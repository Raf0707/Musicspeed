/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.m;

public final class d
extends Enum<d> {
    public static final /* enum */ d f;
    public static final /* enum */ d g;
    public static final /* enum */ d h;
    private static final /* synthetic */ d[] i;

    static {
        d d2;
        d d3;
        d d4;
        f = d3 = new d();
        g = d4 = new d();
        h = d2 = new d();
        i = new d[]{d3, d4, d2};
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])i.clone();
    }
}

