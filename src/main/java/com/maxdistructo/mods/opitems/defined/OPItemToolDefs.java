package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItemTool;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;

public class OPItemToolDefs {
    public static class netherItemTier implements IOPItemTool {

        @Override
        public IItemTier getMcTier() {
            return new IItemTier(){
                @Override
                public int getMaxUses() {
                    return 5000;
                }

                @Override
                public float getEfficiency() {
                    return 5;
                }

                @Override
                public float getAttackDamage() {
                    return 5f;
                }

                @Override
                public int getHarvestLevel() {
                    return 10;
                }

                @Override
                public int getEnchantability() {
                    return 10;
                }

                @Override
                public Ingredient getRepairMaterial() {
                    return Ingredient.fromTag(Objects.requireNonNull(ItemTags.getCollection().get(new ResourceLocation("assets/opitems", "material/wither"))));
                }
            };
        }

        @Override
        public int getDamage() {
            return 10;
        }

        @Override
        public float getSpeed() {
            return 5;
        }

        @Override
        public String getName(){
            return "wither_";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.maxDamage(5000);
                    this.group(OPItems.itemGroup);
                    this.rarity(Rarity.RARE);
                }
            };
        }
    }
    public static class dragonItemTier implements IOPItemTool {

        @Override
        public IItemTier getMcTier() {
            return new IItemTier(){
                @Override
                public int getMaxUses() {
                    return 10000;
                }

                @Override
                public float getEfficiency() {
                    return 8;
                }

                @Override
                public float getAttackDamage() {
                    return 8f;
                }

                @Override
                public int getHarvestLevel() {
                    return 10;
                }

                @Override
                public int getEnchantability() {
                    return 20;
                }

                @Override
                public Ingredient getRepairMaterial() {
                    return Ingredient.fromTag(Objects.requireNonNull(ItemTags.getCollection().get(new ResourceLocation("assets/opitems", "material/dragon"))));
                }
            };
        }

        @Override
        public int getDamage() {
            return 15;
        }

        @Override
        public float getSpeed() {
            return 8;
        }

        @Override
        public String getName(){
            return "dragon_";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.maxDamage(10000);
                    this.group(OPItems.itemGroup);
                    this.rarity(Rarity.EPIC);
                }
            };
        }
    }

    public static class guardianItemTier implements IOPItemTool {

        @Override
        public IItemTier getMcTier() {
            return new IItemTier(){
                @Override
                public int getMaxUses() {
                    return 3000;
                }

                @Override
                public float getEfficiency() {
                    return 3.5f;
                }

                @Override
                public float getAttackDamage() {
                    return 3.5f;
                }

                @Override
                public int getHarvestLevel() {
                    return 8;
                }

                @Override
                public int getEnchantability() {
                    return 10;
                }

                @Override
                public Ingredient getRepairMaterial() {
                    return Ingredient.fromTag(Objects.requireNonNull(ItemTags.getCollection().get(new ResourceLocation("assets/opitems", "material/guardian"))));
                }
            };
        }

        @Override
        public int getDamage() {
            return 8;
        }

        @Override
        public float getSpeed() {
            return 5;
        }

        @Override
        public String getName(){
            return "guardian_";
        }

        @Override
        public Item.Properties getProperties() {
            return new Item.Properties(){
                {
                    this.maxDamage(3000);
                    this.group(OPItems.itemGroup);
                    this.rarity(Rarity.RARE);
                }
            };
        }
    }
}
