package com.james0z.ibcsmod.events;

import com.james0z.ibcsmod.client.ModKeyBinding;
import com.james0z.ibcsmod.item.ModItems;
import com.james0z.ibcsmod.item.custom.EchowandItem;
import com.james0z.ibcsmod.item.custom.GloryfangItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SummonGolemHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null && ModKeyBinding.DASH_KEY.isDown()) {
        // Check if the player is holding the custom item
        if (player.getMainHandItem().getItem() == ModItems.EchoWand.get()) {
            // Calculate dash direction
            Vec3 look = player.getLookAngle();
            Vec3 dashVec = look.scale(2.0); // Adjust dash distance

            // Apply motion to the player
            player.push(dashVec.x, dashVec.y, dashVec.z);

        }
    }
}
}

