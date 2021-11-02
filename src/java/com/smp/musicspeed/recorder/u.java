/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.recorder;

import f.z.d.g;
import f.z.d.k;

public final class u {
    public static final a a = new a(null);
    private final int b;
    private final String c;

    public u(int n2, String string2) {
        k.g((Object)string2, (String)"name");
        this.b = n2;
        this.c = string2;
    }

    public /* synthetic */ u(int n2, String string2, int n3, g g2) {
        if ((n3 & 2) != 0) {
            string2 = "";
        }
        this(n2, string2);
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

