/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  c.d.a.a.h
 *  com.github.stkent.amplify.prompt.i.f
 *  com.github.stkent.amplify.prompt.i.g
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.String
 */
package com.github.stkent.amplify.prompt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.d.a.a.h;
import com.github.stkent.amplify.prompt.i.f;
import com.github.stkent.amplify.prompt.i.g;

@SuppressLint(value={"ViewConstructor"})
class c
extends FrameLayout
implements g {
    private final TextView f;
    private final TextView g;

    c(Context context, int n2) {
        super(context);
        LayoutInflater.from((Context)context).inflate(n2, (ViewGroup)this, true);
        TextView textView = (TextView)this.findViewById(h.d);
        if (textView != null) {
            this.f = textView;
            this.g = (TextView)this.findViewById(h.c);
            return;
        }
        throw new IllegalStateException("Provided layout does not include views with required ids.");
    }

    public void a(f f2) {
        this.f.setText((CharSequence)f2.getTitle());
        String string = f2.a();
        TextView textView = this.g;
        if (textView != null) {
            if (string != null) {
                textView.setText((CharSequence)string);
                this.g.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    protected TextView getSubtitleTextView() {
        return this.g;
    }

    protected TextView getTitleTextView() {
        return this.f;
    }
}

