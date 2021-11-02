/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReference
 */
package e.b.j.a;

import e.b.h.d;
import e.b.k.a;
import java.util.concurrent.atomic.AtomicReference;

public final class b
extends Enum<b>
implements e.b.g.b {
    public static final /* enum */ b f;
    private static final /* synthetic */ b[] g;

    static {
        b b2;
        f = b2 = new b();
        g = new b[]{b2};
    }

    public static boolean b(AtomicReference<e.b.g.b> atomicReference) {
        b b2;
        e.b.g.b b3;
        e.b.g.b b4 = (e.b.g.b)atomicReference.get();
        if (b4 != (b2 = f) && (b3 = (e.b.g.b)atomicReference.getAndSet((Object)b2)) != b2) {
            if (b3 != null) {
                b3.a();
            }
            return true;
        }
        return false;
    }

    public static void c() {
        a.k((Throwable)new d("Disposable already set!"));
    }

    public static boolean d(AtomicReference<e.b.g.b> atomicReference, e.b.g.b b2) {
        e.b.j.b.b.d(b2, "d is null");
        if (!atomicReference.compareAndSet(null, (Object)b2)) {
            b2.a();
            if (atomicReference.get() != f) {
                b.c();
            }
            return false;
        }
        return true;
    }

    public static boolean e(e.b.g.b b2, e.b.g.b b3) {
        if (b3 == null) {
            a.k(new NullPointerException("next is null"));
            return false;
        }
        if (b2 != null) {
            b3.a();
            b.c();
            return false;
        }
        return true;
    }

    public static b valueOf(String string2) {
        return (b)Enum.valueOf(b.class, (String)string2);
    }

    public static b[] values() {
        return (b[])g.clone();
    }

    @Override
    public void a() {
    }
}

