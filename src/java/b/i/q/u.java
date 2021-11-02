/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.PointerIcon
 *  java.lang.Object
 */
package b.i.q;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class u {
    private Object a;

    private u(Object object) {
        this.a = object;
    }

    public static u b(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new u((Object)PointerIcon.getSystemIcon((Context)context, (int)n2));
        }
        return new u(null);
    }

    public Object a() {
        return this.a;
    }
}

