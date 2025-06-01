package net.yasinger.examplemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.exampleMod;

public class ModBlockModelGen extends BlockStateProvider {
    public  ModBlockModelGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.registerBlockModelAndItem(ModBlocks.PRIMOGEM_BLOCK.get());
        this.registerBlockModelAndItem(ModBlocks.PRIMOGEM_ORE.get());
        this.registerBlockModelAndItem(ModBlocks.DEEPSLATE_PRIMOGEM_ORE.get());
        this.registerBlockModelAndItem(ModBlocks.ENDSTONE_PRIMOGEM_ORE.get());
    }

    public void registerBlockModelAndItem(Block block) {
        this.simpleBlockWithItem(block, this.cubeAll(block));
    }
}
