/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.os.Process
 *  android.preference.PreferenceManager
 *  android.widget.Toast
 *  androidx.core.app.i
 *  androidx.core.app.i$b
 *  androidx.core.app.i$d
 *  androidx.core.app.i$e
 *  androidx.core.app.o
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 */
package com.smp.musicspeed.filewriter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.widget.Toast;
import androidx.core.app.i;
import androidx.core.app.o;
import com.smp.musicspeed.equalizer.l;
import com.smp.musicspeed.filewriter.ElastiqueFileWriter;
import com.smp.musicspeed.filewriter.a;
import com.smp.musicspeed.filewriter.b;
import com.smp.musicspeed.filewriter.f;
import com.smp.musicspeed.filewriter.h;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.j;
import com.smp.musicspeed.utils.n;
import com.smp.musicspeed.utils.t;
import java.io.File;

public class FileWriterService
extends Service
implements h {
    private Handler f;
    private NotificationManager g;
    private i.d h;
    private File i;
    private String j;
    private PowerManager.WakeLock k;
    private f l;
    Thread m;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c() {
        f f3 = this.l;
        if (f3 != null) {
            f3.stop();
        }
        this.stopForeground(true);
        this.stopSelf();
        Thread thread = this.m;
        if (thread == null) return;
        try {
            thread.join(2000L);
            return;
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private int d() {
        return Integer.parseInt((String)PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext()).getString("preferences_file_kbps", "192"));
    }

    private boolean e() {
        return "mounted".equals((Object)Environment.getExternalStorageState());
    }

    private /* synthetic */ void f(boolean bl, File file) {
        o.a((Service)this, (int)2);
        this.stopSelf();
        if (bl) {
            this.g.notify(6674329, j.k((Context)this, file));
            this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile((File)file)));
            return;
        }
        Toast.makeText((Context)this, (CharSequence)this.getResources().getString(2131821341), (int)0).show();
    }

    private /* synthetic */ void h(double d2) {
        this.h.t(100, (int)(d2 * 100.0), false);
        this.g.notify(6674329, this.h.c());
    }

    private /* synthetic */ void j(File file, float f3, float f4, int n2, int n3, long l2, long l3, float f5, float f6, float[] arrf, boolean bl) {
        Process.setThreadPriority((int)10);
        String string = z.d() ? new File(this.getCacheDir(), this.i.getName()).getAbsolutePath() : this.i.getAbsolutePath();
        String string2 = string;
        ElastiqueFileWriter elastiqueFileWriter = new ElastiqueFileWriter(file.getAbsolutePath(), string2, this.j, f3, f4, n2, n3, l2, l3, f5, f6, arrf, bl);
        this.l = elastiqueFileWriter;
        elastiqueFileWriter.b(this);
        this.l.start();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    @Override
    public void b(double d2) {
        this.f.post((Runnable)new b(this, d2));
    }

    public /* synthetic */ void g(boolean bl, File file) {
        this.f(bl, file);
    }

    public /* synthetic */ void i(double d2) {
        this.h(d2);
    }

    public /* synthetic */ void k(File file, float f3, float f4, int n2, int n3, long l2, long l3, float f5, float f6, float[] arrf, boolean bl) {
        this.j(file, f3, f4, n2, n3, l2, l3, f5, f6, arrf, bl);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        PowerManager.WakeLock wakeLock;
        super.onCreate();
        this.f = new Handler();
        this.g = (NotificationManager)this.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            j.e((Context)this);
        }
        this.h = new i.d((Context)this, "file_save_channel");
        this.k = wakeLock = ((PowerManager)this.getSystemService("power")).newWakeLock(1, "musicspeed:writerwakelock");
        if (!wakeLock.isHeld()) {
            this.k.acquire();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy() {
        try {
            Thread thread = this.m;
            if (thread != null) {
                thread.join(2000L);
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (this.k.isHeld()) {
            this.k.release();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        Thread thread;
        int n4 = this.d();
        float f3 = intent.getFloatExtra("com.smp.musicspeed.TEMPO", 1.0f);
        float f4 = intent.getFloatExtra("com.smp.musicspeed.PITCH", 0.0f);
        int n5 = intent.getBooleanExtra("com.smp.musicspeed.QUALITY", false) ? 0 : 5;
        File file = new File(intent.getStringExtra("com.smp.musicspeed.ILE_NAME_IN"));
        File file2 = new File(intent.getStringExtra("com.smp.musicspeed.ILE_NAME_OUT"));
        this.j = intent.getStringExtra("com.smp.musicspeed.TRACK_NAME_OUT");
        this.i = g.a(file2, g.d(file2.getAbsolutePath()));
        String string = this.j;
        if (string == null || string.equals((Object)"")) {
            this.j = g.j(this.i.getName());
        }
        long l2 = intent.getLongExtra("com.smp.musicspeed.LOOP_START", Long.MIN_VALUE);
        long l3 = intent.getLongExtra("com.smp.musicspeed.LOOP_END", Long.MIN_VALUE);
        if (!this.e()) {
            Toast.makeText((Context)this, (CharSequence)"Can't access internal storage.", (int)1).show();
            this.c();
            return 2;
        }
        float f5 = l.e(this.getApplicationContext()) ? l.f(this.getApplicationContext()) : -3.0f;
        float f6 = l.a(this.getApplicationContext()) ? l.b(this.getApplicationContext()) : 0.0f;
        float[] arrf = l.c(this.getApplicationContext()) ? l.d(this.getApplicationContext()) : new float[8];
        float[] arrf2 = arrf;
        boolean bl = t.x(this.getApplicationContext());
        a a2 = new a(this, file, f3, f4, n4, n5, l2, l3, f5, f6, arrf2, bl);
        this.m = thread = new Thread((Runnable)a2);
        thread.start();
        i.b b2 = new i.b();
        String string2 = this.i.getName();
        String string3 = this.getResources().getString(2131821161);
        b2.n((CharSequence)string3);
        b2.m((CharSequence)string2);
        this.h.m((CharSequence)string2).w((i.e)b2).n((CharSequence)string3).v(2131231003);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getResources().getString(2131821347));
        stringBuilder.append(n.a((Context)this, this.i.getName()));
        Toast.makeText((Context)this, (CharSequence)stringBuilder.toString(), (int)1).show();
        this.h.t(100, 0, false);
        this.startForeground(6674329, this.h.c());
        return 2;
    }
}

