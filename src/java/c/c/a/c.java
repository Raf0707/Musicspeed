/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  c.c.a.i
 *  java.lang.Object
 */
package c.c.a;

import android.content.Context;
import c.c.a.i;
import f.z.d.k;

public final class c {
    public static final c a = new c();

    private c() {
    }

    public final void a(Context context) {
        k.g((Object)context, "context");
        i i2 = i.b;
        Context context2 = context.getApplicationContext();
        k.f((Object)context2, "context.applicationContext");
        i2.b(context2);
    }
}

