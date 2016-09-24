package droidicus.badwithernocookie;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by droidicus.
 */
public class Config {

    private static final String CATEGORY_GENERAL = "general";

    // This values below you can access elsewhere in your mod:
    public static boolean silenceWither = true;
    public static boolean silenceDragon = false;

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = BadWitherNoCookie.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            System.out.println("Problem loading config file!");
            e1.printStackTrace();
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        silenceWither = cfg.getBoolean("silenceWither", CATEGORY_GENERAL, silenceWither, "Set to true to silence the server-wide Wither spawn broadcast sound");
        silenceDragon = cfg.getBoolean("silenceDragon", CATEGORY_GENERAL, silenceDragon, "Set to true to silence the server-wide Ender Dragon death broadcast sound");
    }
}
