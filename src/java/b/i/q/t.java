/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Objects
 */
package b.i.q;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class t
implements ViewTreeObserver.OnPreDrawListener,
View.OnAttachStateChangeListener {
    private final View f;
    private ViewTreeObserver g;
    private final Runnable h;

    private t(View view, Runnable runnable) {
        this.f = view;
        this.g = view.getViewTreeObserver();
        this.h = runnable;
    }

    public static t a(View view, Runnable runnable) {
        Objects.requireNonNull((Object)view, (String)"view == null");
        Objects.requireNonNull((Object)runnable, (String)"runnable == null");
        t t2 = new t(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)t2);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)t2);
        return t2;
    }

    public void b() {
        if (this.g.isAlive()) {
            this.g.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        } else {
            this.f.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        }
        this.f.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public boolean onPreDraw() {
        this.b();
        this.h.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.g = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        this.b();
    }
}

