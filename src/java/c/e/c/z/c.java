/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Objects
 */
package c.e.c.z;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

public class c
implements Closeable,
Flushable {
    private static final String[] f = new String[128];
    private static final String[] g;
    private final Writer h;
    private int[] i = new int[32];
    private int j = 0;
    private String k;
    private String l;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;

    static {
        for (int i2 = 0; i2 <= 31; ++i2) {
            String[] arrstring = f;
            Object[] arrobject = new Object[]{i2};
            arrstring[i2] = String.format((String)"\\u%04x", (Object[])arrobject);
        }
        String[] arrstring = f;
        arrstring[34] = "\\\"";
        arrstring[92] = "\\\\";
        arrstring[9] = "\\t";
        arrstring[8] = "\\b";
        arrstring[10] = "\\n";
        arrstring[13] = "\\r";
        arrstring[12] = "\\f";
        String[] arrstring2 = (String[])arrstring.clone();
        g = arrstring2;
        arrstring2[60] = "\\u003c";
        arrstring2[62] = "\\u003e";
        arrstring2[38] = "\\u0026";
        arrstring2[61] = "\\u003d";
        arrstring2[39] = "\\u0027";
    }

    public c(Writer writer) {
        this.X(6);
        this.l = ":";
        this.p = true;
        Objects.requireNonNull((Object)writer, (String)"out == null");
        this.h = writer;
    }

    private void L() throws IOException {
        if (this.k == null) {
            return;
        }
        this.h.write(10);
        int n2 = this.j;
        for (int i2 = 1; i2 < n2; ++i2) {
            this.h.write(this.k);
        }
    }

    private c Q(int n2, char c2) throws IOException {
        this.b();
        this.X(n2);
        this.h.write((int)c2);
        return this;
    }

    private int T() {
        int n2 = this.j;
        if (n2 != 0) {
            return this.i[n2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void X(int n2) {
        int n3 = this.j;
        int[] arrn = this.i;
        if (n3 == arrn.length) {
            this.i = Arrays.copyOf((int[])arrn, (int)(n3 * 2));
        }
        int[] arrn2 = this.i;
        int n4 = this.j;
        this.j = n4 + 1;
        arrn2[n4] = n2;
    }

    private void a() throws IOException {
        block4 : {
            block3 : {
                int n2;
                block2 : {
                    n2 = this.T();
                    if (n2 != 5) break block2;
                    this.h.write(44);
                    break block3;
                }
                if (n2 != 3) break block4;
            }
            this.L();
            this.a0(4);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private void a0(int n2) {
        this.i[-1 + this.j] = n2;
    }

    private void b() throws IOException {
        int n2 = this.T();
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 4) {
                    if (n2 != 6) {
                        if (n2 == 7) {
                            if (!this.m) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    this.a0(7);
                    return;
                }
                this.h.append((CharSequence)this.l);
                this.a0(5);
                return;
            }
            this.h.append(',');
            this.L();
            return;
        }
        this.a0(2);
        this.L();
    }

    private void f0(String string) throws IOException {
        String[] arrstring = this.n ? g : f;
        this.h.write(34);
        int n2 = string.length();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2;
            char c2 = string.charAt(i2);
            if (c2 < '') {
                string2 = arrstring[c2];
                if (string2 == null) {
                    continue;
                }
            } else if (c2 == '\u2028') {
                string2 = "\\u2028";
            } else {
                if (c2 != '\u2029') continue;
                string2 = "\\u2029";
            }
            if (n3 < i2) {
                this.h.write(string, n3, i2 - n3);
            }
            this.h.write(string2);
            n3 = i2 + 1;
        }
        if (n3 < n2) {
            this.h.write(string, n3, n2 - n3);
        }
        this.h.write(34);
    }

    private void l0() throws IOException {
        if (this.o != null) {
            this.a();
            this.f0(this.o);
            this.o = null;
        }
    }

    private c p(int n2, int n3, char c2) throws IOException {
        int n4 = this.T();
        if (n4 != n3 && n4 != n2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.o == null) {
            this.j = -1 + this.j;
            if (n4 == n3) {
                this.L();
            }
            this.h.write((int)c2);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dangling name: ");
        stringBuilder.append(this.o);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final boolean B() {
        return this.n;
    }

    public boolean D() {
        return this.m;
    }

    public c E(String string) throws IOException {
        Objects.requireNonNull((Object)string, (String)"name == null");
        if (this.o == null) {
            if (this.j != 0) {
                this.o = string;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public c P() throws IOException {
        if (this.o != null) {
            if (this.p) {
                this.l0();
            } else {
                this.o = null;
                return this;
            }
        }
        this.b();
        this.h.write("null");
        return this;
    }

    public final void b0(boolean bl) {
        this.n = bl;
    }

    public final void c0(String string) {
        if (string.length() == 0) {
            this.k = null;
            this.l = ":";
            return;
        }
        this.k = string;
        this.l = ": ";
    }

    public void close() throws IOException {
        this.h.close();
        int n2 = this.j;
        if (n2 <= 1 && (n2 != 1 || this.i[n2 - 1] == 7)) {
            this.j = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final void d0(boolean bl) {
        this.m = bl;
    }

    public final void e0(boolean bl) {
        this.p = bl;
    }

    public void flush() throws IOException {
        if (this.j != 0) {
            this.h.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c g0(long l2) throws IOException {
        this.l0();
        this.b();
        this.h.write(Long.toString((long)l2));
        return this;
    }

    public c h0(Boolean bl) throws IOException {
        if (bl == null) {
            return this.P();
        }
        this.l0();
        this.b();
        Writer writer = this.h;
        String string = bl != false ? "true" : "false";
        writer.write(string);
        return this;
    }

    public c i() throws IOException {
        this.l0();
        return this.Q(1, '[');
    }

    public c i0(Number number) throws IOException {
        if (number == null) {
            return this.P();
        }
        this.l0();
        String string = number.toString();
        if (!this.m && (string.equals((Object)"-Infinity") || string.equals((Object)"Infinity") || string.equals((Object)"NaN"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append((Object)number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.b();
        this.h.append((CharSequence)string);
        return this;
    }

    public c j0(String string) throws IOException {
        if (string == null) {
            return this.P();
        }
        this.l0();
        this.b();
        this.f0(string);
        return this;
    }

    public c k0(boolean bl) throws IOException {
        this.l0();
        this.b();
        Writer writer = this.h;
        String string = bl ? "true" : "false";
        writer.write(string);
        return this;
    }

    public c o() throws IOException {
        this.l0();
        return this.Q(3, '{');
    }

    public c t() throws IOException {
        return this.p(1, 2, ']');
    }

    public c u() throws IOException {
        return this.p(3, 5, '}');
    }

    public final boolean w() {
        return this.p;
    }
}

