/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e;

public final class h
extends Enum<h> {
    public static final /* enum */ h f;
    public static final /* enum */ h g;
    public static final /* enum */ h h;
    public static final /* enum */ h i;
    public static final /* enum */ h j;
    public static final /* enum */ h k;
    public static final /* enum */ h l;
    public static final /* enum */ h m;
    private static final /* synthetic */ h[] n;
    private final String o;

    static {
        h h2;
        h h3;
        h h4;
        h h5;
        h h6;
        h h7;
        h h8;
        h h9;
        f = h7 = new h("definedByJavaScript");
        g = h8 = new h("unspecified");
        h = h5 = new h("loaded");
        i = h2 = new h("beginToRender");
        j = h3 = new h("onePixel");
        k = h6 = new h("viewable");
        l = h9 = new h("audible");
        m = h4 = new h("other");
        n = new h[]{h7, h8, h5, h2, h3, h6, h9, h4};
    }

    private h(String string2) {
        this.o = string2;
    }

    public static h valueOf(String string) {
        return (h)Enum.valueOf(h.class, (String)string);
    }

    public static h[] values() {
        return (h[])n.clone();
    }

    public String toString() {
        return this.o;
    }
}

