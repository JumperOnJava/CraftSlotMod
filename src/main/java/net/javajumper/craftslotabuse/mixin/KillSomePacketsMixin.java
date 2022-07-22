package net.javajumper.craftslotabuse.mixin;

import net.javajumper.craftslotabuse.CraftSlotAbuseInit;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class KillSomePacketsMixin {
    @Inject(method = "sendPacket", at = @At("HEAD"),cancellable = true)
    private void killCloseWindowPacket(Packet<?> pckt,CallbackInfo ci){
        if(pckt instanceof CloseHandledScreenC2SPacket) {
            if(((CloseHandledScreenC2SPacket) pckt).getSyncId() == 0) {
                ci.cancel();
            }
        }
        if(CraftSlotAbuseInit.GhostBlockEnabled)
        if(pckt instanceof HandSwingC2SPacket || pckt instanceof PlayerInteractBlockC2SPacket)
        {
            ci.cancel();
        }
        CraftSlotAbuseInit.LOGGER.info(pckt.getClass().getSimpleName());
    }
}
