/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  c.c.a.h
 *  java.lang.Long
 *  java.lang.Number
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

public final class f
extends a<Long> {
    private final long d;
    private final String e;
    private final boolean f;

    public f(long l2, String string, boolean bl) {
        this.d = l2;
        this.e = string;
        this.f = bl;
    }

    @Override
    public String e() {
        return this.e;
    }

    public Long k(i<?> i2, SharedPreferences sharedPreferences) {
        k.g(i2, "property");
        k.g((Object)sharedPreferences, "preference");
        return sharedPreferences.getLong(this.c(), this.d);
    }

    public void l(i<?> i2, long l2, SharedPreferences.Editor editor) {
        k.g(i2, "property");
        k.g((Object)editor, "editor");
        editor.putLong(this.c(), l2);
    }

    @SuppressLint(value={"CommitPrefEdits"})
    public void m(i<?> i2, long l2, SharedPreferences sharedPreferences) {
        k.g(i2, "property");
        k.g((Object)sharedPreferences, "preference");
        SharedPreferences.Editor editor = sharedPreferences.edit().putLong(this.c(), l2);
        k.f((Object)editor, "preference.edit().putLong(preferenceKey, value)");
        h.a((SharedPreferences.Editor)editor, (boolean)this.f);
    }
}

