/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.b.a.b.b$a
 *  b.b.a.b.b$b
 *  b.b.a.b.b$d
 *  java.lang.Boolean
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.WeakHashMap
 */
package b.b.a.b;

import b.b.a.b.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/*
 * Exception performing whole class analysis.
 */
public class b<K, V>
implements Iterable<Map.Entry<K, V>> {
    c<K, V> f;
    private c<K, V> g;
    private WeakHashMap<f<K, V>, Boolean> h;
    private int i;

    public b() {
        this.h = new WeakHashMap();
        this.i = 0;
    }

    public Map.Entry<K, V> a() {
        return this.f;
    }

    protected c<K, V> b(K k2) {
        c<K, V> c2 = this.f;
        while (c2 != null) {
            if (c2.f.equals(k2)) {
                return c2;
            }
            c2 = c2.h;
        }
        return c2;
    }

    public b<K, V> c() {
        d d2 = new /* Unavailable Anonymous Inner Class!! */;
        this.h.put((Object)d2, (Object)Boolean.FALSE);
        return d2;
    }

    public Map.Entry<K, V> d() {
        return this.g;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b b2 = new /* Unavailable Anonymous Inner Class!! */;
        this.h.put((Object)b2, (Object)Boolean.FALSE);
        return b2;
    }

    protected c<K, V> e(K k2, V v2) {
        c<K, V> c2 = new c<K, V>(k2, v2);
        this.i = 1 + this.i;
        c<K, V> c3 = this.g;
        if (c3 == null) {
            this.f = c2;
            this.g = c2;
            return c2;
        }
        c3.h = c2;
        c2.i = c3;
        this.g = c2;
        return c2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        b b2 = (b)object;
        if (this.size() != b2.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        Iterator<Map.Entry<K, V>> iterator2 = b2.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Object object2 = iterator2.next();
            if ((entry != null || object2 == null) && (entry == null || entry.equals(object2))) continue;
            return false;
        }
        return !iterator.hasNext() && !iterator2.hasNext();
    }

    public V f(K k2, V v2) {
        c<K, V> c2 = this.b(k2);
        if (c2 != null) {
            return c2.g;
        }
        this.e(k2, v2);
        return null;
    }

    public V g(K k2) {
        c c2;
        c<K, V> c3 = this.b(k2);
        if (c3 == null) {
            return null;
        }
        this.i = -1 + this.i;
        if (!this.h.isEmpty()) {
            Iterator iterator = this.h.keySet().iterator();
            while (iterator.hasNext()) {
                ((f)iterator.next()).a(c3);
            }
        }
        if ((c2 = c3.i) != null) {
            c2.h = c3.h;
        } else {
            this.f = c3.h;
        }
        c c4 = c3.h;
        if (c4 != null) {
            c4.i = c2;
        } else {
            this.g = c2;
        }
        c3.h = null;
        c3.i = null;
        return c3.g;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += ((Map.Entry)iterator.next()).hashCode();
        }
        return n2;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a a2 = new /* Unavailable Anonymous Inner Class!! */;
        this.h.put((Object)a2, (Object)Boolean.FALSE);
        return a2;
    }

    public int size() {
        return this.i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((Map.Entry)iterator.next()).toString());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class c<K, V>
    implements Map.Entry<K, V> {
        final K f;
        final V g;
        c<K, V> h;
        c<K, V> i;

        c(K k2, V v2) {
            this.f = k2;
            this.g = v2;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof c)) {
                return false;
            }
            c c2 = (c)object;
            return this.f.equals(c2.f) && this.g.equals(c2.g);
        }

        public K getKey() {
            return this.f;
        }

        public V getValue() {
            return this.g;
        }

        public int hashCode() {
            return this.f.hashCode() ^ this.g.hashCode();
        }

        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append("=");
            stringBuilder.append(this.g);
            return stringBuilder.toString();
        }
    }

    static interface f<K, V> {
        public void a(c<K, V> var1);
    }

}

