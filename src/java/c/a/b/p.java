/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.b;

public final class p
extends Enum<p> {
    public static final /* enum */ p f;
    public static final /* enum */ p g;
    private static final /* synthetic */ p[] h;

    static {
        p p2;
        p p3;
        f = p3 = new p();
        g = p2 = new p();
        h = new p[]{p3, p2};
    }

    public static p valueOf(String string) {
        return (p)Enum.valueOf(p.class, (String)string);
    }

    public static p[] values() {
        return (p[])h.clone();
    }
}

