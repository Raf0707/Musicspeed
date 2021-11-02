/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.g0;

import f.d0.f;

class a {
    public static final int a(int n2) {
        if (2 <= n2 && 36 >= n2) {
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("radix ");
        stringBuilder.append(n2);
        stringBuilder.append(" was not in valid range ");
        stringBuilder.append((Object)new f(2, 36));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static final int b(char c2, int n2) {
        return Character.digit((int)c2, (int)n2);
    }

    public static final boolean c(char c2) {
        return Character.isWhitespace((char)c2) || Character.isSpaceChar((char)c2);
        {
        }
    }
}

