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
import h.b.a.u;

public abstract class j {
    protected final int a;
    protected j b;

    public j(int n2) {
        this(n2, null);
    }

    public j(int n2, j j2) {
        if (n2 != 262144 && n2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.a = n2;
        this.b = j2;
    }

    public abstract a a(String var1, boolean var2);

    public abstract void b(c var1);

    public abstract void c();

    public abstract a d(int var1, u var2, String var3, boolean var4);
}

