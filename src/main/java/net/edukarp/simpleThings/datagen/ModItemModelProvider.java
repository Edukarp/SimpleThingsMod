package net.edukarp.simpleThings.datagen;

import net.edukarp.simpleThings.item.ModItems;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, simpleThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.RUBY_CHISEL.get());
        basicItem(ModItems.RUBY_SWORD.get());

        basicItem(ModItems.EMPOWERED_COAL.get());

        basicItem(ModItems.TURNIP.get());
    }
}
