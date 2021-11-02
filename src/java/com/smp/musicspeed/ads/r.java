/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.smp.musicspeed.ads.r$b$a
 *  com.smp.musicspeed.ads.r$c
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  kotlinx.coroutines.b3.j
 *  kotlinx.coroutines.b3.m
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.ads;

import android.content.Context;
import com.smp.musicspeed.ads.r;
import com.smp.musicspeed.ads.s;
import com.smp.musicspeed.utils.m;
import f.w.d;
import f.z.c.l;
import f.z.c.p;
import f.z.d.g;
import f.z.d.k;
import kotlinx.coroutines.b3.j;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class r
implements k0 {
    public static final b f = new b(null);
    private final /* synthetic */ k0 g;
    private final Context h;
    private final j<s> i;
    private boolean j;

    private r(Context context) {
        this.g = l0.b();
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, "ctx.applicationContext");
        this.h = context2;
        this.i = kotlinx.coroutines.b3.m.b((int)0, null, null, (int)6, null);
    }

    public /* synthetic */ r(Context context, g g2) {
        this(context);
    }

    public static final /* synthetic */ Context a(r r2) {
        return r2.h;
    }

    public f.w.g L() {
        return this.g.L();
    }

    public final j<s> b() {
        return this.i;
    }

    public final void c() {
        if (this.j) {
            return;
        }
        this.j = true;
        e.d((k0)this, null, null, (p)new c(this, null), (int)3, null);
    }

    public static final class b
    extends m<r, Context> {
        private b() {
            super(a.n);
        }

        public /* synthetic */ b(g g2) {
            this();
        }
    }

}

