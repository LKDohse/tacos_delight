package com.electricbudge.tacosdelight;

import com.electricbudge.tacosdelight.registry.ModCreativeTabs;
import com.electricbudge.tacosdelight.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TacosDelight implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("tacos_delight");
	public static final String MODID = "tacos_delight";

	@Override
	public void onInitialize() {
		LOGGER.info("Tacos Delight is initializing!");
		ModItems.ITEMS.register();
		ModCreativeTabs.CREATIVE_TABS.register();
	}
}