/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.michaelflisar.gdprdialog;

public final class i
extends Enum<i> {
    public static final /* enum */ i f;
    public static final /* enum */ i g;
    public static final /* enum */ i h;
    public static final /* enum */ i i;
    public static i[] j;
    public static i[] k;
    private static final /* synthetic */ i[] l;

    static {
        i i2;
        i i3;
        i i4;
        i i5;
        f = i5 = new i();
        g = i4 = new i();
        h = i3 = new i();
        i = i2 = new i();
        l = new i[]{i5, i4, i3, i2};
        j = new i[]{i5};
        k = new i[]{i5, i4, i3, i2};
    }

    public static i valueOf(String string) {
        return (i)Enum.valueOf(i.class, (String)string);
    }

    public static i[] values() {
        return (i[])l.clone();
    }
}

