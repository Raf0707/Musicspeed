/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.u.a;

import b.u.a.d;
import b.u.a.e;

public final class a
implements e {
    private final String f;
    private final Object[] g;

    public a(String string) {
        this(string, null);
    }

    public a(String string, Object[] arrobject) {
        this.f = string;
        this.g = arrobject;
    }

    private static void c(d d2, int n2, Object object) {
        if (object == null) {
            d2.O(n2);
            return;
        }
        if (object instanceof byte[]) {
            d2.C(n2, (byte[])object);
            return;
        }
        if (object instanceof Float) {
            d2.q(n2, ((Float)object).floatValue());
            return;
        }
        if (object instanceof Double) {
            d2.q(n2, (Double)object);
            return;
        }
        if (object instanceof Long) {
            d2.y(n2, (Long)object);
            return;
        }
        if (object instanceof Integer) {
            d2.y(n2, ((Integer)object).intValue());
            return;
        }
        if (object instanceof Short) {
            d2.y(n2, ((Short)object).shortValue());
            return;
        }
        if (object instanceof Byte) {
            d2.y(n2, ((Byte)object).byteValue());
            return;
        }
        if (object instanceof String) {
            d2.k(n2, (String)object);
            return;
        }
        if (object instanceof Boolean) {
            long l2 = (Boolean)object != false ? 1L : 0L;
            d2.y(n2, l2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot bind ");
        stringBuilder.append(object);
        stringBuilder.append(" at index ");
        stringBuilder.append(n2);
        stringBuilder.append(" Supported types: null, byte[], float, double, long, int, short, byte,");
        stringBuilder.append(" string");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static void d(d d2, Object[] arrobject) {
        if (arrobject == null) {
            return;
        }
        int n2 = arrobject.length;
        int n3 = 0;
        while (n3 < n2) {
            Object object = arrobject[n3];
            a.c(d2, ++n3, object);
        }
    }

    @Override
    public String a() {
        return this.f;
    }

    @Override
    public void b(d d2) {
        a.d(d2, this.g);
    }
}

