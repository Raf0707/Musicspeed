/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.Editable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.fragment.app.x
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.h0$b
 *  androidx.lifecycle.i0
 *  com.google.android.material.textfield.TextInputLayout
 *  f.g0.k
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Objects
 */
package com.smp.musicspeed.i0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.x;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.effects.v;
import com.smp.musicspeed.equalizer.EqualizerFragment;
import com.smp.musicspeed.i0.l;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import f.f;
import f.u.g0;
import f.z.d.g;
import f.z.d.k;
import f.z.d.z;
import java.util.Map;
import java.util.Objects;

public final class l
extends androidx.fragment.app.c {
    public static final a v = new Object(null){
        {
            this();
        }
    };
    private b A;
    private final f w = x.a((Fragment)this, (f.e0.b)z.b(v.class), (f.z.c.a)new f.z.c.a<i0>((Fragment)this){
        final /* synthetic */ Fragment g;
        {
            this.g = fragment;
            super(0);
        }

        public final i0 a() {
            androidx.fragment.app.d d2 = this.g.requireActivity();
            k.f((Object)d2, "requireActivity()");
            i0 i02 = d2.getViewModelStore();
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
    private int x;
    private int y;
    private EditText z;

    private final String N(int n2) {
        String string = EqualizerFragment.g[n2];
        k.f(string, "EqualizerFragment.equalizerBandTexts[equalizerBand]");
        return string;
    }

    private final v O() {
        return (v)((Object)this.w.getValue());
    }

    public static /* synthetic */ void P(View view, l l2, DialogInterface dialogInterface) {
        l.R(view, l2, dialogInterface);
    }

    public static /* synthetic */ void Q(l l2, TextInputLayout textInputLayout, View view) {
        l.S(l2, textInputLayout, view);
    }

    private static final void R(View view, l l2, DialogInterface dialogInterface) {
        k.g((Object)l2, "this$0");
        TextInputLayout textInputLayout = (TextInputLayout)view.findViewById(2131296792);
        Objects.requireNonNull((Object)dialogInterface, (String)"null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        ((androidx.appcompat.app.d)dialogInterface).e(-1).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.i0.b(l2, textInputLayout));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void S(l l2, TextInputLayout textInputLayout, View view) {
        k.g((Object)l2, "this$0");
        try {
            EditText editText = l2.z;
            k.e((Object)editText);
            double d2 = Double.parseDouble((String)f.g0.k.l((String)editText.getText().toString(), (char)',', (char)'.', (boolean)false, (int)4, null));
            int n2 = l2.x;
            if (n2 == 0) {
                int n3 = l2.requireArguments().getInt("effectId");
                int n4 = l2.requireArguments().getInt("controlId");
                l2.O().n(n3, n4, (float)d2);
            } else {
                b b2 = l2.A;
                if (b2 != null) {
                    b2.k(d2, n2, l2.y, true);
                }
            }
            l2.w();
            return;
        }
        catch (Exception exception) {
            textInputLayout.setError((CharSequence)l2.getString(2131821319));
            textInputLayout.setErrorEnabled(true);
            return;
        }
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        Context context = this.requireContext();
        k.f((Object)context, "requireContext()");
        d.a a2 = new d.a((Context)d2, o.d(context));
        LayoutInflater layoutInflater = this.requireActivity().getLayoutInflater();
        k.f((Object)layoutInflater, "requireActivity().layoutInflater");
        View view = layoutInflater.inflate(2131492943, null);
        View view2 = view.findViewById(2131296666);
        Objects.requireNonNull((Object)view2, (String)"null cannot be cast to non-null type android.widget.EditText");
        this.z = (EditText)view2;
        View view3 = view.findViewById(2131297223);
        Objects.requireNonNull((Object)view3, (String)"null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView)view3;
        a2.u(view);
        int n2 = this.x;
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 != 5) {
                                if (n2 == 100) {
                                    a2.s(2131820790);
                                    Object[] arrobject = new Object[]{this.N(this.y)};
                                    a2.h((CharSequence)this.getString(2131820755, arrobject));
                                    textView.setText(2131820770);
                                }
                            } else {
                                a2.s(2131820790);
                                a2.g(2131820750);
                                textView.setText(2131820770);
                            }
                        } else {
                            a2.s(2131820790);
                            a2.g(2131820765);
                            textView.setText(2131820770);
                        }
                    } else {
                        a2.s(2131820790);
                        a2.g(2131820766);
                        textView.setText((CharSequence)"%");
                    }
                } else {
                    a2.s(2131820790);
                    a2.g(2131820769);
                    textView.setText((CharSequence)"%");
                }
            } else {
                a2.s(2131820790);
                a2.g(2131820762);
                textView.setText((CharSequence)this.getResources().getString(2131820768));
            }
        } else {
            int n3 = this.requireArguments().getInt("effectId");
            int n4 = this.requireArguments().getInt("controlId");
            String string = this.getString(this.O().h(n3));
            k.f(string, "getString(viewModel.getEffectLabel(effectId))");
            String string2 = string.toLowerCase();
            k.f(string2, "(this as java.lang.String).toLowerCase()");
            String string3 = this.getString(((Number)g0.h(this.O().g(n3), n4)).intValue());
            k.f(string3, "getString(viewModel.getControlLabels(effectId).getValue(controlId))");
            String string4 = string3.toLowerCase();
            k.f(string4, "(this as java.lang.String).toLowerCase()");
            a2.s(2131820790);
            String string5 = this.getString(2131820754, new Object[]{string2, string4});
            k.f(string5, "getString(R.string.dialog_message_effect_value, effectLabel, levelLabel)");
            a2.h((CharSequence)string5);
            String string6 = this.getString(this.O().k(n3, n4));
            k.f(string6, "getString(viewModel.getUnitLabel(effectId, controlId))");
            textView.setText((CharSequence)string6);
        }
        a2.o(17039370, null).j(17039360, null);
        androidx.appcompat.app.d d3 = a2.a();
        k.f((Object)d3, "builder.create()");
        d3.setOnShowListener((DialogInterface.OnShowListener)new com.smp.musicspeed.i0.a(view, this));
        EditText editText = this.z;
        k.e((Object)editText);
        editText.requestFocus();
        Window window = d3.getWindow();
        k.e((Object)window);
        window.setSoftInputMode(5);
        return d3;
    }

    public void onAttach(Context context) {
        k.g((Object)context, "activity");
        super.onAttach(context);
        b b2 = context instanceof b ? context : null;
        this.A = b2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int n2 = this.requireArguments().getInt("com.smp.musicspeed.BUNDLE_ADJUSTMENT");
        if (n2 >= 100) {
            this.x = 100;
            this.y = n2 - 100;
            return;
        }
        this.x = n2;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.z();
        k.e((Object)dialog);
        View view = dialog.findViewById(16908299);
        Objects.requireNonNull((Object)view, (String)"null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView)view;
        int n2 = (int)t.b((Context)this.getActivity(), 14.0f);
        int n3 = (int)t.b((Context)this.getActivity(), 10.0f);
        textView.setPadding(textView.getPaddingLeft(), n2, textView.getPaddingRight(), n3);
    }

}

