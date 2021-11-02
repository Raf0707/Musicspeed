/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package h.e.e;

public final class b
extends Enum<b> {
    public static final /* enum */ b f;
    public static final /* enum */ b g;
    public static final /* enum */ b h;
    public static final /* enum */ b i;
    public static final /* enum */ b j;
    private static final /* synthetic */ b[] k;
    private int l;
    private String m;

    static {
        b b2;
        b b3;
        b b4;
        b b5;
        b b6;
        f = b2 = new b(40, "ERROR");
        g = b6 = new b(30, "WARN");
        h = b3 = new b(20, "INFO");
        i = b5 = new b(10, "DEBUG");
        j = b4 = new b(0, "TRACE");
        k = new b[]{b2, b6, b3, b5, b4};
    }

    private b(int n3, String string3) {
        this.l = n3;
        this.m = string3;
    }

    public static b valueOf(String string2) {
        return (b)Enum.valueOf(b.class, (String)string2);
    }

    public static b[] values() {
        return (b[])k.clone();
    }

    public String toString() {
        return this.m;
    }
}

