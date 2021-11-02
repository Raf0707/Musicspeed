/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.t
 *  java.lang.Object
 *  java.util.List
 */
package f.u;

import f.u.c;
import f.u.t;
import f.z.d.k;
import java.util.List;

final class l0<T>
extends c<T> {
    private final List<T> f;

    public l0(List<T> list) {
        k.g(list, "delegate");
        this.f = list;
    }

    public void add(int n2, T t2) {
        this.f.add(t.o((List)this, (int)n2), t2);
    }

    @Override
    public int b() {
        return this.f.size();
    }

    @Override
    public T c(int n2) {
        return (T)this.f.remove(t.n((List)this, (int)n2));
    }

    public void clear() {
        this.f.clear();
    }

    public T get(int n2) {
        return (T)this.f.get(t.n((List)this, (int)n2));
    }

    public T set(int n2, T t2) {
        return (T)this.f.set(t.n((List)this, (int)n2), t2);
    }
}

