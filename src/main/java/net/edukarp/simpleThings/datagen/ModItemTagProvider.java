package net.edukarp.simpleThings.datagen;

import net.edukarp.simpleThings.simpleThings;
import net.edukarp.simpleThings.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper){
        super(packOutput, completableFuture, lookupCompletableFuture, simpleThings.MOD_ID, existingFileHelper);

    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
    tag(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(Items.DIAMOND)
            .add(Items.CLOCK);
    }
}
