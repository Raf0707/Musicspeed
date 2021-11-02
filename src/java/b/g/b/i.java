/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  b.g.b.b
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.HashSet
 */
package b.g.b;

import b.g.b.b;
import b.g.b.d;
import java.util.Arrays;
import java.util.HashSet;

public class i {
    private static int a = 1;
    public boolean b;
    private String c;
    public int d = -1;
    int e = -1;
    public int f = 0;
    public float g;
    public boolean h = false;
    float[] i = new float[9];
    float[] j = new float[9];
    a k;
    b[] l = new b[16];
    int m = 0;
    public int n = 0;
    boolean o = false;
    int p = -1;
    float q = 0.0f;
    HashSet<b> r = null;

    public i(a a2, String string) {
        this.k = a2;
    }

    static void b() {
        a = 1 + a;
    }

    public final void a(b b2) {
        int n2;
        for (int i2 = 0; i2 < (n2 = this.m); ++i2) {
            if (this.l[i2] != b2) continue;
            return;
        }
        Object[] arrobject = this.l;
        if (n2 >= arrobject.length) {
            this.l = (b[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
        }
        b[] arrb = this.l;
        int n3 = this.m;
        arrb[n3] = b2;
        this.m = n3 + 1;
    }

    public final void c(b b2) {
        int n2 = this.m;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.l[i2] != b2) continue;
            while (i2 < n2 - 1) {
                b[] arrb = this.l;
                int n3 = i2 + 1;
                arrb[i2] = arrb[n3];
                i2 = n3;
            }
            this.m = -1 + this.m;
            return;
        }
    }

    public void d() {
        this.c = null;
        this.k = a.j;
        this.f = 0;
        this.d = -1;
        this.e = -1;
        this.g = 0.0f;
        this.h = false;
        this.o = false;
        this.p = -1;
        this.q = 0.0f;
        int n2 = this.m;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.l[i2] = null;
        }
        this.m = 0;
        this.n = 0;
        this.b = false;
        Arrays.fill((float[])this.j, (float)0.0f);
    }

    public void e(d d2, float f2) {
        this.g = f2;
        this.h = true;
        this.o = false;
        this.p = -1;
        this.q = 0.0f;
        int n2 = this.m;
        this.e = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.l[i2].A(d2, this, false);
        }
        this.m = 0;
    }

    public void f(a a2, String string) {
        this.k = a2;
    }

    public final void g(d d2, b b2) {
        int n2 = this.m;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.l[i2].B(d2, b2, false);
        }
        this.m = 0;
    }

    public String toString() {
        if (this.c != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(this.c);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        private static final /* synthetic */ a[] k;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            f = a4 = new a();
            g = a3 = new a();
            h = a6 = new a();
            i = a5 = new a();
            j = a2 = new a();
            k = new a[]{a4, a3, a6, a5, a2};
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])k.clone();
        }
    }

}

