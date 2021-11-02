/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package b.j.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.j.a.a;

public abstract class c
extends a {
    private int n;
    private int o;
    private LayoutInflater p;

    @Deprecated
    public c(Context context, int n2, Cursor cursor, boolean bl) {
        super(context, cursor, bl);
        this.o = n2;
        this.n = n2;
        this.p = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    @Override
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.p.inflate(this.o, viewGroup, false);
    }

    @Override
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.p.inflate(this.n, viewGroup, false);
    }
}

