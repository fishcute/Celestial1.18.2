package fishcute.celestial.mixin;

import fishcute.celestialmain.version.independent.VersionSky;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public class FogRendererMixin {

    @ModifyVariable(method = "setupFog", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static boolean setupFog(boolean thickFog) {
        return VersionSky.checkThickFog(thickFog);
    }
    @Inject(method = "setupFog", at = @At("RETURN"))
    private static void setupFog(Camera camera, FogRenderer.FogMode fogMode, float f, boolean bl, CallbackInfo ci) {
        VersionSky.setupFogStartEnd(fogMode == FogRenderer.FogMode.FOG_SKY, f, bl);
        VersionSky.setupFog();
    }

    @Shadow
    private static float fogRed;

    @Shadow
    private static float fogGreen;

    @Shadow
    private static float fogBlue;

    @Inject(method = "setupColor", at = @At("RETURN"))
    private static void setupColor(Camera camera, float f, ClientLevel clientLevel, int i, float g, CallbackInfo ci) {
        float[] color = VersionSky.setupFogColor(f);
        if (color == null) return;
        fogRed = color[0];
        fogGreen = color[1];
        fogBlue = color[2];
    }
}
