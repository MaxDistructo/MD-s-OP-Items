package com.maxdistructo.mods.opitems.constructors;

import com.maxdistructo.mods.opitems.interfaces.IOPItem;
import net.minecraft.world.item.Item;

public class OPItem extends Item {
    public OPItem(IOPItem iopitem) {
        super(iopitem.getProperties());
    }
}
