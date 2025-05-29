package net.yasinger.examplemod.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yasinger.examplemod.exampleMod;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = exampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModItemModeGen(output, helper));
        generator.addProvider(event.includeClient(), new ModEnLangGen(output, "en_us"));
        generator.addProvider(event.includeClient(), new ModZhLangGen(output, "zh_cn"));
        generator.addProvider(event.includeClient(), new ModBlockModelGen(output, helper));
    }
}
