package com.electricbudge.tacosdelight.registry;

import com.electricbudge.tacosdelight.TacosDelight;
import com.google.common.collect.Sets;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class ModItems {

    public static final LazyRegistrar<Item> ITEMS = LazyRegistrar.create(BuiltInRegistries.ITEM, TacosDelight.MODID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();
    public static LinkedHashSet<Supplier<Item>> INGREDIENTS_TAB_ITEMS = Sets.newLinkedHashSet();
    public static LinkedHashSet<Supplier<Item>> FOOD_TAB_ITEMS = Sets.newLinkedHashSet();

    public static Supplier<Item> getTaco(@NotNull FillingType filling){
        return switch (filling) {
            case BEEF -> BEEF_TACO;
            case CHICKEN -> CHICKEN_TACO;
            case POTATO -> POTATO_TACO;
            case CHEESE -> POTATO_TACO;
        };
    }

    public static Supplier<Item> getBurrito(FillingType filling){
        return switch (filling) {
            case BEEF -> BEEF_BURRITO;
            case CHICKEN -> CHICKEN_BURRITO;
            case POTATO -> POTATO_BURRITO;
            case CHEESE -> POTATO_TACO;
        };
    }

    public static Supplier<Item> getCrunchwrap(FillingType filling){
        return switch (filling){
            case BEEF -> BEEF_CRUNCHWRAP;
            default -> CHICKEN_CRUNCHWRAP;
        };
    }

    public static Supplier<Item> getQuesadilla(FillingType filling){
        return switch (filling){
            case BEEF -> BEEF_QUESADILLA;
            case CHICKEN -> CHICKEN_QUESADILLA;
            default -> CHEESE_QUESADILLA;
        };
    }

    public static Supplier<Item> getNachos(FillingType filling){
        return switch (filling){
            default -> CHEESY_NACHOS_SERVING;
        };
    }

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

    public static FoodProperties BuildCrunchwrapProperties(FillingType type){
        var builder = new FoodProperties.Builder().nutrition(16).saturationMod(18F);
        builder.effect(new MobEffectInstance(GetFillingEffect(type), 50), 1F);
        return builder.build();
    }

    public static FoodProperties BuildNachoServingProperties(FillingType type){
        var builder = new FoodProperties.Builder().nutrition(10).saturationMod(10F);
        builder.effect(new MobEffectInstance(GetFillingEffect(type), 50), 0.30F);
        return builder.build();
    }

    public static final FoodProperties BASIC_INGREDIENT_PROPERTIES = new FoodProperties.Builder().nutrition(1).fast().build();
    public static final FoodProperties RAW_INGREDIENT_PROPERTIES = new FoodProperties.Builder().nutrition(2).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HUNGER), 0.30F).build();
    public static final FoodProperties RAW_MEAT_PROPERTIES = new FoodProperties.Builder().nutrition(2).meat().saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HUNGER), 0.30F).build();
    public static final FoodProperties MEAT_PROPERTIES = new FoodProperties.Builder().nutrition(4).meat().saturationMod(1.2F).build();
    public static final FoodProperties UNFINISHED_FOOD_PROPERTIES = new FoodProperties.Builder().nutrition(3).saturationMod(1.2F).build();

    //Uncategorized
    public static final Item.Properties CARDBOARD_TRAY_PROPERTIES = new Item.Properties();
    public static final Item.Properties TACO_SEASONING_PROPERTIES = new Item.Properties().food(new FoodProperties.Builder().nutrition(1).fast().effect(new MobEffectInstance(MobEffects.CONFUSION, 10), 0.50F).build());

    //Basic Ingredients
    public static final Item.Properties DICED_TOMATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties DRIED_CHILI_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties DRIED_ONION_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties FLOUR_TORTILLA_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties HARD_FLOUR_TORTILLA_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties NACHO_CHEESE_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    public static final Item.Properties SHREDDED_CHEESE_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties DICED_POTATO_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties SOUR_CREAM_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    public static final Item.Properties RAW_TORTILLA_CHIPS_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties TORTILLA_CHIPS_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties UNCOOKED_FIESTA_POTATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);
    public static final Item.Properties FRIED_FIESTA_POTATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES);

    //Raw Ingredients
    public static final Item.Properties RAW_TACO_BEEF_PROPERTIES = new Item.Properties().food(RAW_MEAT_PROPERTIES);
    public static final Item.Properties RAW_TACO_CHICKEN_PROPERTIES = new Item.Properties().food(RAW_MEAT_PROPERTIES);
    public static final Item.Properties TORTILLA_DOUGH_PROPERTIES = new Item.Properties().food(RAW_INGREDIENT_PROPERTIES);

    //Cooked Ingredients
    public static final Item.Properties TACO_BEEF_PROPERTIES = new Item.Properties().food(MEAT_PROPERTIES);
    public static final Item.Properties TACO_CHICKEN_PROPERTIES = new Item.Properties().food(MEAT_PROPERTIES);

    //Unfinished Foods
    public static final Item.Properties UNCOOKED_CHEESE_QUESADILLA_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Properties UNCOOKED_CHICKEN_QUESADILLA_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Properties UNCOOKED_BEEF_QUESADILLA_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Properties UNCOOKED_CHICKEN_CRUNCHWRAP_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);
    public static final Item.Properties UNCOOKED_BEEF_CRUNCHWRAP_PROPERTIES = new Item.Properties().food(UNFINISHED_FOOD_PROPERTIES);

    //Sides
    public static final Item.Properties NACHO_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES).craftRemainder(Items.BOWL).stacksTo(16);
    public static final Item.Properties CHEESY_FIESTA_POTATOES_PROPERTIES = new Item.Properties().food(BASIC_INGREDIENT_PROPERTIES).craftRemainder(Items.BOWL).stacksTo(16);

    //Special Nachos
    public static final Item.Properties NACHO_PLATTER_SERVING_PROPERTIES = new Item.Properties().food(BuildNachoServingProperties(FillingType.CHEESE)).craftRemainder(Items.BOWL).stacksTo(4);

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

    //Crunchwraps
    public static final Item.Properties CHICKEN_CRUNCHWRAP_PROPERTIES = new Item.Properties().food(BuildCrunchwrapProperties(FillingType.CHICKEN));
    public static final Item.Properties BEEF_CRUNCHWRAP_PROPERTIES = new Item.Properties().food(BuildCrunchwrapProperties(FillingType.BEEF));

    //Taco Boxes
    public static final Item.Properties BEEF_TACO_BOX_PROPERTIES = new Item.Properties();
    public static final Item.Properties CHICKEN_TACO_BOX_PROPERTIES = new Item.Properties();
    public static final Item.Properties POTATO_TACO_BOX_PROPERTIES = new Item.Properties();

    //Burrito Boxes
    public static final Item.Properties BEEF_BURRITO_BOX_PROPERTIES = new Item.Properties();
    public static final Item.Properties CHICKEN_BURRITO_BOX_PROPERTIES = new Item.Properties();
    public static final Item.Properties POTATO_BURRITO_BOX_PROPERTIES = new Item.Properties();

    //Cravings Boxes
    public static final Item.Properties BEEF_CRAVINGS_BOX_PROPERTIES = new Item.Properties();
    public static final Item.Properties CHICKEN_CRAVINGS_BOX_PROPERTIES = new Item.Properties();

    //Nacho Platters
    public static final Item.Properties CHEESY_NACHO_PLATTER_PROPERTIES = new Item.Properties();

    // Item Registration
    public static final Supplier<Item> CARDBOARD_TRAY = ModItemRegistration.start().register("cardboard_tray",
                    () -> new Item(CARDBOARD_TRAY_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> TACO_SEASONING = ModItemRegistration.start().register("taco_seasoning",
        () -> new Item(TACO_SEASONING_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> DICED_TOMATOES = ModItemRegistration.start().register("diced_tomatoes",
            () -> new Item(DICED_TOMATOES_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> DRIED_CHILI = ModItemRegistration.start().register("dried_chili",
            () -> new Item(DRIED_CHILI_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> DRIED_ONION = ModItemRegistration.start().register("dried_onion",
            () -> new Item(DRIED_ONION_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> FLOUR_TORTILLA = ModItemRegistration.start().register("flour_tortilla",
            () -> new Item(FLOUR_TORTILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> HARD_FLOUR_TORTILLA = ModItemRegistration.start().register("hard_flour_tortilla",
                    () -> new Item(HARD_FLOUR_TORTILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> NACHO_CHEESE = ModItemRegistration.start().register("nacho_cheese", () -> new DrinkableItem(NACHO_CHEESE_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> SHREDDED_CHEESE = ModItemRegistration.start().register("shredded_cheese", () -> new Item(SHREDDED_CHEESE_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> DICED_POTATO = ModItemRegistration.start().register("diced_potato", () -> new Item(DICED_POTATO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> SOUR_CREAM = ModItemRegistration.start().register("sour_cream", () -> new DrinkableItem(SOUR_CREAM_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> RAW_TORTILLA_CHIPS = ModItemRegistration.start().register("raw_tortilla_chips", () -> new Item(RAW_TORTILLA_CHIPS_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> TORTILLA_CHIPS = ModItemRegistration.start().register("tortilla_chips", () -> new Item(TORTILLA_CHIPS_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_FIESTA_POTATOES = ModItemRegistration.start().register("uncooked_fiesta_potatoes", () -> new Item(UNCOOKED_FIESTA_POTATOES_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> FRIED_FIESTA_POTATOES = ModItemRegistration.start().register("fried_fiesta_potatoes", () -> new Item(FRIED_FIESTA_POTATOES_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> RAW_TACO_BEEF = ModItemRegistration.start().register("raw_taco_beef", () -> new Item(RAW_TACO_BEEF_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> RAW_TACO_CHICKEN = ModItemRegistration.start().register("raw_taco_chicken", () -> new Item(RAW_TACO_CHICKEN_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> TACO_BEEF = ModItemRegistration.start().register("taco_beef", () -> new Item(TACO_BEEF_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> TACO_CHICKEN = ModItemRegistration.start().register("taco_chicken", () -> new Item(TACO_CHICKEN_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> TORTILLA_DOUGH = ModItemRegistration.start().register("tortilla_dough", () -> new Item(TORTILLA_DOUGH_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_CHEESE_QUESADILLA = ModItemRegistration.start().register("uncooked_cheese_quesadilla", () -> new Item(UNCOOKED_CHEESE_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_CHICKEN_QUESADILLA = ModItemRegistration.start().register("uncooked_chicken_quesadilla", () -> new Item(UNCOOKED_CHICKEN_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_BEEF_QUESADILLA = ModItemRegistration.start().register("uncooked_beef_quesadilla", () -> new Item(UNCOOKED_BEEF_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_CHICKEN_CRUNCHWRAP = ModItemRegistration.start().register("uncooked_chicken_crunchwrap", () -> new Item(UNCOOKED_CHICKEN_CRUNCHWRAP_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> UNCOOKED_BEEF_CRUNCHWRAP = ModItemRegistration.start().register("uncooked_beef_crunchwrap", () -> new Item(UNCOOKED_BEEF_CRUNCHWRAP_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> NACHOS = ModItemRegistration.start().register("nachos", () -> new ConsumableItem(NACHO_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> CHEESY_FIESTA_POTATOES = ModItemRegistration.start().register("cheesy_fiesta_potatoes", () -> new ConsumableItem(CHEESY_FIESTA_POTATOES_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> CHEESY_NACHOS_SERVING = ModItemRegistration.start().register("cheesy_nachos_serving", () -> new ConsumableItem(NACHO_PLATTER_SERVING_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> POTATO_TACO = ModItemRegistration.start().register("potato_taco", () -> new Item(POTATO_TACO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> CHICKEN_TACO = ModItemRegistration.start().register("chicken_taco", () -> new Item(CHICKEN_TACO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> BEEF_TACO = ModItemRegistration.start().register("beef_taco", () -> new Item(BEEF_TACO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> POTATO_BURRITO = ModItemRegistration.start().register("potato_burrito", () -> new Item(POTATO_BURRITO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> CHICKEN_BURRITO = ModItemRegistration.start().register("chicken_burrito", () -> new Item(CHICKEN_BURRITO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> BEEF_BURRITO = ModItemRegistration.start().register("beef_burrito", () -> new Item(BEEF_BURRITO_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> CHEESE_QUESADILLA = ModItemRegistration.start().register("cheese_quesadilla", () -> new Item(CHEESE_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> CHICKEN_QUESADILLA = ModItemRegistration.start().register("chicken_quesadilla", () -> new Item(CHICKEN_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> BEEF_QUESADILLA = ModItemRegistration.start().register("beef_quesadilla", () -> new Item(BEEF_QUESADILLA_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> CHICKEN_CRUNCHWRAP = ModItemRegistration.start().register("chicken_crunchwrap", () -> new Item(CHICKEN_CRUNCHWRAP_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> BEEF_CRUNCHWRAP = ModItemRegistration.start().register("beef_crunchwrap", () -> new Item(BEEF_CRUNCHWRAP_PROPERTIES))
            .withCreativeTab()
            .withFoodTab()
            .complete();

    public static final Supplier<Item> POTATO_BURRITO_BOX = ModItemRegistration.start().register("potato_burrito_box", () -> new BlockItem(ModBlockItems.POTATO_BURRITO_BOX_BLOCK.get(),POTATO_BURRITO_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> BEEF_BURRITO_BOX = ModItemRegistration.start().register("beef_burrito_box", () -> new BlockItem(ModBlockItems.BEEF_BURRITO_BOX_BLOCK.get(),BEEF_BURRITO_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> CHICKEN_BURRITO_BOX = ModItemRegistration.start().register("chicken_burrito_box", () -> new BlockItem(ModBlockItems.CHICKEN_BURRITO_BOX_BLOCK.get(),CHICKEN_BURRITO_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> POTATO_TACO_BOX = ModItemRegistration.start().register("potato_taco_box", () -> new BlockItem(ModBlockItems.POTATO_TACO_BOX_BLOCK.get(),POTATO_TACO_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> BEEF_TACO_BOX = ModItemRegistration.start().register("beef_taco_box", () -> new BlockItem(ModBlockItems.BEEF_TACO_BOX_BLOCK.get(),BEEF_TACO_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> CHICKEN_TACO_BOX = ModItemRegistration.start().register("chicken_taco_box", () -> new BlockItem(ModBlockItems.CHICKEN_TACO_BOX_BLOCK.get(),CHICKEN_TACO_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> CHICKEN_CRAVINGS_BOX = ModItemRegistration.start().register("chicken_cravings_box", () -> new BlockItem(ModBlockItems.CHICKEN_CRAVINGS_BOX_BLOCK.get(),CHICKEN_CRAVINGS_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> BEEF_CRAVINGS_BOX = ModItemRegistration.start().register("beef_cravings_box", () -> new BlockItem(ModBlockItems.BEEF_CRAVINGS_BOX_BLOCK.get(),BEEF_CRAVINGS_BOX_PROPERTIES))
            .withCreativeTab()
            .complete();

    public static final Supplier<Item> CHEESY_NACHO_PLATTER = ModItemRegistration.start().register("cheesy_nacho_platter", () -> new BlockItem(ModBlockItems.CHEESY_NACHO_PLATTER_BLOCK.get(), CHEESY_NACHO_PLATTER_PROPERTIES))
            .withCreativeTab()
            .complete();

}
