/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.michaelflisar.gdprdialog;

public final class h
extends Enum<h> {
    public static final /* enum */ h f;
    public static final /* enum */ h g;
    public static final /* enum */ h h;
    private static final /* synthetic */ h[] i;

    static {
        h h2;
        h h3;
        h h4;
        f = h4 = new h();
        g = h2 = new h();
        h = h3 = new h();
        i = new h[]{h4, h2, h3};
    }

    public static h valueOf(String string) {
        return (h)Enum.valueOf(h.class, (String)string);
    }

    public static h[] values() {
        return (h[])i.clone();
    }
}

