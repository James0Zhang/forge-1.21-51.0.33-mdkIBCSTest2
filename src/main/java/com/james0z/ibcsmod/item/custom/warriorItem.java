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
import net.minecraft.world.level.Level;

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
    public void equipCustomHelmet(Player player) {
        // Create the helmet item
        ItemStack helmet = new ItemStack(ModItems.Warrior_Crown.get());
        ItemStack chestplate = new ItemStack(ModItems.Warrior_Chestplate.get());
        ItemStack legging = new ItemStack(ModItems.Warrior_Legging.get());
        ItemStack boots = new ItemStack(ModItems.Warrior_Boots.get());

        // Set the helmet in the player's armor slot (slot 3 for helmet)
        player.getInventory().armor.set(3, helmet);
        player.getInventory().armor.set(2, chestplate);
        player.getInventory().armor.set(1, legging);
        player.getInventory().armor.set(0, boots);

        // Notify the player (optional)
        player.displayClientMessage(Component.literal("You are now equipped with the armor!"), true);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();


        if (!level.isClientSide) {

            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 5));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 2));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 2));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 6000, 3));

            if (hasGloryFang(player)) {
                player.getInventory().add(new ItemStack(ModItems.GloryFang.get()));
                player.sendSystemMessage(Component.literal("1"));
            }
            if (player != null) {
                equipCustomHelmet(player);
            }
            player.getCooldowns().addCooldown(this, 700);

        }
        return super.useOn(pContext);
    }
}
