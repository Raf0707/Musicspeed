/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package h.a.j;

public final class f {
    public static /* varargs */ long[] a(long[] arrl, long ... arrl2) {
        if (arrl == null) {
            arrl = new long[]{};
        }
        if (arrl2 == null) {
            arrl2 = new long[]{};
        }
        long[] arrl3 = new long[arrl.length + arrl2.length];
        System.arraycopy((Object)arrl, (int)0, (Object)arrl3, (int)0, (int)arrl.length);
        System.arraycopy((Object)arrl2, (int)0, (Object)arrl3, (int)arrl.length, (int)arrl2.length);
        return arrl3;
    }
}

