/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.m.c$a
 *  c.d.a.a.m.f.d
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.d.a.a.m;

import c.d.a.a.m.c;
import c.d.a.a.m.f.d;

public final class c
extends Enum<c>
implements d {
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* enum */ c i;
    public static final /* enum */ c j;
    public static final /* enum */ c k;
    public static final /* enum */ c l;
    public static final /* enum */ c m;
    private static final /* synthetic */ c[] n;

    static {
        c c2;
        c c3;
        c c4;
        c c5;
        c c6;
        c c7;
        c c8;
        c c9;
        f = c8 = new c();
        g = c6 = new c();
        h = c9 = new c();
        i = c2 = new c();
        j = c4 = new c();
        k = c7 = new c();
        l = c5 = new c();
        m = c3 = new c();
        n = new c[]{c8, c6, c9, c2, c4, c7, c5, c3};
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf(c.class, (String)string);
    }

    public static c[] values() {
        return (c[])n.clone();
    }

    public String a() {
        switch (a.a[this.ordinal()]) {
            default: {
                throw new IllegalStateException("This switch statement should be exhaustive.");
            }
            case 8: {
                return "USER_DECLINED_FEEDBACK";
            }
            case 7: {
                return "USER_GAVE_FEEDBACK";
            }
            case 6: {
                return "USER_DECLINED_POSITIVE_FEEDBACK";
            }
            case 5: {
                return "USER_DECLINED_CRITICAL_FEEDBACK";
            }
            case 4: {
                return "USER_GAVE_POSITIVE_FEEDBACK";
            }
            case 3: {
                return "USER_GAVE_CRITICAL_FEEDBACK";
            }
            case 2: {
                return "USER_INDICATED_CRITICAL_OPINION";
            }
            case 1: 
        }
        return "USER_INDICATED_POSITIVE_OPINION";
    }
}

