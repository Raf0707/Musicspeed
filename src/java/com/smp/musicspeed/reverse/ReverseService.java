/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.IntentService
 *  android.app.Notification
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Process
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.reverse;

import android.app.IntentService;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.smp.musicspeed.reverse.a;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.j;
import java.io.File;
import org.greenrobot.eventbus.c;

public class ReverseService
extends IntentService {
    public static volatile boolean f;
    private static String g;
    private static Handler h;

    public ReverseService() {
        super("ReverseService");
    }

    public static String a(Context context) {
        return context.getResources().getString(2131820835).replace((CharSequence)"_", (CharSequence)"");
    }

    private void b(String string2, String string3) {
        String string4;
        if (string2.contains((CharSequence)g) && string2.length() > 4 + g.length()) {
            File file = g.e(this.getApplicationContext(), ReverseService.a((Context)this));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(g.j(new File(string2).getName()).replace((CharSequence)g, (CharSequence)""));
            stringBuilder.append(".wav");
            string4 = new File(file, stringBuilder.toString()).getAbsolutePath();
        } else {
            File file = g.e(this.getApplicationContext(), ReverseService.a((Context)this));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(g.j(new File(string2).getName()));
            stringBuilder.append(g);
            stringBuilder.append(".wav");
            string4 = new File(file, stringBuilder.toString()).getAbsolutePath();
        }
        if (this.doReverseNative(string2, string4)) {
            this.d(string4);
            return;
        }
        this.c();
    }

    private void c() {
        c.d().p((Object)new a(false, null));
    }

    private void d(String string2) {
        c.d().p((Object)new a(true, string2));
    }

    private native boolean doReverseNative(String var1, String var2);

    public static void e(Context context, String string2) {
        Intent intent = new Intent(context, ReverseService.class);
        intent.setAction("com.smp.musicspeed.action.RESAMPLE");
        intent.putExtra("com.smp.musicspeed.extra.PARAM1", string2);
        context.startService(intent);
    }

    public static void f(Context context, String string2) {
        h = new Handler();
        g = context.getResources().getString(2131820835);
        Intent intent = new Intent(context, ReverseService.class);
        intent.setAction("com.smp.musicspeed.action.REVERSE");
        intent.putExtra("com.smp.musicspeed.extra.PARAM1", string2);
        context.startService(intent);
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.startForeground(6675451, j.h((Context)this));
        }
    }

    protected void onHandleIntent(Intent intent) {
        String string2;
        f = true;
        Process.setThreadPriority((int)10);
        if (intent != null && ("com.smp.musicspeed.action.RESAMPLE".equals((Object)(string2 = intent.getAction())) || "com.smp.musicspeed.action.REVERSE".equals((Object)string2))) {
            this.b(intent.getStringExtra("com.smp.musicspeed.extra.PARAM1"), string2);
        }
        f = false;
    }
}

