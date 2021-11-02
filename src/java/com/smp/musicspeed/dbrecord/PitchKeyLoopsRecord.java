/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  c.e.c.f
 *  c.e.c.g
 *  c.e.c.t
 *  com.smp.musicspeed.utils.t
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import android.content.Context;
import android.content.SharedPreferences;
import c.e.c.f;
import c.e.c.g;
import com.smp.musicspeed.utils.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PitchKeyLoopsRecord {
    public List<?> loops;
    public float pitch = 0.0f;
    public float tempo = 1.0f;

    private PitchKeyLoopsRecord(float f2, float f3, List<?> list) {
        this.pitch = f2;
        this.tempo = f3;
        this.loops = list;
    }

    private static long determineLength(String string) {
        File file = new File(string);
        try {
            long l2 = file.length();
            return l2;
        }
        catch (SecurityException securityException) {
            return 0L;
        }
    }

    public static PitchKeyLoopsRecord loadFromPrefs(Context context, String string) {
        PitchKeyLoopsRecord pitchKeyLoopsRecord;
        f f2 = new g().b();
        long l2 = PitchKeyLoopsRecord.determineLength(string);
        SharedPreferences sharedPreferences = t.o((Context)context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(Long.toString((long)l2));
        String string2 = sharedPreferences.getString(stringBuilder.toString(), "");
        pitchKeyLoopsRecord = new PitchKeyLoopsRecord(0.0f, 1.0f, (List<?>)new ArrayList());
        if (string2.equals((Object)"")) {
            return pitchKeyLoopsRecord;
        }
        try {
            PitchKeyLoopsRecord pitchKeyLoopsRecord2;
            pitchKeyLoopsRecord = pitchKeyLoopsRecord2 = (PitchKeyLoopsRecord)f2.i(string2, PitchKeyLoopsRecord.class);
        }
        catch (c.e.c.t t2) {}
        return pitchKeyLoopsRecord;
    }

    public static void saveToPrefs(Context context, String string, float f2, float f3, List<?> list) {
        long l2 = PitchKeyLoopsRecord.determineLength(string);
        String string2 = PitchKeyLoopsRecord.toJson(new PitchKeyLoopsRecord(f2, f3, list));
        SharedPreferences.Editor editor = t.o((Context)context).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(Long.toString((long)l2));
        editor.putString(stringBuilder.toString(), string2);
        editor.apply();
    }

    private static String toJson(PitchKeyLoopsRecord pitchKeyLoopsRecord) {
        return new g().b().r((Object)pitchKeyLoopsRecord);
    }
}

