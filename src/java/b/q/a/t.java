/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  b.q.a.j
 *  b.q.a.t$a
 *  java.lang.Math
 */
package b.q.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import b.q.a.j;
import b.q.a.t;

/*
 * Exception performing whole class analysis.
 */
class t
extends j {
    t(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    private int getPositivePaddingBottom() {
        return Math.max((int)this.getPaddingBottom(), (int)0);
    }

    private int getPositivePaddingLeft() {
        return Math.max((int)this.getPaddingLeft(), (int)0);
    }

    private int getPositivePaddingRight() {
        return Math.max((int)this.getPaddingRight(), (int)0);
    }

    private int getPositivePaddingTop() {
        return Math.max((int)this.getPaddingTop(), (int)0);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return layoutParams;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6 = this.getChildCount();
        int n7 = this.getPositivePaddingLeft();
        int n8 = n4 - n2 - this.getPositivePaddingRight();
        int n9 = this.getPositivePaddingTop();
        int n10 = n5 - n3 - this.getPositivePaddingBottom();
        for (int i2 = 0; i2 < n6; ++i2) {
            View view = this.getChildAt(i2);
            if (view.getVisibility() == 8) continue;
            int n11 = view.getMeasuredWidth();
            int n12 = view.getMeasuredHeight();
            int n13 = n7 + (n8 - n7 - n11) / 2;
            int n14 = n9 + (n10 - n9 - n12) / 2;
            view.layout(n13, n14, n11 + n13, n12 + n14);
        }
    }

    protected void onMeasure(int n2, int n3) {
        Drawable drawable;
        int n4 = this.getChildCount();
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            View view = this.getChildAt(i2);
            a a2 = view.getLayoutParams();
            if (view.getVisibility() == 8 || a2.a) continue;
            this.measureChild(view, n2, n3);
            n6 = Math.max((int)n6, (int)view.getMeasuredWidth());
            n7 = Math.max((int)n7, (int)view.getMeasuredHeight());
            n8 |= view.getMeasuredState();
        }
        int n9 = n6 + (this.getPositivePaddingLeft() + this.getPositivePaddingRight());
        int n10 = n7 + (this.getPositivePaddingTop() + this.getPositivePaddingBottom());
        int n11 = Math.max((int)n9, (int)this.getSuggestedMinimumWidth());
        int n12 = Math.max((int)n10, (int)this.getSuggestedMinimumHeight());
        if (Build.VERSION.SDK_INT >= 23 && (drawable = this.getForeground()) != null) {
            n11 = Math.max((int)n11, (int)drawable.getMinimumWidth());
            n12 = Math.max((int)n12, (int)drawable.getMinimumHeight());
        }
        this.setMeasuredDimension(ViewGroup.resolveSizeAndState((int)n11, (int)n2, (int)n8), ViewGroup.resolveSizeAndState((int)n12, (int)n3, (int)(n8 << 16)));
        int n13 = View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredWidth() - (this.getPositivePaddingLeft() + this.getPositivePaddingRight())), (int)1073741824);
        int n14 = View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredHeight() - (this.getPositivePaddingTop() + this.getPositivePaddingBottom())), (int)1073741824);
        while (n5 < n4) {
            View view = this.getChildAt(n5);
            a a3 = view.getLayoutParams();
            if (view.getVisibility() != 8 && a3.a) {
                view.measure(n13, n14);
            }
            ++n5;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

