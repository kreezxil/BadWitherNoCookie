package droidicus.badwithernocookie;

import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Mod(modid = BadWitherNoCookie.MODID)
public class BadWitherNoCookie {
    public static final String MODID = "badwithernocookie";

    // Config instance
    public static Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "badwithernocookie.cfg"));
        Config.readConfig();
    }

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event) {
        // Disable the Wither spawn broadcast sound if it is configed to do so
        if (Config.silenceWither) {
            try {
                Field field = ReflectionHelper.findField(SoundEvents.class, "ENTITY_WITHER_SPAWN", "field_187855_gD");
                field.setAccessible(true);

                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(null, null);

                System.out.println("Silenced Wither sound :-D");
            } catch (NoSuchFieldException e) {
                System.out.println("NoSuchFieldException, Wither sound not silenced :-(");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException, Wither sound not silenced :-(");
                e.printStackTrace();
            }
        }

        // Disable the Ender Dragon death broadcast sound if it is configed to do so
        if (Config.silenceDragon) {
            try {
                Field field = ReflectionHelper.findField(SoundEvents.class, "ENTITY_ENDERDRAGON_DEATH", "field_187522_aL");
                field.setAccessible(true);

                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(null, null);

                System.out.println("Silenced Dragon sound :-D");
            } catch (NoSuchFieldException e) {
                System.out.println("NoSuchFieldException, Dragon sound not silenced :-(");
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException, Dragon sound not silenced :-(");
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

}
