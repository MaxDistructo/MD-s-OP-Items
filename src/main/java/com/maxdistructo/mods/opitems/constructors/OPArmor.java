package com.maxdistructo.mods.opitems.constructors;

import com.google.common.collect.Multimap;
import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.defined.OPArmorDefs;
import com.maxdistructo.mods.opitems.interfaces.IArmorItemExtension;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.*;

public class OPArmor {
    public static class OPWitherArmor extends ArmorItem implements IArmorItemExtension {
        final static OPArmorDefs def = OPArmorDefs.WITHER;
        public static OPArmorDefs getDef(){
            return def;
        }
        Map<Attribute, AttributeModifier> modifiers = new HashMap<>();
        List<UUID> health_uuids = new ArrayList<>();
        List<UUID> speed_uuids = new ArrayList<>();
        List<UUID> fly_uuids = new ArrayList<>();
        List<UUID> damage_uuids = new ArrayList<>();
        public OPWitherArmor(EquipmentSlotType type){
            super(def.getMaterial(), type, def.getProperties());
            setRegistryName(OPItems.MOD_ID, def.getName() + armorName[type.getIndex()]);
            health_uuids.addAll(Arrays.asList(
                    UUID.fromString("3d31693d-e0a3-4d1c-97c9-23f8a118c74c"),
                    UUID.fromString("3f195c8f-7ae2-4f1d-9240-a0efb5e2872b"),
                    UUID.fromString("793bd010-fdcd-452b-8e11-af0eb9121447"),
                    UUID.fromString("925c2fd6-1ab4-4e1d-886d-29abeac7e461")));
            speed_uuids.addAll(Arrays.asList(
                    UUID.fromString("1e8ce8a1-89dc-4989-9c3a-40c913be552e"),
                    UUID.fromString("3f55ab35-ce1f-4c4d-8bfb-2776812f7dd0"),
                    UUID.fromString("b40e3b3d-0926-406c-bad7-8183d25b81ad"),
                    UUID.fromString("9d90677e-2545-4319-8986-dbebf8afea54")));
            fly_uuids.addAll(Arrays.asList(
                    UUID.fromString("2409f9be-d760-4579-b9f6-c2398b3c69e3"),
                    UUID.fromString("e11f08cc-147f-460d-9484-0572168f01d8"),
                    UUID.fromString("83bb887f-c345-437f-abb3-57fcbcd32f7b"),
                    UUID.fromString("626d700e-21c9-4bc8-b566-2d31ed500259")
            ));
            damage_uuids.addAll(Arrays.asList(
                    UUID.fromString("73394a53-388d-41e9-8ee9-dc931cb3bca5"),
                    UUID.fromString("0b80c1ad-2b00-4e09-8ffc-cd86c65e4c66"),
                    UUID.fromString("0d35329c-de35-4d55-a87c-d23ca7c28e18"),
                    UUID.fromString("440b70b4-b60c-4151-9dfb-e21f35cce706")
            ));
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
                player.getAttribute(Attributes.MAX_HEALTH).removeModifier(health_boost);

            }
        }

        /*
        @Override
        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
            Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot);
            if (this.slot == slot) {
                map.put(Attributes.ATTACK_DAMAGE, getOrCreateModifier(Attributes.ATTACK_DAMAGE, () -> new AttributeModifier(damage_uuids.get(slot.getIndex()), "opitems:" + slot.getName() + "_attackdamage", 1.25f, AttributeModifier.Operation.ADDITION)));
                map.put(Attributes.MAX_HEALTH, getOrCreateModifier(Attributes.MAX_HEALTH, () -> new AttributeModifier(health_uuids.get(slot.getIndex()), "opitems:" + slot.getName() + "_hp", 2.5f, AttributeModifier.Operation.ADDITION)));
            }
            return map;
        }
        */
        @Override
        public String getRegName() {
            return "wither_";
        }

        @Override
        public Map<Attribute, AttributeModifier> getModifiers() {
            return modifiers;
        }
    }
    public static class OPDragonArmor extends ArmorItem implements IArmorItemExtension {
        final static OPArmorDefs def = OPArmorDefs.DRAGON;
        public static OPArmorDefs getDef(){
            return def;
        }
        Map<Attribute, AttributeModifier> modifiers = new HashMap<>();
        List<UUID> health_uuids = new ArrayList<>();
        List<UUID> speed_uuids = new ArrayList<>();
        List<UUID> fly_uuids = new ArrayList<>();
        List<UUID> damage_uuids = new ArrayList<>();
        public OPDragonArmor(EquipmentSlotType type){
            super(def.getMaterial(), type, def.getProperties());
            setRegistryName(OPItems.MOD_ID, def.getName() + armorName[type.getIndex()]);
            health_uuids.addAll(Arrays.asList(
                    UUID.fromString("3d31693d-e0a3-4d1c-97c9-23f8a118c74c"),
                    UUID.fromString("3f195c8f-7ae2-4f1d-9240-a0efb5e2872b"),
                    UUID.fromString("793bd010-fdcd-452b-8e11-af0eb9121447"),
                    UUID.fromString("925c2fd6-1ab4-4e1d-886d-29abeac7e461")));
            speed_uuids.addAll(Arrays.asList(
                    UUID.fromString("1e8ce8a1-89dc-4989-9c3a-40c913be552e"),
                    UUID.fromString("3f55ab35-ce1f-4c4d-8bfb-2776812f7dd0"),
                    UUID.fromString("b40e3b3d-0926-406c-bad7-8183d25b81ad"),
                    UUID.fromString("9d90677e-2545-4319-8986-dbebf8afea54")));
            fly_uuids.addAll(Arrays.asList(
                    UUID.fromString("2409f9be-d760-4579-b9f6-c2398b3c69e3"),
                    UUID.fromString("e11f08cc-147f-460d-9484-0572168f01d8"),
                    UUID.fromString("83bb887f-c345-437f-abb3-57fcbcd32f7b"),
                    UUID.fromString("626d700e-21c9-4bc8-b566-2d31ed500259")
            ));
            damage_uuids.addAll(Arrays.asList(
                    UUID.fromString("73394a53-388d-41e9-8ee9-dc931cb3bca5"),
                    UUID.fromString("0b80c1ad-2b00-4e09-8ffc-cd86c65e4c66"),
                    UUID.fromString("0d35329c-de35-4d55-a87c-d23ca7c28e18"),
                    UUID.fromString("440b70b4-b60c-4151-9dfb-e21f35cce706")
            ));
        }

        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            //OPItems.LOGGER.debug("Running Armor Tick");
            List<Item> armorSet = new java.util.ArrayList<>();
            String armorType = "dragon_";
            player.getArmorInventoryList().forEach(armor -> armorSet.add(armor.getItem()));
            if(armorSet.containsAll(Arrays.asList(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "helmet")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "chestplate")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "leggings")), OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, armorType + "boots"))))){
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,1,2,false,false));
                player.abilities.allowFlying = true;
                try{player.removeActivePotionEffect(Effects.WITHER);}catch(Exception ignored){}
            }
            else{
                if (!player.isCreative() && !player.isSpectator()){
                    player.abilities.allowFlying = false;
                }
            }
        }

        @Override
        public Map<Attribute, AttributeModifier> getModifiers() {
            return modifiers;
        }

        /*
        @Override
        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
            Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot);
            if (this.slot == slot) {
                map.put(Attributes.ATTACK_DAMAGE, getOrCreateModifier(Attributes.ATTACK_DAMAGE, () -> new AttributeModifier(damage_uuids.get(slot.getIndex()), "opitems:" + slot.getName() + "_attackdamage", 2.5f, AttributeModifier.Operation.ADDITION)));
                map.put(Attributes.MOVEMENT_SPEED, getOrCreateModifier(Attributes.MOVEMENT_SPEED, () -> new AttributeModifier(speed_uuids.get(slot.getIndex()), "opitems:" + slot.getName() + "_movementspeed", 0.175f, AttributeModifier.Operation.ADDITION)));
                map.put(Attributes.FLYING_SPEED, getOrCreateModifier(Attributes.FLYING_SPEED, () -> new AttributeModifier(fly_uuids.get(slot.getIndex()), "opitems:" + slot.getName() + "_flyspeed", 0.175f, AttributeModifier.Operation.ADDITION)));
                map.put(Attributes.MAX_HEALTH, getOrCreateModifier(Attributes.MAX_HEALTH, () -> new AttributeModifier(health_uuids.get(slot.getIndex()), "opitems:" + slot.getName() + "_hp", 5f, AttributeModifier.Operation.ADDITION)));
            }
            return map;
        }
        */
        @Override
        public String getRegName() {
            return "dragon_";
        }
    }
    public static class OPGuardianArmor extends ArmorItem implements IArmorItemExtension {
        final static OPArmorDefs def = OPArmorDefs.GUARDIAN;
        public static OPArmorDefs getDef() {return def;}
        Map<Attribute, AttributeModifier> modifiers = new HashMap<>();
        public OPGuardianArmor (EquipmentSlotType type){
            super(def.getMaterial(), type, def.getProperties());
            setRegistryName(OPItems.MOD_ID, def.getName() + armorName[type.getIndex()]);
        }
        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player){
            if(player.getLastDamageSource() == DamageSource.DROWN){
                //When drowning, the player loses health by half heart. Restore it if they are drowning.
                player.heal(.5f);
            }
        }

        @Override
        public Map<Attribute, AttributeModifier> getModifiers() {
            return modifiers;
        }

        @Override
        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
            Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot);
            return map;
        }

        @Override
        public String getRegName(){
            return "guardian_";
        }
    }
}
