/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$n
 *  androidx.recyclerview.widget.RecyclerView$p
 *  androidx.recyclerview.widget.RecyclerView$z
 *  java.lang.Math
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.utils.t;

public class i
extends RecyclerView.n {
    private Drawable a;
    private int b;

    public i(Drawable drawable, int n2) {
        this.a = drawable;
        this.b = n2;
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z z2) {
        int n2 = recyclerView.getPaddingLeft() + Math.round((float)t.b(recyclerView.getContext(), this.b));
        int n3 = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int n4 = recyclerView.getChildCount();
        for (int i2 = 0; i2 <= n4 - 2; ++i2) {
            View view = recyclerView.getChildAt(i2);
            if (view != null && view.getId() == 2131296405) continue;
            RecyclerView.p p2 = (RecyclerView.p)view.getLayoutParams();
            int n5 = view.getBottom() + p2.bottomMargin;
            int n6 = n5 + this.a.getIntrinsicHeight();
            this.a.setAlpha((int)(255.0f * view.getAlpha()));
            this.a.setBounds(Math.round((float)((float)n2 + view.getTranslationX())), Math.round((float)((float)n5 + view.getTranslationY())), Math.round((float)((float)n3 + view.getTranslationX())), Math.round((float)((float)n6 + view.getTranslationY())));
            this.a.draw(canvas);
        }
    }
}

