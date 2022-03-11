package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItemTool;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class OPGuardianToolDef{
    public static class sword extends SwordItem {
        public sword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public sword(IOPItemTool material){
            super(material.getMcTier(), material.getDamage(), material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "sword");
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player player) {
            if(stack.getEquipmentSlot() == EquipmentSlot.MAINHAND || stack.getEquipmentSlot() == EquipmentSlot.OFFHAND){
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 5,1,false,false));
            }
        }

        @Override
        public boolean hurtEnemy(@NotNull ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {
            if(target.getType() == EntityType.GUARDIAN || target.getType() == EntityType.ELDER_GUARDIAN){
                if(attacker.getType() == EntityType.PLAYER) {
                    target.hurt(DamageSource.playerAttack((Player) attacker), 3);
                }
            }
            return super.hurtEnemy(stack, target, attacker);
        }
    }
    public static class pick extends PickaxeItem {
        public pick(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public pick(IOPItemTool material){
            super(material.getMcTier(), material.getDamage() - 5, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "pick");
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player player) {
            if(stack.getEquipmentSlot() == EquipmentSlot.MAINHAND || stack.getEquipmentSlot() == EquipmentSlot.OFFHAND){
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 5,1,false,false));
            }
        }
    }
    public static class shovel extends ShovelItem {
        public shovel(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public shovel(IOPItemTool material){
            super(material.getMcTier(), material.getDamage() - 7, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "shovel");
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player player) {
            if(stack.getEquipmentSlot() == EquipmentSlot.MAINHAND || stack.getEquipmentSlot() == EquipmentSlot.OFFHAND){
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 5,1,false,false));
            }
        }
    }
    public static class axe extends AxeItem {
        public axe(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public axe(IOPItemTool material){
            super(material.getMcTier(), material.getDamage()- 3, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "axe");
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player player) {
            if(stack.getEquipmentSlot() == EquipmentSlot.MAINHAND || stack.getEquipmentSlot() == EquipmentSlot.OFFHAND){
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 5,1,false,false));
            }
        }

        @Override
        public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if(target.getType() == EntityType.GUARDIAN || target.getType() == EntityType.ELDER_GUARDIAN){
                if(attacker.getType() == EntityType.PLAYER) {
                    target.hurt(DamageSource.playerAttack((Player) attacker), 3);
                }
            }
            return super.hurtEnemy(stack, target, attacker);
        }
    }
    public static class hoe extends HoeItem {
        public hoe(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }
        public hoe(IOPItemTool material){
            super(material.getMcTier(), material.getDamage() - 9, material.getSpeed(), material.getProperties());
            this.setRegistryName(OPItems.MOD_ID, material.getName() + "hoe");
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player player) {
            if(stack.getEquipmentSlot() == EquipmentSlot.MAINHAND || stack.getEquipmentSlot() == EquipmentSlot.OFFHAND){
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 5,1,false,false));
            }
        }
    }
}
