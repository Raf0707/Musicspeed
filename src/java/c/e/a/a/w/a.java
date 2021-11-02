/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.RadioButton
 *  androidx.appcompat.widget.AppCompatRadioButton
 *  androidx.core.widget.c
 *  c.e.a.a.b
 *  c.e.a.a.k
 *  c.e.a.a.l
 *  c.e.a.a.q.a
 *  c.e.a.a.x.c
 *  com.google.android.material.internal.j
 *  com.google.android.material.theme.a.a
 */
package c.e.a.a.w;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.c;
import c.e.a.a.b;
import c.e.a.a.k;
import c.e.a.a.l;
import com.google.android.material.internal.j;

public class a
extends AppCompatRadioButton {
    private static final int i = k.Widget_MaterialComponents_CompoundButton_RadioButton;
    private static final int[][] j = new int[][]{{16842910, 16842912}, {16842910, -16842912}, {-16842910, 16842912}, {-16842910, -16842912}};
    private ColorStateList k;
    private boolean l;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    public a(Context context, AttributeSet attributeSet, int n2) {
        int n3 = i;
        super(com.google.android.material.theme.a.a.c((Context)context, (AttributeSet)attributeSet, (int)n2, (int)n3), attributeSet, n2);
        Context context2 = this.getContext();
        TypedArray typedArray = j.h((Context)context2, (AttributeSet)attributeSet, (int[])l.MaterialRadioButton, (int)n2, (int)n3, (int[])new int[0]);
        int n4 = l.MaterialRadioButton_buttonTint;
        if (typedArray.hasValue(n4)) {
            c.c((CompoundButton)this, (ColorStateList)c.e.a.a.x.c.a((Context)context2, (TypedArray)typedArray, (int)n4));
        }
        this.l = typedArray.getBoolean(l.MaterialRadioButton_useMaterialThemeColors, false);
        typedArray.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.k == null) {
            int n2 = c.e.a.a.q.a.c((View)this, (int)b.colorControlActivated);
            int n3 = c.e.a.a.q.a.c((View)this, (int)b.colorOnSurface);
            int n4 = c.e.a.a.q.a.c((View)this, (int)b.colorSurface);
            int[][] arrn = j;
            int[] arrn2 = new int[arrn.length];
            arrn2[0] = c.e.a.a.q.a.f((int)n4, (int)n2, (float)1.0f);
            arrn2[1] = c.e.a.a.q.a.f((int)n4, (int)n3, (float)0.54f);
            arrn2[2] = c.e.a.a.q.a.f((int)n4, (int)n3, (float)0.38f);
            arrn2[3] = c.e.a.a.q.a.f((int)n4, (int)n3, (float)0.38f);
            this.k = new ColorStateList(arrn, arrn2);
        }
        return this.k;
    }

    protected void onAttachedToWindow() {
        RadioButton.super.onAttachedToWindow();
        if (this.l && c.b((CompoundButton)this) == null) {
            this.setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean bl) {
        this.l = bl;
        if (bl) {
            c.c((CompoundButton)this, (ColorStateList)this.getMaterialThemeColorsTintList());
            return;
        }
        c.c((CompoundButton)this, null);
    }
}

