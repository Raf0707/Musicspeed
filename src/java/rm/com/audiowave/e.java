/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.c.l
 *  java.lang.Object
 *  java.lang.Runnable
 */
package rm.com.audiowave;

import f.z.c.l;
import rm.com.audiowave.m;

public final class e
implements Runnable {
    public final /* synthetic */ l f;
    public final /* synthetic */ byte[] g;

    public /* synthetic */ e(l l2, byte[] arrby) {
        this.f = l2;
        this.g = arrby;
    }

    public final void run() {
        m.e(this.f, this.g);
    }
}

