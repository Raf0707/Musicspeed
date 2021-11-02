/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.net.Uri
 *  c.d.a.a.d
 *  c.d.a.a.e
 *  c.d.a.a.f
 *  c.d.a.a.k.e
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.h0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import c.d.a.a.d;
import c.d.a.a.e;
import c.d.a.a.f;
import f.z.d.k;

public final class a
implements c.d.a.a.k.e {
    private final Uri b(String string) {
        Uri uri = Uri.parse((String)"https://appgallery.cloud.huawei.com/marketshare/app/C102774451");
        k.f((Object)uri, "parse(HUAWEI_APP_GALLERY_LINK)");
        return uri;
    }

    public boolean a(Activity activity, d d2, f f3, e e2) {
        k.g((Object)activity, "currentActivity");
        k.g((Object)d2, "app");
        k.g((Object)f3, "environment");
        k.g((Object)e2, "device");
        String string = activity.getPackageName();
        k.f(string, "currentActivity.packageName");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", this.b(string));
            intent.setPackage("com.huawei.appmarket");
            activity.startActivity(intent);
            activity.overridePendingTransition(17432576, 17432577);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

