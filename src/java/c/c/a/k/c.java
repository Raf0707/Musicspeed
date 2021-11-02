/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  c.c.a.h
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a.k;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import c.c.a.h;
import c.c.a.k.a;
import f.e0.i;
import f.z.d.k;

public final class c
extends a<Boolean> {
    private final boolean d;
    private final String e;
    private final boolean f;

    public c(boolean bl, String string, boolean bl2) {
        this.d = bl;
        this.e = string;
        this.f = bl2;
    }

    @Override
    public String e() {
        return this.e;
    }

    public Boolean k(i<?> i2, SharedPreferences sharedPreferences) {
        k.g(i2, "property");
        k.g((Object)sharedPreferences, "preference");
        return sharedPreferences.getBoolean(this.c(), this.d);
    }

    public void l(i<?> i2, boolean bl, SharedPreferences.Editor editor) {
        k.g(i2, "property");
        k.g((Object)editor, "editor");
        editor.putBoolean(this.c(), bl);
    }

    @SuppressLint(value={"CommitPrefEdits"})
    public void m(i<?> i2, boolean bl, SharedPreferences sharedPreferences) {
        k.g(i2, "property");
        k.g((Object)sharedPreferences, "preference");
        SharedPreferences.Editor editor = sharedPreferences.edit().putBoolean(this.c(), bl);
        k.f((Object)editor, "preference.edit().putBoolean(preferenceKey, value)");
        h.a((SharedPreferences.Editor)editor, (boolean)this.f);
    }
}

