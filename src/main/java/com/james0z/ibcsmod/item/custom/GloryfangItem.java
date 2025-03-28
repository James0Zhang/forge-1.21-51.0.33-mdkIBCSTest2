package com.james0z.ibcsmod.item.custom;

import com.james0z.ibcsmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import static com.james0z.ibcsmod.item.ModItems.ITEMS;

public class GloryfangItem extends Item{

    public GloryfangItem(Properties pProperties) {

        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        //get level and player

        if (!level.isClientSide) {
            // Apply a strength effect to the player and get a cooldown
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 5));

            player.sendSystemMessage(Component.literal("You feel a surge of power!"));
            player.getCooldowns().addCooldown(this, 200);

        }
        return super.useOn(pContext);
    }
    

}
