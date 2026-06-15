package net.sadvistan.sadvistan.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.sadvistan.sadvistan.Sadvistan;
import org.lwjgl.glfw.GLFW;

public class SadvistanClient implements ClientModInitializer {
    private static KeyMapping playMusicKey;
    private static SimpleSoundInstance currentSoundInstance = null;

    @Override
    public void onInitializeClient() {
        playMusicKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.sadvistan.play",
                GLFW.GLFW_KEY_H,
                "category.sadvistan.mod"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (playMusicKey.consumeClick()) {
                if (client.player != null && client.level != null) {

                    if (currentSoundInstance != null && client.getSoundManager().isActive(currentSoundInstance)) {

                        client.getSoundManager().stop(currentSoundInstance);
                        currentSoundInstance = null;

                    } else {

                        currentSoundInstance = SimpleSoundInstance.forUI(Sadvistan.MY_MUSIC_EVENT, 1.0F, 1.0F);
                        client.getSoundManager().play(currentSoundInstance);
                    }
                }
            }
        });
    }
}
