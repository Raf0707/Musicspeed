/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextWatcher
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.EditText
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package c.h.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import c.h.a.c;
import c.h.a.f;
import c.h.a.g;

public class c
extends androidx.fragment.app.c {
    private String v;
    private String w;
    private d x;

    static /* synthetic */ d N(c c2) {
        return c2.x;
    }

    static /* synthetic */ Intent O(String string) {
        return c.P(string);
    }

    private static Intent P(String string) {
        Intent intent = new Intent();
        intent.putExtra("value", string);
        return intent;
    }

    public static c Q(Fragment fragment, int n2, String string, String string2) {
        c c2 = new c();
        Bundle bundle = new Bundle();
        bundle.putString("title", string);
        bundle.putString("message", string2);
        c2.setArguments(bundle);
        c2.setTargetFragment(fragment, n2);
        return c2;
    }

    public Dialog B(Bundle bundle) {
        d d2;
        View view = ((LayoutInflater)this.getActivity().getSystemService("layout_inflater")).inflate(g.b, null);
        EditText editText = (EditText)view.findViewById(f.e);
        editText.addTextChangedListener(new TextWatcher(this){
            final /* synthetic */ c f;
            {
                this.f = c2;
            }

            public void afterTextChanged(android.text.Editable editable) {
                if (c.N(this.f) != null) {
                    c.N(this.f).e(-1).setEnabled(true ^ editable.toString().trim().isEmpty());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }
        });
        this.x = d2 = new d.a((Context)this.getActivity()).t((CharSequence)this.v).h((CharSequence)this.w).u(view).j(17039360, new DialogInterface.OnClickListener(this){
            final /* synthetic */ c f;
            {
                this.f = c2;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                dialogInterface.dismiss();
                this.f.getTargetFragment().onActivityResult(this.f.getTargetRequestCode(), 0, null);
            }
        }).o(17039370, new DialogInterface.OnClickListener(this, editText){
            final /* synthetic */ EditText f;
            final /* synthetic */ c g;
            {
                this.g = c2;
                this.f = editText;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                dialogInterface.dismiss();
                String string = this.f.getText().toString().trim();
                this.g.getTargetFragment().onActivityResult(this.g.getTargetRequestCode(), -1, c.O(string));
            }
        }).a();
        d2.show();
        this.x.e(-1).setEnabled(false);
        editText.requestFocus();
        this.x.getWindow().setSoftInputMode(5);
        return this.x;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.getArguments() != null) {
            this.v = this.getArguments().getString("title");
            this.w = this.getArguments().getString("message");
        }
    }
}

