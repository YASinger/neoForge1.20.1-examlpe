package net.yasinger.examplemod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

import net.yasinger.examplemod.block.custom.JumpyBlock;
import net.yasinger.examplemod.block.custom.PrimogemLampBlock;
import net.yasinger.examplemod.exampleMod;
import net.yasinger.examplemod.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, exampleMod.MOD_ID);

    public static final RegistryObject<Block> PRIMOGEM_BLOCK = registerBlock("primogem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PRIMOGEM_ORE = registerBlock("primogem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_PRIMOGEM_ORE = registerBlock("deepslate_primogem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ENDSTONE_PRIMOGEM_ORE = registerBlock("endstone_primogem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f)));

    public static final RegistryObject<Block> PRIMOGEM_LAMP_BLOCK = registerBlock("primogem_lamp_block",
            () -> new PrimogemLampBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f)
                    .lightLevel(state -> state.getValue(PrimogemLampBlock.LIT) ? 15 : 0)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
