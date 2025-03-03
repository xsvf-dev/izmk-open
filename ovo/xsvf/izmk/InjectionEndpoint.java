package ovo.xsvf.izmk;

import com.heypixel.heypixel.HeyPixel;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.jetbrains.annotations.NotNull;
import ovo.xsvf.irc.IRCClient;
import ovo.xsvf.izmk.config.Configs;
import ovo.xsvf.izmk.config.annotation.ConfigSaveCallback;
import ovo.xsvf.izmk.event.EventBus;
import ovo.xsvf.izmk.event.annotation.AutoRegister;
import ovo.xsvf.izmk.injection.mixinlib.MixinLoader;
import ovo.xsvf.izmk.misc.LogDumper;
import ovo.xsvf.izmk.misc.ProtocolUtil;
import ovo.xsvf.izmk.misc.util.ClassUtil;
import ovo.xsvf.logging.Logger;
import ovo.xsvf.mapping.Mapping;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class InjectionEndpoint {
    public static void onLoad(@NotNull Instrumentation inst, int port, byte @NotNull [] mapping, String pid, boolean debug, String jarPath, Set<String> packages, boolean dev) throws Exception {
        IZMK.mapping = new Mapping(mapping);
        IZMK.LOG_PORT = port;
        IZMK.inst = inst;
        IZMK.logger = new Logger(IZMK.LOG_PORT, "IZMK", IZMK.DEBUG);
        IZMK.pid = pid;
        IZMK.DEBUG = debug;
        IZMK.DEV = dev;
        IZMK.jarPath = jarPath;
        IZMK.config = AutoConfig.register(Configs.class, Toml4jConfigSerializer::new);
        IZMK.configScreen = (screen -> AutoConfig.getConfigScreenProvider(Configs.class, screen)
                .getBuilder()
                .setSavingRunnable(IZMK::saveAll)
                .setTransparentBackground(true)
                .build());

        IZMK.logger.debug("IZMK 正在加载。");
        ClassUtil.init(inst);

        IZMK.checkHeypixel((result) -> IZMK.HEYPIXEL = result);
        if (IZMK.HEYPIXEL && HeyPixel.getInstance() != null) {
            IZMK.logger.error("请在游戏开始前加载IZMK。");
            throw new RuntimeException("请在游戏开始前加载IZMK。");
        }
        if (IZMK.HEYPIXEL) {
            ProtocolUtil.injectHeypixel();
            ProtocolUtil.checkMod();
            ProtocolUtil.init(packages);
        }

        IZMK.registerLogAppender();

        IZMK.logger.debug("start registering classes");
        IZMK.registerClasses(inst);
        IZMK.logger.debug("start loading mixins");
        MixinLoader.loadMixins(inst.getAllLoadedClasses());
        IZMK.logger.debug("finished loading mixins");

        IZMK.logger.info("IZMK 已加载。");
    }
}
