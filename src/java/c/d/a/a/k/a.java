/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Intent
 *  android.net.Uri
 *  c.d.a.a.d
 *  c.d.a.a.e
 *  c.d.a.a.f
 *  c.d.a.a.k.e
 *  c.d.a.a.n.c
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.d.a.a.k;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import c.d.a.a.d;
import c.d.a.a.f;
import c.d.a.a.k.e;
import c.d.a.a.n.c;

public final class a
implements e {
    private final String a = null;

    private Uri b(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("amzn://apps/android?p=");
        stringBuilder.append(string);
        return Uri.parse((String)stringBuilder.toString());
    }

    private Uri c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://www.amazon.com/gp/mas/dl/android?p=");
        stringBuilder.append(string);
        return Uri.parse((String)stringBuilder.toString());
    }

    public boolean a(Activity activity, d d2, f f2, c.d.a.a.e e2) {
        String string = c.a((String)this.a, (String)activity.getPackageName());
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", this.b(string)));
            activity.overridePendingTransition(17432576, 17432577);
            return true;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", this.c(string)));
                activity.overridePendingTransition(17432576, 17432577);
                return true;
            }
            catch (ActivityNotFoundException activityNotFoundException2) {
                return false;
            }
        }
    }
}

