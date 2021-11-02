/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.ImageButton
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.bpmkey;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.d;
import com.smp.musicspeed.bpmkey.c;
import com.smp.musicspeed.dbrecord.BeatStartRecord;
import com.smp.musicspeed.utils.o;

public class c
extends androidx.fragment.app.c {
    private Button A;
    private ImageButton B;
    private d v;
    private float w;
    private float x;
    private EditText y;
    private Button z;

    static /* synthetic */ ImageButton N(c c2) {
        return c2.B;
    }

    static /* synthetic */ float O(c c2) {
        return c2.x;
    }

    static /* synthetic */ EditText P(c c2) {
        return c2.y;
    }

    static /* synthetic */ Button Q(c c2) {
        return c2.z;
    }

    static /* synthetic */ Button R(c c2) {
        return c2.A;
    }

    static /* synthetic */ d S(c c2) {
        return c2.v;
    }

    public static c T(BeatStartRecord beatStartRecord) {
        c c2 = new c();
        Bundle bundle = new Bundle();
        bundle.putFloat("key_bpm_current", beatStartRecord.bpmcurrent);
        bundle.putFloat("key_bpm_original", beatStartRecord.bpmoriginal);
        c2.setArguments(bundle);
        return c2;
    }

    public Dialog B(Bundle bundle) {
        EditText editText;
        d.a a2 = new d.a((Context)this.getActivity(), o.d(this.requireContext()));
        a2.s(2131820776);
        View view = this.getActivity().getLayoutInflater().inflate(2131492933, null);
        this.y = editText = (EditText)view.findViewById(2131296666);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(Math.round((float)this.w));
        editText.setText((CharSequence)stringBuilder.toString());
        this.z = (Button)view.findViewById(2131296615);
        this.A = (Button)view.findViewById(2131296825);
        this.B = (ImageButton)view.findViewById(2131297067);
        View.OnClickListener onClickListener = new View.OnClickListener(this){
            final /* synthetic */ c f;
            {
                this.f = c2;
            }

            /*
             * Exception decompiling
             */
            public void onClick(}
        java.lang.IllegalStateException: Parameters not created
        
        