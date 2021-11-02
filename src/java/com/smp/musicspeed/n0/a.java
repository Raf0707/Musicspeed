/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.UriPermission
 *  java.lang.Object
 *  java.util.Comparator
 */
package com.smp.musicspeed.n0;

import android.content.UriPermission;
import com.smp.musicspeed.n0.c;
import java.util.Comparator;

public final class a
implements Comparator {
    public static final /* synthetic */ a f;

    static /* synthetic */ {
        f = new a();
    }

    private /* synthetic */ a() {
    }

    public final int compare(Object object, Object object2) {
        return c.g((UriPermission)object, (UriPermission)object2);
    }
}

