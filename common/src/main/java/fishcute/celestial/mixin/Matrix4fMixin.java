package fishcute.celestial.mixin;

import com.mojang.math.Matrix4f;
import fishcute.celestial.access.AccessibleMatrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Matrix4f.class)
public class Matrix4fMixin implements AccessibleMatrix4f {

    @Shadow
    protected float m00;
    @Shadow
    protected float m01;
    @Shadow
    protected float m02;
    @Shadow
    protected float m03;
    @Shadow
    protected float m10;
    @Shadow
    protected float m11;
    @Shadow
    protected float m12;
    @Shadow
    protected float m13;
    @Shadow
    protected float m20;
    @Shadow
    protected float m21;
    @Shadow
    protected float m22;
    @Shadow
    protected float m23;
    @Shadow
    protected float m30;
    @Shadow
    protected float m31;
    @Shadow
    protected float m32;
    @Shadow
    protected float m33;

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
    public float celestial$m03(float value) {
        this.m03 = value;
        return this.m03;
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
    public float celestial$m13(float value) {
        this.m13 = value;
        return this.m13;
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
    public float celestial$m23(float value) {
        this.m23 = value;
        return this.m23;
    }

    @Override
    public float celestial$m30(float value) {
        this.m30 = value;
        return this.m30;
    }

    @Override
    public float celestial$m31(float value) {
        this.m31 = value;
        return this.m31;
    }

    @Override
    public float celestial$m32(float value) {
        this.m32 = value;
        return this.m32;
    }

    @Override
    public float celestial$m33(float value) {
        this.m33 = value;
        return this.m33;
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
    public float celestial$m03() {
        return this.m03;
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
    public float celestial$m13() {
        return this.m13;
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

    @Override
    public float celestial$m23() {
        return this.m23;
    }

    @Override
    public float celestial$m30() {
        return this.m30;
    }

    @Override
    public float celestial$m31() {
        return this.m31;
    }

    @Override
    public float celestial$m32() {
        return this.m32;
    }

    @Override
    public float celestial$m33() {
        return this.m33;
    }
    
}
