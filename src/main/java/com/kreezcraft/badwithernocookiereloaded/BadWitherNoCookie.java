package com.kreezcraft.badwithernocookiereloaded;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

@Mod(modid = BadWitherNoCookie.MODID, name = BadWitherNoCookie.NAME, version = BadWitherNoCookie.VERSION)
public class BadWitherNoCookie {
    public static final String MODID = "badwithernocookiereloaded";
    public static final String NAME = "Bad Wither No Cookie! Reloaded";
    public static final String VERSION = "1.11.2-1.9";
    
    // Config instance
    public static Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        // read from config file
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "badwithernocookie.cfg"));
        Config.readConfig();
    }

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event) {
        // Register event handler to do the real work
        MinecraftForge.EVENT_BUS.register(new SoundEventHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        // save config if it has changed
        if (config.hasChanged()) {
            config.save();
        }
    }

}
