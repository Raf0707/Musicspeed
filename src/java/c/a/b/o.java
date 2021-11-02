/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.b;

public final class o
extends Enum<o> {
    public static final /* enum */ o f;
    public static final /* enum */ o g;
    public static final /* enum */ o h;
    private static final /* synthetic */ o[] i;

    static {
        o o2;
        o o3;
        o o4;
        f = o3 = new o();
        g = o2 = new o();
        h = o4 = new o();
        i = new o[]{o3, o2, o4};
    }

    public static o valueOf(String string) {
        return (o)Enum.valueOf(o.class, (String)string);
    }

    public static o[] values() {
        return (o[])i.clone();
    }
}

