package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItem;
import net.minecraft.world.item.Item;

public class OPItemMaterial implements IOPItem {

    String materialName = "";

    public OPItemMaterial(String materialName){
        this.materialName = materialName;
    }

    @Override
    public String getName() {
        return materialName + "_material";
    }

    @Override
    public Item.Properties getProperties() {
        return OPItems.defaultProperties;
    }
}
