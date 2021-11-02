/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.smp.musicspeed.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

class d {
    TelephonyManager a;

    d(Context context) {
        this.a = (TelephonyManager)context.getSystemService("phone");
    }

    protected String a() {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            return locale.getCountry();
        }
        return null;
    }

    protected String b() {
        String string2;
        if (this.a.getPhoneType() == 1 && !TextUtils.isEmpty((CharSequence)(string2 = this.a.getNetworkCountryIso()))) {
            return string2;
        }
        return null;
    }

    protected String c() {
        String string2 = this.a.getSimCountryIso();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        return null;
    }
}

