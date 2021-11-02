/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  f.u.f
 *  f.u.l
 *  java.lang.ArithmeticException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 */
package f.u;

import f.u.e;
import f.u.f;
import f.u.l;
import f.u.m;
import f.u.x;
import f.z.d.k;
import java.util.Collection;
import java.util.List;

class n
extends m {
    public static final <T> Collection<T> c(T[] arrT) {
        k.g(arrT, "$this$asCollection");
        return new e<T>(arrT, false);
    }

    public static <T> List<T> d() {
        return x.f;
    }

    public static f.d0.f e(Collection<?> collection) {
        k.g(collection, "$this$indices");
        return new f.d0.f(0, -1 + collection.size());
    }

    public static <T> int f(List<? extends T> list) {
        k.g(list, "$this$lastIndex");
        return -1 + list.size();
    }

    public static /* varargs */ <T> List<T> g(T ... arrT) {
        k.g(arrT, "elements");
        if (arrT.length > 0) {
            return f.a((Object[])arrT);
        }
        return l.d();
    }

    public static <T> List<T> h(List<? extends T> list) {
        k.g(list, "$this$optimizeReadOnlyList");
        int n2 = list.size();
        if (n2 != 0) {
            if (n2 != 1) {
                return list;
            }
            return l.b((Object)list.get(0));
        }
        return l.d();
    }

    public static void i() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}

