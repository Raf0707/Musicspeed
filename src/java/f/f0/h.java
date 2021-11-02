/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Iterator
 */
package f.f0;

import f.f0.b;
import f.f0.g;
import f.f0.h;
import f.z.d.k;
import java.util.Iterator;

class h
extends g {
    public static <T> b<T> c(Iterator<? extends T> iterator) {
        k.g(iterator, "$this$asSequence");
        return h.d(new b<T>(iterator){
            final /* synthetic */ Iterator a;
            {
                this.a = iterator;
            }

            public Iterator<T> iterator() {
                return this.a;
            }
        });
    }

    public static final <T> b<T> d(b<? extends T> b2) {
        k.g(b2, "$this$constrainOnce");
        if (b2 instanceof f.f0.a) {
            return b2;
        }
        return new f.f0.a<T>(b2);
    }
}

