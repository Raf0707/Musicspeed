/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Map
 *  java.util.Map$Entry
 */
package f.u.q0;

import f.u.d;
import f.z.d.k;
import java.util.Map;

public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V>
extends d<E> {
    public final boolean c(E e2) {
        k.g(e2, "element");
        return this.d((Map.Entry<? extends K, ? extends V>)e2);
    }

    public abstract boolean d(Map.Entry<? extends K, ? extends V> var1);
}

