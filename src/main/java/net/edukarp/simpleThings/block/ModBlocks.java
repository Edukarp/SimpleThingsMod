package net.edukarp.simpleThings.block;

import net.edukarp.simpleThings.block.custom.MagicBlock;
import net.edukarp.simpleThings.item.ModItems;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, simpleThings.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RUBY_DEEPSLATE_ORE = registerBlock("ruby_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<StairBlock> RUBY_STAIRS = registerBlock("ruby_stairs",
            () -> new StairBlock(ModBlocks.RUBY_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> RUBY_SLAB = registerBlock("ruby_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> RUBY_BUTTON = registerBlock("ruby_button",
            () -> new ButtonBlock(BlockSetType.IRON, 15, BlockBehaviour.Properties.of().
                    strength(3f).requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> RUBY_FENCE = registerBlock("ruby_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> RUBY_WALL = registerBlock("ruby_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> RUBY_DOOR = registerBlock("ruby_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
