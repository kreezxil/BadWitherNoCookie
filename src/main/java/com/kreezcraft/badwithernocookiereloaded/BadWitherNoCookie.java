package com.kreezcraft.badwithernocookiereloaded;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bwncr")
public class BadWitherNoCookie {

	public static final Logger LOGGER = LogManager.getLogger();

	public static BadWitherNoCookie instance;

	public static  boolean whatWasThat = false;
	public static PlayerEntity player;
		
	public BadWitherNoCookie() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BWNCR_Config.spec);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(BadWitherNoCookie::clientSetup);
		
		MinecraftForge.EVENT_BUS.register(this);
		instance = this;
	}

	private static void clientSetup(FMLClientSetupEvent event) {
    }
	
	@SubscribeEvent
	public void commands(RegisterCommandsEvent event) {
		ListenCommand.register(event.getDispatcher());
	}

}
