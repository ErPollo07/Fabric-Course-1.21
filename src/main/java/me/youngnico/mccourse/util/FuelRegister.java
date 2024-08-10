package me.youngnico.mccourse.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;

public class FuelRegister {
    public static void regiser(Item item, int secCookingTime) {
        FuelRegistry.INSTANCE.add(item, secCookingTime * 200);
    }
}
