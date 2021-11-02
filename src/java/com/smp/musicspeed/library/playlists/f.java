/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.library.playlists;

import f.z.d.k;
import java.io.File;

public final class f {
    private final File a;
    private final boolean b;

    public f(File file, boolean bl) {
        k.g((Object)file, (String)"file");
        this.a = file;
        this.b = bl;
    }

    public final File a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }
}

