/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;

public final class e
extends Enum<e> {
    public static final /* enum */ e f;
    public static final /* enum */ e g;
    public static final /* enum */ e h;
    private static final boolean i;
    private static final /* synthetic */ e[] j;

    static {
        e e2;
        e e3;
        e e4;
        f = e4 = new e();
        g = e3 = new e();
        h = e2 = new e();
        j = new e[]{e4, e3, e2};
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n2 >= 17) {
            bl = true;
        }
        i = bl;
    }

    public static e valueOf(String string) {
        return (e)Enum.valueOf(e.class, (String)string);
    }

    public static e[] values() {
        return (e[])j.clone();
    }

    @SuppressLint(value={"RtlHardcoded"})
    public int a() {
        int n2 = a.a[this.ordinal()];
        int n3 = 3;
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == n3) {
                    if (i) {
                        return 8388613;
                    }
                    return 5;
                }
                throw new IllegalStateException("Invalid gravity constant");
            }
            return 1;
        }
        if (i) {
            n3 = 8388611;
        }
        return n3;
    }

    @TargetApi(value=17)
    public int b() {
        int n2 = a.a[this.ordinal()];
        if (n2 != 2) {
            if (n2 != 3) {
                return 5;
            }
            return 6;
        }
        return 4;
    }

}

