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
        //  block
        add(ModBlocks.PRIMOGEM_BLOCK.get(), "primogem block");
    }
}
