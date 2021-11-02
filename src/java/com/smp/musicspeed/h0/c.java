/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.h0;

import f.z.d.k;

public final class c {
    public static final String a() {
        if (k.c((Object)"play", (Object)"play")) {
            return "https://play.google.com/store/apps/details?id=com.smp.musicspeed";
        }
        if (k.c((Object)"play", (Object)"amazon")) {
            return "http://www.amazon.com/gp/mas/dl/android?p=com.smp.musicspeed.changer";
        }
        if (k.c((Object)"play", (Object)"huawei")) {
            return "https://appgallery.cloud.huawei.com/marketshare/app/C102774451";
        }
        throw new IllegalStateException();
    }
}

