/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package b.g.b;

import b.g.b.b;
import b.g.b.c;
import b.g.b.i;
import java.util.Arrays;

public class j
implements b.a {
    private static float a = 0.001f;
    private final int b = -1;
    private int c = 16;
    private int d = 16;
    int[] e = new int[16];
    int[] f = new int[16];
    int[] g = new int[16];
    float[] h = new float[16];
    int[] i = new int[16];
    int[] j = new int[16];
    int k = 0;
    int l = -1;
    private final b m;
    protected final c n;

    j(b b2, c c2) {
        this.m = b2;
        this.n = c2;
        this.clear();
    }

    private void l(i i2, int n2) {
        int[] arrn = this.e;
        int n3 = i2.d % this.d;
        int n4 = arrn[n3];
        if (n4 == -1) {
            arrn[n3] = n2;
        } else {
            int[] arrn2;
            while ((arrn2 = this.f)[n4] != -1) {
                n4 = arrn2[n4];
            }
            arrn2[n4] = n2;
        }
        this.f[n2] = -1;
    }

    private void m(int n2, i i2, float f2) {
        this.g[n2] = i2.d;
        this.h[n2] = f2;
        this.i[n2] = -1;
        this.j[n2] = -1;
        i2.a(this.m);
        i2.n = 1 + i2.n;
        this.k = 1 + this.k;
    }

    private int n() {
        for (int i2 = 0; i2 < this.c; ++i2) {
            if (this.g[i2] != -1) continue;
            return i2;
        }
        return -1;
    }

    private void o() {
        int n2 = 2 * this.c;
        this.g = Arrays.copyOf((int[])this.g, (int)n2);
        this.h = Arrays.copyOf((float[])this.h, (int)n2);
        this.i = Arrays.copyOf((int[])this.i, (int)n2);
        this.j = Arrays.copyOf((int[])this.j, (int)n2);
        this.f = Arrays.copyOf((int[])this.f, (int)n2);
        for (int i2 = this.c; i2 < n2; ++i2) {
            this.g[i2] = -1;
            this.f[i2] = -1;
        }
        this.c = n2;
    }

    private void q(int n2, i i2, float f2) {
        int n3 = this.n();
        this.m(n3, i2, f2);
        if (n2 != -1) {
            this.i[n3] = n2;
            int[] arrn = this.j;
            arrn[n3] = arrn[n2];
            arrn[n2] = n3;
        } else {
            this.i[n3] = -1;
            if (this.k > 0) {
                this.j[n3] = this.l;
                this.l = n3;
            } else {
                this.j[n3] = -1;
            }
        }
        int[] arrn = this.j;
        if (arrn[n3] != -1) {
            this.i[arrn[n3]] = n3;
        }
        this.l(i2, n3);
    }

    private void r(i i2) {
        int[] arrn;
        int[] arrn2 = this.e;
        int n2 = i2.d;
        int n3 = n2 % this.d;
        int n4 = arrn2[n3];
        if (n4 == -1) {
            return;
        }
        if (this.g[n4] == n2) {
            int[] arrn3 = this.f;
            arrn2[n3] = arrn3[n4];
            arrn3[n4] = -1;
            return;
        }
        while ((arrn = this.f)[n4] != -1 && this.g[arrn[n4]] != n2) {
            n4 = arrn[n4];
        }
        int n5 = arrn[n4];
        if (n5 != -1 && this.g[n5] == n2) {
            arrn[n4] = arrn[n5];
            arrn[n5] = -1;
        }
    }

    @Override
    public int a() {
        return this.k;
    }

    @Override
    public i b(int n2) {
        int n3 = this.k;
        if (n3 == 0) {
            return null;
        }
        int n4 = this.l;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (i2 == n2 && n4 != -1) {
                return this.n.d[this.g[n4]];
            }
            if ((n4 = this.j[n4]) != -1) continue;
            return null;
        }
        return null;
    }

    @Override
    public void c() {
        int n2 = this.k;
        int n3 = this.l;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] arrf = this.h;
            arrf[n3] = -1.0f * arrf[n3];
            if ((n3 = this.j[n3]) != -1) continue;
            return;
        }
    }

    @Override
    public void clear() {
        int n2 = this.k;
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = this.b(i2);
            if (i3 == null) continue;
            i3.c(this.m);
        }
        for (int i4 = 0; i4 < this.c; ++i4) {
            this.g[i4] = -1;
            this.f[i4] = -1;
        }
        for (int i5 = 0; i5 < this.d; ++i5) {
            this.e[i5] = -1;
        }
        this.k = 0;
        this.l = -1;
    }

    @Override
    public float d(int n2) {
        int n3 = this.k;
        int n4 = this.l;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (i2 == n2) {
                return this.h[n4];
            }
            if ((n4 = this.j[n4]) == -1) break;
        }
        return 0.0f;
    }

    @Override
    public void e(i i2, float f2, boolean bl) {
        float f3 = a;
        if (f2 > -f3 && f2 < f3) {
            return;
        }
        int n2 = this.p(i2);
        if (n2 == -1) {
            this.i(i2, f2);
            return;
        }
        float[] arrf = this.h;
        arrf[n2] = f2 + arrf[n2];
        float f4 = arrf[n2];
        float f5 = a;
        if (f4 > -f5 && arrf[n2] < f5) {
            arrf[n2] = 0.0f;
            this.j(i2, bl);
        }
    }

    @Override
    public float f(i i2) {
        int n2 = this.p(i2);
        if (n2 != -1) {
            return this.h[n2];
        }
        return 0.0f;
    }

    @Override
    public boolean g(i i2) {
        return this.p(i2) != -1;
    }

    @Override
    public float h(b b2, boolean bl) {
        float f2 = this.f(b2.a);
        this.j(b2.a, bl);
        j j2 = (j)b2.e;
        int n2 = j2.a();
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            int[] arrn = j2.g;
            if (arrn[n4] != -1) {
                float f3 = j2.h[n4];
                this.e(this.n.d[arrn[n4]], f3 * f2, bl);
                ++n3;
            }
            ++n4;
        }
        return f2;
    }

    @Override
    public void i(i i2, float f2) {
        float f3 = a;
        if (f2 > -f3 && f2 < f3) {
            this.j(i2, true);
            return;
        }
        int n2 = this.k;
        int n3 = 0;
        if (n2 == 0) {
            this.m(0, i2, f2);
            this.l(i2, 0);
            this.l = 0;
            return;
        }
        int n4 = this.p(i2);
        if (n4 != -1) {
            this.h[n4] = f2;
            return;
        }
        if (1 + this.k >= this.c) {
            this.o();
        }
        int n5 = this.k;
        int n6 = this.l;
        int n7 = -1;
        while (n3 < n5) {
            int[] arrn = this.g;
            int n8 = arrn[n6];
            int n9 = i2.d;
            if (n8 == n9) {
                this.h[n6] = f2;
                return;
            }
            if (arrn[n6] < n9) {
                n7 = n6;
            }
            if ((n6 = this.j[n6]) == -1) break;
            ++n3;
        }
        this.q(n7, i2, f2);
    }

    @Override
    public float j(i i2, boolean bl) {
        int[] arrn;
        int n2 = this.p(i2);
        if (n2 == -1) {
            return 0.0f;
        }
        this.r(i2);
        float f2 = this.h[n2];
        if (this.l == n2) {
            this.l = this.j[n2];
        }
        this.g[n2] = -1;
        int[] arrn2 = this.i;
        if (arrn2[n2] != -1) {
            int[] arrn3 = this.j;
            arrn3[arrn2[n2]] = arrn3[n2];
        }
        if ((arrn = this.j)[n2] != -1) {
            arrn2[arrn[n2]] = arrn2[n2];
        }
        this.k = -1 + this.k;
        i2.n = -1 + i2.n;
        if (bl) {
            i2.c(this.m);
        }
        return f2;
    }

    @Override
    public void k(float f2) {
        int n2 = this.k;
        int n3 = this.l;
        for (int i2 = 0; i2 < n2; ++i2) {
            float[] arrf = this.h;
            arrf[n3] = arrf[n3] / f2;
            if ((n3 = this.j[n3]) != -1) continue;
            return;
        }
    }

    public int p(i i2) {
        if (this.k != 0) {
            int[] arrn;
            if (i2 == null) {
                return -1;
            }
            int n2 = i2.d;
            int n3 = n2 % this.d;
            int n4 = this.e[n3];
            if (n4 == -1) {
                return -1;
            }
            if (this.g[n4] == n2) {
                return n4;
            }
            while ((arrn = this.f)[n4] != -1 && this.g[arrn[n4]] != n2) {
                n4 = arrn[n4];
            }
            if (arrn[n4] == -1) {
                return -1;
            }
            if (this.g[arrn[n4]] == n2) {
                return arrn[n4];
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.hashCode());
        stringBuilder.append(" { ");
        String string = stringBuilder.toString();
        int n2 = this.k;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2;
            String string3;
            i i3 = this.b(i2);
            if (i3 == null) continue;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append((Object)i3);
            stringBuilder2.append(" = ");
            stringBuilder2.append(this.d(i2));
            stringBuilder2.append(" ");
            String string4 = stringBuilder2.toString();
            int n3 = this.p(i3);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string4);
            stringBuilder3.append("[p: ");
            String string5 = stringBuilder3.toString();
            if (this.i[n3] != -1) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string5);
                stringBuilder4.append((Object)this.n.d[this.g[this.i[n3]]]);
                string3 = stringBuilder4.toString();
            } else {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string5);
                stringBuilder5.append("none");
                string3 = stringBuilder5.toString();
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(string3);
            stringBuilder6.append(", n: ");
            String string6 = stringBuilder6.toString();
            if (this.j[n3] != -1) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append(string6);
                stringBuilder7.append((Object)this.n.d[this.g[this.j[n3]]]);
                string2 = stringBuilder7.toString();
            } else {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(string6);
                stringBuilder8.append("none");
                string2 = stringBuilder8.toString();
            }
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append(string2);
            stringBuilder9.append("]");
            string = stringBuilder9.toString();
        }
        StringBuilder stringBuilder10 = new StringBuilder();
        stringBuilder10.append(string);
        stringBuilder10.append(" }");
        return stringBuilder10.toString();
    }
}

