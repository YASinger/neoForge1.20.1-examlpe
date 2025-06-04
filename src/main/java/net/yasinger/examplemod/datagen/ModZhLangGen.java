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
        //  item
        add(ModItems.PRIMOGEM.get(), "原石");
        add(ModItems.RAW_PRIMOGEM.get(), "粗原石");
        add(ModItems.EIGHT_BALL.get(), "八号球");
        //block
        add(ModBlocks.PRIMOGEM_BLOCK.get(), "原石块");
        add(ModBlocks.PRIMOGEM_ORE.get(), "原石矿");
        add(ModBlocks.DEEPSLATE_PRIMOGEM_ORE.get(), "下界原石矿");
        add(ModBlocks.ENDSTONE_PRIMOGEM_ORE.get(), "末地原石矿");
        add(ModBlocks.JUMPY_BLOCK.get(), "跳跃方块");
    }
}
