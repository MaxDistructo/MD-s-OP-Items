package com.maxdistructo.mods.opitems.events;

import com.maxdistructo.mods.opitems.OPItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;

public final class MobLoot {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) { //Wither does not have loot table so have to dirty add the drop.
        OPItems.LOGGER.debug("Triggered LivingDrop Event");
        LivingEntity deadEntity = event.getEntityLiving();
        Collection<ItemEntity> drops = event.getDrops();
        Level world = deadEntity.getCommandSenderWorld();

        if (event.getEntityLiving() instanceof WitherBoss) {
            ItemStack witherMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "wither_material")), 8);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), witherMaterial));
        }
        if (event.getEntity() instanceof ElderGuardian){
            ItemStack guardianMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "guardian_material")), 8);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), guardianMaterial));
        }
        if (event.getEntity() instanceof Guardian){
            ItemStack guardianMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "guardian_material")), 1);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), guardianMaterial));
        }
        if (event.getEntity() instanceof EnderDragon){
            ItemStack dragonMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "dragon_material")), 8);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), dragonMaterial));
        }
    }
}


