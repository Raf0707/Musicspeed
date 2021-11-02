/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  com.smp.musicspeed.ads.m
 *  com.smp.musicspeed.folders.s
 *  com.smp.musicspeed.utils.t
 *  f.d0.g
 *  f.z.d.k
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Random
 */
package com.smp.musicspeed;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.ads.m;
import com.smp.musicspeed.folders.s;
import com.smp.musicspeed.utils.t;
import f.d0.g;
import f.z.d.k;
import java.util.Random;

public final class c0 {
    public static final m a(Activity activity, RecyclerView.i i2, RecyclerView.g<RecyclerView.c0> g2, boolean bl, int n2, boolean bl2) {
        k.g((Object)activity, (String)"activity");
        k.g((Object)i2, (String)"observer");
        k.g(g2, (String)"adapter");
        int n3 = 1 + (int)Math.ceil((double)((t.M((Context)activity, (int)Math.max((int)t.R((Context)activity), (int)t.S((Activity)activity))) - (float)168) / (float)72));
        new Random();
        g.b((int)n3, (int)8);
        m m2 = new m(activity, g2, 0, n3, bl2);
        return m2;
    }

    public static /* synthetic */ m b(Activity activity, RecyclerView.i i2, RecyclerView.g g2, boolean bl, int n2, boolean bl2, int n3, Object object) {
        boolean bl3 = (n3 & 8) != 0 ? false : bl;
        int n4 = (n3 & 16) != 0 ? -1 : n2;
        boolean bl4 = (n3 & 32) != 0 ? true : bl2;
        return c0.a(activity, i2, (RecyclerView.g<RecyclerView.c0>)g2, bl3, n4, bl4);
    }

    public static final m c(Activity activity, RecyclerView.i i2, s s2, int n2) {
        k.g((Object)activity, (String)"activity");
        k.g((Object)i2, (String)"observer");
        k.g((Object)s2, (String)"adapter");
        return c0.b(activity, i2, (RecyclerView.g)s2, true, n2, false, 32, null);
    }
}

