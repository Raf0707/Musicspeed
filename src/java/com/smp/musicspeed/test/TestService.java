/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  com.smp.musicspeed.test.TestService$b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.test;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.smp.musicspeed.test.TestService;
import com.smp.musicspeed.utils.j;
import f.w.d;
import f.z.c.p;
import f.z.d.g;
import f.z.d.k;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class TestService
extends Service
implements k0 {
    public static final a f = new Object(null){
        {
            this();
        }

        public final void a(Context context) {
            k.g((Object)context, "context");
            Intent intent = new Intent(context, TestService.class);
            intent.setAction("com.smp.musicspeed.action.testdevice");
            context.startService(intent);
        }
    };
    private final /* synthetic */ k0 g;

    public TestService() {
        this.g = l0.b();
    }

    public static final void a(Context context) {
        f.a(context);
    }

    public f.w.g L() {
        return this.g.L();
    }

    public IBinder onBind(Intent intent) {
        k.g((Object)intent, "intent");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(6675451, j.l((Context)this));
        }
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        e.d((k0)this, null, null, (p)new b(this, null), (int)3, null);
        return 2;
    }

}

