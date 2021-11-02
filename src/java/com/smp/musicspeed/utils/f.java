/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.os.Bundle;
import com.smp.musicspeed.utils.d;
import java.util.Arrays;

public class f {
    public static boolean a;
    public static Bundle b;
    private static String[] c;

    static {
        Bundle bundle;
        b = bundle = new Bundle();
        c = new String[]{"BE", "EL", "LT", "PT", "BG", "ES", "LU", "RO", "CZ", "FR", "HU", "SI", "DK", "HR", "MT", "SK", "DE", "IT", "NL", "FI", "EE", "CY", "AT", "SE", "IE", "LV", "PL", "UK", "CH", "NO", "IS", "LI"};
        bundle.putString("npa", "1");
    }

    public static void a(Context context) {
        d d2 = new d(context);
        String string2 = d2.b();
        String string3 = d2.c();
        if (string2 != null && string2.length() == 2 || string3 != null && string3.length() == 2) {
            boolean bl = f.b(string2) || f.b(string3);
            a = bl;
            return;
        }
        a = f.b(d2.a());
    }

    public static boolean b(String string2) {
        if (string2 == null) {
            return false;
        }
        return Arrays.asList((Object[])c).contains((Object)string2.toUpperCase());
    }
}

