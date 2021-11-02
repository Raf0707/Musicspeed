/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.view.ViewGroup
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.o
 *  java.lang.Object
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.o;
import com.smp.musicspeed.k0.p;
import f.z.d.k;

public abstract class q
extends o {
    private final Context h;
    private final SparseArray<p<?, ?, ?>> i;

    public q(Context context, FragmentManager fragmentManager) {
        k.g((Object)context, "mContext");
        k.g((Object)fragmentManager, "fm");
        super(fragmentManager);
        this.h = context;
        this.i = new SparseArray();
    }

    public void a(ViewGroup viewGroup, int n2, Object object) {
        k.g((Object)viewGroup, "container");
        k.g(object, "object");
        this.i.remove(n2);
        super.a(viewGroup, n2, object);
    }

    public Object g(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "container");
        p p2 = (p)super.g(viewGroup, n2);
        this.i.put(n2, (Object)p2);
        return p2;
    }

    public final Context t() {
        return this.h;
    }

    public final p<?, ?, ?> u(int n2) {
        return (p)this.i.get(n2);
    }
}

