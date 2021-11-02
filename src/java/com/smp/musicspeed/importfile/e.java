/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.importfile.h
 *  java.lang.Object
 *  java.util.Comparator
 */
package com.smp.musicspeed.importfile;

import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.importfile.h;
import java.util.Comparator;

public final class e
implements Comparator {
    public static final /* synthetic */ e f;

    static /* synthetic */ {
        f = new e();
    }

    private /* synthetic */ e() {
    }

    public final int compare(Object object, Object object2) {
        return h.b.b((MediaTrack)object, (MediaTrack)object2);
    }
}

