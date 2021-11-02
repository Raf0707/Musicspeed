/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package h.a.h;

import h.a.i.d;
import java.util.Date;

public class h
implements Cloneable {
    int f;
    private String g = "eng";
    private long h;
    private Date i = new Date();
    private Date j = new Date();
    private d k = d.a;
    private double l;
    private double m;
    private float n;
    private long o = 1L;
    private int p = 0;

    public Date a() {
        return this.j;
    }

    public int b() {
        return this.p;
    }

    public double c() {
        return this.m;
    }

    public Object clone() {
        try {
            Object object = super.clone();
            return object;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public String d() {
        return this.g;
    }

    public int e() {
        return this.f;
    }

    public d f() {
        return this.k;
    }

    public long g() {
        return this.h;
    }

    public long h() {
        return this.o;
    }

    public float i() {
        return this.n;
    }

    public double j() {
        return this.l;
    }

    public void k(Date date) {
        this.j = date;
    }

    public void l(String string2) {
        this.g = string2;
    }

    public void m(Date date) {
        this.i = date;
    }

    public void n(long l2) {
        this.h = l2;
    }

    public void o(long l2) {
        this.o = l2;
    }

    public void p(float f2) {
        this.n = f2;
    }
}

