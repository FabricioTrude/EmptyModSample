package net.lirue.myfirstmod.datagen;

import net.lirue.myfirstmod.MyFirstMod;
import net.lirue.myfirstmod.block.ModBlocks;
import net.lirue.myfirstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MyFirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(Tags.Blocks.ORES)
                .addTag(ModTags.Blocks.FORGE_SAPPHIRE_ORES);
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_SAPPHIRE)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_RAW_SAPPHIRE);

        this.tag(ModTags.Blocks.STORAGE_BLOCKS_SAPPHIRE)
                .add(ModBlocks.SAPPHIRE_BLOCK.get());
        this.tag(ModTags.Blocks.STORAGE_BLOCKS_RAW_SAPPHIRE)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.tag(ModTags.Blocks.FORGE_SAPPHIRE_ORES)
                .addTag(ModTags.Blocks.SAPPHIRE_ORES);
        this.tag(ModTags.Blocks.SAPPHIRE_ORES)
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.SANDSTONE_SAPPHIRE_ORE.get())
                .add(ModBlocks.TUFF_SAPPHIRE_ORE.get())
                .add(ModBlocks.ANDESITE_SAPPHIRE_ORE.get())
                .add(ModBlocks.GRANITE_SAPPHIRE_ORE.get())
                .add(ModBlocks.DIORITE_SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                .add(ModBlocks.END_SAPPHIRE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(ModTags.Blocks.FORGE_SAPPHIRE_ORES)
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_SLAB.get()).add(ModBlocks.SAPPHIRE_TRAPDOOR.get()).add(ModBlocks.SAPPHIRE_STAIRS.get())
                .add(ModBlocks.SAPPHIRE_DOOR.get()).add(ModBlocks.SAPPHIRE_BUTTON.get()).add(ModBlocks.SAPPHIRE_FENCE.get())
                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get()).add(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()).add(ModBlocks.SAPPHIRE_WALL.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE.get()).add(ModBlocks.SANDSTONE_SAPPHIRE_ORE.get()).add(ModBlocks.TUFF_SAPPHIRE_ORE.get())
                .add(ModBlocks.ANDESITE_SAPPHIRE_ORE.get()).add(ModBlocks.GRANITE_SAPPHIRE_ORE.get()).add(ModBlocks.DIORITE_SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get()).add(ModBlocks.NETHER_SAPPHIRE_ORE.get()).add(ModBlocks.END_SAPPHIRE_ORE.get())
                .add(ModBlocks.SAPPHIRE_SLAB.get()).add(ModBlocks.SAPPHIRE_TRAPDOOR.get()).add(ModBlocks.SAPPHIRE_STAIRS.get())
                .add(ModBlocks.SAPPHIRE_DOOR.get()).add(ModBlocks.SAPPHIRE_BUTTON.get()).add(ModBlocks.SAPPHIRE_FENCE.get())
                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get()).add(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()).add(ModBlocks.SAPPHIRE_WALL.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
        this.tag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL).add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.SAPPHIRE_SLAB.get());
        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.SAPPHIRE_STAIRS.get());
        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.SAPPHIRE_BUTTON.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SAPPHIRE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SAPPHIRE_WALL.get());
        this.tag(BlockTags.DOORS)
                .add(ModBlocks.SAPPHIRE_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.SAPPHIRE_TRAPDOOR.get());
    }
}
