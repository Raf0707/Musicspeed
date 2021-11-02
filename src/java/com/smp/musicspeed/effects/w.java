/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.b
 *  f.u.l
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.effects;

import f.d0.b;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class w {
    private final b<Float> a;
    private final int b;
    private final List<Float> c;
    private final Float d;
    private final boolean e;

    public w(b<Float> b2, int n2, List<Float> list, Float f2, boolean bl) {
        k.g(b2, (String)"range");
        k.g(list, (String)"acceptableValues");
        this.a = b2;
        this.b = n2;
        this.c = list;
        this.d = f2;
        this.e = bl;
    }

    public /* synthetic */ w(b b2, int n2, List list, Float f2, boolean bl, int n3, g g2) {
        if ((n3 & 4) != 0) {
            list = l.d();
        }
        List list2 = list;
        if ((n3 & 8) != 0) {
            f2 = null;
        }
        Float f3 = f2;
        boolean bl2 = (n3 & 16) != 0 ? false : bl;
        this((b<Float>)b2, n2, (List<Float>)list2, f3, bl2);
    }

    public final List<Float> a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final Float c() {
        return this.d;
    }

    public final b<Float> d() {
        return this.a;
    }

    public final boolean e() {
        return this.e;
    }
}

