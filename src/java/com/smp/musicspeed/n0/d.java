/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.n0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import com.smp.musicspeed.n0.b;
import com.smp.musicspeed.n0.e;
import com.smp.musicspeed.utils.o;
import f.f;
import f.z.d.g;
import f.z.d.k;
import f.z.d.l;

public final class d
extends c {
    private final f v = f.g.a(new f.z.c.a<String>(){

        public final String a() {
            String string = this.requireArguments().getString("path");
            if (string == null) {
                string = "";
            }
            return string;
        }
    });

    public static /* synthetic */ void O(d d2, DialogInterface dialogInterface, int n2) {
        d.P(d2, dialogInterface, n2);
    }

    private static final void P(d d2, DialogInterface dialogInterface, int n2) {
        k.g((Object)d2, "this$0");
        Context context = d2.requireContext();
        k.f((Object)context, "requireContext()");
        e e2 = new e(context, d2.N(), 0, 4, null);
        androidx.fragment.app.d d3 = d2.requireActivity();
        k.f((Object)d3, "requireActivity()");
        e2.j((Activity)d3);
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        androidx.fragment.app.d d3 = this.requireActivity();
        k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3));
        LayoutInflater layoutInflater = this.requireActivity().getLayoutInflater();
        k.f((Object)layoutInflater, "requireActivity().layoutInflater");
        a2.u(layoutInflater.inflate(2131492947, null)).t((CharSequence)this.requireActivity().getString(2131820793)).o(17039370, (DialogInterface.OnClickListener)new b(this)).j(17039360, null);
        androidx.appcompat.app.d d4 = a2.a();
        k.f((Object)d4, "builder.create()");
        return d4;
    }

    public final String N() {
        return (String)this.v.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        Fragment.super.onViewCreated(view, bundle);
    }

}

