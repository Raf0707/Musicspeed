/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.fragment.app.s
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.reverse;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.player.ElastiquePlayer;
import com.smp.musicspeed.reverse.ReverseService;
import com.smp.musicspeed.reverse.b;
import com.smp.musicspeed.utils.o;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class b
extends androidx.fragment.app.c {
    private IntentFilter A;
    private d B;
    private Handler v;
    private String w;
    private String x;
    private c y;
    private b z;

    public static b N(String string, String string2) {
        b b2 = new b();
        Bundle bundle = new Bundle();
        bundle.putString("com.smp.bundle.FILEPATH", string);
        bundle.putString("com.smp.bundle.ACTION", string2);
        b2.setArguments(bundle);
        return b2;
    }

    public Dialog B(Bundle bundle) {
        d d2;
        d.a a2 = new d.a((Context)this.requireActivity(), o.d((Context)this.requireActivity()));
        a2.u(this.getActivity().getLayoutInflater().inflate(2131492946, null));
        a2.g(2131820792);
        this.B = d2 = a2.a();
        return d2;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.y = context;
    }

    public void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        super.onCreate(bundle);
        this.w = this.getArguments().getString("com.smp.bundle.FILEPATH");
        this.x = this.getArguments().getString("com.smp.bundle.ACTION");
        this.z = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
            }
        };
        this.A = intentFilter = new IntentFilter("com.smp.ReverseService.ACTION_SEND_FILE_NAME");
        intentFilter.addAction("com.smp.ReverseService.ACTION_ERROR");
        this.A.addCategory("android.intent.category.DEFAULT");
        this.H(false);
        this.v = new Handler();
    }

    public void onDestroy() {
        Fragment.super.onDestroy();
    }

    @m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.reverse.a a2) {
        org.greenrobot.eventbus.c.d().s(com.smp.musicspeed.reverse.a.class);
        if (a2.a) {
            String string = a2.b;
            boolean bl = this.x.equals((Object)"com.smp.musicspeed.action.REVERSE");
            this.y.u(string, bl);
        } else {
            this.y.i();
        }
        if (MainActivity.F) {
            this.w();
            return;
        }
        this.getActivity().R().n().p((Fragment)this).j();
    }

    public void onPause() {
        Fragment.super.onPause();
    }

    public void onResume() {
        Fragment.super.onResume();
        if (!ReverseService.f) {
            if (ElastiquePlayer.a) {
                if ("com.smp.musicspeed.action.RESAMPLE".equals((Object)this.x)) {
                    ReverseService.e(this.getActivity().getApplicationContext(), this.w);
                    return;
                }
                if ("com.smp.musicspeed.action.REVERSE".equals((Object)this.x)) {
                    ReverseService.f(this.getActivity().getApplicationContext(), this.w);
                    return;
                }
            } else {
                this.x();
            }
        }
    }

    public void onStart() {
        super.onStart();
        org.greenrobot.eventbus.c.d().r((Object)this);
        com.smp.musicspeed.reverse.a a2 = (com.smp.musicspeed.reverse.a)org.greenrobot.eventbus.c.d().g(com.smp.musicspeed.reverse.a.class);
        if (a2 != null) {
            this.onEvent(a2);
        }
    }

    public void onStop() {
        super.onStop();
        org.greenrobot.eventbus.c.d().v((Object)this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Fragment.super.onViewCreated(view, bundle);
    }

}

