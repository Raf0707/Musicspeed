/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  f.g0.k
 *  f.z.d.k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Objects
 */
package com.smp.musicspeed.k0.m0;

import android.content.Context;
import android.text.TextUtils;
import f.g0.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class i {
    public static final String a(Context context, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"musicMediaTitle");
        boolean bl = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl) {
            return string3;
        }
        if (!f.z.d.k.c((Object)string2, (Object)context.getString(2131821379))) {
            if (f.z.d.k.c((Object)string2, (Object)context.getString(2131821377))) {
                return string3;
            }
            String string4 = k.b0((CharSequence)string2).toString();
            Objects.requireNonNull((Object)string4, (String)"null cannot be cast to non-null type java.lang.String");
            String string5 = string4.toLowerCase();
            f.z.d.k.f((Object)string5, (String)"(this as java.lang.String).toLowerCase()");
            if (k.o((String)string5, (String)"the ", (boolean)false, (int)2, null)) {
                Objects.requireNonNull((Object)string5, (String)"null cannot be cast to non-null type java.lang.String");
                string5 = string5.substring(4);
                f.z.d.k.f((Object)string5, (String)"(this as java.lang.String).substring(startIndex)");
            } else if (k.o((String)string5, (String)"a ", (boolean)false, (int)2, null)) {
                Objects.requireNonNull((Object)string5, (String)"null cannot be cast to non-null type java.lang.String");
                string5 = string5.substring(2);
                f.z.d.k.f((Object)string5, (String)"(this as java.lang.String).substring(startIndex)");
            }
            int n2 = string5.length();
            boolean bl2 = false;
            if (n2 == 0) {
                bl2 = true;
            }
            if (bl2) {
                return string3;
            }
            string3 = string5;
        }
        return string3;
    }

    public static final String b(long l2) {
        return i.d(l2);
    }

    public static final String c(Context context, String string2) {
        f.z.d.k.g((Object)context, (String)"context");
        f.z.d.k.g((Object)string2, (String)"musicMediaTitle");
        boolean bl = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl) {
            return string3;
        }
        if (!f.z.d.k.c((Object)string2, (Object)context.getString(2131821379))) {
            if (f.z.d.k.c((Object)string2, (Object)context.getString(2131821377))) {
                return string3;
            }
            String string4 = k.b0((CharSequence)string2).toString();
            Objects.requireNonNull((Object)string4, (String)"null cannot be cast to non-null type java.lang.String");
            String string5 = string4.toLowerCase();
            f.z.d.k.f((Object)string5, (String)"(this as java.lang.String).toLowerCase()");
            if (k.o((String)string5, (String)"the ", (boolean)false, (int)2, null)) {
                Objects.requireNonNull((Object)string5, (String)"null cannot be cast to non-null type java.lang.String");
                string5 = string5.substring(4);
                f.z.d.k.f((Object)string5, (String)"(this as java.lang.String).substring(startIndex)");
            } else if (k.o((String)string5, (String)"a ", (boolean)false, (int)2, null)) {
                Objects.requireNonNull((Object)string5, (String)"null cannot be cast to non-null type java.lang.String");
                string5 = string5.substring(2);
                f.z.d.k.f((Object)string5, (String)"(this as java.lang.String).substring(startIndex)");
            }
            boolean bl2 = string5.length() == 0;
            if (bl2) {
                return string3;
            }
            String string6 = String.valueOf((char)string5.charAt(0));
            Objects.requireNonNull((Object)string6, (String)"null cannot be cast to non-null type java.lang.String");
            string3 = string6.toUpperCase();
            f.z.d.k.f((Object)string3, (String)"(this as java.lang.String).toUpperCase()");
        }
        return string3;
    }

    private static final String d(long l2) {
        Date date = new Date(l2 * 1000L);
        String string2 = new SimpleDateFormat("yyyy-MM-dd").format(date);
        f.z.d.k.f((Object)string2, (String)"format.format(date)");
        return string2;
    }

    public static final String e(String string2, String string3) {
        f.z.d.k.g((Object)string3, (String)"convertValue");
        if (string2 == null || f.z.d.k.c((Object)string2, (Object)"<unknown>")) {
            string2 = string3;
        }
        return string2;
    }
}

