package net.javajumper.craftslotabuse;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.MessageType;
import net.minecraft.text.BaseText;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class CraftSlotAbuseInit implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("CraftSlotAbuse");
	public static boolean GhostBlockEnabled = false;
	@Override
	public void onInitialize() {
			var bind = new KeyBinding("GhostBlockGenerator", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UP,"Clientside magic");
			KeyBindingHelper.registerKeyBinding(bind);
			ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (bind.wasPressed()) {
				GhostBlockEnabled = !GhostBlockEnabled;
				String status = GhostBlockEnabled ? "enabled" : "disabled";
				MinecraftClient.getInstance().inGameHud.addChatMessage(MessageType.SYSTEM,new LiteralText("Ghost block mode is "+status),UUID.randomUUID());
			}
		});
	}
	private void registerEvents() {

	}

}
