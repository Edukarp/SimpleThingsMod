package net.edukarp.simpleThings.datagen;

import net.edukarp.simpleThings.block.ModBlocks;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, simpleThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.RUBY_DEEPSLATE_ORE.get());

        tag((BlockTags.NEEDS_IRON_TOOL))
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag((BlockTags.NEEDS_DIAMOND_TOOL))
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.RUBY_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.RUBY_WALL.get());
    }

}
