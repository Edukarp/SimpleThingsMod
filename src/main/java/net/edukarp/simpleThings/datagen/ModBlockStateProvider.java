package net.edukarp.simpleThings.datagen;

import net.edukarp.simpleThings.block.ModBlocks;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, simpleThings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.RUBY_DEEPSLATE_ORE);

        stairsBlock(ModBlocks.RUBY_STAIRS.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        slabBlock(ModBlocks.RUBY_SLAB.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()), blockTexture((ModBlocks.RUBY_BLOCK.get())));

        buttonBlock(ModBlocks.RUBY_BUTTON.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        pressurePlateBlock(ModBlocks.RUBY_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        fenceBlock(ModBlocks.RUBY_FENCE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceGateBlock(ModBlocks.RUBY_FENCE_GATE.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));
        wallBlock(ModBlocks.RUBY_WALL.get(), blockTexture(ModBlocks.RUBY_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.RUBY_DOOR.get(), modLoc("block/ruby_door_bottom"), modLoc("block/ruby_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.RUBY_TRAPDOOR.get(), modLoc("block/ruby_trapdoor"), true, "cutout");


        blockItem(ModBlocks.RUBY_STAIRS);
        blockItem(ModBlocks.RUBY_SLAB);
        blockItem(ModBlocks.RUBY_PRESSURE_PLATE);
        blockItem(ModBlocks.RUBY_FENCE_GATE);
        blockItem(ModBlocks.RUBY_TRAPDOOR, "_bottom");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("simplethings:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("simplethings:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
