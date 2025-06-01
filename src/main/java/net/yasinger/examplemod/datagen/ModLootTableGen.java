package net.yasinger.examplemod.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Map;
import java.util.stream.Collectors;

import net.yasinger.examplemod.block.ModBlocks;
import net.yasinger.examplemod.exampleMod;
import net.yasinger.examplemod.item.ModItems;


public class ModLootTableGen  extends VanillaBlockLoot {
    @Override
    protected void generate() {
        dropSelf(ModBlocks.PRIMOGEM_BLOCK.get());
        add(ModBlocks.PRIMOGEM_ORE.get(), this::createPrimogemOreDrops);
        add(ModBlocks.DEEPSLATE_PRIMOGEM_ORE.get(), this::createPrimogemOreDrops);
        add(ModBlocks.ENDSTONE_PRIMOGEM_ORE.get(), this::createPrimogemOreDrops);
    }

    protected LootTable.Builder createPrimogemOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(ModItems.RAW_PRIMOGEM.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(exampleMod.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
