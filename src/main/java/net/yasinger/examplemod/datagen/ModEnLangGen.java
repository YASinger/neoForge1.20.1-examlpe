package net.yasinger.examplemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.exampleMod;
import net.yasinger.examplemod.item.ModItems;

public class ModEnLangGen extends LanguageProvider {
    public ModEnLangGen(PackOutput output, String locale) {
        super(output, exampleMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        //  item
        add(ModItems.PRIMOGEM.get(), "primogem");
        add(ModItems.RAW_PRIMOGEM.get(), "raw primogem");
        add(ModItems.EIGHT_BALL.get(), "eight ball");
        //  block
        add(ModBlocks.PRIMOGEM_BLOCK.get(), "primogem block");
        add(ModBlocks.PRIMOGEM_ORE.get(), "primogem ore");
        add(ModBlocks.DEEPSLATE_PRIMOGEM_ORE.get(), "deepslate primogem ore");
        add(ModBlocks.ENDSTONE_PRIMOGEM_ORE.get(), "endstone primogem ore");
        add(ModBlocks.JUMPY_BLOCK.get(), "jumpy block");
        add(ModBlocks.PRIMOGEM_LAMP_BLOCK.get(), "primogem lamp block");
    }
}
