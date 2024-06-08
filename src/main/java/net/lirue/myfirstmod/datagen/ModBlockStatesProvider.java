package net.lirue.myfirstmod.datagen;

import net.lirue.myfirstmod.MyFirstMod;
import net.lirue.myfirstmod.block.ModBlocks;
import net.minecraft.client.model.Model;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ModelProvider;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MyFirstMod.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SANDSTONE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.TUFF_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.ANDESITE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.GRANITE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DIORITE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_SAPPHIRE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        lampBlock(ModBlocks.BORDERLESS_LAMP);
        lampBlock(ModBlocks.COLORED_LAMP);
        lampBlock(ModBlocks.SMOOTH_LAMP);

        stairsBlock(((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.SAPPHIRE_SLAB.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.SAPPHIRE_WALL.get()),blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get()), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAPDOOR.get()), modLoc("block/sapphire_trapdoor"),true,"cutout");
    }

    private void blockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
    private void lampBlock(RegistryObject<Block> block){
        var blockState = MultiVariantGenerator.multiVariant(block.get())
            .with(PropertyDispatch.property(BlockStateProperties.POWER).generate(power ->
                Variant.variant().with(VariantProperties.MODEL,
                new ResourceLocation(MyFirstMod.MOD_ID, "block/" + block.getId().getPath() + "_" + power))));
        registeredBlocks.put(block.get(), () -> blockState.get().getAsJsonObject()); // creates block state file

        for(int power = 0; power <= 15 ; power++){
            new ConfiguredModel(
                    models().cubeAll(block.getId() + "_" + power,
                            new ResourceLocation(MyFirstMod.MOD_ID,
                                    "block/lamps/" + block.getId().getPath() + "_" + power)));  // create blocks models files
        }
        simpleBlockItem(block.get(),models().withExistingParent(block.getId().getPath(),
                new ResourceLocation(MyFirstMod.MOD_ID,
                        "block/" + block.getId().getPath()+ "_0"))); // create item model and block model
    }
}
