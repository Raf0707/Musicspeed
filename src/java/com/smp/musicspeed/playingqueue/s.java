/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.drawable.NinePatchDrawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewPropertyAnimator
 *  android.widget.ImageView
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$o
 *  b.i.h.a
 *  java.lang.Object
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.playingqueue;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.c.d;
import c.f.a.a.a.d.a;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.j0.f;
import com.smp.musicspeed.player.m;
import com.smp.musicspeed.playingqueue.LinearLayoutManagerWrapper;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.playingqueue.a0;
import com.smp.musicspeed.playingqueue.b0;
import com.smp.musicspeed.playingqueue.c0;
import com.smp.musicspeed.playingqueue.e;
import com.smp.musicspeed.playingqueue.h;
import com.smp.musicspeed.playingqueue.p;
import com.smp.musicspeed.playingqueue.u;
import com.smp.musicspeed.playingqueue.z;
import com.smp.musicspeed.utils.k;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;

public class s
extends Fragment {
    private RecyclerView f;
    private LinearLayoutManager g;
    private RecyclerView.g h;
    private RecyclerView.g i;
    private d j;
    private c.f.a.a.a.b.k k;
    private a l;

    private /* synthetic */ boolean u(View view, MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return false;
                }
            } else {
                this.f.setNestedScrollingEnabled(false);
                return false;
            }
        }
        this.f.setNestedScrollingEnabled(true);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131492974, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        RecyclerView recyclerView;
        d d2;
        a a2;
        RecyclerView.g g2;
        c.d().v((Object)this);
        c.f.a.a.a.b.k k2 = this.k;
        if (k2 != null) {
            k2.L();
            this.k = null;
        }
        if ((d2 = this.j) != null) {
            d2.D();
            this.j = null;
        }
        if ((a2 = this.l) != null) {
            a2.i();
            this.l = null;
        }
        if ((recyclerView = this.f) != null) {
            recyclerView.setItemAnimator(null);
            this.f.setAdapter(null);
            this.f = null;
        }
        if ((g2 = this.i) != null) {
            c.f.a.a.a.e.e.b(g2);
            this.i = null;
        }
        this.h = null;
        this.g = null;
        super.onDestroyView();
    }

    @org.greenrobot.eventbus.m(sticky=true, threadMode=ThreadMode.MAIN_ORDERED)
    public void onEvent(f f2) {
        c.d().t((Object)f2);
        ((u)this.h).B(f2.a(), f2.b(), true);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(m m2) {
        int n2 = PlayingQueue.getDefault().getCurrentlyPlaying();
        this.h.notifyItemChanged(n2);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(a0 a02) {
        Context context = this.getContext();
        if (context == null) {
            return;
        }
        if (k.D(context) && !a02.a) {
            return;
        }
        int n2 = PlayingQueue.getDefault().getCurrentlyPlaying();
        this.f.D1();
        this.g.H2(n2, 0);
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(b0 b02) {
        ((u)this.h).F();
    }

    @org.greenrobot.eventbus.m(sticky=true, threadMode=ThreadMode.MAIN)
    public void onEvent(c0 c02) {
        c.d().t((Object)c02);
        c.d().m((Object)new com.smp.musicspeed.k0.l0.c());
        ((u)this.h).s();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(p p2) {
        View view;
        int n2 = p2.a;
        int n3 = p2.b;
        View view2 = this.g.D(n2);
        if (view2 != null) {
            ImageView imageView = (ImageView)view2.findViewById(2131296758);
            View view3 = view2.findViewById(2131297300);
            if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setAlpha(0.01f);
                imageView.animate().alpha(1.0f).setDuration(400L);
            }
            if (view3 != null) {
                view3.setVisibility(8);
            }
        } else {
            this.h.notifyItemChanged(n2);
        }
        if ((view = this.g.D(n3)) != null) {
            ImageView imageView = (ImageView)view.findViewById(2131296758);
            View view4 = view.findViewById(2131297300);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (view4 != null) {
                view4.setVisibility(0);
                return;
            }
        } else {
            this.h.notifyItemChanged(n3);
        }
    }

    @org.greenrobot.eventbus.m(sticky=true, threadMode=ThreadMode.MAIN)
    public void onEvent(z z2) {
        c.d().t((Object)z2);
        ((u)this.h).r();
    }

    public void onPause() {
        this.k.c();
        super.onPause();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public void onViewCreated(View view, Bundle bundle) {
        RecyclerView.g g2;
        c.f.a.a.a.b.k k2;
        a a2;
        RecyclerView recyclerView;
        super.onViewCreated(view, bundle);
        this.f = recyclerView = (RecyclerView)this.getView().findViewById(2131297063);
        recyclerView.setOnTouchListener((View.OnTouchListener)new e(this));
        this.g = new LinearLayoutManagerWrapper(this.getContext(), 1, false);
        this.l = a2 = new a();
        a2.k(true);
        this.l.j(true);
        this.k = k2 = new c.f.a.a.a.b.k();
        k2.S((NinePatchDrawable)b.i.h.a.e((Context)this.getContext(), (int)2131231057));
        this.j = new d();
        u u2 = new u((Context)this.getActivity(), this.t());
        this.h = u2;
        this.i = g2 = this.k.h(u2);
        this.i = this.j.h(g2);
        c.f.a.a.a.a.c c2 = new c.f.a.a.a.a.c();
        c2.R(false);
        this.f.setLayoutManager((RecyclerView.o)this.g);
        this.f.setAdapter(this.i);
        this.f.setItemAnimator((RecyclerView.l)c2);
        this.l.a(this.f);
        this.j.c(this.f);
        this.k.a(this.f);
        c.d().r((Object)this);
    }

    public h t() {
        return ((MainActivity)this.getActivity()).l2();
    }

    public /* synthetic */ boolean v(View view, MotionEvent motionEvent) {
        return this.u(view, motionEvent);
    }
}

