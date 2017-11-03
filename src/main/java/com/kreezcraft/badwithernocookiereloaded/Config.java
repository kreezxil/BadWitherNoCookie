package com.kreezcraft.badwithernocookiereloaded;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by droidicus.
 */
public class Config {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_EXTRA = "extra sounds to silence";

    // This values below you can access elsewhere in your mod:
    public static boolean silenceWither = true;
    public static boolean silenceDragon = true;
    public static boolean silenceLightning = true;
    public static boolean silenceSuccess = true;
    public static String[] silenceUs;

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
        silenceWither = cfg.getBoolean("silenceWither", CATEGORY_GENERAL, silenceWither, "Set to true to silence the server-wide Wither spawn broadcast sound.");
        silenceDragon = cfg.getBoolean("silenceDragon", CATEGORY_GENERAL, silenceDragon, "Set to true to silence the server-wide Ender Dragon death broadcast sound.");
        silenceLightning = cfg.getBoolean("silenceLightning", CATEGORY_GENERAL, silenceLightning, "Set to true to silence the server-wide Thunder caused by Lightning broadcast sound.");
        silenceSuccess = cfg.getBoolean("silenceSuccess", CATEGORY_GENERAL, silenceSuccess, "Set to true to silence the server messages for when any of these sounds have been silenced.");
        cfg.addCustomCategoryComment(CATEGORY_EXTRA, "The sounds of silence");
        silenceUs = cfg.getStringList("silenceUs", CATEGORY_EXTRA, new String[] {""}, "A list of sounds to silence, discoverable with the toggle command /listen\nenter one sound event per line with no commas");
    }
}
