package com.james0z.ibcsmod.events;

import com.james0z.ibcsmod.client.ModKeyBinding;
import com.james0z.ibcsmod.item.ModItems;
import com.james0z.ibcsmod.item.custom.GloryfangItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DashHandler {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;


        if (player != null && ModKeyBinding.DASH_KEY.isDown()) {
            if (player.getMainHandItem().getItem() instanceof GloryfangItem) {
                Vec3 look = player.getLookAngle();
                Vec3 dashVec = look.scale(1.5); // Adjust the dash distance

                ItemStack heldItem = player.getMainHandItem();
                if (heldItem.getItem() == ModItems.GloryFang.get()) {
                    // Check if cooldown is over
                    if (!player.getCooldowns().isOnCooldown(heldItem.getItem())) {
                        player.getCooldowns().addCooldown(heldItem.getItem(), 60); // 5 seconds cooldown
                        player.sendSystemMessage(Component.literal("Dash"));

                    } else {
                        player.sendSystemMessage(Component.literal("1"));
                    }
                    player.push(dashVec.x, dashVec.y, dashVec.z);
                    player.level().playSound(null, player.blockPosition(),
                            net.minecraft.sounds.SoundEvents.ENDER_PEARL_THROW,
                            net.minecraft.sounds.SoundSource.PLAYERS, 1.0F, 1.0F);

                }


            }
        }
    }
}
