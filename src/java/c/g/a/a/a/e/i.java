/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e;

public final class i
extends Enum<i> {
    public static final /* enum */ i f;
    public static final /* enum */ i g;
    public static final /* enum */ i h;
    private static final /* synthetic */ i[] i;
    private final String j;

    static {
        i i2;
        i i3;
        i i4;
        f = i4 = new i("native");
        g = i3 = new i("javascript");
        h = i2 = new i("none");
        i = new i[]{i4, i3, i2};
    }

    private i(String string2) {
        this.j = string2;
    }

    public static i valueOf(String string) {
        return (i)Enum.valueOf(i.class, (String)string);
    }

    public static i[] values() {
        return (i[])i.clone();
    }

    public String toString() {
        return this.j;
    }
}

