package com.maxdistructo.mods.opitems.constructors;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.defined.OPArmorDefs;
import com.maxdistructo.mods.opitems.interfaces.IArmorItemExtension;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.*;

public class OPArmor {
    public static class OPWitherArmor extends ArmorItem implements IArmorItemExtension {
        final static OPArmorDefs def = OPArmorDefs.WITHER;
        public static OPArmorDefs getDef(){
            return def;
        }
        public OPWitherArmor(EquipmentSlotType type){
            super(def.getMaterial(), type, def.getProperties());
            setRegistryName(OPItems.MOD_ID, def.getName() + armorName[type.getIndex()]);
        }
        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            //OPItems.LOGGER.debug("Running Armor Tick");
            List<Item> armorSet = new java.util.ArrayList<>();
            String armorType = "wither_";
            player.getArmorInventoryList().forEach(armor -> armorSet.add(armor.getItem()));
            AttributeModifier health_boost = new AttributeModifier(UUID.fromString("6d93ef5c-812f-4f24-b6e4-a62e2f88403e"),"opitems:wither_health_boost", 20.0, AttributeModifier.Operation.ADDITION);
            if(armorSet.containsAll(Arrays.asList(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "helmet")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "chestplate")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "leggings")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "boots"))))){
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH,1,0,false,false));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,1,0,false,false));
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,1,0,false,false));
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 3,false, false));
                player.abilities.allowFlying = true;
                try{player.removeActivePotionEffect(Effects.WITHER);}catch(Exception ignored){}
            }
            else{
                if (!player.isCreative() && !player.isSpectator()){
                    player.abilities.allowFlying = false;
                }
                player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(health_boost);

            }
        }

        @Override
        public String getRegName() {
            return "wither_";
        }
    }
    public static class OPDragonArmor extends ArmorItem implements IArmorItemExtension {
        final static OPArmorDefs def = OPArmorDefs.DRAGON;
        public static OPArmorDefs getDef(){
            return def;
        }
        public OPDragonArmor(EquipmentSlotType type){
            super(def.getMaterial(), type, def.getProperties());
            setRegistryName(OPItems.MOD_ID, def.getName() + armorName[type.getIndex()]);
        }
        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            //OPItems.LOGGER.debug("Running Armor Tick");
            List<Item> armorSet = new java.util.ArrayList<>();
            String armorType = "dragon_";
            player.getArmorInventoryList().forEach(armor -> armorSet.add(armor.getItem()));
            AttributeModifier health_boost = new AttributeModifier(UUID.fromString("6d93ef5c-812f-4f24-b6e4-a62e2f88403e"),"opitems:dragon_health_boost", 40.0, AttributeModifier.Operation.ADDITION);
            //AttributeModifier fly_speed = new AttributeModifier(UUID.fromString("6591ec30-1fae-4bee-a303-bb09dd4c00f2"),"opitems:dragon_fly_speed", 2.0, AttributeModifier.Operation.ADDITION); Bugged in forge
            if(armorSet.containsAll(Arrays.asList(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "helmet")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "chestplate")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "leggings")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "boots"))))){
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH,1,2,false,false));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,1,2,false,false));
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,1,2,false,false));
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION,1,0,false,false));
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 10, 5,false, false));
                try {
                    if (!player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getModifiers().contains(health_boost)) {
                       player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(health_boost);
                    }
                   // if (!player.getAttribute(SharedMonsterAttributes.FLYING_SPEED).getModifiers().contains(fly_speed)) {
                    //    player.getAttribute(SharedMonsterAttributes.FLYING_SPEED).applyModifier(fly_speed);
                   // }
                }
                catch(NullPointerException ignored){}
                player.abilities.allowFlying = true;
                try{player.removeActivePotionEffect(Effects.WITHER);}catch(Exception ignored){}
            }
            else{
                if (!player.isCreative() && !player.isSpectator()){
                    player.abilities.allowFlying = false;
                }
                try {
                    player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(health_boost);
                    //player.getAttribute(SharedMonsterAttributes.FLYING_SPEED).removeModifier(fly_speed);
                }
                catch(NullPointerException ignored){}

            }
        }

        @Override
        public String getRegName() {
            return "dragon_";
        }
    }
    public static class OPGuardianArmor extends ArmorItem implements IArmorItemExtension {
        final static OPArmorDefs def = OPArmorDefs.GUARDIAN;
        public static OPArmorDefs getDef() {return def;}
        public OPGuardianArmor (EquipmentSlotType type){
            super(def.getMaterial(), type, def.getProperties());
            setRegistryName(OPItems.MOD_ID, def.getName() + armorName[type.getIndex()]);
        }
        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player){
            player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5,1,false,false));
        }

        @Override
        public String getRegName(){
            return "guardian_";
        }
    }
}
