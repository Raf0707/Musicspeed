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

public final class a
implements c {
    private final float a;

    public a(float f2) {
        this.a = f2;
    }

    public float a(RectF rectF) {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        return this.a == a2.a;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{Float.valueOf((float)this.a)};
        return Arrays.hashCode((Object[])arrobject);
    }
}

