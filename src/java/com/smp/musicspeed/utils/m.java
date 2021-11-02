/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.c.l
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.utils;

import f.z.c.l;
import f.z.d.k;

public class m<T, A> {
    private l<? super A, ? extends T> a;
    private volatile T b;

    public m(l<? super A, ? extends T> l2) {
        k.g(l2, (String)"creator");
        this.a = l2;
    }

    public final T a(A a2) {
        T t2 = this.b;
        if (t2 != null) {
            return t2;
        }
        m m2 = this;
        synchronized (m2) {
            Object object;
            block5 : {
                object = this.b;
                if (object != null) break block5;
                l<? super A, ? extends T> l2 = this.a;
                k.e(l2);
                this.b = object = l2.g(a2);
                this.a = null;
            }
            return object;
        }
    }
}

