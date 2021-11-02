/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.core.widget.ContentLoadingProgressBar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.fragment.app.x
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.i0
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  b.i.h.a
 *  com.google.android.material.bottomsheet.b
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.checkbox.MaterialCheckBox
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.x1
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.i0;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.smp.musicspeed.ads.e;
import com.smp.musicspeed.ads.f;
import com.smp.musicspeed.ads.g;
import com.smp.musicspeed.ads.h;
import com.smp.musicspeed.ads.i;
import com.smp.musicspeed.ads.j;
import com.smp.musicspeed.ads.u;
import com.smp.musicspeed.ads.v;
import com.smp.musicspeed.ads.w;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.i0.n;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import f.z.d.k;
import f.z.d.z;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

public final class u
extends com.google.android.material.bottomsheet.b
implements k0 {
    public static final a w = new Object(null){
        {
            this();
        }

        public final u a(boolean bl) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("withNoThankYou", bl);
            u u2 = new u();
            u2.setArguments(bundle);
            return u2;
        }
    };
    private final /* synthetic */ k0 x;
    private final f.f y;
    private final f.f z;

    public u() {
        this.x = l0.b();
        f.z.c.a<Fragment> a2 = new f.z.c.a<Fragment>((Fragment)this){
            final /* synthetic */ Fragment g;
            {
                this.g = fragment;
                super(0);
            }

            public final Fragment a() {
                return this.g;
            }
        };
        this.y = androidx.fragment.app.x.a((Fragment)this, (f.e0.b)z.b(v.class), (f.z.c.a)new f.z.c.a<i0>((f.z.c.a)a2){
            final /* synthetic */ f.z.c.a g;
            {
                this.g = a2;
                super(0);
            }

            public final i0 a() {
                i0 i02 = ((androidx.lifecycle.j0)this.g.invoke()).getViewModelStore();
                k.f((Object)i02, "ownerProducer().viewModelStore");
                return i02;
            }
        }, null);
        this.z = f.g.a(new f.z.c.a<Boolean>(this){
            final /* synthetic */ u g;
            {
                this.g = u2;
                super(0);
            }

            public final boolean a() {
                return this.g.requireArguments().getBoolean("withNoThankYou");
            }
        });
    }

    private final int R() {
        if (t.w(this.requireContext())) {
            return b.i.h.a.c((Context)this.requireContext(), (int)2131099740);
        }
        return b.i.h.a.c((Context)this.requireContext(), (int)2131099741);
    }

    private final int S() {
        Context context = this.requireContext();
        androidx.fragment.app.d d2 = this.requireActivity();
        k.f((Object)d2, "requireActivity()");
        return b.i.h.a.c((Context)context, (int)o.b((Context)d2));
    }

    private final boolean U() {
        return (Boolean)this.z.getValue();
    }

    public static /* synthetic */ void V(Dialog dialog, DialogInterface dialogInterface) {
        u.c0(dialog, dialogInterface);
    }

    public static /* synthetic */ void W(u u2, j j2) {
        u.m0(u2, j2);
    }

    public static /* synthetic */ void X(u u2, View view) {
        u.i0(u2, view);
    }

    public static /* synthetic */ void Y(u u2, View view) {
        u.h0(u2, view);
    }

    public static /* synthetic */ void Z(u u2, View view) {
        u.g0(u2, view);
    }

    public static /* synthetic */ void a0(u u2, View view) {
        u.f0(u2, view);
    }

    public static /* synthetic */ void b0(u u2, CompoundButton compoundButton, boolean bl) {
        u.k0(u2, compoundButton, bl);
    }

    private static final void c0(Dialog dialog, DialogInterface dialogInterface) {
        k.g((Object)dialog, "$dialog");
        n.a(dialog);
    }

    private final void d0() {
        try {
            com.smp.musicspeed.e0.a a2 = com.smp.musicspeed.e0.a.f;
            androidx.fragment.app.d d2 = this.requireActivity();
            k.f((Object)d2, "requireActivity()");
            a2.j((Activity)d2);
        }
        catch (Exception exception) {}
    }

    private final void e0() {
        View view;
        if (!this.U()) {
            View view2 = this.getView();
            View view3 = view2 == null ? null : view2.findViewById(d0.x);
            ((MaterialButton)view3).setVisibility(8);
        }
        View view4 = (view = this.getView()) == null ? null : view.findViewById(d0.r);
        ((AppCompatImageButton)view4).setOnClickListener((View.OnClickListener)new h(this));
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.A);
        ((MaterialButton)view6).setTextColor(this.S());
        View view7 = this.getView();
        View view8 = view7 == null ? null : view7.findViewById(d0.B);
        ((MaterialButton)view8).setTextColor(this.S());
        View view9 = this.getView();
        View view10 = view9 == null ? null : view9.findViewById(d0.x);
        ((MaterialButton)view10).setTextColor(this.S());
        View view11 = this.getView();
        View view12 = view11 == null ? null : view11.findViewById(d0.A);
        ((MaterialButton)view12).setOnClickListener((View.OnClickListener)new g(this));
        View view13 = this.getView();
        View view14 = view13 == null ? null : view13.findViewById(d0.x);
        ((MaterialButton)view14).setOnClickListener((View.OnClickListener)new f(this));
        View view15 = this.getView();
        View view16 = view15 == null ? null : view15.findViewById(d0.B);
        ((MaterialButton)view16).setOnClickListener((View.OnClickListener)new e(this));
    }

    private static final void f0(u u2, View view) {
        k.g((Object)u2, "this$0");
        u2.w();
    }

    private static final void g0(u u2, View view) {
        k.g((Object)u2, "this$0");
        u2.d0();
        u2.w();
    }

    private static final void h0(u u2, View view) {
        k.g((Object)u2, "this$0");
        String string = u2.getString(2131821353);
        k.f(string, "getString(R.string.toast_show_remove_ads_automatically)");
        Context context = u2.requireContext();
        k.f((Object)context, "requireContext()");
        com.smp.musicspeed.k0.z.m(string, context, 1);
        AppPrefs.k.M0(false);
        u2.w();
    }

    private static final void i0(u u2, View view) {
        k.g((Object)u2, "this$0");
        if (u2.T().f().a().f() == j.h) {
            AppPrefs.k.S0(true);
            w w2 = u2.T().f();
            androidx.fragment.app.d d2 = u2.requireActivity();
            k.f((Object)d2, "requireActivity()");
            w2.c((Activity)d2);
            u2.w();
            return;
        }
        String string = u2.getString(2131821306);
        k.f(string, "getString(R.string.toast_ad_not_loaded)");
        Context context = u2.requireContext();
        k.f((Object)context, "requireContext()");
        com.smp.musicspeed.k0.z.n(string, context, 0, 2, null);
    }

    private final void j0() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.K);
        ((MaterialCheckBox)view2).setChecked(AppPrefs.k.d0());
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.K);
        ((MaterialCheckBox)view4).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new i(this));
    }

    private static final void k0(u u2, CompoundButton compoundButton, boolean bl) {
        k.g((Object)u2, "this$0");
        AppPrefs.k.M0(bl);
        if (!bl) {
            String string = u2.getString(2131821353);
            k.f(string, "getString(R.string.toast_show_remove_ads_automatically)");
            Context context = u2.requireContext();
            k.f((Object)context, "requireContext()");
            com.smp.musicspeed.k0.z.m(string, context, 1);
        }
    }

    private final void l0() {
        this.T().f().a().i(this.getViewLifecycleOwner(), (x)new com.smp.musicspeed.ads.d(this));
    }

    private static final void m0(u u2, j j2) {
        k.g((Object)u2, "this$0");
        if (j2 == j.g) {
            View view = u2.getView();
            View view2 = view == null ? null : view.findViewById(d0.B);
            ((MaterialButton)view2).setEnabled(false);
            View view3 = u2.getView();
            View view4 = view3 == null ? null : view3.findViewById(d0.B);
            ((MaterialButton)view4).setTextColor(u2.R());
            View view5 = u2.getView();
            View view6 = view5 == null ? null : view5.findViewById(d0.a);
            ((ContentLoadingProgressBar)view6).c();
            return;
        }
        View view = u2.getView();
        View view7 = view == null ? null : view.findViewById(d0.B);
        ((MaterialButton)view7).setEnabled(true);
        View view8 = u2.getView();
        View view9 = view8 == null ? null : view8.findViewById(d0.B);
        ((MaterialButton)view9).setTextColor(u2.S());
        View view10 = u2.getView();
        View view11 = view10 == null ? null : view10.findViewById(d0.a);
        ((ContentLoadingProgressBar)view11).a();
    }

    public Dialog B(Bundle bundle) {
        Dialog dialog = super.B(bundle);
        k.f((Object)dialog, "super.onCreateDialog(savedInstanceState)");
        dialog.setOnShowListener((DialogInterface.OnShowListener)new com.smp.musicspeed.ads.c(dialog));
        return dialog;
    }

    public f.w.g L() {
        return this.x.L();
    }

    public final v T() {
        return (v)((Object)this.y.getValue());
    }

    public void onCreate(Bundle bundle) {
        androidx.fragment.app.c.super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.g((Object)layoutInflater, "inflater");
        View view = this.requireActivity().getLayoutInflater().inflate(2131492975, viewGroup, false);
        AppPrefs.k.L0(true);
        return view;
    }

    public void onDestroy() {
        Fragment.super.onDestroy();
        l0.d((k0)this, null, (int)1, null);
    }

    public void onDestroyView() {
        androidx.fragment.app.c.super.onDestroyView();
        x1.f((f.w.g)this.L(), null, (int)1, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        Fragment.super.onViewCreated(view, bundle);
        this.e0();
        this.j0();
        this.l0();
        View view2 = this.getView();
        View view3 = view2 == null ? null : view2.findViewById(d0.b);
        TextView textView = (TextView)view3;
        Object[] arrobject = new Object[]{this.getString(2131820673), 30};
        textView.setText((CharSequence)this.getString(2131821098, arrobject));
        View view4 = this.getView();
        View view5 = view4 == null ? null : view4.findViewById(d0.K);
        MaterialCheckBox materialCheckBox = (MaterialCheckBox)view5;
        Object[] arrobject2 = new Object[]{30};
        materialCheckBox.setText((CharSequence)this.getString(2131821099, arrobject2));
    }

}

