/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.TextView
 *  c.d.a.a.i
 *  c.d.a.a.n.b
 *  com.github.stkent.amplify.prompt.DefaultLayoutPromptViewConfig
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.String
 */
package com.github.stkent.amplify.prompt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import c.d.a.a.i;
import com.github.stkent.amplify.prompt.DefaultLayoutPromptViewConfig;
import com.github.stkent.amplify.prompt.b;

@SuppressLint(value={"ViewConstructor"})
final class d
extends b {
    d(Context context, DefaultLayoutPromptViewConfig defaultLayoutPromptViewConfig) {
        super(context, i.a);
        TextView textView = this.f();
        if (textView != null) {
            this.setBackgroundColor(defaultLayoutPromptViewConfig.q());
            this.g().setTextColor(defaultLayoutPromptViewConfig.z());
            textView.setTextColor(defaultLayoutPromptViewConfig.y());
            this.p(this.e(), defaultLayoutPromptViewConfig.x());
            this.p(this.d(), defaultLayoutPromptViewConfig.u());
            this.j(defaultLayoutPromptViewConfig);
            this.i(context, defaultLayoutPromptViewConfig);
            return;
        }
        throw new IllegalStateException("Provided layout does not include views with required ids.");
    }

    private void i(Context context, DefaultLayoutPromptViewConfig defaultLayoutPromptViewConfig) {
        Integer n2 = defaultLayoutPromptViewConfig.n();
        Integer n3 = defaultLayoutPromptViewConfig.o();
        Integer n4 = this.k(n2, c.d.a.a.n.b.a((Context)context, (int)1));
        Integer n5 = this.k(n3, 0);
        this.o(this.e(), defaultLayoutPromptViewConfig.v(), defaultLayoutPromptViewConfig.w(), n4, n5);
        this.o(this.d(), defaultLayoutPromptViewConfig.s(), defaultLayoutPromptViewConfig.t(), n4, n5);
    }

    private void j(DefaultLayoutPromptViewConfig defaultLayoutPromptViewConfig) {
        Integer n2 = defaultLayoutPromptViewConfig.p();
        if (n2 != null) {
            this.g().setTextSize(0, (float)n2.intValue());
            this.q(this.e(), n2);
            this.q(this.d(), n2);
            TextView textView = this.f();
            if (textView != null) {
                textView.setTextSize(0, (float)n2.intValue());
            }
        }
    }

    private int k(Integer n2, int n3) {
        if (n2 != null) {
            n3 = n2;
        }
        return n3;
    }

    private Drawable l(int n2, int n3, int n4, int n5) {
        Drawable drawable = this.n(n2, n3, n4, n5);
        float[] arrf = new float[3];
        Color.colorToHSV((int)n2, (float[])arrf);
        int n6 = Color.alpha((int)n2);
        float[] arrf2 = new float[]{arrf[0], arrf[1], Math.max((float)(arrf[2] - 0.1f), (float)0.0f)};
        Drawable drawable2 = this.n(Color.HSVToColor((int)n6, (float[])arrf2), n3, n4, n5);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842910}, drawable);
        return stateListDrawable;
    }

    private RoundRectShape m(int n2) {
        float f2 = n2;
        float[] arrf = new float[]{f2, f2, f2, f2, f2, f2, f2, f2};
        return new RoundRectShape(arrf, null, null);
    }

    private Drawable n(int n2, int n3, int n4, int n5) {
        ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)this.m(n5));
        shapeDrawable.getPaint().setColor(n3);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable((Shape)this.m(n5 - n4));
        shapeDrawable2.getPaint().setColor(n2);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, shapeDrawable2});
        layerDrawable.setLayerInset(1, n4, n4, n4, n4);
        return layerDrawable;
    }

    private void o(View view, int n2, int n3, int n4, int n5) {
        Drawable drawable = this.l(n2, n3, n4, n5);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    private void p(View view, int n2) {
        if (view instanceof TextView) {
            ((TextView)view).setTextColor(n2);
        }
    }

    private void q(View view, int n2) {
        if (view instanceof TextView) {
            ((TextView)view).setTextSize(0, (float)n2);
        }
    }
}

