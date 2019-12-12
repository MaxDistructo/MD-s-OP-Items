package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItem;
import net.minecraft.item.Item;

public enum OPItemDefs implements IOPItem {
    OBSIDIAN_STICK{
        @Override
        public String getName() {
            return "obsidian_stick";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.maxStackSize(16);
                    this.group(OPItems.itemGroup);
                }
            };
        }
    }
}
