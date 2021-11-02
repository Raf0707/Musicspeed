/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package h.b.a;

public abstract class a {
    protected final int a;
    protected a b;

    public a(int n2) {
        this(n2, null);
    }

    public a(int n2, a a2) {
        if (n2 != 262144 && n2 != 327680) {
            throw new IllegalArgumentException();
        }
        this.a = n2;
        this.b = a2;
    }

    public abstract void a(String var1, Object var2);

    public abstract a b(String var1, String var2);

    public abstract a c(String var1);

    public abstract void d();

    public abstract void e(String var1, String var2, String var3);
}

