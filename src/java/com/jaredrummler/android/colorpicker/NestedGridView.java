/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.GridView
 */
package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class NestedGridView
extends GridView {
    public NestedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int n2, int n3) {
        super.onMeasure(n2, View.MeasureSpec.makeMeasureSpec((int)536870911, (int)Integer.MIN_VALUE));
    }
}

