package droidicus.badwithernocookie;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = BadWitherNoCookie.MODID, version = BadWitherNoCookie.VERSION)
public class BadWitherNoCookie  {
    public static final String MODID = "badwithernocookie";
    public static final String VERSION = "0.0.1";
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event) {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());

        //do things
        try {
            Field field = SoundEvents.class.getField("ENTITY_WITHER_SPAWN");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, null);
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException, Wither sound not silenced :-(");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException, Wither sound not silenced :-(");
            e.printStackTrace();
        }

        try {
            Field field = SoundEvents.class.getField("ENTITY_ENDERDRAGON_DEATH");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, null);
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException, Dragon sound not silenced :-(");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException, Dragon sound not silenced :-(");
            e.printStackTrace();
        }

    }
}
