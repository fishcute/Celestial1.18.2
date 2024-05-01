package fishcute.celestial;

import com.mojang.math.Quaternion;
import fishcute.celestial.access.AccessibleMatrix3f;
import fishcute.celestial.access.AccessibleMatrix4f;
import net.minecraft.util.Mth;
import com.mojang.math.Vector3f;

public class VMath {
    public static float sin(float o) {
        return Mth.sin(o);
    }
    public static float cos(float o) {
        return Mth.cos(o);
    }
    public static void matrix3fCopyQuaternion(AccessibleMatrix3f matrix3f, Object quaternion) {
        Quaternion quat = (Quaternion) quaternion;
        float f = quat.r();
        float g = quat.i();
        float h = quat.j();
        float i = quat.k();
        float j = 2.0F * f * f;
        float k = 2.0F * g * g;
        float l = 2.0F * h * h;
        matrix3f.celestial$m00(1.0F - k - l);
        matrix3f.celestial$m11(1.0F - l - j);
        matrix3f.celestial$m22(1.0F - j - k);
        float m = f * g;
        float n = g * h;
        float o = h * f;
        float p = f * i;
        float q = g * i;
        float r = h * i;
        matrix3f.celestial$m10(2.0F * (m + r));
        matrix3f.celestial$m01(2.0F * (m - r));
        matrix3f.celestial$m20(2.0F * (o - q));
        matrix3f.celestial$m02(2.0F * (o + q));
        matrix3f.celestial$m21(2.0F * (n + p));
        matrix3f.celestial$m12(2.0F * (n - p));
    }
    public static void matrix3fSetAxisAngle(AccessibleMatrix3f matrix3f, Vector3f axis, float angle) {
        angle *= 0.017453292F;

        float g = Mth.sin(angle / 2.0F);
        float a = axis.x() * g;
        float b = axis.y() * g;
        float c = axis.z() * g;
        float d = Mth.cos(angle / 2.0F);

        float j = 2.0F * a * a;
        float k = 2.0F * b * b;
        float l = 2.0F * c * c;
        matrix3f.celestial$m00(1.0F - k - l);
        matrix3f.celestial$m11(1.0F - l - j);
        matrix3f.celestial$m22(1.0F - j - k);
        float m = a * b;
        float n = b * c;
        float o = c * a;
        float p = a * d;
        float q = b * d;
        float r = c * d;
        matrix3f.celestial$m10(2.0F * (m + r));
        matrix3f.celestial$m01(2.0F * (m - r));
        matrix3f.celestial$m20(2.0F * (o - q));
        matrix3f.celestial$m02(2.0F * (o + q));
        matrix3f.celestial$m21(2.0F * (n + p));
        matrix3f.celestial$m12(2.0F * (n - p));
    }

    public static void matrix4fCopyQuaternion(AccessibleMatrix4f matrix4f, Quaternion quaternion) {
        float f = quaternion.r();
        float g = quaternion.i();
        float h = quaternion.j();
        float i = quaternion.k();
        float j = 2.0F * f * f;
        float k = 2.0F * g * g;
        float l = 2.0F * h * h;
        matrix4f.celestial$m00(1.0F - k - l);
        matrix4f.celestial$m11(1.0F - l - j);
        matrix4f.celestial$m22(1.0F - j - k);
        matrix4f.celestial$m33(1.0F);
        float m = f * g;
        float n = g * h;
        float o = h * f;
        float p = f * i;
        float q = g * i;
        float r = h * i;
        matrix4f.celestial$m10(2.0F * (m + r));
        matrix4f.celestial$m01(2.0F * (m - r));
        matrix4f.celestial$m20(2.0F * (o - q));
        matrix4f.celestial$m02(2.0F * (o + q));
        matrix4f.celestial$m21(2.0F * (n + p));
        matrix4f.celestial$m12(2.0F * (n - p));
    }

    public static void matrix4fCopyMatrix3f(AccessibleMatrix4f matrix4f, AccessibleMatrix3f matrix3f) {
        matrix4f.celestial$m00((matrix3f).celestial$m00());
        matrix4f.celestial$m11((matrix3f).celestial$m11());
        matrix4f.celestial$m22((matrix3f).celestial$m22());
        matrix4f.celestial$m10((matrix3f).celestial$m10());
        matrix4f.celestial$m01((matrix3f).celestial$m01());
        matrix4f.celestial$m20((matrix3f).celestial$m20());
        matrix4f.celestial$m02((matrix3f).celestial$m02());
        matrix4f.celestial$m21((matrix3f).celestial$m21());
        matrix4f.celestial$m12((matrix3f).celestial$m12());

        matrix4f.celestial$m03(0.0f);
        matrix4f.celestial$m13(0.0f);
        matrix4f.celestial$m23(0.0f);
        matrix4f.celestial$m30(0.0f);
        matrix4f.celestial$m31(0.0f);
        matrix4f.celestial$m32(0.0f);
        matrix4f.celestial$m33(0.0f);
    }
}
