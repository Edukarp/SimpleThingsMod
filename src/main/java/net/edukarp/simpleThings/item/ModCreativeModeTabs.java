package net.edukarp.simpleThings.item;

import net.edukarp.simpleThings.block.ModBlocks;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, simpleThings.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUBY_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("ruby_items_tab", () ->
                    CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                            .title(Component.translatable("creativetab.simplethings.ruby_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.RUBY.get());
                                output.accept(ModItems.RUBY_SWORD.get());
                                output.accept(ModBlocks.RUBY_BLOCK.get());
                                output.accept(ModBlocks.RUBY_ORE.get());
                                output.accept(ModBlocks.RUBY_DEEPSLATE_ORE.get());
                                output.accept(ModItems.RUBY_CHISEL.get());
                                output.accept(ModBlocks.MAGIC_BLOCK.get());
                                output.accept(ModItems.TURNIP.get());
                                output.accept(ModItems.EMPOWERED_COAL.get());
                            })
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
