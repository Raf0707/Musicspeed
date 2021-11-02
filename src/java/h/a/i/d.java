/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 */
package h.a.i;

import h.a.j.e;
import java.nio.ByteBuffer;

public class d {
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    double e;
    double f;
    double g;
    double h;
    double i;
    double j;
    double k;
    double l;
    double m;

    static {
        d d2;
        d d3;
        d d4;
        d d5;
        a = d5 = new d(1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0);
        b = d3 = new d(0.0, 1.0, -1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0);
        c = d4 = new d(-1.0, 0.0, 0.0, -1.0, 0.0, 0.0, 1.0, 0.0, 0.0);
        d = d2 = new d(0.0, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0);
    }

    public d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.e = d6;
        this.f = d7;
        this.g = d8;
        this.h = d2;
        this.i = d3;
        this.j = d4;
        this.k = d5;
        this.l = d9;
        this.m = d10;
    }

    public static d a(ByteBuffer byteBuffer) {
        return d.b(h.a.j.d.d(byteBuffer), h.a.j.d.d(byteBuffer), h.a.j.d.c(byteBuffer), h.a.j.d.d(byteBuffer), h.a.j.d.d(byteBuffer), h.a.j.d.c(byteBuffer), h.a.j.d.d(byteBuffer), h.a.j.d.d(byteBuffer), h.a.j.d.c(byteBuffer));
    }

    public static d b(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        d d11 = new d(d2, d3, d5, d6, d4, d7, d10, d8, d9);
        return d11;
    }

    public void c(ByteBuffer byteBuffer) {
        e.b(byteBuffer, this.h);
        e.b(byteBuffer, this.i);
        e.a(byteBuffer, this.e);
        e.b(byteBuffer, this.j);
        e.b(byteBuffer, this.k);
        e.a(byteBuffer, this.f);
        e.b(byteBuffer, this.l);
        e.b(byteBuffer, this.m);
        e.a(byteBuffer, this.g);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (d.class != object.getClass()) {
                return false;
            }
            d d2 = (d)object;
            if (Double.compare((double)d2.h, (double)this.h) != 0) {
                return false;
            }
            if (Double.compare((double)d2.i, (double)this.i) != 0) {
                return false;
            }
            if (Double.compare((double)d2.j, (double)this.j) != 0) {
                return false;
            }
            if (Double.compare((double)d2.k, (double)this.k) != 0) {
                return false;
            }
            if (Double.compare((double)d2.l, (double)this.l) != 0) {
                return false;
            }
            if (Double.compare((double)d2.m, (double)this.m) != 0) {
                return false;
            }
            if (Double.compare((double)d2.e, (double)this.e) != 0) {
                return false;
            }
            if (Double.compare((double)d2.f, (double)this.f) != 0) {
                return false;
            }
            return Double.compare((double)d2.g, (double)this.g) == 0;
        }
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits((double)this.e);
        int n2 = (int)(l2 ^ l2 >>> 32);
        long l3 = Double.doubleToLongBits((double)this.f);
        int n3 = n2 * 31 + (int)(l3 ^ l3 >>> 32);
        long l4 = Double.doubleToLongBits((double)this.g);
        int n4 = n3 * 31 + (int)(l4 ^ l4 >>> 32);
        long l5 = Double.doubleToLongBits((double)this.h);
        int n5 = n4 * 31 + (int)(l5 ^ l5 >>> 32);
        long l6 = Double.doubleToLongBits((double)this.i);
        int n6 = n5 * 31 + (int)(l6 ^ l6 >>> 32);
        long l7 = Double.doubleToLongBits((double)this.j);
        int n7 = n6 * 31 + (int)(l7 ^ l7 >>> 32);
        long l8 = Double.doubleToLongBits((double)this.k);
        int n8 = n7 * 31 + (int)(l8 ^ l8 >>> 32);
        long l9 = Double.doubleToLongBits((double)this.l);
        int n9 = n8 * 31 + (int)(l9 ^ l9 >>> 32);
        long l10 = Double.doubleToLongBits((double)this.m);
        return n9 * 31 + (int)(l10 ^ l10 >>> 32);
    }

    public String toString() {
        if (this.equals(a)) {
            return "Rotate 0\u00b0";
        }
        if (this.equals(b)) {
            return "Rotate 90\u00b0";
        }
        if (this.equals(c)) {
            return "Rotate 180\u00b0";
        }
        if (this.equals(d)) {
            return "Rotate 270\u00b0";
        }
        StringBuilder stringBuilder = new StringBuilder("Matrix{u=");
        stringBuilder.append(this.e);
        stringBuilder.append(", v=");
        stringBuilder.append(this.f);
        stringBuilder.append(", w=");
        stringBuilder.append(this.g);
        stringBuilder.append(", a=");
        stringBuilder.append(this.h);
        stringBuilder.append(", b=");
        stringBuilder.append(this.i);
        stringBuilder.append(", c=");
        stringBuilder.append(this.j);
        stringBuilder.append(", d=");
        stringBuilder.append(this.k);
        stringBuilder.append(", tx=");
        stringBuilder.append(this.l);
        stringBuilder.append(", ty=");
        stringBuilder.append(this.m);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

