/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  java.lang.Object
 */
package c.g.a.a.a.f;

import android.annotation.SuppressLint;
import android.content.Context;

public class d {
    @SuppressLint(value={"StaticFieldLeak"})
    private static d a = new d();
    private Context b;

    private d() {
    }

    public static d a() {
        return a;
    }

    public void b(Context context) {
        Context context2 = context != null ? context.getApplicationContext() : null;
        this.b = context2;
    }

    public Context c() {
        return this.b;
    }
}

