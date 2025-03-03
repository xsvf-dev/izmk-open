package ovo.xsvf.izmk.misc;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.ConfigSerializer;
import me.shedaniel.autoconfig.util.Utils;
import me.shedaniel.cloth.clothconfig.shadowed.com.moandjiezana.toml.Toml;
import me.shedaniel.cloth.clothconfig.shadowed.com.moandjiezana.toml.TomlWriter;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class Toml4jIZMKConfigSerializer<T extends ConfigData> implements ConfigSerializer<T> {
    private Config definition;
    private Class<T> configClass;
    private TomlWriter tomlWriter;

    public Toml4jIZMKConfigSerializer(Config definition, Class<T> configClass, TomlWriter tomlWriter) {
        this.definition = definition;
        this.configClass = configClass;
        this.tomlWriter = tomlWriter;
    }

    public Toml4jIZMKConfigSerializer(Config definition, Class<T> configClass) {
        this(definition, configClass, new TomlWriter());
    }

    private Path getConfigPath() {
        return FMLPaths.GAMEDIR.get().resolve("izmk").resolve(this.definition.name() + ".toml");
    }

    public void serialize(T config) throws ConfigSerializer.SerializationException {
        Path configPath = this.getConfigPath();

        try {
            Files.createDirectories(configPath.getParent());
            this.tomlWriter.write(config, configPath.toFile());
        } catch (IOException e) {
            throw new ConfigSerializer.SerializationException(e);
        }
    }

    public T deserialize() throws ConfigSerializer.SerializationException {
        Path configPath = this.getConfigPath();
        if (Files.exists(configPath, new LinkOption[0])) {
            try {
                return (T)((new Toml()).read(configPath.toFile()).to(this.configClass));
            } catch (IllegalStateException e) {
                throw new ConfigSerializer.SerializationException(e);
            }
        } else {
            return (T)this.createDefault();
        }
    }

    public T createDefault() {
        return (T)(Utils.constructUnsafely(this.configClass));
    }
}