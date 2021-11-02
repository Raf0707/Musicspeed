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
 *  android.widget.CheckBox
 *  android.widget.ImageButton
 *  android.widget.NumberPicker
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.bpmkey;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import com.smp.musicspeed.bpmkey.f;
import com.smp.musicspeed.bpmkey.g;
import com.smp.musicspeed.dbrecord.BeatStartRecord;
import com.smp.musicspeed.utils.o;

public class f
extends androidx.fragment.app.c {
    private ImageButton A;
    private d v;
    private int w;
    private int x;
    private NumberPicker y;
    private CheckBox z;

    static /* synthetic */ int N(f f2) {
        return f2.w;
    }

    static /* synthetic */ void O(f f2, int n2) {
        f2.T(n2);
    }

    static /* synthetic */ NumberPicker P(f f2) {
        return f2.y;
    }

    static /* synthetic */ CheckBox Q(f f2) {
        return f2.z;
    }

    static /* synthetic */ d R(f f2) {
        return f2.v;
    }

    public static f S(BeatStartRecord beatStartRecord) {
        f f2 = new f();
        Bundle bundle = new Bundle();
        bundle.putInt("key_original", beatStartRecord.keyoriginal);
        bundle.putInt("key_current", beatStartRecord.keycurrent);
        f2.setArguments(bundle);
        return f2;
    }

    private void T(int n2) {
        if (n2 > 11) {
            n2 -= 12;
            this.z.setChecked(true);
        } else {
            this.z.setChecked(false);
        }
        this.y.setValue(n2);
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.getActivity(), o.d(this.requireContext()));
        a2.s(2131820782);
        View view = this.getActivity().getLayoutInflater().inflate(2131492937, null);
        this.A = (ImageButton)view.findViewById(2131297067);
        this.y = (NumberPicker)view.findViewById(2131297019);
        this.z = (CheckBox)view.findViewById(2131296566);
        this.y.setDisplayedValues(g.b);
        this.T(this.x);
        this.A.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ f f;
            {
                this.f = f2;
            }

            public void onClick(View view) {
                f f2 = this.f;
                f.O(f2, f.N(f2));
            }
        });
        a2.u(view);
        a2.o(17039370, new DialogInterface.OnClickListener(this){
            final /* synthetic */ f f;
            {
                this.f = f2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                int n3 = f.P(this.f).getValue();
                if (f.Q(this.f).isChecked()) {
                    n3 += 12;
                }
                f.R(this.f).D(n3);
            }
        }).j(17039360, new DialogInterface.OnClickListener(this){
            final /* synthetic */ f f;
            {
                this.f = f2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
            }
        });
        return a2.a();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.v = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.getArguments() != null) {
            this.x = this.getArguments().getInt("key_current");
            this.w = this.getArguments().getInt("key_original");
        }
    }

    public void onResume() {
        Fragment.super.onResume();
    }

}

