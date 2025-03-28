package com.james0z.ibcsmod.entity;

import com.james0z.ibcsmod.IBCSMod;
import com.james0z.ibcsmod.entity.projectile.CustomArrow;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, IBCSMod.MOD_ID);

    public static final RegistryObject<EntityType<CustomArrow>> CUSTOM_ARROW =
            ENTITIES.register("custom_arrow",
                    () -> EntityType.Builder.<CustomArrow>of((entityType, level) -> new CustomArrow(entityType, level), MobCategory.MISC)
                            .sized(0.5F, 0.5F) // Arrow size
                            .build("custom_arrow"));}

