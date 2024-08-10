package me.youngnico.mccourse.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponent {

    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().nutrition(3).saturationModifier(3)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();
}
