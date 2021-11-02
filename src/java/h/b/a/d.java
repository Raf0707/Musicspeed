/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package h.b.a;

public class d {
    byte[] a;
    int b;

    public d() {
        this.a = new byte[64];
    }

    public d(int n2) {
        this.a = new byte[n2];
    }

    private void b(int n2) {
        byte[] arrby = this.a;
        int n3 = 2 * arrby.length;
        int n4 = this.b;
        int n5 = n2 + n4;
        if (n3 <= n5) {
            n3 = n5;
        }
        byte[] arrby2 = new byte[n3];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)n4);
        this.a = arrby2;
    }

    d a(int n2, int n3) {
        int n4 = this.b;
        if (n4 + 2 > this.a.length) {
            this.b(2);
        }
        byte[] arrby = this.a;
        int n5 = n4 + 1;
        arrby[n4] = (byte)n2;
        int n6 = n5 + 1;
        arrby[n5] = (byte)n3;
        this.b = n6;
        return this;
    }

    d c(int n2, int n3) {
        int n4 = this.b;
        if (n4 + 3 > this.a.length) {
            this.b(3);
        }
        byte[] arrby = this.a;
        int n5 = n4 + 1;
        arrby[n4] = (byte)n2;
        int n6 = n5 + 1;
        arrby[n5] = (byte)(n3 >>> 8);
        int n7 = n6 + 1;
        arrby[n6] = (byte)n3;
        this.b = n7;
        return this;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    d d(String var1_1, int var2_2, int var3_3) {
        var4_4 = var1_1.length();
        var6_6 = var5_5 = var2_2;
        while (var5_5 < var4_4) {
            var17_7 = var1_1.charAt(var5_5);
            var6_6 = var17_7 >= '\u0001' && var17_7 <= '' ? ++var6_6 : (var17_7 > '\u07ff' ? (var6_6 += 3) : (var6_6 += 2));
            ++var5_5;
        }
        if (var6_6 > var3_3) throw new IllegalArgumentException();
        var7_8 = this.b;
        var8_9 = -2 + (var7_8 - var2_2);
        if (var8_9 >= 0) {
            var16_10 = this.a;
            var16_10[var8_9] = (byte)(var6_6 >>> 8);
            var16_10[var8_9 + 1] = (byte)var6_6;
        }
        if (var7_8 + var6_6 - var2_2 > this.a.length) {
            this.b(var6_6 - var2_2);
        }
        var9_11 = this.b;
        do {
            block7 : {
                if (var2_2 >= var4_4) {
                    this.b = var9_11;
                    return this;
                }
                var10_12 = var1_1.charAt(var2_2);
                if (var10_12 < '\u0001' || var10_12 > '') break block7;
                var15_17 = this.a;
                var14_16 = var9_11 + 1;
                var15_17[var9_11] = (byte)var10_12;
                ** GOTO lbl37
            }
            var11_13 = this.a;
            var12_14 = var9_11 + 1;
            if (var10_12 > '\u07ff') {
                var11_13[var9_11] = (byte)(224 | 15 & var10_12 >> 12);
                var13_15 = var12_14 + 1;
                var11_13[var12_14] = (byte)(128 | 63 & var10_12 >> 6);
                var14_16 = var13_15 + 1;
                var11_13[var13_15] = (byte)(128 | var10_12 & 63);
lbl37: // 2 sources:
                var9_11 = var14_16;
            } else {
                var11_13[var9_11] = (byte)(192 | 31 & var10_12 >> 6);
                var9_11 = var12_14 + 1;
                var11_13[var12_14] = (byte)(128 | var10_12 & 63);
            }
            ++var2_2;
        } while (true);
    }

    public d e(int n2) {
        int n3 = this.b;
        int n4 = n3 + 1;
        if (n4 > this.a.length) {
            this.b(1);
        }
        this.a[n3] = (byte)n2;
        this.b = n4;
        return this;
    }

    public d f(byte[] arrby, int n2, int n3) {
        if (n3 + this.b > this.a.length) {
            this.b(n3);
        }
        if (arrby != null) {
            System.arraycopy((Object)arrby, (int)n2, (Object)this.a, (int)this.b, (int)n3);
        }
        this.b = n3 + this.b;
        return this;
    }

    public d g(int n2) {
        int n3 = this.b;
        if (n3 + 4 > this.a.length) {
            this.b(4);
        }
        byte[] arrby = this.a;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(n2 >>> 24);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(n2 >>> 16);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(n2 >>> 8);
        int n7 = n6 + 1;
        arrby[n6] = (byte)n2;
        this.b = n7;
        return this;
    }

    public d h(long l2) {
        int n2 = this.b;
        if (n2 + 8 > this.a.length) {
            this.b(8);
        }
        byte[] arrby = this.a;
        int n3 = (int)(l2 >>> 32);
        int n4 = n2 + 1;
        arrby[n2] = (byte)(n3 >>> 24);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(n3 >>> 16);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(n3 >>> 8);
        int n7 = n6 + 1;
        arrby[n6] = (byte)n3;
        int n8 = (int)l2;
        int n9 = n7 + 1;
        arrby[n7] = (byte)(n8 >>> 24);
        int n10 = n9 + 1;
        arrby[n9] = (byte)(n8 >>> 16);
        int n11 = n10 + 1;
        arrby[n10] = (byte)(n8 >>> 8);
        int n12 = n11 + 1;
        arrby[n11] = (byte)n8;
        this.b = n12;
        return this;
    }

    public d i(int n2) {
        int n3 = this.b;
        if (n3 + 2 > this.a.length) {
            this.b(2);
        }
        byte[] arrby = this.a;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(n2 >>> 8);
        int n5 = n4 + 1;
        arrby[n4] = (byte)n2;
        this.b = n5;
        return this;
    }

    public d j(String string2) {
        int n2 = string2.length();
        if (n2 <= 65535) {
            int n3 = this.b;
            if (n2 + (n3 + 2) > this.a.length) {
                this.b(n2 + 2);
            }
            byte[] arrby = this.a;
            int n4 = n3 + 1;
            arrby[n3] = (byte)(n2 >>> 8);
            int n5 = n4 + 1;
            arrby[n4] = (byte)n2;
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string2.charAt(i2);
                if (c2 >= '\u0001' && c2 <= '') {
                    int n6 = n5 + 1;
                    arrby[n5] = (byte)c2;
                    n5 = n6;
                    continue;
                }
                this.b = n5;
                return this.d(string2, i2, 65535);
            }
            this.b = n5;
            return this;
        }
        throw new IllegalArgumentException();
    }
}

