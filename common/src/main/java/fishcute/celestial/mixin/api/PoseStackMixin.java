package fishcute.celestial.mixin.api;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import fishcute.celestial.VMath;
import fishcute.celestial.access.AccessibleMatrix3f;
import fishcute.celestial.access.AccessibleMatrix4f;
import fishcute.celestial.mixin.PoseMixin;
import fishcute.celestialmain.api.minecraft.wrappers.IPoseStackWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PoseStack.class)
public class PoseStackMixin implements IPoseStackWrapper {

    @Override
    public Object celestial$lastPose() {
        PoseStack self = ((PoseStack)(Object) this);
        return self.last().pose();
    }

    @Override
    public void celestial$pushPose() {
        PoseStack self = ((PoseStack)(Object) this);
        self.pushPose();
    }

    @Override
    public void celestial$popPose() {
        PoseStack self = ((PoseStack)(Object) this);
        self.popPose();
    }

    @Override
    public void celestial$translate(double x, double y, double z) {
        PoseStack self = ((PoseStack)(Object) this);
        self.translate((float) x, (float) y, (float) z);
    }

    @Unique
    private final static Matrix4f celestial$int4 = new Matrix4f();
    @Unique
    private final static Matrix3f celestial$int3 = new Matrix3f();

    @Unique
    private static final Vector3f celestial$XN = new Vector3f(1.0F, 0.0F, 0.0F);
    @Unique
    private static final Vector3f celestial$YN = new Vector3f(0.0F, 1.0F, 0.0F);
    @Unique
    private static final Vector3f celestial$ZN = new Vector3f(0.0F, 0.0F, 1.0F);

    @Override
    public void celestial$mulPose(Axis a, float rot) {
        switch (a) {
            case X:
                VMath.matrix3fSetAxisAngle((AccessibleMatrix3f)(Object) celestial$int3, celestial$XN, rot);
                this.celestial$mulPose((Object) celestial$int3, (Object) celestial$int4);
                break;
            case Y:
                VMath.matrix3fSetAxisAngle((AccessibleMatrix3f)(Object) celestial$int3, celestial$YN, rot);
                this.celestial$mulPose((Object) celestial$int3, (Object) celestial$int4);
                break;
            case Z:
                VMath.matrix3fSetAxisAngle((AccessibleMatrix3f)(Object) celestial$int3, celestial$ZN, rot);
                this.celestial$mulPose((Object) celestial$int3, (Object) celestial$int4);
                break;
        }
    }

    @Override
    public void celestial$mulPose(Object quaternion) {
        this.celestial$mulPose(quaternion, (Object) celestial$int4, (Object) celestial$int3);
    }

    @Override
    public void celestial$mulPose(Object quaternion, Object intermediate4, Object intermediate3) {
        PoseStack.Pose pose = ((PoseStack)(Object) this).last();
        VMath.matrix3fCopyQuaternion(((AccessibleMatrix3f) intermediate3), quaternion);
        VMath.matrix4fCopyMatrix3f(((AccessibleMatrix4f) intermediate4), (AccessibleMatrix3f) intermediate3);

        ((PoseMixin)(Object) pose).getPose().multiply((Matrix4f) intermediate4);
        ((PoseMixin)(Object) pose).getNormal().mul((Matrix3f) intermediate3);
    }

    @Override
    public void celestial$mulPose(Object matrix3f, Object intermediate4) {
        PoseStack self = ((PoseStack)(Object) this);
        PoseStack.Pose pose = self.last();
        VMath.matrix4fCopyMatrix3f(((AccessibleMatrix4f) intermediate4), (AccessibleMatrix3f) matrix3f);
        ((PoseMixin)(Object) pose).getPose().multiply((Matrix4f) intermediate4);
        ((PoseMixin)(Object) pose).getNormal().mul((Matrix3f) matrix3f);
    }

    @Override
    public Object celestial$rotate(float i, float j, float k) {
        this.celestial$pushPose();

        if (i != 0) {
            this.celestial$mulPose(Axis.X, i);
        }
        if (j != 0) {
            this.celestial$mulPose(Axis.Y, j);
        }
        if (k != 0) {
            this.celestial$mulPose(Axis.Z, k);
        }

        Object matrix4f = this.celestial$lastPose();
        this.celestial$popPose();

        return matrix4f;
    }

    @Override
    public Object celestial$rotateThenTranslate(float i, float j, float k, float x, float y, float z) {
        this.celestial$pushPose();

        if (i != 0) {
            this.celestial$mulPose(Axis.X, i);
        }
        if (j != 0) {
            this.celestial$mulPose(Axis.Y, j);
        }
        if (k != 0) {
            this.celestial$mulPose(Axis.Z, k);
        }

        this.celestial$translate(x, y, z);

        Object matrix4f = this.celestial$lastPose();
        this.celestial$popPose();

        return matrix4f;
    }

    @Override
    public Object celestial$translateThenRotate(float i, float j, float k, float x, float y, float z) {
        this.celestial$pushPose();

        this.celestial$translate(x, y, z);

        if (i != 0) {
            this.celestial$mulPose(Axis.X, i);
        }
        if (j != 0) {
            this.celestial$mulPose(Axis.Y, j);
        }
        if (k != 0) {
            this.celestial$mulPose(Axis.Z, k);
        }

        Object matrix4f = this.celestial$lastPose();
        this.celestial$popPose();

        return matrix4f;
    }
}