package net.edukarp.simpleThings.item;

import net.edukarp.simpleThings.item.custom.ChiselItem;
import net.edukarp.simpleThings.simpleThings;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, simpleThings.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

   public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
           () -> new Item(new Item.Properties()));

   public static final RegistryObject<Item> RUBY_CHISEL = ITEMS.register("ruby_chisel",
           () -> new ChiselItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
