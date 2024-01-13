package com.ncpbails.alexsdelight;

import com.mojang.logging.LogUtils;
import com.ncpbails.alexsdelight.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlexsDelight.MOD_ID)
public class AlexsDelight
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "alexsdelight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AlexsDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
            event.accept(ModItems.KANGAROO_SHANK);
            event.accept(ModItems.COOKED_KANGAROO_SHANK);
            event.accept(ModItems.LOOSE_MOOSE_RIB);
            event.accept(ModItems.COOKED_LOOSE_MOOSE_RIB);
            event.accept(ModItems.BISON_MINCE);
            event.accept(ModItems.BISON_PATTY);
            event.accept(ModItems.RAW_BUNFUNGUS_DRUMSTICK);
            event.accept(ModItems.COOKED_BUNFUNGUS_DRUMSTICK);
            event.accept(ModItems.COOKED_CATFISH_SLICE);
            event.accept(ModItems.RAW_CATFISH_SLICE);
            event.accept(ModItems.RAW_BISON);
            event.accept(ModItems.COOKED_BISON);
            event.accept(ModItems.RAW_BUNFUNGUS);
            event.accept(ModItems.COOKED_BUNFUNGUS);
            event.accept(ModItems.COOKED_CENTIPEDE_LEG);
            event.accept(ModItems.GONGYLIDIA_BRUSCHETTA);
            event.accept(ModItems.MAGGOT_SALAD);
            event.accept(ModItems.KANGAROO_STEW);
            event.accept(ModItems.ACACIA_BLOSSOM_SOUP);
            event.accept(ModItems.LOBSTER_PASTA);
            event.accept(ModItems.BISON_BURGER);
            event.accept(ModItems.BUNFUNGUS_SANDWICH);
            event.accept(ModItems.KANGAROO_PASTA);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
