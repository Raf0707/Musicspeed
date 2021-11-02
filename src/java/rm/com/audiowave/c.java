/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.c.a
 *  java.lang.Object
 *  java.lang.Runnable
 */
package rm.com.audiowave;

import f.z.c.a;
import rm.com.audiowave.AudioWaveView;

public final class c
implements Runnable {
    public final /* synthetic */ byte[] f;
    public final /* synthetic */ AudioWaveView g;
    public final /* synthetic */ a h;

    public /* synthetic */ c(byte[] arrby, AudioWaveView audioWaveView, a a2) {
        this.f = arrby;
        this.g = audioWaveView;
        this.h = a2;
    }

    public final void run() {
        AudioWaveView.z(this.f, this.g, this.h);
    }
}

