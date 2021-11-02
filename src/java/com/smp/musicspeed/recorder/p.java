/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.media.MediaRecorder
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.w
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.LinkedList
 */
package com.smp.musicspeed.recorder;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.recorder.b0;
import com.smp.musicspeed.recorder.q;
import com.smp.musicspeed.utils.k;
import com.smp.musicspeed.utils.s;
import com.smp.musicspeed.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public final class p {
    private static int a = 3000;
    private int b = 0;
    private b c;
    private volatile long d = 0L;
    private MediaRecorder e;
    private boolean f = false;
    private File g;
    private String h;
    private w<LinkedList<Byte>> i = new w();
    private Uri j;
    private Context k;
    private Runnable l = new d();
    private Handler m = new Handler(Looper.getMainLooper());

    private p() {
        this.i.m((Object)new LinkedList());
    }

    public static p d() {
        Class<p> class_ = p.class;
        synchronized (p.class) {
            p p2 = c.a;
            // ** MonitorExit[var2] (shouldn't be in output)
            return p2;
        }
    }

    private /* synthetic */ void i() {
        this.m.removeCallbacks(this.l);
    }

    private /* synthetic */ void k() {
        this.m.removeCallbacks(this.l);
        ((LinkedList)this.i.f()).clear();
    }

    private void p(int n2) {
        b b2 = this.c;
        if (b2 != null) {
            b2.a(n2);
        }
    }

    public LiveData<LinkedList<Byte>> e() {
        return this.i;
    }

    public int f() {
        MediaRecorder mediaRecorder = this.e;
        if (mediaRecorder == null && this.b != 2) {
            return 0;
        }
        try {
            int n2 = mediaRecorder.getMaxAmplitude();
            return n2;
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public String g() {
        p p2 = this;
        synchronized (p2) {
            String string2 = this.h;
            return string2;
        }
    }

    public int h() {
        return this.b;
    }

    public /* synthetic */ void j() {
        this.i();
    }

    public /* synthetic */ void l() {
        this.k();
    }

    public boolean m() {
        p p2 = this;
        synchronized (p2) {
            block8 : {
                MediaRecorder mediaRecorder = this.e;
                if (mediaRecorder == null) break block8;
                int n2 = this.b;
                if (n2 != 2) break block8;
                try {
                    mediaRecorder.pause();
                }
                catch (IllegalStateException illegalStateException) {
                    return false;
                }
                this.b = 3;
                this.m.post((Runnable)new com.smp.musicspeed.recorder.b(this));
                return true;
            }
            this.p(4);
            return false;
        }
    }

    public long n() {
        int n2 = this.b;
        if (n2 != 2 && n2 != 3) {
            return 0L;
        }
        return System.currentTimeMillis() - this.d;
    }

    public boolean o() {
        p p2 = this;
        synchronized (p2) {
            block8 : {
                MediaRecorder mediaRecorder = this.e;
                if (mediaRecorder == null) break block8;
                int n2 = this.b;
                if (n2 != 3) break block8;
                try {
                    mediaRecorder.resume();
                }
                catch (IllegalStateException illegalStateException) {
                    return false;
                }
                this.b = 2;
                this.m.post(this.l);
                return true;
            }
            this.p(5);
            return false;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean q(int n2, int n3, int n4, int n5, int n6, File file) {
        MediaRecorder mediaRecorder;
        void var10_13;
        p p2 = this;
        // MONITORENTER : p2
        this.s();
        this.e = mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(n2);
        this.e.setOutputFormat(n3);
        this.e.setAudioSamplingRate(n5);
        this.e.setAudioEncodingBitRate(n6);
        this.e.setAudioEncoder(n4);
        this.e.setOutputFile(file.getAbsolutePath());
        this.e.prepare();
        try {
            this.e.start();
            this.f = true;
        }
        catch (RuntimeException runtimeException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("startRecord fail, start fail: ");
            stringBuilder.append(runtimeException.getMessage());
            Log.w((String)"AudioRecorder", (String)stringBuilder.toString());
            this.p(2);
            this.e.reset();
            this.e.release();
            this.e = null;
            this.f = false;
            // MONITOREXIT : p2
            return false;
        }
        this.d = System.currentTimeMillis();
        this.b = 2;
        this.m.post(this.l);
        // MONITOREXIT : p2
        return true;
        catch (RuntimeException runtimeException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("startRecord fail, prepare fail: ");
        stringBuilder.append(var10_13.getMessage());
        Log.w((String)"AudioRecorder", (String)stringBuilder.toString());
        this.p(2);
        this.e.reset();
        this.e.release();
        this.e = null;
        // MONITOREXIT : p2
        return false;
    }

    public boolean r(Context context, String string2) {
        p p2 = this;
        synchronized (p2) {
            b0 b02;
            block4 : {
                b02 = q.h(context, string2);
                if (b02 != null) break block4;
                return false;
            }
            this.h = b02.b();
            this.j = b02.c();
            this.k = b02.a();
            this.g = new File(context.getCacheDir(), "temprecording.aac");
            int n2 = 1000 * Integer.parseInt((String)k.u(context));
            boolean bl = this.q(1, 6, 3, t.l(context), n2, this.g);
            return bl;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int s() {
        p p2 = this;
        synchronized (p2) {
            int n2;
            MediaRecorder mediaRecorder = this.e;
            n2 = -1;
            if (mediaRecorder == null) {
                this.b = 0;
                return n2;
            }
            int n3 = this.b;
            if (n3 == 2 || n3 == 3) {
                long l2;
                try {
                    Thread.sleep((long)300L);
                    Log.i((String)"AudioRecorder", (String)"STOP");
                    this.e.stop();
                    this.f = false;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("duration", Long.valueOf((long)this.n()));
                    contentValues.put("date_modified", Long.valueOf((long)(System.currentTimeMillis() / 1000L)));
                    if (z.d()) {
                        contentValues.put("is_pending", Integer.valueOf((int)0));
                    }
                    s.b(this.k, this.g, this.j);
                    this.k.getContentResolver().update(this.j, contentValues, null, null);
                    l2 = (System.currentTimeMillis() - this.d) / 1000L;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("stopRecord fail, stop fail(no audio data recorded): ");
                    stringBuilder.append(exception.getMessage());
                    Log.w((String)"AudioRecorder", (String)stringBuilder.toString());
                }
                n2 = (int)l2;
            }
            try {
                this.e.reset();
                this.g.delete();
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("stopRecord fail, file descriptor fail ");
                stringBuilder.append(exception.getMessage());
                Log.w((String)"AudioRecorder", (String)stringBuilder.toString());
            }
            this.e.release();
            this.e = null;
            this.b = 0;
            this.m.post((Runnable)new com.smp.musicspeed.recorder.a(this));
            return n2;
        }
    }

    public static interface b {
        public void a(int var1);
    }

    private static class c {
        private static final p a = new p();
    }

    private class d
    implements Runnable {
        private d() {
        }

        public void run() {
            ((LinkedList)p.this.i.f()).addFirst((Object)q.j(p.this.f()));
            if (((LinkedList)p.this.i.f()).size() > a) {
                ((LinkedList)p.this.i.f()).removeLast();
            }
            p.this.i.p((Object)((LinkedList)p.this.i.f()));
            p.this.m.postDelayed((Runnable)this, 16L);
        }
    }

}

