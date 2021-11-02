/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.i
 *  com.bumptech.glide.load.n.d
 *  com.bumptech.glide.load.p.n
 *  com.bumptech.glide.load.p.n$a
 *  com.bumptech.glide.load.p.o
 *  com.bumptech.glide.load.p.r
 *  com.bumptech.glide.s.d
 *  java.io.InputStream
 *  java.lang.Object
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.p.n;
import com.bumptech.glide.load.p.o;
import com.bumptech.glide.load.p.r;
import com.bumptech.glide.s.d;
import com.smp.musicspeed.playingqueue.i;
import com.smp.musicspeed.playingqueue.j;
import java.io.InputStream;

public final class k
implements n<i, InputStream> {
    private final Context a;

    public k(Context context) {
        f.z.d.k.g((Object)context, "context");
        Context context2 = context.getApplicationContext();
        f.z.d.k.f((Object)context2, "context.applicationContext");
        this.a = context2;
    }

    public n.a<InputStream> c(i i2, int n2, int n3, com.bumptech.glide.load.i i3) {
        f.z.d.k.g(i2, "model");
        f.z.d.k.g((Object)i3, "options");
        return new n.a((g)new d((Object)i2), (com.bumptech.glide.load.n.d)new j(this.a, i2));
    }

    public boolean d(i i2) {
        f.z.d.k.g(i2, "model");
        return true;
    }

    public static final class a
    implements o<i, InputStream> {
        private final Context a;

        public a(Context context) {
            f.z.d.k.g((Object)context, "context");
            Context context2 = context.getApplicationContext();
            f.z.d.k.f((Object)context2, "context.applicationContext");
            this.a = context2;
        }

        public n<i, InputStream> b(r r2) {
            f.z.d.k.g((Object)r2, "multiFactory");
            return new k(this.a);
        }
    }

}

