/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  b.i.h.a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.smp.musicspeed.about;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.c;
import androidx.fragment.app.d;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import f.z.d.g;
import f.z.d.k;
import java.util.Objects;

public final class i
extends c {
    public static final a v = new Object(null){
        {
            this();
        }

        public final i a() {
            return new i();
        }
    };

    public static final i N() {
        return v.a();
    }

    public Dialog B(Bundle bundle) {
        d d2 = this.requireActivity();
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        d.a a2 = new d.a((Context)d2, o.d(context));
        a2.s(2131820962);
        LayoutInflater layoutInflater = this.requireActivity().getLayoutInflater();
        k.f((Object)layoutInflater, "requireActivity().layoutInflater");
        View view = layoutInflater.inflate(2131492950, null);
        k.f((Object)view, "inflater.inflate(R.layout.dialog_technology, null)");
        a2.u(view);
        View view2 = view.findViewById(2131297184);
        Objects.requireNonNull((Object)view2, (String)"null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView)view2;
        d d3 = this.requireActivity();
        Context context2 = this.requireContext();
        k.f((Object)context2, "requireContext()");
        textView.setLinkTextColor(b.i.h.a.c((Context)d3, (int)o.b(context2)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        androidx.appcompat.app.d d4 = a2.a();
        k.f((Object)d4, "builder.create()");
        return d4;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.z();
        if (dialog != null) {
            t.U((Activity)this.getActivity(), dialog, 600);
        }
    }

}

