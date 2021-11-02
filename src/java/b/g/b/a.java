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

public class a
implements b.a {
    private static float a = 0.001f;
    int b = 0;
    private final b c;
    protected final c d;
    private int e = 8;
    private i f = null;
    private int[] g = new int[8];
    private int[] h = new int[8];
    private float[] i = new float[8];
    private int j = -1;
    private int k = -1;
    private boolean l = false;

    a(b b2, c c2) {
        this.c = b2;
        this.d = c2;
    }

    @Override
    public int a() {
        return this.b;
    }

    @Override
    public i b(int n2) {
        int n3 = this.j;
        for (int i2 = 0; n3 != -1 && i2 < this.b; ++i2) {
            if (i2 == n2) {
                return this.d.d[this.g[n3]];
            }
            n3 = this.h[n3];
        }
        return null;
    }

    @Override
    public void c() {
        int n2 = this.j;
        for (int i2 = 0; n2 != -1 && i2 < this.b; ++i2) {
            float[] arrf = this.i;
            arrf[n2] = -1.0f * arrf[n2];
            n2 = this.h[n2];
        }
    }

    @Override
    public final void clear() {
        int n2 = this.j;
        for (int i2 = 0; n2 != -1 && i2 < this.b; ++i2) {
            i i3 = this.d.d[this.g[n2]];
            if (i3 != null) {
                i3.c(this.c);
            }
            n2 = this.h[n2];
        }
        this.j = -1;
        this.k = -1;
        this.l = false;
        this.b = 0;
    }

    @Override
    public float d(int n2) {
        int n3 = this.j;
        for (int i2 = 0; n3 != -1 && i2 < this.b; ++i2) {
            if (i2 == n2) {
                return this.i[n3];
            }
            n3 = this.h[n3];
        }
        return 0.0f;
    }

    @Override
    public void e(i i2, float f2, boolean bl) {
        int[] arrn;
        int n2;
        int[] arrn2;
        float f3 = a;
        if (f2 > -f3 && f2 < f3) {
            return;
        }
        int n3 = this.j;
        if (n3 == -1) {
            this.j = 0;
            this.i[0] = f2;
            this.g[0] = i2.d;
            this.h[0] = -1;
            i2.n = 1 + i2.n;
            i2.a(this.c);
            this.b = 1 + this.b;
            if (!this.l) {
                int n4;
                this.k = n4 = 1 + this.k;
                int[] arrn3 = this.g;
                if (n4 >= arrn3.length) {
                    this.l = true;
                    this.k = arrn3.length - 1;
                }
            }
            return;
        }
        int n5 = -1;
        for (int i3 = 0; n3 != -1 && i3 < this.b; ++i3) {
            int[] arrn4 = this.g;
            int n6 = arrn4[n3];
            int n7 = i2.d;
            if (n6 == n7) {
                float[] arrf = this.i;
                float f4 = f2 + arrf[n3];
                float f5 = a;
                if (f4 > -f5 && f4 < f5) {
                    f4 = 0.0f;
                }
                arrf[n3] = f4;
                if (f4 == 0.0f) {
                    if (n3 == this.j) {
                        this.j = this.h[n3];
                    } else {
                        int[] arrn5 = this.h;
                        arrn5[n5] = arrn5[n3];
                    }
                    if (bl) {
                        i2.c(this.c);
                    }
                    if (this.l) {
                        this.k = n3;
                    }
                    --i2.n;
                    --this.b;
                }
                return;
            }
            if (arrn4[n3] < n7) {
                n5 = n3;
            }
            n3 = this.h[n3];
        }
        int n8 = this.k;
        int n9 = n8 + 1;
        if (this.l) {
            int[] arrn6 = this.g;
            if (arrn6[n8] != -1) {
                n8 = arrn6.length;
            }
        } else {
            n8 = n9;
        }
        int[] arrn7 = this.g;
        if (n8 >= arrn7.length && this.b < arrn7.length) {
            int[] arrn8;
            for (int i4 = 0; i4 < (arrn8 = this.g).length; ++i4) {
                if (arrn8[i4] != -1) continue;
                n8 = i4;
                break;
            }
        }
        if (n8 >= (arrn = this.g).length) {
            int n10;
            n8 = arrn.length;
            this.e = n10 = 2 * this.e;
            this.l = false;
            this.k = n8 - 1;
            this.i = Arrays.copyOf((float[])this.i, (int)n10);
            this.g = Arrays.copyOf((int[])this.g, (int)this.e);
            this.h = Arrays.copyOf((int[])this.h, (int)this.e);
        }
        this.g[n8] = i2.d;
        this.i[n8] = f2;
        if (n5 != -1) {
            int[] arrn9 = this.h;
            arrn9[n8] = arrn9[n5];
            arrn9[n5] = n8;
        } else {
            this.h[n8] = this.j;
            this.j = n8;
        }
        i2.n = 1 + i2.n;
        i2.a(this.c);
        this.b = 1 + this.b;
        if (!this.l) {
            this.k = 1 + this.k;
        }
        if ((n2 = this.k) >= (arrn2 = this.g).length) {
            this.l = true;
            this.k = arrn2.length - 1;
        }
    }

    @Override
    public final float f(i i2) {
        int n2 = this.j;
        for (int i3 = 0; n2 != -1 && i3 < this.b; ++i3) {
            if (this.g[n2] == i2.d) {
                return this.i[n2];
            }
            n2 = this.h[n2];
        }
        return 0.0f;
    }

    @Override
    public boolean g(i i2) {
        int n2 = this.j;
        if (n2 == -1) {
            return false;
        }
        for (int i3 = 0; n2 != -1 && i3 < this.b; ++i3) {
            if (this.g[n2] == i2.d) {
                return true;
            }
            n2 = this.h[n2];
        }
        return false;
    }

    @Override
    public float h(b b2, boolean bl) {
        float f2 = this.f(b2.a);
        this.j(b2.a, bl);
        b.a a2 = b2.e;
        int n2 = a2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = a2.b(i2);
            this.e(i3, f2 * a2.f(i3), bl);
        }
        return f2;
    }

    @Override
    public final void i(i i2, float f2) {
        int[] arrn;
        int[] arrn2;
        int n2;
        if (f2 == 0.0f) {
            this.j(i2, true);
            return;
        }
        int n3 = this.j;
        if (n3 == -1) {
            this.j = 0;
            this.i[0] = f2;
            this.g[0] = i2.d;
            this.h[0] = -1;
            i2.n = 1 + i2.n;
            i2.a(this.c);
            this.b = 1 + this.b;
            if (!this.l) {
                int n4;
                this.k = n4 = 1 + this.k;
                int[] arrn3 = this.g;
                if (n4 >= arrn3.length) {
                    this.l = true;
                    this.k = arrn3.length - 1;
                }
            }
            return;
        }
        int n5 = -1;
        for (int i3 = 0; n3 != -1 && i3 < this.b; ++i3) {
            int[] arrn4 = this.g;
            int n6 = arrn4[n3];
            int n7 = i2.d;
            if (n6 == n7) {
                this.i[n3] = f2;
                return;
            }
            if (arrn4[n3] < n7) {
                n5 = n3;
            }
            n3 = this.h[n3];
        }
        int n8 = this.k;
        int n9 = n8 + 1;
        if (this.l) {
            int[] arrn5 = this.g;
            if (arrn5[n8] != -1) {
                n8 = arrn5.length;
            }
        } else {
            n8 = n9;
        }
        int[] arrn6 = this.g;
        if (n8 >= arrn6.length && this.b < arrn6.length) {
            int[] arrn7;
            for (int i4 = 0; i4 < (arrn7 = this.g).length; ++i4) {
                if (arrn7[i4] != -1) continue;
                n8 = i4;
                break;
            }
        }
        if (n8 >= (arrn = this.g).length) {
            int n10;
            n8 = arrn.length;
            this.e = n10 = 2 * this.e;
            this.l = false;
            this.k = n8 - 1;
            this.i = Arrays.copyOf((float[])this.i, (int)n10);
            this.g = Arrays.copyOf((int[])this.g, (int)this.e);
            this.h = Arrays.copyOf((int[])this.h, (int)this.e);
        }
        this.g[n8] = i2.d;
        this.i[n8] = f2;
        if (n5 != -1) {
            int[] arrn8 = this.h;
            arrn8[n8] = arrn8[n5];
            arrn8[n5] = n8;
        } else {
            this.h[n8] = this.j;
            this.j = n8;
        }
        i2.n = 1 + i2.n;
        i2.a(this.c);
        this.b = n2 = 1 + this.b;
        if (!this.l) {
            this.k = 1 + this.k;
        }
        if (n2 >= (arrn2 = this.g).length) {
            this.l = true;
        }
        if (this.k >= arrn2.length) {
            this.l = true;
            this.k = arrn2.length - 1;
        }
    }

    @Override
    public final float j(i i2, boolean bl) {
        int n2;
        if (this.f == i2) {
            this.f = null;
        }
        if ((n2 = this.j) == -1) {
            return 0.0f;
        }
        int n3 = -1;
        for (int i3 = 0; n2 != -1 && i3 < this.b; ++i3) {
            if (this.g[n2] == i2.d) {
                if (n2 == this.j) {
                    this.j = this.h[n2];
                } else {
                    int[] arrn = this.h;
                    arrn[n3] = arrn[n2];
                }
                if (bl) {
                    i2.c(this.c);
                }
                i2.n = -1 + i2.n;
                this.b = -1 + this.b;
                this.g[n2] = -1;
                if (this.l) {
                    this.k = n2;
                }
                return this.i[n2];
            }
            int n4 = this.h[n2];
            n3 = n2;
            n2 = n4;
        }
        return 0.0f;
    }

    @Override
    public void k(float f2) {
        int n2 = this.j;
        for (int i2 = 0; n2 != -1 && i2 < this.b; ++i2) {
            float[] arrf = this.i;
            arrf[n2] = arrf[n2] / f2;
            n2 = this.h[n2];
        }
    }

    public String toString() {
        int n2 = this.j;
        String string = "";
        for (int i2 = 0; n2 != -1 && i2 < this.b; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" -> ");
            String string2 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(this.i[n2]);
            stringBuilder2.append(" : ");
            String string3 = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string3);
            stringBuilder3.append((Object)this.d.d[this.g[n2]]);
            string = stringBuilder3.toString();
            n2 = this.h[n2];
        }
        return string;
    }
}

