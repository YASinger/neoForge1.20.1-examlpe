package net.yasinger.examplemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.block.custom.PrimogemLampBlock;
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
        this.registerBlockModelAndItem(ModBlocks.JUMPY_BLOCK.get());

        registerProcessor(ModBlocks.PRIMOGEM_LAMP_BLOCK.get(),
            ((PrimogemLampBlock) ModBlocks.PRIMOGEM_LAMP_BLOCK.get()).getLitProperty());
    }

    public void registerBlockModelAndItem(Block block) {
        this.simpleBlockWithItem(block, this.cubeAll(block));
    }
    private void registerProcessor(Block block, BooleanProperty litProperty) {
        String baseName = ForgeRegistries.BLOCKS.getKey(block).getPath();
        String offTexture = "block/" + baseName + "_off";
        String onTexture = "block/" + baseName + "_on";
        ModelFile offModel = models().cubeAll(baseName + "_off", modLoc(offTexture));
        ModelFile onModel = models().cubeAll(baseName + "_on", modLoc(onTexture));

        getVariantBuilder(block).partialState()
                .with(litProperty, false)
                .modelForState().modelFile(offModel).addModel()
                .partialState()
                .with(litProperty, true)
                .modelForState().modelFile(onModel).addModel();
        simpleBlockItem(block, offModel);
    }

}
