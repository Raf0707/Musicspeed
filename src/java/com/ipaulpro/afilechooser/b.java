/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Environment
 *  android.view.View
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.d
 *  androidx.fragment.app.y
 *  b.o.a.a
 *  b.o.a.a$a
 *  b.o.b.b
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.ipaulpro.afilechooser;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.y;
import b.o.a.a;
import com.ipaulpro.afilechooser.c;
import java.io.File;
import java.util.List;

public class b
extends y
implements a.a<List<File>> {
    private com.ipaulpro.afilechooser.a q;
    private String r;
    private a s;

    public static b A(String string) {
        b b2 = new b();
        Bundle bundle = new Bundle();
        bundle.putString("path", string);
        b2.setArguments(bundle);
        return b2;
    }

    public void B(b.o.b.b<List<File>> b2, List<File> list) {
        this.q.c(list);
        if (this.isResumed()) {
            this.x(true);
            return;
        }
        this.z(true);
    }

    public void I(b.o.b.b<List<File>> b2) {
        this.q.a();
    }

    public void onActivityCreated(Bundle bundle) {
        this.v((CharSequence)"No music here.");
        this.w((ListAdapter)this.q);
        this.x(false);
        this.getLoaderManager().e(0, null, (a.a)this);
        Fragment.super.onActivityCreated(bundle);
    }

    public void onAttach(Context context) {
        Fragment.super.onAttach(context);
        try {
            this.s = context;
            return;
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement FileListFragment.Callbacks");
            throw new ClassCastException(stringBuilder.toString());
        }
    }

    public void onCreate(Bundle bundle) {
        Fragment.super.onCreate(bundle);
        this.q = new com.ipaulpro.afilechooser.a((Context)this.getActivity());
        String string = this.getArguments() != null ? this.getArguments().getString("path") : Environment.getExternalStorageDirectory().getAbsolutePath();
        this.r = string;
    }

    public b.o.b.b<List<File>> s(int n2, Bundle bundle) {
        return new c((Context)this.getActivity(), this.r);
    }

    public void u(ListView listView, View view, int n2, long l2) {
        com.ipaulpro.afilechooser.a a2 = (com.ipaulpro.afilechooser.a)listView.getAdapter();
        if (a2 != null) {
            File file = a2.b(n2);
            this.r = file.getAbsolutePath();
            this.s.b(file);
        }
    }

}

