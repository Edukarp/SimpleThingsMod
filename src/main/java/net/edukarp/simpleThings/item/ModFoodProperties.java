package net.edukarp.simpleThings.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TURNIP = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 400), 0.40f).build();
}
