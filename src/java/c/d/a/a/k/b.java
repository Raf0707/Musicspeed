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
 *  java.util.Arrays
 */
package c.d.a.a.k;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import c.d.a.a.d;
import c.d.a.a.f;
import c.d.a.a.k.e;
import c.d.a.a.m.a;
import java.util.Arrays;

public abstract class b
implements e {
    private final String[] a;

    public /* varargs */ b(String ... arrstring) {
        this.a = (String[])Arrays.copyOf((Object[])arrstring, (int)arrstring.length);
    }

    private Intent c(d d2, f f2, c.d.a.a.e e2) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse((String)"mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", this.a);
        intent.putExtra("android.intent.extra.SUBJECT", this.d(d2, f2, e2));
        intent.putExtra("android.intent.extra.TEXT", this.b(d2, f2, e2));
        return intent;
    }

    private void e(Activity activity, Intent intent) {
        try {
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
        }
        catch (Exception exception) {}
    }

    public boolean a(Activity activity, d d2, f f2, c.d.a.a.e e2) {
        Intent intent = this.c(d2, f2, e2);
        if (!f2.d(intent)) {
            a.j().a("Unable to present email client chooser.");
            return false;
        }
        this.e(activity, intent);
        return true;
    }

    protected abstract String b(d var1, f var2, c.d.a.a.e var3);

    protected abstract String d(d var1, f var2, c.d.a.a.e var3);
}

