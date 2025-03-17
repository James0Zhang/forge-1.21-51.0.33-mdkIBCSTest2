package com.james0z.ibcsmod.item;

import com.james0z.ibcsmod.IBCSMod;
import com.james0z.ibcsmod.item.custom.GloryfangItem;
import com.james0z.ibcsmod.item.custom.warriorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.SwordItem.createAttributes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IBCSMod.MOD_ID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> warrior = ITEMS.register("warrior",
            ()-> new warriorItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> Ranger = ITEMS.register("ranger",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GloryFang = ITEMS.register("gloryfang",
            () -> new GloryfangItem( new Item.Properties()
            .attributes(SwordItem.createAttributes(ModTier.Warrior, 9, -2.8F))));


}
