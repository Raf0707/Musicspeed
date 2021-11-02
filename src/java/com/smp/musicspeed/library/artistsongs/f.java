/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$o
 *  androidx.recyclerview.widget.g
 *  b.i.h.a
 *  b.i.q.w
 *  com.smp.musicspeed.k0.h0.k
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.smp.musicspeed.library.artistsongs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import com.smp.musicspeed.k0.h0.k;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.album.e;
import com.smp.musicspeed.library.artistsongs.e;
import f.z.d.g;
import f.z.d.l;
import java.util.Objects;

public final class f
extends p<Album, e.a, com.smp.musicspeed.library.album.e> {
    public static final a r = new Object(null){
        {
            this();
        }

        public final f a(long l2) {
            f f2 = new f();
            Bundle bundle = new Bundle();
            bundle.putLong("artistId", l2);
            f2.setArguments(bundle);
            return f2;
        }
    };
    private final f.f s = f.g.a(new f.z.c.a<Long>(){

        public final long a() {
            Bundle bundle = this.getArguments();
            if (bundle == null) {
                return -1L;
            }
            return bundle.getLong("artistId");
        }
    });

    @Override
    public RecyclerView.o A() {
        return new LinearLayoutManager((Context)this.requireActivity(), 0, false);
    }

    @Override
    protected int F() {
        return 2131820814;
    }

    @Override
    protected g.b G() {
        return g.b.n;
    }

    @Override
    public int K() {
        return 2131492960;
    }

    @Override
    protected void e0() {
        super.e0();
        androidx.recyclerview.widget.g g2 = new androidx.recyclerview.widget.g(this.h.getContext(), 0);
        Drawable drawable = b.i.h.a.e((Context)this.requireContext(), (int)2131230879);
        if (drawable != null) {
            g2.n(drawable);
        }
        this.h.k((RecyclerView.n)g2);
    }

    @Override
    public void h(View view, int n2) {
        f.z.d.k.g((Object)view, "v");
        Fragment fragment = this.getParentFragment();
        Objects.requireNonNull((Object)fragment, (String)"null cannot be cast to non-null type com.smp.musicspeed.library.albumsongs.ArtistSongsFragment");
        if (((k)fragment).U() == 0) {
            super.m(view, n2);
        }
    }

    protected e i0() {
        d d2 = this.getActivity();
        Objects.requireNonNull((Object)d2, (String)"null cannot be cast to non-null type android.content.Context");
        return new e((Context)d2, this);
    }

    public final long j0() {
        return ((Number)this.s.getValue()).longValue();
    }

    @Override
    public void m(View view, int n2) {
        f.z.d.k.g((Object)view, "v");
        Fragment fragment = this.getParentFragment();
        Objects.requireNonNull((Object)fragment, (String)"null cannot be cast to non-null type com.smp.musicspeed.library.albumsongs.ArtistSongsFragment");
        if (((k)fragment).U() == 0) {
            super.m(view, n2);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.k.g((Object)view, "view");
        g.a a2 = com.smp.musicspeed.k0.m0.g.a;
        Context context = this.requireContext();
        f.z.d.k.f((Object)context, "requireContext()");
        com.smp.musicspeed.k0.m0.g g2 = (com.smp.musicspeed.k0.m0.g)a2.a(context);
        boolean bl = g2.d() == this.j0();
        this.q = bl;
        g2.z(this.j0());
        super.onViewCreated(view, bundle);
        this.q = true;
        w.F0((View)this.h, (boolean)false);
    }

}

