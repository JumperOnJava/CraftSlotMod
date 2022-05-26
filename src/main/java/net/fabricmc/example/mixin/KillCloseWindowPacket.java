package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleMod;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class KillCloseWindowPacket {
    @Shadow public abstract void closeScreen();

    //@Inject(at = @At("HEAD"), method = "closeHandledScreen()V")
    @Overwrite
    public void closeHandledScreen() {
        ExampleMod.LOGGER.info("player closed screen but we dont care lol");
        this.closeScreen();
    }
}
