/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package c.h.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import c.h.a.a;
import c.h.a.b;
import java.io.File;

public class a
extends androidx.fragment.app.c {
    private final b.d v;
    private final c.h.a.b w;
    private e x;
    private String y;

    public a() {
        b.d d2;
        this.v = d2 = new b.d(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void a() {
                a.N(this.a).a();
            }

            public void b() {
                a a2 = this.a;
                c.h.a.c.Q((Fragment)a2, 1000, a2.getString(c.h.a.h.a), this.a.getString(c.h.a.h.c)).M(this.a.getFragmentManager(), "createDirDialog");
            }
        };
        this.w = new c.h.a.b(this, d2){
            final /* synthetic */ a p;
            {
                this.p = a2;
                super(d2);
            }

            protected Context m() {
                return this.p.getActivity();
            }

            protected File n() {
                return android.os.Environment.getExternalStorageDirectory();
            }
        };
    }

    static /* synthetic */ e N(a a2) {
        return a2.x;
    }

    static /* synthetic */ c.h.a.b O(a a2) {
        return a2.w;
    }

    public static a P(String string) {
        a a2 = new a();
        Bundle bundle = new Bundle();
        bundle.putString("initial_dir", string);
        a2.setArguments(bundle);
        return a2;
    }

    public Dialog B(Bundle bundle) {
        d.a a2 = new d.a((Context)this.getActivity()).o(17039370, new DialogInterface.OnClickListener(this){
            final /* synthetic */ a f;
            {
                this.f = a2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                if (a.N(this.f) != null) {
                    a.N(this.f).F(a.O(this.f).o());
                }
            }
        }).j(17039360, new DialogInterface.OnClickListener(this){
            final /* synthetic */ a f;
            {
                this.f = a2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                if (a.N(this.f) != null) {
                    a.N(this.f).A();
                }
            }
        });
        View view = this.getActivity().getLayoutInflater().inflate(this.w.p(), null);
        this.w.q(view);
        if (!TextUtils.isEmpty((CharSequence)this.y)) {
            this.w.v(this.y);
        }
        a2.u(view);
        return a2.a();
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        Fragment.super.onActivityResult(n2, n3, intent);
        if (n2 != 1000) {
            return;
        }
        if (n3 == -1 && intent != null) {
            String string = intent.getStringExtra("value");
            this.w.l(string);
        }
    }

    public void onAttach(Activity activity) {
        Fragment.super.onAttach(activity);
        if (activity instanceof e) {
            this.x = activity;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = null;
        if (this.getArguments() != null) {
            this.y = this.getArguments().getString("initial_dir");
        }
        if (bundle != null) {
            this.y = bundle.getString("selected_dir");
        }
    }

    public void onDetach() {
        super.onDetach();
        this.x = null;
    }

    public void onPause() {
        Fragment.super.onPause();
        this.w.s();
    }

    public void onResume() {
        Fragment.super.onResume();
        this.w.t();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        File file = this.w.o();
        if (file != null) {
            bundle.putString("selected_dir", file.getPath());
        }
    }

}

