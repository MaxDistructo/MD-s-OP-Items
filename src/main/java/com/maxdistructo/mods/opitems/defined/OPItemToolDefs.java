package com.maxdistructo.mods.opitems.defined;

import com.maxdistructo.mods.opitems.OPItems;
import com.maxdistructo.mods.opitems.interfaces.IOPItemTool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Objects;

public class OPItemToolDefs {
    public static class netherItemTier implements IOPItemTool {

        @Override
        public Tier getMcTier() {
            return new Tier(){
                @Override
                public int getUses() {
                    return 5000;
                }

                @Override
                public float getSpeed() {
                    return 5;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 5f;
                }

                @Override
                public int getLevel() {
                    return 10;
                }

                @Override
                public int getEnchantmentValue() {
                    return 10;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(Objects.requireNonNull(ItemTags.create((new ResourceLocation("assets/opitems", "material/wither")))));
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
                    this.durability(5000);
                    this.tab(OPItems.itemGroup);
                    this.rarity(Rarity.RARE);
                    this.fireResistant();

                }
            };
        }
    }
    public static class dragonItemTier implements IOPItemTool {

        @Override
        public Tier getMcTier() {
            return new Tier(){
                @Override
                public int getUses() {
                    return 10000;
                }

                @Override
                public float getSpeed() {
                    return 8;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 8f;
                }

                @Override
                public int getLevel() {
                    return 10;
                }

                @Override
                public int getEnchantmentValue() {
                    return 20;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(Objects.requireNonNull(ItemTags.create(new ResourceLocation("assets/opitems", "material/dragon"))));
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
                    this.durability(10000);
                    this.tab(OPItems.itemGroup);
                    this.rarity(Rarity.EPIC);
                    this.fireResistant();
                }
            };
        }
    }

    public static class guardianItemTier implements IOPItemTool {

        @Override
        public Tier getMcTier() {
            return new Tier(){
                @Override
                public int getUses() {
                    return 3000;
                }

                @Override
                public float getSpeed() {
                    return 3.5f;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 3.5f;
                }

                @Override
                public int getLevel() {
                    return 8;
                }

                @Override
                public int getEnchantmentValue() {
                    return 10;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(Objects.requireNonNull(ItemTags.create(new ResourceLocation("assets/opitems", "material/guardian"))));
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
                    this.durability(3000);
                    this.tab(OPItems.itemGroup);
                    this.rarity(Rarity.RARE);
                }
            };
        }
    }
}
