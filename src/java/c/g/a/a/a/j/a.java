/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package c.g.a.a.a.j;

import android.os.Build;
import c.g.a.a.a.j.b;
import org.json.JSONObject;

public final class a {
    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("; ");
        stringBuilder.append(Build.MODEL);
        return stringBuilder.toString();
    }

    public static String b() {
        return Integer.toString((int)Build.VERSION.SDK_INT);
    }

    public static String c() {
        return "Android";
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.g(jSONObject, "deviceType", a.a());
        b.g(jSONObject, "osVersion", a.b());
        b.g(jSONObject, "os", a.c());
        return jSONObject;
    }
}

