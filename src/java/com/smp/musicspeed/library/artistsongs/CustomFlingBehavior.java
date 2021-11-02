/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$c
 *  androidx.recyclerview.widget.RecyclerView
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior
 *  com.google.android.material.appbar.AppBarLayout$BaseBehavior$d
 *  com.google.android.material.appbar.AppBarLayout$Behavior
 *  com.google.android.material.appbar.AppBarLayout$Behavior$a
 */
package com.smp.musicspeed.library.artistsongs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.smp.musicspeed.library.artistsongs.CustomFlingBehavior;

public final class CustomFlingBehavior
extends AppBarLayout.Behavior {
    private boolean s;
    private boolean t = true;

    public CustomFlingBehavior() {
        this.z0();
    }

    public CustomFlingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z0();
    }

    static /* synthetic */ boolean u0(CustomFlingBehavior customFlingBehavior) {
        return customFlingBehavior.t;
    }

    private void z0() {
        this.o0((AppBarLayout.BaseBehavior.d)new AppBarLayout.Behavior.a(this){
            final /* synthetic */ CustomFlingBehavior a;
            {
                this.a = customFlingBehavior;
            }

            public boolean a(AppBarLayout appBarLayout) {
                return CustomFlingBehavior.u0(this.a);
            }
        });
    }

    public boolean v0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3, boolean bl) {
        if (f3 > 0.0f && !this.s || f3 < 0.0f && this.s) {
            f3 *= -1.0f;
        }
        float f4 = f3;
        if (view instanceof RecyclerView && f4 < 0.0f) {
            RecyclerView recyclerView = (RecyclerView)view;
            int n2 = recyclerView.j0(recyclerView.getChildAt(0));
            bl = false;
            if (n2 > 3) {
                bl = true;
            }
        }
        return CoordinatorLayout.c.super.n(coordinatorLayout, (View)appBarLayout, view, f2, f4, bl);
    }

    public void w0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int n2, int n3, int[] arrn) {
        CoordinatorLayout.c.super.p(coordinatorLayout, (View)appBarLayout, view, n2, n3, arrn);
        boolean bl = n3 > 0;
        this.s = bl;
    }

    public void x0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int n2, int n3, int n4, int n5, int n6) {
        CoordinatorLayout.c.super.s(coordinatorLayout, (View)appBarLayout, view, n2, n3, n4, n5, n6);
    }

    public boolean y0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int n2) {
        return this.t && CoordinatorLayout.c.super.z(coordinatorLayout, (View)appBarLayout, view, view2, n2);
    }
}

