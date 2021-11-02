/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$o
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.library.playlists;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.o0.j;
import com.smp.musicspeed.k0.p;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.k0.w;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.library.playlists.f;
import com.smp.musicspeed.library.playlists.g;
import com.smp.musicspeed.library.playlists.h;
import com.smp.musicspeed.utils.AppPrefs;
import f.z.d.k;
import java.util.Objects;
import org.greenrobot.eventbus.ThreadMode;

public final class j
extends w<Playlist, g.a, g> {
    @Override
    public RecyclerView.o A() {
        return new LinearLayoutManager((Context)this.getActivity());
    }

    @Override
    protected int F() {
        return 2131820817;
    }

    @Override
    protected g.b G() {
        return g.b.j;
    }

    @Override
    protected boolean J() {
        return com.smp.musicspeed.utils.k.r() == 4 && k.c("play", "play");
    }

    @Override
    public int K() {
        return 2131492968;
    }

    @Override
    protected void e0() {
        super.e0();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public final void handleExportEvent(f f2) {
        k.g(f2, "event");
        d d2 = this.getActivity();
        if (d2 == null) {
            return;
        }
        h.d(d2, f2);
    }

    @Override
    public int i0() {
        return 72;
    }

    protected g j0() {
        d d2 = this.getActivity();
        Objects.requireNonNull((Object)d2, (String)"null cannot be cast to non-null type android.content.Context");
        return new g((Context)d2, this, this);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        p.super.onActivityCreated(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        k.g((Object)menu, "menu");
        k.g((Object)menuInflater, "inflater");
        menuInflater.inflate(2131558423, menu);
        if (AppPrefs.k.D()) {
            menu.removeItem(2131296356);
        }
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        String string = com.smp.musicspeed.utils.k.w(context, this.G().ordinal());
        if (k.c(string, "name")) {
            menu.findItem(2131296373).setChecked(true);
        } else if (k.c(string, "name DESC")) {
            menu.findItem(2131296374).setChecked(true);
        }
        Fragment.super.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        k.g((Object)menuItem, "item");
        if (menuItem.getItemId() == 2131296350) {
            com.smp.musicspeed.k0.o0.j.w.a(new MediaTrack[0]).M(this.requireActivity().R(), "NewPlaylistDialogFragment");
            return true;
        }
        return false;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        p.super.onViewCreated(view, bundle);
    }
}

