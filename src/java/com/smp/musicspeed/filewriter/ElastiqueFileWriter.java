/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.smp.musicspeed.effects.CompressorPrefModel
 *  com.smp.musicspeed.effects.EchoPrefModel
 *  com.smp.musicspeed.effects.FlangerPrefModel
 *  com.smp.musicspeed.effects.LimiterPrefModel
 *  com.smp.musicspeed.effects.MonoPrefModel
 *  com.smp.musicspeed.effects.ReverbPrefModel
 *  com.smp.musicspeed.effects.VocalPrefModel
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package com.smp.musicspeed.filewriter;

import com.smp.musicspeed.effects.CompressorPrefModel;
import com.smp.musicspeed.effects.EchoPrefModel;
import com.smp.musicspeed.effects.FlangerPrefModel;
import com.smp.musicspeed.effects.LimiterPrefModel;
import com.smp.musicspeed.effects.MonoPrefModel;
import com.smp.musicspeed.effects.ReverbPrefModel;
import com.smp.musicspeed.effects.VocalPrefModel;
import com.smp.musicspeed.filewriter.ElastiqueFileWriter;
import com.smp.musicspeed.filewriter.f;
import com.smp.musicspeed.filewriter.g;
import com.smp.musicspeed.filewriter.h;
import com.smp.musicspeed.utils.AppPrefs;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ElastiqueFileWriter
implements f {
    private volatile boolean a;
    private h b;
    private ScheduledExecutorService c;
    private Runnable d = new Runnable(this){
        final /* synthetic */ ElastiqueFileWriter f;
        {
            this.f = elastiqueFileWriter;
        }

        public void run() {
            if (!ElastiqueFileWriter.c(this.f)) {
                ElastiqueFileWriter.e(this.f).b(ElastiqueFileWriter.d(this.f));
            }
        }
    };
    private String e;
    private String f;
    private boolean g;

    public ElastiqueFileWriter(String string, String string2, String string3, float f3, float f4, int n2, int n3, long l2, long l3, float f5, float f6, float[] arrf, boolean bl) {
        this.f();
        this.e = string;
        this.f = string2;
        boolean[] arrbl = new boolean[7];
        VocalPrefModel vocalPrefModel = VocalPrefModel.m;
        arrbl[0] = vocalPrefModel.U();
        CompressorPrefModel compressorPrefModel = CompressorPrefModel.m;
        arrbl[1] = compressorPrefModel.V();
        LimiterPrefModel limiterPrefModel = LimiterPrefModel.m;
        arrbl[2] = limiterPrefModel.T();
        FlangerPrefModel flangerPrefModel = FlangerPrefModel.m;
        arrbl[3] = flangerPrefModel.Y();
        EchoPrefModel echoPrefModel = EchoPrefModel.m;
        arrbl[4] = echoPrefModel.Y();
        ReverbPrefModel reverbPrefModel = ReverbPrefModel.m;
        arrbl[5] = reverbPrefModel.V();
        MonoPrefModel monoPrefModel = MonoPrefModel.m;
        arrbl[6] = monoPrefModel.T();
        float[] arrf2 = new float[]{vocalPrefModel.T(), vocalPrefModel.S()};
        float[] arrf3 = new float[]{compressorPrefModel.b0(), compressorPrefModel.U(), compressorPrefModel.W(), compressorPrefModel.R(), compressorPrefModel.Z(), compressorPrefModel.Y(), compressorPrefModel.a0(), compressorPrefModel.T()};
        float[] arrf4 = new float[]{limiterPrefModel.R(), limiterPrefModel.V(), limiterPrefModel.U()};
        float[] arrf5 = new float[]{flangerPrefModel.a0(), flangerPrefModel.W(), flangerPrefModel.Z(), flangerPrefModel.T(), flangerPrefModel.V(), flangerPrefModel.U()};
        float[] arrf6 = new float[]{echoPrefModel.W(), echoPrefModel.Z(), echoPrefModel.U(), echoPrefModel.T(), echoPrefModel.V()};
        float[] arrf7 = new float[]{reverbPrefModel.U(), reverbPrefModel.Y(), reverbPrefModel.R(), reverbPrefModel.X(), reverbPrefModel.W(), reverbPrefModel.T()};
        float[] arrf8 = new float[]{monoPrefModel.S(), monoPrefModel.U()};
        this.g = bl;
        this.newElastiqueFileWriter(string, string2, string3, f3, f4, n2, n3, l2, l3, f5, f6, arrf, bl, arrbl, arrf2, arrf3, arrf4, arrf5, arrf6, arrf7, arrf8, AppPrefs.k.f0());
    }

    static /* synthetic */ boolean c(ElastiqueFileWriter elastiqueFileWriter) {
        return elastiqueFileWriter.a;
    }

    static /* synthetic */ double d(ElastiqueFileWriter elastiqueFileWriter) {
        return elastiqueFileWriter.getProgressPercentageNative();
    }

    static /* synthetic */ h e(ElastiqueFileWriter elastiqueFileWriter) {
        return elastiqueFileWriter.b;
    }

    private void f() {
        this.c = Executors.newScheduledThreadPool((int)1);
    }

    private native double getProgressPercentageNative();

    private native void newElastiqueFileWriter(String var1, String var2, String var3, float var4, float var5, int var6, int var7, long var8, long var10, float var12, float var13, float[] var14, boolean var15, boolean[] var16, float[] var17, float[] var18, float[] var19, float[] var20, float[] var21, float[] var22, float[] var23, int var24);

    private native long startNative();

    private native void stopNative();

    @Override
    public String a() {
        return this.f;
    }

    @Override
    public void b(h h2) {
        this.b = h2;
    }

    @Override
    public void start() {
        this.c.scheduleWithFixedDelay(this.d, 0L, 500L, TimeUnit.MILLISECONDS);
        this.a = false;
        long l2 = this.startNative() LCMP 0L;
        if (l2 > 0) {
            g.a(this.e, this.f);
        }
        h h2 = this.b;
        boolean bl = false;
        if (l2 > 0) {
            bl = true;
        }
        h2.a(bl);
    }

    @Override
    public void stop() {
        this.a = true;
        this.c.shutdown();
        try {
            this.c.awaitTermination(4L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        this.stopNative();
    }
}

