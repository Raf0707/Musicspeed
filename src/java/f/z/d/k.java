/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package f.z.d;

import f.e;
import f.s;
import java.util.Arrays;

public class k {
    private k() {
    }

    public static boolean a(Double d2, double d3) {
        return d2 != null && d2 == d3;
    }

    public static boolean b(Float f2, Float f3) {
        return f2 == null ? f3 == null : f3 != null && f2.floatValue() == f3.floatValue();
    }

    public static boolean c(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static void d(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        throw k.k(new IllegalStateException(stringBuilder.toString()));
    }

    public static void e(Object object) {
        if (object == null) {
            k.n();
        }
    }

    public static void f(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        throw k.k(new NullPointerException(stringBuilder.toString()));
    }

    public static void g(Object object, String string2) {
        if (object == null) {
            k.q(string2);
        }
    }

    public static void h(Object object, String string2) {
        if (object == null) {
            k.p(string2);
        }
    }

    public static int i(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        return n2 != n3;
    }

    private static String j(String string2) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String string3 = stackTraceElement.getClassName();
        String string4 = stackTraceElement.getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(string3);
        stringBuilder.append(".");
        stringBuilder.append(string4);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static <T extends Throwable> T k(T t2) {
        return k.l(t2, k.class.getName());
    }

    static <T extends Throwable> T l(T t2, String string2) {
        Object[] arrobject = t2.getStackTrace();
        int n2 = arrobject.length;
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equals((Object)arrobject[i2].getClassName())) continue;
            n3 = i2;
        }
        t2.setStackTrace((StackTraceElement[])Arrays.copyOfRange((Object[])arrobject, (int)(n3 + 1), (int)n2));
        return t2;
    }

    public static String m(String string2, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public static void n() {
        throw k.k(new NullPointerException());
    }

    public static void o() {
        throw k.k(new e());
    }

    private static void p(String string2) {
        throw k.k(new IllegalArgumentException(k.j(string2)));
    }

    private static void q(String string2) {
        throw k.k(new NullPointerException(k.j(string2)));
    }

    public static void r(String string2) {
        throw k.k(new s(string2));
    }

    public static void s(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(string2);
        stringBuilder.append(" has not been initialized");
        k.r(stringBuilder.toString());
    }
}

