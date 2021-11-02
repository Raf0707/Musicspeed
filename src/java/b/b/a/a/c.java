/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package b.b.a.a;

public abstract class c {
    public abstract void a(Runnable var1);

    public void b(Runnable runnable) {
        if (this.c()) {
            runnable.run();
            return;
        }
        this.d(runnable);
    }

    public abstract boolean c();

    public abstract void d(Runnable var1);
}

