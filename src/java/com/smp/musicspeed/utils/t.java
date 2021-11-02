/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.app.Dialog
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.os.Process
 *  android.preference.PreferenceManager
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.ImageView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.graphics.drawable.a
 *  b.i.h.a
 *  com.smp.musicspeed.utils.AppPrefs
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.List
 *  java.util.Locale
 */
package com.smp.musicspeed.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import b.i.h.a;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.utils.AppPrefs;
import java.util.List;
import java.util.Locale;

public class t {
    public static boolean A(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_link", false);
    }

    public static boolean B(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_maximum_file_quality", false);
    }

    public static boolean C(Context context, Class<? extends Service> class_) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager)context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (!class_.getName().equals((Object)runningServiceInfo.service.getClassName())) continue;
            return true;
        }
        return false;
    }

    public static boolean D(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_reset_controls", false);
    }

    public static boolean E(Context context) {
        return context.getString(2131820892).equals((Object)"true");
    }

    public static boolean F(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_screen_on", false);
    }

    public static boolean G(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_shuffle", false);
    }

    public static boolean H(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_snap_pitch", false);
    }

    public static boolean I(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_snap_tempo", false);
    }

    public static boolean J(Context context) {
        return (48 & context.getResources().getConfiguration().uiMode) == 32;
    }

    public static void K(Context context) {
        t.L(context, ":pathservice");
    }

    public static void L(Context context, String string2) {
        if (context == null) {
            return;
        }
        ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        if (activityManager == null) {
            return;
        }
        List list = activityManager.getRunningAppProcesses();
        if (list == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            if (!runningAppProcessInfo.processName.equals((Object)string3)) continue;
            Process.killProcess((int)runningAppProcessInfo.pid);
            break;
        }
    }

    public static float M(Context context, int n2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (float)n2 / ((float)displayMetrics.densityDpi / 160.0f);
    }

    public static void N(Context context, int n2) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (n2 > sharedPreferences.getInt("preferences_tunedbuffersize", -1)) {
            editor.putInt("preferences_tunedbuffersize", n2);
            editor.apply();
        }
    }

    public static void O(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        PreferenceManager.getDefaultSharedPreferences((Context)context).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void P(Context context) {
        PreferenceManager.getDefaultSharedPreferences((Context)context).edit().putInt("preferences_tunedbuffersize", -1).apply();
    }

    public static int Q(Context context, int n2, int n3) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{n2});
        try {
            int n4 = typedArray.getColor(0, n3);
            return n4;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static int R(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int S(Activity activity) {
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

    public static int T(Activity activity) {
        return activity.getResources().getConfiguration().screenWidthDp;
    }

    public static void U(Activity activity, Dialog dialog, int n2) {
        int n3 = t.S(activity);
        float f2 = activity.getResources().getDisplayMetrics().density;
        float f3 = f2 * (float)n2;
        float f4 = f2 * 16.0f;
        float f5 = n3;
        if (f3 > f5) {
            f3 = f5 - f4 * 2.0f;
        }
        dialog.getWindow().setLayout((int)f3, -2);
    }

    public static boolean V(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = sharedPreferences.getInt("preferences_loopclearcount", 0);
        int n3 = 0;
        if (n2 < 5) {
            n3 = 1;
            editor.putInt("preferences_loopclearcount", n2 + n3);
            editor.apply();
        }
        return (boolean)n3;
    }

    public static boolean W(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = sharedPreferences.getInt("preferences_loopendcount", 0);
        int n3 = 0;
        if (n2 < 5) {
            n3 = 1;
            editor.putInt("preferences_loopendcount", n2 + n3);
            editor.apply();
        }
        return (boolean)n3;
    }

    public static boolean X(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = sharedPreferences.getInt("preferences_loopstartcount", 0);
        int n3 = 0;
        if (n2 < 5) {
            n3 = 1;
            editor.putInt("preferences_loopstartcount", n2 + n3);
            editor.apply();
        }
        return (boolean)n3;
    }

    public static boolean Y(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = sharedPreferences.getInt("preferences_pitchresetcount", 0);
        int n3 = 0;
        if (n2 < 5) {
            n3 = 1;
            editor.putInt("preferences_pitchresetcount", n2 + n3);
            editor.apply();
        }
        return (boolean)n3;
    }

    public static boolean Z(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = sharedPreferences.getInt("preferences_playmodecount", 0);
        int n3 = 0;
        if (n2 < 12) {
            n3 = 1;
            editor.putInt("preferences_playmodecount", n2 + n3);
            editor.apply();
        }
        return (boolean)n3;
    }

    public static String a(PlayingQueue playingQueue, Context context) {
        return context.getPackageName();
    }

    public static boolean a0(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int n2 = sharedPreferences.getInt("shuffle_mode_count", 0);
        int n3 = 0;
        if (n2 < 6) {
            n3 = 1;
            editor.putInt("shuffle_mode_count", n2 + n3);
            editor.apply();
        }
        return (boolean)n3;
    }

    public static float b(Context context, float f2) {
        return TypedValue.applyDimension((int)1, (float)f2, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    public static void b0(long l2) {
        try {
            Thread.sleep((long)l2);
        }
        catch (InterruptedException interruptedException) {}
    }

    public static int c(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new TypedValue().data, new int[]{2130968779});
        int n2 = typedArray.getColor(0, 0);
        typedArray.recycle();
        return n2;
    }

    public static void c0(Context context, int n2, ImageView imageView, int n3) {
        Drawable drawable2 = androidx.core.graphics.drawable.a.r((Drawable)a.e((Context)context, (int)n2).mutate());
        imageView.setImageDrawable(drawable2);
        androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)n3);
    }

    public static int d(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new TypedValue().data, new int[]{2130968779});
        int n2 = typedArray.getResourceId(0, 0);
        typedArray.recycle();
        return n2;
    }

    public static void d0(Context context, int n2, MenuItem menuItem, int n3) {
        Drawable drawable2 = androidx.core.graphics.drawable.a.r((Drawable)a.e((Context)context, (int)n2).mutate());
        menuItem.setIcon(drawable2);
        androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)n3);
    }

    public static int e(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new TypedValue().data, new int[]{2130969602});
        int n2 = typedArray.getColor(0, 0);
        typedArray.recycle();
        return n2;
    }

    public static void e0(Context context, int n2, Toolbar toolbar, int n3) {
        Drawable drawable2 = androidx.core.graphics.drawable.a.r((Drawable)a.e((Context)context, (int)n2).mutate());
        toolbar.setNavigationIcon(drawable2);
        androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)n3);
    }

    public static int f(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new TypedValue().data, new int[]{2130969603});
        int n2 = typedArray.getColor(0, 0);
        typedArray.recycle();
        return n2;
    }

    public static boolean f0() {
        return Integer.parseInt((String)AppPrefs.k.i0()) != 3;
    }

    public static float g(Context context) {
        return Float.parseFloat((String)PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_maximum_speed", "1.5"));
    }

    public static void g0(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        PreferenceManager.getDefaultSharedPreferences((Context)context).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static float h(Context context) {
        return Float.parseFloat((String)PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_minimum_speed", "0.25"));
    }

    public static void h0(Context context) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
        editor.putLong("com.smp.PREF_POSITION", 0L);
        editor.putFloat("com.smp.PREF_RATE", 1.0f);
        editor.putFloat("com.smp.PREF_TEMPO", 1.0f);
        editor.putFloat("com.smp.PREF_PITCH", 0.0f);
        editor.putLong("com.smp.PREF_LOOP_START", Long.MIN_VALUE);
        editor.putLong("com.smp.PREF_LOOP_END", Long.MIN_VALUE);
        editor.putString("com.smp.PREF_FILENAME", null);
        editor.apply();
        PlayingQueue.getDefault().clear();
    }

    public static String i(Context context) {
        return context.getResources().getString(2131820673).replace((CharSequence)" ", (CharSequence)"");
    }

    public static String j(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_on_track_change", context.getString(2131820716));
    }

    public static int k(Context context) {
        int n2;
        String string2;
        PreferenceManager.getDefaultSharedPreferences((Context)context);
        int n3 = Build.VERSION.SDK_INT;
        String string3 = "512";
        if (n3 >= 17 && (string2 = ((AudioManager)context.getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) != null) {
            string3 = string2;
        }
        n2 = 512;
        try {
            n2 = Integer.parseInt((String)string3);
        }
        catch (NumberFormatException numberFormatException) {}
        return n2;
    }

    public static int l(Context context) {
        int n2;
        String string2;
        int n3 = Build.VERSION.SDK_INT;
        String string3 = "44100";
        if (n3 >= 17 && (string2 = ((AudioManager)context.getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE")) != null) {
            string3 = string2;
        }
        n2 = 44100;
        try {
            n2 = Integer.parseInt((String)string3);
        }
        catch (NumberFormatException numberFormatException) {}
        return n2;
    }

    public static int m(Context context) {
        return Integer.parseInt((String)PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_pitch_range", "2400"));
    }

    public static int n(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getInt("com.smp.PREF_PLAY_MODE", 1);
    }

    public static SharedPreferences o(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context);
    }

    public static SharedPreferences.Editor p(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
    }

    public static String q(long l2) {
        long l3 = l2 / 1000L;
        long l4 = l3 / 60L;
        long l5 = l3 % 60L;
        if (l4 < 60L) {
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{l4, l5};
            return String.format((Locale)locale, (String)"%02d:%02d", (Object[])arrobject);
        }
        long l6 = l4 / 60L;
        long l7 = l4 % 60L;
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{l6, l7, l5};
        return String.format((Locale)locale, (String)"%d:%02d:%02d", (Object[])arrobject);
    }

    public static String r(long l2) {
        long l3 = l2 / 1000L;
        long l4 = l3 / 60L;
        l3 % 60L;
        long l5 = l4 / 60L;
        long l6 = l4 % 60L;
        Locale locale = Locale.getDefault();
        Object[] arrobject = new Object[]{l5, l6};
        return String.format((Locale)locale, (String)"%d:%02d", (Object[])arrobject);
    }

    public static int s(Context context) {
        return Integer.parseInt((String)PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_seek", "3"));
    }

    public static int t(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getInt("preferences_tunedbuffersize", -1);
    }

    public static void u(Activity activity) {
        View view;
        if (activity != null && (view = activity.getCurrentFocus()) != null) {
            ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus();
        }
    }

    public static boolean v(Context context) {
        return true ^ AppPrefs.k.j0();
    }

    public static boolean w(Context context) {
        String string2 = PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_theme", context.getString(2131820723));
        if (string2.equals((Object)"System default")) {
            return t.J(context);
        }
        return true ^ string2.equals((Object)"Light");
    }

    public static boolean x(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_file_type", "mp3").equals((Object)"wav");
    }

    public static boolean y(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("preferences_ignore_audio_focus", false);
    }

    public static boolean z(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }
}

