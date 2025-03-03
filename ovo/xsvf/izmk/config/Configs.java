package ovo.xsvf.izmk.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "izmk")
public class Configs implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public Watermark watermark = new Watermark();

    public static class Watermark {
        public boolean enabled = true;
        public String text = "IZMK";
        @ConfigEntry.ColorPicker(allowAlpha = true)
        public int color = 0xFFFFFFFF;
        public int x = 0;
        public int y = 0;

        @ConfigEntry.BoundedDiscrete(min = 1, max = 5)
        public int scale = 1;
    }

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public OldAnimations old_animations = new OldAnimations();

    public static class OldAnimations {
        public boolean swing_anim = false;
        public boolean old_camera_view = false;
        public boolean third_person_crosshair = false;
        public boolean third_person_name = false;
        public boolean shift_anim = false;
        public boolean sword_blocking = false;
    }

    @ConfigEntry.Gui.Tooltip
    public boolean no_hurt_cam = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public CustomHeldItem custom_held_item = new CustomHeldItem();

    public static class CustomHeldItem {
        public float x_offset = 0;
        public float y_offset = 0;
        public float z_offset = 0;

        public float x_rot = 0;
        public float y_rot = 0;
        public float z_rot = 0;
    }

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public Hitboxes hitboxes = new Hitboxes();

    public static class Hitboxes {
        public boolean enabled = false;

        @ConfigEntry.BoundedDiscrete(min = 1, max = 128)
        public int alpha = 1;
    }

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public HitColor hit_color = new HitColor();

    public static class HitColor {
        public boolean enabled = false;

        @ConfigEntry.ColorPicker(allowAlpha = true)
        public int color = 0xFFFFFF;
    }

    @ConfigEntry.Gui.Tooltip
    public boolean item_physics = false;

    @ConfigEntry.Gui.Tooltip
    public boolean minimal_bobbing = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public MotionBlur motion_blur = new MotionBlur();

    public static class MotionBlur {
        public boolean enabled = false;

        public float strength = 0.6f;
    }

    @ConfigEntry.Gui.Tooltip
    public boolean nick_hider = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public NoParticles no_particles = new NoParticles();

    public static class NoParticles {
        public boolean self_effect = false;
        public boolean block_break = false;
    }

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public PotionStatus potion_status = new PotionStatus();

    public static class PotionStatus {
        public boolean enabled = false;

        public int renderX = 0;
        public int renderY = 0;
    }

    @ConfigEntry.Gui.Tooltip
    public boolean real_health = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public ChatHider chat_hider = new ChatHider();

    public static class ChatHider {
        public boolean shouts = false;
    }

    @ConfigEntry.Gui.Tooltip
    public boolean chat_copy = false;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public Scoreboard scoreboard = new Scoreboard();

    public static class Scoreboard {
        public boolean show = true;
        public boolean show_red_numbers = true;
        public float background_opacity = 1.0f;
        public float scale = 1.0f;
        public int xOffset = 0;
        public int yOffset = 0;
    }

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.Gui.CollapsibleObject
    public ItemScale item_scale = new ItemScale();
    public static class ItemScale {
        public boolean self = true;

        @ConfigEntry.Gui.PrefixText
        public float kb_ball = 1.0f; // 击退球
        public float kb_ball_x_rotation = 0.0f;
        public float kb_ball_y_rotation = 0.0f;
        public float kb_ball_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float instant_kill_axe = 1.0f; // 瞬间击杀斧
        public float instant_kill_axe_x_rotation = 0.0f;
        public float instant_kill_axe_y_rotation = 0.0f;
        public float instant_kill_axe_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float totem = 1.0f; // 图腾
        public float totem_x_rotation = 0.0f;
        public float totem_y_rotation = 0.0f;
        public float totem_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float enchanted_golden_apple = 1.0f; // 附魔金苹果
        public float enchanted_golden_apple_x_rotation = 0.0f;
        public float enchanted_golden_apple_y_rotation = 0.0f;
        public float enchanted_golden_apple_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float power_v_bow = 1.0f; // 力量5倍弓
        public float power_v_bow_x_rotation = 0.0f;
        public float power_v_bow_y_rotation = 0.0f;
        public float power_v_bow_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float punch_iii_bow = 1.0f; // 击杀3倍弓
        public float punch_iii_bow_x_rotation = 0.0f;
        public float punch_iii_bow_y_rotation = 0.0f;
        public float punch_iii_bow_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float flame_bow = 1.0f; // 火焰弓
        public float flame_bow_x_rotation = 0.0f;
        public float flame_bow_y_rotation = 0.0f;
        public float flame_bow_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float end_crystal = 1.0f; // 末影水晶
        public float end_crystal_x_rotation = 0.0f;
        public float end_crystal_y_rotation = 0.0f;
        public float end_crystal_z_rotation = 0.0f;

        @ConfigEntry.Gui.PrefixText
        public float sharp_viii = 1.0f; // 锋利8
        public float sharp_viii_x_rotation = 0.0f;
        public float sharp_viii_y_rotation = 0.0f;
        public float sharp_viii_z_rotation = 0.0f;
    }

}
