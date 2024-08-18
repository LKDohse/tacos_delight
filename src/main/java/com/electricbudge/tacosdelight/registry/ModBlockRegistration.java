package com.electricbudge.tacosdelight.registry;
import net.minecraft.world.level.block.Block;


import java.util.function.Supplier;

public class ModBlockRegistration {
    private Supplier<Block> BLOCK;

    public static ModBlockRegistration start(){
        return new ModBlockRegistration();
    }

    public ModBlockRegistration register(final String name, final Supplier<Block> supplier) {
        BLOCK = ModBlockItems.BLOCKS.register(name, supplier);
        return this;
    }

    public ModBlockRegistration withCreativeTab(){
        ModBlockItems.BLOCK_TAB_ITEMS.add(BLOCK);
        return this;
    }

    public ModBlockRegistration withIngredientTab(){
        ModBlockItems.FOOD_TAB_ITEMS.add(BLOCK);
        return this;
    }

    public Supplier<Block> complete(){
        return BLOCK;
    }
}
