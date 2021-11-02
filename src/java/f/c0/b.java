/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ThreadLocal
 *  java.util.Random
 */
package f.c0;

import f.c0.b;
import f.z.d.k;
import java.util.Random;

public final class b
extends f.c0.a {
    private final a h = new ThreadLocal<Random>(){

        protected Random a() {
            return new Random();
        }
    };

    @Override
    public Random e() {
        Object object = this.h.get();
        k.f(object, "implStorage.get()");
        return (Random)object;
    }
}

