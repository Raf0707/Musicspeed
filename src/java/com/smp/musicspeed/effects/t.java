/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.smp.musicspeed.effects;

import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.smp.musicspeed.effects.p;
import f.z.d.k;

public final class t {
    public static final void a(View view, boolean bl) {
        k.g((Object)view, (String)"view");
        view.getContext();
        if (bl) {
            t.b(view);
            return;
        }
        view.animate().cancel();
        view.setRotation(0.0f);
    }

    private static final void b(View view) {
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        viewPropertyAnimator.setDuration(400L);
        viewPropertyAnimator.rotationBy(360.0f);
        viewPropertyAnimator.withEndAction((Runnable)new p(view));
    }

    private static final void c(View view) {
        k.g((Object)view, (String)"$view");
        t.b(view);
    }

    public static /* synthetic */ void d(View view) {
        t.c(view);
    }
}

