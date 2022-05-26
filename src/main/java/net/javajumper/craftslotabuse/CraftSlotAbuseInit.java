package net.javajumper.craftslotabuse;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraftSlotAbuseInit implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("CraftSlotAbuse");

	@Override
	public void onInitialize() {
		//we dont init anything, dont tell anyone
		LOGGER.info("Hello JavaJumper!");
	}
}
