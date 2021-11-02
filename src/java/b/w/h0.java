/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.view.View
 */
package b.w;

import android.graphics.Matrix;
import android.view.View;
import b.w.g0;

class h0
extends g0 {
    h0() {
    }

    @Override
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override
    public void e(View view, int n2, int n3, int n4, int n5) {
        view.setLeftTopRightBottom(n2, n3, n4, n5);
    }

    @Override
    public void f(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override
    public void g(View view, int n2) {
        view.setTransitionVisibility(n2);
    }

    @Override
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}

