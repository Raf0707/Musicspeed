/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build
 *  android.util.DisplayMetrics
 *  c.d.a.a.e
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package c.d.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import c.d.a.a.e;
import java.util.Locale;

public final class b
implements e {
    private final String a;
    private final String b;
    private final String c;

    public b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(displayMetrics.heightPixels);
        stringBuilder.append("x");
        stringBuilder.append(displayMetrics.widthPixels);
        this.a = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(displayMetrics.densityDpi);
        stringBuilder2.append("dpi");
        this.b = stringBuilder2.toString();
        this.c = b.f(displayMetrics);
    }

    private static String f(DisplayMetrics displayMetrics) {
        int n2 = displayMetrics.densityDpi;
        if (n2 != 120) {
            if (n2 != 160) {
                if (n2 != 213) {
                    if (n2 != 240) {
                        if (n2 != 320) {
                            if (n2 != 480) {
                                if (n2 != 640) {
                                    return "Unknown";
                                }
                                return "xxxhdpi";
                            }
                            return "xxhdpi";
                        }
                        return "xhdpi";
                    }
                    return "hdpi";
                }
                return "tvdpi";
            }
            return "mdpi";
        }
        return "ldpi";
    }

    public String a() {
        return Build.MANUFACTURER.toUpperCase(Locale.US);
    }

    public String b() {
        return Build.MODEL.toUpperCase(Locale.US);
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }
}

