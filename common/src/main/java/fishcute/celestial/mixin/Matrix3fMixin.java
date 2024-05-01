package fishcute.celestial.mixin;

import com.mojang.math.Matrix3f;
import fishcute.celestial.access.AccessibleMatrix3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Matrix3f.class)
public class Matrix3fMixin implements AccessibleMatrix3f {
    @Shadow
    protected float m00;
    @Shadow
    protected float m01;
    @Shadow
    protected float m02;
    @Shadow
    protected float m10;
    @Shadow
    protected float m11;
    @Shadow
    protected float m12;
    @Shadow
    protected float m20;
    @Shadow
    protected float m21;
    @Shadow
    protected float m22;

    @Override
    public float celestial$m00(float value) {
        this.m00 = value;
        return this.m00;
    }

    @Override
    public float celestial$m01(float value) {
        this.m01 = value;
        return this.m01;
    }

    @Override
    public float celestial$m02(float value) {
        this.m02 = value;
        return this.m02;
    }

    @Override
    public float celestial$m10(float value) {
        this.m10 = value;
        return this.m10;
    }

    @Override
    public float celestial$m11(float value) {
        this.m11 = value;
        return this.m11;
    }

    @Override
    public float celestial$m12(float value) {
        this.m12 = value;
        return this.m12;
    }

    @Override
    public float celestial$m20(float value) {
        this.m20 = value;
        return this.m20;
    }

    @Override
    public float celestial$m21(float value) {
        this.m21 = value;
        return this.m21;
    }

    @Override
    public float celestial$m22(float value) {
        this.m22 = value;
        return this.m22;
    }

    @Override
    public float celestial$m00() {
        return this.m00;
    }

    @Override
    public float celestial$m01() {
        return this.m01;
    }

    @Override
    public float celestial$m02() {
        return this.m02;
    }

    @Override
    public float celestial$m10() {
        return this.m10;
    }

    @Override
    public float celestial$m11() {
        return this.m11;
    }

    @Override
    public float celestial$m12() {
        return this.m12;
    }

    @Override
    public float celestial$m20() {
        return this.m20;
    }

    @Override
    public float celestial$m21() {
        return this.m21;
    }

    @Override
    public float celestial$m22() {
        return this.m22;
    }
}
