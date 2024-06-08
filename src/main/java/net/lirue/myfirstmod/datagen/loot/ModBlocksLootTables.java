package net.lirue.myfirstmod.datagen.loot;

import net.lirue.myfirstmod.block.ModBlocks;
import net.lirue.myfirstmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlocksLootTables extends BlockLootSubProvider {
    public ModBlocksLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.BORDERLESS_LAMP.get());
        this.dropSelf(ModBlocks.COLORED_LAMP.get());
        this.dropSelf(ModBlocks.SMOOTH_LAMP .get());
        this.dropSelf(ModBlocks.CONDUCTOR .get());

        this.dropSelf(ModBlocks.SAPPHIRE_STAIRS.get());
        this.dropSelf(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_WALL.get());
        this.dropSelf(ModBlocks.SAPPHIRE_TRAPDOOR.get());

        this.add(ModBlocks.SAPPHIRE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SAPPHIRE_SLAB.get()));
        this.add(ModBlocks.SAPPHIRE_DOOR.get(),
                block -> createDoorTable(ModBlocks.SAPPHIRE_DOOR.get()));


        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.SANDSTONE_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.SANDSTONE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.TUFF_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.TUFF_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.ANDESITE_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.ANDESITE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.GRANITE_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.GRANITE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.DIORITE_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.DIORITE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
        this.add(ModBlocks.END_SAPPHIRE_ORE.get(),
                block -> createLikeOreDrops(ModBlocks.END_SAPPHIRE_ORE.get(),ModItems.RAW_SAPPHIRE.get(),1F,6F));
    }

    protected LootTable.Builder createLikeOreDrops(Block pBlock, Item item, float pMin, float pMax) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                    LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(pMin, pMax)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
