package net.javajumper.craftslotabuse.mixin;

import net.javajumper.craftslotabuse.CraftSlotAbuseInit;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class KillCloseWindowPacket {
    @Inject(method = "sendPacket", at = @At("HEAD"))
    public void sendPacket(Packet<?> pckt,CallbackInfo ci){
        if(pckt instanceof CloseHandledScreenC2SPacket){
            //doing exception here, because we dont want to send packet to server and because i dont know how to do it in other way
            //int x = 0/0;
            //bruh it crashes entire game
            //time to explore fabric documentation yay!!!!!

            //*few minutes later*
            //looks like
            ci.cancel();
            //should work
            //bruh it crashes again but now it tells me that method is not cancellable

            CraftSlotAbuseInit.LOGGER.info("CloseHandledScreenC2SPacket (not) sent to server");
            return;
        }
    }
}
