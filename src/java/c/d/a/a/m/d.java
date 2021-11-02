/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.d$a
 *  c.d.a.a.m.f.d
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.d.a.a.m;

import c.d.a.a.m.d;

public final class d
extends Enum<d>
implements c.d.a.a.m.f.d {
    public static final /* enum */ d f;
    public static final /* enum */ d g;
    public static final /* enum */ d h;
    private static final /* synthetic */ d[] i;

    static {
        d d2;
        d d3;
        d d4;
        f = d3 = new d();
        g = d2 = new d();
        h = d4 = new d();
        i = new d[]{d3, d2, d4};
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])i.clone();
    }

    public String a() {
        int n2 = a.a[this.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 == 3) {
                    return "PROMPT_DISMISSED";
                }
                throw new IllegalStateException("This switch statement should be exhaustive.");
            }
            return "THANKS_SHOWN";
        }
        return "PROMPT_SHOWN";
    }
}

