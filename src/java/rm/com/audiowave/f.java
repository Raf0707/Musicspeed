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

public final class f
implements Runnable {
    public final /* synthetic */ byte[] f;
    public final /* synthetic */ int g;
    public final /* synthetic */ l h;

    public /* synthetic */ f(byte[] arrby, int n2, l l2) {
        this.f = arrby;
        this.g = n2;
        this.h = l2;
    }

    public final void run() {
        m.f(this.f, this.g, this.h);
    }
}

