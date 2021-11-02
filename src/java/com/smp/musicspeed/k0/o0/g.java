/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  androidx.recyclerview.widget.RecyclerView
 *  com.smp.musicspeed.k0.o0.p
 *  java.lang.Object
 */
package com.smp.musicspeed.k0.o0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.k0.o0.p;

public final class g
implements View.OnScrollChangeListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public /* synthetic */ g(RecyclerView recyclerView, View view, View view2) {
        this.a = recyclerView;
        this.b = view;
        this.c = view2;
    }

    public final void onScrollChange(View view, int n2, int n3, int n4, int n5) {
        p.P((RecyclerView)this.a, (View)this.b, (View)this.c, (View)view, (int)n2, (int)n3, (int)n4, (int)n5);
    }
}

