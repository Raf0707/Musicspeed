/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  java.lang.Object
 */
package b.w;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import b.w.w;

class v
implements w {
    private final ViewGroupOverlay a;

    v(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    @Override
    public void c(View view) {
        this.a.add(view);
    }

    @Override
    public void d(View view) {
        this.a.remove(view);
    }
}

