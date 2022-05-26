package net.javajumper.craftslotabuse.mixin;

import net.javajumper.craftslotabuse.CraftSlotAbuseInit;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientPlayerEntity.class)
public abstract class KillCloseWindowPacket {
    @Shadow public abstract void closeScreen();
    @Overwrite
    public void closeHandledScreen() {
        CraftSlotAbuseInit.LOGGER.info("player closed screen but we dont care lol");
        this.closeScreen();
    }
}
