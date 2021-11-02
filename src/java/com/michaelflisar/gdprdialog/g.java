/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.appcompat.app.i
 *  androidx.appcompat.app.j
 *  androidx.core.app.a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$f
 *  com.google.android.material.bottomsheet.a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.michaelflisar.gdprdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.michaelflisar.gdprdialog.GDPRCustomTexts;
import com.michaelflisar.gdprdialog.GDPRSetup;
import com.michaelflisar.gdprdialog.g;
import com.michaelflisar.gdprdialog.h;
import com.michaelflisar.gdprdialog.k;
import com.michaelflisar.gdprdialog.l;
import com.michaelflisar.gdprdialog.m.j;

public class g
extends androidx.appcompat.app.j {
    public static String v = "ARG_PARENT_MUST_IMPLEMENT_CALLBACK";
    private boolean w;
    private j x;

    static /* synthetic */ j N(g g2) {
        return g2.x;
    }

    private View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view = layoutInflater.inflate(k.a, viewGroup, false);
        this.x.e((Activity)this.getActivity(), view, new com.michaelflisar.gdprdialog.a(this));
        return view;
    }

    private /* synthetic */ void P() {
        this.V();
    }

    private /* synthetic */ void R(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout)((com.google.android.material.bottomsheet.a)dialogInterface).findViewById(com.michaelflisar.gdprdialog.j.g);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.W((View)frameLayout);
        bottomSheetBehavior.r0(3);
        if (this.x.c().t()) {
            bottomSheetBehavior.n0(frameLayout.getMeasuredHeight());
            return;
        }
        bottomSheetBehavior.n0(0);
        bottomSheetBehavior.g0(new BottomSheetBehavior.f(this){
            final /* synthetic */ g a;
            {
                this.a = g2;
            }

            public void a(View view, float f2) {
            }

            public void b(View view, int n2) {
                if (n2 == 4) {
                    while (g.N(this.a).b() != 0) {
                        g.N(this.a).d();
                    }
                    this.a.w();
                }
            }
        });
    }

    public static g T(GDPRSetup gDPRSetup, h h2) {
        return g.U(gDPRSetup, h2, true);
    }

    public static g U(GDPRSetup gDPRSetup, h h2, boolean bl) {
        g g2 = new g();
        Bundle bundle = j.a(gDPRSetup, h2);
        bundle.putBoolean(v, bl);
        g2.setArguments(bundle);
        return g2;
    }

    private void V() {
        if (this.x.E()) {
            if (this.getActivity() != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.getActivity().finishAndRemoveTask();
                } else {
                    androidx.core.app.a.j((Activity)this.getActivity());
                }
            }
        } else {
            this.w();
        }
        this.x.B();
    }

    public Dialog B(Bundle bundle) {
        if (this.x.F()) {
            com.google.android.material.bottomsheet.a a2 = new com.google.android.material.bottomsheet.a(this, this.getContext(), this.A()){
                final /* synthetic */ g o;
                {
                    this.o = g2;
                    super(context, n2);
                }

                public void onBackPressed() {
                    if (g.N(this.o).d()) {
                        return;
                    }
                    if (!g.N(this.o).c().t()) {
                        this.dismiss();
                    }
                }
            };
            a2.setOnShowListener((DialogInterface.OnShowListener)new com.michaelflisar.gdprdialog.b(this));
            return a2;
        }
        return new i(this, this.getContext(), this.A()){
            final /* synthetic */ g h;
            {
                this.h = g2;
                super(context, n2);
            }

            public void onBackPressed() {
                if (g.N(this.h).d()) {
                    return;
                }
                if (!g.N(this.h).c().t()) {
                    this.dismiss();
                }
            }
        };
    }

    public /* synthetic */ void Q() {
        this.P();
    }

    public /* synthetic */ void S(DialogInterface dialogInterface) {
        this.R(dialogInterface);
    }

    public void onActivityCreated(Bundle bundle) {
        Fragment.super.onActivityCreated(bundle);
        this.H(false);
        this.x.D((Object)this.getActivity(), this.w);
    }

    public void onCreate(Bundle bundle) {
        androidx.fragment.app.c.super.onCreate(bundle);
        this.x = new j(this.getArguments(), bundle);
        this.w = this.getArguments().getBoolean(v);
        GDPRCustomTexts gDPRCustomTexts = this.x.c().u();
        if (gDPRCustomTexts.t() && gDPRCustomTexts.o(this.getContext()).isEmpty()) {
            this.J(1, this.x.c().q());
            return;
        }
        this.J(0, this.x.c().q());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.O(layoutInflater, viewGroup);
        GDPRCustomTexts gDPRCustomTexts = this.x.c().u();
        if (gDPRCustomTexts.t()) {
            this.z().setTitle((CharSequence)gDPRCustomTexts.o(this.getContext()));
            return view;
        }
        this.z().setTitle(l.o);
        return view;
    }

    public void onDestroy() {
        this.x.B();
        Fragment.super.onDestroy();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.x.d()) {
            return;
        }
        if (this.x.c().t()) {
            return;
        }
        this.V();
        androidx.fragment.app.c.super.onDismiss(dialogInterface);
    }

    public void onSaveInstanceState(Bundle bundle) {
        androidx.fragment.app.c.super.onSaveInstanceState(bundle);
        this.x.C(bundle);
    }
}

