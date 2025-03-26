package com.james0z.ibcsmod.item.custom;

import com.james0z.ibcsmod.entity.ModEntities;
import com.james0z.ibcsmod.entity.projectile.CustomArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

public class EchowandItem extends BowItem{
    public EchowandItem(Properties properties){
        super(properties);
    }


    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity shooter, int chargeTime) {
        if (!(shooter instanceof Player player)) return;

        boolean infiniteArrows = player.getAbilities().instabuild || player.getInventory().contains(Items.ARROW.getDefaultInstance());

        if (!level.isClientSide()) {
            CustomArrow arrow = new CustomArrow(ModEntities.CUSTOM_ARROW.get(), level);

            // Set the arrow spawn position (player's eye level)
            arrow.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());

            // Calculate charge time to determine arrow strength
            float power = BowItem.getPowerForTime(chargeTime);
            arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, power * 3.0F, 1.0F);

            // Apply effects to the arrow if needed
            arrow.setBaseDamage(5.0D);
            arrow.setTicksFrozen(3);
            arrow.setRemainingFireTicks(3);// Set on fire for 3 seconds

            // Spawn the arrow in the world
            level.addFreshEntity(arrow);

            // Consume an arrow if the player is not in creative mode
            if (!infiniteArrows) {
                player.getInventory().removeItem(Items.ARROW.getDefaultInstance());
            }
        }
    }
}
