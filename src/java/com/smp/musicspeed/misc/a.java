/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.smp.musicspeed.misc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.c;
import androidx.fragment.app.d;
import com.smp.musicspeed.misc.a;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;

public class a
extends c {
    public static a N() {
        a a2 = new a();
        a2.setArguments(new Bundle());
        return a2;
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.getActivity(), o.d(this.requireContext()));
        a2.s(2131820605);
        String string = this.getActivity().getResources().getString(2131821402);
        TextView textView = new TextView((Context)this.getActivity());
        textView.setText((CharSequence)string);
        float f2 = this.getResources().getDisplayMetrics().density;
        int n2 = (int)(24.0f * f2);
        int n3 = (int)(f2 * 0.0f);
        textView.setPadding(n2, n3, n2, n3);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setTextSize(2, 16.0f);
        ScrollView scrollView = new ScrollView((Context)this.getActivity());
        scrollView.addView((View)textView);
        a2.u((View)scrollView);
        textView.setLayoutDirection(0);
        textView.setTextDirection(3);
        a2.o(17039370, new DialogInterface.OnClickListener(this){
            final /* synthetic */ a f;
            {
                this.f = a2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
            }
        });
        return a2.a();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.z();
        if (dialog != null) {
            t.U((Activity)this.getActivity(), dialog, 600);
        }
    }
}

