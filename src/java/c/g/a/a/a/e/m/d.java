/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e.m;

public final class d
extends Enum<d> {
    public static final /* enum */ d f;
    public static final /* enum */ d g;
    public static final /* enum */ d h;
    public static final /* enum */ d i;
    private static final /* synthetic */ d[] j;
    private final String k;

    static {
        d d2;
        d d3;
        d d4;
        d d5;
        f = d2 = new d("preroll");
        g = d3 = new d("midroll");
        h = d4 = new d("postroll");
        i = d5 = new d("standalone");
        j = new d[]{d2, d3, d4, d5};
    }

    private d(String string2) {
        this.k = string2;
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])j.clone();
    }

    public String toString() {
        return this.k;
    }
}

