/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  c.e.a.a.a0.c
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Arrays
 */
package c.e.a.a.a0;

import android.graphics.RectF;
import c.e.a.a.a0.c;
import java.util.Arrays;

public final class b
implements c {
    private final c a;
    private final float b;

    public b(float f2, c c2) {
        while (c2 instanceof b) {
            c2 = ((b)c2).a;
            f2 += ((b)c2).b;
        }
        this.a = c2;
        this.b = f2;
    }

    public float a(RectF rectF) {
        return Math.max((float)0.0f, (float)(this.a.a(rectF) + this.b));
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        return this.a.equals((Object)b2.a) && this.b == b2.b;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, Float.valueOf((float)this.b)};
        return Arrays.hashCode((Object[])arrobject);
    }
}

