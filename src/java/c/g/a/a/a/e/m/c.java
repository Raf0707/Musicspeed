/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e.m;

public final class c
extends Enum<c> {
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* enum */ c i;
    public static final /* enum */ c j;
    private static final /* synthetic */ c[] k;
    private final String l;

    static {
        c c2;
        c c3;
        c c4;
        c c5;
        c c6;
        f = c2 = new c("minimized");
        g = c4 = new c("collapsed");
        h = c3 = new c("normal");
        i = c6 = new c("expanded");
        j = c5 = new c("fullscreen");
        k = new c[]{c2, c4, c3, c6, c5};
    }

    private c(String string2) {
        this.l = string2;
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])k.clone();
    }

    public String toString() {
        return this.l;
    }
}

