/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Binder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.preference.PreferenceManager
 *  android.support.v4.media.session.MediaControllerCompat
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Callback
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.support.v4.media.session.PlaybackStateCompat$Builder
 *  android.util.DisplayMetrics
 *  android.widget.Toast
 *  androidx.media.l.a
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.g
 *  com.bumptech.glide.r.j.i
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.effects.CompressorPrefModel
 *  com.smp.musicspeed.effects.EchoPrefModel
 *  com.smp.musicspeed.effects.FlangerPrefModel
 *  com.smp.musicspeed.effects.LimiterPrefModel
 *  com.smp.musicspeed.effects.MonoPrefModel
 *  com.smp.musicspeed.effects.ReverbPrefModel
 *  com.smp.musicspeed.effects.VocalPrefModel
 *  com.smp.musicspeed.player.PlayFileService$a
 *  com.smp.musicspeed.player.PlayFileService$b
 *  com.smp.musicspeed.player.PlayFileService$c
 *  java.io.File
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 *  org.greenrobot.eventbus.n
 */
package com.smp.musicspeed.player;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.bumptech.glide.r.j.i;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.dbrecord.PitchKeyLoopsRecord;
import com.smp.musicspeed.effects.CompressorPrefModel;
import com.smp.musicspeed.effects.EchoPrefModel;
import com.smp.musicspeed.effects.FlangerPrefModel;
import com.smp.musicspeed.effects.LimiterPrefModel;
import com.smp.musicspeed.effects.MonoPrefModel;
import com.smp.musicspeed.effects.ReverbPrefModel;
import com.smp.musicspeed.effects.VocalPrefModel;
import com.smp.musicspeed.effects.s;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.player.ElastiquePlayer;
import com.smp.musicspeed.player.MusicSpeedMediaButtonReceiver;
import com.smp.musicspeed.player.PlayFileService;
import com.smp.musicspeed.player.f;
import com.smp.musicspeed.player.g;
import com.smp.musicspeed.player.j;
import com.smp.musicspeed.player.k;
import com.smp.musicspeed.player.l;
import com.smp.musicspeed.player.m;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.playingqueue.p;
import com.smp.musicspeed.playingqueue.v;
import com.smp.musicspeed.reverse.ReverseService;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.e;
import com.smp.musicspeed.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.n;

public class PlayFileService
extends Service
implements k,
AudioManager.OnAudioFocusChangeListener,
SharedPreferences.OnSharedPreferenceChangeListener {
    public static MediaSessionCompat f;
    public static boolean g;
    private g h;
    private l i;
    private PowerManager.WakeLock j;
    PlaybackStateCompat.Builder k;
    private Handler l = new Handler();
    private e m = new Binder(){

        public PlayFileService a() {
            return PlayFileService.this;
        }

        public void b(l l2) {
            PlayFileService.this.i = l2;
        }
    };
    private NotificationManager n;
    private d o;
    private AudioManager p;
    private e.a<String> q;
    private com.smp.musicspeed.utils.e<String> r;
    private String s;
    private boolean t;
    private Runnable u;
    int v;
    private com.bumptech.glide.r.j.g<Bitmap> w;
    private com.bumptech.glide.r.j.g<Bitmap> x;
    private com.bumptech.glide.r.j.g<Bitmap> y;

    public PlayFileService() {
        com.smp.musicspeed.player.b b2;
        this.q = b2 = new com.smp.musicspeed.player.b(this);
        this.r = new com.smp.musicspeed.utils.e(b2, 1000);
        this.s = "mediaState";
        this.t = false;
        this.u = new com.smp.musicspeed.player.e(this);
    }

    private void A0() {
        this.Z();
        this.j0();
        int n2 = Build.VERSION.SDK_INT;
        if (n2 < 26) {
            this.startService(new Intent((Context)this, PlayFileService.class));
        }
        if (n2 >= 26) {
            this.stopForeground(2);
        } else {
            this.stopForeground(false);
        }
        this.o();
    }

    private void B0() {
        MediaSessionCompat mediaSessionCompat = f;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setActive(false);
        }
    }

    private /* synthetic */ void H(String string) {
        this.p0();
    }

    private /* synthetic */ void J() {
        this.t = false;
    }

    private /* synthetic */ void L() {
        l l2;
        Toast.makeText((Context)this, (CharSequence)this.getApplicationContext().getResources().getString(2131821339), (int)0).show();
        int n2 = PlayingQueue.getDefault().getCurrentlyPlaying();
        if (this.w0()) {
            boolean bl = this.D0(n2);
            if (this.j(PlayFileService.class)) {
                if (bl) {
                    this.o();
                } else {
                    this.stopForeground(true);
                    com.smp.musicspeed.utils.j.a((Context)this, 6675451);
                }
            }
        } else {
            this.Z();
            this.h0(false);
            this.l0(0.0f);
            if (this.j(PlayFileService.class)) {
                if (this.h != null) {
                    this.A0();
                } else {
                    this.z0();
                }
            }
        }
        if ((l2 = this.i) != null) {
            l2.d();
        }
    }

    private /* synthetic */ void N(double d2, long l2) {
        long l3;
        long l4;
        MediaSessionCompat mediaSessionCompat;
        l l5 = this.i;
        if (l5 != null) {
            l5.a(d2, l2);
        }
        if (!MainActivity.F && !this.t && (mediaSessionCompat = f) != null && mediaSessionCompat.getController() != null && f.getController().getPlaybackState() != null && Math.abs((long)((l3 = f.getController().getPlaybackState().getPosition()) - (l4 = l2 / 1000L))) > 1000L) {
            this.q0(l4);
        }
    }

    private /* synthetic */ void P() {
        int n2 = t.n(this.getApplicationContext());
        int n3 = PlayingQueue.getDefault().getLength();
        if (this.w0()) {
            this.T(false, true);
            if (this.j(PlayFileService.class)) {
                if (this.h == null) {
                    this.z0();
                    return;
                }
                this.o();
                return;
            }
        } else {
            if (n3 == 1 && n2 == 2 && this.h != null) {
                this.l0(0.0f);
                this.b0();
                return;
            }
            this.p.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this);
            if (this.j(PlayFileService.class)) {
                this.A0();
            }
            this.l0(0.0f);
            g = false;
            org.greenrobot.eventbus.c.d().m((Object)new m());
            l l2 = this.i;
            if (l2 != null) {
                l2.e();
            }
        }
    }

    public static double R(double d2) {
        return Math.log((double)d2) / Math.log((double)2.0);
    }

    private void S(String string, float f3, float f4) throws IOException {
        String string2 = this.getString(2131820708);
        int n2 = Integer.parseInt((String)t.o(this.getApplicationContext()).getString("preferences_buffer_size", string2));
        ElastiquePlayer elastiquePlayer = new ElastiquePlayer(string, this.getApplicationContext(), f3, f4, n2);
        this.h = elastiquePlayer;
        elastiquePlayer.setOnProgressChangedListener(this);
    }

    private void U() {
        if (this.h != null) {
            this.Y();
            l l2 = this.i;
            if (l2 != null) {
                l2.c();
            }
            this.q();
        }
    }

    private void V(boolean bl) {
        if (this.h != null) {
            long l2;
            long l3 = (long)((double)t.s(this.getApplicationContext()) * (double)1000000L);
            long l4 = this.s();
            long l5 = this.x();
            long l6 = l5 + (l2 = bl ? -l3 : l3);
            if (l6 < 0L) {
                l6 = 0L;
            }
            if (l6 > l4) {
                return;
            }
            long l7 = l4 - l3;
            if (l6 > l7) {
                l6 = l7;
            }
            double d2 = (double)l6 / (double)l4;
            this.l0((float)d2);
            l l8 = this.i;
            if (l8 != null) {
                l8.b(d2, l6);
            }
        }
    }

    private void W(long l2) {
        if (this.h != null) {
            long l3 = l2 * 1000L;
            this.k0(l3);
            this.q();
            long l4 = this.s();
            double d2 = (double)l3 / (double)l4;
            l l5 = this.i;
            if (l5 != null) {
                l5.b(d2, l3);
            }
        }
    }

    private void X(boolean bl) {
        if (this.h != null) {
            if (bl) {
                if ((double)this.x() / 1000000.0 > 3.0) {
                    this.l0(0.0f);
                    if (this.i != null && this.F()) {
                        this.i.a(0.0, 0L);
                    }
                } else {
                    this.T(bl, true ^ this.F());
                }
            } else {
                this.T(bl, true ^ this.F());
            }
            if (this.h != null) {
                this.q();
                return;
            }
            this.z0();
        }
    }

    private void Z() {
        if (this.j.isHeld()) {
            this.j.release();
        }
        this.h.pause();
        g = false;
        this.p0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    private float a0(float f3) {
        return (float)(12.0 * PlayFileService.R(f3));
    }

    private void b0() {
        boolean bl = t.y(this.getApplicationContext());
        if (this.p.requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this, 3, 1) != 1 && !bl) {
            Toast.makeText((Context)this, (CharSequence)"Another app is preventing audio playback, can't play.", (int)1).show();
            return;
        }
        if (!this.j.isHeld()) {
            this.j.acquire();
        }
        this.h.play();
        g = true;
        if (f == null) {
            this.e0();
        }
        f.setActive(true);
        this.p0();
        org.greenrobot.eventbus.c.d().m((Object)new m());
    }

    private void c0() {
        this.t = true;
        this.l.removeCallbacks(this.u);
        this.l.postDelayed(this.u, 750L);
    }

    private void e0() {
        MediaSessionCompat mediaSessionCompat;
        if (f != null) {
            return;
        }
        ComponentName componentName = new ComponentName(this.getApplicationContext(), MusicSpeedMediaButtonReceiver.class);
        f = mediaSessionCompat = new MediaSessionCompat(this.getApplicationContext(), "SOUNDPROCESS", componentName, null);
        mediaSessionCompat.setFlags(3);
        f.setCallback((MediaSessionCompat.Callback)new j((Context)this));
        f.setActive(true);
    }

    private void f0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals((Object)"android.media.AUDIO_BECOMING_NOISY") && PlayFileService.this.h != null && !PlayFileService.this.h.isFinished() && !PlayFileService.this.h.isPaused()) {
                    PlayFileService.this.Z();
                    PlayFileService.this.j0();
                    if (PlayFileService.this.i != null) {
                        PlayFileService.this.i.c();
                    }
                    PlayFileService.this.l();
                }
            }
        };
        this.o = broadcastReceiver;
        this.registerReceiver(broadcastReceiver, intentFilter);
    }

    static /* synthetic */ NotificationManager i(PlayFileService playFileService) {
        return playFileService.n;
    }

    private void i0() {
        if (this.h == null) {
            PlayingQueue.load(this.getApplicationContext());
            this.d0();
        }
    }

    private boolean j(Class<? extends Service> class_) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager)this.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (!class_.getName().equals((Object)runningServiceInfo.service.getClassName())) continue;
            return runningServiceInfo.foreground;
        }
        return false;
    }

    private void l() {
        if (this.j(PlayFileService.class)) {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 < 26) {
                this.startService(new Intent((Context)this, PlayFileService.class));
            }
            if (n2 >= 26) {
                this.stopForeground(2);
            } else {
                this.stopForeground(false);
            }
            this.o();
        }
    }

    private void n() {
        DisplayMetrics displayMetrics = this.getApplicationContext().getResources().getDisplayMetrics();
        int n2 = displayMetrics.widthPixels;
        int n3 = displayMetrics.heightPixels;
        if (n2 <= 0 || n3 <= 0) {
            n3 = 1024;
            n2 = 768;
        }
        int n4 = Math.max((int)n3, (int)n2);
        int n5 = Math.min((int)n3, (int)n2);
        String string = this.h.getTitle();
        String string2 = this.h.getArtist();
        String string3 = this.h.getAlbum();
        com.bumptech.glide.c.u((Context)this).l(this.y);
        com.bumptech.glide.j j2 = com.bumptech.glide.c.u((Context)this.getApplicationContext()).f();
        com.smp.musicspeed.playingqueue.i i2 = new com.smp.musicspeed.playingqueue.i(this.getApplicationContext(), string, string2, string3, this.t());
        ((com.bumptech.glide.j)((com.bumptech.glide.j)j2.w0((Object)i2).P(n5, n4)).e(com.bumptech.glide.load.o.j.b)).n0(this.y);
    }

    private void o() {
        String string = this.h.getTitle();
        String string2 = this.h.getArtist();
        String string3 = this.h.getAlbum();
        com.bumptech.glide.c.u((Context)this).l(this.w);
        com.bumptech.glide.j j2 = com.bumptech.glide.c.u((Context)this.getApplicationContext()).f();
        com.smp.musicspeed.playingqueue.i i2 = new com.smp.musicspeed.playingqueue.i(this.getApplicationContext(), string, string2, string3, this.t());
        ((com.bumptech.glide.j)j2.w0((Object)i2).e(com.bumptech.glide.load.o.j.b)).n0(this.w);
    }

    private void o0() {
        if (this.h != null) {
            this.n();
        }
    }

    private void p0() {
        g g2 = this.h;
        long l2 = g2 != null ? g2.getPlayedDuration() / 1000L : 0L;
        this.q0(l2);
    }

    private void q() {
        if (!MainActivity.F) {
            if (this.F()) {
                this.A0();
                return;
            }
            this.p();
        }
    }

    private boolean w0() {
        int n2 = PlayingQueue.getDefault().getCurrentlyPlaying();
        int n3 = t.n(this.getApplicationContext());
        int n4 = PlayingQueue.getDefault().getLength();
        return n4 > 1 && (n3 == 2 || n3 == 1 && n4 > n2 + 1) && !ReverseService.f;
    }

    private void z0() {
        MediaSessionCompat mediaSessionCompat = f;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setActive(false);
            f.setCallback(null);
            f.release();
            f = null;
        }
        this.k();
        this.y0();
        this.stopSelf();
        this.stopForeground(true);
        com.smp.musicspeed.utils.j.a((Context)this, 6675451);
    }

    public String A() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getTitle();
        }
        return this.getString(2131820950);
    }

    public void B(String string) throws IOException {
        this.C(string);
        this.x0();
    }

    public void C(String string) throws IOException {
        this.D(string, 1.0f, 0.0f);
    }

    public void C0(boolean bl) {
        g g2 = this.h;
        if (g2 != null) {
            g2.toForeground(bl);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(String string, float f3, float f4) throws IOException {
        void var4_11;
        boolean bl;
        try {
            this.y0();
            int n2 = Integer.parseInt((String)t.j(this.getApplicationContext()));
            if (n2 != 0) {
                if (n2 == 2) {
                    PitchKeyLoopsRecord pitchKeyLoopsRecord = PitchKeyLoopsRecord.loadFromPrefs(this.getApplicationContext(), string);
                    f4 = pitchKeyLoopsRecord.pitch;
                    f3 = pitchKeyLoopsRecord.tempo;
                }
            } else {
                SharedPreferences sharedPreferences = t.o(this.getApplicationContext());
                f4 = sharedPreferences.getFloat("com.smp.PREF_PITCH", 0.0f);
                f3 = sharedPreferences.getFloat("com.smp.PREF_TEMPO", 1.0f);
            }
            this.S(string, f3, f4);
            bl = t.n(this.getApplicationContext()) == 3;
        }
        catch (IllegalStateException illegalStateException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (this.j.isHeld()) {
            this.j.release();
        }
        this.p.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this);
        var4_11.printStackTrace();
        this.h = null;
        throw var4_11;
        this.t0(bl);
        this.o0();
    }

    public boolean D0(int n2) {
        this.T(false, true ^ this.F());
        if (n2 == PlayingQueue.getDefault().getCurrentlyPlaying()) {
            this.k();
            this.y0();
            t.h0(this.getApplicationContext());
            return false;
        }
        return true;
    }

    public boolean E() {
        g g2 = this.h;
        boolean bl = false;
        if (g2 != null) {
            long l2 = g2.getLoopStart() LCMP Long.MIN_VALUE;
            bl = false;
            if (l2 != false) {
                long l3 = this.h.getLoopEnd() LCMP Long.MIN_VALUE;
                bl = false;
                if (l3 != false) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public boolean F() {
        g g2 = this.h;
        if (g2 == null) {
            return true;
        }
        return g2.isPaused();
    }

    public boolean G() {
        return this.h != null;
    }

    public /* synthetic */ void I(String string) {
        this.H(string);
    }

    public /* synthetic */ void K() {
        this.J();
    }

    public /* synthetic */ void M() {
        this.L();
    }

    public /* synthetic */ void O(double d2, long l2) {
        this.N(d2, l2);
    }

    public /* synthetic */ void Q() {
        this.P();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void T(boolean var1_1, boolean var2_2) {
        block8 : {
            var3_3 = PlayingQueue.getDefault().getCurrentlyPlaying();
            var4_4 = PlayingQueue.getDefault().getLength();
            if (var4_4 <= (var5_5 = 1)) break block8;
            for (var6_6 = 0; var5_5 != 0 && var6_6 < PlayingQueue.getDefault().getLength(); ++var6_6) {
                if (!var1_1) ** GOTO lbl9
                try {
                    block9 : {
                        var10_8 = PlayingQueue.getDefault().previousTrack().getFile().getAbsolutePath();
                        break block9;
lbl9: // 1 sources:
                        var10_8 = PlayingQueue.getDefault().nextTrack().getFile().getAbsolutePath();
                    }
                    this.B(var10_8);
                    var5_5 = 0;
                    continue;
                }
                catch (IOException var9_7) {
                    var9_7.printStackTrace();
                }
            }
            if (this.h != null) {
                this.c0();
                if (var2_2) {
                    this.b0();
                }
            } else {
                t.h0(this.getApplicationContext());
                var7_9 = this.i;
                if (var7_9 != null) {
                    var7_9.d();
                }
            }
            if ((var8_10 = this.i) != null) {
                var8_10.f();
            }
        }
        this.j0();
        org.greenrobot.eventbus.c.d().m((Object)new p(var3_3, PlayingQueue.getDefault().getCurrentlyPlaying()));
    }

    public void Y() {
        g g2 = this.h;
        if (g2 != null) {
            if (g2.isPaused()) {
                if (AppPrefs.k.W()) {
                    com.smp.musicspeed.g0.a.f.c();
                    return;
                }
                this.b0();
                return;
            }
            this.Z();
        }
    }

    @Override
    public void a(double d2, long l2) {
        Handler handler = this.l;
        com.smp.musicspeed.player.d d3 = new com.smp.musicspeed.player.d(this, d2, l2);
        handler.post((Runnable)d3);
    }

    @Override
    public void b(String string) {
        this.l.post((Runnable)new com.smp.musicspeed.player.c(this));
    }

    @Override
    public void c() {
        this.l.post((Runnable)new f(this));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean d0() {
        var1_1 = PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext());
        var2_2 = var1_1.getString("com.smp.PREF_FILENAME", null);
        var3_3 = var1_1.getBoolean("preferences_link", false);
        if (var2_2 == null) return true;
        if (!var3_3) ** GOTO lbl10
        try {
            block2 : {
                var10_4 = this.a0(var1_1.getFloat("com.smp.PREF_RATE", 1.0f));
                this.D(var2_2, var1_1.getFloat("com.smp.PREF_RATE", 1.0f), var10_4);
                break block2;
lbl10: // 1 sources:
                this.D(var2_2, var1_1.getFloat("com.smp.PREF_TEMPO", 1.0f), var1_1.getFloat("com.smp.PREF_PITCH", 0.0f));
            }
            var6_5 = var1_1.getLong("com.smp.PREF_POSITION", 0L);
            this.h.seekTo(var6_5);
            this.m0(var1_1.getLong("com.smp.PREF_LOOP_END", Long.MIN_VALUE), false);
            this.n0(var1_1.getLong("com.smp.PREF_LOOP_START", Long.MIN_VALUE), false);
            this.x0();
            this.q0(var6_5 / 1000L);
            return true;
        }
        catch (Exception var4_6) {
            this.h = null;
            var4_6.printStackTrace();
            t.h0(this.getApplicationContext());
            this.d0();
            return false;
        }
    }

    public void g0() {
        this.i = null;
    }

    public void h0(boolean bl) {
        boolean bl2 = this.F();
        this.y0();
        if (bl) {
            t.P((Context)this);
        }
        this.d0();
        if (!bl2 && this.h != null) {
            this.b0();
        }
    }

    public void j0() {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext()).edit();
        g g2 = this.h;
        if (g2 != null) {
            long l2 = g2.getPlayedDuration();
            if (l2 < 0L) {
                l2 = 0L;
            }
            editor.putString("com.smp.PREF_FILENAME", this.h.getFileName());
            editor.putLong("com.smp.PREF_POSITION", l2);
            editor.putFloat("com.smp.PREF_RATE", this.h.getRate());
            editor.putFloat("com.smp.PREF_TEMPO", this.h.getTempo());
            editor.putFloat("com.smp.PREF_PITCH", this.h.getPitchSemi());
            editor.putLong("com.smp.PREF_LOOP_START", this.h.getLoopStart());
            editor.putLong("com.smp.PREF_LOOP_END", this.h.getLoopEnd());
            PitchKeyLoopsRecord.saveToPrefs(this.getApplicationContext(), this.h.getFileName(), this.h.getPitchSemi(), this.h.getTempo(), new ArrayList());
        } else {
            editor.putString("com.smp.PREF_FILENAME", null);
        }
        editor.apply();
    }

    public void k() {
        com.bumptech.glide.c.u((Context)this).l(this.x);
        com.bumptech.glide.c.u((Context)this).l(this.w);
        com.bumptech.glide.c.u((Context)this).l(this.y);
    }

    public void k0(long l2) {
        g g2 = this.h;
        if (g2 != null && !g2.isFinished()) {
            boolean bl = this.h.isPaused();
            if (l2 > this.h.getDuration()) {
                l2 = this.h.getDuration();
            }
            if (l2 < 0L) {
                l2 = 0L;
            }
            float f3 = (float)((double)l2 / (double)this.h.getDuration());
            this.q0(l2 / 1000L);
            this.h.seekTo(f3, bl);
            this.c0();
        }
    }

    public void l0(float f3) {
        g g2 = this.h;
        if (g2 != null && !g2.isFinished()) {
            boolean bl = this.h.isPaused();
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            double d2 = this.h.getDuration();
            double d3 = f3;
            this.q0((long)(d2 * d3 / 1000.0));
            this.h.seekTo(d3, bl);
            this.c0();
        }
    }

    public void m() {
        g g2 = this.h;
        if (g2 != null) {
            g2.clearLoopPoints();
        }
    }

    public boolean m0(long l2, boolean bl) {
        if (l2 != Long.MIN_VALUE) {
            long l3;
            g g2 = this.h;
            if (g2 == null) {
                return false;
            }
            if (l2 < 0L) {
                l2 = 0L;
            }
            if (l2 > (l3 = g2.getDuration())) {
                l2 = l3;
            }
            if (this.h.getLoopStart() != Long.MIN_VALUE && l2 <= this.h.getLoopStart()) {
                return false;
            }
            try {
                this.h.setLoopEnd(l2);
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public boolean n0(long l2, boolean bl) {
        if (l2 != Long.MIN_VALUE) {
            long l3;
            g g2 = this.h;
            if (g2 == null) {
                return false;
            }
            if (l2 < 0L) {
                l2 = 0L;
            }
            if (l2 > (l3 = g2.getDuration())) {
                l2 = l3;
            }
            if (this.h.getLoopEnd() != Long.MIN_VALUE && l2 >= this.h.getLoopEnd()) {
                return false;
            }
            this.h.setLoopStart(l2);
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onAudioFocusChange(int n2) {
        boolean bl = t.y(this.getApplicationContext());
        if (n2 != -3) {
            if (n2 != -2) {
                if (n2 != -1) {
                    if (n2 != 1) {
                        return;
                    }
                    g g2 = this.h;
                    if (g2 == null || g2.isFinished()) return;
                    this.h.setVolume(1.0f, 1.0f);
                    if (!this.h.isPaused()) return;
                    this.b0();
                    l l2 = this.i;
                    if (l2 != null) {
                        l2.c();
                    }
                    if (MainActivity.F) return;
                    this.p();
                    return;
                }
                if (bl) {
                    return;
                }
                g g3 = this.h;
                if (g3 != null && !g3.isFinished() && !this.h.isPaused()) {
                    this.Z();
                    this.j0();
                    l l3 = this.i;
                    if (l3 != null) {
                        l3.c();
                    }
                    this.l();
                }
                this.p.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this);
                return;
            }
            if (bl) {
                return;
            }
            g g4 = this.h;
            if (g4 != null && !g4.isFinished() && !this.h.isPaused()) {
                this.Z();
                this.j0();
                l l4 = this.i;
                if (l4 != null) {
                    l4.c();
                }
                this.l();
                return;
            }
            this.p.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this);
            return;
        }
        if (bl) {
            return;
        }
        g g5 = this.h;
        if (g5 != null && !g5.isFinished() && !this.h.isPaused()) {
            if (this.p.getStreamVolume(5) == 0) return;
            this.h.setVolume(0.2f, 0.2f);
            return;
        }
        this.p.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this);
    }

    public IBinder onBind(Intent intent) {
        return this.m;
    }

    public void onCreate() {
        int n2;
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(6675451, com.smp.musicspeed.utils.j.h((Context)this));
        }
        this.k = new PlaybackStateCompat.Builder();
        this.v = n2 = (int)t.b(this.getApplicationContext(), 128.0f);
        this.w = new a(this, n2, n2);
        int n3 = this.v;
        this.x = new b(this, n3, n3);
        this.y = new c(this);
        t.O(this.getApplicationContext(), this);
        org.greenrobot.eventbus.c.d().r((Object)this);
        this.f0();
        this.e0();
        this.p = (AudioManager)this.getSystemService("audio");
        this.n = (NotificationManager)this.getSystemService("notification");
        this.j = ((PowerManager)this.getSystemService("power")).newWakeLock(1, "smp:playWakeLock");
    }

    public void onDestroy() {
        this.p.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this);
        if (this.j.isHeld()) {
            this.j.release();
        }
        this.y0();
        this.B0();
        this.k();
        this.l.removeCallbacks(this.u);
        this.unregisterReceiver((BroadcastReceiver)this.o);
        org.greenrobot.eventbus.c.d().v((Object)this);
        t.g0(this.getApplicationContext(), this);
        super.onDestroy();
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(s s2) {
        g g2 = this.h;
        if (g2 != null) {
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
            g2.setEffectsLevels(bl, f3, f4, f5, f6, f7, f8, bl2, f9, f10, f11, f12, f13, f14, f15, f16, bl3, f17, f18, bl4, f19, f20, f21, f22, f23, bl5, f24, f25, bl6, f26, f27, f28, flangerPrefModel.Y(), flangerPrefModel.a0(), flangerPrefModel.W(), flangerPrefModel.Z(), flangerPrefModel.T(), flangerPrefModel.V(), flangerPrefModel.U());
        }
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.equalizer.m m2) {
        if (this.h != null) {
            boolean bl = com.smp.musicspeed.equalizer.l.e(this.getApplicationContext());
            float f3 = com.smp.musicspeed.equalizer.l.f(this.getApplicationContext());
            boolean bl2 = com.smp.musicspeed.equalizer.l.c(this.getApplicationContext());
            float[] arrf = com.smp.musicspeed.equalizer.l.d(this.getApplicationContext());
            boolean bl3 = com.smp.musicspeed.equalizer.l.a(this.getApplicationContext());
            float f4 = com.smp.musicspeed.equalizer.l.b(this.getApplicationContext());
            this.h.setEqualizerLevels(bl, f3, bl2, arrf, bl3, f4);
        }
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.g0.b b2) {
        if (this.h != null) {
            this.b0();
            l l2 = this.i;
            if (l2 != null) {
                l2.c();
            }
            this.q();
        }
    }

    /*
     * Exception decompiling
     */
    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(v var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl63 : ALOAD_0 : trying to set 1 previously set to 0
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

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(com.smp.musicspeed.test.a a2) {
        if (!a2.a) {
            if (this.h != null && !this.F()) {
                Toast.makeText((Context)this, (int)2131821309, (int)0).show();
            }
            this.h0(false);
        }
    }

    @org.greenrobot.eventbus.m(threadMode=ThreadMode.MAIN)
    public void onEvent(n n2) {
        throw new RuntimeException(z.l(n2.b));
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        if (!string.equals((Object)"preferences_buffer_size") && !string.equals((Object)"usePVDR")) {
            String string2;
            if (string.equals((Object)"stretchQuality")) {
                this.h0(false);
                return;
            }
            AppPrefs appPrefs = AppPrefs.k;
            if (string.equals((Object)appPrefs.k0())) {
                this.h0(false);
                return;
            }
            if (string.equals((Object)"preferences_low_latency")) {
                this.h0(true);
                return;
            }
            if (string.equals((Object)appPrefs.C()) && (string2 = this.t()) != null) {
                com.smp.musicspeed.bpmkey.a.f.h(string2);
                return;
            }
        } else {
            this.h0(false);
        }
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        String string;
        MediaSessionCompat mediaSessionCompat = f;
        if (mediaSessionCompat != null) {
            androidx.media.l.a.c((MediaSessionCompat)mediaSessionCompat, (Intent)intent);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(6675451, com.smp.musicspeed.utils.j.h((Context)this));
            if (MainActivity.J || intent == null || intent.getAction() == null) {
                this.stopForeground(true);
            }
        }
        if ("com.smp.musicspeed.ACTION_PLAY".equals((Object)(string = intent.getAction())) || "com.smp.musicspeed.ACTION_STOP".equals((Object)string) || "com.smp.musicspeed.ACTION.PREVIOUS_TRACK".equals((Object)string) || "com.smp.musicspeed.ACTION.NEXT_TRACK".equals((Object)string) || "com.smp.musicspeed.seek_increment".equals((Object)string) || "com.smp.musicspeed.intent_seek_to_ms".equals((Object)string)) {
            this.i0();
        }
        if (this.h != null) {
            if ("com.smp.musicspeed.ACTION_PLAY".equals((Object)string)) {
                if (!intent.getBooleanExtra("com.smp.musicspeed.FROM_SLEEP_TIMER", false) || !this.F()) {
                    this.U();
                }
            } else if ("com.smp.musicspeed.ACTION_STOP".equals((Object)string)) {
                if (!MainActivity.F) {
                    this.z0();
                }
            } else if ("com.smp.musicspeed.ACTION.NEXT_TRACK".equals((Object)string)) {
                this.X(false);
            } else if ("com.smp.musicspeed.ACTION.PREVIOUS_TRACK".equals((Object)string)) {
                this.X(true);
            } else if ("com.smp.musicspeed.seek_increment".equals((Object)string)) {
                this.V(intent.getBooleanExtra("com.smp.musicspeed.intent_reverse_seek_increment", false));
            } else if ("com.smp.musicspeed.intent_seek_to_ms".equals((Object)string)) {
                this.W(intent.getLongExtra("com.smp.musicspeed.intent_seek_position", 0L));
            } else if ("com.smp.musicspeed.intent_reload_track".equals((Object)string)) {
                this.h0(false);
            }
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        this.z0();
        t.K((Context)this);
        super.onTaskRemoved(intent);
    }

    public void p() {
        String string = this.h.getTitle();
        String string2 = this.h.getArtist();
        String string3 = this.h.getAlbum();
        com.bumptech.glide.c.u((Context)this).l(this.x);
        com.bumptech.glide.j j2 = com.bumptech.glide.c.u((Context)this.getApplicationContext()).f();
        com.smp.musicspeed.playingqueue.i i2 = new com.smp.musicspeed.playingqueue.i(this.getApplicationContext(), string, string2, string3, this.t());
        ((com.bumptech.glide.j)j2.w0((Object)i2).e(com.bumptech.glide.load.o.j.b)).n0(this.x);
    }

    public void q0(long l2) {
        int n2 = this.F() ? 2 : 3;
        if (n2 == 3) {
            this.k.setActions(890L);
        } else {
            this.k.setActions(892L);
        }
        g g2 = this.h;
        float f3 = g2 == null ? 1.0f : g2.getTempo();
        this.k.setState(n2, l2, f3);
        MediaSessionCompat mediaSessionCompat = f;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setPlaybackState(this.k.build());
        }
    }

    public Notification r(Bitmap bitmap) {
        MediaSessionCompat mediaSessionCompat = f;
        MediaSessionCompat.Token token = mediaSessionCompat != null ? mediaSessionCompat.getSessionToken() : null;
        MediaSessionCompat.Token token2 = token;
        boolean bl = this.F();
        g g2 = this.h;
        String string = g2 != null ? g2.getTitle() : "";
        g g3 = this.h;
        String string2 = g3 != null ? g3.getArtist() : "";
        return com.smp.musicspeed.utils.j.g((Context)this, token2, bl, string, string2, this.w(), this.z(), this.y(), true ^ t.A((Context)this), bitmap, false);
    }

    public void r0(float f3) {
        g g2 = this.h;
        if (g2 != null) {
            g2.setPitchSemi(f3);
        }
    }

    public long s() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getDuration();
        }
        return Long.MIN_VALUE;
    }

    public void s0(float f3) {
        this.r.e(this.s);
        g g2 = this.h;
        if (g2 != null) {
            g2.setRate(f3);
        }
    }

    public String t() {
        g g2 = this.h;
        if (g2 == null) {
            return null;
        }
        return g2.getFileName();
    }

    public void t0(boolean bl) {
        g g2 = this.h;
        if (g2 != null) {
            g2.setRepeat(bl);
        }
    }

    public long u() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getLoopEnd();
        }
        return Long.MIN_VALUE;
    }

    public void u0(float f3) {
        this.r.e(this.s);
        g g2 = this.h;
        if (g2 != null) {
            g2.setTempo(f3);
        }
    }

    public long v() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getLoopStart();
        }
        return Long.MIN_VALUE;
    }

    public void v0(float f3) {
        g g2 = this.h;
        if (g2 != null) {
            g2.setVolume(f3, f3);
        }
    }

    public float w() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getPitchSemi();
        }
        return 0.0f;
    }

    public long x() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getPlayedDuration();
        }
        return Long.MIN_VALUE;
    }

    public void x0() {
        g g2 = this.h;
        if (g2 != null) {
            g2.start();
        }
    }

    public float y() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getRate();
        }
        return 1.0f;
    }

    public void y0() {
        g = false;
        org.greenrobot.eventbus.c.d().m((Object)new m());
        if (this.j.isHeld()) {
            this.j.release();
        }
        if (this.h != null) {
            this.j0();
        }
        this.m();
        g g2 = this.h;
        if (g2 != null) {
            g2.stop();
            this.h = null;
        }
    }

    public float z() {
        g g2 = this.h;
        if (g2 != null) {
            return g2.getTempo();
        }
        return 1.0f;
    }

}

