package com.maxdistructo.mods.opitems.interfaces;

import net.minecraft.item.IItemTier;

public interface IOPItemTool extends IOPItem{
    IItemTier getMcTier();
    int getDamage();
    float getSpeed();
}
