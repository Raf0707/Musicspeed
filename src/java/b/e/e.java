/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 */
package b.e;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class e<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public e(int n2) {
        if (n2 > 0) {
            this.c = n2;
            this.a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int c(K k2, V v2) {
        int n2 = this.sizeOf(k2, v2);
        if (n2 >= 0) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k2);
        stringBuilder.append("=");
        stringBuilder.append(v2);
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected V a(K k2) {
        return null;
    }

    protected void b(boolean bl, K k2, V v2, V v3) {
    }

    public final int createCount() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.e;
            return n2;
        }
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    public final int evictionCount() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.f;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V get(K k2) {
        Objects.requireNonNull(k2, (String)"key == null");
        e e2 = this;
        // MONITORENTER : e2
        Object object = this.a.get(k2);
        if (object != null) {
            this.g = 1 + this.g;
            // MONITOREXIT : e2
            return (V)object;
        }
        this.h = 1 + this.h;
        // MONITOREXIT : e2
        V v2 = this.a(k2);
        if (v2 == null) {
            return null;
        }
        e2 = this;
        // MONITORENTER : e2
        this.e = 1 + this.e;
        Object object2 = this.a.put(k2, v2);
        if (object2 != null) {
            this.a.put(k2, object2);
        } else {
            this.b += this.c(k2, v2);
        }
        // MONITOREXIT : e2
        if (object2 != null) {
            this.b(false, k2, v2, object2);
            return (V)object2;
        }
        this.trimToSize(this.c);
        return v2;
    }

    public final int hitCount() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.g;
            return n2;
        }
    }

    public final int maxSize() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.c;
            return n2;
        }
    }

    public final int missCount() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.h;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V put(K k2, V v2) {
        if (k2 == null) throw new NullPointerException("key == null || value == null");
        if (v2 == null) throw new NullPointerException("key == null || value == null");
        e e2 = this;
        // MONITORENTER : e2
        this.d = 1 + this.d;
        this.b += this.c(k2, v2);
        Object object = this.a.put(k2, v2);
        if (object != null) {
            this.b -= this.c(k2, object);
        }
        // MONITOREXIT : e2
        if (object != null) {
            this.b(false, k2, object, v2);
        }
        this.trimToSize(this.c);
        return (V)object;
    }

    public final int putCount() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.d;
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final V remove(K k2) {
        Objects.requireNonNull(k2, (String)"key == null");
        e e2 = this;
        // MONITORENTER : e2
        Object object = this.a.remove(k2);
        if (object != null) {
            this.b -= this.c(k2, object);
        }
        // MONITOREXIT : e2
        if (object == null) return (V)object;
        this.b(false, k2, object, null);
        return (V)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resize(int n2) {
        if (n2 > 0) {
            e e2 = this;
            synchronized (e2) {
                this.c = n2;
            }
            this.trimToSize(n2);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int size() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.b;
            return n2;
        }
    }

    protected int sizeOf(K k2, V v2) {
        return 1;
    }

    public final Map<K, V> snapshot() {
        e e2 = this;
        synchronized (e2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.a);
            return linkedHashMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String toString() {
        e e2 = this;
        synchronized (e2) {
            int n2 = this.g;
            int n3 = n2 + this.h;
            int n4 = n3 != 0 ? n2 * 100 / n3 : 0;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.c, this.g, this.h, n4};
            return String.format((Locale)locale, (String)"LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", (Object[])arrobject);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void trimToSize(int n2) {
        do {
            Object object;
            Object object2;
            e e2 = this;
            synchronized (e2) {
                if (this.b < 0 || this.a.isEmpty() && this.b != 0) break block4;
                if (this.b <= n2 || this.a.isEmpty()) break;
                Map.Entry entry = (Map.Entry)this.a.entrySet().iterator().next();
                object2 = entry.getKey();
                object = entry.getValue();
                this.a.remove(object2);
                this.b -= this.c(object2, object);
                this.f = 1 + this.f;
            }
            this.b(true, object2, object, null);
        } while (true);
        {
            block4 : {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(".sizeOf() is reporting inconsistent results!");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}

