package com.maxdistructo.mods.opitems.interfaces;

import net.minecraft.world.item.ArmorMaterial;

public interface IOPArmor extends IOPItem {
    ArmorMaterial getMaterial();
    double[] getPercentOfMax();
    int getMaxDurability();
    int[] getReductionAmounts();
}
