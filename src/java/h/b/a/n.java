/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package h.b.a;

import h.b.a.p;

class n {
    p a;
    p b;
    p c;
    String d;
    int e;
    n f;

    n() {
    }

    static n a(n n2, p p2, p p3) {
        n n3;
        if (n2 == null) {
            return null;
        }
        n2.f = n3 = n.a(n2.f, p2, p3);
        int n4 = n2.a.c;
        int n5 = n2.b.c;
        int n6 = p2.c;
        int n7 = p3 == null ? Integer.MAX_VALUE : p3.c;
        if (n6 < n5 && n7 > n4) {
            if (n6 <= n4) {
                if (n7 >= n5) {
                    return n3;
                }
                n2.a = p3;
                return n2;
            }
            if (n7 >= n5) {
                n2.b = p2;
                return n2;
            }
            n n8 = new n();
            n8.a = p3;
            n8.b = n2.b;
            n8.c = n2.c;
            n8.d = n2.d;
            n8.e = n2.e;
            n8.f = n2.f;
            n2.b = p2;
            n2.f = n8;
        }
        return n2;
    }
}

