/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c.c.a;

import android.content.Context;
import c.c.a.a;
import f.z.d.k;

public final class i
implements a {
    private static Context a;
    public static final i b;

    static {
        b = new i();
    }

    private i() {
    }

    @Override
    public Context a() {
        Context context = a;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Kotpref has not been initialized.");
    }

    public final void b(Context context) {
        k.g((Object)context, "context");
        a = context.getApplicationContext();
    }
}

