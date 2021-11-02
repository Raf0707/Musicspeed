/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package f.b0;

import f.b0.d;
import f.e0.i;
import f.z.d.k;

public abstract class b<V>
implements d<Object, V> {
    private V a;

    public b(V v2) {
        this.a = v2;
    }

    @Override
    public V a(Object object, i<?> i2) {
        k.g(i2, "property");
        return this.a;
    }

    @Override
    public void b(Object object, i<?> i2, V v2) {
        k.g(i2, "property");
        V v3 = this.a;
        if (!this.d(i2, v3, v2)) {
            return;
        }
        this.a = v2;
        this.c(i2, v3, v2);
    }

    protected abstract void c(i<?> var1, V var2, V var3);

    protected boolean d(i<?> i2, V v2, V v3) {
        k.g(i2, "property");
        return true;
    }
}

