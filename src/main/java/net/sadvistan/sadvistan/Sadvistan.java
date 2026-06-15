package net.sadvistan.sadvistan;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sadvistan implements ModInitializer {
    public static final String MOD_ID = "sadvistan";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Создаем объект звука
    public static final ResourceLocation MUSIC_ID = new ResourceLocation(MOD_ID, "song1");
    public static final SoundEvent MY_MUSIC_EVENT = SoundEvent.createVariableRangeEvent(MUSIC_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Sadvistan Mod");

        // Регистрируем звук в игре
        Registry.register(BuiltInRegistries.SOUND_EVENT, MUSIC_ID, MY_MUSIC_EVENT);
    }
}
