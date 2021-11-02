/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e.m;

public final class a
extends Enum<a> {
    public static final /* enum */ a f;
    public static final /* enum */ a g;
    private static final /* synthetic */ a[] h;
    String i;

    static {
        a a2;
        a a3;
        f = a2 = new a("click");
        g = a3 = new a("invitationAccept");
        h = new a[]{a2, a3};
    }

    private a(String string2) {
        this.i = string2;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf(a.class, (String)string);
    }

    public static a[] values() {
        return (a[])h.clone();
    }

    public String toString() {
        return this.i;
    }
}

