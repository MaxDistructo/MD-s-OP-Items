package com.maxdistructo.mods.opitems;

import com.maxdistructo.mods.opitems.constructors.OPArmor;
import com.maxdistructo.mods.opitems.constructors.OPItem;
import com.maxdistructo.mods.opitems.defined.OPGuardianToolDef;
import com.maxdistructo.mods.opitems.defined.OPItemDefs;
import com.maxdistructo.mods.opitems.defined.OPItemMaterial;
import com.maxdistructo.mods.opitems.defined.OPItemToolDefs;
import com.maxdistructo.mods.opitems.events.MobLoot;
import com.maxdistructo.mods.opitems.interfaces.IOPItem;
import com.maxdistructo.mods.opitems.interfaces.IOPItemTool;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

@Mod(OPItems.MOD_ID)
public class OPItems {
    public static final String MOD_ID = "opitems";
    //Define static values used for item and block creation
    public static final ItemGroup itemGroup = new ItemGroup(10, "opitems") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Blocks.DIRT);
        }
    };
    public static final Item.Properties defaultProperties = new Item.Properties() {
        {
            this.group(itemGroup);
        }
    };
    public static final Logger LOGGER = LogManager.getLogger();
    public static IForgeRegistry<Item> registry;
    public static List<Object> recievedIMC;

    public OPItems() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(MobLoot.class);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    //Send IMC to other mod
    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    //Recieve IMC from mods
    private void processIMC(final InterModProcessEvent event) {
        recievedIMC = event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList());
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> registryEvent) {
            OPItems.registry = registryEvent.getRegistry();
            //Item Registry Loop. Allows for easy creation of items.
            OPItems.LOGGER.info("Registering Basic Items");
            IOPItem[] items = {OPItemDefs.OBSIDIAN_STICK, new OPItemMaterial("dragon"), new OPItemMaterial("wither"), new OPItemMaterial("guardian")};
            Arrays.stream(items).forEach(item -> {
                registry.register(
                        new OPItem(item)
                );
            });
            OPItems.LOGGER.info("Registering Armors");
            registry.registerAll(
                    new OPArmor.OPDragonArmor(EquipmentSlotType.HEAD),
                    new OPArmor.OPDragonArmor(EquipmentSlotType.CHEST),
                    new OPArmor.OPDragonArmor(EquipmentSlotType.LEGS),
                    new OPArmor.OPDragonArmor(EquipmentSlotType.FEET),
                    new OPArmor.OPGuardianArmor(EquipmentSlotType.HEAD),
                    new OPArmor.OPGuardianArmor(EquipmentSlotType.CHEST),
                    new OPArmor.OPGuardianArmor(EquipmentSlotType.LEGS),
                    new OPArmor.OPGuardianArmor(EquipmentSlotType.FEET),
                    new OPArmor.OPWitherArmor(EquipmentSlotType.HEAD),
                    new OPArmor.OPWitherArmor(EquipmentSlotType.CHEST),
                    new OPArmor.OPWitherArmor(EquipmentSlotType.LEGS),
                    new OPArmor.OPWitherArmor(EquipmentSlotType.FEET)
            );
            //Tool Registry Loop. Allows for 1 OP Item Tier to be used on each of the 5 different tools.
            OPItems.LOGGER.info("Registering Tools");
            IOPItemTool[] itemTiers = {new OPItemToolDefs.netherItemTier(), new OPItemToolDefs.dragonItemTier()};
            Arrays.stream(itemTiers).forEach(tier -> {
                registry.registerAll(
                        new SwordItem(tier.getMcTier(), tier.getDamage(), tier.getSpeed(), tier.getProperties()) {
                            {
                                this.setRegistryName(OPItems.MOD_ID, tier.getName() + "sword");

                            }
                        },
                        new PickaxeItem(tier.getMcTier(), tier.getDamage() - 5, tier.getSpeed(), tier.getProperties()) {
                            {
                                this.setRegistryName(OPItems.MOD_ID, tier.getName() + "pick");
                            }
                        },
                        new AxeItem(tier.getMcTier(), tier.getDamage() - 3, tier.getSpeed(), tier.getProperties()) {
                            {
                                this.setRegistryName(OPItems.MOD_ID, tier.getName() + "axe");
                            }
                        },
                        new ShovelItem(tier.getMcTier(), tier.getDamage() - 7, tier.getSpeed(), tier.getProperties()) {
                            {
                                this.setRegistryName(OPItems.MOD_ID, tier.getName() + "shovel");
                            }
                        },
                        new HoeItem(tier.getMcTier(), tier.getSpeed(), tier.getProperties()) {
                            {
                                this.setRegistryName(OPItems.MOD_ID, tier.getName() + "hoe");
                            }
                        }
                );
            });
            //Extra/Custom Items to Register
            IOPItemTool guardian_tier = new OPItemToolDefs.guardianItemTier();
            Item[] itemsRegistry = {new OPGuardianToolDef.axe(guardian_tier), new OPGuardianToolDef.shovel(guardian_tier), new OPGuardianToolDef.hoe(guardian_tier), new OPGuardianToolDef.pick(guardian_tier), new OPGuardianToolDef.sword(guardian_tier)};
            Arrays.stream(itemsRegistry).forEach(registry::register);
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}

