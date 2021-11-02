/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.smp.musicspeed.e.g.I$a
 *  com.smp.musicspeed.e.g.I$b
 *  com.smp.musicspeed.e.g.I$c
 *  com.smp.musicspeed.e.g.I$d
 *  com.smp.musicspeed.e.g.I$e
 *  com.smp.musicspeed.e.g.I$f
 *  com.smp.musicspeed.e.g.I$g
 *  com.smp.musicspeed.e.g.I$h
 *  com.smp.musicspeed.e.g.I$i
 *  com.smp.musicspeed.e.g.I$j
 *  com.smp.musicspeed.e.g.I$k
 *  com.smp.musicspeed.utils.t
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.e.g;

import android.content.Context;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.utils.t;

/*
 * Exception performing whole class analysis.
 */
public abstract class I
extends Enum<I> {
    private static final /* synthetic */ I[] $VALUES;
    public static final /* enum */ I a;
    public static final /* enum */ I b;
    public static final /* enum */ I c;
    public static final /* enum */ I d;
    public static final /* enum */ I e;
    public static final /* enum */ I f;
    public static final /* enum */ I g;
    public static final /* enum */ I h;
    public static final /* enum */ I i;
    public static final /* enum */ I j;
    public static final /* enum */ I k;

    static {
        a = new /* Unavailable Anonymous Inner Class!! */;
        b = new /* Unavailable Anonymous Inner Class!! */;
        c = new /* Unavailable Anonymous Inner Class!! */;
        d = new /* Unavailable Anonymous Inner Class!! */;
        e = new /* Unavailable Anonymous Inner Class!! */;
        f = new /* Unavailable Anonymous Inner Class!! */;
        g = new /* Unavailable Anonymous Inner Class!! */;
        h = new /* Unavailable Anonymous Inner Class!! */;
        i = new /* Unavailable Anonymous Inner Class!! */;
        j = new /* Unavailable Anonymous Inner Class!! */;
        k = new /* Unavailable Anonymous Inner Class!! */;
        $VALUES = arri = new I[]{I.a, I.b, I.c, I.d, I.e, I.f, I.g, I.h, I.i, I.j, I.k};
    }

    private I() {
    }

    public /* synthetic */ I(String string, int n2, f.z.d.g g2) {
        this();
    }

    public static I valueOf(String string) {
        return (I)Enum.valueOf(I.class, (String)string);
    }

    public static I[] values() {
        return (I[])$VALUES.clone();
    }

    public abstract int defaultResource(Context var1);

    public final int defaultResourceLargeAlbum(Context context) {
        f.z.d.k.g((Object)context, (String)"context");
        if (t.w((Context)context)) {
            return 2131230863;
        }
        return 2131230864;
    }
}

