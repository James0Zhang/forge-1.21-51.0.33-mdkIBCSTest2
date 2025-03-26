package com.james0z.ibcsmod.entity.projectile;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.EntityHitResult;

public class CustomArrow extends AbstractArrow {

    public CustomArrow(EntityType<? extends CustomArrow> entityType, Level level) {
        super(entityType, level);
    }
    public CustomArrow(EntityType<? extends AbstractArrow> entityType, LivingEntity shooter, Level level) {
        super(entityType, level);}

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.ARROW); // Pickup as a normal arrow
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (result.getEntity() instanceof LivingEntity target) {
            // Apply Fire Effect
            //target.setSecondsOnFire(5); // Burns for 5 seconds

            // Apply Slowness Effect
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1)); // 5 sec Slowness II
        }
    }
}
