/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  c.e.a.a.a0.c
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.Arrays
 */
package c.e.a.a.a0;

import android.graphics.RectF;
import c.e.a.a.a0.c;
import java.util.Arrays;

public final class i
implements c {
    private final float a;

    public i(float f2) {
        this.a = f2;
    }

    public float a(RectF rectF) {
        return this.a * rectF.height();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof i)) {
            return false;
        }
        i i2 = (i)object;
        return this.a == i2.a;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{Float.valueOf((float)this.a)};
        return Arrays.hashCode((Object[])arrobject);
    }
}

