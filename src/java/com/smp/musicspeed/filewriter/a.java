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

public final class a
implements Runnable {
    public final /* synthetic */ FileWriterService f;
    public final /* synthetic */ File g;
    public final /* synthetic */ float h;
    public final /* synthetic */ float i;
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;
    public final /* synthetic */ float n;
    public final /* synthetic */ float o;
    public final /* synthetic */ float[] p;
    public final /* synthetic */ boolean q;

    public /* synthetic */ a(FileWriterService fileWriterService, File file, float f2, float f3, int n2, int n3, long l2, long l3, float f4, float f5, float[] arrf, boolean bl) {
        this.f = fileWriterService;
        this.g = file;
        this.h = f2;
        this.i = f3;
        this.j = n2;
        this.k = n3;
        this.l = l2;
        this.m = l3;
        this.n = f4;
        this.o = f5;
        this.p = arrf;
        this.q = bl;
    }

    public final void run() {
        this.f.k(this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
    }
}

