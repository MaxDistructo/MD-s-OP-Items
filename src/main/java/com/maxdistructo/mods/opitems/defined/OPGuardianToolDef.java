package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItemTool;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class OPGuardianToolDef{
    public static class sword extends SwordItem {
        public sword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public sword(IOPItemTool material){
            super(material.getMcTier(), material.getDamage(), material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "sword");
        }

        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            if(stack.getEquipmentSlot() == EquipmentSlotType.MAINHAND || stack.getEquipmentSlot() == EquipmentSlotType.OFFHAND){
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5,1,false,false));
            }
        }

        @Override
        public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if(target.getType() == EntityType.GUARDIAN || target.getType() == EntityType.ELDER_GUARDIAN){
                if(attacker.getType() == EntityType.PLAYER) {
                    target.attackEntityFrom(DamageSource.causePlayerDamage((PlayerEntity) attacker), 3);
                }
            }
            return super.hitEntity(stack, target, attacker);
        }
    }
    public static class pick extends PickaxeItem {
        public pick(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public pick(IOPItemTool material){
            super(material.getMcTier(), material.getDamage() - 5, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "pick");
        }

        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            if(stack.getEquipmentSlot() == EquipmentSlotType.MAINHAND || stack.getEquipmentSlot() == EquipmentSlotType.OFFHAND){
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5,1,false,false));
            }
        }
    }
    public static class shovel extends ShovelItem {
        public shovel(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public shovel(IOPItemTool material){
            super(material.getMcTier(), material.getDamage() - 7, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "shovel");
        }

        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            if(stack.getEquipmentSlot() == EquipmentSlotType.MAINHAND || stack.getEquipmentSlot() == EquipmentSlotType.OFFHAND){
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5,1,false,false));
            }
        }
    }
    public static class axe extends AxeItem {
        public axe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public axe(IOPItemTool material){
            super(material.getMcTier(), material.getDamage()- 3, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "axe");
        }

        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            if(stack.getEquipmentSlot() == EquipmentSlotType.MAINHAND || stack.getEquipmentSlot() == EquipmentSlotType.OFFHAND){
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5,1,false,false));
            }
        }

        @Override
        public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if(target.getType() == EntityType.GUARDIAN || target.getType() == EntityType.ELDER_GUARDIAN){
                if(attacker.getType() == EntityType.PLAYER) {
                    target.attackEntityFrom(DamageSource.causePlayerDamage((PlayerEntity) attacker), 3);
                }
            }
            return super.hitEntity(stack, target, attacker);
        }
    }
    public static class hoe extends HoeItem {
        public hoe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public hoe(IOPItemTool material){
            super(material.getMcTier(), material.getDamage(), material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "hoe");
        }

        @Override
        public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
            if(stack.getEquipmentSlot() == EquipmentSlotType.MAINHAND || stack.getEquipmentSlot() == EquipmentSlotType.OFFHAND){
                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 5,1,false,false));
            }
        }
    }
}
