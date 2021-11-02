/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.w.g$a$a
 *  f.w.g$b
 *  f.w.h
 *  f.z.c.p
 *  java.lang.Object
 */
package f.w;

import f.w.g;
import f.w.h;
import f.z.c.p;
import f.z.d.k;

public interface g {
    public <R> R fold(R var1, p<? super R, ? super b, ? extends R> var2);

    public <E extends b> E get(c<E> var1);

    public g minusKey(c<?> var1);

    public g plus(g var1);

    public static final class f.w.g$a {
        public static g a(g g2, g g3) {
            k.g(g3, "context");
            if (g3 == h.f) {
                return g2;
            }
            return g3.fold(g2, a.g);
        }
    }

    public static interface c<E extends b> {
    }

}

