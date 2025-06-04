package net.yasinger.examplemod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.exampleMod;

public class ModCreativeModeTab {
    public static final String EXAMPLE_TAB_STRING = "creativetab.example_tab";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, exampleMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PRIMOGEM.get()))
                    .title(Component.translatable(EXAMPLE_TAB_STRING))
                    .displayItems((pParameters, pOutput) -> {
                        //  物品
                        pOutput.accept(ModItems.PRIMOGEM.get());
                        pOutput.accept(ModItems.RAW_PRIMOGEM.get());
                        pOutput.accept(ModItems.EIGHT_BALL.get());
                        //  block
                        pOutput.accept(ModBlocks.PRIMOGEM_BLOCK.get());
                        pOutput.accept(ModBlocks.PRIMOGEM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_PRIMOGEM_ORE.get());
                        pOutput.accept(ModBlocks.ENDSTONE_PRIMOGEM_ORE.get());
                        pOutput.accept(ModBlocks.JUMPY_BLOCK.get());
                        //  原版
                        pOutput.accept(Items.DIAMOND);
                    }).build());
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
