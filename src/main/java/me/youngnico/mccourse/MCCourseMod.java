package me.youngnico.mccourse;

import me.youngnico.mccourse.block.ModBlocks;
import me.youngnico.mccourse.item.ModItemGroups;
import me.youngnico.mccourse.item.ModItems;
import me.youngnico.mccourse.util.FuelRegister;
import me.youngnico.mccourse.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		FuelRegister.regiser(ModItems.STARLIGHT_ASHES, 10);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}