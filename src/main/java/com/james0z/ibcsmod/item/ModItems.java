package com.james0z.ibcsmod.item;

import com.james0z.ibcsmod.IBCSMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IBCSMod.MOD_ID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> warrior = ITEMS.register("warrior",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Ranger = ITEMS.register("ranger",
            ()-> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> Gloryfang = ITEMS.register("ranger",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Emberweaver = ITEMS.register("ranger",
            ()-> new Item(new Item.Properties()));

}
