/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  b.i.h.a
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.Iterator
 */
package com.smp.musicspeed.misc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.fragment.app.c;
import com.smp.musicspeed.misc.b;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import java.util.Arrays;
import java.util.Iterator;

public class b
extends c {
    public static b N() {
        b b2 = new b();
        b2.setArguments(new Bundle());
        return b2;
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.getActivity(), o.d(this.requireContext()));
        a2.s(2131820633);
        View view = this.getActivity().getLayoutInflater().inflate(2131492938, null);
        ((Button)view.findViewById(2131296475)).setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ b f;
            {
                this.f = b2;
            }

            public void onClick(View view) {
                new d.a.a.b$e((Context)this.f.getActivity()).c(2131755038).b(true).a().j();
            }
        });
        a2.u(view);
        a2.o(17039370, new DialogInterface.OnClickListener(this){
            final /* synthetic */ b f;
            {
                this.f = b2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
            }
        });
        TextView textView = (TextView)view.findViewById(2131296804);
        TextView textView2 = (TextView)view.findViewById(2131296798);
        TextView textView3 = (TextView)view.findViewById(2131296800);
        TextView textView4 = (TextView)view.findViewById(2131296802);
        Iterator iterator = Arrays.asList((Object[])new TextView[]{textView, textView2, textView3, textView4}).iterator();
        while (iterator.hasNext()) {
            ((TextView)iterator.next()).setLinkTextColor(b.i.h.a.c((Context)this.requireActivity(), (int)o.b(this.requireContext())));
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
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

