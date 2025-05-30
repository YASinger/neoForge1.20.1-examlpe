package net.yasinger.examplemod.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.exampleMod;

import java.util.Map;
import java.util.stream.Collectors;

public class ModLootTableGen  extends VanillaBlockLoot {
    @Override
    protected void generate() {
        dropSelf(ModBlocks.PRIMOGEM_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(exampleMod.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
