/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  com.smp.musicspeed.k0.n
 *  com.smp.musicspeed.k0.o$b
 *  i.a.b
 *  i.a.c
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import com.smp.musicspeed.k0.n;
import com.smp.musicspeed.k0.o;
import i.a.c;

/*
 * Exception performing whole class analysis.
 */
final class o {
    private static final String[] a;

    static {
        a = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    static /* synthetic */ String[] a() {
        return a;
    }

    static void b(n n2) {
        String[] arrstring;
        d d2 = n2.requireActivity();
        if (c.b((Context)d2, (String[])(arrstring = a))) {
            n2.w();
            return;
        }
        if (c.e((Fragment)n2, (String[])arrstring)) {
            n2.F((i.a.b)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        n2.requestPermissions(arrstring, 0);
    }

    static void c(n n2, int n3, int[] arrn) {
        if (n3 != 0) {
            return;
        }
        if (c.f((int[])arrn)) {
            n2.w();
            return;
        }
        n2.D();
    }

}

