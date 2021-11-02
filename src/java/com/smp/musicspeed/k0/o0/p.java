/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.view.ViewGroup
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$o
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Objects
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.k0.o0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.l0.e;
import com.smp.musicspeed.k0.m0.h;
import com.smp.musicspeed.k0.o0.f;
import com.smp.musicspeed.k0.o0.g;
import com.smp.musicspeed.k0.o0.j;
import com.smp.musicspeed.k0.o0.n;
import com.smp.musicspeed.k0.o0.p;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.utils.o;
import f.z.d.k;
import java.util.List;
import java.util.Objects;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;

public final class p
extends androidx.fragment.app.c {
    public static final a v = new Object(null){
        {
            this();
        }

        public final p a(List<MediaTrack> list) {
            k.g(list, "items");
            p p2 = new p();
            Bundle bundle = new Bundle();
            Object[] arrobject = list.toArray((Object[])new MediaTrack[0]);
            Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
            bundle.putParcelableArray("tracks", (Parcelable[])arrobject);
            p2.setArguments(bundle);
            return p2;
        }
    };
    private final f.f w = f.g.a(new f.z.c.a<MediaTrack[]>(this){
        final /* synthetic */ p g;
        {
            this.g = p2;
            super(0);
        }

        public final MediaTrack[] a() {
            Bundle bundle = this.g.getArguments();
            Parcelable[] arrparcelable = bundle == null ? null : bundle.getParcelableArray("tracks");
            Objects.requireNonNull((Object)arrparcelable, (String)"null cannot be cast to non-null type kotlin.Array<com.smp.musicspeed.dbrecord.MediaTrack>");
            return (MediaTrack[])arrparcelable;
        }
    });

    public static /* synthetic */ void O(DialogInterface dialogInterface, int n2) {
        p.R(dialogInterface, n2);
    }

    public static /* synthetic */ void P(RecyclerView recyclerView, View view, View view2, View view3, int n2, int n3, int n4, int n5) {
        p.Q(recyclerView, view, view2, view3, n2, n3, n4, n5);
    }

    private static final void Q(RecyclerView recyclerView, View view, View view2, View view3, int n2, int n3, int n4, int n5) {
        if (recyclerView.canScrollVertically(-1)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
        if (recyclerView.canScrollVertically(1)) {
            view2.setVisibility(0);
            return;
        }
        view2.setVisibility(4);
    }

    private static final void R(DialogInterface dialogInterface, int n2) {
    }

    public Dialog B(Bundle bundle) {
        d d2 = this.requireActivity();
        d d3 = this.requireActivity();
        k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3));
        LayoutInflater layoutInflater = this.requireActivity().getLayoutInflater();
        k.f((Object)layoutInflater, "requireActivity().layoutInflater");
        View view = layoutInflater.inflate(2131492948, null);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(2131297034);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this.getActivity());
        d d4 = this.requireActivity();
        k.f((Object)d4, "requireActivity()");
        n n2 = new n((Context)d4);
        View view2 = view.findViewById(2131296648);
        View view3 = view.findViewById(2131296645);
        recyclerView.setLayoutManager((RecyclerView.o)linearLayoutManager);
        recyclerView.setAdapter((RecyclerView.g)n2);
        recyclerView.setNestedScrollingEnabled(false);
        if (Build.VERSION.SDK_INT >= 23) {
            recyclerView.setOnScrollChangeListener((View.OnScrollChangeListener)new g(recyclerView, view2, view3));
        }
        a2.u(view).t((CharSequence)this.requireActivity().getString(2131820774)).j(17039360, (DialogInterface.OnClickListener)f.f);
        androidx.appcompat.app.d d5 = a2.a();
        k.f((Object)d5, "builder.create()");
        return d5;
    }

    public final MediaTrack[] N() {
        return (MediaTrack[])this.w.getValue();
    }

    public void onAttach(Context context) {
        k.g((Object)context, "activity");
        super.onAttach(context);
    }

    public void onDestroy() {
        Fragment.super.onDestroy();
    }

    @m(threadMode=ThreadMode.MAIN)
    public final void onEvent(e e2) {
        k.g(e2, "event");
        j.w.a(this.N()).M(this.requireActivity().R(), "NewPlaylistDialogFragment");
        this.w();
    }

    @m(threadMode=ThreadMode.MAIN)
    public final void onEvent(com.smp.musicspeed.k0.l0.f f2) {
        k.g(f2, "event");
        Playlist playlist = f2.a();
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        com.smp.musicspeed.k0.m0.f.b(context, f.u.f.r(this.N()), playlist.getPlaylistId(), playlist.getPlaylistName(), false, 16, null);
        Context context2 = this.requireContext();
        k.f((Object)context2, "requireContext()");
        h.a(context2);
        this.w();
    }

    public void onPause() {
        Fragment.super.onPause();
        c.d().v((Object)this);
    }

    public void onResume() {
        c.d().r((Object)this);
        Fragment.super.onResume();
    }

}

