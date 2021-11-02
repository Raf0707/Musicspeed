/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.c.l
 *  com.google.gson.internal.g
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package c.e.c;

import c.e.c.l;
import c.e.c.n;
import com.google.gson.internal.g;
import java.util.Map;
import java.util.Set;

public final class o
extends l {
    private final g<String, l> a = new g();

    public boolean equals(Object object) {
        return object == this || object instanceof o && ((o)object).a.equals(this.a);
        {
        }
    }

    public void h(String string, l l2) {
        g<String, l> g2 = this.a;
        if (l2 == null) {
            l2 = n.a;
        }
        g2.put((Object)string, (Object)l2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, l>> i() {
        return this.a.entrySet();
    }
}

