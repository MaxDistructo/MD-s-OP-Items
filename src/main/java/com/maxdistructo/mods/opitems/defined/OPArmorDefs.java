package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Objects;

public enum OPArmorDefs implements IOPArmor {
    WITHER{
        @Override
        public String getName() {
            return "wither_";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.tab(OPItems.itemGroup);
                    this.rarity(Rarity.RARE);
                    this.fireResistant();
                }
            };
        }

        @Override
        public ArmorMaterial getMaterial() {
            return new ArmorMaterial() {
                @Override
                public int getDurabilityForSlot(EquipmentSlot slotIn) {
                    return (int)(OPArmorDefs.WITHER.getMaxDurability() * OPArmorDefs.WITHER.getPercentOfMax()[slotIn.getIndex()]);
                }

                @Override
                public int getDefenseForSlot(EquipmentSlot slotIn) {
                    return OPArmorDefs.WITHER.getReductionAmounts()[slotIn.getIndex()];
                }

                @Override
                public int getEnchantmentValue() {
                    return 10;
                }

                @Override
                public SoundEvent getEquipSound() {
                    return SoundEvents.ARMOR_EQUIP_DIAMOND;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(Objects.requireNonNull(ItemTags.create(new ResourceLocation("assets/opitems", "material/wither"))));
                }

                @Override
                public String getName() {
                    return "opitems:wither";
                }

                @Override
                public float getToughness() {
                    return 3f;
                }

                @Override
                public float getKnockbackResistance() {
                    return 0;
                }
            };
        }

        @Override
        public double[] getPercentOfMax() {
            return new double[]{.625, 1, .875, .5};

        }

        @Override
        public int getMaxDurability() {
            return 5000;
        }

        @Override
        public int[] getReductionAmounts() {
            return new int[]{4, 7, 9, 4};
        }
    },
    DRAGON{
        @Override
        public String getName() {
            return "dragon_";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.tab(OPItems.itemGroup);
                    this.rarity(Rarity.EPIC);
                    this.fireResistant();
                }
            };
        }

        @Override
        public ArmorMaterial getMaterial() {
            return new ArmorMaterial() {
                @Override
                public int getDurabilityForSlot(EquipmentSlot slotIn) {
                    return (int)(OPArmorDefs.DRAGON.getMaxDurability() * OPArmorDefs.DRAGON.getPercentOfMax()[slotIn.getIndex()]);
                }

                @Override
                public int getDefenseForSlot(EquipmentSlot slotIn) {
                    return OPArmorDefs.DRAGON.getReductionAmounts()[slotIn.getIndex()];
                }

                @Override
                public int getEnchantmentValue() {
                    return 10;
                }

                @Override
                public SoundEvent getEquipSound() {
                    return SoundEvents.ARMOR_EQUIP_DIAMOND;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(Objects.requireNonNull(ItemTags.create(new ResourceLocation("assets/opitems", "material/dragon"))));
                }

                @Override
                public String getName() {
                    return "opitems:dragon";
                }

                @Override
                public float getToughness() {
                    return 5f;
                }

                @Override
                public float getKnockbackResistance() {
                    return 0;
                }
            };
        }

        @Override
        public double[] getPercentOfMax() {
            return new double[]{.625, .875, 1, .5};

        }

        @Override
        public int getMaxDurability() {
            return 10000;
        }

        @Override
        public int[] getReductionAmounts() {
            return new int[]{5, 8, 10, 5};
        }
    },
    GUARDIAN{
        @Override
        public String getName() {
            return "guardian_";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.tab(OPItems.itemGroup);
                    this.rarity(Rarity.RARE);
                }
            };
        }

        @Override
        public ArmorMaterial getMaterial() {
            return new ArmorMaterial() {
                @Override
                public int getDurabilityForSlot(EquipmentSlot slotIn) {
                    return (int)(OPArmorDefs.GUARDIAN.getMaxDurability() * OPArmorDefs.GUARDIAN.getPercentOfMax()[slotIn.getIndex()]);
                }

                @Override
                public int getDefenseForSlot(EquipmentSlot slotIn) {
                    return OPArmorDefs.GUARDIAN.getReductionAmounts()[slotIn.getIndex()];
                }

                @Override
                public int getEnchantmentValue() {
                    return 10;
                }

                @Override
                public SoundEvent getEquipSound() {
                    return SoundEvents.ARMOR_EQUIP_DIAMOND;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(Objects.requireNonNull(ItemTags.create(new ResourceLocation("assets/opitems", "material/guardian"))));
                }

                @Override
                public String getName() {
                    return "opitems:guardian";
                }

                @Override
                public float getToughness() {
                    return 2f;
                }

                @Override
                public float getKnockbackResistance() {
                    return 0;
                }
            };
        }

        @Override
        public double[] getPercentOfMax() {
            return new double[]{.625, .875, 1, .5};
        }

        @Override
        public int getMaxDurability() {
            return 3000;
        }

        @Override
        public int[] getReductionAmounts() {
            return new int[]{3, 6, 8, 3};
        }
    }
}
