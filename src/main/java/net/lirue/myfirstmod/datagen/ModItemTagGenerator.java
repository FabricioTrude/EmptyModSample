package net.lirue.myfirstmod.datagen;

import net.lirue.myfirstmod.MyFirstMod;
import net.lirue.myfirstmod.item.ModItems;
import net.lirue.myfirstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MyFirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(Tags.Items.GEMS).addTag(ModTags.Items.GEMS_SAPPHIRE);
        this.tag(ModTags.Items.GEMS_SAPPHIRE).add(ModItems.SAPPHIRE.get());
        this.tag(Tags.Items.DUSTS).addTag(ModTags.Items.DUSTS_SAPPHIRE);
        this.tag(ModTags.Items.DUSTS_SAPPHIRE).add(ModItems.SAPPHIRE_DUST.get());
        this.tag(Tags.Items.RAW_MATERIALS).addTag(ModTags.Items.RAW_SAPPHIRE);
        this.tag(ModTags.Items.RAW_SAPPHIRE).add(ModItems.RAW_SAPPHIRE.get());

        copy(ModTags.Blocks.STORAGE_BLOCKS_SAPPHIRE,ModTags.Items.STORAGE_BLOCKS_SAPPHIRE);
        copy(ModTags.Blocks.STORAGE_BLOCKS_RAW_SAPPHIRE,ModTags.Items.STORAGE_BLOCKS_RAW_SAPPHIRE);

        this.tag(ItemTags.BEACON_PAYMENT_ITEMS).add(ModItems.SAPPHIRE.get());
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(ModItems.SAPPHIRE_HELMET.get(),ModItems.SAPPHIRE_CHESTPLATE.get(),ModItems.SAPPHIRE_LEGGINGS.get(),ModItems.SAPPHIRE_BOOTS.get());
        this.tag(Tags.Items.ARMORS).addTags(Tags.Items.ARMORS_HELMETS,Tags.Items.ARMORS_CHESTPLATES,Tags.Items.ARMORS_LEGGINGS,Tags.Items.ARMORS_BOOTS);
        this.tag(Tags.Items.ARMORS_HELMETS).add(ModItems.SAPPHIRE_HELMET.get());
        this.tag(Tags.Items.ARMORS_CHESTPLATES).add(ModItems.SAPPHIRE_CHESTPLATE.get());
        this.tag(Tags.Items.ARMORS_LEGGINGS).add(ModItems.SAPPHIRE_LEGGINGS.get());
        this.tag(Tags.Items.ARMORS_BOOTS).add(ModItems.SAPPHIRE_BOOTS.get());
        this.tag(ItemTags.SWORDS).add(ModItems.SAPPHIRE_SWORD.get());
        this.tag(ItemTags.PICKAXES).add(ModItems.SAPPHIRE_PICKAXE.get());
        this.tag(ItemTags.AXES).add(ModItems.SAPPHIRE_AXE.get());
        this.tag(ItemTags.SHOVELS).add(ModItems.SAPPHIRE_SHOVEL.get());
        this.tag(ItemTags.HOES).add(ModItems.SAPPHIRE_HOE.get());
        this.tag(Tags.Items.TOOLS_BOWS).add(ModItems.SAPPHIRE_BOW.get());

    }
}
