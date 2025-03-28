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
            GLFW.GLFW_KEY_R, 
            "key.categories.ibcsmod"
    );
    //bind DASH_KEY to key r

    public static final String CATEGORY_MOD = "key.categories.ibcsmod";
    public static final KeyMapping SUMMON_GOLEM_KEY = new KeyMapping(
            "key.ibcsmod.summon_golem",
            GLFW.GLFW_KEY_G, // Change to "G" key
            CATEGORY_MOD
    );



    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
        event.register(DASH_KEY);
        event.register(SUMMON_GOLEM_KEY);
    }
    //register DASH_KEY
}
