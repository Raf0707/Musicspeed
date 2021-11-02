/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.ViewConfiguration
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  java.lang.Math
 *  java.lang.Object
 */
package com.shawnlin.numberpicker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class d {
    private static float a = (float)(Math.log((double)0.78) / Math.log((double)0.9));
    private static final float[] b = new float[101];
    private static final float[] c = new float[101];
    private float A;
    private final float B;
    private float C;
    private final Interpolator d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private long p;
    private int q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private float w;
    private float x;
    private int y;
    private float z;

    static {
        float f2 = 0.0f;
        float f3 = 0.0f;
        block0 : for (int i2 = 0; i2 < 100; ++i2) {
            float f4 = (float)i2 / 100.0f;
            float f5 = 1.0f;
            do {
                float f6;
                float f7;
                float f8;
                float f9;
                float f10;
                float f11;
                float f12;
                float f13;
                float f14;
                float f15;
                if ((double)Math.abs((float)((f6 = (f11 = (f15 = (f10 = (f9 = f2 + (f13 = f5 - f2) / (f12 = 2.0f)) * (f7 = 3.0f)) * (f14 = 1.0f - f9)) * (f14 * 0.175f + f9 * 0.35000002f)) + (f8 = f9 * (f9 * f9))) - f4)) < 1.0E-5) {
                    d.b[i2] = f8 + f15 * (f9 + f14 * 0.5f);
                    float f16 = 1.0f;
                    do {
                        float f17;
                        float f18;
                        float f19;
                        float f20;
                        float f21;
                        float f22;
                        float f23;
                        if ((double)Math.abs((float)((f20 = (f22 = (f18 = (f21 = (f23 = f3 + (f16 - f3) / f12) * f7) * (f17 = 1.0f - f23)) * (f23 + f17 * 0.5f)) + (f19 = f23 * (f23 * f23))) - f4)) < 1.0E-5) {
                            d.c[i2] = f19 + f18 * (f17 * 0.175f + f23 * 0.35000002f);
                            continue block0;
                        }
                        if (f20 > f4) {
                            f16 = f23;
                        } else {
                            f3 = f23;
                        }
                        f12 = 2.0f;
                        f7 = 3.0f;
                    } while (true);
                }
                if (f6 > f4) {
                    f5 = f9;
                    continue;
                }
                f2 = f9;
            } while (true);
        }
        float[] arrf = b;
        d.c[100] = 1.0f;
        arrf[100] = 1.0f;
    }

    public d(Context context, Interpolator interpolator) {
        boolean bl = context.getApplicationInfo().targetSdkVersion >= 11;
        this(context, interpolator, bl);
    }

    public d(Context context, Interpolator interpolator, boolean bl) {
        this.z = ViewConfiguration.getScrollFriction();
        this.u = true;
        this.d = interpolator == null ? new a() : interpolator;
        this.B = 160.0f * context.getResources().getDisplayMetrics().density;
        this.A = this.a(ViewConfiguration.getScrollFriction());
        this.v = bl;
        this.C = this.a(0.84f);
    }

    private float a(float f2) {
        return f2 * (386.0878f * this.B);
    }

    private double j(float f2) {
        return Math.log((double)(0.35f * Math.abs((float)f2) / (this.z * this.C)));
    }

    private double k(float f2) {
        double d2 = this.j(f2);
        float f3 = a;
        double d3 = (double)f3 - 1.0;
        return (double)(this.z * this.C) * Math.exp((double)(d2 * ((double)f3 / d3)));
    }

    private int l(float f2) {
        return (int)(1000.0 * Math.exp((double)(this.j(f2) / ((double)a - 1.0))));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean b() {
        int n2;
        if (this.u) {
            return false;
        }
        int n3 = (int)(AnimationUtils.currentAnimationTimeMillis() - this.p);
        if (n3 < (n2 = this.q)) {
            int n4 = this.e;
            if (n4 != 0) {
                int n5;
                int n6;
                int n7;
                int n8;
                int n9;
                if (n4 != 1) {
                    return true;
                }
                float f2 = (float)n3 / (float)n2;
                int n10 = (int)(f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (n10 < 100) {
                    float f5 = (float)n10 / 100.0f;
                    int n11 = n10 + 1;
                    float f6 = (float)n11 / 100.0f;
                    float[] arrf = b;
                    float f7 = arrf[n10];
                    f4 = (arrf[n11] - f7) / (f6 - f5);
                    f3 = f7 + f4 * (f2 - f5);
                }
                this.x = 1000.0f * (f4 * (float)this.y / (float)n2);
                int n12 = this.f;
                this.n = n6 = n12 + Math.round((float)(f3 * (float)(this.h - n12)));
                this.n = n9 = Math.min((int)n6, (int)this.k);
                this.n = Math.max((int)n9, (int)this.j);
                int n13 = this.g;
                this.o = n8 = n13 + Math.round((float)(f3 * (float)(this.i - n13)));
                this.o = n5 = Math.min((int)n8, (int)this.m);
                this.o = n7 = Math.max((int)n5, (int)this.l);
                if (this.n != this.h || n7 != this.i) return true;
                this.u = true;
                return true;
            }
            float f8 = this.d.getInterpolation((float)n3 * this.r);
            this.n = this.f + Math.round((float)(f8 * this.s));
            this.o = this.g + Math.round((float)(f8 * this.t));
            return true;
        }
        this.n = this.h;
        this.o = this.i;
        this.u = true;
        return true;
    }

    public void c(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10;
        int n11;
        float f2;
        int n12;
        int n13;
        if (this.v && !this.u) {
            float f3;
            float f4 = this.e();
            float f5 = this.h - this.f;
            float f6 = this.i - this.g;
            float f7 = (float)Math.hypot((double)f5, (double)f6);
            float f8 = f5 / f7;
            float f9 = f6 / f7;
            float f10 = f8 * f4;
            float f11 = f9 * f4;
            float f12 = n4;
            if (Math.signum((float)f12) == Math.signum((float)f10) && Math.signum((float)(f3 = (float)n5)) == Math.signum((float)f11)) {
                n4 = (int)(f12 + f10);
                n5 = (int)(f3 + f11);
            }
        }
        this.e = 1;
        this.u = false;
        this.w = f2 = (float)Math.hypot((double)n4, (double)n5);
        this.q = this.l(f2);
        this.p = AnimationUtils.currentAnimationTimeMillis();
        this.f = n2;
        this.g = n3;
        float f13 = 1.0f;
        float f14 = f2 FCMPL 0.0f;
        float f15 = f14 == false ? 1.0f : (float)n4 / f2;
        if (f14 != false) {
            f13 = (float)n5 / f2;
        }
        double d2 = this.k(f2);
        this.y = (int)(d2 * (double)Math.signum((float)f2));
        this.j = n6;
        this.k = n7;
        this.l = n8;
        this.m = n9;
        this.h = n12 = n2 + (int)Math.round((double)(d2 * (double)f15));
        this.h = n13 = Math.min((int)n12, (int)this.k);
        this.h = Math.max((int)n13, (int)this.j);
        this.i = n10 = n3 + (int)Math.round((double)(d2 * (double)f13));
        this.i = n11 = Math.min((int)n10, (int)this.m);
        this.i = Math.max((int)n11, (int)this.l);
    }

    public final void d(boolean bl) {
        this.u = bl;
    }

    public float e() {
        if (this.e == 1) {
            return this.x;
        }
        return this.w - this.A * (float)this.q() / 2000.0f;
    }

    public final int f() {
        return this.n;
    }

    public final int g() {
        return this.o;
    }

    public final int h() {
        return this.h;
    }

    public final int i() {
        return this.i;
    }

    public final int m() {
        return this.f;
    }

    public final int n() {
        return this.g;
    }

    public final boolean o() {
        return this.u;
    }

    public void p(int n2, int n3, int n4, int n5, int n6) {
        this.e = 0;
        this.u = false;
        this.q = n6;
        this.p = AnimationUtils.currentAnimationTimeMillis();
        this.f = n2;
        this.g = n3;
        this.h = n2 + n4;
        this.i = n3 + n5;
        this.s = n4;
        this.t = n5;
        this.r = 1.0f / (float)this.q;
    }

    public int q() {
        return (int)(AnimationUtils.currentAnimationTimeMillis() - this.p);
    }

    static class a
    implements Interpolator {
        private static final float a;
        private static final float b;

        static {
            float f2;
            a = f2 = 1.0f / a.a(1.0f);
            b = 1.0f - f2 * a.a(1.0f);
        }

        a() {
        }

        private static float a(float f2) {
            float f3 = f2 * 8.0f;
            if (f3 < 1.0f) {
                return f3 - (1.0f - (float)Math.exp((double)(-f3)));
            }
            return 0.36787945f + 0.63212055f * (1.0f - (float)Math.exp((double)(1.0f - f3)));
        }

        public float getInterpolation(float f2) {
            float f3 = a * a.a(f2);
            if (f3 > 0.0f) {
                f3 += b;
            }
            return f3;
        }
    }

}

