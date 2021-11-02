/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package h.a.f.b.b;

import h.a.f.a.d.b;

class g
implements b {
    Class a;
    String b;
    int c;

    g(Class class_, String string2, int n2) {
        this.a = class_;
        this.b = string2;
        this.c = n2;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a());
        stringBuffer.append(":");
        stringBuffer.append(this.b());
        return stringBuffer.toString();
    }
}

