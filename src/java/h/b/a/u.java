/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 */
package h.b.a;

public class u {
    byte[] a;
    int b;

    u(byte[] arrby, int n2) {
        this.a = arrby;
        this.b = n2;
    }

    public int a() {
        return this.a[this.b];
    }

    public int b(int n2) {
        return this.a[1 + (this.b + n2 * 2)];
    }

    public int c(int n2) {
        return this.a[2 + (this.b + n2 * 2)];
    }

    public String toString() {
        int n2 = this.a();
        StringBuffer stringBuffer = new StringBuffer(n2 * 2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            int n4 = this.b(i2);
            if (n4 != 0) {
                if (n4 != 1) {
                    if (n4 != 2) {
                        if (n4 != 3) {
                            n3 = 95;
                        } else {
                            stringBuffer.append(this.c(i2));
                            n3 = 59;
                        }
                    } else {
                        n3 = 42;
                    }
                } else {
                    n3 = 46;
                }
            } else {
                n3 = 91;
            }
            stringBuffer.append((char)n3);
        }
        return stringBuffer.toString();
    }
}

