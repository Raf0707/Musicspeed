/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.folders.v
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Object
 */
package com.smp.musicspeed.folders;

import com.smp.musicspeed.folders.v;
import java.io.File;
import java.io.FileFilter;

public final class f
implements FileFilter {
    public static final /* synthetic */ f a;

    static /* synthetic */ {
        a = new f();
    }

    private /* synthetic */ f() {
    }

    public final boolean accept(File file) {
        return v.R((File)file);
    }
}

