/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 */
package h.b.a;

import h.b.a.a;
import h.b.a.d;
import h.b.a.g;
import h.b.a.o;
import h.b.a.t;
import h.b.a.u;

final class b
extends a {
    private final g c;
    private int d;
    private final boolean e;
    private final d f;
    private final d g;
    private final int h;
    b i;
    b j;

    b(g g2, boolean bl, d d2, d d3, int n2) {
        super(327680);
        this.c = g2;
        this.e = bl;
        this.f = d2;
        this.g = d3;
        this.h = n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void g(int var0, u var1_1, d var2_2) {
        var3_3 = var0 >>> 24;
        if (var3_3 != 0 && var3_3 != 1) {
            switch (var3_3) {
                default: {
                    switch (var3_3) {
                        default: {
                            var2_2.c(var3_3, (var0 & 16776960) >> 8);
                            ** break;
                        }
                        case 71: 
                        case 72: 
                        case 73: 
                        case 74: 
                        case 75: 
                    }
                    var2_2.g(var0);
                    ** break;
                }
                case 19: 
                case 20: 
                case 21: {
                    var2_2.e(var3_3);
                    ** break;
                }
                case 22: 
            }
        }
        var2_2.i(var0 >>> 16);
lbl17: // 4 sources:
        if (var1_1 == null) {
            var2_2.e(0);
            return;
        }
        var5_4 = var1_1.a;
        var6_5 = var1_1.b;
        var2_2.f(var5_4, var6_5, 1 + 2 * var5_4[var6_5]);
    }

    static void i(b[] arrb, int n2, d d2) {
        int n3 = 1 + 2 * (arrb.length - n2);
        for (int i2 = n2; i2 < arrb.length; ++i2) {
            int n4 = arrb[i2] == null ? 0 : arrb[i2].f();
            n3 += n4;
        }
        d2.g(n3).e(arrb.length - n2);
        while (n2 < arrb.length) {
            b b2 = arrb[n2];
            b b3 = null;
            int n5 = 0;
            while (b2 != null) {
                ++n5;
                b2.d();
                b2.j = b3;
                b b4 = b2.i;
                b3 = b2;
                b2 = b4;
            }
            d2.i(n5);
            while (b3 != null) {
                d d3 = b3.f;
                d2.f(d3.a, 0, d3.b);
                b3 = b3.j;
            }
            ++n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(String string, Object object) {
        int n2;
        int n3;
        block35 : {
            int n4;
            d d2;
            block34 : {
                g g2;
                String string2;
                block32 : {
                    block33 : {
                        block31 : {
                            this.d = 1 + this.d;
                            if (this.e) {
                                this.f.i(this.c.N(string));
                            }
                            if (!(object instanceof String)) break block31;
                            d2 = this.f;
                            n2 = 115;
                            g2 = this.c;
                            string2 = (String)object;
                            break block32;
                        }
                        boolean bl = object instanceof Byte;
                        n2 = 66;
                        if (!bl) break block33;
                        d2 = this.f;
                        n4 = this.c.p((int)((Byte)object).byteValue()).a;
                        break block34;
                    }
                    if (object instanceof Boolean) {
                        int n5 = ((Boolean)object).booleanValue();
                        this.f.c(90, this.c.p((int)n5).a);
                        return;
                    }
                    if (object instanceof Character) {
                        this.f.c(67, this.c.p((int)((Character)object).charValue()).a);
                        return;
                    }
                    if (object instanceof Short) {
                        this.f.c(83, this.c.p((int)((Short)object).shortValue()).a);
                        return;
                    }
                    if (!(object instanceof t)) break block35;
                    d2 = this.f;
                    n2 = 99;
                    g2 = this.c;
                    string2 = ((t)object).h();
                }
                n4 = g2.N(string2);
            }
            d2.c(n2, n4);
            return;
        }
        boolean bl = object instanceof byte[];
        if (bl) {
            byte[] arrby = (byte[])object;
            this.f.c(91, arrby.length);
            for (n3 = 0; n3 < arrby.length; ++n3) {
                this.f.c(n2, this.c.p((int)arrby[n3]).a);
            }
            return;
        } else if (object instanceof boolean[]) {
            boolean[] arrbl = (boolean[])object;
            this.f.c(91, arrbl.length);
            while (n3 < arrbl.length) {
                this.f.c(90, this.c.p((int)arrbl[n3]).a);
                ++n3;
            }
            return;
        } else if (object instanceof short[]) {
            short[] arrs = (short[])object;
            this.f.c(91, arrs.length);
            while (n3 < arrs.length) {
                this.f.c(83, this.c.p((int)arrs[n3]).a);
                ++n3;
            }
            return;
        } else if (object instanceof char[]) {
            char[] arrc = (char[])object;
            this.f.c(91, arrc.length);
            while (n3 < arrc.length) {
                this.f.c(67, this.c.p((int)arrc[n3]).a);
                ++n3;
            }
            return;
        } else if (object instanceof int[]) {
            int[] arrn = (int[])object;
            this.f.c(91, arrn.length);
            while (n3 < arrn.length) {
                this.f.c(73, this.c.p((int)arrn[n3]).a);
                ++n3;
            }
            return;
        } else if (object instanceof long[]) {
            long[] arrl = (long[])object;
            this.f.c(91, arrl.length);
            while (n3 < arrl.length) {
                this.f.c(74, this.c.r((long)arrl[n3]).a);
                ++n3;
            }
            return;
        } else if (object instanceof float[]) {
            float[] arrf = (float[])object;
            this.f.c(91, arrf.length);
            while (n3 < arrf.length) {
                this.f.c(70, this.c.o((float)arrf[n3]).a);
                ++n3;
            }
            return;
        } else if (object instanceof double[]) {
            double[] arrd = (double[])object;
            this.f.c(91, arrd.length);
            while (n3 < arrd.length) {
                this.f.c(68, this.c.n((double)arrd[n3]).a);
                ++n3;
            }
            return;
        } else {
            o o2 = this.c.s(object);
            this.f.c(".s.IFJDCS".charAt(o2.b), o2.a);
        }
    }

    @Override
    public a b(String string, String string2) {
        this.d = 1 + this.d;
        if (this.e) {
            this.f.i(this.c.N(string));
        }
        this.f.c(64, this.c.N(string2)).i(0);
        g g2 = this.c;
        d d2 = this.f;
        b b2 = new b(g2, true, d2, d2, -2 + d2.b);
        return b2;
    }

    @Override
    public a c(String string) {
        this.d = 1 + this.d;
        if (this.e) {
            this.f.i(this.c.N(string));
        }
        this.f.c(91, 0);
        g g2 = this.c;
        d d2 = this.f;
        b b2 = new b(g2, false, d2, d2, -2 + d2.b);
        return b2;
    }

    @Override
    public void d() {
        d d2 = this.g;
        if (d2 != null) {
            byte[] arrby = d2.a;
            int n2 = this.h;
            int n3 = this.d;
            arrby[n2] = (byte)(n3 >>> 8);
            arrby[n2 + 1] = (byte)n3;
        }
    }

    @Override
    public void e(String string, String string2, String string3) {
        this.d = 1 + this.d;
        if (this.e) {
            this.f.i(this.c.N(string));
        }
        this.f.c(101, this.c.N(string2)).i(this.c.N(string3));
    }

    int f() {
        int n2 = 0;
        b b2 = this;
        while (b2 != null) {
            n2 += b2.f.b;
            b2 = b2.i;
        }
        return n2;
    }

    void h(d d2) {
        int n2 = 2;
        int n3 = 0;
        b b2 = null;
        b b3 = this;
        while (b3 != null) {
            ++n3;
            n2 += b3.f.b;
            b3.d();
            b3.j = b2;
            b b4 = b3.i;
            b2 = b3;
            b3 = b4;
        }
        d2.g(n2);
        d2.i(n3);
        while (b2 != null) {
            d d3 = b2.f;
            d2.f(d3.a, 0, d3.b);
            b2 = b2.j;
        }
    }
}

