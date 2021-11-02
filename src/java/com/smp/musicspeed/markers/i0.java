/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.mopub.mobileads.d0
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.markers;

import com.mopub.mobileads.d0;

public final class i0 {
    private final long a;
    private final long b;
    private final long c;

    public i0(long l2, long l3, long l4) {
        this.a = l2;
        this.b = l3;
        this.c = l4;
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof i0)) {
            return false;
        }
        i0 i02 = (i0)object;
        if (this.a != i02.a) {
            return false;
        }
        if (this.b != i02.b) {
            return false;
        }
        return this.c == i02.c;
    }

    public int hashCode() {
        return 31 * (31 * d0.a((long)this.a) + d0.a((long)this.b)) + d0.a((long)this.c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MinSecMs(minutes=");
        stringBuilder.append(this.a);
        stringBuilder.append(", seconds=");
        stringBuilder.append(this.b);
        stringBuilder.append(", millis=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

