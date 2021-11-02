/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.ipaulpro.afilechooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ipaulpro.afilechooser.d;
import com.ipaulpro.afilechooser.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class a
extends BaseAdapter {
    private static final int f = d.b;
    private static final int g = d.a;
    private final LayoutInflater h;
    private List<File> i = new ArrayList();

    public a(Context context) {
        this.h = LayoutInflater.from((Context)context);
    }

    public void a() {
        this.i.clear();
        this.notifyDataSetChanged();
    }

    public File b(int n2) {
        return (File)this.i.get(n2);
    }

    public void c(List<File> list) {
        this.i = list;
        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.i.size();
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.h.inflate(e.a, viewGroup, false);
        }
        TextView textView = (TextView)view;
        File file = this.b(n2);
        textView.setText((CharSequence)file.getName());
        int n3 = file.isDirectory() ? f : g;
        textView.setCompoundDrawablesWithIntrinsicBounds(n3, 0, 0, 0);
        return view;
    }
}

