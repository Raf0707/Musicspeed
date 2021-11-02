/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.FrameLayout
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SquareLayout
extends FrameLayout {
    private boolean f = true;

    public SquareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int n2, int n3) {
        if (this.f) {
            n3 = n2;
        }
        super.onMeasure(n2, n3);
    }
}

