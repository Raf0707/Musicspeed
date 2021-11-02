/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.media.MediaMetadataRetriever
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Process
 *  com.smp.musicspeed.effects.CompressorPrefModel
 *  com.smp.musicspeed.effects.EchoPrefModel
 *  com.smp.musicspeed.effects.FlangerPrefModel
 *  com.smp.musicspeed.effects.LimiterPrefModel
 *  com.smp.musicspeed.effects.MonoPrefModel
 *  com.smp.musicspeed.effects.ReverbPrefModel
 *  com.smp.musicspeed.effects.VocalPrefModel
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.smp.musicspeed.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.smp.musicspeed.effects.CompressorPrefModel;
import com.smp.musicspeed.effects.EchoPrefModel;
import com.smp.musicspeed.effects.FlangerPrefModel;
import com.smp.musicspeed.effects.LimiterPrefModel;
import com.smp.musicspeed.effects.MonoPrefModel;
import com.smp.musicspeed.effects.ReverbPrefModel;
import com.smp.musicspeed.effects.VocalPrefModel;
import com.smp.musicspeed.equalizer.l;
import com.smp.musicspeed.player.ElastiquePlayer;
import com.smp.musicspeed.player.g;
import com.smp.musicspeed.player.h;
import com.smp.musicspeed.player.i;
import com.smp.musicspeed.player.k;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.t;
import java.io.IOException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ElastiquePlayer
implements g {
    public static boolean a;
    private volatile boolean b;
    private String c;
    private k d;
    private Handler e;
    private volatile long f;
    private volatile long g;
    private Context h;
    private volatile boolean i;
    private ScheduledThreadPoolExecutor j = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> k;
    private String l;
    private String m;
    private String n;
    private h o;
    private Runnable p = new Runnable(this){
        final /* synthetic */ ElastiquePlayer f;
        {
            this.f = elastiquePlayer;
        }

        public void run() {
            if (!this.f.isFinished()) {
                if (ElastiquePlayer.a(this.f)) {
                    ElastiquePlayer.c(this.f, true);
                    if (ElastiquePlayer.d(this.f) != null) {
                        ElastiquePlayer.d(this.f).b("Decoder Error");
                    }
                } else if (ElastiquePlayer.e(this.f) && !ElastiquePlayer.f(this.f) && !this.f.isPaused()) {
                    this.f.pause();
                    if (ElastiquePlayer.d(this.f) != null) {
                        ElastiquePlayer.d(this.f).c();
                    }
                }
                if (!ElastiquePlayer.b(this.f) && !this.f.isPaused()) {
                    long l2 = this.f.getPlayedDuration();
                    double d2 = (double)l2 / (double)this.f.getDuration();
                    if (ElastiquePlayer.d(this.f) != null) {
                        ElastiquePlayer.d(this.f).a(d2, l2);
                    }
                }
            }
        }
    };
    private Runnable q = new Runnable(this){
        final /* synthetic */ ElastiquePlayer f;
        {
            this.f = elastiquePlayer;
        }

        public void run() {
            ElastiquePlayer.g(this.f);
            if (ElastiquePlayer.h(this.f) != null) {
                ElastiquePlayer.h(this.f).d();
            }
        }
    };

    static {
        System.loadLibrary((String)"c++_shared");
        System.loadLibrary((String)"mp3lame");
        System.loadLibrary((String)"avutil");
        System.loadLibrary((String)"swresample");
        System.loadLibrary((String)"avcodec");
        System.loadLibrary((String)"avformat");
        System.loadLibrary((String)"avfilter");
        System.loadLibrary((String)"oboe");
        System.loadLibrary((String)"ModernTimeStretch");
        System.loadLibrary((String)"ElastiquePlayer");
    }

    public ElastiquePlayer(String string, Context context, float f3, float f4, int n2) throws IOException {
        boolean bl;
        this.e = new Handler(context.getMainLooper());
        this.h = context.getApplicationContext();
        int n3 = t.l(context);
        int n4 = t.t(context);
        if (n4 == -1) {
            n4 = t.k(context);
        }
        if (bl = t.v(context)) {
            n4 = h.c(n3) / 2 / 2 / 2;
        }
        int n5 = n4;
        int n6 = Build.VERSION.SDK_INT;
        boolean bl2 = com.smp.musicspeed.utils.k.o(context);
        String string2 = t.a(PlayingQueue.getDefault(), context);
        AppPrefs appPrefs = AppPrefs.k;
        this.newElastiquePlayer(string, n3, n5, f3, f4, n2, bl, n6, bl2, string2, appPrefs.f0());
        if (this.loadSuccessNative()) {
            this.c = string;
            if (appPrefs.B() || appPrefs.A() || com.smp.musicspeed.utils.k.d() || com.smp.musicspeed.utils.k.j()) {
                com.smp.musicspeed.bpmkey.a.f.h(this.getFileName());
            }
            this.j();
            this.l();
            this.setEffectsParameters();
            this.stopAudioNative();
            this.g = Long.MIN_VALUE;
            this.f = Long.MIN_VALUE;
            a = true;
            if (bl) {
                this.o = new h(context, n3, 2 * (n5 * 2));
                return;
            }
            int n7 = this.getAudioSessionIdNative();
            if (n7 != -1) {
                i.b(context, n7);
            }
            return;
        }
        throw new IOException();
    }

    public ElastiquePlayer(String string, Context context, int n2) throws IOException {
        this(string, context, 1.0f, 1.0f, n2);
    }

    static /* synthetic */ boolean a(ElastiquePlayer elastiquePlayer) {
        return elastiquePlayer.isErrorNative();
    }

    static /* synthetic */ boolean b(ElastiquePlayer elastiquePlayer) {
        return elastiquePlayer.i;
    }

    static /* synthetic */ boolean c(ElastiquePlayer elastiquePlayer, boolean bl) {
        elastiquePlayer.i = bl;
        return bl;
    }

    static /* synthetic */ k d(ElastiquePlayer elastiquePlayer) {
        return elastiquePlayer.d;
    }

    static /* synthetic */ boolean e(ElastiquePlayer elastiquePlayer) {
        return elastiquePlayer.eofEncounteredNative();
    }

    private native void endLoopNative();

    private native boolean eofEncounteredNative();

    static /* synthetic */ boolean f(ElastiquePlayer elastiquePlayer) {
        return elastiquePlayer.b;
    }

    static /* synthetic */ void g(ElastiquePlayer elastiquePlayer) {
        elastiquePlayer.stopAudioNative();
    }

    private native int getAudioSessionIdNative();

    private native int getBufferSizeInFramesNative();

    private native long getDurationNative();

    private native String[] getMetaDataNative();

    private native float getPitchSemiNative();

    private native long getPlayedDurationNative();

    private native double getPlayedDurationPercentNative();

    private native float getRateNative();

    private native float getTempoNative();

    static /* synthetic */ h h(ElastiquePlayer elastiquePlayer) {
        return elastiquePlayer.o;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void i() {
        Throwable throwable;
        MediaMetadataRetriever mediaMetadataRetriever;
        block4 : {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(this.c);
                this.m = mediaMetadataRetriever.extractMetadata(2);
                this.l = mediaMetadataRetriever.extractMetadata(7);
                this.n = mediaMetadataRetriever.extractMetadata(1);
            }
            catch (Throwable throwable2) {}
            mediaMetadataRetriever.release();
            return;
            break block4;
            catch (Throwable throwable3) {
                mediaMetadataRetriever = null;
                throwable = throwable3;
            }
        }
        mediaMetadataRetriever.release();
        throw throwable;
    }

    public static void init() {
    }

    private native boolean isErrorNative();

    private native boolean isPausedNative();

    /*
     * Exception decompiling
     */
    private void j() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl6 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private void k() {
        String[] arrstring = this.getMetaDataNative();
        this.m = arrstring[0];
        this.l = arrstring[1];
        this.n = arrstring[2];
    }

    private void l() {
        this.setEqualizerLevels(l.e(this.h), l.f(this.h), l.c(this.h), l.d(this.h), l.a(this.h), l.b(this.h));
    }

    private native boolean loadSuccessNative();

    private native boolean newElastiquePlayer(String var1, int var2, int var3, float var4, float var5, int var6, boolean var7, int var8, boolean var9, String var10, int var11);

    private native void onPlayPause(boolean var1);

    private native void seekToPerNative(double var1, boolean var3);

    private native void seekToPosNative(long var1, boolean var3);

    private native void setEffectsLevelsNative(boolean var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16, boolean var17, float var18, float var19, boolean var20, float var21, float var22, float var23, float var24, float var25, boolean var26, float var27, float var28, boolean var29, float var30, float var31, float var32, boolean var33, float var34, float var35, float var36, float var37, float var38, float var39);

    private native void setEqualizerLevelsNative(boolean var1, float var2, boolean var3, float[] var4, boolean var5, float var6);

    private native void setPitchSemiNative(float var1);

    private native void setRateNative(float var1);

    private native void setTempoNative(float var1);

    private native void setVolumeNative(float var1);

    private native void startAudioNative();

    private native void startDecodeLoop();

    private native boolean startLoopNative(long var1, long var3);

    private native void startProcessLoop();

    private native void stopAudioNative();

    private native void stopNative();

    public static int testDevice(Context context) {
        String string = ((AudioManager)context.getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (string == null) {
            string = "44100";
        }
        Process.setThreadPriority((int)-19);
        int n2 = ElastiquePlayer.testDeviceNative(Integer.parseInt((String)string));
        Process.setThreadPriority((int)0);
        return n2;
    }

    private static native int testDeviceNative(int var0);

    private native void toForegroundNative(boolean var1);

    @Override
    public void clearLoopPoints() {
        this.g = Long.MIN_VALUE;
        this.f = Long.MIN_VALUE;
        this.endLoopNative();
    }

    @Override
    public String getAlbum() {
        return this.n;
    }

    @Override
    public String getArtist() {
        return this.m;
    }

    public int getChannels() {
        return 0;
    }

    @Override
    public long getDuration() {
        return this.getDurationNative();
    }

    @Override
    public String getFileName() {
        return this.c;
    }

    @Override
    public long getLoopEnd() {
        return this.g;
    }

    @Override
    public long getLoopStart() {
        return this.f;
    }

    @Override
    public float getPitchSemi() {
        return this.getPitchSemiNative();
    }

    @Override
    public long getPlayedDuration() {
        return this.getPlayedDurationNative();
    }

    public double getPlayedDurationPercent() {
        return this.getPlayedDurationPercentNative();
    }

    @Override
    public float getRate() {
        return this.getRateNative();
    }

    public int getSamplingRate() {
        return 0;
    }

    public int getSessionId() {
        return 0;
    }

    @Override
    public float getTempo() {
        return this.getTempoNative();
    }

    @Override
    public String getTitle() {
        return this.l;
    }

    @Override
    public boolean isFinished() {
        return this.i;
    }

    @Override
    public boolean isPaused() {
        return this.isPausedNative();
    }

    public boolean isRepeat() {
        return this.b;
    }

    @Override
    public void pause() {
        this.onPlayPause(false);
        this.e.postDelayed(this.q, 1024L);
    }

    @Override
    public void play() {
        if (this.i) {
            try {
                throw new IllegalStateException("ElastiquePlayer.java was stopped when play was called");
            }
            catch (IllegalStateException illegalStateException) {
                illegalStateException.printStackTrace();
            }
        }
        this.e.removeCallbacks(this.q);
        this.startAudioNative();
        h h2 = this.o;
        if (h2 != null) {
            h2.e();
        }
        this.onPlayPause(true);
        ScheduledFuture<?> scheduledFuture = this.k;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.k = this.j.scheduleWithFixedDelay(this.p, 0L, 16L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void seekTo(double d2, boolean bl) {
        this.seekToPerNative(d2, bl);
    }

    @Override
    public void seekTo(long l2) {
        this.seekToPosNative(l2, false);
    }

    @Override
    public void setEffectsLevels(boolean bl, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl2, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean bl3, float f17, float f18, boolean bl4, float f19, float f20, float f21, float f22, float f23, boolean bl5, float f24, float f25, boolean bl6, float f26, float f27, float f28, boolean bl7, float f29, float f30, float f31, float f32, float f33, float f34) {
        this.setEffectsLevelsNative(bl, f3, f4, f5, f6, f7, f8, bl2, f9, f10, f11, f12, f13, f14, f15, f16, bl3, f17, f18, bl4, f19, f20, f21, f22, f23, bl5, f24, f25, bl6, f26, f27, f28, bl7, f29, f30, f31, f32, f33, f34);
    }

    public void setEffectsParameters() {
        ReverbPrefModel reverbPrefModel = ReverbPrefModel.m;
        boolean bl = reverbPrefModel.V();
        float f3 = reverbPrefModel.U();
        float f4 = reverbPrefModel.Y();
        float f5 = reverbPrefModel.R();
        float f6 = reverbPrefModel.X();
        float f7 = reverbPrefModel.W();
        float f8 = reverbPrefModel.T();
        CompressorPrefModel compressorPrefModel = CompressorPrefModel.m;
        boolean bl2 = compressorPrefModel.V();
        float f9 = compressorPrefModel.b0();
        float f10 = compressorPrefModel.U();
        float f11 = compressorPrefModel.W();
        float f12 = compressorPrefModel.R();
        float f13 = compressorPrefModel.Z();
        float f14 = compressorPrefModel.Y();
        float f15 = compressorPrefModel.a0();
        float f16 = compressorPrefModel.T();
        VocalPrefModel vocalPrefModel = VocalPrefModel.m;
        boolean bl3 = vocalPrefModel.U();
        float f17 = vocalPrefModel.T();
        float f18 = vocalPrefModel.S();
        EchoPrefModel echoPrefModel = EchoPrefModel.m;
        boolean bl4 = echoPrefModel.Y();
        float f19 = echoPrefModel.W();
        float f20 = echoPrefModel.Z();
        float f21 = echoPrefModel.U();
        float f22 = echoPrefModel.T();
        float f23 = echoPrefModel.V();
        MonoPrefModel monoPrefModel = MonoPrefModel.m;
        boolean bl5 = monoPrefModel.T();
        float f24 = monoPrefModel.S();
        float f25 = monoPrefModel.U();
        LimiterPrefModel limiterPrefModel = LimiterPrefModel.m;
        boolean bl6 = limiterPrefModel.T();
        float f26 = limiterPrefModel.R();
        float f27 = limiterPrefModel.V();
        float f28 = limiterPrefModel.U();
        FlangerPrefModel flangerPrefModel = FlangerPrefModel.m;
        this.setEffectsLevelsNative(bl, f3, f4, f5, f6, f7, f8, bl2, f9, f10, f11, f12, f13, f14, f15, f16, bl3, f17, f18, bl4, f19, f20, f21, f22, f23, bl5, f24, f25, bl6, f26, f27, f28, flangerPrefModel.Y(), flangerPrefModel.a0(), flangerPrefModel.W(), flangerPrefModel.Z(), flangerPrefModel.T(), flangerPrefModel.V(), flangerPrefModel.U());
    }

    @Override
    public void setEqualizerLevels(boolean bl, float f3, boolean bl2, float[] arrf, boolean bl3, float f4) {
        this.setEqualizerLevelsNative(bl, f3, bl2, arrf, bl3, f4);
    }

    @Override
    public void setLoopEnd(long l2) {
        Process.setThreadPriority((int)-19);
        this.g = l2;
        if (this.f != Long.MIN_VALUE && this.g != Long.MIN_VALUE) {
            this.startLoopNative(this.f, this.g);
        }
        Process.setThreadPriority((int)0);
    }

    @Override
    public void setLoopStart(long l2) {
        Process.setThreadPriority((int)-19);
        this.f = l2;
        if (this.f != Long.MIN_VALUE && this.g != Long.MIN_VALUE) {
            this.startLoopNative(this.f, this.g);
        }
        Process.setThreadPriority((int)0);
    }

    @Override
    public void setOnProgressChangedListener(k k2) {
        this.d = k2;
    }

    @Override
    public void setPitchSemi(float f3) {
        this.setPitchSemiNative(f3);
    }

    @Override
    public void setRate(float f3) {
        this.setRateNative(f3);
    }

    @Override
    public void setRepeat(boolean bl) {
        this.b = bl;
    }

    @Override
    public void setTempo(float f3) {
        this.setTempoNative(f3);
    }

    @Override
    public void setVolume(float f3, float f4) {
        this.setVolumeNative((f3 + f4) / 2.0f);
    }

    @Override
    public void start() {
        this.i = false;
        Process.setThreadPriority((int)-16);
        this.startDecodeLoop();
        Process.setThreadPriority((int)-19);
        this.startProcessLoop();
        Process.setThreadPriority((int)0);
    }

    @Override
    public void stop() {
        int n2;
        this.i = true;
        ScheduledFuture<?> scheduledFuture = this.k;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.j.shutdown();
        try {
            this.j.awaitTermination(2L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        this.e.removeCallbacks(this.q);
        int n3 = this.getBufferSizeInFramesNative();
        if (n3 > 0) {
            t.N(this.h, n3);
        }
        if (this.o == null && (n2 = this.getAudioSessionIdNative()) != -1) {
            i.a(this.h, n2);
        }
        this.stopNative();
        h h2 = this.o;
        if (h2 != null) {
            h2.f(this.h);
        }
    }

    @Override
    public void toForeground(boolean bl) {
        if (!this.i) {
            this.toForegroundNative(bl);
        }
    }

    public void write(short[] arrs) {
        h h2;
        if (!this.i && (h2 = this.o) != null) {
            h2.g(arrs);
        }
    }
}

