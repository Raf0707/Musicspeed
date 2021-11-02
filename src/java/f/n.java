/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package f;

import f.m;
import f.z.d.k;

public final class n {
    public static final Object a(Throwable throwable) {
        k.g((Object)throwable, (String)"exception");
        return new m.b(throwable);
    }

    public static final void b(Object object) {
        if (!(object instanceof m.b)) {
            return;
        }
        throw ((m.b)object).f;
    }
}

