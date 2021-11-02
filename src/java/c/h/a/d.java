/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ArrayAdapter
 *  android.widget.TextView
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c.h.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.List;

class d
extends ArrayAdapter<File> {
    private final LayoutInflater f;

    public d(Context context, List<File> list) {
        super(context, 0, list);
        this.f = LayoutInflater.from((Context)context);
    }

    private void a(TextView textView, File file) {
        textView.setText((CharSequence)file.getName());
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView)view;
        if (textView == null) {
            textView = (TextView)this.f.inflate(17367043, null);
        }
        this.a(textView, (File)this.getItem(n2));
        return textView;
    }
}

