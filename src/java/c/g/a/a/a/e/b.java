/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  c.g.a.a.a.e.l
 *  java.lang.Object
 *  java.lang.String
 */
package c.g.a.a.a.e;

import android.view.View;
import c.g.a.a.a.e.c;
import c.g.a.a.a.e.d;
import c.g.a.a.a.e.g;
import c.g.a.a.a.e.l;
import c.g.a.a.a.j.e;

public abstract class b {
    public static b b(c c2, d d2) {
        e.a();
        e.d(c2, "AdSessionConfiguration is null");
        e.d(d2, "AdSessionContext is null");
        return new l(c2, d2);
    }

    public abstract void a(View var1, g var2, String var3);

    public abstract void c();

    public abstract void d(View var1);

    public abstract void e();
}

