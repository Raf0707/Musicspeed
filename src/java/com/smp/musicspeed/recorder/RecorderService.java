/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  androidx.lifecycle.LiveData
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.Byte
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedList
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.m
 */
package com.smp.musicspeed.recorder;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.lifecycle.LiveData;
import com.smp.musicspeed.recorder.p;
import com.smp.musicspeed.recorder.q;
import com.smp.musicspeed.recorder.u;
import com.smp.musicspeed.recorder.v;
import com.smp.musicspeed.utils.j;
import f.k;
import f.z.d.g;
import java.util.LinkedList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;

public final class RecorderService
extends Service {
    public static final a f = new a(null);

    private final boolean a() {
        if (this.d()) {
            String string2 = f.a().g();
            f.z.d.k.f((Object)string2, (String)"audioRecorder.name");
            if (q.a((Context)this, string2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean b() {
        a a2 = f;
        if (a2.e() == 2) {
            return a2.a().m();
        }
        return a2.a().o();
    }

    private final boolean c(String string2) {
        return f.a().r((Context)this, string2);
    }

    private final boolean d() {
        int n2 = f.a().s();
        this.stopForeground(true);
        this.stopSelf();
        return n2 >= 0;
    }

    private final Notification e() {
        a a2 = f;
        boolean bl = a2.e() == 3;
        Notification notification = j.i((Context)this, bl, a2.a().g());
        f.z.d.k.f((Object)notification, (String)"generateRecordNotification(this, recorderState == STATE_PAUSED, audioRecorder.name)");
        return notification;
    }

    @m(threadMode=ThreadMode.BACKGROUND)
    public final void handleRecordEvent(u u2) {
        f.z.d.k.g((Object)u2, (String)"event");
        int n2 = u2.a();
        boolean bl = n2 != 0 ? (n2 != 1 ? (n2 != 2 ? (n2 != 3 ? false : this.a()) : this.c(u2.b())) : this.b()) : this.d();
        if (u2.a() != 0 && !bl) {
            this.d();
        }
        a a2 = f;
        c c2 = a2.c();
        int n3 = u2.a();
        int n4 = bl ^ true;
        String string2 = a2.a().g();
        f.z.d.k.f((Object)string2, (String)"audioRecorder.name");
        c2.m((Object)new v(n3, n4, string2));
        this.startForeground(6675452, this.e());
    }

    public IBinder onBind(Intent intent) {
        f.z.d.k.g((Object)intent, (String)"intent");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append("Return the communication channel to the service.");
        throw new k(stringBuilder.toString());
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(6675452, j.j((Context)this));
        }
        c.d().r((Object)this);
    }

    public void onDestroy() {
        c.d().v((Object)this);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(6675452, j.j((Context)this));
        }
        if (intent != null) {
            String string2 = intent.getStringExtra("extra_record_name");
            if (string2 == null) {
                string2 = "";
            }
            if (f.z.d.k.c((Object)intent.getAction(), (Object)"com.smp.musicspeed.ACTION_RECORD_START")) {
                f.c().m((Object)new u(2, string2));
                return 2;
            }
            if (f.z.d.k.c((Object)intent.getAction(), (Object)"com.smp.musicspeed.ACTION_RECORD_STOP")) {
                f.c().m((Object)new u(0, null, 2, null));
                return 2;
            }
            if (f.z.d.k.c((Object)intent.getAction(), (Object)"com.smp.musicspeed.ACTION_RECORD_PAUSE_RESUME")) {
                f.c().m((Object)new u(1, null, 2, null));
            }
        }
        return 2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final p a() {
            p p2 = p.d();
            f.z.d.k.f((Object)p2, (String)"getInstance()");
            return p2;
        }

        public final long b() {
            return this.a().n();
        }

        public final c c() {
            c c2 = c.d();
            f.z.d.k.f((Object)c2, (String)"getDefault()");
            return c2;
        }

        public final LiveData<LinkedList<Byte>> d() {
            LiveData<LinkedList<Byte>> liveData = this.a().e();
            f.z.d.k.f(liveData, (String)"audioRecorder.lastAmplitudes");
            return liveData;
        }

        public final int e() {
            return this.a().h();
        }
    }

}

