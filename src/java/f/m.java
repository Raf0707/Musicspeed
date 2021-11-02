/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.z.d.g
 *  f.z.d.k
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package f;

import f.z.d.g;
import f.z.d.k;
import java.io.Serializable;

public final class m<T>
implements Serializable {
    public static final a f = new a(null);
    private final Object g;

    private /* synthetic */ m(Object object) {
        this.g = object;
    }

    public static final /* synthetic */ m a(Object object) {
        return new m<T>(object);
    }

    public static Object b(Object object) {
        return object;
    }

    public static boolean c(Object object, Object object2) {
        return object2 instanceof m && k.c((Object)object, (Object)((m)object2).i());
    }

    public static final Throwable d(Object object) {
        if (object instanceof b) {
            return ((b)object).f;
        }
        return null;
    }

    public static int e(Object object) {
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    public static final boolean f(Object object) {
        return object instanceof b;
    }

    public static final boolean g(Object object) {
        return true ^ object instanceof b;
    }

    public static String h(Object object) {
        if (object instanceof b) {
            return object.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Success(");
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public boolean equals(Object object) {
        return m.c(this.g, object);
    }

    public int hashCode() {
        return m.e(this.g);
    }

    public final /* synthetic */ Object i() {
        return this.g;
    }

    public String toString() {
        return m.h(this.g);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

    public static final class b
    implements Serializable {
        public final Throwable f;

        public b(Throwable throwable) {
            k.g((Object)throwable, (String)"exception");
            this.f = throwable;
        }

        public boolean equals(Object object) {
            return object instanceof b && k.c((Object)this.f, (Object)((b)object).f);
        }

        public int hashCode() {
            return this.f.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failure(");
            stringBuilder.append((Object)this.f);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

}

