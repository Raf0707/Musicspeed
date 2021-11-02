/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.x.a
 *  f.x.b
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package f;

import f.x.a;
import f.z.d.k;

class b {
    public static void a(Throwable throwable, Throwable throwable2) {
        k.g((Object)throwable, (String)"$this$addSuppressed");
        k.g((Object)throwable2, (String)"exception");
        if (throwable != throwable2) {
            f.x.b.a.a(throwable, throwable2);
        }
    }
}

