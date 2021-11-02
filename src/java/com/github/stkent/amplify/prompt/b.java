/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  c.d.a.a.h
 *  com.github.stkent.amplify.prompt.b$a
 *  com.github.stkent.amplify.prompt.b$b
 *  com.github.stkent.amplify.prompt.i.c
 *  com.github.stkent.amplify.prompt.i.d
 *  com.github.stkent.amplify.prompt.i.e
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
import com.github.stkent.amplify.prompt.b;
import com.github.stkent.amplify.prompt.i.c;
import com.github.stkent.amplify.prompt.i.d;
import com.github.stkent.amplify.prompt.i.e;

@SuppressLint(value={"ViewConstructor"})
class b
extends FrameLayout
implements e {
    private final TextView f;
    private final TextView g;
    private final View h;
    private final View i;
    private d j;

    b(Context context, int n2) {
        super(context);
        LayoutInflater.from((Context)context).inflate(n2, (ViewGroup)this, true);
        TextView textView = (TextView)this.findViewById(h.d);
        View view = this.findViewById(h.b);
        View view2 = this.findViewById(h.a);
        if (textView != null && view != null && view2 != null) {
            this.f = textView;
            this.g = (TextView)this.findViewById(h.c);
            this.h = view;
            this.i = view2;
            view.setOnClickListener((View.OnClickListener)new a(this));
            view2.setOnClickListener((View.OnClickListener)new b(this));
            return;
        }
        throw new IllegalStateException("Provided layout does not include views with required ids.");
    }

    static /* synthetic */ d c(b b2) {
        return b2.j;
    }

    private void h(View view, String string) {
        if (view instanceof TextView) {
            ((TextView)view).setText((CharSequence)string);
        }
    }

    public void a(c c2) {
        this.f.setText((CharSequence)c2.getTitle());
        this.h(this.h, c2.c());
        this.h(this.i, c2.b());
        String string = c2.a();
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

    public void b(d d2) {
        this.j = d2;
    }

    protected View d() {
        return this.i;
    }

    protected View e() {
        return this.h;
    }

    protected TextView f() {
        return this.g;
    }

    protected TextView g() {
        return this.f;
    }
}

