/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$o
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.r;
import com.smp.musicspeed.k0.w;
import com.smp.musicspeed.utils.AppPrefs;
import f.z.d.k;

public abstract class s
extends w<MediaTrack, r.a, r> {
    @Override
    public RecyclerView.o A() {
        return new LinearLayoutManager((Context)this.getActivity());
    }

    @Override
    public int K() {
        return 2131492968;
    }

    @Override
    public int i0() {
        return 72;
    }

    public abstract int j0();

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        k.g((Object)menu, "menu");
        k.g((Object)menuInflater, "inflater");
        menuInflater.inflate(this.j0(), menu);
        if (AppPrefs.k.D()) {
            menu.removeItem(2131296356);
        }
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        String string = com.smp.musicspeed.utils.k.w(context, this.G().ordinal());
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 1301476023: {
                if (!string.equals((Object)"date_modified DESC")) break;
                menu.findItem(2131296372).setChecked(true);
                this.a0(2131296372);
                break;
            }
            case -102326855: {
                if (!string.equals((Object)"title_key DESC")) break;
                menu.findItem(2131296374).setChecked(true);
                this.a0(2131296374);
                break;
            }
            case -825358278: {
                if (!string.equals((Object)"date_modified")) break;
                menu.findItem(2131296371).setChecked(true);
                this.a0(2131296371);
                break;
            }
            case -2135424008: {
                if (!string.equals((Object)"title_key")) break;
                menu.findItem(2131296373).setChecked(true);
                this.a0(2131296373);
            }
        }
        Fragment.super.onCreateOptionsMenu(menu, menuInflater);
    }
}

