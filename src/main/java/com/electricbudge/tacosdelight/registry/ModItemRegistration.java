package com.electricbudge.tacosdelight.registry;

import net.minecraft.world.item.Item;
import java.util.function.Supplier;

public class ModItemRegistration {

    private Supplier<Item> ITEM; 
    
    public static ModItemRegistration start(){
        return new ModItemRegistration();
    }
    
    public ModItemRegistration register(final String name, final Supplier<Item> supplier) {
        ITEM = ModItems.ITEMS.register(name, supplier);
        return this;
    }

    public ModItemRegistration withCreativeTab(){
        ModItems.CREATIVE_TAB_ITEMS.add(ITEM);
        return this;
    }

    public ModItemRegistration withIngredientTab(){
        ModItems.INGREDIENTS_TAB_ITEMS.add(ITEM);
        return this;
    }
    
    public Supplier<Item> complete(){
        return ITEM; 
    }
}
