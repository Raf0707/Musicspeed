/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.view.View
 *  android.widget.TextView
 *  b.i.q.w
 *  c.i.c.o.b
 *  c.i.c.o.c
 *  java.lang.Object
 */
package c.i.c.o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import b.i.q.w;
import c.i.c.i;
import c.i.c.o.b;
import c.i.c.o.c;

public class a {
    private int a = i.a;
    private Drawable b;
    private b c;
    private b d;
    private b e;
    private ColorStateList f;
    private c g;
    private c h = c.c((int)2);
    private c i = c.c((int)3);
    private c j = c.c((int)20);

    public b a() {
        return this.c;
    }

    public b b() {
        return this.d;
    }

    public c c() {
        return this.g;
    }

    public int d() {
        return this.a;
    }

    public void e(TextView textView, ColorStateList colorStateList) {
        Context context = textView.getContext();
        Drawable drawable = this.b;
        if (drawable == null) {
            w.v0((View)textView, (Drawable)new c.i.c.r.j.a(this).a(context));
        } else {
            w.v0((View)textView, (Drawable)drawable);
        }
        b b2 = this.e;
        if (b2 != null) {
            c.i.d.k.a.a((c.i.d.k.a)b2, textView, null);
        } else {
            ColorStateList colorStateList2 = this.f;
            if (colorStateList2 != null) {
                textView.setTextColor(colorStateList2);
            } else if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
        int n2 = this.i.a(context);
        int n3 = this.h.a(context);
        textView.setPadding(n2, n3, n2, n3);
        textView.setMinWidth(this.j.a(context));
    }
}

