package net.yasinger.examplemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.exampleMod;
import net.yasinger.examplemod.item.ModItems;

public class ModZhLangGen extends LanguageProvider {
    public ModZhLangGen(PackOutput output, String locale) {
        super(output, exampleMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.PRIMOGEM.get(), "原石");
        add(ModBlocks.PRIMOGEM_BLOCK.get(), "原石块");
    }
}
