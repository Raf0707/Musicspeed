/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.mopub.mobileads.d0
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.markers;

import com.mopub.mobileads.d0;
import f.z.d.k;

public final class k0 {
    private final String a;
    private final long b;

    public k0(String string2, long l2) {
        k.g((Object)string2, (String)"path");
        this.a = string2;
        this.b = l2;
    }

    public final long a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof k0)) {
            return false;
        }
        k0 k02 = (k0)object;
        if (!k.c((Object)this.a, (Object)k02.a)) {
            return false;
        }
        return this.b == k02.b;
    }

    public int hashCode() {
        return 31 * this.a.hashCode() + d0.a((long)this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackInfo(path=");
        stringBuilder.append(this.a);
        stringBuilder.append(", durationUs=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

