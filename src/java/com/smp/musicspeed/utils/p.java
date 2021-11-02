/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.utils;

public class p
implements Comparable {
    private int f;
    private int g;
    private int h;
    private long i;

    public p(long l2) {
        int n2;
        this.f = (int)(l2 / 60000000L);
        this.g = (int)Math.floor((double)((double)(l2 % 60000000L) / 1000000.0));
        this.h = n2 = (int)Math.round((double)((double)(l2 % 1000000L) / 1000.0));
        this.i = 60000000L * (long)this.f + 1000000L * (long)this.g + 1000L * (long)n2;
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.g;
    }

    public int compareTo(Object object) {
        p p2 = (p)object;
        int n2 = this.f;
        int n3 = p2.f;
        if (n2 == n3 && this.g == p2.g) {
            return 0;
        }
        if (n2 == n3) {
            if (this.g > p2.g) {
                return 1;
            }
            return -1;
        }
        if (n2 > n3) {
            return 1;
        }
        return -1;
    }

    public long d() {
        return this.i;
    }

    public void e(int n2) {
        int n3 = n2 - this.f;
        this.i += 60000000L * (long)n3;
        this.f = n2;
    }

    public void f(int n2) {
        int n3 = n2 - this.h;
        this.i += 1000L * (long)n3;
        this.h = n2;
    }

    public void g(int n2) {
        int n3 = n2 - this.g;
        this.i += 1000000L * (long)n3;
        this.g = n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        Object[] arrobject = new Object[]{this.f};
        stringBuilder.append(String.format((String)"%d", (Object[])arrobject));
        stringBuilder.append(":");
        Object[] arrobject2 = new Object[]{this.g};
        stringBuilder.append(String.format((String)"%02d", (Object[])arrobject2));
        return stringBuilder.toString();
    }
}

