/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.GridLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.RecyclerView$z
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.smp.musicspeed.library.album;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.album.e;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.t;
import f.z.d.g;
import f.z.d.k;
import f.z.d.l;
import java.util.Objects;

public class f
extends p<Album, e.a, e> {
    public static final a r = new Object(null){
        {
            this();
        }
    };
    private final f.f s = f.g.a(new f.z.c.a<Integer>(){

        public final int a() {
            int n2 = t.T((Activity)this.getActivity()) / 140;
            if (n2 < 2) {
                n2 = 2;
            }
            return n2;
        }
    });

    @Override
    public RecyclerView.o A() {
        return new GridLayoutManager((Context)this.getActivity(), this.j0());
    }

    @Override
    protected int F() {
        return 2131820814;
    }

    @Override
    protected g.b G() {
        return g.b.g;
    }

    @Override
    public int K() {
        return 2131492968;
    }

    @Override
    protected void e0() {
        super.e0();
        RecyclerView.n n2 = new RecyclerView.n(this.j0(), (int)t.b(this.getContext(), 4.0f), false){
            private final int a;
            private final int b;
            private final boolean c;
            {
                k.g(f.this, "this$0");
                this.a = n2;
                this.b = n3;
                this.c = bl;
            }

            public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z z2) {
                k.g((Object)rect, "outRect");
                k.g((Object)view, "view");
                k.g((Object)recyclerView, "parent");
                k.g((Object)z2, "state");
                int n2 = recyclerView.j0(view);
                int n3 = n2 % this.a;
                if (t.E(f.this.getContext())) {
                    if (this.c) {
                        int n4 = this.b;
                        int n5 = n3 * n4;
                        int n6 = this.a;
                        rect.right = n4 - n5 / n6;
                        rect.left = n4 * (n3 + 1) / n6;
                        if (n2 < n6) {
                            rect.top = n4;
                        }
                        rect.bottom = n4;
                        return;
                    }
                    int n7 = this.b;
                    int n8 = n3 * n7;
                    int n9 = this.a;
                    rect.right = n8 / n9;
                    rect.left = n7 - n7 * (n3 + 1) / n9;
                    if (n2 >= n9) {
                        rect.top = n7;
                        return;
                    }
                } else {
                    if (this.c) {
                        int n10 = this.b;
                        int n11 = n3 * n10;
                        int n12 = this.a;
                        rect.left = n10 - n11 / n12;
                        rect.right = n10 * (n3 + 1) / n12;
                        if (n2 < n12) {
                            rect.top = n10;
                        }
                        rect.bottom = n10;
                        return;
                    }
                    int n13 = this.b;
                    int n14 = n3 * n13;
                    int n15 = this.a;
                    rect.left = n14 / n15;
                    rect.right = n13 - n13 * (n3 + 1) / n15;
                    if (n2 >= n15) {
                        rect.top = n13;
                    }
                }
            }
        };
        this.h.k(n2);
    }

    protected e i0() {
        d d2 = this.getActivity();
        Objects.requireNonNull((Object)d2, (String)"null cannot be cast to non-null type android.content.Context");
        return new e((Context)d2, this, this);
    }

    public final int j0() {
        return ((Number)this.s.getValue()).intValue();
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        k.g((Object)menu, "menu");
        k.g((Object)menuInflater, "inflater");
        menuInflater.inflate(2131558421, menu);
        if (AppPrefs.k.D()) {
            menu.removeItem(2131296356);
        }
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        String string = com.smp.musicspeed.utils.k.w(context, this.G().ordinal());
        if (k.c(string, "album_key")) {
            menu.findItem(2131296373).setChecked(true);
        } else if (k.c(string, "album_key DESC")) {
            menu.findItem(2131296374).setChecked(true);
        }
        Fragment.super.onCreateOptionsMenu(menu, menuInflater);
    }

}

