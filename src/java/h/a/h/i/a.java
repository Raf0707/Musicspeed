/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 */
package h.a.h.i;

import h.a.h.g;
import h.a.h.h;
import h.a.h.i.c;
import h.a.j.f;
import java.util.Arrays;

public class a
implements c {
    private double a = 2.0;

    public a(double d2) {
        this.a = d2;
    }

    @Override
    public long[] a(g g2) {
        long[] arrl = new long[]{1L};
        long[] arrl2 = g2.F();
        long[] arrl3 = g2.v();
        long l2 = g2.s().g();
        double d2 = 0.0;
        for (int i2 = 0; i2 < arrl2.length; ++i2) {
            if (!((d2 += (double)arrl2[i2] / (double)l2) >= this.a) || arrl3 != null && Arrays.binarySearch((long[])arrl3, (long)(i2 + 1)) < 0) continue;
            if (i2 > 0) {
                long[] arrl4 = new long[]{i2 + 1};
                arrl = f.a(arrl, arrl4);
            }
            d2 = 0.0;
        }
        return arrl;
    }
}

