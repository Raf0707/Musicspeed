/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  java.lang.Object
 */
package b.w;

import android.os.IBinder;
import b.w.m0;

class k0
implements m0 {
    private final IBinder a;

    k0(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object object) {
        return object instanceof k0 && ((k0)object).a.equals((Object)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

