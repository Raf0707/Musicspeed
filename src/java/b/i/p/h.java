/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package b.i.p;

import java.util.Objects;

public final class h {
    public static void a(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void b(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf((Object)object));
    }

    public static int c(int n2) {
        if (n2 >= 0) {
            return n2;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T d(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static <T> T e(T t2, Object object) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf((Object)object));
    }

    public static void f(boolean bl) {
        h.g(bl, null);
    }

    public static void g(boolean bl, String string) {
        if (bl) {
            return;
        }
        throw new IllegalStateException(string);
    }
}

