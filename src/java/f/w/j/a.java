/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package f.w.j;

public final class a
extends Enum<a> {
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    public static final /* enum */ a h;
    private static final /* synthetic */ a[] i;

    static {
        a a2;
        a a3;
        a a4;
        a[] arra = new a[3];
        f = a2 = new a();
        arra[0] = a2;
        g = a4 = new a();
        arra[1] = a4;
        h = a3 = new a();
        arra[2] = a3;
        i = arra;
    }

    public static a valueOf(String string2) {
        return (a)Enum.valueOf(a.class, (String)string2);
    }

    public static a[] values() {
        return (a[])i.clone();
    }
}

