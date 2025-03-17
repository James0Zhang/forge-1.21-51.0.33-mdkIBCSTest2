package com.james0z.ibcsmod.item.custom;

import com.james0z.ibcsmod.IBCSMod;
import com.james0z.ibcsmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.conditions.TrueCondition;
import org.apache.commons.lang3.ObjectUtils;

public class warriorItem extends Item {
    public warriorItem(Properties pProperties) {

        super(pProperties);
    }
    private boolean hasGloryFang(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() == ModItems.GloryFang.get()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();


        if (!level.isClientSide) {
            // Apply a strength effect to the player for 30 seconds (600 ticks)
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 5));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 5));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 2));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000, 3));

            if (hasGloryFang(player)) {
                player.getInventory().add(new ItemStack(ModItems.GloryFang.get()));
                player.sendSystemMessage(Component.literal("1"));
            }
            player.getCooldowns().addCooldown(this, 700);

        }
        return super.useOn(pContext);
    }
}
