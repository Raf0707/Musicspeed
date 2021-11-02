/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.util.Comparator
 */
package com.smp.musicspeed.utils;

import com.smp.musicspeed.utils.g;
import java.io.File;
import java.util.Comparator;

public final class b
implements Comparator {
    public static final /* synthetic */ b f;

    static /* synthetic */ {
        f = new b();
    }

    private /* synthetic */ b() {
    }

    public final int compare(Object object, Object object2) {
        return g.i((File)object, (File)object2);
    }
}

