package com.maxdistructo.mods.opitems.constructors;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItem;
import net.minecraft.item.Item;

public class OPItem extends Item {
    public OPItem(IOPItem iopitem) {
        super(iopitem.getProperties());
        this.setRegistryName(OPItems.MOD_ID, iopitem.getName());
    }
}
