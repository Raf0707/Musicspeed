/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.j
 *  androidx.recyclerview.widget.j$f
 *  java.lang.Object
 */
package com.smp.musicspeed.m0;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import com.smp.musicspeed.m0.a;
import com.smp.musicspeed.m0.b;
import f.z.d.k;

public final class d
extends j.f {
    private final a d;

    public d(a a2) {
        k.g(a2, "mAdapter");
        this.d = a2;
    }

    public void A(RecyclerView.c0 c02, int n2) {
        if (c02 != null && n2 != 0) {
            ((b)c02).r();
        }
        super.A(c02, n2);
    }

    public void B(RecyclerView.c0 c02, int n2) {
        k.g((Object)c02, "viewHolder");
    }

    public void c(RecyclerView recyclerView, RecyclerView.c0 c02) {
        k.g((Object)recyclerView, "recyclerView");
        k.g((Object)c02, "viewHolder");
        super.c(recyclerView, c02);
        ((b)c02).l();
    }

    public int k(RecyclerView recyclerView, RecyclerView.c0 c02) {
        k.g((Object)recyclerView, "recyclerView");
        k.g((Object)c02, "viewHolder");
        return j.f.t((int)3, (int)0);
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return false;
    }

    public boolean y(RecyclerView recyclerView, RecyclerView.c0 c02, RecyclerView.c0 c03) {
        k.g((Object)recyclerView, "recyclerView");
        k.g((Object)c02, "source");
        k.g((Object)c03, "target");
        this.d.m(c02.getAdapterPosition(), c03.getAdapterPosition());
        return true;
    }
}

