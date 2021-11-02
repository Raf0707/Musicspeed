/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package h.a.h;

import h.a.h.c;
import h.a.h.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
implements g {
    String f;
    List<c> g = new ArrayList();
    Map<h.a.g.d.a, long[]> h = new HashMap();

    public a(String string) {
        this.f = string;
    }

    @Override
    public List<c> e() {
        return this.g;
    }

    @Override
    public long getDuration() {
        long[] arrl = this.F();
        int n2 = arrl.length;
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            l2 += arrl[i2];
        }
        return l2;
    }

    @Override
    public Map<h.a.g.d.a, long[]> n() {
        return this.h;
    }
}

