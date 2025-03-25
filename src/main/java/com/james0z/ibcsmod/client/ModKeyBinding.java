package com.james0z.ibcsmod.client;

import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModKeyBinding {
    public static final KeyMapping DASH_KEY = new KeyMapping(
            "key.ibcsmod.dash",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R, // Change this key if needed
            "key.categories.ibcsmod"
    );

    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
        event.register(DASH_KEY);
    }
}
