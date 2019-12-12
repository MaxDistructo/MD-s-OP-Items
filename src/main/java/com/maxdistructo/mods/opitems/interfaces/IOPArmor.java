package com.maxdistructo.mods.opitems.interfaces;

import net.minecraft.item.IArmorMaterial;

public interface IOPArmor extends IOPItem {
    IArmorMaterial getMaterial();
    double[] getPercentOfMax();
    int getMaxDurability();
    int[] getReductionAmounts();
}
