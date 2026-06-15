package net.sadvistan.sadvistan.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.sounds.SoundSource;
import net.sadvistan.sadvistan.Sadvistan;
import org.lwjgl.glfw.GLFW;

public class SadvistanClient implements ClientModInitializer {
    private static KeyMapping playMusicKey;

    @Override
    public void onInitializeClient() {

        playMusicKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.sadvistan.play_music",
                GLFW.GLFW_KEY_H,
                "category.sadvistan.mod"
        ));


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (playMusicKey.consumeClick()) {
                if (client.player != null && client.level != null) {
                    client.level.playSound(
                            client.player,
                            client.player.getX(), client.player.getY(), client.player.getZ(),
                            Sadvistan.MY_MUSIC_EVENT,
                            SoundSource.MUSIC,
                            1.0F,
                            1.0F
                    );
                }
            }
        });
    }
}
