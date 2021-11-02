/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.dbrecord;

import com.smp.musicspeed.e.g.I;
import f.z.d.k;

public final class Converters {
    public final int intFromMediaType(I i2) {
        k.g((Object)((Object)i2), (String)"value");
        return i2.ordinal();
    }

    public final I mediaTypeFromInt(int n2) {
        return I.values()[n2];
    }
}

