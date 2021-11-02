/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.c0.c$a
 *  f.x.a
 *  f.x.b
 *  f.z.d.g
 *  java.lang.Object
 */
package f.c0;

import f.c0.c;
import f.c0.d;
import f.x.b;
import f.z.d.g;

/*
 * Exception performing whole class analysis.
 */
public abstract class c {
    private static final c f;
    public static final a g;

    static {
        g = new /* Unavailable Anonymous Inner Class!! */;
        f = b.a.b();
    }

    public static final /* synthetic */ c a() {
        return f;
    }

    public abstract int b(int var1);

    public abstract int c();

    public int d(int n2, int n3) {
        int n4;
        d.b(n2, n3);
        int n5 = n3 - n2;
        if (n5 <= 0 && n5 != Integer.MIN_VALUE) {
            int n6;
            while (n2 > (n6 = this.c()) || n3 <= n6) {
            }
            return n6;
        }
        if ((n5 & -n5) == n5) {
            n4 = this.b(d.c(n5));
        } else {
            int n7;
            int n8;
            while ((n8 = this.c() >>> 1) - (n7 = n8 % n5) + (n5 - 1) < 0) {
            }
            n4 = n7;
        }
        return n2 + n4;
    }
}

