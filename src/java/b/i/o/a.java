/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.SpannableStringBuilder
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package b.i.o;

import android.text.SpannableStringBuilder;
import b.i.o.e;
import b.i.o.f;
import b.i.o.g;
import java.util.Locale;

public final class a {
    static final e a;
    private static final String b;
    private static final String c;
    static final a d;
    static final a e;
    private final boolean f;
    private final int g;
    private final e h;

    static {
        e e2;
        a = e2 = f.c;
        b = Character.toString((char)'\u200e');
        c = Character.toString((char)'\u200f');
        d = new a(false, 2, e2);
        e = new a(true, 2, e2);
    }

    a(boolean bl, int n2, e e2) {
        this.f = bl;
        this.g = n2;
        this.h = e2;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new a().a();
    }

    static boolean e(Locale locale) {
        return g.b(locale) == 1;
    }

    private String f(CharSequence charSequence, e e2) {
        boolean bl = e2.a(charSequence, 0, charSequence.length());
        if (!this.f && (bl || a.b(charSequence) == 1)) {
            return b;
        }
        if (this.f && (!bl || a.b(charSequence) == -1)) {
            return c;
        }
        return "";
    }

    private String g(CharSequence charSequence, e e2) {
        boolean bl = e2.a(charSequence, 0, charSequence.length());
        if (!this.f && (bl || a.a(charSequence) == 1)) {
            return b;
        }
        if (this.f && (!bl || a.a(charSequence) == -1)) {
            return c;
        }
        return "";
    }

    public boolean d() {
        return (2 & this.g) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return this.i(charSequence, this.h, true);
    }

    public CharSequence i(CharSequence charSequence, e e2, boolean bl) {
        if (charSequence == null) {
            return null;
        }
        boolean bl2 = e2.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.d() && bl) {
            e e3 = bl2 ? f.b : f.a;
            spannableStringBuilder.append((CharSequence)this.g(charSequence, e3));
        }
        if (bl2 != this.f) {
            char c2 = bl2 ? (char)'\u202b' : '\u202a';
            spannableStringBuilder.append(c2);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (bl) {
            e e4 = bl2 ? f.b : f.a;
            spannableStringBuilder.append((CharSequence)this.f(charSequence, e4));
        }
        return spannableStringBuilder;
    }

    public String j(String string) {
        return this.k(string, this.h, true);
    }

    public String k(String string, e e2, boolean bl) {
        if (string == null) {
            return null;
        }
        return this.i(string, e2, bl).toString();
    }

    public static final class a {
        private boolean a;
        private int b;
        private e c;

        public a() {
            this.c(a.e(Locale.getDefault()));
        }

        private static a b(boolean bl) {
            if (bl) {
                return a.e;
            }
            return a.d;
        }

        private void c(boolean bl) {
            this.a = bl;
            this.c = a.a;
            this.b = 2;
        }

        public a a() {
            if (this.b == 2 && this.c == a.a) {
                return a.b(this.a);
            }
            return new a(this.a, this.b, this.c);
        }
    }

    private static class b {
        private static final byte[] a = new byte[1792];
        private final CharSequence b;
        private final boolean c;
        private final int d;
        private int e;
        private char f;

        static {
            for (int i2 = 0; i2 < 1792; ++i2) {
                b.a[i2] = Character.getDirectionality((int)i2);
            }
        }

        b(CharSequence charSequence, boolean bl) {
            this.b = charSequence;
            this.c = bl;
            this.d = charSequence.length();
        }

        private static byte c(char c2) {
            if (c2 < '\u0700') {
                return a[c2];
            }
            return Character.getDirectionality((char)c2);
        }

        private byte f() {
            int n2;
            int n3 = this.e;
            while ((n2 = this.e) > 0) {
                int n4;
                char c2;
                CharSequence charSequence = this.b;
                this.e = n4 = n2 - 1;
                this.f = c2 = charSequence.charAt(n4);
                if (c2 == '&') {
                    return 12;
                }
                if (c2 != ';') continue;
            }
            this.e = n3;
            this.f = (char)59;
            return 13;
        }

        private byte g() {
            int n2;
            while ((n2 = this.e) < this.d) {
                char c2;
                CharSequence charSequence = this.b;
                this.e = n2 + 1;
                this.f = c2 = charSequence.charAt(n2);
                if (c2 != ';') continue;
            }
            return 12;
        }

        private byte h() {
            int n2;
            int n3 = this.e;
            block0 : while ((n2 = this.e) > 0) {
                int n4;
                int n5;
                char c2;
                CharSequence charSequence = this.b;
                this.e = n5 = n2 - 1;
                this.f = c2 = charSequence.charAt(n5);
                if (c2 == '<') {
                    return 12;
                }
                if (c2 == '>') break;
                if (c2 != '\"' && c2 != '\'') continue;
                while ((n4 = this.e) > 0) {
                    char c3;
                    int n6;
                    CharSequence charSequence2 = this.b;
                    this.e = n6 = n4 - 1;
                    this.f = c3 = charSequence2.charAt(n6);
                    if (c3 == c2) continue block0;
                }
            }
            this.e = n3;
            this.f = (char)62;
            return 13;
        }

        private byte i() {
            int n2;
            int n3 = this.e;
            block0 : while ((n2 = this.e) < this.d) {
                char c2;
                int n4;
                CharSequence charSequence = this.b;
                this.e = n2 + 1;
                this.f = c2 = charSequence.charAt(n2);
                if (c2 == '>') {
                    return 12;
                }
                if (c2 != '\"' && c2 != '\'') continue;
                while ((n4 = this.e) < this.d) {
                    char c3;
                    CharSequence charSequence2 = this.b;
                    this.e = n4 + 1;
                    this.f = c3 = charSequence2.charAt(n4);
                    if (c3 == c2) continue block0;
                }
            }
            this.e = n3;
            this.f = (char)60;
            return 13;
        }

        byte a() {
            char c2;
            this.f = c2 = this.b.charAt(-1 + this.e);
            if (Character.isLowSurrogate((char)c2)) {
                int n2 = Character.codePointBefore((CharSequence)this.b, (int)this.e);
                this.e -= Character.charCount((int)n2);
                return Character.getDirectionality((int)n2);
            }
            this.e = -1 + this.e;
            byte by = b.c(this.f);
            if (this.c) {
                char c3 = this.f;
                if (c3 == '>') {
                    return this.h();
                }
                if (c3 == ';') {
                    by = this.f();
                }
            }
            return by;
        }

        byte b() {
            char c2;
            this.f = c2 = this.b.charAt(this.e);
            if (Character.isHighSurrogate((char)c2)) {
                int n2 = Character.codePointAt((CharSequence)this.b, (int)this.e);
                this.e += Character.charCount((int)n2);
                return Character.getDirectionality((int)n2);
            }
            this.e = 1 + this.e;
            byte by = b.c(this.f);
            if (this.c) {
                char c3 = this.f;
                if (c3 == '<') {
                    return this.i();
                }
                if (c3 == '&') {
                    by = this.g();
                }
            }
            return by;
        }

        int d() {
            this.e = 0;
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            while (this.e < this.d && n2 == 0) {
                block18 : {
                    block16 : {
                        block17 : {
                            byte by = this.b();
                            if (by == 0) break block16;
                            if (by == 1 || by == 2) break block17;
                            if (by == 9) continue;
                            switch (by) {
                                default: {
                                    break block18;
                                }
                                case 18: {
                                    --n4;
                                    n3 = 0;
                                    break;
                                }
                                case 16: 
                                case 17: {
                                    ++n4;
                                    n3 = 1;
                                    break;
                                }
                                case 14: 
                                case 15: {
                                    ++n4;
                                    n3 = -1;
                                    break;
                                }
                            }
                            continue;
                        }
                        if (n4 == 0) {
                            return 1;
                        }
                        break block18;
                    }
                    if (n4 == 0) {
                        return -1;
                    }
                }
                n2 = n4;
            }
            if (n2 == 0) {
                return 0;
            }
            if (n3 != 0) {
                return n3;
            }
            block11 : while (this.e > 0) {
                switch (this.a()) {
                    default: {
                        continue block11;
                    }
                    case 18: {
                        ++n4;
                        continue block11;
                    }
                    case 16: 
                    case 17: {
                        if (n2 != n4) break;
                        return 1;
                    }
                    case 14: 
                    case 15: {
                        if (n2 != n4) break;
                        return -1;
                    }
                }
                --n4;
            }
            return 0;
        }

        int e() {
            this.e = this.d;
            int n2 = 0;
            int n3 = 0;
            block5 : while (this.e > 0) {
                block10 : {
                    block8 : {
                        block9 : {
                            byte by = this.a();
                            if (by == 0) break block8;
                            if (by == 1 || by == 2) break block9;
                            if (by == 9) continue;
                            switch (by) {
                                default: {
                                    if (n3 != 0) continue block5;
                                    break block10;
                                }
                                case 18: {
                                    ++n2;
                                    continue block5;
                                }
                                case 16: 
                                case 17: {
                                    if (n3 != n2) break;
                                    return 1;
                                }
                                case 14: 
                                case 15: {
                                    if (n3 != n2) break;
                                    return -1;
                                }
                            }
                            --n2;
                            continue;
                        }
                        if (n2 == 0) {
                            return 1;
                        }
                        if (n3 != 0) continue;
                        break block10;
                    }
                    if (n2 == 0) {
                        return -1;
                    }
                    if (n3 != 0) continue;
                }
                n3 = n2;
            }
            return 0;
        }
    }

}

