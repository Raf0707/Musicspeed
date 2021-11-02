/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.b;

public final class b
extends Enum<b> {
    public static final /* enum */ b f;
    public static final /* enum */ b g;
    public static final /* enum */ b h;
    private static final /* synthetic */ b[] i;

    static {
        b b2;
        b b3;
        b b4;
        f = b4 = new b();
        g = b3 = new b();
        h = b2 = new b();
        i = new b[]{b4, b3, b2};
    }

    public static b valueOf(String string) {
        return (b)Enum.valueOf(b.class, (String)string);
    }

    public static b[] values() {
        return (b[])i.clone();
    }
}

