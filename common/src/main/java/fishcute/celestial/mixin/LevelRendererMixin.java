package fishcute.celestial.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import fishcute.celestialmain.api.minecraft.wrappers.*;
import fishcute.celestialmain.sky.CelestialSky;
import fishcute.celestialmain.version.independent.VersionLevelRenderer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import com.mojang.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    @Shadow
    private VertexBuffer skyBuffer;
    @Shadow
    private VertexBuffer darkBuffer;

    @Shadow
    private ClientLevel level;
    @Inject(method = "renderSky", at = @At("HEAD"), cancellable = true)
    private void renderSky(PoseStack matrices, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean bl, Runnable runnable, CallbackInfo info) {
        if (CelestialSky.doesDimensionHaveCustomSky()) {
            info.cancel();
            runnable.run();

            VersionLevelRenderer.renderLevel((Object) projectionMatrix,
                    (IPoseStackWrapper) matrices,
                    (IVertexBufferWrapper) skyBuffer,
                    (IVertexBufferWrapper) darkBuffer,
                    (ICameraWrapper) camera,
                    (ILevelWrapper) level,
                    tickDelta,
                    null // Not required for 1.19
            );
        }
    }
}
