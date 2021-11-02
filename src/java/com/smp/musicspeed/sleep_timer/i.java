/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.g
 *  java.lang.Object
 */
package com.smp.musicspeed.sleep_timer;

import com.smp.musicspeed.sleep_timer.h;
import f.z.d.g;

public final class i {
    public static final a a = new a(null);
    private final int b;
    private final int c;

    public i(int n2, int n3) {
        this.b = n2;
        this.c = n3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final long c() {
        return h.a(this.b) + h.b(this.c);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final i a(long l2) {
            long l3 = l2 / (long)1000;
            long l4 = 60;
            long l5 = l3 / l4;
            long l6 = l5 / l4;
            long l7 = l5 % l4;
            return new i((int)l6, (int)l7);
        }
    }

}

