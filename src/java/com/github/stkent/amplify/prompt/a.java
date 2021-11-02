/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  c.d.a.a.j
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.f
 *  com.github.stkent.amplify.prompt.BasePromptViewConfig
 *  com.github.stkent.amplify.prompt.a$c
 *  com.github.stkent.amplify.prompt.i.a$b
 *  com.github.stkent.amplify.prompt.i.a$c
 *  com.github.stkent.amplify.prompt.i.b
 *  com.github.stkent.amplify.prompt.i.c
 *  com.github.stkent.amplify.prompt.i.d
 *  com.github.stkent.amplify.prompt.i.e
 *  com.github.stkent.amplify.prompt.i.f
 *  com.github.stkent.amplify.prompt.i.g
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.github.stkent.amplify.prompt;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.d.a.a.j;
import com.github.stkent.amplify.prompt.BasePromptViewConfig;
import com.github.stkent.amplify.prompt.a;
import com.github.stkent.amplify.prompt.i.a;
import com.github.stkent.amplify.prompt.i.d;
import com.github.stkent.amplify.prompt.i.e;
import com.github.stkent.amplify.prompt.i.f;
import com.github.stkent.amplify.prompt.i.g;

abstract class a<T extends View, U extends View>
extends FrameLayout
implements com.github.stkent.amplify.prompt.i.b {
    private final d f = new d(){

        public void a() {
            a.this.h.c(a.c.f);
        }

        public void b() {
            a.this.h.c(a.c.g);
        }
    };
    private final d g = new d(){

        public void a() {
            a.this.h.b(a.b.f);
        }

        public void b() {
            a.this.h.b(a.b.g);
        }
    };
    private com.github.stkent.amplify.prompt.i.a h;
    private BasePromptViewConfig i;
    private T j;
    private boolean k;

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.o(attributeSet);
        if (!this.isInEditMode()) {
            this.h = new com.github.stkent.amplify.prompt.f(c.d.a.a.m.a.k(), this);
        }
    }

    static /* synthetic */ boolean h(a a2, boolean bl) {
        a2.k = bl;
        return bl;
    }

    static /* synthetic */ void i(a a2) {
        a2.n();
    }

    private void l() {
        this.j = null;
    }

    private void m() {
        if (this.j == null) {
            T t2 = this.getQuestionView();
            this.j = t2;
            this.setDisplayedView((View)t2);
        }
    }

    private void n() {
        this.removeAllViews();
        this.setVisibility(8);
    }

    private void o(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(attributeSet, j.p, 0, 0);
        this.i = new BasePromptViewConfig(typedArray);
        typedArray.recycle();
    }

    private void setDisplayedView(View view) {
        this.removeAllViews();
        this.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        this.setVisibility(0);
    }

    public final void a(boolean bl) {
        if (!bl) {
            this.h.a((c.d.a.a.m.f.d)c.d.a.a.m.d.h);
        }
        this.l();
        this.n();
    }

    public final boolean b() {
        return this.getThanksView() != null;
    }

    public final void c() {
        this.m();
        ((e)this.j).b(this.g);
        ((e)this.j).a(this.i.p());
    }

    public final void d(boolean bl) {
        if (this.p()) {
            if (!bl) {
                this.h.a((c.d.a.a.m.f.d)c.d.a.a.m.d.f);
            }
            this.m();
            ((e)this.j).b(this.f);
            ((e)this.j).a(this.i.w());
            return;
        }
        throw new IllegalStateException("PromptView is not fully configured.");
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    public final void e() {
        this.m();
        ((e)this.j).b(this.g);
        ((e)this.j).a(this.i.l());
    }

    public final void f(boolean bl) {
        if (!bl) {
            this.h.a((c.d.a.a.m.f.d)c.d.a.a.m.d.g);
        }
        this.l();
        if (!this.k) {
            U u2 = this.getThanksView();
            ((g)u2).a(this.i.t());
            this.setDisplayedView((View)u2);
            Long l2 = this.i.u();
            if (l2 != null) {
                this.postDelayed((Runnable)new c(this, u2), l2.longValue());
                return;
            }
        } else {
            this.n();
        }
    }

    public final com.github.stkent.amplify.prompt.i.a getPresenter() {
        return this.h;
    }

    protected abstract T getQuestionView();

    protected abstract U getThanksView();

    public void j(c.d.a.a.m.f.f f2) {
        this.h.f(f2);
    }

    public void k(BasePromptViewConfig basePromptViewConfig) {
        if (!this.q()) {
            this.i = basePromptViewConfig;
            return;
        }
        throw new IllegalStateException("Configuration cannot be changed after the prompt is first displayed.");
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle)parcelable;
        if (bundle != null) {
            super.onRestoreInstanceState(bundle.getParcelable("SUPER_STATE_KEY"));
            BasePromptViewConfig basePromptViewConfig = (BasePromptViewConfig)bundle.getParcelable("BASE_PROMPT_VIEW_CONFIG_KEY");
            if (basePromptViewConfig != null) {
                this.i = basePromptViewConfig;
            }
            this.k = bundle.getBoolean("THANKS_DISPLAY_TIME_EXPIRED_KEY");
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE_KEY", parcelable);
        bundle.putParcelable("BASE_PROMPT_VIEW_CONFIG_KEY", (Parcelable)this.i);
        bundle.putBoolean("THANKS_DISPLAY_TIME_EXPIRED_KEY", this.k);
        bundle.putBundle("PROMPT_PRESENTER_STATE_BUNDLE_KEY", this.h.d());
        return bundle;
    }

    protected abstract boolean p();

    protected final boolean q() {
        return this.getChildCount() > 0;
    }

    protected final void r(Parcelable parcelable) {
        Bundle bundle;
        Bundle bundle2 = (Bundle)parcelable;
        if (bundle2 != null && (bundle = bundle2.getBundle("PROMPT_PRESENTER_STATE_BUNDLE_KEY")) != null) {
            this.h.e(bundle);
        }
    }

}

