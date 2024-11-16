package com.electricbudge.tacosdelight.registry;

import com.electricbudge.tacosdelight.TacosDelight;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


import java.util.function.Supplier;

public class ModCreativeTabs
{
    public static final LazyRegistrar<CreativeModeTab> CREATIVE_TABS = LazyRegistrar.create(Registries.CREATIVE_MODE_TAB, TacosDelight.MODID);

    public static final Supplier<CreativeModeTab> TAB_TACOS_DELIGHT = CREATIVE_TABS.register(TacosDelight.MODID,
            () -> FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.tacos_delight"))
                    .icon(() -> new ItemStack(ModItems.POTATO_BURRITO.get()))
                    .displayItems((parameters, output) -> ModItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
                    .build());

   public static void RegisterItemsInFoodTab(){
       ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> ModItems.FOOD_TAB_ITEMS.forEach((item) ->entries.addAfter(Items.HONEY_BOTTLE, item.get())));
   }
}
