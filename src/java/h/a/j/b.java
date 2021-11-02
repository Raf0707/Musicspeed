/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Date
 */
package h.a.j;

import java.util.Date;

public class b {
    public static long a(Date date) {
        return 2082844800L + date.getTime() / 1000L;
    }

    public static Date b(long l2) {
        return new Date(1000L * (l2 - 2082844800L));
    }
}

