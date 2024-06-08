package net.lirue.myfirstmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
   public static final FoodProperties COOKED_SAPPHIRE = new FoodProperties.Builder()
           .nutrition(4).fast().alwaysEat().saturationMod(0.2f).effect(
            () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200),1f).build();
   public static final FoodProperties SAPPHIRE = new FoodProperties.Builder()
           .nutrition(2).fast().alwaysEat().saturationMod(0.2f).build();
}
