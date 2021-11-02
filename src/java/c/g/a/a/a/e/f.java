/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e;

public final class f
extends Enum<f> {
    public static final /* enum */ f f;
    public static final /* enum */ f g;
    public static final /* enum */ f h;
    public static final /* enum */ f i;
    public static final /* enum */ f j;
    private static final /* synthetic */ f[] k;
    private final String l;

    static {
        f f2;
        f f3;
        f f4;
        f f5;
        f f6;
        f = f6 = new f("definedByJavaScript");
        g = f4 = new f("htmlDisplay");
        h = f3 = new f("nativeDisplay");
        i = f5 = new f("video");
        j = f2 = new f("audio");
        k = new f[]{f6, f4, f3, f5, f2};
    }

    private f(String string2) {
        this.l = string2;
    }

    public static f valueOf(String string) {
        return (f)Enum.valueOf(f.class, (String)string);
    }

    public static f[] values() {
        return (f[])k.clone();
    }

    public String toString() {
        return this.l;
    }
}

