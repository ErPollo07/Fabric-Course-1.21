package me.youngnico.mccourse.datagen;

import me.youngnico.mccourse.MCCourseMod;
import me.youngnico.mccourse.block.ModBlocks;
import me.youngnico.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> FLUORITE_SMELTABLES = List.of(ModItems.RAW_FLUORITE,
                ModBlocks.FLUORITE_ORE, ModBlocks.FLUORITE_DEEPSLATE_ORE, ModBlocks.FLUORITE_NETHER_ORE,
                ModBlocks.FLUORITE_END_ORE);

        offerSmelting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE, 0.2F, 200, "fluorite");
        offerBlasting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE, 0.2F, 100, "fluorite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FLUORITE, RecipeCategory.DECORATIONS, ModBlocks.FLUORITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLUORITE)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Blocks.STONE)
                .input('C', ModItems.FLUORITE)
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(ModItems.FLUORITE), conditionsFromItem(ModItems.FLUORITE))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUORITE_STAIRS)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .input('S', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUORITE_SLAB)
                .pattern("   ")
                .pattern("   ")
                .pattern("SSS")
                .input('S', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUORITE_SLAB)
                .pattern("   ")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter, Identifier.of(MCCourseMod.MOD_ID, "fluorite_slab_recipe2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUORITE_SLAB)
                .pattern("SSS")
                .pattern("   ")
                .pattern("   ")
                .input('S', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter, Identifier.of(MCCourseMod.MOD_ID, "fluorite_slab_recipe3"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUORITE_FENCE)
                .pattern("   ")
                .pattern("SCS")
                .pattern("SCS")
                .input('S', ModBlocks.FLUORITE_BLOCK)
                .input('C', Items.STICK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FLUORITE_FENCE)
                .pattern("   ")
                .pattern("SCS")
                .pattern("SCS")
                .input('S', Items.STICK)
                .input('C', ModBlocks.FLUORITE_BLOCK)
                .criterion(hasItem(ModBlocks.FLUORITE_BLOCK), conditionsFromItem(ModBlocks.FLUORITE_BLOCK))
                .offerTo(exporter);
    }
}
