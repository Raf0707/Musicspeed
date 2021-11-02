/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.f
 *  f.u.q0.d
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package f.u.q0;

import f.z.d.d0.b;
import f.z.d.g;
import f.z.d.k;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * Exception performing whole class analysis.
 */
public final class c<K, V>
implements Map<K, V>,
f.z.d.d0.b {
    private static final a f;
    private int g;
    private int h;
    private f.u.q0.e<K> i;
    private f.u.q0.f<V> j;
    private f.u.q0.d<K, V> k;
    private boolean l;
    private K[] m;
    private V[] n;
    private int[] o;
    private int[] p;
    private int q;
    private int r;

    static {
        f = new Object(null){
            {
                this();
            }

            private final int c(int n2) {
                return Integer.highestOneBit((int)(3 * f.d0.g.b(n2, 1)));
            }

            private final int d(int n2) {
                return 1 + Integer.numberOfLeadingZeros((int)n2);
            }
        };
    }

    public c() {
        this(8);
    }

    public c(int n2) {
        this(f.u.q0.b.a(n2), null, new int[n2], new int[c.f.c(n2)], 2, 0);
    }

    private c(K[] arrK, V[] arrV, int[] arrn, int[] arrn2, int n2, int n3) {
        this.m = arrK;
        this.n = arrV;
        this.o = arrn;
        this.p = arrn2;
        this.q = n2;
        this.r = n3;
        this.g = c.f.d(this.w());
    }

    private final int A(K k2) {
        int n2 = k2 != null ? k2.hashCode() : 0;
        return n2 * -1640531527 >>> this.g;
    }

    private final boolean C(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean bl = collection.isEmpty();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        this.q(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.D((Map.Entry)iterator.next())) continue;
            bl2 = true;
        }
        return bl2;
    }

    private final boolean D(Map.Entry<? extends K, ? extends V> entry) {
        int n2 = this.h(entry.getKey());
        V[] arrV = this.i();
        if (n2 >= 0) {
            arrV[n2] = entry.getValue();
            return true;
        }
        int n3 = -n2 - 1;
        V v2 = arrV[n3];
        if (true ^ k.c(entry.getValue(), v2)) {
            arrV[n3] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean E(int n2) {
        int n3 = this.A(this.m[n2]);
        int n4 = this.q;
        do {
            int[] arrn;
            if ((arrn = this.p)[n3] == 0) {
                arrn[n3] = n2 + 1;
                this.o[n2] = n3;
                return true;
            }
            if (--n4 < 0) {
                return false;
            }
            int n5 = n3 - 1;
            if (n3 == 0) {
                n3 = this.w() - 1;
                continue;
            }
            n3 = n5;
        } while (true);
    }

    private final void F(int n2) {
        if (this.r > this.size()) {
            this.l();
        }
        int n3 = this.w();
        int n4 = 0;
        if (n2 != n3) {
            this.p = new int[n2];
            this.g = c.f.d(n2);
            n4 = 0;
        } else {
            f.u.f.f((int[])this.p, (int)0, (int)0, (int)this.w());
        }
        while (n4 < this.r) {
            int n5 = n4 + 1;
            if (this.E(n4)) {
                n4 = n5;
                continue;
            }
            throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void H(int n2) {
        int n3 = f.d0.g.d(2 * this.q, this.w() / 2);
        int n4 = 0;
        int n5 = n2;
        do {
            int n6 = n2 - 1;
            n2 = n2 == 0 ? -1 + this.w() : n6;
            if (++n4 > this.q) {
                this.p[n5] = 0;
                return;
            }
            int[] arrn = this.p;
            int n7 = arrn[n2];
            if (n7 == 0) {
                arrn[n5] = 0;
                return;
            }
            if (n7 < 0) {
                arrn[n5] = -1;
            } else {
                K[] arrK = this.m;
                int n8 = n7 - 1;
                if ((this.A(arrK[n8]) - n2 & -1 + this.w()) < n4) continue;
                this.p[n5] = n7;
                this.o[n8] = n5;
            }
            n5 = n2;
            n4 = 0;
        } while (--n3 >= 0);
        this.p[n5] = -1;
    }

    private final void J(int n2) {
        f.u.q0.b.c(this.m, n2);
        this.H(this.o[n2]);
        this.o[n2] = -1;
        this.h = -1 + this.size();
    }

    private final V[] i() {
        V[] arrV = this.n;
        if (arrV != null) {
            return arrV;
        }
        E[] arrE = f.u.q0.b.a(this.u());
        this.n = arrE;
        return arrE;
    }

    private final void l() {
        int n2;
        V[] arrV = this.n;
        int n3 = 0;
        for (int i2 = 0; i2 < (n2 = this.r); ++i2) {
            if (this.o[i2] < 0) continue;
            K[] arrK = this.m;
            arrK[n3] = arrK[i2];
            if (arrV != null) {
                arrV[n3] = arrV[i2];
            }
            ++n3;
        }
        f.u.q0.b.d(this.m, n3, n2);
        if (arrV != null) {
            f.u.q0.b.d(arrV, n3, this.r);
        }
        this.r = n3;
    }

    private final boolean o(Map<?, ?> map) {
        return this.size() == map.size() && this.m((Collection<?>)map.entrySet());
    }

    private final void p(int n2) {
        if (n2 > this.u()) {
            int n3 = 3 * this.u() / 2;
            if (n2 <= n3) {
                n2 = n3;
            }
            this.m = f.u.q0.b.b(this.m, n2);
            V[] arrV = this.n;
            V[] arrV2 = arrV != null ? f.u.q0.b.b(arrV, n2) : null;
            this.n = arrV2;
            int[] arrn = Arrays.copyOf((int[])this.o, (int)n2);
            k.f(arrn, "java.util.Arrays.copyOf(this, newSize)");
            this.o = arrn;
            int n4 = c.f.c(n2);
            if (n4 > this.w()) {
                this.F(n4);
                return;
            }
        } else if (n2 + this.r - this.size() > this.u()) {
            this.F(this.w());
        }
    }

    private final void q(int n2) {
        this.p(n2 + this.r);
    }

    private final int s(K k2) {
        int n2 = this.A(k2);
        int n3 = this.q;
        int n4;
        while ((n4 = this.p[n2]) != 0) {
            K[] arrK;
            int n5;
            if (n4 > 0 && k.c((arrK = this.m)[n5 = n4 - 1], k2)) {
                return n5;
            }
            if (--n3 < 0) {
                return -1;
            }
            int n6 = n2 - 1;
            if (n2 == 0) {
                n2 = -1 + this.w();
                continue;
            }
            n2 = n6;
        }
        return -1;
    }

    private final int t(V v2) {
        int n2 = this.r;
        while (--n2 >= 0) {
            if (this.o[n2] < 0) continue;
            V[] arrV = this.n;
            k.e(arrV);
            if (!k.c(arrV[n2], v2)) continue;
            return n2;
        }
        return -1;
    }

    private final int u() {
        return this.m.length;
    }

    private final int w() {
        return this.p.length;
    }

    public final e<K, V> B() {
        return }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    