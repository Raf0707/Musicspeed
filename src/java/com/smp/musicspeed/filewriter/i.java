/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.Editable
 *  android.text.InputFilter
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.EditText
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  com.google.android.material.textfield.TextInputLayout
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.filewriter;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import com.google.android.material.textfield.TextInputLayout;
import com.smp.musicspeed.filewriter.FileWriterService;
import com.smp.musicspeed.filewriter.d;
import com.smp.musicspeed.filewriter.e;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.h;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.s;
import com.smp.musicspeed.utils.t;
import java.io.File;

public class i
extends c {
    private String A;
    private File B;
    private File C;
    private float D;
    private float E;
    private float F;
    private boolean G;
    private boolean H;
    private long I;
    private long J;
    private EditText v;
    private EditText w;
    private a x;
    private CheckBox y;
    private boolean z;

    private void N() {
        boolean bl;
        String string;
        String string2 = this.P();
        String string3 = this.getActivity().getResources().getString(2131820834);
        String string4 = this.getActivity().getResources().getString(2131820836);
        String string5 = this.getActivity().getResources().getString(2131820833);
        this.z = bl = t.x((Context)this.getActivity());
        String string6 = bl ? ".wav" : ".mp3";
        if (this.G) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" (");
            stringBuilder.append(string3);
            stringBuilder.append(" ");
            Object[] arrobject = new Object[]{Math.round((float)(100.0f * this.F))};
            stringBuilder.append(String.format((String)"%d", (Object[])arrobject));
            stringBuilder.append(")");
            String string7 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(g.j(this.B.getName()));
            stringBuilder2.append(string7);
            stringBuilder2.append(string6);
            string = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.A);
            stringBuilder3.append(string7);
            this.A = stringBuilder3.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" (");
            stringBuilder.append(string5);
            stringBuilder.append(" ");
            Object[] arrobject = new Object[]{Float.valueOf((float)this.E)};
            stringBuilder.append(String.format((String)"%.2f", (Object[])arrobject));
            stringBuilder.append(" - ");
            stringBuilder.append(string4);
            stringBuilder.append(" ");
            Object[] arrobject2 = new Object[]{Math.round((float)(100.0f * this.D))};
            stringBuilder.append(String.format((String)"%d", (Object[])arrobject2));
            stringBuilder.append(")");
            String string8 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(g.j(this.B.getName()));
            stringBuilder4.append(string8);
            stringBuilder4.append(string6);
            string = stringBuilder4.toString();
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(this.A);
            stringBuilder5.append(string8);
            this.A = stringBuilder5.toString();
        }
        this.C = g.a(new File(string2, string), string6);
    }

    private Intent O(Context context, String string, String string2, String string3, float f2, float f3, float f4, boolean bl, boolean bl2, long l2, long l3) {
        Intent intent = new Intent(context, FileWriterService.class);
        intent.putExtra("com.smp.musicspeed.ILE_NAME_IN", string);
        intent.putExtra("com.smp.musicspeed.ILE_NAME_OUT", string2);
        intent.putExtra("com.smp.musicspeed.TRACK_NAME_OUT", string3);
        intent.putExtra("com.smp.musicspeed.TEMPO", f2);
        intent.putExtra("com.smp.musicspeed.PITCH", f3);
        intent.putExtra("com.smp.musicspeed.RATE", f4);
        intent.putExtra("com.smp.musicspeed.LINKED", bl);
        intent.putExtra("com.smp.musicspeed.QUALITY", bl2);
        if (!this.y.isChecked()) {
            l3 = l2 = Long.MIN_VALUE;
        }
        intent.putExtra("com.smp.musicspeed.LOOP_START", l2);
        intent.putExtra("com.smp.musicspeed.LOOP_END", l3);
        return intent;
    }

    private String P() {
        return g.c(this.requireContext()).getAbsolutePath();
    }

    private /* synthetic */ void Q(androidx.appcompat.app.d d2, View view) {
        this.A = this.w.getText().toString();
        String string = this.v.getText().toString();
        boolean bl = s.h(this.A);
        boolean bl2 = s.h(string);
        TextInputLayout textInputLayout = (TextInputLayout)d2.findViewById(2131296795);
        TextInputLayout textInputLayout2 = (TextInputLayout)d2.findViewById(2131296781);
        if (bl) {
            textInputLayout.setError((CharSequence)this.getString(2131820821));
            textInputLayout.setErrorEnabled(true);
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        if (bl2) {
            textInputLayout2.setError((CharSequence)this.getString(2131820821));
            textInputLayout2.setErrorEnabled(true);
        } else {
            textInputLayout2.setErrorEnabled(false);
        }
        if (!bl) {
            if (bl2) {
                return;
            }
            File file = this.C.getParentFile();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            String string2 = this.z ? ".wav" : ".mp3";
            stringBuilder.append(string2);
            this.C = new File(file, stringBuilder.toString());
            this.V();
            this.x.J();
            this.w();
        }
    }

    private /* synthetic */ void S(androidx.appcompat.app.d d2, DialogInterface dialogInterface) {
        ((androidx.appcompat.app.d)dialogInterface).e(-1).setOnClickListener((View.OnClickListener)new d(this, d2));
    }

    public static i U(String string, String string2, float f2, float f3, float f4, boolean bl, boolean bl2, long l2, long l3) {
        i i2 = new i();
        Bundle bundle = new Bundle();
        bundle.putString("com.smo.bundle.FILEPATH", string);
        bundle.putString("com.smo.bundle.TRACKNAME", string2);
        bundle.putFloat("KEY_TEMPO", f2);
        bundle.putFloat("KEY_PITCH", f3);
        bundle.putFloat("KEY_RATE", f4);
        bundle.putBoolean("com.smo.bundle.LINK", bl);
        bundle.putBoolean("com.smp.bundle.file_quality", bl2);
        bundle.putLong("com.smp.musicspeed.BUNDLE_LOOPSTART", l2);
        bundle.putLong("com.smp.musicspeed.BUNDLE_LOOPEND", l3);
        i2.setArguments(bundle);
        return i2;
    }

    private void V() {
        Intent intent = this.O((Context)this.getActivity(), this.B.toString(), this.C.toString(), this.A, this.D, this.E, this.F, this.G, this.H, this.I, this.J);
        this.getActivity().startService(intent);
    }

    public Dialog B(Bundle bundle) {
        CheckBox checkBox;
        d.a a2 = new d.a((Context)this.requireActivity(), o.d((Context)this.requireActivity()));
        View view = this.getActivity().getLayoutInflater().inflate(2131492945, null);
        a2.u(view).t((CharSequence)this.getActivity().getString(2131820794)).o(17039370, null).j(17039360, null);
        this.y = checkBox = (CheckBox)view.findViewById(2131296567);
        if (this.I != Long.MIN_VALUE && this.J != Long.MIN_VALUE) {
            checkBox.setVisibility(0);
        }
        this.v = (EditText)view.findViewById(2131296662);
        this.w = (EditText)view.findViewById(2131296663);
        this.v.setText((CharSequence)g.j(this.C.getName()));
        this.w.setText((CharSequence)this.A);
        if (this.z) {
            this.w.setVisibility(8);
            view.findViewById(2131296795).setVisibility(8);
        }
        h h2 = new h();
        this.v.setFilters(new InputFilter[]{h2});
        androidx.appcompat.app.d d2 = a2.a();
        d2.setOnShowListener((DialogInterface.OnShowListener)new e(this, d2));
        return d2;
    }

    public /* synthetic */ void R(androidx.appcompat.app.d d2, View view) {
        this.Q(d2, view);
    }

    public /* synthetic */ void T(androidx.appcompat.app.d d2, DialogInterface dialogInterface) {
        this.S(d2, dialogInterface);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.x = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B = new File(this.getArguments().getString("com.smo.bundle.FILEPATH"));
        this.A = this.getArguments().getString("com.smo.bundle.TRACKNAME");
        this.D = this.getArguments().getFloat("KEY_TEMPO");
        this.E = this.getArguments().getFloat("KEY_PITCH");
        this.F = this.getArguments().getFloat("KEY_RATE");
        this.G = this.getArguments().getBoolean("com.smo.bundle.LINK");
        this.H = this.getArguments().getBoolean("com.smp.bundle.file_quality");
        this.I = this.getArguments().getLong("com.smp.musicspeed.BUNDLE_LOOPSTART");
        this.J = this.getArguments().getLong("com.smp.musicspeed.BUNDLE_LOOPEND");
        this.N();
    }

    public void onDestroy() {
        Fragment.super.onDestroy();
    }

    public void onPause() {
        Fragment.super.onPause();
    }

    public void onResume() {
        Fragment.super.onResume();
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.z();
        if (dialog != null) {
            t.U((Activity)this.getActivity(), dialog, 600);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Fragment.super.onViewCreated(view, bundle);
    }

}

