package com.james0z.ibcsmod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import static net.minecraft.world.item.enchantment.Enchantments.FLAME;

public class EchowandItem extends BowItem{
    public EchowandItem(Properties properties){
        super(properties);
    }


    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);

        // Get the Holder reference for the enchantment
        Holder.Reference<Enchantment> powerEnchantment = level.registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(Enchantments.POWER);
        Holder.Reference<Enchantment> flameEnchantment = level.registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(FLAME);
        // Apply the enchantment using the correct Holder
        stack.enchant(powerEnchantment, 5);
        stack.enchant(flameEnchantment,1);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true; // Makes the bow shine like an enchanted item
    }



    @Override
    public boolean useOnRelease(ItemStack stack) {
        return true; // Makes it function like a bow
    }
}
