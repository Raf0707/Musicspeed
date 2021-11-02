/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowId
 *  java.lang.Object
 */
package b.w;

import android.view.View;
import android.view.WindowId;
import b.w.m0;

class l0
implements m0 {
    private final WindowId a;

    l0(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object object) {
        return object instanceof l0 && ((l0)object).a.equals((Object)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

