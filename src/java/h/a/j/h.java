/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.e
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.List
 */
package h.a.j;

import h.a.b;
import h.a.c;
import h.a.e;
import java.util.Iterator;
import java.util.List;

public class h {
    public static long a(c c2, e e2, long l2) {
        Iterator iterator = c2.i().iterator();
        while (iterator.hasNext()) {
            long l3;
            b b2 = (b)iterator.next();
            if (b2 == e2) {
                return l2;
            }
            if (b2 instanceof c) {
                long l4 = h.a((c)((Object)b2), e2, 0L);
                if (l4 > 0L) {
                    return l4 + l2;
                }
                l3 = b2.a();
            } else {
                l3 = b2.a();
            }
            l2 += l3;
        }
        return -1L;
    }
}

