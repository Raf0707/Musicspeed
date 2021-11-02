/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.k0.m0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import f.z.d.k;

public final class h {
    public static final void a(Context context) {
        k.g((Object)context, (String)"context");
        context.getContentResolver().notifyChange(Uri.parse((String)"content://media"), null);
    }
}

