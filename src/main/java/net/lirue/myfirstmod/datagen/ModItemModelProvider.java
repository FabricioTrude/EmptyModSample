package net.lirue.myfirstmod.datagen;

import net.lirue.myfirstmod.MyFirstMod;
import net.lirue.myfirstmod.block.ModBlocks;
import net.lirue.myfirstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.example.registry.ItemRegistry;

import java.rmi.registry.Registry;
import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static{
     trimMaterials.put(TrimMaterials.QUARTZ,0.1F);
     trimMaterials.put(TrimMaterials.IRON,0.2F);
     trimMaterials.put(TrimMaterials.NETHERITE,0.3F);
     trimMaterials.put(TrimMaterials.REDSTONE,0.4F);
     trimMaterials.put(TrimMaterials.COPPER,0.5F);
     trimMaterials.put(TrimMaterials.GOLD,0.6F);
     trimMaterials.put(TrimMaterials.EMERALD,0.7F);
     trimMaterials.put(TrimMaterials.DIAMOND,0.8F);
     trimMaterials.put(TrimMaterials.LAPIS,0.9F);
     trimMaterials.put(TrimMaterials.AMETHYST,1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MyFirstMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        simpleItem("myfirstmod:item/",ModItems.SAPPHIRE_DUST);
        simpleItem("myfirstmod:item/",ModItems.RAW_SAPPHIRE);
        simpleItem("myfirstmod:item/",ModItems.SAPPHIRE);
        simpleItem("myfirstmod:item/food/",ModItems.COOKED_SAPPHIRE);
        simpleHeldItem("myfirstmod:item/tools/",ModItems.SAPPHIRE_SWORD);
        simpleHeldItem("myfirstmod:item/tools/",ModItems.SAPPHIRE_PICKAXE);
        simpleHeldItem("myfirstmod:item/tools/",ModItems.SAPPHIRE_AXE);
        simpleHeldItem("myfirstmod:item/tools/",ModItems.SAPPHIRE_SHOVEL);
        simpleHeldItem("myfirstmod:item/tools/",ModItems.SAPPHIRE_HOE);
        trimmedArmorItem(ModItems.SAPPHIRE_HELMET);
        trimmedArmorItem(ModItems.SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(ModItems.SAPPHIRE_LEGGINGS);
        trimmedArmorItem(ModItems.SAPPHIRE_BOOTS);

        simpleBlockItem("myfirstmod:item/",ModBlocks.SAPPHIRE_DOOR);

        fenceItem(ModBlocks.SAPPHIRE_FENCE,ModBlocks.SAPPHIRE_BLOCK);
        buttonItem(ModBlocks.SAPPHIRE_BUTTON,ModBlocks.SAPPHIRE_BLOCK);
        wallItem(ModBlocks.SAPPHIRE_WALL,ModBlocks.SAPPHIRE_BLOCK);

        trapdoorItem(ModBlocks.SAPPHIRE_TRAPDOOR);

        simplerBlockItem(ModBlocks.SAPPHIRE_STAIRS);
        simplerBlockItem(ModBlocks.SAPPHIRE_SLAB);
        simplerBlockItem(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        simplerBlockItem(ModBlocks.SAPPHIRE_FENCE_GATE);

    }

    private ItemModelBuilder simpleItem(String pPath, RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(pPath + item.getId().getPath()));
    }
    private ItemModelBuilder simpleHeldItem(String pPath, RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(pPath + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(String pPath,RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(pPath + item.getId().getPath()));
    }
    public void simplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(MyFirstMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(MyFirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(MyFirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(MyFirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()+ "_bottom"));
    }
    private ItemModelBuilder simpleArmorItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MyFirstMod.MOD_ID, "item/armor/" + item.getId().getPath()));
    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = MyFirstMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {
                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();
                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };
                String armorItemPath = "item/armor/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/armor/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}