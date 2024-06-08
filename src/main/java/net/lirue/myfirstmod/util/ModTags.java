package net.lirue.myfirstmod.util;

import net.lirue.myfirstmod.MyFirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("tiers/sapphire");

        public static final TagKey<Block> FORGE_SAPPHIRE_ORES = forgeTag("ores/sapphire");
        public static final TagKey<Block> SAPPHIRE_ORES = tag("sapphire_ores");
        public static final TagKey<Block> STORAGE_BLOCKS_SAPPHIRE = forgeTag("storage_blocks/sapphire");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_SAPPHIRE = forgeTag("storage_blocks/raw_sapphire");

        public static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge" ,name));
        }
        public static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(MyFirstMod.MOD_ID, name));
        }


    }
    public static class Items{

        public static final TagKey<Item> GEMS_SAPPHIRE = forgeTag("gems/sapphire");
        public static final TagKey<Item> DUSTS_SAPPHIRE = forgeTag("dusts/sapphire");
        public static final TagKey<Item> RAW_SAPPHIRE = forgeTag("raw_materials/sapphire");
        public static final TagKey<Item> STORAGE_BLOCKS_SAPPHIRE = forgeTag("storage_blocks/sapphire");
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_SAPPHIRE = forgeTag("storage_blocks/raw_sapphire");

        public static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge" ,name));
        }
        public static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(MyFirstMod.MOD_ID, name));
        }
    }
}
