/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.NumberPicker
 *  android.widget.NumberPicker$Formatter
 *  com.smp.musicspeed.i0.m
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.i0;

import android.widget.NumberPicker;
import com.smp.musicspeed.i0.m;

public final class f
implements NumberPicker.Formatter {
    public static final /* synthetic */ f a;

    static /* synthetic */ {
        a = new f();
    }

    private /* synthetic */ f() {
    }

    public final String format(int n2) {
        return m.q0((int)n2);
    }
}

