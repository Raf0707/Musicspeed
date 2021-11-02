/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.Comparator
 */
package b.g.b;

import b.g.b.b;
import b.g.b.c;
import b.g.b.d;
import b.g.b.h;
import b.g.b.i;
import java.util.Arrays;
import java.util.Comparator;

public class h
extends b.g.b.b {
    private int g = 128;
    private i[] h = new i[128];
    private i[] i = new i[128];
    private int j = 0;
    b k = new Comparable(this){
        i f;
        h g;
        {
            this.g = h3;
        }

        public boolean a(i i2, float f2) {
            boolean bl = this.f.b;
            boolean bl2 = true;
            if (bl) {
                for (int i3 = 0; i3 < 9; ++i3) {
                    float[] arrf = this.f.j;
                    arrf[i3] = arrf[i3] + f2 * i2.j[i3];
                    if (Math.abs((float)arrf[i3]) < 1.0E-4f) {
                        this.f.j[i3] = 0.0f;
                        continue;
                    }
                    bl2 = false;
                }
                if (bl2) {
                    h.this.G(this.f);
                }
                return false;
            }
            for (int i4 = 0; i4 < 9; ++i4) {
                float f3 = i2.j[i4];
                if (f3 != 0.0f) {
                    float f4 = f3 * f2;
                    if (Math.abs((float)f4) < 1.0E-4f) {
                        f4 = 0.0f;
                    }
                    this.f.j[i4] = f4;
                    continue;
                }
                this.f.j[i4] = 0.0f;
            }
            return bl2;
        }

        public void b(i i2) {
            this.f = i2;
        }

        public final boolean c() {
            for (int i2 = 8; i2 >= 0; --i2) {
                float f2 = this.f.j[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (!(f2 < 0.0f)) continue;
                return true;
            }
            return false;
        }

        public int compareTo(Object object) {
            i i2 = (i)object;
            return this.f.d - i2.d;
        }

        public final boolean d(i i2) {
            for (int i3 = 8; i3 >= 0; --i3) {
                float f2 = this.f.j[i3];
                float f3 = i2.j[i3];
                if (f2 == f3) {
                    continue;
                }
                if (!(f2 < f3)) break;
                return true;
            }
            return false;
        }

        public void e() {
            Arrays.fill((float[])this.f.j, (float)0.0f);
        }

        public String toString() {
            i i2 = this.f;
            String string = "[ ";
            if (i2 != null) {
                for (int i3 = 0; i3 < 9; ++i3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append(this.f.j[i3]);
                    stringBuilder.append(" ");
                    string = stringBuilder.toString();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("] ");
            stringBuilder.append((Object)this.f);
            return stringBuilder.toString();
        }
    };
    c l;

    public h(c c2) {
        super(c2);
        this.l = c2;
    }

    private final void F(i i2) {
        int n2;
        int n3 = 1 + this.j;
        Object[] arrobject = this.h;
        if (n3 > arrobject.length) {
            Object[] arrobject2 = (i[])Arrays.copyOf((Object[])arrobject, (int)(2 * arrobject.length));
            this.h = arrobject2;
            this.i = (i[])Arrays.copyOf((Object[])arrobject2, (int)(2 * arrobject2.length));
        }
        i[] arri = this.h;
        int n4 = this.j;
        arri[n4] = i2;
        this.j = n2 = n4 + 1;
        if (n2 > 1 && arri[n2 - 1].d > i2.d) {
            int n5;
            int n6 = 0;
            for (int i3 = 0; i3 < (n5 = this.j); ++i3) {
                this.i[i3] = this.h[i3];
            }
            Arrays.sort((Object[])this.i, (int)0, (int)n5, (Comparator)new Comparator<i>(this){
                final /* synthetic */ h f;
                {
                    this.f = h2;
                }

                public int a(i i2, i i3) {
                    return i2.d - i3.d;
                }
            });
            while (n6 < this.j) {
                this.h[n6] = this.i[n6];
                ++n6;
            }
        }
        i2.b = true;
        i2.a(this);
    }

    private final void G(i i2) {
        for (int i3 = 0; i3 < this.j; ++i3) {
            int n2;
            if (this.h[i3] != i2) continue;
            while (i3 < (n2 = this.j) - 1) {
                i[] arri = this.h;
                int n3 = i3 + 1;
                arri[i3] = arri[n3];
                i3 = n3;
            }
            this.j = n2 - 1;
            i2.b = false;
            return;
        }
    }

    @Override
    public void B(d d2, b.g.b.b b2, boolean bl) {
        i i2 = b2.a;
        if (i2 == null) {
            return;
        }
        b.a a2 = b2.e;
        int n2 = a2.a();
        for (int i3 = 0; i3 < n2; ++i3) {
            i i4 = a2.b(i3);
            float f2 = a2.d(i3);
            this.k.b(i4);
            if (this.k.a(i2, f2)) {
                this.F(i4);
            }
            this.b += f2 * b2.b;
        }
        this.G(i2);
    }

    @Override
    public void a(i i2) {
        this.k.b(i2);
        this.k.e();
        i2.j[i2.f] = 1.0f;
        this.F(i2);
    }

    @Override
    public i b(d d2, boolean[] arrbl) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.j; ++i2) {
            i i3 = this.h[i2];
            if (arrbl[i3.d]) continue;
            this.k.b(i3);
            if (!(n2 == -1 ? this.k.c() : this.k.d(this.h[n2]))) continue;
            n2 = i2;
        }
        if (n2 == -1) {
            return null;
        }
        return this.h[n2];
    }

    @Override
    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    @Override
    public boolean isEmpty() {
        return this.j == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(" goal -> (");
        stringBuilder.append(this.b);
        stringBuilder.append(") : ");
        String string = stringBuilder.toString();
        for (int i2 = 0; i2 < this.j; ++i2) {
            i i3 = this.h[i2];
            this.k.b(i3);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append((Object)this.k);
            stringBuilder2.append(" ");
            string = stringBuilder2.toString();
        }
        return string;
    }

}

