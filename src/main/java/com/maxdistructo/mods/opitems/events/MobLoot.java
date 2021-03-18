package com.maxdistructo.mods.opitems.events;

import com.maxdistructo.mods.opitems.OPItems;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobLoot {

    public static void onEntityDeath(LivingDropsEvent event) { //Wither does not have loot table so have to dirty add the drop.
        if (event.getEntity() instanceof WitherEntity) {
            event.getEntity().spawnAtLocation(new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "wither_material")), 6));
        }
        if (event.getEntity() instanceof ElderGuardianEntity){
            event.getEntity().spawnAtLocation(new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "guardian_material")), 8));
        }
        if (event.getEntity() instanceof GuardianEntity){
            event.getEntity().spawnAtLocation(new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "guardian_material")), 1));
        }
        if (event.getEntity() instanceof EnderDragonEntity){
            event.getEntity().spawnAtLocation(new ItemStack(OPItems.registry.getValue(new ResourceLocation(OPItems.MOD_ID, "dragon_material")), 8));
        }
    }
}


