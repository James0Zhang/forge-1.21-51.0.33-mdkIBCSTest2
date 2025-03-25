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
    public static final RegistryObject<Item> GloryFang = ITEMS.register("gloryfang",
            () -> new GloryfangItem( new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTier.Warrior, 9, -2.8F))));

    public static final RegistryObject<Item> Ranger = ITEMS.register("ranger",
            ()-> new Item(new Item.Properties()));


    public static final RegistryObject<Item> Warrior_Crown = ITEMS.register("warrior_crown",
            ()-> new ArmorItem(ModArmor.WARRIOR_MATERIAL,ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> Warrior_Chestplate = ITEMS.register("warrior_chestplate",
            ()-> new ArmorItem(ModArmor.WARRIOR_MATERIAL,ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> Warrior_Legging = ITEMS.register("warrior_legging",
            ()-> new ArmorItem(ModArmor.WARRIOR_MATERIAL,ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> Warrior_Boots = ITEMS.register("warrior_boots",
            ()-> new ArmorItem(ModArmor.WARRIOR_MATERIAL,ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));


}
