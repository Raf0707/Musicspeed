/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package h.b.a;

public final class m {
    final int a;
    final String b;
    final String c;
    final String d;

    public m(int n2, String string2, String string3, String string4) {
        this.a = n2;
        this.b = string2;
        this.c = string3;
        this.d = string4;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof m)) {
            return false;
        }
        m m2 = (m)object;
        return this.a == m2.a && this.b.equals((Object)m2.b) && this.c.equals((Object)m2.c) && this.d.equals((Object)m2.d);
    }

    public int hashCode() {
        return this.a + this.b.hashCode() * this.c.hashCode() * this.d.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append('.');
        stringBuffer.append(this.c);
        stringBuffer.append(this.d);
        stringBuffer.append(" (");
        stringBuffer.append(this.a);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

