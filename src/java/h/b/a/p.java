/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.b.a.r
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.System
 */
package h.b.a;

import h.b.a.d;
import h.b.a.i;
import h.b.a.l;
import h.b.a.r;

public class p {
    int a;
    int b;
    int c;
    private int d;
    private int[] e;
    int f;
    int g;
    l h;
    p i;
    i j;
    p k;

    private void b(int n2, int n3) {
        int n4;
        int[] arrn;
        int n5;
        if (this.e == null) {
            this.e = new int[6];
        }
        if ((n4 = this.d) >= (arrn = this.e).length) {
            int[] arrn2 = new int[6 + arrn.length];
            System.arraycopy((Object)arrn, (int)0, (Object)arrn2, (int)0, (int)arrn.length);
            this.e = arrn2;
        }
        int[] arrn3 = this.e;
        int n6 = this.d;
        this.d = n5 = n6 + 1;
        arrn3[n6] = n2;
        this.d = n5 + 1;
        arrn3[n5] = n3;
    }

    p a() {
        l l2 = this.h;
        if (l2 == null) {
            return this;
        }
        return l2.b;
    }

    void c(long l2, int n2) {
        int n3 = this.a;
        if ((n3 & 1024) == 0) {
            this.a = n3 | 1024;
            this.e = new int[1 + n2 / 32];
        }
        int[] arrn = this.e;
        int n4 = (int)(l2 >>> 32);
        arrn[n4] = arrn[n4] | (int)l2;
    }

    void d(r r2, d d2, int n2, boolean bl) {
        int n3;
        block5 : {
            block4 : {
                block2 : {
                    block3 : {
                        if ((2 & this.a) != 0) break block2;
                        n3 = -1;
                        if (!bl) break block3;
                        this.b(-1 - n2, d2.b);
                        break block4;
                    }
                    this.b(n2, d2.b);
                    break block5;
                }
                n3 = this.c - n2;
                if (!bl) break block5;
            }
            d2.g(n3);
            return;
        }
        d2.i(n3);
    }

    boolean e(long l2) {
        int n2 = 1024 & this.a;
        boolean bl = false;
        if (n2 != 0) {
            int n3 = this.e[(int)(l2 >>> 32)] & (int)l2;
            bl = false;
            if (n3 != 0) {
                bl = true;
            }
        }
        return bl;
    }

    boolean f(p p2) {
        if ((1024 & this.a) != 0) {
            int[] arrn;
            if ((1024 & p2.a) == 0) {
                return false;
            }
            for (int i2 = 0; i2 < (arrn = this.e).length; ++i2) {
                if ((arrn[i2] & p2.e[i2]) == 0) continue;
                return true;
            }
        }
        return false;
    }

    boolean g(r r2, int n2, byte[] arrby) {
        this.a = 2 | this.a;
        this.c = n2;
        int n3 = 0;
        boolean bl = false;
        while (n3 < this.d) {
            int[] arrn = this.e;
            int n4 = n3 + 1;
            int n5 = arrn[n3];
            int n6 = n4 + 1;
            int n7 = arrn[n4];
            if (n5 >= 0) {
                int n8 = n2 - n5;
                if (n8 < -32768 || n8 > 32767) {
                    int n9 = n7 - 1;
                    int n10 = 255 & arrby[n9];
                    arrby[n9] = n10 <= 168 ? (byte)(n10 + 49) : (byte)(n10 + 20);
                    bl = true;
                }
                int n11 = n7 + 1;
                arrby[n7] = (byte)(n8 >>> 8);
                arrby[n11] = (byte)n8;
            } else {
                int n12 = 1 + (n5 + n2);
                int n13 = n7 + 1;
                arrby[n7] = (byte)(n12 >>> 24);
                int n14 = n13 + 1;
                arrby[n13] = (byte)(n12 >>> 16);
                int n15 = n14 + 1;
                arrby[n14] = (byte)(n12 >>> 8);
                arrby[n15] = (byte)n12;
            }
            n3 = n6;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    void h(p p2, long l2, int n2) {
        p p3 = this;
        do {
            p p4;
            block11 : {
                block12 : {
                    block10 : {
                        int n3;
                        if (p3 == null) {
                            return;
                        }
                        p4 = p3.k;
                        p3.k = null;
                        if (p2 == null) break block10;
                        int n4 = p3.a;
                        if ((n4 & 2048) != 0) break block11;
                        p3.a = n3 = n4 | 2048;
                        if ((n3 & 256) != 0 && !p3.f(p2)) {
                            i i2 = new i();
                            i2.a = p3.f;
                            i2.b = p2.j.b;
                            i2.c = p3.j;
                            p3.j = i2;
                        }
                        break block12;
                    }
                    if (p3.e(l2)) break block11;
                    p3.c(l2, n2);
                }
                i i3 = p3.j;
                while (i3 != null) {
                    if ((128 & p3.a) == 0 || i3 != p3.j.c) {
                        p p5 = i3.b;
                        if (p5.k == null) {
                            p5.k = p4;
                            p4 = p5;
                        }
                    }
                    i3 = i3.c;
                }
            }
            p3 = p4;
        } while (true);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("L");
        stringBuffer.append(System.identityHashCode((Object)this));
        return stringBuffer.toString();
    }
}

