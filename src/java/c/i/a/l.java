/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 *  java.util.List
 */
package c.i.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.j;
import java.util.List;

public interface l<T, VH extends RecyclerView.c0>
extends j<T> {
    public boolean a();

    public boolean b();

    public void f(VH var1);

    public boolean g(VH var1);

    public int getType();

    public void i(VH var1);

    public boolean isEnabled();

    public T k(boolean var1);

    public void m(VH var1, List<Object> var2);

    public VH n(ViewGroup var1);

    public void p(VH var1);
}

