package com.kreezcraft.badwithernocookiereloaded;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * Originally created by droidicus.
 * Now heavily modifed by Kreezxil
 */
public class SoundEventHandler {
	PlayerEntity player = null;
    // LOWEST Priority so that everything else can do their thing if they need to first
	@SubscribeEvent
	public void player(PlayerEvent.PlayerLoggedInEvent event){
		if(event.getPlayer().hasPermissionLevel(2) || Minecraft.getInstance().isSingleplayer()){
    		player = event.getPlayer();
    	}
	}
	
    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=false)
    public void onEvent(PlaySoundEvent event) {
    	final boolean theSilence = BWNCR_Config.GENERAL.silenceSuccess.get(); 
    	
        // Disable the Wither spawn broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.wither.spawn")) &&
        		BWNCR_Config.GENERAL.silenceWither.get()) {
            if(!theSilence) {
            	System.out.println("WITHER SOUND SILENCED!!!");
            }
            event.setCanceled(true);
        }

        // Disable the Ender Dragon death broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.enderdragon.death")) &&
        		BWNCR_Config.GENERAL.silenceDragon.get()) {
        	if(!theSilence) {
        		System.out.println("ENDER DRAGON SOUND SILENCED!!!");
        	}
        	event.setCanceled(true);
        }
        
        // Disable the Thunderous Lightning broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.lightning.thunder")) &&
        		BWNCR_Config.GENERAL.silenceLightning.get()) {
            if(!theSilence) {
            	System.out.println("THUNDER SILENCED!!!");
            }
            event.setCanceled(true);
        }
        
        if (!Arrays.asList(BWNCR_Config.GENERAL.silenceUs).isEmpty()) {
        	for (String soundName: BWNCR_Config.GENERAL.silenceUs.get()) {
        		if((event.getName().equals(soundName))) {
        			if(!theSilence) {
        				System.out.println(soundName + " Silenced!!!");
        			}
        			event.setCanceled(true);
        		}
        	}
        	
        }
        
        if (BadWitherNoCookie.whatWasThat) {
        	if(player != null) {
        	    player.sendMessage(new StringTextComponent(TextFormatting.AQUA + "Sound is "+TextFormatting.RED + event.getName()));
        	} else {
        		BadWitherNoCookie.LOGGER.info(new StringTextComponent(TextFormatting.AQUA + "Sound is "+TextFormatting.RED + event.getName()));
        	}
        	event.getListenerList();
        }
    }
}
