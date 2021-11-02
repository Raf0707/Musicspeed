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
import h.b.a.j;
import h.b.a.q;
import h.b.a.u;

public abstract class f {
    protected final int a;
    protected f b;

    public f(int n2) {
        this(n2, null);
    }

    public f(int n2, f f2) {
        if (n2 != 262144 && n2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.a = n2;
        this.b = f2;
    }

    public abstract void a(int var1, int var2, String var3, String var4, String var5, String[] var6);

    public abstract a b(String var1, boolean var2);

    public abstract void c(c var1);

    public abstract void d();

    public abstract j e(int var1, String var2, String var3, String var4, Object var5);

    public abstract void f(String var1, String var2, String var3, int var4);

    public abstract q g(int var1, String var2, String var3, String var4, String[] var5);

    public abstract void h(String var1, String var2, String var3);

    public abstract void i(String var1, String var2);

    public abstract a j(int var1, u var2, String var3, boolean var4);
}

