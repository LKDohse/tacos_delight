package com.electricbudge.tacosdelight.registry;

import com.electricbudge.tacosdelight.TacosDelight;
import com.google.common.collect.Sets;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class ModItems {

    public static final LazyRegistrar<Item> ITEMS = LazyRegistrar.create(BuiltInRegistries.ITEM, TacosDelight.MODID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();
    public static LinkedHashSet<Supplier<Item>> INGREDIENTS_TAB_ITEMS = Sets.newLinkedHashSet();

    public enum FillingType{
        BEEF,
        CHICKEN,
        POTATO,
        CHEESE
    };

    public static MobEffect GetFillingEffect(FillingType filling){
        return switch (filling) {
            case BEEF -> MobEffects.DAMAGE_BOOST;
            case CHICKEN -> MobEffects.DIG_SPEED;
            case POTATO -> MobEffects.DAMAGE_RESISTANCE;
            case CHEESE -> MobEffects.GLOWING;
        };
    }

    public static FoodProperties BuildQuesadillaProperties(FillingType type){
        var builder = new FoodProperties.Builder().nutrition(10).saturationMod(12F);
        builder.effect(new MobEffectInstance(GetFillingEffect(type), 20), 0.45F);
        return builder.build();
    }

    public static FoodProperties BuildTacoProperties(FillingType type){
        var builder = new FoodProperties.Builder().nutrition(12).saturationMod(14F);
        builder.effect(new MobEffectInstance(GetFillingEffect(type), 30), 0.30F);
        return builder.build();
    }

    public static FoodProperties BuildBurritoProperties(FillingType type){
        var builder = new FoodProperties.Builder().nutrition(14).saturationMod(16F);
        builder.effect(new MobEffectInstance(GetFillingEffect(type), 45), 0.80F);
        return builder.build();
    }

    public static final FoodProperties BASIC_INGREDIENT_PROPERTIES = new FoodProperties.Builder().nutrition(1).fast().build();
    public static final FoodProperties RAW_INGREDIENT_PROPERTIES = new FoodProperties.Builder().nutrition(2).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HUNGER), 0.30F).build();
    public static final FoodProperties RAW_MEAT_PROPERTIES = new FoodProperties.Builder().nutrition(2).meat().saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HUNGER), 0.30F).build();
    public static final FoodProperties UNFINISHED_FOOD_PROPERTIES = new FoodProperties.Builder().nutrition(3).saturationMod(1.2F).build();

    //Uncategorized
    public static final Item.Properties TACO_SEASONING_PROPERTIES = new Item.Properties().food(new FoodProperties.Builder().nutrition(1).fast().effect(new MobEffectInstance(MobEffects.CONFUSION, 10), 0.50F).build());

    //Basic Ingredients
    public static final Item.Properties DICED_TOMATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties DRIED_CHILI_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties DRIED_ONION_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties FLOUR_TORTILLA_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties NACHO_CHEESE_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties DICED_POTATO_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties SOUR_CREAM_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties RAW_TORTILLA_CHIPS_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties TORTILLA_CHIPS_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties UNCOOKED_FIESTA_POTATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties FRIED_FIESTA_POTATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);

    //Raw Ingredients
    public static final Item.Properties RAW_TACO_BEEF_PROPERTIES = new Item.Properties().food(RAW_MEAT_PROPERTIES);
    public static final Item.Properties RAW_TACO_CHICKEN_PROPERTIES = new Item.Properties().food(RAW_MEAT_PROPERTIES);
    public static final Item.Properties TORTILLA_DOUGH_PROPERTIES = new Item.Properties().food(RAW_INGREDIENT_PROPERTIES);

    //Unfinished Foods
    public static final Item.Properties UNCOOKED_CHEESE_QUESADILLA_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Properties UNCOOKED_CHICKEN_QUESADILLA_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Properties UNCOOKED_BEEF_QUESADILLA_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);

    //Sides
    public static final Item.Properties NACHO_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties CHEESY_FIESTA_POTATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);

    //Tacos
    public static final Item.Properties POTATO_TACO_PROPERTIES = new Item.Properties().food(BuildTacoProperties(FillingType.POTATO));
    public static final Item.Properties CHICKEN_TACO_PROPERTIES = new Item.Properties().food(BuildTacoProperties(FillingType.CHICKEN));
    public static final Item.Properties BEEF_TACO_PROPERTIES = new Item.Properties().food(BuildTacoProperties(FillingType.BEEF));

    //Burritos
    public static final Item.Properties POTATO_BURRITO_PROPERTIES = new Item.Properties().food(BuildBurritoProperties(FillingType.POTATO));
    public static final Item.Properties CHICKEN_BURRITO_PROPERTIES = new Item.Properties().food(BuildBurritoProperties(FillingType.CHICKEN));
    public static final Item.Properties BEEF_BURRITO_PROPERTIES = new Item.Properties().food(BuildBurritoProperties(FillingType.BEEF));

    //Quesadillas
    public static final Item.Properties CHEESE_QUESADILLA_PROPERTIES = new Item.Properties().food(BuildQuesadillaProperties(FillingType.CHEESE));
    public static final Item.Properties CHICKEN_QUESADILLA_PROPERTIES = new Item.Properties().food(BuildQuesadillaProperties(FillingType.CHICKEN));
    public static final Item.Properties BEEF_QUESADILLA_PROPERTIES = new Item.Properties().food(BuildQuesadillaProperties(FillingType.BEEF));

    // Item Registration
    public static final Supplier<Item> TACO_SEASONING = ModItemRegistration.start().register("taco_seasoning",
        () -> new Item(TACO_SEASONING_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> DICED_TOMATOES = ModItemRegistration.start().register("diced_tomatoes",
            () -> new Item(DICED_TOMATOES_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> DRIED_CHILI = ModItemRegistration.start().register("dried_chili",
            () -> new Item(DRIED_CHILI_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> DRIED_ONION = ModItemRegistration.start().register("dried_onion",
            () -> new Item(DRIED_ONION_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> FLOUR_TORTILLA = ModItemRegistration.start().register("flour_tortilla",
            () -> new Item(FLOUR_TORTILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> NACHO_CHEESE = ModItemRegistration.start().register("nacho_cheese", () -> new Item(NACHO_CHEESE_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> DICED_POTATO = ModItemRegistration.start().register("diced_potato", () -> new Item(DICED_POTATO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> SOUR_CREAM = ModItemRegistration.start().register("sour_cream", () -> new Item(SOUR_CREAM_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> RAW_TORTILLA_CHIPS = ModItemRegistration.start().register("raw_tortilla_chips", () -> new Item(RAW_TORTILLA_CHIPS_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> TORTILLA_CHIPS = ModItemRegistration.start().register("tortilla_chips", () -> new Item(TORTILLA_CHIPS_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_FIESTA_POTATOES = ModItemRegistration.start().register("uncooked_fiesta_potatoes", () -> new Item(UNCOOKED_FIESTA_POTATOES_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> FRIED_FIESTA_POTATOES = ModItemRegistration.start().register("fried_fiesta_potatoes", () -> new Item(FRIED_FIESTA_POTATOES_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> RAW_TACO_BEEF = ModItemRegistration.start().register("raw_taco_beef", () -> new Item(RAW_TACO_BEEF_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> RAW_TACO_CHICKEN = ModItemRegistration.start().register("raw_taco_chicken", () -> new Item(RAW_TACO_CHICKEN_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> TORTILLA_DOUGH = ModItemRegistration.start().register("tortilla_dough", () -> new Item(TORTILLA_DOUGH_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_CHEESE_QUESADILLA = ModItemRegistration.start().register("uncooked_cheese_quesadilla", () -> new Item(UNCOOKED_CHEESE_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_CHICKEN_QUESADILLA = ModItemRegistration.start().register("uncooked_chicken_quesadilla", () -> new Item(UNCOOKED_CHICKEN_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_BEEF_QUESADILLA = ModItemRegistration.start().register("uncooked_beef_quesadilla", () -> new Item(UNCOOKED_BEEF_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> NACHOS = ModItemRegistration.start().register("nachos", () -> new Item(NACHO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> CHEESY_FIESTA_POTATOES = ModItemRegistration.start().register("cheesy_fiesta_potatoes", () -> new Item(CHEESY_FIESTA_POTATOES_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> POTATO_TACO = ModItemRegistration.start().register("potato_taco", () -> new Item(POTATO_TACO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> CHICKEN_TACO = ModItemRegistration.start().register("chicken_taco", () -> new Item(CHICKEN_TACO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> BEEF_TACO = ModItemRegistration.start().register("beef_taco", () -> new Item(BEEF_TACO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> POTATO_BURRITO = ModItemRegistration.start().register("potato_burrito", () -> new Item(POTATO_BURRITO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> CHICKEN_BURRITO = ModItemRegistration.start().register("chicken_burrito", () -> new Item(CHICKEN_BURRITO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> BEEF_BURRITO = ModItemRegistration.start().register("beef_burrito", () -> new Item(BEEF_BURRITO_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> CHEESE_QUESADILLA = ModItemRegistration.start().register("cheese_quesadilla", () -> new Item(CHEESE_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> CHICKEN_QUESADILLA = ModItemRegistration.start().register("chicken_quesadilla", () -> new Item(CHICKEN_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();

    public static final Supplier<Item> BEEF_QUESADILLA = ModItemRegistration.start().register("beef_quesadilla", () -> new Item(BEEF_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withIngredientTab()
            .complete();
}
