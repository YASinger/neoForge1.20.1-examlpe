package net.yasinger.examplemod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.yasinger.examplemod.exampleMod;
import net.yasinger.examplemod.item.ModItems;

public class ModItemModeGen extends ItemModelProvider {
    public static final String GENERATED = "item/generated";
    public static final String HANDGELD = "item/handheld";
    public ModItemModeGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, exampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGeneratedModel(ModItems.PRIMOGEM.get(), resourceItem(itemName(ModItems.PRIMOGEM.get())));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }
    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(exampleMod.MOD_ID, "item/" + path);
    }
}
