package net.yasinger.examplemod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yasinger.examplemod.exampleMod;
import net.yasinger.examplemod.item.custom.EightBallItem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, exampleMod.MOD_ID);
    public static  final RegistryObject<Item> PRIMOGEM = ITEMS.register("primogem",
            () -> new Item(new Item.Properties()));
    public static  final RegistryObject<Item> RAW_PRIMOGEM = ITEMS.register("raw_primogem",
            () -> new Item(new Item.Properties()));
    public static  final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
