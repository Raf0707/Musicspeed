/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package h.a.f.b.b;

import h.a.f.b.b.a;
import h.a.f.b.b.h;

class e
extends a
implements h.a.f.a.d.a {
    Class n;

    e(int n2, String string, Class class_, Class[] arrclass, String[] arrstring, Class[] arrclass2, Class class_2) {
        super(n2, string, class_, arrclass, arrstring, arrclass2);
        this.n = class_2;
    }

    @Override
    protected String a(h h2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h2.e(this.i()));
        if (h2.e) {
            stringBuffer.append(h2.g(this.n()));
        }
        if (h2.e) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(h2.f(this.f(), this.g()));
        stringBuffer.append(".");
        stringBuffer.append(this.j());
        h2.a(stringBuffer, this.m());
        h2.b(stringBuffer, this.l());
        return stringBuffer.toString();
    }

    public Class n() {
        if (this.n == null) {
            this.n = this.d(6);
        }
        return this.n;
    }
}

