/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 */
package h.a.f.b.b;

import h.a.f.a.c;
import h.a.f.b.b.d;

abstract class a
extends d
implements c {
    Class[] k;
    String[] l;
    Class[] m;

    a(int n2, String string, Class class_, Class[] arrclass, String[] arrstring, Class[] arrclass2) {
        super(n2, string, class_);
        this.k = arrclass;
        this.l = arrstring;
        this.m = arrclass2;
    }

    public Class[] l() {
        if (this.m == null) {
            this.m = this.e(5);
        }
        return this.m;
    }

    public Class[] m() {
        if (this.k == null) {
            this.k = this.e(3);
        }
        return this.k;
    }
}

