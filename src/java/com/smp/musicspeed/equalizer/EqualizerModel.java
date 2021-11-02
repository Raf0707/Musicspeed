/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  c.c.a.a
 *  c.c.a.d
 *  c.c.a.f
 *  c.c.a.j.a
 *  com.smp.musicspeed.equalizer.EqualizerModel$a
 *  f.e0.g
 *  f.z.d.o
 *  f.z.d.p
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.equalizer;

import androidx.lifecycle.LiveData;
import c.c.a.f;
import com.smp.musicspeed.equalizer.EqualizerModel;
import f.b0.d;
import f.e0.c;
import f.e0.i;
import f.z.d.g;
import f.z.d.o;
import f.z.d.p;
import f.z.d.z;

public final class EqualizerModel
extends c.c.a.d {
    public static final EqualizerModel k;
    static final /* synthetic */ i<Object>[] l;
    private static final d m;
    private static final LiveData<Boolean> n;

    static {
        EqualizerModel equalizerModel;
        i[] arri = new i[]{z.e((o)new p((c)z.b(EqualizerModel.class), "equalizerExpanded", "getEqualizerExpanded()Z"))};
        l = arri;
        k = equalizerModel = new EqualizerModel();
        m = c.c.a.d.c((c.c.a.d)equalizerModel, (boolean)true, null, (boolean)false, (int)6, null).g((c.c.a.d)equalizerModel, arri[0]);
        n = c.c.a.j.a.a((c.c.a.d)equalizerModel, (f.e0.g)new a((Object)equalizerModel));
    }

    private EqualizerModel() {
        super(null, null, 3, null);
    }

    public final LiveData<Boolean> A() {
        return n;
    }

    public final void B(boolean bl) {
        m.b(this, l[0], bl);
    }

    public final boolean z() {
        return (Boolean)m.a(this, l[0]);
    }
}

