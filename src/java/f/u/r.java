/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package f.u;

import f.u.q;
import f.z.d.k;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class r
extends q {
    public static <T extends Comparable<? super T>> void k(List<T> list) {
        k.g(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void l(List<T> list, Comparator<? super T> comparator) {
        k.g(list, "$this$sortWith");
        k.g(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}

