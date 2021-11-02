/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package f.u;

import f.u.x;
import f.u.z;
import f.z.d.d0.a;
import f.z.d.k;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class y
implements Map,
Serializable,
a {
    public static final y f = new y();

    private y() {
    }

    public boolean b(Void void_) {
        k.g((Object)void_, "value");
        return false;
    }

    public Void c(Object object) {
        return null;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object object) {
        return false;
    }

    public Set<Map.Entry> d() {
        return z.f;
    }

    public Set<Object> e() {
        return z.f;
    }

    public boolean equals(Object object) {
        return object instanceof Map && ((Map)object).isEmpty();
    }

    public int f() {
        return 0;
    }

    public Collection g() {
        return x.f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public /* synthetic */ Object put(Object object, Object object2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "{}";
    }
}

