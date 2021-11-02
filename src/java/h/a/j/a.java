/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h.a.j;

public class a {
    public static int a(long l2) {
        if (l2 <= Integer.MAX_VALUE && l2 >= Integer.MIN_VALUE) {
            return (int)l2;
        }
        StringBuilder stringBuilder = new StringBuilder("A cast to int has gone wrong. Please contact the mp4parser discussion group (");
        stringBuilder.append(l2);
        stringBuilder.append(")");
        throw new RuntimeException(stringBuilder.toString());
    }
}

