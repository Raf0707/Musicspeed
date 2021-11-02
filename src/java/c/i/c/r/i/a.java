/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 */
package c.i.c.r.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.g;
import c.i.a.l;
import c.i.a.p;

public interface a<T, VH extends RecyclerView.c0>
extends l<T, VH>,
g<T, a>,
p<a, a> {
    @Override
    public boolean a();

    @Override
    public boolean b();

    public int d();

    @Override
    public boolean isEnabled();

    public View o(Context var1, ViewGroup var2);
}

