/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e;

public final class e
extends Enum<e> {
    public static final /* enum */ e f;
    public static final /* enum */ e g;
    public static final /* enum */ e h;
    private static final /* synthetic */ e[] i;
    private final String j;

    static {
        e e2;
        e e3;
        e e4;
        f = e4 = new e("html");
        g = e2 = new e("native");
        h = e3 = new e("javascript");
        i = new e[]{e4, e2, e3};
    }

    private e(String string2) {
        this.j = string2;
    }

    public static e valueOf(String string) {
        return (e)Enum.valueOf(e.class, (String)string);
    }

    public static e[] values() {
        return (e[])i.clone();
    }

    public String toString() {
        return this.j;
    }
}

