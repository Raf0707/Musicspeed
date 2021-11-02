/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.System
 */
package h.b.a;

import h.b.a.a;
import h.b.a.b;
import h.b.a.c;
import h.b.a.d;
import h.b.a.e;
import h.b.a.f;
import h.b.a.j;
import h.b.a.k;
import h.b.a.m;
import h.b.a.o;
import h.b.a.q;
import h.b.a.r;
import h.b.a.t;
import h.b.a.u;

public class g
extends f {
    static final byte[] c;
    private b A;
    private b B;
    private b C;
    private b D;
    private c E;
    private int F;
    private d G;
    int H;
    d I;
    k J;
    k K;
    r L;
    r M;
    private boolean N;
    private boolean O;
    boolean P;
    e d;
    int e;
    int f;
    final d g;
    o[] h;
    int i;
    final o j;
    final o k;
    final o l;
    final o m;
    o[] n;
    private short o;
    private int p;
    private int q;
    String r;
    private int s;
    private int t;
    private int u;
    private int[] v;
    private int w;
    private d x;
    private int y;
    private int z;

    static {
        g.k();
        byte[] arrby = new byte[220];
        for (int i2 = 0; i2 < 220; ++i2) {
            arrby[i2] = (byte)(-65 + "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i2));
        }
        c = arrby;
    }

    public g(int n2) {
        int n3;
        super(327680);
        this.f = n3 = 1;
        this.g = new d();
        o[] arro = new o[256];
        this.h = arro;
        this.i = (int)(0.75 * (double)arro.length);
        this.j = new o();
        this.k = new o();
        this.l = new o();
        this.m = new o();
        boolean bl = (n2 & 1) != 0;
        this.N = bl;
        if ((n2 & 2) == 0) {
            n3 = 0;
        }
        this.O = n3;
    }

    private o A(String string) {
        this.k.e(8, string, null, null);
        o o2 = this.y(this.k);
        if (o2 == null) {
            this.g.c(8, this.N(string));
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.k);
            this.C(o2);
        }
        return o2;
    }

    private void B(int n2, int n3, int n4) {
        this.g.a(n2, n3).i(n4);
    }

    private void C(o o2) {
        if (this.f + this.o > this.i) {
            int n2 = this.h.length;
            int n3 = 1 + n2 * 2;
            o[] arro = new o[n3];
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                o o3 = this.h[i2];
                while (o3 != null) {
                    int n4 = o3.h % n3;
                    o o4 = o3.i;
                    o3.i = arro[n4];
                    arro[n4] = o3;
                    o3 = o4;
                }
            }
            this.h = arro;
            this.i = (int)(0.75 * (double)n3);
        }
        int n5 = o2.h;
        o[] arro = this.h;
        int n6 = n5 % arro.length;
        o2.i = arro[n6];
        arro[n6] = o2;
    }

    private o F(o o2) {
        o[] arro;
        short s2;
        short s3;
        this.o = s3 = (short)(1 + this.o);
        o o3 = new o(s3, this.j);
        this.C(o3);
        if (this.n == null) {
            this.n = new o[16];
        }
        if ((s2 = this.o) == (arro = this.n).length) {
            o[] arro2 = new o[2 * arro.length];
            System.arraycopy((Object)arro, (int)0, (Object)arro2, (int)0, (int)arro.length);
            this.n = arro2;
        }
        this.n[this.o] = o3;
        return o3;
    }

    static /* synthetic */ void k() {
    }

    private o y(o o2) {
        o[] arro = this.h;
        o o3 = arro[o2.h % arro.length];
        while (!(o3 == null || o3.b == o2.b && o2.h(o3))) {
            o3 = o3.i;
        }
        return o3;
    }

    private void z(int n2, int n3, int n4) {
        this.g.c(n2, n3).i(n4);
    }

    int D(String string) {
        this.j.e(30, string, null, null);
        o o2 = this.y(this.j);
        if (o2 == null) {
            o2 = this.F(this.j);
        }
        return o2.a;
    }

    o E(String string) {
        this.k.e(16, string, null, null);
        o o2 = this.y(this.k);
        if (o2 == null) {
            this.g.c(16, this.N(string));
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.k);
            this.C(o2);
        }
        return o2;
    }

    protected String G(String string, String string2) {
        Class class_;
        Class class_2;
        ClassLoader classLoader = g.class.getClassLoader();
        try {
            class_2 = Class.forName((String)string.replace('/', '.'), (boolean)false, (ClassLoader)classLoader);
            class_ = Class.forName((String)string2.replace('/', '.'), (boolean)false, (ClassLoader)classLoader);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.toString());
        }
        if (class_2.isAssignableFrom(class_)) {
            return string;
        }
        if (class_.isAssignableFrom(class_2)) {
            return string2;
        }
        if (!class_2.isInterface() && !class_.isInterface()) {
            while (!(class_2 = class_2.getSuperclass()).isAssignableFrom(class_)) {
            }
            return class_2.getName().replace('.', '/');
        }
        return "java/lang/Object";
    }

    public int H(String string) {
        return this.t((String)string).a;
    }

    public int I(Object object) {
        return this.s((Object)object).a;
    }

    public int J(String string, String string2, String string3) {
        return this.v((String)string, (String)string2, (String)string3).a;
    }

    public int K(int n2, String string, String string2, String string3) {
        return this.q((int)n2, (String)string, (String)string2, (String)string3).a;
    }

    public int L(String string, String string2, String string3, boolean bl) {
        return this.w((String)string, (String)string2, (String)string3, (boolean)bl).a;
    }

    public int M(String string, String string2) {
        return this.u((String)string, (String)string2).a;
    }

    public int N(String string) {
        this.j.e(1, string, null, null);
        o o2 = this.y(this.j);
        if (o2 == null) {
            this.g.e(1).j(string);
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.j);
            this.C(o2);
        }
        return o2.a;
    }

    public byte[] O() {
        if (this.f <= 65535) {
            b b2;
            String string;
            String string2;
            String string3;
            String string4;
            b b3;
            d d2;
            int n2;
            int n3;
            int n4;
            String string5;
            d d3;
            c c2;
            d d4;
            b b4;
            b b5;
            d d5;
            int n5;
            int n6 = 24 + 2 * this.u;
            k k2 = this.J;
            int n7 = 0;
            while (k2 != null) {
                ++n7;
                n6 += k2.e();
                k2 = (k)k2.b;
            }
            r r2 = this.L;
            int n8 = 0;
            while (r2 != null) {
                ++n8;
                n6 += r2.F();
                r2 = (r)r2.b;
            }
            d d6 = this.I;
            if (d6 != null) {
                n6 += 8 + d6.b;
                this.N("BootstrapMethods");
                n2 = 1;
            } else {
                n2 = 0;
            }
            if (this.s != 0) {
                ++n2;
                n6 += 8;
                this.N("Signature");
            }
            if (this.w != 0) {
                ++n2;
                n6 += 8;
                this.N("SourceFile");
            }
            if ((d3 = this.x) != null) {
                ++n2;
                n6 += 6 + d3.b;
                this.N("SourceDebugExtension");
            }
            if (this.y != 0) {
                ++n2;
                n6 += 10;
                this.N("EnclosingMethod");
            }
            if ((131072 & this.p) != 0) {
                ++n2;
                n6 += 6;
                this.N("Deprecated");
            }
            if (((n4 = this.p) & 4096) != 0 && ((65535 & this.e) < 49 || (n4 & 262144) != 0)) {
                ++n2;
                n6 += 6;
                this.N("Synthetic");
            }
            if ((d2 = this.G) != null) {
                ++n2;
                n6 += 8 + d2.b;
                this.N("InnerClasses");
            }
            if ((b2 = this.A) != null) {
                ++n2;
                n6 += 8 + b2.f();
                this.N("RuntimeVisibleAnnotations");
            }
            if ((b4 = this.B) != null) {
                ++n2;
                n6 += 8 + b4.f();
                this.N("RuntimeInvisibleAnnotations");
            }
            if ((b3 = this.C) != null) {
                ++n2;
                n6 += 8 + b3.f();
                this.N("RuntimeVisibleTypeAnnotations");
            }
            if ((b5 = this.D) != null) {
                ++n2;
                n6 += 8 + b5.f();
                this.N("RuntimeInvisibleTypeAnnotations");
            }
            int n9 = n6;
            c c3 = this.E;
            if (c3 != null) {
                int n10 = n2 + c3.a();
                c c4 = this.E;
                string2 = "Deprecated";
                string = "EnclosingMethod";
                string4 = "RuntimeVisibleTypeAnnotations";
                string3 = "RuntimeInvisibleAnnotations";
                string5 = "SourceDebugExtension";
                n9 += c4.b(this, null, 0, -1, -1);
                n2 = n10;
            } else {
                string2 = "Deprecated";
                string = "EnclosingMethod";
                string4 = "RuntimeVisibleTypeAnnotations";
                string3 = "RuntimeInvisibleAnnotations";
                string5 = "SourceDebugExtension";
            }
            d d7 = new d(n9 + this.g.b);
            d7.g(-889275714).g(this.e);
            d d8 = d7.i(this.f);
            d d9 = this.g;
            d8.f(d9.a, 0, d9.b);
            int n11 = this.p;
            d7.i(n11 & (393216 | (n11 & 262144) / 64)).i(this.q).i(this.t);
            d7.i(this.u);
            for (int i2 = 0; i2 < this.u; ++i2) {
                d7.i(this.v[i2]);
            }
            d7.i(n7);
            k k3 = this.J;
            while (k3 != null) {
                k3.f(d7);
                k3 = (k)k3.b;
            }
            d7.i(n8);
            r r3 = this.L;
            while (r3 != null) {
                r3.M(d7);
                r3 = (r)r3.b;
            }
            d7.i(n2);
            if (this.I != null) {
                d7.i(this.N("BootstrapMethods"));
                d7.g(2 + this.I.b).i(this.H);
                d d10 = this.I;
                d7.f(d10.a, 0, d10.b);
            }
            if (this.s != 0) {
                d d11 = d7.i(this.N("Signature"));
                n3 = 2;
                d11.g(n3).i(this.s);
            } else {
                n3 = 2;
            }
            if (this.w != 0) {
                d7.i(this.N("SourceFile")).g(n3).i(this.w);
            }
            if ((d4 = this.x) != null) {
                int n12 = d4.b;
                d7.i(this.N(string5)).g(n12);
                d7.f(this.x.a, 0, n12);
            }
            if (this.y != 0) {
                d7.i(this.N(string)).g(4);
                d7.i(this.y).i(this.z);
            }
            if ((131072 & this.p) != 0) {
                d7.i(this.N(string2)).g(0);
            }
            if (((n5 = this.p) & 4096) != 0 && ((65535 & this.e) < 49 || (n5 & 262144) != 0)) {
                d7.i(this.N("Synthetic")).g(0);
            }
            if (this.G != null) {
                d7.i(this.N("InnerClasses"));
                d7.g(2 + this.G.b).i(this.F);
                d d12 = this.G;
                d7.f(d12.a, 0, d12.b);
            }
            if (this.A != null) {
                d7.i(this.N("RuntimeVisibleAnnotations"));
                this.A.h(d7);
            }
            if (this.B != null) {
                d7.i(this.N(string3));
                this.B.h(d7);
            }
            if (this.C != null) {
                d7.i(this.N(string4));
                this.C.h(d7);
            }
            if (this.D != null) {
                d7.i(this.N("RuntimeInvisibleTypeAnnotations"));
                this.D.h(d7);
            }
            if ((c2 = this.E) != null) {
                d5 = d7;
                c2.c(this, null, 0, -1, -1, d5);
            } else {
                d5 = d7;
            }
            if (this.P) {
                this.A = null;
                this.B = null;
                this.E = null;
                this.F = 0;
                this.G = null;
                this.H = 0;
                this.I = null;
                this.J = null;
                this.K = null;
                this.L = null;
                this.M = null;
                this.N = false;
                this.O = true;
                this.P = false;
                new e(d5.a).m(this, 4);
                return this.O();
            }
            return d5.a;
        }
        throw new RuntimeException("Class file too large!");
    }

    @Override
    public final void a(int n2, int n3, String string, String string2, String string3, String[] arrstring) {
        this.e = n2;
        this.p = n3;
        this.q = this.H(string);
        this.r = string;
        if (string2 != null) {
            this.s = this.N(string2);
        }
        int n4 = string3 == null ? 0 : this.H(string3);
        this.t = n4;
        if (arrstring != null && arrstring.length > 0) {
            int n5;
            this.u = n5 = arrstring.length;
            this.v = new int[n5];
            for (int i2 = 0; i2 < this.u; ++i2) {
                this.v[i2] = this.H(arrstring[i2]);
            }
        }
    }

    @Override
    public final a b(String string, boolean bl) {
        d d2 = new d();
        d2.i(this.N(string)).i(0);
        b b2 = new b(this, true, d2, d2, 2);
        if (bl) {
            b2.i = this.A;
            this.A = b2;
            return b2;
        }
        b2.i = this.B;
        this.B = b2;
        return b2;
    }

    @Override
    public final void c(c c2) {
        c2.c = this.E;
        this.E = c2;
    }

    @Override
    public final void d() {
    }

    @Override
    public final j e(int n2, String string, String string2, String string3, Object object) {
        k k2 = new k(this, n2, string, string2, string3, object);
        return k2;
    }

    @Override
    public final void f(String string, String string2, String string3, int n2) {
        if (this.G == null) {
            this.G = new d();
        }
        o o2 = this.t(string);
        if (o2.c == 0) {
            this.F = 1 + this.F;
            this.G.i(o2.a);
            d d2 = this.G;
            int n3 = string2 == null ? 0 : this.H(string2);
            d2.i(n3);
            d d3 = this.G;
            int n4 = string3 == null ? 0 : this.N(string3);
            d3.i(n4);
            this.G.i(n2);
            o2.c = this.F;
        }
    }

    @Override
    public final q g(int n2, String string, String string2, String string3, String[] arrstring) {
        r r2 = new r(this, n2, string, string2, string3, arrstring, this.N, this.O);
        return r2;
    }

    @Override
    public final void h(String string, String string2, String string3) {
        this.y = this.H(string);
        if (string2 != null && string3 != null) {
            this.z = this.M(string2, string3);
        }
    }

    @Override
    public final void i(String string, String string2) {
        if (string != null) {
            this.w = this.N(string);
        }
        if (string2 != null) {
            this.x = new d().d(string2, 0, Integer.MAX_VALUE);
        }
    }

    @Override
    public final a j(int n2, u u2, String string, boolean bl) {
        d d2 = new d();
        b.g(n2, u2, d2);
        d2.i(this.N(string)).i(0);
        b b2 = new b(this, true, d2, d2, -2 + d2.b);
        if (bl) {
            b2.i = this.C;
            this.C = b2;
            return b2;
        }
        b2.i = this.D;
        this.D = b2;
        return b2;
    }

    int l(int n2, int n3) {
        o o2 = this.k;
        o2.b = 32;
        o2.d = (long)n2 | (long)n3 << 32;
        o2.h = Integer.MAX_VALUE & n3 + (n2 + 32);
        o o3 = this.y(o2);
        if (o3 == null) {
            o[] arro = this.n;
            String string = arro[n2].e;
            String string2 = arro[n3].e;
            this.k.c = this.D(this.G(string, string2));
            o3 = new o(0, this.k);
            this.C(o3);
        }
        return o3.c;
    }

    int m(String string, int n2) {
        o o2 = this.j;
        o2.b = 31;
        o2.c = n2;
        o2.e = string;
        o2.h = Integer.MAX_VALUE & n2 + (31 + string.hashCode());
        o o3 = this.y(this.j);
        if (o3 == null) {
            o3 = this.F(this.j);
        }
        return o3.a;
    }

    o n(double d2) {
        this.j.a(d2);
        o o2 = this.y(this.j);
        if (o2 == null) {
            this.g.e(6).h(this.j.d);
            o2 = new o(this.f, this.j);
            this.f = 2 + this.f;
            this.C(o2);
        }
        return o2;
    }

    o o(float f2) {
        this.j.b(f2);
        o o2 = this.y(this.j);
        if (o2 == null) {
            this.g.e(4).g(this.j.c);
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.j);
            this.C(o2);
        }
        return o2;
    }

    o p(int n2) {
        this.j.c(n2);
        o o2 = this.y(this.j);
        if (o2 == null) {
            this.g.e(3).g(n2);
            int n3 = this.f;
            this.f = n3 + 1;
            o2 = new o(n3, this.j);
            this.C(o2);
        }
        return o2;
    }

    /*
     * Enabled aggressive block sorting
     */
    o q(int n2, String string, String string2, String string3) {
        this.m.e(n2 + 20, string, string2, string3);
        o o2 = this.y(this.m);
        if (o2 == null) {
            int n3;
            if (n2 <= 4) {
                n3 = this.J(string, string2, string3);
            } else {
                boolean bl = n2 == 9;
                n3 = this.L(string, string2, string3, bl);
            }
            this.B(15, n2, n3);
            int n4 = this.f;
            this.f = n4 + 1;
            o2 = new o(n4, this.m);
            this.C(o2);
        }
        return o2;
    }

    o r(long l2) {
        this.j.f(l2);
        o o2 = this.y(this.j);
        if (o2 == null) {
            this.g.e(5).h(l2);
            o2 = new o(this.f, this.j);
            this.f = 2 + this.f;
            this.C(o2);
        }
        return o2;
    }

    o s(Object object) {
        if (object instanceof Integer) {
            return this.p((Integer)object);
        }
        if (object instanceof Byte) {
            return this.p(((Byte)object).intValue());
        }
        if (object instanceof Character) {
            return this.p(((Character)object).charValue());
        }
        if (object instanceof Short) {
            return this.p(((Short)object).intValue());
        }
        if (object instanceof Boolean) {
            return this.p((int)((Boolean)object).booleanValue());
        }
        if (object instanceof Float) {
            return this.o(((Float)object).floatValue());
        }
        if (object instanceof Long) {
            return this.r((Long)object);
        }
        if (object instanceof Double) {
            return this.n((Double)object);
        }
        if (object instanceof String) {
            return this.A((String)object);
        }
        if (object instanceof t) {
            t t2 = (t)object;
            int n2 = t2.o();
            if (n2 == 10) {
                return this.t(t2.l());
            }
            String string = t2.h();
            if (n2 == 11) {
                return this.E(string);
            }
            return this.t(string);
        }
        if (object instanceof m) {
            m m2 = (m)object;
            return this.q(m2.a, m2.b, m2.c, m2.d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("value ");
        stringBuffer.append(object);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    o t(String string) {
        this.k.e(7, string, null, null);
        o o2 = this.y(this.k);
        if (o2 == null) {
            this.g.c(7, this.N(string));
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.k);
            this.C(o2);
        }
        return o2;
    }

    o u(String string, String string2) {
        this.k.e(12, string, string2, null);
        o o2 = this.y(this.k);
        if (o2 == null) {
            this.z(12, this.N(string), this.N(string2));
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.k);
            this.C(o2);
        }
        return o2;
    }

    o v(String string, String string2, String string3) {
        this.l.e(9, string, string2, string3);
        o o2 = this.y(this.l);
        if (o2 == null) {
            this.z(9, this.H(string), this.M(string2, string3));
            int n2 = this.f;
            this.f = n2 + 1;
            o2 = new o(n2, this.l);
            this.C(o2);
        }
        return o2;
    }

    o w(String string, String string2, String string3, boolean bl) {
        int n2 = bl ? 11 : 10;
        this.l.e(n2, string, string2, string3);
        o o2 = this.y(this.l);
        if (o2 == null) {
            this.z(n2, this.H(string), this.M(string2, string3));
            int n3 = this.f;
            this.f = n3 + 1;
            o2 = new o(n3, this.l);
            this.C(o2);
        }
        return o2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    /* varargs */ o x(String var1_1, String var2_2, m var3_3, Object ... var4_4) {
        var5_5 = this.I;
        if (var5_5 == null) {
            this.I = var5_5 = new d();
        }
        var6_6 = var5_5.b;
        var7_7 = var3_3.hashCode();
        var5_5.i(this.K(var3_3.a, var3_3.b, var3_3.c, var3_3.d));
        var9_8 = var4_4.length;
        var5_5.i(var9_8);
        for (var11_9 = 0; var11_9 < var9_8; var7_7 ^= var23_10.hashCode(), ++var11_9) {
            var23_10 = var4_4[var11_9];
            var5_5.i(this.I(var23_10));
        }
        var12_11 = var5_5.a;
        var13_12 = var9_8 + 2 << 1;
        var14_13 = var7_7 & Integer.MAX_VALUE;
        var15_14 = this.h;
        var16_15 = var15_14[var14_13 % var15_14.length];
        block1 : while (var16_15 != null) {
            if (var16_15.b != 33 || var16_15.h != var14_13) ** GOTO lbl24
            var21_16 = var16_15.c;
            for (var22_17 = 0; var22_17 < var13_12; ++var22_17) {
                if (var12_11[var6_6 + var22_17] == var12_11[var21_16 + var22_17]) {
                    continue;
                }
lbl24: // 3 sources:
                var16_15 = var16_15.i;
                continue block1;
            }
        }
        if (var16_15 != null) {
            var17_18 = var16_15.a;
            var5_5.b = var6_6;
        } else {
            var17_18 = this.H;
            this.H = var17_18 + 1;
            var18_19 = new o(var17_18);
            var18_19.d(var6_6, var14_13);
            this.C(var18_19);
        }
        this.l.g(var1_1, var2_2, var17_18);
        var19_20 = this.y(this.l);
        if (var19_20 != null) return var19_20;
        this.z(18, var17_18, this.M(var1_1, var2_2));
        var20_21 = this.f;
        this.f = var20_21 + 1;
        var19_20 = new o(var20_21, this.l);
        this.C(var19_20);
        return var19_20;
    }
}

