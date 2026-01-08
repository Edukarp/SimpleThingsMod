package net.edukarp.simpleThings.datagen;

import net.edukarp.simpleThings.block.ModBlocks;
import net.edukarp.simpleThings.item.ModItems;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> RUBY_SMELTABLE = List.of(
                ModBlocks.RUBY_ORE.get(), ModBlocks.RUBY_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD.get())
                .pattern("R")
                .pattern("R")
                .pattern("#")
                .define('R', ModItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_CHISEL.get())
                .pattern("R")
                .pattern("#")
                .define('R', ModItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY.get(),
                0.25f, 200, "ruby");
        oreBlasting(pRecipeOutput, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY.get(),
                0.25f, 100, "ruby");

    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, simpleThings.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }


}
