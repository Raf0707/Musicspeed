/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.u.f
 *  java.lang.Object
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.List
 */
package f.u;

import f.u.f;
import f.u.h;
import f.u.k;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class i
extends h {
    public static <T> List<T> a(T[] arrT) {
        f.z.d.k.g(arrT, "$this$asList");
        List<T> list = k.a(arrT);
        f.z.d.k.f(list, "ArraysUtilJVM.asList(this)");
        return list;
    }

    public static byte[] b(byte[] arrby, byte[] arrby2, int n2, int n3, int n4) {
        f.z.d.k.g(arrby, "$this$copyInto");
        f.z.d.k.g(arrby2, "destination");
        System.arraycopy((Object)arrby, (int)n3, (Object)arrby2, (int)n2, (int)(n4 - n3));
        return arrby2;
    }

    public static final <T> T[] c(T[] arrT, T[] arrT2, int n2, int n3, int n4) {
        f.z.d.k.g(arrT, "$this$copyInto");
        f.z.d.k.g(arrT2, "destination");
        System.arraycopy(arrT, (int)n3, arrT2, (int)n2, (int)(n4 - n3));
        return arrT2;
    }

    public static /* synthetic */ Object[] d(Object[] arrobject, Object[] arrobject2, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 2) != 0) {
            n2 = 0;
        }
        if ((n5 & 4) != 0) {
            n3 = 0;
        }
        if ((n5 & 8) != 0) {
            n4 = arrobject.length;
        }
        return i.c(arrobject, arrobject2, n2, n3, n4);
    }

    public static void e(byte[] arrby, byte by, int n2, int n3) {
        f.z.d.k.g(arrby, "$this$fill");
        Arrays.fill((byte[])arrby, (int)n2, (int)n3, (byte)by);
    }

    public static void f(int[] arrn, int n2, int n3, int n4) {
        f.z.d.k.g(arrn, "$this$fill");
        Arrays.fill((int[])arrn, (int)n3, (int)n4, (int)n2);
    }

    public static <T> void g(T[] arrT, T t2, int n2, int n3) {
        f.z.d.k.g(arrT, "$this$fill");
        Arrays.fill((Object[])arrT, (int)n2, (int)n3, t2);
    }

    public static /* synthetic */ void h(Object[] arrobject, Object object, int n2, int n3, int n4, Object object2) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) != 0) {
            n3 = arrobject.length;
        }
        f.g((Object[])arrobject, (Object)object, (int)n2, (int)n3);
    }

    public static final <T> void i(T[] arrT, Comparator<? super T> comparator) {
        f.z.d.k.g(arrT, "$this$sortWith");
        f.z.d.k.g(comparator, "comparator");
        if (arrT.length > 1) {
            Arrays.sort((Object[])arrT, comparator);
        }
    }
}

