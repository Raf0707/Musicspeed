/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Typeface
 *  b.i.n.e$b
 *  b.i.n.e$d
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
package b.i.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import b.i.n.e;
import b.i.n.f;
import b.i.n.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class e {
    static final b.e.e<String, Typeface> a = new b.e.e(16);
    private static final ExecutorService b = g.a("fonts-androidx", 10, 10000);
    static final Object c = new Object();
    static final b.e.g<String, ArrayList<b.i.p.a<e>>> d = new b.e.g();

    private static String a(b.i.n.d d2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d2.d());
        stringBuilder.append("-");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    @SuppressLint(value={"WrongConstant"})
    private static int b(f.a a2) {
        int n2 = a2.c();
        int n3 = 1;
        if (n2 != 0) {
            if (a2.c() != n3) {
                return -3;
            }
            return -2;
        }
        f.b[] arrb = a2.b();
        if (arrb != null) {
            if (arrb.length == 0) {
                return n3;
            }
            int n4 = arrb.length;
            int n5 = 0;
            do {
                n3 = 0;
                if (n5 >= n4) break;
                int n6 = arrb[n5].b();
                if (n6 != 0) {
                    if (n6 < 0) {
                        return -3;
                    }
                    return n6;
                }
                ++n5;
            } while (true);
        }
        return n3;
    }

    static e c(String string, Context context, b.i.n.d d2, int n2) {
        f.a a2;
        b.e.e<String, Typeface> e2 = a;
        Typeface typeface = e2.get(string);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            a2 = b.i.n.c.d(context, d2, null);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return new e(-1);
        }
        int n3 = e.b(a2);
        if (n3 != 0) {
            return new e(n3);
        }
        Typeface typeface2 = b.i.i.d.b(context, null, a2.b(), n2);
        if (typeface2 != null) {
            e2.put(string, typeface2);
            return new e(typeface2);
        }
        return new e(-3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Typeface d(final Context context, final b.i.n.d d2, final int n2, Executor executor, b.i.n.a a2) {
        Object object;
        String string = e.a(d2, n2);
        Typeface typeface = a.get(string);
        if (typeface != null) {
            a2.b(new e(typeface));
            return typeface;
        }
        b b2 = new b(a2);
        Object object2 = object = c;
        synchronized (object2) {
            b.e.g<String, ArrayList<b.i.p.a<e>>> g2 = d;
            ArrayList<b.i.p.a<e>> arrayList = g2.get(string);
            if (arrayList != null) {
                arrayList.add((Object)b2);
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add((Object)b2);
            g2.put(string, (ArrayList<b.i.p.a<e>>)arrayList2);
        }
        Callable<e> callable = new Callable<e>(){

            public e a() {
                return e.c(String.this, context, d2, n2);
            }
        };
        if (executor == null) {
            executor = b;
        }
        g.b(executor, callable, new d(string));
        return null;
    }

    static Typeface e(final Context context, final b.i.n.d d2, b.i.n.a a2, final int n2, int n3) {
        String string = e.a(d2, n2);
        Typeface typeface = a.get(string);
        if (typeface != null) {
            a2.b(new e(typeface));
            return typeface;
        }
        if (n3 == -1) {
            e e2 = e.c(string, context, d2, n2);
            a2.b(e2);
            return e2.a;
        }
        Callable<e> callable = new Callable<e>(){

            public e a() {
                return e.c(String.this, context, d2, n2);
            }
        };
        try {
            e e3 = g.c(b, callable, n3);
            a2.b(e3);
            Typeface typeface2 = e3.a;
            return typeface2;
        }
        catch (InterruptedException interruptedException) {
            a2.b(new e(-3));
            return null;
        }
    }

    static final class e {
        final Typeface a;
        final int b;

        e(int n2) {
            this.a = null;
            this.b = n2;
        }

        @SuppressLint(value={"WrongConstant"})
        e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }

        @SuppressLint(value={"WrongConstant"})
        boolean a() {
            return this.b == 0;
        }
    }

}

