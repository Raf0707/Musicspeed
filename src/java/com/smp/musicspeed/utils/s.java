/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  com.smp.musicspeed.utils.AppPrefs
 *  f.g0.k
 *  f.z.d.k
 *  java.io.File
 *  java.io.FileDescriptor
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  org.jaudiotagger.audio.AudioFile
 *  org.jaudiotagger.audio.AudioFileIO
 *  org.jaudiotagger.tag.FieldKey
 *  org.jaudiotagger.tag.Tag
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.view.ViewGroup;
import com.smp.musicspeed.utils.AppPrefs;
import f.g0.k;
import java.io.File;
import java.io.FileDescriptor;
import java.util.Objects;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public final class s {
    public static final void a(String string2, String string3) {
        f.z.d.k.g((Object)string2, (String)"pathOut");
        f.z.d.k.g((Object)string3, (String)"artistName");
        try {
            AudioFile audioFile = AudioFileIO.read((File)new File(string2));
            audioFile.getTagOrCreateAndSetDefault().addField(FieldKey.ARTIST, new String[]{string3});
            audioFile.commit();
        }
        catch (Exception exception) {}
    }

    /*
     * Exception decompiling
     */
    public static final void b(Context var0, File var1_1, Uri var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    private static final void c(File file) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open((File)file, (int)805306368);
            parcelFileDescriptor.getFileDescriptor().sync();
            parcelFileDescriptor.close();
        }
        catch (Exception exception) {}
    }

    public static final void d(SharedPreferences sharedPreferences, String string2) {
        f.z.d.k.g((Object)sharedPreferences, (String)"prefs");
        f.z.d.k.g((Object)string2, (String)"storedVersion");
        if (f.z.d.k.c((Object)sharedPreferences.getString("preferences_minimum_speed", "0.25"), (Object)"0.1")) {
            sharedPreferences.edit().putString("preferences_minimum_speed", "0.15").apply();
        }
    }

    /*
     * Exception decompiling
     */
    public static final void e(Context var0, SharedPreferences var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl33 : RETURN : trying to set 1 previously set to 0
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

    private static final void f(SharedPreferences sharedPreferences, String string2) {
        sharedPreferences.edit().putString("preferences_store_path", string2).apply();
    }

    public static final void g(SharedPreferences sharedPreferences, String string2) {
        f.z.d.k.g((Object)sharedPreferences, (String)"prefs");
        f.z.d.k.g((Object)string2, (String)"storedVersion");
        int n2 = Integer.parseInt((String)k.V((String)string2, (char)'.', (String)"0"));
        boolean bl = 1 <= n2 && n2 <= 8;
        if (bl) {
            if (sharedPreferences.getBoolean("preferences_bought_no_ads", false)) {
                AppPrefs.k.o0(true);
            }
            if (f.z.d.k.c((Object)sharedPreferences.getString("preferences_audio_api", ""), (Object)"AudioTrack")) {
                AppPrefs.k.R0(false);
            }
            String string3 = sharedPreferences.getString("preferences_waveformmode", "0");
            boolean bl2 = sharedPreferences.getBoolean("preferences_show_link", false);
            boolean bl3 = sharedPreferences.getBoolean("preferences_show_plusminus", false);
            boolean bl4 = sharedPreferences.getBoolean("preferences_show_bpm", false);
            boolean bl5 = sharedPreferences.getBoolean("preferences_show_key", false);
            boolean bl6 = sharedPreferences.getBoolean("preferences_show_loop", true);
            boolean bl7 = sharedPreferences.getBoolean("preferences_show_preamp", false);
            boolean bl8 = sharedPreferences.getBoolean("preferences_show_balance", false);
            boolean bl9 = sharedPreferences.getBoolean("preferences_show_equalizer", false);
            AppPrefs appPrefs = AppPrefs.k;
            appPrefs.Q0(String.valueOf((Object)string3));
            appPrefs.O0(bl2);
            appPrefs.P0(bl3);
            appPrefs.r0(bl4);
            appPrefs.x0(bl5);
            appPrefs.z0(bl6);
            appPrefs.D0(bl7);
            appPrefs.q0(bl8);
            appPrefs.v0(bl9);
            if (bl4 || bl5 || !bl6 || bl7 || bl8 || bl9) {
                appPrefs.K0(5);
                appPrefs.p0(true);
                appPrefs.u0(true);
            }
            if (!sharedPreferences.getBoolean("com.smp.preampenabled", true)) {
                float f2 = sharedPreferences.getFloat("com.smp.preamplevel", -3.0f) FCMPG -3.0f;
                boolean bl10 = false;
                if (f2 == false) {
                    bl10 = true;
                }
                if (bl10) {
                    sharedPreferences.edit().putBoolean("com.smp.preampenabled", true).apply();
                }
            }
        }
    }

    public static final boolean h(String string2) {
        f.z.d.k.g((Object)string2, (String)"string");
        return k.h((CharSequence)string2);
    }

    public static final void i(View view, int n2, int n3, int n4, int n5) {
        f.z.d.k.e((Object)view);
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull((Object)layoutParams, (String)"null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams)layoutParams).setMargins(n2, n3, n4, n5);
            view.requestLayout();
        }
    }
}

