package com.james0z.ibcsmod.item.custom;

import com.james0z.ibcsmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class RangerItem extends Item {
    public RangerItem(Properties pProperties) {

        super(pProperties);
    }
    private boolean hasEchowand(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() == ModItems.EchoWand.get()) {
                return false;
            }
        }
        return true;
    }
    // Check if the player has Echowand in inventory

    public void equipCustomHelmet(Player player) {
        // Create the helmet item
        ItemStack helmet = new ItemStack(ModItems.Ranger_Hat.get());
        ItemStack chestplate = new ItemStack(ModItems.Ranger_Shirt.get());
        ItemStack legging = new ItemStack(ModItems.Ranger_Legging.get());
        ItemStack boots = new ItemStack(ModItems.Ranger_Boots.get());

        // Set the helmet in the player's armor slot (slot 3 for helmet)
        player.getInventory().armor.set(3, helmet);
        player.getInventory().armor.set(2, chestplate);
        player.getInventory().armor.set(1, legging);
        player.getInventory().armor.set(0, boots);

    }
    // give and equip player armor
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();



        if (!level.isClientSide) {

            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 2));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 2));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 2));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000, 3));

            if (hasEchowand(player)) {
                player.getInventory().add(new ItemStack(ModItems.EchoWand.get()));

            }
            if (player != null) {
                equipCustomHelmet(player);
            }
            player.getCooldowns().addCooldown(this, 700);

        }
        return super.useOn(pContext);
        //give player buffs and Echowand
    }
}
