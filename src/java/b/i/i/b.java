/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.Rect
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.i.i;

import android.graphics.Insets;
import android.graphics.Rect;

public final class b {
    public static final b a = new b(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    private b(int n2, int n3, int n4, int n5) {
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
    }

    public static b a(b b2, b b3) {
        return b.b(Math.max((int)b2.b, (int)b3.b), Math.max((int)b2.c, (int)b3.c), Math.max((int)b2.d, (int)b3.d), Math.max((int)b2.e, (int)b3.e));
    }

    public static b b(int n2, int n3, int n4, int n5) {
        if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
            return a;
        }
        return new b(n2, n3, n4, n5);
    }

    public static b c(Rect rect) {
        return b.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b.b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of((int)this.b, (int)this.c, (int)this.d, (int)this.e);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (b.class != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            if (this.e != b2.e) {
                return false;
            }
            if (this.b != b2.b) {
                return false;
            }
            if (this.d != b2.d) {
                return false;
            }
            return this.c == b2.c;
        }
        return false;
    }

    public int hashCode() {
        return 31 * (31 * (31 * this.b + this.c) + this.d) + this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Insets{left=");
        stringBuilder.append(this.b);
        stringBuilder.append(", top=");
        stringBuilder.append(this.c);
        stringBuilder.append(", right=");
        stringBuilder.append(this.d);
        stringBuilder.append(", bottom=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

