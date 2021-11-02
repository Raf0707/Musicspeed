/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package com.smp.musicspeed.markers;

import com.smp.musicspeed.markers.i0;
import f.z.d.k;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class d0 {
    public static final String a(long l2) {
        i0 i02 = d0.b(l2);
        long l3 = i02.a();
        long l4 = i02.b();
        long l5 = i02.c();
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{l3, l4, l5};
        String string2 = String.format((Locale)locale, (String)"%02d:%02d.%03d", (Object[])Arrays.copyOf((Object[])arrobject, (int)3));
        k.f((Object)string2, (String)"java.lang.String.format(locale, format, *args)");
        return string2;
    }

    public static final i0 b(long l2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l3 = timeUnit.toMinutes(l2);
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        long l4 = timeUnit.toSeconds(l2 - timeUnit2.toMillis(l3));
        long l5 = l2 - timeUnit2.toMillis(l3) - TimeUnit.SECONDS.toMillis(l4);
        i0 i02 = new i0(l3, l4, l5);
        return i02;
    }
}

