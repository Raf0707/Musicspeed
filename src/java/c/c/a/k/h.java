/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  c.c.a.h
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.k;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import c.c.a.k.a;
import f.e0.i;
import f.z.d.k;

public final class h
extends a<String> {
    private final String d;
    private final String e;
    private final boolean f;

    public h(String string, String string2, boolean bl) {
        k.g(string, "default");
        this.d = string;
        this.e = string2;
        this.f = bl;
    }

    @Override
    public String e() {
        return this.e;
    }

    public String k(i<?> i2, SharedPreferences sharedPreferences) {
        k.g(i2, "property");
        k.g((Object)sharedPreferences, "preference");
        String string = sharedPreferences.getString(this.c(), this.d);
        if (string != null) {
            return string;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void l(i<?> i2, String string, SharedPreferences.Editor editor) {
        k.g(i2, "property");
        k.g(string, "value");
        k.g((Object)editor, "editor");
        editor.putString(this.c(), string);
    }

    @SuppressLint(value={"CommitPrefEdits"})
    public void m(i<?> i2, String string, SharedPreferences sharedPreferences) {
        k.g(i2, "property");
        k.g(string, "value");
        k.g((Object)sharedPreferences, "preference");
        SharedPreferences.Editor editor = sharedPreferences.edit().putString(this.c(), string);
        k.f((Object)editor, "preference.edit().putString(preferenceKey, value)");
        c.c.a.h.a((SharedPreferences.Editor)editor, (boolean)this.f);
    }
}

