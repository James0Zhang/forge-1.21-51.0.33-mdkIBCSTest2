package com.james0z.ibcsmod.item;
import com.electronwill.nightconfig.core.NullObject;
import net.minecraft.tags.BlockTags;
import com.james0z.ibcsmod.IBCSMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import org.apache.commons.lang3.ObjectUtils;

public class ModTier {
    public static final Tier Warrior = new ForgeTier(1400,2,2.4F,20, BlockTags.MINEABLE_WITH_AXE, ()->Ingredient.of(Items.NETHERITE_INGOT), BlockTags.ANVIL);}