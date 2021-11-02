/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  c.g.a.a.a.f.f
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a;

import android.content.Context;
import c.g.a.a.a.f.b;
import c.g.a.a.a.f.d;
import c.g.a.a.a.f.f;
import c.g.a.a.a.j.e;

public class g {
    private boolean a;

    private void d(Context context) {
        e.d((Object)context, "Application Context cannot be null");
    }

    String a() {
        return "1.3.16-Mopub";
    }

    void b(Context context) {
        this.d(context);
        if (!this.e()) {
            this.c(true);
            f.c().d(context);
            b.a().b(context);
            c.g.a.a.a.j.b.c(context);
            d.a().b(context);
        }
    }

    void c(boolean bl) {
        this.a = bl;
    }

    boolean e() {
        return this.a;
    }
}

