/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioTrack
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.player;

import android.content.Context;
import android.media.AudioTrack;
import com.smp.musicspeed.player.i;
import f.z.d.g;
import f.z.d.k;

public final class h {
    public static final a a = new a(null);
    private final AudioTrack b;

    public h(Context context, int n2, int n3) {
        AudioTrack audioTrack;
        k.g((Object)context, (String)"context");
        this.b = audioTrack = new AudioTrack(3, n2, 12, 2, n3, 1);
        audioTrack.play();
        this.b(context);
    }

    private final void a(Context context) {
        i.a(context, this.b.getAudioSessionId());
    }

    private final void b(Context context) {
        i.b(context, this.b.getAudioSessionId());
    }

    public static final int c(int n2) {
        return a.a(n2);
    }

    public final void d() {
        h h2 = this;
        synchronized (h2) {
            this.b.pause();
            return;
        }
    }

    public final void e() {
        h h2 = this;
        synchronized (h2) {
            this.b.play();
            return;
        }
    }

    public final void f(Context context) {
        h h2 = this;
        synchronized (h2) {
            k.g((Object)context, (String)"context");
            this.a(context);
            this.b.pause();
            this.b.release();
            return;
        }
    }

    public final void g(short[] arrs) {
        k.g((Object)arrs, (String)"data");
        this.b.write(arrs, 0, arrs.length);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final int a(int n2) {
            return AudioTrack.getMinBufferSize((int)n2, (int)12, (int)2);
        }
    }

}

