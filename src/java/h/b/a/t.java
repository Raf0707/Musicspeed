/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.Void
 */
package h.b.a;

public class t {
    public static final t a;
    public static final t b;
    public static final t c;
    public static final t d;
    public static final t e;
    public static final t f;
    public static final t g;
    public static final t h;
    public static final t i;
    private final int j;
    private final char[] k;
    private final int l;
    private final int m;

    static {
        t.a();
        a = new t(0, null, 1443168256, 1);
        b = new t(1, null, 1509950721, 1);
        c = new t(2, null, 1124075009, 1);
        d = new t(3, null, 1107297537, 1);
        e = new t(4, null, 1392510721, 1);
        f = new t(5, null, 1224736769, 1);
        g = new t(6, null, 1174536705, 1);
        h = new t(7, null, 1241579778, 1);
        i = new t(8, null, 1141048066, 1);
    }

    private t(int n2, char[] arrc, int n3, int n4) {
        this.j = n2;
        this.k = arrc;
        this.l = n3;
        this.m = n4;
    }

    static /* synthetic */ void a() {
    }

    private static t b(char[] arrc, int n2) {
        char c2 = arrc[n2];
        if (c2 != 'F') {
            if (c2 != 'L') {
                if (c2 != 'S') {
                    if (c2 != 'V') {
                        if (c2 != 'I') {
                            if (c2 != 'J') {
                                if (c2 != 'Z') {
                                    int n3;
                                    if (c2 != '[') {
                                        switch (c2) {
                                            default: {
                                                return new t(11, arrc, n2, arrc.length - n2);
                                            }
                                            case 'D': {
                                                return i;
                                            }
                                            case 'C': {
                                                return c;
                                            }
                                            case 'B': 
                                        }
                                        return d;
                                    }
                                    int n4 = 1;
                                    while (arrc[n3 = n2 + n4] == '[') {
                                        ++n4;
                                    }
                                    if (arrc[n3] == 'L') {
                                        while (arrc[n2 + ++n4] != ';') {
                                        }
                                    }
                                    return new t(9, arrc, n2, n4 + 1);
                                }
                                return b;
                            }
                            return h;
                        }
                        return f;
                    }
                    return a;
                }
                return e;
            }
            int n5 = 1;
            while (arrc[n2 + n5] != ';') {
                ++n5;
            }
            return new t(10, arrc, n2 + 1, n5 - 1);
        }
        return g;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(StringBuffer stringBuffer) {
        int n2;
        char[] arrc = this.k;
        if (arrc == null) {
            n2 = (-16777216 & this.l) >>> 24;
        } else {
            if (this.j != 10) {
                stringBuffer.append(arrc, this.l, this.m);
                return;
            }
            stringBuffer.append('L');
            stringBuffer.append(this.k, this.l, this.m);
            n2 = 59;
        }
        stringBuffer.append((char)n2);
    }

    private static void d(StringBuffer stringBuffer, Class class_) {
        do {
            if (class_.isPrimitive()) {
                int n2 = class_ == Integer.TYPE ? 73 : (class_ == Void.TYPE ? 86 : (class_ == Boolean.TYPE ? 90 : (class_ == Byte.TYPE ? 66 : (class_ == Character.TYPE ? 67 : (class_ == Short.TYPE ? 83 : (class_ == Double.TYPE ? 68 : (class_ == Float.TYPE ? 70 : 74)))))));
                stringBuffer.append((char)n2);
                return;
            }
            if (!class_.isArray()) break;
            stringBuffer.append('[');
            class_ = class_.getComponentType();
        } while (true);
        stringBuffer.append('L');
        String string2 = class_.getName();
        int n3 = string2.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 == '.') {
                c2 = '/';
            }
            stringBuffer.append(c2);
        }
        stringBuffer.append(';');
    }

    public static t[] e(String string2) {
        char[] arrc = string2.toCharArray();
        int n2 = 1;
        int n3 = 1;
        int n4 = 0;
        do {
            int n5 = n3 + 1;
            char c2 = arrc[n3];
            if (c2 == ')') {
                t[] arrt = new t[n4];
                int n6 = 0;
                while (arrc[n2] != ')') {
                    arrt[n6] = t.b(arrc, n2);
                    int n7 = arrt[n6].m;
                    int n8 = arrt[n6].j == 10 ? 2 : 0;
                    n2 += n7 + n8;
                    ++n6;
                }
                return arrt;
            }
            if (c2 == 'L') {
                do {
                    n3 = n5 + 1;
                    if (arrc[n5] == ';') break;
                    n5 = n3;
                } while (true);
                ++n4;
                continue;
            }
            if (c2 != '[') {
                ++n4;
            }
            n3 = n5;
        } while (true);
    }

    public static int f(String string2) {
        int n2 = 1;
        int n3 = 1;
        int n4 = 1;
        do {
            int n5 = n3 + 1;
            char c2 = string2.charAt(n3);
            if (c2 == ')') {
                char c3 = string2.charAt(n5);
                int n6 = n4 << 2;
                if (c3 == 'V') {
                    n2 = 0;
                } else if (c3 == 'D' || c3 == 'J') {
                    n2 = 2;
                }
                return n6 | n2;
            }
            if (c2 == 'L') {
                do {
                    n3 = n5 + 1;
                    if (string2.charAt(n5) == ';') break;
                    n5 = n3;
                } while (true);
                ++n4;
                continue;
            }
            if (c2 == '[') {
                char c4;
                while ((c4 = string2.charAt(n5)) == '[') {
                    ++n5;
                }
                if (c4 == 'D' || c4 == 'J') {
                    --n4;
                }
            } else {
                n4 = c2 != 'D' && c2 != 'J' ? ++n4 : (n4 += 2);
            }
            n3 = n5;
        } while (true);
    }

    public static String i(Class class_) {
        StringBuffer stringBuffer = new StringBuffer();
        t.d(stringBuffer, class_);
        return stringBuffer.toString();
    }

    public static t m(String string2) {
        return t.b(string2.toCharArray(), 0);
    }

    public static t n(String string2) {
        char[] arrc = string2.toCharArray();
        int n2 = arrc[0] == '[' ? 9 : 10;
        return new t(n2, arrc, 0, arrc.length);
    }

    public static t p(Class class_) {
        if (class_.isPrimitive()) {
            if (class_ == Integer.TYPE) {
                return f;
            }
            if (class_ == Void.TYPE) {
                return a;
            }
            if (class_ == Boolean.TYPE) {
                return b;
            }
            if (class_ == Byte.TYPE) {
                return d;
            }
            if (class_ == Character.TYPE) {
                return c;
            }
            if (class_ == Short.TYPE) {
                return e;
            }
            if (class_ == Double.TYPE) {
                return i;
            }
            if (class_ == Float.TYPE) {
                return g;
            }
            return h;
        }
        return t.q(t.i(class_));
    }

    public static t q(String string2) {
        return t.b(string2.toCharArray(), 0);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof t)) {
            return false;
        }
        t t2 = (t)object;
        int n2 = this.j;
        if (n2 != t2.j) {
            return false;
        }
        if (n2 >= 9) {
            int n3 = this.m;
            if (n3 != t2.m) {
                return false;
            }
            int n4 = this.l;
            int n5 = t2.l;
            int n6 = n3 + n4;
            while (n4 < n6) {
                if (this.k[n4] != t2.k[n5]) {
                    return false;
                }
                ++n4;
                ++n5;
            }
        }
        return true;
    }

    public String g() {
        switch (this.j) {
            default: {
                return null;
            }
            case 10: {
                return new String(this.k, this.l, this.m).replace('/', '.');
            }
            case 9: {
                StringBuffer stringBuffer = new StringBuffer(this.k().g());
                for (int i2 = this.j(); i2 > 0; --i2) {
                    stringBuffer.append("[]");
                }
                return stringBuffer.toString();
            }
            case 8: {
                return "double";
            }
            case 7: {
                return "long";
            }
            case 6: {
                return "float";
            }
            case 5: {
                return "int";
            }
            case 4: {
                return "short";
            }
            case 3: {
                return "byte";
            }
            case 2: {
                return "char";
            }
            case 1: {
                return "boolean";
            }
            case 0: 
        }
        return "void";
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer();
        this.c(stringBuffer);
        return stringBuffer.toString();
    }

    public int hashCode() {
        int n2 = this.j;
        int n3 = n2 * 13;
        if (n2 >= 9) {
            int n4;
            int n5 = n4 + this.m;
            for (n4 = this.l; n4 < n5; ++n4) {
                n3 = 17 * (n3 + this.k[n4]);
            }
        }
        return n3;
    }

    public int j() {
        int n2 = 1;
        while (this.k[n2 + this.l] == '[') {
            ++n2;
        }
        return n2;
    }

    public t k() {
        return t.b(this.k, this.l + this.j());
    }

    public String l() {
        return new String(this.k, this.l, this.m);
    }

    public int o() {
        return this.j;
    }

    public String toString() {
        return this.h();
    }
}

