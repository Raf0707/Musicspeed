/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.filewriter.FileWriterService
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.smp.musicspeed.filewriter;

import com.smp.musicspeed.filewriter.FileWriterService;
import java.io.File;

public final class c
implements Runnable {
    public final /* synthetic */ FileWriterService f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ File h;

    public /* synthetic */ c(FileWriterService fileWriterService, boolean bl, File file) {
        this.f = fileWriterService;
        this.g = bl;
        this.h = file;
    }

    public final void run() {
        this.f.g(this.g, this.h);
    }
}

