package me.youngnico.mccourse.util;

import me.youngnico.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MCCourseMod.MOD_ID, name));
        }
    }

    public static class Item {
        public static final TagKey<net.minecraft.item.Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<net.minecraft.item.Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MCCourseMod.MOD_ID, name));
        }
    }
}
