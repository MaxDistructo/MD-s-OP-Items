package com.maxdistructo.mods.opitems.interfaces;

import net.minecraft.world.item.Tier;

public interface IOPItemTool extends IOPItem{
    Tier getMcTier();
    int getDamage();
    float getSpeed();
}
