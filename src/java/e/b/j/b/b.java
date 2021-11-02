/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.b.b$a
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Objects
 */
package e.b.j.b;

import e.b.i.c;
import e.b.j.b.b;
import java.util.Objects;

/*
 * Exception performing whole class analysis.
 */
public final class b {
    static final c<Object, Object> a;

    static {
        a = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static int a(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        return n2 > n3;
    }

    public static int b(long l2, long l3) {
        long l4 = l2 LCMP l3;
        if (l4 < 0) {
            return -1;
        }
        return l4 > 0;
    }

    public static boolean c(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    public static <T> T d(T t2, String string2) {
        Objects.requireNonNull(t2, (String)string2);
        return t2;
    }

    public static int e(int n2, String string2) {
        if (n2 > 0) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

