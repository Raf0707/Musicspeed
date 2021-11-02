/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package e.b.j.h;

import e.b.d;
import e.b.j.b.b;
import java.io.Serializable;

public final class c
extends Enum<c> {
    public static final /* enum */ c f;
    private static final /* synthetic */ c[] g;

    static {
        c c2;
        f = c2 = new c();
        g = new c[]{c2};
    }

    public static <T> boolean a(Object object, d<? super T> d2) {
        if (object == f) {
            d2.b();
            return true;
        }
        if (object instanceof a) {
            d2.d(((a)object).f);
            return true;
        }
        d2.e(object);
        return false;
    }

    public static Object b() {
        return f;
    }

    public static Object c(Throwable throwable) {
        return new a(throwable);
    }

    public static <T> T d(Object object) {
        return (T)object;
    }

    public static boolean e(Object object) {
        return object == f;
    }

    public static boolean f(Object object) {
        return object instanceof a;
    }

    public static <T> Object g(T t2) {
        return t2;
    }

    public static c valueOf(String string2) {
        return (c)Enum.valueOf(c.class, (String)string2);
    }

    public static c[] values() {
        return (c[])g.clone();
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    static final class a
    implements Serializable {
        final Throwable f;

        a(Throwable throwable) {
            this.f = throwable;
        }

        public boolean equals(Object object) {
            if (object instanceof a) {
                a a2 = (a)object;
                return b.c((Object)this.f, (Object)a2.f);
            }
            return false;
        }

        public int hashCode() {
            return this.f.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Error[");
            stringBuilder.append((Object)this.f);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

}

