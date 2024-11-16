package com.electricbudge.tacosdelight.registry;

import com.electricbudge.tacosdelight.TacosDelight;
import com.electricbudge.tacosdelight.block.BurritoBoxBlock;
import com.electricbudge.tacosdelight.block.CravingsBoxBlock;
import com.electricbudge.tacosdelight.block.NachoPlateBlock;
import com.electricbudge.tacosdelight.block.TacoBoxBlock;
import com.google.common.collect.Sets;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class ModBlockItems {
    public static final LazyRegistrar<Block> BLOCKS = LazyRegistrar.create(BuiltInRegistries.BLOCK, TacosDelight.MODID);
    public static LinkedHashSet<Supplier<Block>> BLOCK_TAB_ITEMS = Sets.newLinkedHashSet();


    //TACO BOXES
    public static final Supplier<Block> BEEF_TACO_BOX_BLOCK = ModBlockRegistration.start()
            .register("beef_taco_box_block",
                    () -> new TacoBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.BEEF))
            .withCreativeTab()
            .complete();

    public static final Supplier<Block> CHICKEN_TACO_BOX_BLOCK = ModBlockRegistration.start().register("chicken_taco_box_block",
            () -> new TacoBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.CHICKEN))
            .withCreativeTab()
            .complete();

    public static final Supplier<Block> POTATO_TACO_BOX_BLOCK = ModBlockRegistration.start().register("potato_taco_box_block",
            () -> new TacoBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.POTATO))
            .withCreativeTab()
            .complete();

    //BURRITO BOXES
    public static final Supplier<Block> BEEF_BURRITO_BOX_BLOCK = ModBlockRegistration.start().register("beef_burrito_box_block",
            () -> new BurritoBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.BEEF))
            .withCreativeTab()
            .complete();

    public static final Supplier<Block> CHICKEN_BURRITO_BOX_BLOCK = ModBlockRegistration.start().register("chicken_burrito_box_block",
            () -> new BurritoBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.CHICKEN))
            .withCreativeTab()
            .complete();

    public static final Supplier<Block> POTATO_BURRITO_BOX_BLOCK = ModBlockRegistration.start().register("potato_burrito_box_block",
            () -> new BurritoBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.POTATO))
            .withCreativeTab()
            .complete();


    public static final Supplier<Block> CHICKEN_CRAVINGS_BOX_BLOCK = ModBlockRegistration.start().register("chicken_cravings_box_block",
                    () -> new CravingsBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.CHICKEN))
            .withCreativeTab()
            .complete();


    public static final Supplier<Block> BEEF_CRAVINGS_BOX_BLOCK = ModBlockRegistration.start().register("beef_cravings_box_block",
                    () -> new CravingsBoxBlock(Block.Properties.copy(Blocks.CAKE), ModItems.FillingType.BEEF))
            .withCreativeTab()
            .complete();

    public static final Supplier<Block> CHEESY_NACHO_PLATTER_BLOCK = ModBlockRegistration.start().register("cheesy_nacho_platter_block",
            () -> new NachoPlateBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.FillingType.CHEESE))
            .withCreativeTab()
            .complete();
}
