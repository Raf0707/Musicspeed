/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.fragment.app.d
 *  com.smp.musicspeed.recorder.x
 *  f.z.d.k
 *  i.a.c
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package com.smp.musicspeed.recorder;

import android.content.Context;
import androidx.fragment.app.d;
import com.smp.musicspeed.recorder.x;
import f.z.d.k;
import i.a.c;
import java.util.Arrays;

public final class y {
    private static final String[] a = new String[]{"android.permission.RECORD_AUDIO"};

    public static final void a(x x2) {
        k.g((Object)x2, (String)"<this>");
        d d2 = x2.requireActivity();
        Object[] arrobject = a;
        if (c.b((Context)d2, (String[])((String[])Arrays.copyOf((Object[])arrobject, (int)arrobject.length)))) {
            x2.X();
            return;
        }
        x2.requestPermissions((String[])arrobject, 6);
    }

    public static final void b(x x2, int n2, int[] arrn) {
        k.g((Object)x2, (String)"<this>");
        k.g((Object)arrn, (String)"grantResults");
        if (n2 == 6 && c.f((int[])Arrays.copyOf((int[])arrn, (int)arrn.length))) {
            x2.X();
        }
    }
}

