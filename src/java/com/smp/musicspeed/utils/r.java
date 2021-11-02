/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.utils;

public final class r {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;

    public r(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16) {
        this.a = bl;
        this.b = bl2;
        this.c = bl3;
        this.d = bl4;
        this.e = bl5;
        this.f = bl6;
        this.g = bl7;
        this.h = bl8;
        this.i = bl9;
        this.j = bl10;
        this.k = bl11;
        this.l = bl12;
        this.m = bl13;
        this.n = bl14;
        this.o = bl15;
        this.p = bl16;
    }

    public final boolean a() {
        return this.f;
    }

    public final boolean b() {
        return this.g;
    }

    public final boolean c() {
        return this.j;
    }

    public final boolean d() {
        return this.l;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof r)) {
            return false;
        }
        r r2 = (r)object;
        if (this.a != r2.a) {
            return false;
        }
        if (this.b != r2.b) {
            return false;
        }
        if (this.c != r2.c) {
            return false;
        }
        if (this.d != r2.d) {
            return false;
        }
        if (this.e != r2.e) {
            return false;
        }
        if (this.f != r2.f) {
            return false;
        }
        if (this.g != r2.g) {
            return false;
        }
        if (this.h != r2.h) {
            return false;
        }
        if (this.i != r2.i) {
            return false;
        }
        if (this.j != r2.j) {
            return false;
        }
        if (this.k != r2.k) {
            return false;
        }
        if (this.l != r2.l) {
            return false;
        }
        if (this.m != r2.m) {
            return false;
        }
        if (this.n != r2.n) {
            return false;
        }
        if (this.o != r2.o) {
            return false;
        }
        return this.p == r2.p;
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.n;
    }

    public int hashCode() {
        int n2 = this.a;
        int n3 = 1;
        if (n2 != 0) {
            n2 = 1;
        }
        int n4 = n2 * 31;
        int n5 = this.b ? 1 : 0;
        if (n5 != 0) {
            n5 = 1;
        }
        int n6 = 31 * (n4 + n5);
        int n7 = this.c ? 1 : 0;
        if (n7 != 0) {
            n7 = 1;
        }
        int n8 = 31 * (n6 + n7);
        int n9 = this.d ? 1 : 0;
        if (n9 != 0) {
            n9 = 1;
        }
        int n10 = 31 * (n8 + n9);
        int n11 = this.e ? 1 : 0;
        if (n11 != 0) {
            n11 = 1;
        }
        int n12 = 31 * (n10 + n11);
        int n13 = this.f ? 1 : 0;
        if (n13 != 0) {
            n13 = 1;
        }
        int n14 = 31 * (n12 + n13);
        int n15 = this.g ? 1 : 0;
        if (n15 != 0) {
            n15 = 1;
        }
        int n16 = 31 * (n14 + n15);
        int n17 = this.h ? 1 : 0;
        if (n17 != 0) {
            n17 = 1;
        }
        int n18 = 31 * (n16 + n17);
        int n19 = this.i ? 1 : 0;
        if (n19 != 0) {
            n19 = 1;
        }
        int n20 = 31 * (n18 + n19);
        int n21 = this.j ? 1 : 0;
        if (n21 != 0) {
            n21 = 1;
        }
        int n22 = 31 * (n20 + n21);
        int n23 = this.k ? 1 : 0;
        if (n23 != 0) {
            n23 = 1;
        }
        int n24 = 31 * (n22 + n23);
        int n25 = this.l ? 1 : 0;
        if (n25 != 0) {
            n25 = 1;
        }
        int n26 = 31 * (n24 + n25);
        int n27 = this.m ? 1 : 0;
        if (n27 != 0) {
            n27 = 1;
        }
        int n28 = 31 * (n26 + n27);
        int n29 = this.n ? 1 : 0;
        if (n29 != 0) {
            n29 = 1;
        }
        int n30 = 31 * (n28 + n29);
        int n31 = this.o ? 1 : 0;
        if (n31 != 0) {
            n31 = 1;
        }
        int n32 = 31 * (n30 + n31);
        int n33 = this.p;
        if (n33 == 0) {
            n3 = n33;
        }
        return n32 + n3;
    }

    public final boolean i() {
        return this.b;
    }

    public final boolean j() {
        return this.c;
    }

    public final boolean k() {
        return this.m;
    }

    public final boolean l() {
        return this.a;
    }

    public final boolean m() {
        return this.p;
    }

    public final boolean n() {
        return this.e;
    }

    public final boolean o() {
        return this.i;
    }

    public final boolean p() {
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UiConfig(pitchTempo=");
        stringBuilder.append(this.a);
        stringBuilder.append(", loop=");
        stringBuilder.append(this.b);
        stringBuilder.append(", markers=");
        stringBuilder.append(this.c);
        stringBuilder.append(", equalizer=");
        stringBuilder.append(this.d);
        stringBuilder.append(", preamp=");
        stringBuilder.append(this.e);
        stringBuilder.append(", balance=");
        stringBuilder.append(this.f);
        stringBuilder.append(", bpm=");
        stringBuilder.append(this.g);
        stringBuilder.append(", key=");
        stringBuilder.append(this.h);
        stringBuilder.append(", reverb=");
        stringBuilder.append(this.i);
        stringBuilder.append(", compressor=");
        stringBuilder.append(this.j);
        stringBuilder.append(", vocal=");
        stringBuilder.append(this.k);
        stringBuilder.append(", echo=");
        stringBuilder.append(this.l);
        stringBuilder.append(", mono=");
        stringBuilder.append(this.m);
        stringBuilder.append(", limiter=");
        stringBuilder.append(this.n);
        stringBuilder.append(", flanger=");
        stringBuilder.append(this.o);
        stringBuilder.append(", plusMinus=");
        stringBuilder.append(this.p);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

