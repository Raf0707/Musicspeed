/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  c.d.a.a.d
 *  c.d.a.a.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package c.d.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import c.d.a.a.d;
import c.d.a.a.g;

public final class a
implements d {
    private final String a;
    private final String b;
    private final int c;
    private final long d;
    private final long e;
    private final g f;

    public a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        PackageInfo packageInfo = this.f(context);
        String string = packageManager.getInstallerPackageName(context.getPackageName());
        this.a = applicationInfo.loadLabel(packageManager).toString();
        this.b = packageInfo.versionName;
        this.c = packageInfo.versionCode;
        this.d = packageInfo.firstInstallTime;
        this.e = packageInfo.lastUpdateTime;
        this.f = g.a((String)string);
    }

    private PackageInfo f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
    }

    public long a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public g c() {
        return this.f;
    }

    public int d() {
        return this.c;
    }

    public long e() {
        return this.e;
    }

    public String getName() {
        return this.a;
    }
}

