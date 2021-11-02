/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.filewriter.FileWriterService
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.smp.musicspeed.filewriter;

import com.smp.musicspeed.filewriter.FileWriterService;

public final class b
implements Runnable {
    public final /* synthetic */ FileWriterService f;
    public final /* synthetic */ double g;

    public /* synthetic */ b(FileWriterService fileWriterService, double d2) {
        this.f = fileWriterService;
        this.g = d2;
    }

    public final void run() {
        this.f.i(this.g);
    }
}

