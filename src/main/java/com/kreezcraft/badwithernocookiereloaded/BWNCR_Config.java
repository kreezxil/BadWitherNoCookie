package com.kreezcraft.badwithernocookiereloaded;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Config(modid = BadWitherNoCookie.MODID, category = "")
public class BWNCR_Config {

	@Config.Comment({ "Choose Global Sounds to Silence" })
	@Config.Name("General Settings")
	public static General general = new General();

	public static class General {
		@Config.Comment({ "Set to true to silence the server-wide Wither spawn broadcast sound." })
		@Config.Name("The Wither")
		public boolean silenceWither = true;

		@Config.Comment({ "Set to true to silence the server-wide Ender Dragon Death broadcast sound." })
		@Config.Name("The Dragon")
		public boolean silenceDragon = true;

		@Config.Comment({ "Set to true to silence the server-wide Thunder caused by Lightning broadcast sound." })
		@Config.Name("The Lightning")
		public boolean silenceLightning = true;

		@Config.Comment({
				"Set to true to silence the server messages for when any of these sounds have been silenced." })
		@Config.Name("The Console on Success")
		public boolean silenceSuccess = true;
	}

	@Config.Comment({ "Yes, you can silence other sounds too!" })
	@Config.Name("Localized Settings")
	public static Xtra xtra = new Xtra();

	public static class Xtra {
		@Config.Comment({ "A list of sounds to silence, discoverable with the toggle command /listen ",
				"enter one sound event per line with no commas." })
		public String[] silenceUs = new String[0];
	}

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(BadWitherNoCookie.MODID)) {
			ConfigManager.sync(BadWitherNoCookie.MODID, Config.Type.INSTANCE);
		}
	}
}
