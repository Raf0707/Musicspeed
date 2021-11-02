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

public final class d
implements FileFilter {
    public static final /* synthetic */ d a;

    static /* synthetic */ {
        a = new d();
    }

    private /* synthetic */ d() {
    }

    public final boolean accept(File file) {
        return v.c0((File)file);
    }
}

