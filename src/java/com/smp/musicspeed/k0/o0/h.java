/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
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
 *  android.view.Window
 *  android.widget.Button
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  com.google.android.material.textfield.TextInputEditText
 *  com.google.android.material.textfield.TextInputLayout
 *  f.g0.k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.smp.musicspeed.k0.o0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.d;
import androidx.fragment.app.c;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.o0.b;
import com.smp.musicspeed.utils.o;
import f.g0.k;
import f.t;
import f.z.d.g;
import java.util.Objects;

public abstract class h
extends c {
    public static final a v = new Object(null){
        {
            this();
        }

        protected final Bundle a(MediaTrack[] arrmediaTrack) {
            f.z.d.k.g(arrmediaTrack, "items");
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("tracks", (Parcelable[])arrmediaTrack);
            return bundle;
        }
    };

    protected static final Bundle N(MediaTrack[] arrmediaTrack) {
        return v.a(arrmediaTrack);
    }

    public static /* synthetic */ void U(View view, TextInputLayout textInputLayout, h h2, View view2) {
        h.X(view, textInputLayout, h2, view2);
    }

    public static /* synthetic */ void V(d d2, h h2, View view, DialogInterface dialogInterface) {
        h.W(d2, h2, view, dialogInterface);
    }

    private static final void W(d d2, h h2, View view, DialogInterface dialogInterface) {
        f.z.d.k.g((Object)d2, "$dialog");
        f.z.d.k.g((Object)h2, "this$0");
        Objects.requireNonNull((Object)dialogInterface, (String)"null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        Button button = ((d)dialogInterface).e(-1);
        TextInputLayout textInputLayout = (TextInputLayout)d2.findViewById(2131296787);
        if (textInputLayout != null) {
            textInputLayout.setHint((CharSequence)h2.getString(h2.S()));
        }
        button.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.o0.a(view, textInputLayout, h2));
    }

    private static final void X(View view, TextInputLayout textInputLayout, h h2, View view2) {
        f.z.d.k.g((Object)h2, "this$0");
        Editable editable = ((TextInputEditText)view.findViewById(d0.c0)).getText();
        boolean bl = editable == null || k.h((CharSequence)editable);
        if (bl) {
            f.z.d.k.e((Object)textInputLayout);
            textInputLayout.setError((CharSequence)h2.requireContext().getString(2131820821));
            textInputLayout.setErrorEnabled(true);
            return;
        }
        if (h2.P()) {
            f.z.d.k.e((Object)textInputLayout);
            textInputLayout.setError((CharSequence)h2.requireContext().getString(2131821334));
            textInputLayout.setErrorEnabled(true);
            return;
        }
        h2.O().invoke();
        h2.w();
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        androidx.fragment.app.d d3 = this.requireActivity();
        f.z.d.k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3));
        LayoutInflater layoutInflater = this.requireActivity().getLayoutInflater();
        f.z.d.k.f((Object)layoutInflater, "requireActivity().layoutInflater");
        View view = layoutInflater.inflate(2131492942, null);
        a2.u(view).t((CharSequence)this.requireActivity().getString(this.T())).o(this.R(), null).j(17039360, null);
        d d4 = a2.a();
        f.z.d.k.f((Object)d4, "builder.create()");
        d4.setOnShowListener((DialogInterface.OnShowListener)new b(d4, this, view));
        ((TextInputEditText)view.findViewById(d0.c0)).requestFocus();
        Window window = d4.getWindow();
        if (window == null) {
            return d4;
        }
        window.setSoftInputMode(5);
        return d4;
    }

    public abstract f.z.c.a<t> O();

    public final boolean P() {
        Context context = this.requireContext();
        f.z.d.k.f((Object)context, "requireContext()");
        return f.d(context, this.Q());
    }

    public final String Q() {
        TextInputEditText textInputEditText;
        Dialog dialog = this.z();
        Editable editable = dialog == null ? null : ((textInputEditText = (TextInputEditText)dialog.findViewById(d0.c0)) == null ? null : textInputEditText.getText());
        return String.valueOf(editable);
    }

    protected abstract int R();

    protected abstract int S();

    protected abstract int T();

}

