/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package f.x.d;

import f.z.d.k;

public class a
extends f.x.a {
    @Override
    public void a(Throwable throwable, Throwable throwable2) {
        k.g((Object)throwable, "cause");
        k.g((Object)throwable2, "exception");
        throwable.addSuppressed(throwable2);
    }
}

