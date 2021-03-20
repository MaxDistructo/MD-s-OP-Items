package com.maxdistructo.mods.opitems.events;

import com.maxdistructo.mods.opitems.OPItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;

public final class MobLoot {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) { //Wither does not have loot table so have to dirty add the drop.
        OPItems.LOGGER.debug("Triggered LivingDrop Event");
        LivingEntity deadEntity = event.getEntityLiving();
        Collection<ItemEntity> drops = event.getDrops();
        World world = deadEntity.getCommandSenderWorld();

        if (event.getEntityLiving() instanceof WitherEntity) {
            ItemStack witherMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "wither_material")), 8);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), witherMaterial));
        }
        if (event.getEntity() instanceof ElderGuardianEntity){
            ItemStack guardianMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "guardian_material")), 8);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), guardianMaterial));
        }
        if (event.getEntity() instanceof GuardianEntity){
            ItemStack guardianMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "guardian_material")), 1);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), guardianMaterial));
        }
        if (event.getEntity() instanceof EnderDragonEntity){
            ItemStack dragonMaterial = new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "dragon_material")), 8);
            drops.add(new ItemEntity(world, deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), dragonMaterial));
        }
    }
}


