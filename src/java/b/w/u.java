/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 */
package b.w;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.w.w;
import b.w.z;

class u
extends z
implements w {
    u(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static u g(ViewGroup viewGroup) {
        return (u)z.e((View)viewGroup);
    }

    @Override
    public void c(View view) {
        this.a.b(view);
    }

    @Override
    public void d(View view) {
        this.a.g(view);
    }
}

