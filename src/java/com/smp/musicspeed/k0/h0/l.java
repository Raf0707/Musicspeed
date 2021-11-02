/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.k0.h0;

import android.content.Context;
import com.smp.musicspeed.dbrecord.MediaTrack;
import f.z.d.k;
import java.util.List;

public final class l {
    private final Context a;
    private final List<MediaTrack> b;

    public l(Context context, List<MediaTrack> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"oldDataSet");
        this.a = context;
        this.b = list;
    }

    public final Context a() {
        return this.a;
    }

    public final List<MediaTrack> b() {
        return this.b;
    }
}

