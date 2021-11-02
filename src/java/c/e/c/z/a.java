/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.c.z.a$a
 *  com.google.gson.internal.e
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.Objects
 */
package c.e.c.z;

import c.e.c.z.a;
import c.e.c.z.b;
import c.e.c.z.d;
import com.google.gson.internal.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

public class a
implements Closeable {
    private static final char[] f = ")]}'\n".toCharArray();
    private final Reader g;
    private boolean h = false;
    private final char[] i = new char[1024];
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    int n = 0;
    private long o;
    private int p;
    private String q;
    private int[] r;
    private int s;
    private String[] t;
    private int[] u;

    static {
        e.a = new a();
    }

    public a(Reader reader) {
        int[] arrn = new int[32];
        this.r = arrn;
        this.s = 0;
        this.s = 0 + 1;
        arrn[0] = 6;
        this.t = new String[32];
        this.u = new int[32];
        Objects.requireNonNull((Object)reader, (String)"in == null");
        this.g = reader;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean E(char var1_1) throws IOException {
        if (var1_1 == '\t') return false;
        if (var1_1 == '\n') return false;
        if (var1_1 == '\f') return false;
        if (var1_1 == '\r') return false;
        if (var1_1 == ' ') return false;
        if (var1_1 == '#') ** GOTO lbl-1000
        if (var1_1 == ',') return false;
        if (var1_1 == '/' || var1_1 == '=') ** GOTO lbl-1000
        if (var1_1 == '{') return false;
        if (var1_1 == '}') return false;
        if (var1_1 == ':') return false;
        if (var1_1 == ';') ** GOTO lbl-1000
        switch (var1_1) {
            default: {
                return true;
            }
            case '\\': lbl-1000: // 4 sources:
            {
                this.i();
            }
            case '[': 
            case ']': 
        }
        return false;
    }

    private int b0(boolean bl) throws IOException {
        char[] arrc = this.i;
        int n2 = this.j;
        int n3 = this.k;
        do {
            if (n2 == n3) {
                this.j = n2;
                if (!this.w(1)) {
                    if (!bl) {
                        return -1;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("End of input");
                    stringBuilder.append(this.L());
                    throw new EOFException(stringBuilder.toString());
                }
                n2 = this.j;
                n3 = this.k;
            }
            int n4 = n2 + 1;
            char c2 = arrc[n2];
            if (c2 == '\n') {
                this.l = 1 + this.l;
                this.m = n4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.j = n4;
                    if (n4 == n3) {
                        this.j = n4 - 1;
                        boolean bl2 = this.w(2);
                        this.j = 1 + this.j;
                        if (!bl2) {
                            return c2;
                        }
                    }
                    this.i();
                    int n5 = this.j;
                    char c3 = arrc[n5];
                    if (c3 != '*') {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.j = n5 + 1;
                        this.o0();
                        n2 = this.j;
                        n3 = this.k;
                        continue;
                    }
                    this.j = n5 + 1;
                    if (this.n0("*/")) {
                        n2 = 2 + this.j;
                        n3 = this.k;
                        continue;
                    }
                    throw this.r0("Unterminated comment");
                }
                if (c2 == '#') {
                    this.j = n4;
                    this.i();
                    this.o0();
                    n2 = this.j;
                    n3 = this.k;
                    continue;
                }
                this.j = n4;
                return c2;
            }
            n2 = n4;
        } while (true);
    }

    private String d0(char c2) throws IOException {
        char[] arrc = this.i;
        StringBuilder stringBuilder = null;
        do {
            int n2;
            int n3 = this.j;
            int n4 = this.k;
            block1 : do {
                int n5 = n4;
                n2 = n3;
                while (n3 < n5) {
                    int n6 = n3 + 1;
                    char c3 = arrc[n3];
                    if (c3 == c2) {
                        this.j = n6;
                        int n7 = n6 - n2 - 1;
                        if (stringBuilder == null) {
                            return new String(arrc, n2, n7);
                        }
                        stringBuilder.append(arrc, n2, n7);
                        return stringBuilder.toString();
                    }
                    if (c3 == '\\') {
                        this.j = n6;
                        int n8 = n6 - n2 - 1;
                        if (stringBuilder == null) {
                            stringBuilder = new StringBuilder(Math.max((int)(2 * (n8 + 1)), (int)16));
                        }
                        stringBuilder.append(arrc, n2, n8);
                        stringBuilder.append(this.k0());
                        n3 = this.j;
                        n4 = this.k;
                        continue block1;
                    }
                    if (c3 == '\n') {
                        this.l = 1 + this.l;
                        this.m = n6;
                    }
                    n3 = n6;
                }
                break;
            } while (true);
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(Math.max((int)(2 * (n3 - n2)), (int)16));
            }
            stringBuilder.append(arrc, n2, n3 - n2);
            this.j = n3;
        } while (this.w(1));
        throw this.r0("Unterminated string");
    }

    /*
     * Exception decompiling
     */
    private String f0() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    private int h0() throws IOException {
        int n2;
        String string;
        String string2;
        char c2 = this.i[this.j];
        if (c2 != 't' && c2 != 'T') {
            if (c2 != 'f' && c2 != 'F') {
                if (c2 != 'n' && c2 != 'N') {
                    return 0;
                }
                n2 = 7;
                string = "null";
                string2 = "NULL";
            } else {
                n2 = 6;
                string = "false";
                string2 = "FALSE";
            }
        } else {
            n2 = 5;
            string = "true";
            string2 = "TRUE";
        }
        int n3 = string.length();
        for (int i2 = 1; i2 < n3; ++i2) {
            if (i2 + this.j >= this.k && !this.w(i2 + 1)) {
                return 0;
            }
            char c3 = this.i[i2 + this.j];
            if (c3 == string.charAt(i2) || c3 == string2.charAt(i2)) continue;
            return 0;
        }
        if ((n3 + this.j < this.k || this.w(n3 + 1)) && this.E(this.i[n3 + this.j])) {
            return 0;
        }
        this.j = n3 + this.j;
        this.n = n2;
        return n2;
    }

    private void i() throws IOException {
        if (this.h) {
            return;
        }
        throw this.r0("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private int i0() throws IOException {
        char[] arrc = this.i;
        int n2 = this.j;
        int n3 = this.k;
        int n4 = 0;
        int n5 = 0;
        boolean bl = true;
        long l2 = 0L;
        boolean bl2 = false;
        do {
            block26 : {
                block30 : {
                    block21 : {
                        block22 : {
                            block29 : {
                                block23 : {
                                    block28 : {
                                        block24 : {
                                            block27 : {
                                                block20 : {
                                                    char c2;
                                                    block25 : {
                                                        block19 : {
                                                            if (n2 + n4 != n3) break block19;
                                                            if (n4 == arrc.length) {
                                                                return 0;
                                                            }
                                                            if (!this.w(n4 + 1)) break block20;
                                                            n2 = this.j;
                                                            n3 = this.k;
                                                        }
                                                        if ((c2 = arrc[n2 + n4]) == '+') break block21;
                                                        if (c2 == 'E' || c2 == 'e') break block22;
                                                        if (c2 == '-') break block23;
                                                        if (c2 == '.') break block24;
                                                        if (c2 < '0' || c2 > '9') break block25;
                                                        if (n5 != 1 && n5 != 0) {
                                                            if (n5 == 2) {
                                                                if (l2 == 0L) {
                                                                    return 0;
                                                                }
                                                                long l3 = 10L * l2 - (long)(c2 - 48);
                                                                long l4 = l2 LCMP -922337203685477580L;
                                                                boolean bl3 = l4 > 0 || l4 == false && l3 < l2;
                                                                bl &= bl3;
                                                                l2 = l3;
                                                            } else if (n5 == 3) {
                                                                n5 = 4;
                                                            } else if (n5 == 5 || n5 == 6) {
                                                                n5 = 7;
                                                            }
                                                        } else {
                                                            l2 = -(c2 - 48);
                                                            n5 = 2;
                                                        }
                                                        break block26;
                                                    }
                                                    if (this.E(c2)) break block27;
                                                }
                                                if (!(n5 != 2 || !bl || l2 == Long.MIN_VALUE && !bl2 || l2 == 0L && bl2)) {
                                                    if (!bl2) {
                                                        l2 = -l2;
                                                    }
                                                    this.o = l2;
                                                    this.j = n4 + this.j;
                                                    this.n = 15;
                                                    return 15;
                                                }
                                                if (n5 != 2 && n5 != 4 && n5 != 7) {
                                                    return 0;
                                                }
                                                this.p = n4;
                                                this.n = 16;
                                                return 16;
                                            }
                                            return 0;
                                        }
                                        if (n5 != 2) break block28;
                                        n5 = 3;
                                        break block26;
                                    }
                                    return 0;
                                }
                                if (n5 != 0) break block29;
                                n5 = 1;
                                bl2 = true;
                                break block26;
                            }
                            if (n5 != 5) {
                                return 0;
                            }
                            break block30;
                        }
                        if (n5 != 2 && n5 != 4) {
                            return 0;
                        }
                        n5 = 5;
                        break block26;
                    }
                    if (n5 != 5) break;
                }
                n5 = 6;
            }
            ++n4;
        } while (true);
        return 0;
    }

    private void j0(int n2) {
        int n3 = this.s;
        int[] arrn = this.r;
        if (n3 == arrn.length) {
            int n4 = n3 * 2;
            this.r = Arrays.copyOf((int[])arrn, (int)n4);
            this.u = Arrays.copyOf((int[])this.u, (int)n4);
            this.t = (String[])Arrays.copyOf((Object[])this.t, (int)n4);
        }
        int[] arrn2 = this.r;
        int n5 = this.s;
        this.s = n5 + 1;
        arrn2[n5] = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private char k0() throws IOException {
        block16 : {
            char c2;
            block15 : {
                int n2;
                block14 : {
                    if (this.j == this.k && !this.w(1)) {
                        throw this.r0("Unterminated escape sequence");
                    }
                    char[] arrc = this.i;
                    int n3 = this.j;
                    this.j = n2 = n3 + 1;
                    c2 = arrc[n3];
                    if (c2 == '\n') break block14;
                    if (c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\') break block15;
                    if (c2 == 'b') {
                        return '\b';
                    }
                    if (c2 == 'f') {
                        return '\f';
                    }
                    if (c2 == 'n') {
                        return '\n';
                    }
                    if (c2 == 'r') {
                        return '\r';
                    }
                    if (c2 == 't') {
                        return '\t';
                    }
                    if (c2 != 'u') {
                        throw this.r0("Invalid escape sequence");
                    }
                    if (n2 + 4 > this.k && !this.w(4)) {
                        throw this.r0("Unterminated escape sequence");
                    }
                    break block16;
                }
                this.l = 1 + this.l;
                this.m = n2;
            }
            return c2;
        }
        char c3 = '\u0000';
        int n4 = this.j;
        int n5 = n4 + 4;
        do {
            int n6;
            if (n4 >= n5) {
                this.j = 4 + this.j;
                return c3;
            }
            char c4 = this.i[n4];
            char c5 = (char)(c3 << 4);
            if (c4 >= '0' && c4 <= '9') {
                n6 = c4 - 48;
            } else {
                int n7;
                if (c4 >= 'a' && c4 <= 'f') {
                    n7 = c4 - 97;
                } else {
                    if (c4 < 'A' || c4 > 'F') break;
                    n7 = c4 - 65;
                }
                n6 = n7 + 10;
            }
            c3 = (char)(c5 + n6);
            ++n4;
        } while (true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\u");
        stringBuilder.append(new String(this.i, this.j, 4));
        throw new NumberFormatException(stringBuilder.toString());
    }

    private void m0(char c2) throws IOException {
        char[] arrc = this.i;
        do {
            int n2 = this.j;
            int n3 = this.k;
            while (n2 < n3) {
                int n4 = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    this.j = n4;
                    return;
                }
                if (c3 == '\\') {
                    this.j = n4;
                    this.k0();
                    n2 = this.j;
                    n3 = this.k;
                    continue;
                }
                if (c3 == '\n') {
                    this.l = 1 + this.l;
                    this.m = n4;
                }
                n2 = n4;
            }
            this.j = n2;
        } while (this.w(1));
        throw this.r0("Unterminated string");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean n0(String var1_1) throws IOException {
        var2_2 = var1_1.length();
        block0 : do {
            block6 : {
                if (var2_2 + this.j > this.k) {
                    if (this.w(var2_2) == false) return false;
                }
                var3_3 = this.i;
                var4_4 = this.j;
                var5_5 = var3_3[var4_4];
                var6_6 = 0;
                if (var5_5 != '\n') break block6;
                this.l = 1 + this.l;
                this.m = var4_4 + 1;
                ** GOTO lbl16
            }
            while (var6_6 < var2_2) {
                block7 : {
                    if (this.i[var6_6 + this.j] == var1_1.charAt(var6_6)) break block7;
lbl16: // 2 sources:
                    this.j = 1 + this.j;
                    continue block0;
                }
                ++var6_6;
            }
            return true;
            break;
        } while (true);
    }

    private void o() throws IOException {
        int n2;
        char[] arrc;
        this.b0(true);
        this.j = n2 = this.j - 1;
        char[] arrc2 = f;
        if (n2 + arrc2.length > this.k && !this.w(arrc2.length)) {
            return;
        }
        for (int i2 = 0; i2 < (arrc = f).length; ++i2) {
            if (this.i[i2 + this.j] == arrc[i2]) continue;
            return;
        }
        this.j += arrc.length;
    }

    private void o0() throws IOException {
        while (this.j < this.k || this.w(1)) {
            int n2;
            char[] arrc = this.i;
            int n3 = this.j;
            this.j = n2 = n3 + 1;
            char c2 = arrc[n3];
            if (c2 == '\n') {
                this.l = 1 + this.l;
                this.m = n2;
                return;
            }
            if (c2 != '\r') continue;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void p0() throws IOException {
        do {
            var1_1 = 0;
            block5 : while ((var2_2 = this.j) + var1_1 < this.k) {
                block6 : {
                    var3_3 = this.i[var2_2 + var1_1];
                    if (var3_3 == '\t' || var3_3 == '\n' || var3_3 == '\f' || var3_3 == '\r' || var3_3 == ' ') break block6;
                    if (var3_3 == '#') ** GOTO lbl-1000
                    if (var3_3 == ',') break block6;
                    if (var3_3 == '/' || var3_3 == '=') ** GOTO lbl-1000
                    if (var3_3 == '{' || var3_3 == '}' || var3_3 == ':') break block6;
                    if (var3_3 == ';') ** GOTO lbl-1000
                    switch (var3_3) {
                        default: {
                            ++var1_1;
                            continue block5;
                        }
                        case '\\': lbl-1000: // 4 sources:
                        {
                            this.i();
                        }
                        case '[': 
                        case ']': 
                    }
                }
                this.j = var1_1 + this.j;
                return;
            }
            this.j = var2_2 + var1_1;
        } while (this.w(1));
    }

    private IOException r0(String string) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(this.L());
        throw new d(stringBuilder.toString());
    }

    private boolean w(int n2) throws IOException {
        Reader reader;
        int n3;
        int n4;
        char[] arrc = this.i;
        int n5 = this.m;
        int n6 = this.j;
        this.m = n5 - n6;
        int n7 = this.k;
        if (n7 != n6) {
            int n8;
            this.k = n8 = n7 - n6;
            System.arraycopy((Object)arrc, (int)n6, (Object)arrc, (int)0, (int)n8);
        } else {
            this.k = 0;
        }
        this.j = 0;
        while ((n3 = (reader = this.g).read(arrc, n4 = this.k, arrc.length - n4)) != -1) {
            int n9;
            int n10;
            this.k = n9 = n3 + this.k;
            if (this.l == 0 && (n10 = this.m) == 0 && n9 > 0 && arrc[0] == '\ufeff') {
                this.j = 1 + this.j;
                this.m = n10 + 1;
                ++n2;
            }
            if (n9 < n2) continue;
            return true;
        }
        return false;
    }

    public boolean B() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        return n2 != 2 && n2 != 4;
    }

    public final boolean D() {
        return this.h;
    }

    String L() {
        int n2 = 1 + this.l;
        int n3 = 1 + (this.j - this.m);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at line ");
        stringBuilder.append(n2);
        stringBuilder.append(" column ");
        stringBuilder.append(n3);
        stringBuilder.append(" path ");
        stringBuilder.append(this.R());
        return stringBuilder.toString();
    }

    public boolean P() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 5) {
            this.n = 0;
            int[] arrn = this.u;
            int n3 = this.s - 1;
            arrn[n3] = 1 + arrn[n3];
            return true;
        }
        if (n2 == 6) {
            this.n = 0;
            int[] arrn = this.u;
            int n4 = this.s - 1;
            arrn[n4] = 1 + arrn[n4];
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public double Q() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 15) {
            this.n = 0;
            int[] arrn = this.u;
            int n3 = -1 + this.s;
            arrn[n3] = 1 + arrn[n3];
            return this.o;
        }
        if (n2 == 16) {
            this.q = new String(this.i, this.j, this.p);
            this.j += this.p;
        } else if (n2 != 8 && n2 != 9) {
            if (n2 == 10) {
                this.q = this.f0();
            } else if (n2 != 11) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a double but was ");
                stringBuilder.append((Object)this.g0());
                stringBuilder.append(this.L());
                throw new IllegalStateException(stringBuilder.toString());
            }
        } else {
            char c2 = n2 == 8 ? (char)'\'' : '\"';
            this.q = this.d0(c2);
        }
        this.n = 11;
        double d2 = Double.parseDouble((String)this.q);
        if (!this.h && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            stringBuilder.append(this.L());
            throw new d(stringBuilder.toString());
        }
        this.q = null;
        this.n = 0;
        int[] arrn = this.u;
        int n4 = -1 + this.s;
        arrn[n4] = 1 + arrn[n4];
        return d2;
    }

    public String R() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        int n2 = this.s;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.r[i2];
            if (n3 != 1 && n3 != 2) {
                if (n3 != 3 && n3 != 4 && n3 != 5) continue;
                stringBuilder.append('.');
                String[] arrstring = this.t;
                if (arrstring[i2] == null) continue;
                stringBuilder.append(arrstring[i2]);
                continue;
            }
            stringBuilder.append('[');
            stringBuilder.append(this.u[i2]);
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public int T() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl170.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public long X() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl136.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public void a() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 3) {
            this.j0(1);
            this.u[this.s - 1] = 0;
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String a0() throws IOException {
        block7 : {
            String string;
            block5 : {
                int n2;
                block6 : {
                    block4 : {
                        n2 = this.n;
                        if (n2 == 0) {
                            n2 = this.p();
                        }
                        if (n2 != 14) break block4;
                        string = this.f0();
                        break block5;
                    }
                    if (n2 != 12) break block6;
                    string = this.d0('\'');
                    break block5;
                }
                if (n2 != 13) break block7;
                string = this.d0('\"');
            }
            this.n = 0;
            this.t[-1 + this.s] = string;
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a name but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void b() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 1) {
            this.j0(3);
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void c0() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 7) {
            this.n = 0;
            int[] arrn = this.u;
            int n3 = -1 + this.s;
            arrn[n3] = 1 + arrn[n3];
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void close() throws IOException {
        this.n = 0;
        this.r[0] = 8;
        this.s = 1;
        this.g.close();
    }

    public String e0() throws IOException {
        block10 : {
            String string;
            block5 : {
                int n2;
                block9 : {
                    block8 : {
                        block7 : {
                            block6 : {
                                block4 : {
                                    n2 = this.n;
                                    if (n2 == 0) {
                                        n2 = this.p();
                                    }
                                    if (n2 != 10) break block4;
                                    string = this.f0();
                                    break block5;
                                }
                                if (n2 != 8) break block6;
                                string = this.d0('\'');
                                break block5;
                            }
                            if (n2 != 9) break block7;
                            string = this.d0('\"');
                            break block5;
                        }
                        if (n2 != 11) break block8;
                        string = this.q;
                        this.q = null;
                        break block5;
                    }
                    if (n2 != 15) break block9;
                    string = Long.toString((long)this.o);
                    break block5;
                }
                if (n2 != 16) break block10;
                string = new String(this.i, this.j, this.p);
                this.j += this.p;
            }
            this.n = 0;
            int[] arrn = this.u;
            int n3 = -1 + this.s;
            arrn[n3] = 1 + arrn[n3];
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a string but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public b g0() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return b.o;
            }
            case 15: 
            case 16: {
                return b.l;
            }
            case 12: 
            case 13: 
            case 14: {
                return b.j;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return b.k;
            }
            case 7: {
                return b.n;
            }
            case 5: 
            case 6: {
                return b.m;
            }
            case 4: {
                return b.g;
            }
            case 3: {
                return b.f;
            }
            case 2: {
                return b.i;
            }
            case 1: 
        }
        return b.h;
    }

    public final void l0(boolean bl) {
        this.h = bl;
    }

    int p() throws IOException {
        int n2;
        int n3;
        int n4;
        block32 : {
            block37 : {
                block30 : {
                    block36 : {
                        block35 : {
                            block33 : {
                                block34 : {
                                    char[] arrc;
                                    int n5;
                                    block31 : {
                                        block29 : {
                                            int[] arrn = this.r;
                                            int n6 = this.s;
                                            n3 = arrn[n6 - 1];
                                            if (n3 != 1) break block29;
                                            arrn[n6 - 1] = 2;
                                            break block30;
                                        }
                                        if (n3 != 2) break block31;
                                        int n7 = this.b0(true);
                                        if (n7 != 44) {
                                            if (n7 != 59) {
                                                if (n7 == 93) {
                                                    this.n = 4;
                                                    return 4;
                                                }
                                                throw this.r0("Unterminated array");
                                            }
                                            this.i();
                                        }
                                        break block30;
                                    }
                                    if (n3 == 3 || n3 == 5) break block32;
                                    if (n3 != 4) break block33;
                                    arrn[n6 - 1] = 5;
                                    int n8 = this.b0(true);
                                    if (n8 == 58) break block30;
                                    if (n8 != 61) break block34;
                                    this.i();
                                    if ((this.j < this.k || this.w(1)) && (arrc = this.i)[n5 = this.j] == '>') {
                                        this.j = n5 + 1;
                                    }
                                    break block30;
                                }
                                throw this.r0("Expected ':'");
                            }
                            if (n3 != 6) break block35;
                            if (this.h) {
                                this.o();
                            }
                            this.r[this.s - 1] = 7;
                            break block30;
                        }
                        if (n3 != 7) break block36;
                        if (this.b0(false) == -1) {
                            this.n = 17;
                            return 17;
                        }
                        this.i();
                        --this.j;
                        break block30;
                    }
                    if (n3 == 8) break block37;
                }
                int n9 = this.b0(true);
                if (n9 != 34) {
                    if (n9 != 39) {
                        if (n9 != 44 && n9 != 59) {
                            if (n9 != 91) {
                                if (n9 != 93) {
                                    if (n9 != 123) {
                                        --this.j;
                                        int n10 = this.h0();
                                        if (n10 != 0) {
                                            return n10;
                                        }
                                        int n11 = this.i0();
                                        if (n11 != 0) {
                                            return n11;
                                        }
                                        if (this.E(this.i[this.j])) {
                                            this.i();
                                            this.n = 10;
                                            return 10;
                                        }
                                        throw this.r0("Expected value");
                                    }
                                    this.n = 1;
                                    return 1;
                                }
                                if (n3 == 1) {
                                    this.n = 4;
                                    return 4;
                                }
                            } else {
                                this.n = 3;
                                return 3;
                            }
                        }
                        if (n3 != 1 && n3 != 2) {
                            throw this.r0("Unexpected value");
                        }
                        this.i();
                        --this.j;
                        this.n = 7;
                        return 7;
                    }
                    this.i();
                    this.n = 8;
                    return 8;
                }
                this.n = 9;
                return 9;
            }
            throw new IllegalStateException("JsonReader is closed");
        }
        arrn[n6 - 1] = 4;
        if (n3 == 5 && (n2 = this.b0(true)) != 44) {
            if (n2 != 59) {
                if (n2 == 125) {
                    this.n = 2;
                    return 2;
                }
                throw this.r0("Unterminated object");
            }
            this.i();
        }
        if ((n4 = this.b0(true)) != 34) {
            if (n4 != 39) {
                if (n4 != 125) {
                    this.i();
                    --this.j;
                    if (this.E((char)n4)) {
                        this.n = 14;
                        return 14;
                    }
                    throw this.r0("Expected name");
                }
                if (n3 != 5) {
                    this.n = 2;
                    return 2;
                }
                throw this.r0("Expected name");
            }
            this.i();
            this.n = 12;
            return 12;
        }
        this.n = 13;
        return 13;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void q0() throws IOException {
        var1_1 = 0;
        do {
            block14 : {
                block15 : {
                    block13 : {
                        block12 : {
                            block11 : {
                                if ((var2_2 = this.n) == 0) {
                                    var2_2 = this.p();
                                }
                                if (var2_2 != 3) break block11;
                                this.j0(1);
                                break block12;
                            }
                            if (var2_2 != 1) break block13;
                            this.j0(3);
                        }
                        ++var1_1;
                        break block14;
                    }
                    if (var2_2 != 4) break block15;
                    --this.s;
                    ** GOTO lbl21
                }
                if (var2_2 == 2) {
                    --this.s;
lbl21: // 2 sources:
                    --var1_1;
                } else if (var2_2 != 14 && var2_2 != 10) {
                    if (var2_2 != 8 && var2_2 != 12) {
                        if (var2_2 != 9 && var2_2 != 13) {
                            if (var2_2 == 16) {
                                this.j += this.p;
                            }
                        } else {
                            this.m0('\"');
                        }
                    } else {
                        this.m0('\'');
                    }
                } else {
                    this.p0();
                }
            }
            this.n = 0;
        } while (var1_1 != 0);
        var3_3 = this.u;
        var4_4 = this.s;
        var5_5 = var4_4 - 1;
        var3_3[var5_5] = 1 + var3_3[var5_5];
        this.t[var4_4 - 1] = "null";
    }

    public void t() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 4) {
            int n3;
            this.s = n3 = -1 + this.s;
            int[] arrn = this.u;
            int n4 = n3 - 1;
            arrn[n4] = 1 + arrn[n4];
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(this.L());
        return stringBuilder.toString();
    }

    public void u() throws IOException {
        int n2 = this.n;
        if (n2 == 0) {
            n2 = this.p();
        }
        if (n2 == 2) {
            int n3;
            this.s = n3 = -1 + this.s;
            this.t[n3] = null;
            int[] arrn = this.u;
            int n4 = n3 - 1;
            arrn[n4] = 1 + arrn[n4];
            this.n = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.g0());
        stringBuilder.append(this.L());
        throw new IllegalStateException(stringBuilder.toString());
    }
}

