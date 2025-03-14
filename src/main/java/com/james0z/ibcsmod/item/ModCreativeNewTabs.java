package com.james0z.ibcsmod.item;

import com.james0z.ibcsmod.IBCSMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import javax.management.monitor.CounterMonitor;

public class ModCreativeNewTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IBCSMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHARACTER_MOD_TAB = CREATIVE_MODE_TABS.register("character",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.warrior.get()))
                    .title(Component.translatable("creativetab.ibcsmod.character_mod"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Ranger.get());
                        pOutput.accept(ModItems.GloryFang.get());
                        pOutput.accept(ModItems.warrior.get());
                    })

                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
