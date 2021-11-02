/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;

public class g {
    public static int a = 0;
    public static int b = -1;
    private String c = null;
    private Context d;

    public g(Context context, String string2) {
        this.d = context;
        this.c = string2;
    }

    static void e(Context context, String string2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("material_showcaseview_prefs", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("status_");
        stringBuilder.append(string2);
        editor.putInt(stringBuilder.toString(), a).apply();
    }

    public void a() {
        this.d = null;
    }

    int b() {
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("material_showcaseview_prefs", 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("status_");
        stringBuilder.append(this.c);
        return sharedPreferences.getInt(stringBuilder.toString(), a);
    }

    boolean c() {
        return this.b() == b;
    }

    public void d() {
        g.e(this.d, this.c);
    }

    void f() {
        this.g(b);
    }

    void g(int n2) {
        SharedPreferences.Editor editor = this.d.getSharedPreferences("material_showcaseview_prefs", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("status_");
        stringBuilder.append(this.c);
        editor.putInt(stringBuilder.toString(), n2).apply();
    }
}

