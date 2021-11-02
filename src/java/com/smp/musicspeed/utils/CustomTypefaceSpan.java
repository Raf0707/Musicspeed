/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Typeface
 *  android.text.TextPaint
 *  android.text.style.TypefaceSpan
 *  java.lang.String
 */
package com.smp.musicspeed.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan
extends TypefaceSpan {
    private final Typeface f;

    public CustomTypefaceSpan(String string2, Typeface typeface) {
        super(string2);
        this.f = typeface;
    }

    private static void l(Paint paint, Typeface typeface) {
        Typeface typeface2 = paint.getTypeface();
        int n2 = typeface2 == null ? 0 : typeface2.getStyle();
        int n3 = n2 & typeface.getStyle();
        if ((n3 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((n3 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        CustomTypefaceSpan.l((Paint)textPaint, this.f);
    }

    public void updateMeasureState(TextPaint textPaint) {
        CustomTypefaceSpan.l((Paint)textPaint, this.f);
    }
}

