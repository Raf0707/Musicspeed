/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.i.o.f$a
 *  b.i.o.f$b
 *  b.i.o.f$e
 *  b.i.o.f$f
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package b.i.o;

import b.i.o.f;

/*
 * Exception performing whole class analysis.
 */
public final class f {
    public static final b.i.o.e a;
    public static final b.i.o.e b;
    public static final b.i.o.e c;
    public static final b.i.o.e d;
    public static final b.i.o.e e;
    public static final b.i.o.e f;

    static {
        a = new /* Unavailable Anonymous Inner Class!! */;
        b = new /* Unavailable Anonymous Inner Class!! */;
        b b2 = b.a;
        c = new /* Unavailable Anonymous Inner Class!! */;
        d = new /* Unavailable Anonymous Inner Class!! */;
        e = new /* Unavailable Anonymous Inner Class!! */;
        f = f.b;
    }

    static int a(int n2) {
        if (n2 != 0) {
            if (n2 != 1 && n2 != 2) {
                return 2;
            }
            return 0;
        }
        return 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static int b(int n2) {
        if (n2 == 0) return 1;
        if (n2 == 1 || n2 == 2) return 0;
        switch (n2) {
            default: {
                return 2;
            }
            case 16: 
            case 17: {
                return 0;
            }
            case 14: 
            case 15: 
        }
        return 1;
    }

    private static interface c {
        public int a(CharSequence var1, int var2, int var3);
    }

}

