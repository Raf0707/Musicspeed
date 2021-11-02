/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  c.a.a.b
 *  c.a.a.b$a
 *  java.lang.Object
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.b;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.k0.w;
import f.z.d.k;

public abstract class d0<MT extends e, VH extends RecyclerView.c0, AT extends m<VH, MT>>
extends w<MT, VH, AT> {
    @Override
    public void onActivityCreated(Bundle bundle) {
        p.super.onActivityCreated(bundle);
    }

    public void onAttach(Context context) {
        k.g((Object)context, "context");
        Fragment.super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        p.super.onDestroyView();
        b.b.a();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        p.super.onViewCreated(view, bundle);
        b.b.a();
    }
}

