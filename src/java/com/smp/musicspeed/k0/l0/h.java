/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.k0.l0;

import com.smp.musicspeed.dbrecord.MediaTrack;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class h {
    private final List<MediaTrack> a;
    private final int b;
    private final boolean c;
    private final boolean d;

    public h(List<MediaTrack> list, int n2, boolean bl, boolean bl2) {
        k.g(list, (String)"tracks");
        this.a = list;
        this.b = n2;
        this.c = bl;
        this.d = bl2;
    }

    public /* synthetic */ h(List list, int n2, boolean bl, boolean bl2, int n3, g g2) {
        if ((n3 & 4) != 0) {
            bl = false;
        }
        if ((n3 & 8) != 0) {
            bl2 = true;
        }
        this((List<MediaTrack>)list, n2, bl, bl2);
    }

    public final boolean a() {
        return this.d;
    }

    public final int b() {
        return this.b;
    }

    public final List<MediaTrack> c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }
}

