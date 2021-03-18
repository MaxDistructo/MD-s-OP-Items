package com.maxdistructo.mods.opitems.interfaces;

import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;

import java.util.Map;
import java.util.function.Supplier;

public interface IArmorItemExtension {
    String getRegName();
    String[] armorName = {"boots", "leggings", "chestplate", "helmet"};
    Map<Attribute, AttributeModifier> getModifiers ();
    default AttributeModifier getOrCreateModifier(Attribute attribute, Supplier<AttributeModifier> supplier) {
        AttributeModifier mod = getModifiers().get(attribute);
        if (mod == null) {
            mod = supplier.get();
            getModifiers().put(attribute, mod);
        }
        return mod;
    }
}
