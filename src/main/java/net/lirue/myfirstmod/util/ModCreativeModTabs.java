package net.lirue.myfirstmod.util;

import net.lirue.myfirstmod.MyFirstMod;
import net.lirue.myfirstmod.block.ModBlocks;
import net.lirue.myfirstmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyFirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                .title(Component.translatable("creativetab.main"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                    pOutput.accept(ModItems.SAPPHIRE.get());
                    pOutput.accept(ModItems.COOKED_SAPPHIRE.get());
                    pOutput.accept(ModItems.SAPPHIRE_DUST.get());
                    pOutput.accept(ModItems.SAPPHIRE_STAFF.get());
                    pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                    pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                    pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                    pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                    pOutput.accept(ModItems.SAPPHIRE_HOE.get());
                    pOutput.accept(ModItems.SAPPHIRE_BOW.get());
                    pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                    pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                    pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                    pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());
                    pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                    pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                })
                .build());

    public static final RegistryObject<CreativeModeTab> ORES_TAB = CREATIVE_MODE_TABS.register("ores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SAPPHIRE_ORE.get()))
                    .title(Component.translatable("creativetab.ores"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.SANDSTONE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.ANDESITE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.GRANITE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DIORITE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.TUFF_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_SAPPHIRE_ORE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TABS.register("misc_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.COLORED_LAMP.get()))
                    .title(Component.translatable("creativetab.misc"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BORDERLESS_LAMP.get());
                        pOutput.accept(ModBlocks.COLORED_LAMP.get());
                        pOutput.accept(ModBlocks.SMOOTH_LAMP.get());
                        pOutput.accept(ModBlocks.CONDUCTOR.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
