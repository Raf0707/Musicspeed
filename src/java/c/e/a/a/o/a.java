/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.Checkable
 *  android.widget.FrameLayout
 *  androidx.cardview.widget.CardView
 *  c.e.a.a.a0.k
 *  c.e.a.a.a0.n
 *  c.e.a.a.b
 *  c.e.a.a.k
 *  c.e.a.a.o.a$a
 *  c.e.a.a.o.b
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 */
package c.e.a.a.o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import c.e.a.a.a0.n;
import c.e.a.a.k;
import c.e.a.a.o.a;
import c.e.a.a.o.b;

public class a
extends CardView
implements Checkable,
n {
    private static final int[] o = new int[]{16842911};
    private static final int[] p = new int[]{16842912};
    private static final int[] q;
    private static final int r;
    private final b s;
    private boolean t;
    private boolean u;
    private boolean v;
    private a w;

    static {
        int[] arrn = new int[]{c.e.a.a.b.state_dragged};
        q = arrn;
        r = k.Widget_MaterialComponents_CardView;
    }

    private void g() {
        if (Build.VERSION.SDK_INT <= 26) {
            return;
        }
        throw null;
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    float getCardViewRadius() {
        return a.super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public c.e.a.a.a0.k getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    public boolean h() {
        if (this.s == null) {
            return false;
        }
        throw null;
    }

    public boolean i() {
        return this.v;
    }

    public boolean isChecked() {
        return this.u;
    }

    protected void onAttachedToWindow() {
        FrameLayout.super.onAttachedToWindow();
        throw null;
    }

    protected int[] onCreateDrawableState(int n2) {
        int[] arrn = FrameLayout.super.onCreateDrawableState(n2 + 3);
        if (this.h()) {
            FrameLayout.mergeDrawableStates((int[])arrn, (int[])o);
        }
        if (this.isChecked()) {
            FrameLayout.mergeDrawableStates((int[])arrn, (int[])p);
        }
        if (this.i()) {
            FrameLayout.mergeDrawableStates((int[])arrn, (int[])q);
        }
        return arrn;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        FrameLayout.super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)"androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        FrameLayout.super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)"androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(this.h());
        accessibilityNodeInfo.setClickable(this.isClickable());
        accessibilityNodeInfo.setChecked(this.isChecked());
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.getMeasuredWidth();
        this.getMeasuredHeight();
        throw null;
    }

    public void setBackground(Drawable drawable) {
        this.setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.t) {
            return;
        }
        throw null;
    }

    void setBackgroundInternal(Drawable drawable) {
        FrameLayout.super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int n2) {
        ColorStateList.valueOf((int)n2);
        throw null;
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean bl) {
        throw null;
    }

    public void setChecked(boolean bl) {
        if (this.u != bl) {
            this.toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconMargin(int n2) {
        throw null;
    }

    public void setCheckedIconMarginResource(int n2) {
        if (n2 == -1) {
            return;
        }
        this.getResources().getDimensionPixelSize(n2);
        throw null;
    }

    public void setCheckedIconResource(int n2) {
        b.a.k.a.a.d(this.getContext(), n2);
        throw null;
    }

    public void setCheckedIconSize(int n2) {
        throw null;
    }

    public void setCheckedIconSizeResource(int n2) {
        if (n2 == 0) {
            return;
        }
        this.getResources().getDimensionPixelSize(n2);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setClickable(boolean bl) {
        FrameLayout.super.setClickable(bl);
        if (this.s == null) {
            return;
        }
        throw null;
    }

    public void setDragged(boolean bl) {
        if (this.v != bl) {
            this.v = bl;
            this.refreshDrawableState();
            this.g();
            this.invalidate();
        }
    }

    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        throw null;
    }

    public void setOnCheckedChangeListener(a a2) {
        this.w = a2;
    }

    public void setPreventCornerOverlap(boolean bl) {
        super.setPreventCornerOverlap(bl);
        throw null;
    }

    public void setProgress(float f2) {
        throw null;
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int n2) {
        b.a.k.a.a.c(this.getContext(), n2);
        throw null;
    }

    public void setShapeAppearanceModel(c.e.a.a.a0.k k2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.setClipToOutline(k2.u(this.getBoundsAsRectF()));
        }
        throw null;
    }

    public void setStrokeColor(int n2) {
        ColorStateList.valueOf((int)n2);
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeWidth(int n2) {
        throw null;
    }

    public void setUseCompatPadding(boolean bl) {
        super.setUseCompatPadding(bl);
        throw null;
    }

    public void toggle() {
        if (this.h() && this.isEnabled()) {
            this.u = true ^ this.u;
            this.refreshDrawableState();
            this.g();
            a a2 = this.w;
            if (a2 != null) {
                a2.a(this, this.u);
            }
        }
    }
}

