package net.yasinger.examplemod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yasinger.examplemod.block.ModBlocks;
import org.slf4j.Logger;

import net.yasinger.examplemod.item.ModCreativeModeTab;
import net.yasinger.examplemod.item.ModItems;


@Mod(exampleMod.MOD_ID)
public class exampleMod {
    public static  final String MOD_ID = "examplemod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public exampleMod()
    {
        IEventBus modEvenBus = FMLJavaModLoadingContext.get().getModEventBus();
        //  item
        ModItems.register(modEvenBus);
        //  block
        ModBlocks.register(modEvenBus);
        //  item group
        ModCreativeModeTab.register(modEvenBus);

        modEvenBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public  static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
