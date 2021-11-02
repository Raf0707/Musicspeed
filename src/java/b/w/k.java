/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  android.graphics.Rect
 *  java.lang.Object
 */
package b.w;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class k
implements TypeEvaluator<Rect> {
    private Rect a;

    k() {
    }

    public Rect a(float f2, Rect rect, Rect rect2) {
        int n2 = rect.left;
        int n3 = n2 + (int)(f2 * (float)(rect2.left - n2));
        int n4 = rect.top;
        int n5 = n4 + (int)(f2 * (float)(rect2.top - n4));
        int n6 = rect.right;
        int n7 = n6 + (int)(f2 * (float)(rect2.right - n6));
        int n8 = rect.bottom;
        int n9 = n8 + (int)(f2 * (float)(rect2.bottom - n8));
        Rect rect3 = this.a;
        if (rect3 == null) {
            return new Rect(n3, n5, n7, n9);
        }
        rect3.set(n3, n5, n7, n9);
        return this.a;
    }
}

