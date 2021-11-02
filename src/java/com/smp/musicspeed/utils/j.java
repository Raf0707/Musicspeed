/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  androidx.core.app.i
 *  androidx.core.app.i$a
 *  androidx.core.app.i$b
 *  androidx.core.app.i$d
 *  androidx.core.app.i$e
 *  androidx.media.k.a
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.player.PlayFileService
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.i;
import androidx.media.k.a;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.h0.c;
import com.smp.musicspeed.player.PlayFileService;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.recorder.RecorderService;
import com.smp.musicspeed.utils.n;
import java.io.File;

public class j {
    public static boolean a;

    public static void a(Context context, int n2) {
        ((NotificationManager)context.getSystemService("notification")).cancel(n2);
    }

    public static void b(Context context) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        if (notificationManager.getNotificationChannel("importing_channel") != null) {
            return;
        }
        String string2 = context.getString(2131820781);
        String string3 = context.getString(2131820781);
        NotificationChannel notificationChannel = new NotificationChannel("importing_channel", (CharSequence)string2, 2);
        notificationChannel.setDescription(string3);
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static void c(Context context) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        if (notificationManager.getNotificationChannel("playback_channel") != null) {
            return;
        }
        String string2 = context.getString(2131821155);
        String string3 = context.getString(2131821152);
        NotificationChannel notificationChannel = new NotificationChannel("playback_channel", (CharSequence)string2, 2);
        notificationChannel.setDescription(string3);
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static void d(Context context) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        if (notificationManager.getNotificationChannel("record_channel") != null) {
            return;
        }
        String string2 = context.getString(2131821156);
        String string3 = context.getString(2131821153);
        NotificationChannel notificationChannel = new NotificationChannel("record_channel", (CharSequence)string2, 2);
        notificationChannel.setDescription(string3);
        notificationChannel.setShowBadge(false);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setLockscreenVisibility(1);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static void e(Context context) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        if (notificationManager.getNotificationChannel("file_save_channel") != null) {
            return;
        }
        String string2 = context.getString(2131821157);
        String string3 = context.getString(2131821154);
        NotificationChannel notificationChannel = new NotificationChannel("file_save_channel", (CharSequence)string2, 2);
        notificationChannel.setDescription(string3);
        notificationChannel.setShowBadge(false);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setLockscreenVisibility(1);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static Notification f(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.b(context);
        }
        return j.p(context);
    }

    public static Notification g(Context context, MediaSessionCompat.Token token, boolean bl, String string2, String string3, float f2, float f3, float f4, boolean bl2, Bitmap bitmap, boolean bl3) {
        String string4;
        if (Build.VERSION.SDK_INT >= 26) {
            j.c(context);
        }
        a = bl2;
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(268435456);
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)0);
        Intent intent2 = new Intent(context, PlayFileService.class);
        intent2.setAction("com.smp.musicspeed.ACTION_STOP");
        PendingIntent pendingIntent2 = PendingIntent.getService((Context)context.getApplicationContext(), (int)0, (Intent)intent2, (int)0);
        Intent intent3 = new Intent(context, PlayFileService.class);
        intent3.setAction("com.smp.musicspeed.ACTION_PLAY");
        PendingIntent pendingIntent3 = PendingIntent.getService((Context)context.getApplicationContext(), (int)0, (Intent)intent3, (int)0);
        Intent intent4 = new Intent(context, PlayFileService.class);
        intent4.setAction("com.smp.musicspeed.ACTION.PREVIOUS_TRACK");
        PendingIntent pendingIntent4 = PendingIntent.getService((Context)context.getApplicationContext(), (int)0, (Intent)intent4, (int)0);
        Intent intent5 = new Intent(context, PlayFileService.class);
        intent5.setAction("com.smp.musicspeed.ACTION.NEXT_TRACK");
        PendingIntent pendingIntent5 = PendingIntent.getService((Context)context.getApplicationContext(), (int)0, (Intent)intent5, (int)0);
        int n2 = bl ? 2131230983 : 2131230978;
        String string5 = bl ? context.getResources().getString(2131821150) : context.getResources().getString(2131821149);
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n.e(f2));
            stringBuilder.append("  ");
            stringBuilder.append(n.g(f3));
            string4 = stringBuilder.toString();
        } else {
            string4 = n.f(f4);
        }
        a a2 = new a();
        i.a a3 = new i.a(n2, (CharSequence)string5, pendingIntent3);
        i.a a4 = new i.a(2131231022, (CharSequence)context.getResources().getString(2131821151), pendingIntent2);
        i.a a5 = new i.a(2131231017, (CharSequence)"", pendingIntent4);
        i.a a6 = new i.a(2131231015, (CharSequence)"", pendingIntent5);
        i.d d2 = new i.d(context, "playback_channel");
        if (PlayingQueue.getDefault().getLength() > 1 && !bl3 && !string2.equals((Object)context.getString(2131820950))) {
            d2.b(a5);
        }
        d2.q(bitmap).v(2131231139).n((CharSequence)string2).m((CharSequence)string4).r(bl ^ true).u(false).x((CharSequence)string3).k("service").j(false).l(pendingIntent).b(a3).s(2).w((i.e)a2).y(1);
        if (PlayingQueue.getDefault().getLength() > 1 && !bl3 && !string2.equals((Object)context.getString(2131820950))) {
            d2.b(a6);
            a2.u(new int[]{0, 1, 2});
        } else if (!string2.equals((Object)context.getString(2131820950))) {
            a2.u(new int[]{0, 1});
        }
        d2.b(a4);
        d2.o(pendingIntent2);
        a2.v(bl);
        a2.s(pendingIntent2);
        a2.t(token);
        return d2.c();
    }

    public static Notification h(Context context) {
        Notification notification;
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 26) {
            j.c(context);
        }
        if (n2 >= 23 && (notification = j.m(context, 6675451)) != null) {
            return notification;
        }
        return j.n(context);
    }

    public static Notification i(Context context, boolean bl, String string2) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 26) {
            j.d(context);
        }
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction("com.smp.musicspeed.ACTION_RECORD_NOTIF");
        intent.addFlags(268435456);
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)0);
        Intent intent2 = new Intent(context, RecorderService.class);
        intent2.setAction("com.smp.musicspeed.ACTION_RECORD_PAUSE_RESUME");
        PendingIntent pendingIntent2 = PendingIntent.getService((Context)context.getApplicationContext(), (int)0, (Intent)intent2, (int)0);
        Intent intent3 = new Intent(context, RecorderService.class);
        intent3.setAction("com.smp.musicspeed.ACTION_RECORD_STOP");
        PendingIntent pendingIntent3 = PendingIntent.getService((Context)context.getApplicationContext(), (int)0, (Intent)intent3, (int)0);
        int n3 = bl ? 2131230996 : 2131230978;
        String string3 = bl ? context.getResources().getString(2131821148) : context.getResources().getString(2131821149);
        i.a a2 = new i.a(n3, (CharSequence)string3, pendingIntent2);
        i.a a3 = new i.a(2131231022, (CharSequence)context.getResources().getString(2131821151), pendingIntent3);
        i.d d2 = new i.d(context, "record_channel");
        a a4 = new a();
        if (n2 >= 24) {
            d2.b(a2);
            d2.b(a3);
            a4.u(new int[]{0, 1});
        } else {
            d2.b(a3);
            a4.u(new int[]{0});
        }
        d2.v(2131230937).n((CharSequence)string2).m((CharSequence)context.getString(2131820673)).j(false).u(false).r(true).k("service").l(pendingIntent).s(2).w((i.e)a4).y(1);
        a4.v(false);
        a4.t(null);
        return d2.c();
    }

    public static Notification j(Context context) {
        Notification notification;
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 26) {
            j.d(context);
        }
        if (n2 >= 23 && (notification = j.m(context, 6675452)) != null) {
            return notification;
        }
        return j.o(context);
    }

    public static Notification k(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.e(context);
        }
        Intent intent = new Intent();
        intent.putExtra("random", Math.random());
        intent.setAction("android.intent.action.VIEW");
        Intent intent2 = Intent.createChooser((Intent)intent, (CharSequence)context.getResources().getString(2131820789));
        intent.setDataAndType(Uri.fromFile((File)file), "audio/mpeg3");
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)context.getApplicationContext(), (int)0, (Intent)intent2, (int)134217728);
        i.b b2 = new i.b();
        String string2 = context.getResources().getString(2131821158);
        String string3 = file.getName();
        b2.n((CharSequence)string2);
        b2.m((CharSequence)string3);
        Intent intent3 = new Intent("android.intent.action.SEND");
        intent3.putExtra("random", Math.random());
        intent3.setType("audio/mpeg3");
        intent3.putExtra("android.intent.extra.SUBJECT", file.getName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getResources().getString(2131821301));
        stringBuilder.append(" ");
        stringBuilder.append(c.a());
        intent3.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        intent3.putExtra("android.intent.extra.STREAM", (Parcelable)Uri.fromFile((File)file));
        PendingIntent pendingIntent2 = PendingIntent.getActivity((Context)context.getApplicationContext(), (int)0, (Intent)intent3, (int)134217728);
        return new i.d(context, "file_save_channel").m((CharSequence)string3).n((CharSequence)string2).l(pendingIntent).t(0, 0, false).v(2131230918).w((i.e)b2).a(2131231009, (CharSequence)context.getResources().getString(2131821162), pendingIntent2).a(2131230972, (CharSequence)context.getResources().getString(2131821160), pendingIntent).c();
    }

    public static Notification l(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.c(context);
        }
        return j.q(context);
    }

    public static Notification m(Context context, int n2) {
        for (StatusBarNotification statusBarNotification : ((NotificationManager)context.getSystemService("notification")).getActiveNotifications()) {
            if (statusBarNotification.getId() != n2) continue;
            return statusBarNotification.getNotification();
        }
        return null;
    }

    private static Notification n(Context context) {
        return new i.d(context, "playback_channel").n((CharSequence)"").m((CharSequence)"").c();
    }

    private static Notification o(Context context) {
        return j.i(context, true, "");
    }

    private static Notification p(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(268435456);
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent, (int)0);
        return new i.d(context, "importing_channel").n((CharSequence)context.getString(2131820781)).l(pendingIntent).v(2131230927).c();
    }

    private static Notification q(Context context) {
        return new i.d(context, "playback_channel").n((CharSequence)context.getString(2131820797)).v(2131230925).c();
    }
}

