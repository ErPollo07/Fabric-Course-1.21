package me.youngnico.mccourse.item;

import me.youngnico.mccourse.MCCourseMod;
import me.youngnico.mccourse.item.custom.ChainsawItem;
import me.youngnico.mccourse.item.custom.TeleportstickItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item FLUORITE = registerItem("fluorite",
            new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite",
            new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw",
            new ChainsawItem(new Item.Settings().maxDamage(32)));
    public static final Item TELEPORT_STICK = registerItem("teleport_stick",
            new TeleportstickItem(new Item.Settings()));

    public static final Item STRAWBERRY = registerItem("strawberry",
            new Item(new Item.Settings().food(ModFoodComponent.STRAWBERRY)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.mccourse.strawberry.tip1"));

                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    }

    private static void customIngridient(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Register");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngridient);
    }
}
