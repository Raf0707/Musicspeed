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
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  androidx.lifecycle.LiveData
 *  com.google.android.material.textfield.TextInputLayout
 *  f.g0.k
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.f0
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.l0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.PresetItem;
import com.smp.musicspeed.effects.u;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.l0.h;
import com.smp.musicspeed.l0.i;
import f.n;
import f.t;
import f.u.g0;
import f.w.k.a.f;
import f.z.c.p;
import f.z.d.g;
import f.z.d.k;
import f.z.d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.e;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class q
extends androidx.fragment.app.c
implements k0 {
    public static final a v = new Object(null){
        {
            this();
        }

        public final q a(int n2) {
            q q2 = new q();
            Bundle bundle = new Bundle();
            bundle.putInt("effectId", n2);
            q2.setArguments(bundle);
            return q2;
        }
    };
    private final /* synthetic */ k0 w;
    private final f.f x = f.g.a(new f.z.c.a<Integer>(){

        public final int a() {
            return this.requireArguments().getInt("effectId");
        }
    });

    public q() {
        this.w = l0.b();
    }

    private final int O() {
        return ((Number)this.x.getValue()).intValue();
    }

    public static /* synthetic */ void P(TextView textView, TextInputLayout textInputLayout, q q2, View view) {
        q.S(textView, textInputLayout, q2, view);
    }

    public static /* synthetic */ void Q(androidx.appcompat.app.d d2, q q2, DialogInterface dialogInterface) {
        q.R(d2, q2, dialogInterface);
    }

    private static final void R(androidx.appcompat.app.d d2, q q2, DialogInterface dialogInterface) {
        k.g((Object)d2, "$dialog");
        k.g((Object)q2, "this$0");
        Objects.requireNonNull((Object)dialogInterface, (String)"null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        ((androidx.appcompat.app.d)dialogInterface).e(-1).setOnClickListener((View.OnClickListener)new h((TextView)d2.findViewById(2131297216), (TextInputLayout)d2.findViewById(2131296786), q2));
    }

    private static final void S(TextView textView, TextInputLayout textInputLayout, q q2, View view) {
        k.g((Object)q2, "this$0");
        k.e((Object)textView);
        CharSequence charSequence = textView.getText();
        boolean bl = charSequence == null || f.g0.k.h((CharSequence)charSequence);
        if (bl) {
            k.e((Object)textInputLayout);
            textInputLayout.setError((CharSequence)q2.requireContext().getString(2131820821));
            textInputLayout.setErrorEnabled(true);
            return;
        }
        e.d((k0)q2, null, null, (p)new p<k0, f.w.d<? super t>, Object>(q2, textView, null){
            int j;
            final /* synthetic */ q k;
            final /* synthetic */ TextView l;
            {
                this.k = q2;
                this.l = textView;
                super(2, d2);
            }

            @Override
            public final f.w.d<t> a(Object object, f.w.d<?> d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final Object q(Object object) {
                Object object2 = f.w.j.b.c();
                int n2 = this.j;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    n.b(object);
                } else {
                    ArrayList arrayList;
                    n.b(object);
                    if (this.k.O() == 2) {
                        float[] arrf = com.smp.musicspeed.equalizer.l.d(this.k.requireContext());
                        k.f(arrf, "eqFloats");
                        TextView textView = this.l;
                        q q2 = this.k;
                        arrayList = new ArrayList(arrf.length);
                        int n3 = arrf.length;
                        int n4 = 0;
                        for (int i2 = 0; i2 < n3; ++i2) {
                            float f2 = arrf[i2];
                            Integer n5 = f.w.k.a.b.c(n4);
                            ++n4;
                            float f3 = f.w.k.a.b.b(f2).floatValue();
                            int n6 = n5;
                            arrayList.add((Object)new PresetItem(textView.getText().toString(), q2.O(), n6, f3));
                        }
                    } else {
                        Object object3 = g0.h(u.a(), f.w.k.a.b.c(this.k.O())).J().f();
                        k.e(object3);
                        Map<Integer, Float> map = ((com.smp.musicspeed.effects.q)object3).c();
                        TextView textView = this.l;
                        q q3 = this.k;
                        arrayList = new ArrayList(map.size());
                        for (Map.Entry entry : map.entrySet()) {
                            arrayList.add((Object)new PresetItem(textView.getText().toString(), q3.O(), ((Number)entry.getKey()).intValue(), ((Number)entry.getValue()).floatValue()));
                        }
                    }
                    f0 f02 = a1.b();
                    p<k0, f.w.d<? super t>, Object> p2 = new p<k0, f.w.d<? super t>, Object>((List<PresetItem>)arrayList, null){
                        int j;
                        final /* synthetic */ List<PresetItem> k;
                        {
                            this.k = list;
                            super(2, d2);
                        }

                        @Override
                        public final f.w.d<t> a(Object object, f.w.d<?> d2) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }

                        @Override
                        public final Object q(Object object) {
                            f.w.j.b.c();
                            if (this.j == 0) {
                                n.b(object);
                                AppDatabaseKt.getPresetsDao().insertPresetItems(this.k);
                                return t.a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Object t(k0 k02, f.w.d<? super t> d2) {
                            return (this.a((Object)k02, d2)).q(t.a);
                        }
                    };
                    this.j = 1;
                    if (e.e((f.w.g)f02, (p)p2, (f.w.d)this) == object2) {
                        return object2;
                    }
                }
                String string = this.k.requireContext().getString(2131821337);
                k.f(string, "requireContext().getString(R.string.toast_preset_saved)");
                Context context = this.k.requireContext();
                k.f((Object)context, "requireContext()");
                z.n(string, context, 0, 2, null);
                this.k.w();
                return t.a;
            }

            public final Object t(k0 k02, f.w.d<? super t> d2) {
                return (this.a((Object)k02, d2)).q(t.a);
            }

        }, (int)3, null);
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.requireActivity());
        View view = this.getLayoutInflater().inflate(2131492949, null);
        a2.u(view);
        a2.s(2131820795);
        a2.o(17039370, null);
        a2.j(17039360, null);
        ((TextView)view.findViewById(2131297216)).requestFocus();
        androidx.appcompat.app.d d2 = a2.a();
        k.f((Object)d2, "Builder(requireActivity()).run {\n            val rootView = layoutInflater.inflate(R.layout.dialog_save_preset, null)\n            //setupView()\n            setView(rootView)\n            setTitle(R.string.dialog_title_save_preset)\n            setPositiveButton(android.R.string.ok, null)\n            setNegativeButton(android.R.string.cancel, null)\n            rootView.findViewById<TextView>(R.id.text_name).requestFocus()\n            create()\n        }");
        d2.setOnShowListener((DialogInterface.OnShowListener)new i(d2, this));
        return d2;
    }

    public f.w.g L() {
        return this.w.L();
    }

    public void onDestroyView() {
        super.onDestroyView();
        l0.d((k0)this, null, (int)1, null);
    }

    public void onResume() {
        Fragment.super.onResume();
        com.smp.musicspeed.utils.t.U((Activity)this.getActivity(), this.z(), 300);
        Dialog dialog = this.z();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setSoftInputMode(5);
    }

}

