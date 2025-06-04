package net.yasinger.examplemod.datagen;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesGen extends RecipeProvider {
    public ModRecipesGen(PackOutput packOutput) {
        super(packOutput);
    }
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PRIMOGEM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.PRIMOGEM.get())
                .group("examplemod")
                .unlockedBy("has_primogem", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModItems.PRIMOGEM.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PRIMOGEM.get(), 9)
                .requires(ModBlocks.PRIMOGEM_BLOCK.get())
                .group("examplemod")
                .unlockedBy("has_primogem_block", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ModBlocks.PRIMOGEM_BLOCK.get()).build()))
                .save(pWriter);

        oreSmelting(pWriter, List.of(ModItems.RAW_PRIMOGEM.get()), RecipeCategory.MISC, ModItems.PRIMOGEM.get(), 0.7f, 200, "examplemod");
        oreBlasting(pWriter, List.of(ModItems.RAW_PRIMOGEM.get()), RecipeCategory.MISC, ModItems.PRIMOGEM.get(), 0.7f, 100, "examplemod");
    }
}
