/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package f.w.k.a;

import f.w.d;
import f.w.g;
import f.w.h;
import f.w.k.a.a;

public abstract class j
extends a {
    public j(d<Object> d2) {
        super(d2);
        if (d2 != null) {
            boolean bl = d2.getContext() == h.f;
            if (bl) {
                return;
            }
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override
    public g getContext() {
        return h.f;
    }
}

