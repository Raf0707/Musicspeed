/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package h.a.f.b.b;

import h.a.f.a.a;
import h.a.f.a.d.b;
import h.a.f.b.b.f;
import h.a.f.b.b.h;

class c
implements h.a.f.a.a {
    Object a;
    Object b;
    Object[] c;
    a.a d;

    public c(a.a a2, Object object, Object object2, Object[] arrobject) {
        this.d = a2;
        this.a = object;
        this.b = object2;
        this.c = arrobject;
    }

    @Override
    public Object a() {
        return this.b;
    }

    public final String toString() {
        return this.d.toString();
    }

    static class a
    implements a.a {
        String a;
        h.a.f.a.c b;
        b c;
        private int d;

        public a(int n2, String string2, h.a.f.a.c c2, b b2) {
            this.a = string2;
            this.b = c2;
            this.c = b2;
            this.d = n2;
        }

        public String a() {
            return this.a;
        }

        public h.a.f.a.c b() {
            return this.b;
        }

        String c(h h2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(h2.d(this.a()));
            stringBuffer.append("(");
            stringBuffer.append(((f)this.b()).k(h2));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        @Override
        public final String toString() {
            return this.c(h.b);
        }
    }

}

