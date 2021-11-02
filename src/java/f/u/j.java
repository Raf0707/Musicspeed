/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.l
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package f.u;

import f.u.f;
import f.u.g0;
import f.u.i;
import f.u.l;
import f.u.n;
import f.u.n0;
import f.u.o0;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

class j
extends i {
    public static final <T> boolean j(T[] arrT, T t2) {
        k.g(arrT, "$this$contains");
        return j.l(arrT, t2) >= 0;
    }

    public static int k(byte[] arrby) {
        k.g(arrby, "$this$lastIndex");
        return -1 + arrby.length;
    }

    public static final <T> int l(T[] arrT, T t2) {
        int n2;
        k.g(arrT, "$this$indexOf");
        if (t2 == null) {
            int n3 = arrT.length;
            for (n2 = 0; n2 < n3; ++n2) {
                if (arrT[n2] != null) continue;
                return n2;
            }
        } else {
            int n4 = arrT.length;
            while (n2 < n4) {
                if (k.c(t2, arrT[n2])) {
                    return n2;
                }
                ++n2;
            }
        }
        return -1;
    }

    public static char m(char[] arrc) {
        k.g(arrc, "$this$single");
        int n2 = arrc.length;
        if (n2 != 0) {
            if (n2 == 1) {
                return arrc[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T n(T[] arrT) {
        k.g(arrT, "$this$singleOrNull");
        if (arrT.length == 1) {
            return arrT[0];
        }
        return null;
    }

    public static final <T> T[] o(T[] arrT, Comparator<? super T> comparator) {
        k.g(arrT, "$this$sortedArrayWith");
        k.g(comparator, "comparator");
        boolean bl = arrT.length == 0;
        if (bl) {
            return arrT;
        }
        Object[] arrobject = Arrays.copyOf((Object[])arrT, (int)arrT.length);
        k.f(arrobject, "java.util.Arrays.copyOf(this, size)");
        i.i(arrobject, comparator);
        return arrobject;
    }

    public static <T> List<T> p(T[] arrT, Comparator<? super T> comparator) {
        k.g(arrT, "$this$sortedWith");
        k.g(comparator, "comparator");
        return f.a(j.o(arrT, comparator));
    }

    public static final <T, C extends Collection<? super T>> C q(T[] arrT, C c2) {
        k.g(arrT, "$this$toCollection");
        k.g(c2, "destination");
        int n2 = arrT.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            c2.add(arrT[i2]);
        }
        return c2;
    }

    public static <T> List<T> r(T[] arrT) {
        k.g(arrT, "$this$toList");
        int n2 = arrT.length;
        if (n2 != 0) {
            if (n2 != 1) {
                return j.s(arrT);
            }
            return l.b(arrT[0]);
        }
        return l.d();
    }

    public static final <T> List<T> s(T[] arrT) {
        k.g(arrT, "$this$toMutableList");
        return new ArrayList(n.c(arrT));
    }

    public static final <T> Set<T> t(T[] arrT) {
        k.g(arrT, "$this$toSet");
        int n2 = arrT.length;
        if (n2 != 0) {
            if (n2 != 1) {
                return (Set)j.q(arrT, new LinkedHashSet(g0.d(arrT.length)));
            }
            return n0.a(arrT[0]);
        }
        return o0.b();
    }
}

