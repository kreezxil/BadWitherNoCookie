package droidicus.badwithernocookie;

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
        // Disable the Wither spawn broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.wither.spawn")) &&
                Config.silenceWither) {
            System.out.println("WITHER SOUND SILENCED!!!");
            event.setResultSound(null);
        }

        // Disable the Ender Dragon death broadcast sound if it is configed to do so
        if ((event.getName().equals("entity.enderdragon.death")) &&
                Config.silenceDragon) {
            System.out.println("ENDER DRAGON SOUND SILENCED!!!");
            event.setResultSound(null);
        }
    }
}
