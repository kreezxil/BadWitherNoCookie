package com.kreezcraft.badwithernocookiereloaded;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod("bwncr")
public class BadWitherNoCookie {

	private static final String MOD_ID = "bwncr";

	public static Logger logger;

	public static BadWitherNoCookie instance;

	public static boolean whatWasThat = false;
	public static EntityPlayer player;

	public BadWitherNoCookie() {

		DistExecutor.runForDist(() -> () -> new SideProxy.Client(), () -> () -> new SideProxy.Server());

		MinecraftForge.EVENT_BUS.register(this);
		instance = this;
	}

	@Nonnull
	public static String getVersion() {
		Optional<? extends ModContainer> o = ModList.get().getModContainerById(MOD_ID);
		if (o.isPresent()) {
			return o.get().getModInfo().getVersion().toString();
		}
		return "NONE";
	}

	public static boolean isDevBuild() {
		String version = getVersion();
		return "NONE".equals(version);
	}

	@Nonnull
	public static ResourceLocation getId(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
