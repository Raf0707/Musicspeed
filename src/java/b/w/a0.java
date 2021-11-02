/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewOverlay
 *  java.lang.Object
 */
package b.w;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import b.w.b0;

class a0
implements b0 {
    private final ViewOverlay a;

    a0(View view) {
        this.a = view.getOverlay();
    }

    @Override
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}

