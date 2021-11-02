/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Queue
 */
package h.e.e;

import h.e.e.b;
import h.e.e.d;
import h.e.f.e;
import java.util.Queue;

public class a
implements h.e.b {
    String f;
    e g;
    Queue<d> h;

    public a(e e2, Queue<d> queue) {
        this.g = e2;
        this.f = e2.getName();
        this.h = queue;
    }

    private void i(b b2, String string, Object[] arrobject, Throwable throwable) {
        this.j(b2, null, string, arrobject, throwable);
    }

    private void j(b b2, h.e.d d2, String string, Object[] arrobject, Throwable throwable) {
        d d3 = new d();
        d3.j(System.currentTimeMillis());
        d3.c(b2);
        d3.d(this.g);
        d3.e(this.f);
        d3.f(d2);
        d3.g(string);
        d3.b(arrobject);
        d3.i(throwable);
        d3.h(Thread.currentThread().getName());
        this.h.add((Object)d3);
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public void b(String string, Throwable throwable) {
        this.i(b.f, string, null, throwable);
    }

    @Override
    public /* varargs */ void c(String string, Object ... arrobject) {
        this.i(b.g, string, arrobject, null);
    }

    @Override
    public void d(String string) {
        this.i(b.j, string, null, null);
    }

    @Override
    public void e(String string, Object object) {
        this.i(b.i, string, new Object[]{object}, null);
    }

    @Override
    public void f(String string, Throwable throwable) {
        this.i(b.g, string, null, throwable);
    }

    @Override
    public void g(String string) {
        this.i(b.g, string, null, null);
    }

    @Override
    public String getName() {
        return this.f;
    }

    @Override
    public /* varargs */ void h(String string, Object ... arrobject) {
        this.i(b.j, string, arrobject, null);
    }
}

