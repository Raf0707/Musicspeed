/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.BidiFormatter
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.NumberFormat
 *  java.util.Locale
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.text.BidiFormatter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.t;
import java.text.NumberFormat;
import java.util.Locale;

public class n {
    public static String a(Context context, String string2) {
        if (t.E(context)) {
            BidiFormatter bidiFormatter = BidiFormatter.getInstance();
            TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.RTL;
            String string3 = g.d(string2);
            if (string3.equals((Object)string2)) {
                return string2;
            }
            String string4 = bidiFormatter.unicodeWrap(g.j(string2), textDirectionHeuristic, true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
        return string2;
    }

    public static String b(float f2) {
        return NumberFormat.getPercentInstance((Locale)Locale.getDefault()).format((double)f2);
    }

    public static String c(int n2) {
        Object[] arrobject = new Object[]{n2};
        return String.format((String)"%d", (Object[])arrobject);
    }

    public static String d(float f2) {
        Object[] arrobject = new Object[]{Float.valueOf((float)f2)};
        return String.format((String)"%+.1f", (Object[])arrobject);
    }

    public static String e(float f2) {
        Object[] arrobject = new Object[]{Float.valueOf((float)f2)};
        return String.format((String)"%+.2f", (Object[])arrobject);
    }

    public static String f(float f2) {
        return n.b(f2);
    }

    public static String g(float f2) {
        return n.b(f2);
    }
}

