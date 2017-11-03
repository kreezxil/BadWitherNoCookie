package com.kreezcraft.badwithernocookiereloaded;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by droidicus.
 */
public class SoundEventHandler {
    // LOWEST Priority so that everything else can do their thing if they need to first
    @SubscribeEvent(priority= EventPriority.LOWEST, receiveCanceled=false)
    public void onEvent(PlaySoundEvent event) {
    	
    	final boolean theSilence = Config.silenceSuccess;
    	
        // Disable the Wither spawn broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.wither.spawn")) &&
                Config.silenceWither) {
            if(!theSilence) {
            	System.out.println("WITHER SOUND SILENCED!!!");
            }
            event.setResultSound(null);
        }

        // Disable the Ender Dragon death broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.enderdragon.death")) &&
                Config.silenceDragon) {
        	if(!theSilence) {
        		System.out.println("ENDER DRAGON SOUND SILENCED!!!");
        	}
            event.setResultSound(null);
        }
        
        // Disable the Thunderous Lightning broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.lightning.thunder")) &&
                Config.silenceLightning) {
            if(!theSilence) {
            	System.out.println("THUNDER SILENCED!!!");
            }
            event.setResultSound(null);
        }
        
        if (Config.silenceUs != null) {
        	for (String s: Config.silenceUs) {
        		if((event.getName().equals(s))) {
        			if(!theSilence) {
        				System.out.println(s + " Silenced!!!");
        			}
        			event.setResultSound(null);
        		}
        	}
        	
        }
        
        if (BadWitherNoCookie.whatWasThat) {
        	if(BadWitherNoCookie.player == null) {
        		System.out.println("Sound is "+event.getName());
        	} else {
        	    BadWitherNoCookie.player.sendMessage(new TextComponentString(TextFormatting.AQUA + "Sound is "+TextFormatting.RED + event.getName()));
        	}
        	event.getListenerList();
        }
    }
}
