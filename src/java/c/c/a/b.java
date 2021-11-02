/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  c.c.a.f
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import c.c.a.f;
import f.z.d.k;

final class b
implements f {
    public static final b a = new b();

    private b() {
    }

    public SharedPreferences a(Context context, String string, int n2) {
        k.g((Object)context, "context");
        k.g(string, "name");
        SharedPreferences sharedPreferences = context.getSharedPreferences(string, n2);
        k.f((Object)sharedPreferences, "context.getSharedPreferences(name, mode)");
        return sharedPreferences;
    }
}

