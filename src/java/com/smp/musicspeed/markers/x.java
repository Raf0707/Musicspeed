/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.Editable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.fragment.app.x
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.h0$b
 *  androidx.lifecycle.i0
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.text.NumberFormat
 *  java.util.List
 *  java.util.Objects
 *  java.util.concurrent.TimeUnit
 */
package com.smp.musicspeed.markers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h0;
import androidx.lifecycle.p;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.d0;
import com.smp.musicspeed.markers.g0;
import com.smp.musicspeed.markers.i0;
import com.smp.musicspeed.utils.t;
import f.m;
import f.n;
import f.z.d.k;
import f.z.d.l;
import f.z.d.v;
import f.z.d.z;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class x
extends androidx.fragment.app.c {
    public static final a v = new Object(null){
        {
            this();
        }

        public final x a(MarkerItem markerItem) {
            k.g(markerItem, "markerItem");
            x x2 = new x();
            Bundle bundle = new Bundle();
            bundle.putParcelable("marker", (Parcelable)markerItem);
            x2.setArguments(bundle);
            return x2;
        }
    };
    private final f.f A = f.g.a(new f.z.c.a<TextView>(){

        public final TextView a() {
            View view = this.y;
            k.e((Object)view);
            return (TextView)view.findViewById(2131297098);
        }
    });
    private final f.f B = f.g.a(new f.z.c.a<TextView>(){

        public final TextView a() {
            View view = this.y;
            k.e((Object)view);
            return (TextView)view.findViewById(2131296941);
        }
    });
    private final f.f w = androidx.fragment.app.x.a((Fragment)this, (f.e0.b)z.b(g0.class), (f.z.c.a)new f.z.c.a<androidx.lifecycle.i0>((Fragment)this){
        final /* synthetic */ Fragment g;
        {
            this.g = fragment;
            super(0);
        }

        public final androidx.lifecycle.i0 a() {
            androidx.fragment.app.d d2 = this.g.requireActivity();
            k.f((Object)d2, "requireActivity()");
            androidx.lifecycle.i0 i02 = d2.getViewModelStore();
            k.f((Object)i02, "requireActivity().viewModelStore");
            return i02;
        }
    }, (f.z.c.a)new f.z.c.a<h0.b>((Fragment)this){
        final /* synthetic */ Fragment g;
        {
            this.g = fragment;
            super(0);
        }

        public final h0.b a() {
            androidx.fragment.app.d d2 = this.g.requireActivity();
            k.f((Object)d2, "requireActivity()");
            return d2.getDefaultViewModelProviderFactory();
        }
    });
    private final f.f x = f.g.a(new f.z.c.a<MarkerItem>(){

        public final MarkerItem a() {
            Parcelable parcelable = this.requireArguments().getParcelable("marker");
            k.e((Object)parcelable);
            return (MarkerItem)parcelable;
        }
    });
    private View y;
    private final f.f z = f.g.a(new f.z.c.a<TextView>(){

        public final TextView a() {
            View view = this.y;
            k.e((Object)view);
            return (TextView)view.findViewById(2131296946);
        }
    });

    private final MarkerItem O() {
        return (MarkerItem)this.x.getValue();
    }

    private final TextView P() {
        Object t2 = this.B.getValue();
        k.f(t2, "<get-millisText>(...)");
        return (TextView)t2;
    }

    private final TextView Q() {
        Object t2 = this.z.getValue();
        k.f(t2, "<get-minutesText>(...)");
        return (TextView)t2;
    }

    private final EditText R() {
        View view = this.y;
        k.e((Object)view);
        View view2 = view.findViewById(2131296829);
        k.e((Object)view2);
        return (EditText)view2;
    }

    private final TextView S() {
        Object t2 = this.A.getValue();
        k.f(t2, "<get-secondsText>(...)");
        return (TextView)t2;
    }

    private final g0 T() {
        return (g0)((Object)this.w.getValue());
    }

    public static /* synthetic */ void U(x x2, DialogInterface dialogInterface) {
        x.X(x2, dialogInterface);
    }

    public static /* synthetic */ void V(x x2, View view) {
        x.Y(x2, view);
    }

    public static /* synthetic */ void W(v v2, x x2, List list) {
        x.Z(v2, x2, list);
    }

    private static final void X(x x2, DialogInterface dialogInterface) {
        k.g((Object)x2, "this$0");
        Objects.requireNonNull((Object)dialogInterface, (String)"null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        ((androidx.appcompat.app.d)dialogInterface).e(-1).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.markers.b(x2));
    }

    private static final void Y(x x2, View view) {
        Object object;
        k.g((Object)x2, "this$0");
        try {
            object = m.b(x2.c0());
        }
        catch (Throwable throwable) {
            object = m.b(n.a(throwable));
        }
        if (m.g(object)) {
            long l2 = ((Number)object).longValue();
            g0 g02 = x2.T();
            MarkerItem markerItem = x2.O();
            k.f(markerItem, "markerItem");
            MarkerItem markerItem2 = g02.m(markerItem, x2.b0());
            x2.T().n(markerItem2, l2);
            x2.w();
        }
        if (m.d(object) != null) {
            String string = d0.a((long)((double)x2.O().getDurationUs() / 1000.0));
            View view2 = x2.y;
            if (view2 == null) {
                return;
            }
            TextView textView = (TextView)view2.findViewById(2131297209);
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            textView.setText((CharSequence)x2.getString(2131820735, new Object[]{string}));
        }
    }

    private static final void Z(v v2, x x2, List list) {
        k.g(v2, "$initial");
        k.g((Object)x2, "this$0");
        if (v2.f) {
            v2.f = false;
            return;
        }
        x2.w();
    }

    private final void a0() {
        float f2 = this.O().getPosition();
        i0 i02 = d0.b(f.a0.a.c((double)this.O().getDurationUs() / 1000.0 * (double)f2));
        long l2 = i02.a();
        long l3 = i02.b();
        long l4 = i02.c();
        NumberFormat numberFormat = NumberFormat.getInstance();
        this.Q().setText((CharSequence)numberFormat.format(l2));
        this.S().setText((CharSequence)numberFormat.format(l3));
        this.P().setText((CharSequence)numberFormat.format(l4));
        this.R().setText((CharSequence)this.O().getName());
    }

    private final String b0() {
        return this.R().getText().toString();
    }

    private final long c0() {
        String string = this.Q().getText().toString();
        String string2 = this.S().getText().toString();
        String string3 = this.P().getText().toString();
        long l2 = !k.c(string, "") ? Long.parseLong((String)string) : 0L;
        long l3 = !k.c(string2, "") ? Long.parseLong((String)string2) : 0L;
        long l4 = !k.c(string3, "") ? Long.parseLong((String)string3) : 0L;
        long l5 = l4 + (TimeUnit.MINUTES.toMillis(l2) + TimeUnit.SECONDS.toMillis(l3));
        double d2 = (double)this.O().getDurationUs() / 1000.0;
        if (l5 < 0L) {
            return 0L;
        }
        if (!((double)l5 > d2)) {
            return l5;
        }
        throw new IllegalArgumentException();
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.requireActivity());
        this.y = this.getLayoutInflater().inflate(2131492941, null);
        this.a0();
        a2.u(this.y);
        a2.s(2131820786);
        a2.o(17039370, null);
        a2.j(17039360, null);
        androidx.appcompat.app.d d2 = a2.a();
        k.f((Object)d2, "Builder(requireActivity()).run {\n            rootView = layoutInflater.inflate(R.layout.dialog_marker_edit, null)\n            setupView()\n            setView(rootView)\n            setTitle(R.string.dialog_title_marker_edit)\n            setPositiveButton(android.R.string.ok, null)\n            setNegativeButton(android.R.string.cancel, null)\n            create()\n        }");
        d2.setOnShowListener((DialogInterface.OnShowListener)new com.smp.musicspeed.markers.a(this));
        return d2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.g((Object)layoutInflater, "inflater");
        return this.y;
    }

    public void onDestroyView() {
        this.y = null;
        super.onDestroyView();
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.z();
        if (dialog == null) {
            return;
        }
        t.U((Activity)this.getActivity(), dialog, 350);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        Fragment.super.onViewCreated(view, bundle);
        v v2 = new v();
        v2.f = true;
        this.T().h().i(this.getViewLifecycleOwner(), (androidx.lifecycle.x)new com.smp.musicspeed.markers.c(v2, this));
    }

}

