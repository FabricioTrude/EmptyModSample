package net.lirue.myfirstmod.datagen;

import net.lirue.myfirstmod.MyFirstMod;
import net.lirue.myfirstmod.block.ModBlocks;
import net.lirue.myfirstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get(),ModBlocks.SANDSTONE_SAPPHIRE_ORE.get(),ModBlocks.TUFF_SAPPHIRE_ORE.get(),
            ModBlocks.ANDESITE_SAPPHIRE_ORE.get(),ModBlocks.GRANITE_SAPPHIRE_ORE.get(),ModBlocks.DIORITE_SAPPHIRE_ORE.get(),
            ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),ModBlocks.NETHER_SAPPHIRE_ORE.get(),ModBlocks.END_SAPPHIRE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE_DUST.get(), 0.25F,100,"sapphire_dust");
        oreBlasting(consumer, List.of(ModItems.SAPPHIRE_DUST.get()), RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25F,100,"sapphire");
        oreSmelting(consumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE_DUST.get(), 0.25F,200,"sapphire_dust");
        oreSmelting(consumer, List.of(ModItems.SAPPHIRE_DUST.get()), RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25F,200,"sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()),has(ModItems.SAPPHIRE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SAPPHIRE.get(),9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()),has(ModBlocks.SAPPHIRE_BLOCK.get())) .save(consumer);
    }


    protected static void fourCompacting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, int pCount,String pGroup){

    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MyFirstMod.MOD_ID +":"+getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}