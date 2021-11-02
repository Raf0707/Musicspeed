/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c.a.k.g
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Set
 */
package c.c.a.k;

import c.c.a.d;
import c.c.a.k.g;
import f.b0.c;
import f.e0.i;
import f.z.d.k;
import java.util.Map;
import java.util.Set;

public abstract class b
implements c<d, Set<String>>,
g {
    private i<?> a;

    public String c() {
        String string = this.d();
        if (string != null) {
            return string;
        }
        i<?> i2 = this.a;
        if (i2 == null) {
            k.s("property");
        }
        return i2.getName();
    }

    public abstract String d();

    public final c<d, Set<String>> e(d d2, i<?> i2) {
        k.g(d2, "thisRef");
        k.g(i2, "property");
        this.a = i2;
        d2.m().put((Object)i2.getName(), (Object)this);
        return this;
    }
}

