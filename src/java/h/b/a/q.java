/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package h.b.a;

import h.b.a.a;
import h.b.a.c;
import h.b.a.m;
import h.b.a.p;
import h.b.a.u;

public abstract class q {
    protected final int a;
    protected q b;

    public q(int n2) {
        this(n2, null);
    }

    public q(int n2, q q2) {
        if (n2 != 262144 && n2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.a = n2;
        this.b = q2;
    }

    public abstract a A(int var1, u var2, String var3, boolean var4);

    public abstract void B(p var1, p var2, p var3, String var4);

    public abstract a C(int var1, u var2, String var3, boolean var4);

    public abstract void D(int var1, String var2);

    public abstract void E(int var1, int var2);

    public abstract a a(String var1, boolean var2);

    public abstract a b();

    public abstract void c(c var1);

    public abstract void d();

    public abstract void e();

    public abstract void f(int var1, String var2, String var3, String var4);

    public abstract void g(int var1, int var2, Object[] var3, int var4, Object[] var5);

    public abstract void h(int var1, int var2);

    public abstract void i(int var1);

    public abstract a j(int var1, u var2, String var3, boolean var4);

    public abstract void k(int var1, int var2);

    public /* varargs */ abstract void l(String var1, String var2, m var3, Object ... var4);

    public abstract void m(int var1, p var2);

    public abstract void n(p var1);

    public abstract void o(Object var1);

    public abstract void p(int var1, p var2);

    public abstract void q(String var1, String var2, String var3, p var4, p var5, int var6);

    public abstract a r(int var1, u var2, p[] var3, p[] var4, int[] var5, String var6, boolean var7);

    public abstract void s(p var1, int[] var2, p[] var3);

    public abstract void t(int var1, int var2);

    public void u(int n2, String string2, String string3, String string4) {
        if (this.a >= 327680) {
            boolean bl = n2 == 185;
            this.v(n2, string2, string3, string4, bl);
            return;
        }
        q q2 = this.b;
        if (q2 != null) {
            q2.u(n2, string2, string3, string4);
        }
    }

    public abstract void v(int var1, String var2, String var3, String var4, boolean var5);

    public abstract void w(String var1, int var2);

    public abstract void x(String var1, int var2);

    public abstract a y(int var1, String var2, boolean var3);

    public /* varargs */ abstract void z(int var1, int var2, p var3, p ... var4);
}

