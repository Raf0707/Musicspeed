/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Map
 */
package h.a.g.a.a.a;

import h.a.g.a.a.a.c;
import h.a.g.a.a.a.d;
import h.a.g.a.a.a.g;
import h.a.j.e;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@g(objectTypeIndication=64, tags={5})
public class a
extends h.a.g.a.a.a.b {
    public static Map<Integer, Integer> d = new HashMap();
    public static Map<Integer, String> e = new HashMap();
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    byte[] Z;
    boolean a0 = false;
    public a f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o = -1;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y;
    public int z;

    static {
        d.put((Object)0, (Object)96000);
        Map<Integer, Integer> map = d;
        Integer n2 = 1;
        map.put((Object)n2, (Object)88200);
        Map<Integer, Integer> map2 = d;
        Integer n3 = 2;
        map2.put((Object)n3, (Object)64000);
        Map<Integer, Integer> map3 = d;
        Integer n4 = 3;
        map3.put((Object)n4, (Object)48000);
        Map<Integer, Integer> map4 = d;
        Integer n5 = 4;
        map4.put((Object)n5, (Object)44100);
        Map<Integer, Integer> map5 = d;
        Integer n6 = 5;
        map5.put((Object)n6, (Object)32000);
        Map<Integer, Integer> map6 = d;
        Integer n7 = 6;
        map6.put((Object)n7, (Object)24000);
        Map<Integer, Integer> map7 = d;
        Integer n8 = 7;
        map7.put((Object)n8, (Object)22050);
        Map<Integer, Integer> map8 = d;
        Integer n9 = 8;
        map8.put((Object)n9, (Object)16000);
        Map<Integer, Integer> map9 = d;
        Integer n10 = 9;
        map9.put((Object)n10, (Object)12000);
        Map<Integer, Integer> map10 = d;
        Integer n11 = 10;
        map10.put((Object)n11, (Object)11025);
        Map<Integer, Integer> map11 = d;
        Integer n12 = 11;
        map11.put((Object)n12, (Object)8000);
        e.put((Object)n2, (Object)"AAC main");
        e.put((Object)n3, (Object)"AAC LC");
        e.put((Object)n4, (Object)"AAC SSR");
        e.put((Object)n5, (Object)"AAC LTP");
        e.put((Object)n6, (Object)"SBR");
        e.put((Object)n7, (Object)"AAC Scalable");
        e.put((Object)n8, (Object)"TwinVQ");
        e.put((Object)n9, (Object)"CELP");
        e.put((Object)n10, (Object)"HVXC");
        e.put((Object)n11, (Object)"(reserved)");
        e.put((Object)n12, (Object)"(reserved)");
        e.put((Object)12, (Object)"TTSI");
        e.put((Object)13, (Object)"Main synthetic");
        e.put((Object)14, (Object)"Wavetable synthesis");
        e.put((Object)15, (Object)"General MIDI");
        e.put((Object)16, (Object)"Algorithmic Synthesis and Audio FX");
        e.put((Object)17, (Object)"ER AAC LC");
        e.put((Object)18, (Object)"(reserved)");
        e.put((Object)19, (Object)"ER AAC LTP");
        e.put((Object)20, (Object)"ER AAC Scalable");
        e.put((Object)21, (Object)"ER TwinVQ");
        e.put((Object)22, (Object)"ER BSAC");
        e.put((Object)23, (Object)"ER AAC LD");
        e.put((Object)24, (Object)"ER CELP");
        e.put((Object)25, (Object)"ER HVXC");
        e.put((Object)26, (Object)"ER HILN");
        e.put((Object)27, (Object)"ER Parametric");
        e.put((Object)28, (Object)"SSC");
        e.put((Object)29, (Object)"PS");
        e.put((Object)30, (Object)"MPEG Surround");
        e.put((Object)31, (Object)"(escape)");
        e.put((Object)32, (Object)"Layer-1");
        e.put((Object)33, (Object)"Layer-2");
        e.put((Object)34, (Object)"Layer-3");
        e.put((Object)35, (Object)"DST");
        e.put((Object)36, (Object)"ALS");
        e.put((Object)37, (Object)"SLS");
        e.put((Object)38, (Object)"SLS non-core");
        e.put((Object)39, (Object)"ER AAC ELD");
        e.put((Object)40, (Object)"SMR Simple");
        e.put((Object)41, (Object)"SMR Main");
    }

    public a() {
        this.a = 5;
    }

    private int g() {
        int n2 = this.z == 1 ? 16 : 2;
        int n3 = n2 + 1;
        if (this.k != 0) {
            int n4 = this.g;
            if (n4 == 6 || n4 == 20) {
                n3 += 3;
            }
            if (this.B == 1) {
                if (n4 == 22) {
                    n3 = 11 + (n3 + 5);
                }
                if (n4 == 17 || n4 == 19 || n4 == 20 || n4 == 23) {
                    n3 = 1 + (1 + (n3 + 1));
                }
                int n5 = n3 + 1;
                if (this.I != 1) {
                    return n5;
                }
                throw new RuntimeException("Not implemented");
            }
            return n3;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    private static int h(c c2) throws IOException {
        int n2 = c2.a(5);
        if (n2 == 31) {
            n2 = 32 + c2.a(6);
        }
        return n2;
    }

    private void i(int n2, int n3, int n4, c c2) throws IOException {
        int n5;
        this.N = c2.a(1);
        this.O = c2.a(2);
        this.P = n5 = c2.a(1);
        if (n5 == 1) {
            this.Q = c2.a(1);
        }
    }

    private void j(int n2, int n3, int n4, c c2) throws IOException {
        int n5;
        this.y = c2.a(1);
        this.z = n5 = c2.a(1);
        if (n5 == 1) {
            this.A = c2.a(14);
        }
        this.B = c2.a(1);
        if (n3 != 0) {
            if (n4 == 6 || n4 == 20) {
                this.C = c2.a(3);
            }
            if (this.B == 1) {
                int n6;
                if (n4 == 22) {
                    this.D = c2.a(5);
                    this.E = c2.a(11);
                }
                if (n4 == 17 || n4 == 19 || n4 == 20 || n4 == 23) {
                    this.F = c2.b();
                    this.G = c2.b();
                    this.H = c2.b();
                }
                this.I = n6 = c2.a(1);
                if (n6 == 1) {
                    throw new RuntimeException("not yet implemented");
                }
            }
            this.J = true;
            return;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    private void k(int n2, int n3, int n4, c c2) throws IOException {
        this.R = c2.a(1);
        this.S = c2.a(8);
        this.T = c2.a(4);
        this.U = c2.a(12);
        this.V = c2.a(2);
    }

    private void l(int n2, int n3, int n4, c c2) throws IOException {
        int n5;
        this.W = n5 = c2.a(1);
        if (n5 == 1) {
            this.X = c2.a(2);
        }
    }

    private void m(int n2, int n3, int n4, c c2) throws IOException {
        int n5;
        this.L = n5 = c2.a(2);
        if (n5 != 1) {
            this.i(n2, n3, n4, c2);
        }
        if (this.L != 0) {
            this.k(n2, n3, n4, c2);
        }
        this.M = c2.a(1);
        this.Y = true;
    }

    private void n(int n2, int n3, int n4, c c2) throws IOException {
        int n5;
        this.K = n5 = c2.a(1);
        if (n5 == 1) {
            this.m(n2, n3, n4, c2);
            return;
        }
        this.l(n2, n3, n4, c2);
    }

    private static void t(int n2, d d2) {
        if (n2 >= 32) {
            d2.a(31, 5);
            d2.a(n2 - 32, 6);
            return;
        }
        d2.a(n2, 5);
    }

    private void u(d d2) {
        d2.a(this.y, 1);
        d2.a(this.z, 1);
        if (this.z == 1) {
            d2.a(this.A, 14);
        }
        d2.a(this.B, 1);
        if (this.k != 0) {
            int n2 = this.g;
            if (n2 == 6 || n2 == 20) {
                d2.a(this.C, 3);
            }
            if (this.B == 1) {
                int n3;
                if (this.g == 22) {
                    d2.a(this.D, 5);
                    d2.a(this.E, 11);
                }
                if ((n3 = this.g) == 17 || n3 == 19 || n3 == 20 || n3 == 23) {
                    d2.b(this.F);
                    d2.b(this.G);
                    d2.b(this.H);
                }
                d2.a(this.I, 1);
                if (this.I != 1) {
                    return;
                }
                throw new RuntimeException("not yet implemented");
            }
            return;
        }
        throw new UnsupportedOperationException("can't parse program_config_element yet");
    }

    @Override
    protected int a() {
        int n2;
        int n3 = this.h > 30 ? 11 : 5;
        int n4 = n3 + 4;
        if (this.i == 15) {
            n4 += 24;
        }
        int n5 = n4 + 4;
        int n6 = this.g;
        if (n6 == 5 || n6 == 29) {
            n5 += 4;
            if (this.o == 15) {
                n5 += 24;
            }
        }
        if (n6 == 22) {
            n5 += 4;
        }
        if (this.J) {
            n5 += this.g();
        }
        if ((n2 = this.x) >= 0) {
            n5 += 11;
            if (n2 == 695) {
                n5 += 5;
                int n7 = this.l;
                if (n7 > 30) {
                    n5 += 6;
                }
                if (n7 == 5) {
                    ++n5;
                    if (this.m) {
                        int n8;
                        n5 += 4;
                        if (this.o == 15) {
                            n5 += 24;
                        }
                        if ((n8 = this.w) >= 0) {
                            n5 += 11;
                            if (n8 == 1352) {
                                ++n5;
                            }
                        }
                    }
                }
                if (n7 == 22) {
                    int n9 = n5 + 1;
                    if (this.m) {
                        n9 += 4;
                        if (this.o == 15) {
                            n9 += 24;
                        }
                    }
                    n5 = n9 + 4;
                }
            }
        }
        return (int)Math.ceil((double)((double)n5 / 8.0));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void e(ByteBuffer var1_1) throws IOException {
        this.a0 = true;
        var2_2 = var1_1.slice();
        var2_2.limit(this.b);
        var1_1.position(var1_1.position() + this.b);
        var5_3 = new byte[this.b];
        this.Z = var5_3;
        var2_2.get(var5_3);
        var2_2.rewind();
        var8_4 = new c(var2_2);
        this.g = var9_5 = a.h(var8_4);
        this.h = var9_5;
        this.i = var10_6 = var8_4.a(4);
        if (var10_6 == 15) {
            this.j = var8_4.a(24);
        }
        this.k = var8_4.a(4);
        var11_7 = this.g;
        if (var11_7 != 5 && var11_7 != 29) {
            this.l = 0;
        } else {
            this.l = 5;
            this.m = true;
            if (var11_7 == 29) {
                this.n = true;
            }
            this.o = var12_8 = var8_4.a(4);
            if (var12_8 == 15) {
                this.p = var8_4.a(24);
            }
            this.g = var13_9 = a.h(var8_4);
            if (var13_9 == 22) {
                this.q = var8_4.a(4);
            }
        }
        var14_10 = this.g;
        switch (var14_10) {
            default: {
                ** break;
            }
            case 40: 
            case 41: {
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
            }
            case 39: {
                this.f = new Object(this.k, var8_4){
                    public boolean a;
                    public boolean b;
                    public boolean c;
                    public boolean d;
                    public boolean e;
                    public boolean f;
                    public boolean g;
                    {
                        boolean bl;
                        this.a = c2.b();
                        this.b = c2.b();
                        this.c = c2.b();
                        this.d = c2.b();
                        this.e = bl = c2.b();
                        if (bl) {
                            this.f = c2.b();
                            this.g = c2.b();
                            this.a(n2, c2);
                        }
                        block0 : while (c2.a(4) != 0) {
                            int n3;
                            int n4 = c2.a(4);
                            if (n4 == 15) {
                                n3 = c2.a(8);
                                n4 += n3;
                            } else {
                                n3 = 0;
                            }
                            int n5 = 0;
                            if (n3 == 255) {
                                n4 += c2.a(16);
                            }
                            do {
                                if (n5 >= n4) continue block0;
                                c2.a(8);
                                ++n5;
                            } while (true);
                            break;
                        }
                        return;
                    }

                    public void a(int n2, c c2) {
                        int n3;
                        int n4 = 0;
                        switch (n2) {
                            default: {
                                n4 = 0;
                                n3 = 0;
                                break;
                            }
                            case 7: {
                                n3 = 4;
                                n4 = 0;
                                break;
                            }
                            case 4: 
                            case 5: 
                            case 6: {
                                n3 = 3;
                                n4 = 0;
                                break;
                            }
                            case 3: {
                                n3 = 2;
                                n4 = 0;
                                break;
                            }
                            case 1: 
                            case 2: {
                                n3 = 1;
                            }
                        }
                        while (n4 < n3) {
                            new Object(c2){
                                public boolean a;
                                public int b;
                                public int c;
                                public int d;
                                public int e;
                                public boolean f;
                                public boolean g;
                                public int h;
                                public boolean i;
                                public int j;
                                public int k;
                                public int l;
                                public boolean m;
                                public boolean n;
                                {
                                    this.a = c2.b();
                                    this.b = c2.a(4);
                                    this.c = c2.a(4);
                                    this.d = c2.a(3);
                                    this.e = c2.a(2);
                                    this.f = c2.b();
                                    this.g = c2.b();
                                    if (this.f) {
                                        this.h = c2.a(2);
                                        this.i = c2.b();
                                        this.j = c2.a(2);
                                    }
                                    if (this.g) {
                                        this.k = c2.a(2);
                                        this.l = c2.a(2);
                                        this.m = c2.b();
                                    }
                                    this.n = c2.b();
                                }
                            };
                            ++n4;
                        }
                        return;
                    }
                };
                ** break;
            }
            case 37: 
            case 38: {
                throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
            }
            case 36: {
                this.s = var8_4.a(5);
                throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
            }
            case 35: {
                throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
            }
            case 32: 
            case 33: 
            case 34: {
                throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
            }
            case 30: {
                this.r = var8_4.a(1);
                throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
            }
            case 28: {
                throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
            }
            case 26: 
            case 27: {
                this.n(this.i, this.k, var14_10, var8_4);
                ** break;
            }
            case 25: {
                throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
            }
            case 24: {
                throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
            }
            case 12: {
                throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
            }
            case 9: {
                throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
            }
            case 8: {
                throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 7: 
            case 17: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
        }
        this.j(this.i, this.k, var14_10, var8_4);
lbl70: // 4 sources:
        var15_11 = this.g;
        if (var15_11 != 17 && var15_11 != 39) {
            switch (var15_11) {
                default: {
                    ** break;
                }
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
            }
        }
        this.t = var16_12 = var8_4.a(2);
        if (var16_12 == 2) throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        if (var16_12 == 3) throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        if (var16_12 == 3) {
            this.u = var24_13 = var8_4.a(1);
            if (var24_13 == 0) throw new RuntimeException("not implemented");
            ** break;
        }
lbl83: // 4 sources:
        if (this.l == 5) return;
        if (var8_4.c() < 16) return;
        this.v = var17_14 = var8_4.a(11);
        this.x = var17_14;
        if (var17_14 != 695) return;
        this.l = var18_15 = a.h(var8_4);
        if (var18_15 == 5) {
            this.m = var21_16 = var8_4.b();
            if (var21_16) {
                this.o = var22_17 = var8_4.a(4);
                if (var22_17 == 15) {
                    this.p = var8_4.a(24);
                }
                if (var8_4.c() >= 12) {
                    this.v = var23_18 = var8_4.a(11);
                    this.w = var23_18;
                    if (var23_18 == 1352) {
                        this.n = var8_4.b();
                    }
                }
            }
        }
        if (this.l != 22) return;
        this.m = var19_19 = var8_4.b();
        if (var19_19) {
            this.o = var20_20 = var8_4.a(4);
            if (var20_20 == 15) {
                this.p = var8_4.a(24);
            }
        }
        this.q = var8_4.a(4);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (a.class != object.getClass()) {
                return false;
            }
            a a2 = (a)object;
            if (this.G != a2.G) {
                return false;
            }
            if (this.F != a2.F) {
                return false;
            }
            if (this.H != a2.H) {
                return false;
            }
            if (this.g != a2.g) {
                return false;
            }
            if (this.k != a2.k) {
                return false;
            }
            if (this.A != a2.A) {
                return false;
            }
            if (this.z != a2.z) {
                return false;
            }
            if (this.u != a2.u) {
                return false;
            }
            if (this.t != a2.t) {
                return false;
            }
            if (this.P != a2.P) {
                return false;
            }
            if (this.l != a2.l) {
                return false;
            }
            if (this.q != a2.q) {
                return false;
            }
            if (this.B != a2.B) {
                return false;
            }
            if (this.I != a2.I) {
                return false;
            }
            if (this.p != a2.p) {
                return false;
            }
            if (this.o != a2.o) {
                return false;
            }
            if (this.s != a2.s) {
                return false;
            }
            if (this.y != a2.y) {
                return false;
            }
            if (this.J != a2.J) {
                return false;
            }
            if (this.V != a2.V) {
                return false;
            }
            if (this.W != a2.W) {
                return false;
            }
            if (this.X != a2.X) {
                return false;
            }
            if (this.U != a2.U) {
                return false;
            }
            if (this.S != a2.S) {
                return false;
            }
            if (this.R != a2.R) {
                return false;
            }
            if (this.T != a2.T) {
                return false;
            }
            if (this.O != a2.O) {
                return false;
            }
            if (this.N != a2.N) {
                return false;
            }
            if (this.K != a2.K) {
                return false;
            }
            if (this.C != a2.C) {
                return false;
            }
            if (this.E != a2.E) {
                return false;
            }
            if (this.D != a2.D) {
                return false;
            }
            if (this.M != a2.M) {
                return false;
            }
            if (this.L != a2.L) {
                return false;
            }
            if (this.Y != a2.Y) {
                return false;
            }
            if (this.n != a2.n) {
                return false;
            }
            if (this.r != a2.r) {
                return false;
            }
            if (this.j != a2.j) {
                return false;
            }
            if (this.i != a2.i) {
                return false;
            }
            if (this.m != a2.m) {
                return false;
            }
            if (this.v != a2.v) {
                return false;
            }
            if (this.Q != a2.Q) {
                return false;
            }
            return Arrays.equals((byte[])this.Z, (byte[])a2.Z);
        }
        return false;
    }

    public int hashCode() {
        byte[] arrby = this.Z;
        int n2 = arrby != null ? Arrays.hashCode((byte[])arrby) : 0;
        return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (n2 * 31 + this.g) + this.i) + this.j) + this.k) + this.l) + this.m) + this.n) + this.o) + this.p) + this.q) + this.r) + this.s) + this.t) + this.u) + this.v) + this.y) + this.z) + this.A) + this.B) + this.C) + this.D) + this.E) + this.F) + this.G) + this.H) + this.I) + this.J) + this.K) + this.L) + this.M) + this.N) + this.O) + this.P) + this.Q) + this.R) + this.S) + this.T) + this.U) + this.V) + this.W) + this.X) + this.Y;
    }

    public ByteBuffer o() {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.b());
        e.j(byteBuffer, this.a);
        this.f(byteBuffer, this.a());
        byteBuffer.put(this.p());
        return (ByteBuffer)byteBuffer.rewind();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected ByteBuffer p() {
        var1_1 = ByteBuffer.wrap((byte[])new byte[this.a()]);
        var2_2 = new d(var1_1);
        a.t(this.h, var2_2);
        var2_2.a(this.i, 4);
        if (this.i == 15) {
            var2_2.a(this.j, 24);
        }
        var2_2.a(this.k, 4);
        var3_3 = this.g;
        if (var3_3 == 5 || var3_3 == 29) {
            this.l = 5;
            this.m = true;
            if (var3_3 == 29) {
                this.n = true;
            }
            var2_2.a(this.o, 4);
            if (this.o == 15) {
                var2_2.a(this.p, 24);
            }
            a.t(this.g, var2_2);
            if (this.g == 22) {
                var2_2.a(this.q, 4);
            }
        }
        switch (this.g) {
            default: {
                ** break;
            }
            case 40: 
            case 41: {
                throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
            }
            case 39: {
                throw new UnsupportedOperationException("can't write ELDSpecificConfig yet");
            }
            case 37: 
            case 38: {
                throw new UnsupportedOperationException("can't write SLSSpecificConfig yet");
            }
            case 36: {
                var2_2.a(this.s, 5);
                throw new UnsupportedOperationException("can't write ALSSpecificConfig yet");
            }
            case 35: {
                throw new UnsupportedOperationException("can't write DSTSpecificConfig yet");
            }
            case 32: 
            case 33: 
            case 34: {
                throw new UnsupportedOperationException("can't write MPEG_1_2_SpecificConfig yet");
            }
            case 30: {
                var2_2.a(this.r, 1);
                throw new UnsupportedOperationException("can't write SpatialSpecificConfig yet");
            }
            case 28: {
                throw new UnsupportedOperationException("can't write SSCSpecificConfig yet");
            }
            case 26: 
            case 27: {
                throw new UnsupportedOperationException("can't write parseParametricSpecificConfig yet");
            }
            case 25: {
                throw new UnsupportedOperationException("can't write ErrorResilientHvxcSpecificConfig yet");
            }
            case 24: {
                throw new UnsupportedOperationException("can't write ErrorResilientCelpSpecificConfig yet");
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                throw new UnsupportedOperationException("can't write StructuredAudioSpecificConfig yet");
            }
            case 12: {
                throw new UnsupportedOperationException("can't write TTSSpecificConfig yet");
            }
            case 9: {
                throw new UnsupportedOperationException("can't write HvxcSpecificConfig yet");
            }
            case 8: {
                throw new UnsupportedOperationException("can't write CelpSpecificConfig yet");
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 7: 
            case 17: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
        }
        this.u(var2_2);
lbl57: // 2 sources:
        var4_4 = this.g;
        if (var4_4 != 17 && var4_4 != 39) {
            switch (var4_4) {
                default: {
                    ** break;
                }
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
            }
        }
        var2_2.a(this.t, 2);
        var5_5 = this.t;
        if (var5_5 == 2) throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        if (var5_5 == 3) throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        if (var5_5 == 3) {
            var2_2.a(this.u, 1);
            if (this.u == 0) throw new RuntimeException("not implemented");
            ** break;
        }
lbl71: // 4 sources:
        var6_6 = this.x;
        if (var6_6 < 0) return (ByteBuffer)var1_1.rewind();
        var2_2.a(var6_6, 11);
        if (this.x != 695) return (ByteBuffer)var1_1.rewind();
        a.t(this.l, var2_2);
        if (this.l == 5) {
            var2_2.b(this.m);
            if (this.m) {
                var2_2.a(this.o, 4);
                if (this.o == 15) {
                    var2_2.a(this.p, 24);
                }
                if ((var7_7 = this.w) >= 0) {
                    var2_2.a(var7_7, 11);
                    if (this.v == 1352) {
                        var2_2.b(this.n);
                    }
                }
            }
        }
        if (this.l != 22) return (ByteBuffer)var1_1.rewind();
        var2_2.b(this.m);
        if (this.m) {
            var2_2.a(this.o, 4);
            if (this.o == 15) {
                var2_2.a(this.p, 24);
            }
        }
        var2_2.a(this.q, 4);
        return (ByteBuffer)var1_1.rewind();
    }

    public void q(int n2) {
        this.k = n2;
    }

    public void r(int n2) {
        this.h = n2;
    }

    public void s(int n2) {
        this.i = n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioSpecificConfig");
        stringBuilder.append("{configBytes=");
        stringBuilder.append(h.a.j.c.a(this.Z));
        stringBuilder.append(", audioObjectType=");
        stringBuilder.append(this.g);
        stringBuilder.append(" (");
        stringBuilder.append((String)e.get((Object)this.g));
        stringBuilder.append(")");
        stringBuilder.append(", samplingFrequencyIndex=");
        stringBuilder.append(this.i);
        stringBuilder.append(" (");
        stringBuilder.append(d.get((Object)this.i));
        stringBuilder.append(")");
        stringBuilder.append(", samplingFrequency=");
        stringBuilder.append(this.j);
        stringBuilder.append(", channelConfiguration=");
        stringBuilder.append(this.k);
        if (this.l > 0) {
            stringBuilder.append(", extensionAudioObjectType=");
            stringBuilder.append(this.l);
            stringBuilder.append(" (");
            stringBuilder.append((String)e.get((Object)this.l));
            stringBuilder.append(")");
            stringBuilder.append(", sbrPresentFlag=");
            stringBuilder.append(this.m);
            stringBuilder.append(", psPresentFlag=");
            stringBuilder.append(this.n);
            stringBuilder.append(", extensionSamplingFrequencyIndex=");
            stringBuilder.append(this.o);
            stringBuilder.append(" (");
            stringBuilder.append(d.get((Object)this.o));
            stringBuilder.append(")");
            stringBuilder.append(", extensionSamplingFrequency=");
            stringBuilder.append(this.p);
            stringBuilder.append(", extensionChannelConfiguration=");
            stringBuilder.append(this.q);
        }
        stringBuilder.append(", syncExtensionType=");
        stringBuilder.append(this.v);
        if (this.J) {
            stringBuilder.append(", frameLengthFlag=");
            stringBuilder.append(this.y);
            stringBuilder.append(", dependsOnCoreCoder=");
            stringBuilder.append(this.z);
            stringBuilder.append(", coreCoderDelay=");
            stringBuilder.append(this.A);
            stringBuilder.append(", extensionFlag=");
            stringBuilder.append(this.B);
            stringBuilder.append(", layerNr=");
            stringBuilder.append(this.C);
            stringBuilder.append(", numOfSubFrame=");
            stringBuilder.append(this.D);
            stringBuilder.append(", layer_length=");
            stringBuilder.append(this.E);
            stringBuilder.append(", aacSectionDataResilienceFlag=");
            stringBuilder.append(this.F);
            stringBuilder.append(", aacScalefactorDataResilienceFlag=");
            stringBuilder.append(this.G);
            stringBuilder.append(", aacSpectralDataResilienceFlag=");
            stringBuilder.append(this.H);
            stringBuilder.append(", extensionFlag3=");
            stringBuilder.append(this.I);
        }
        if (this.Y) {
            stringBuilder.append(", isBaseLayer=");
            stringBuilder.append(this.K);
            stringBuilder.append(", paraMode=");
            stringBuilder.append(this.L);
            stringBuilder.append(", paraExtensionFlag=");
            stringBuilder.append(this.M);
            stringBuilder.append(", hvxcVarMode=");
            stringBuilder.append(this.N);
            stringBuilder.append(", hvxcRateMode=");
            stringBuilder.append(this.O);
            stringBuilder.append(", erHvxcExtensionFlag=");
            stringBuilder.append(this.P);
            stringBuilder.append(", var_ScalableFlag=");
            stringBuilder.append(this.Q);
            stringBuilder.append(", hilnQuantMode=");
            stringBuilder.append(this.R);
            stringBuilder.append(", hilnMaxNumLine=");
            stringBuilder.append(this.S);
            stringBuilder.append(", hilnSampleRateCode=");
            stringBuilder.append(this.T);
            stringBuilder.append(", hilnFrameLength=");
            stringBuilder.append(this.U);
            stringBuilder.append(", hilnContMode=");
            stringBuilder.append(this.V);
            stringBuilder.append(", hilnEnhaLayer=");
            stringBuilder.append(this.W);
            stringBuilder.append(", hilnEnhaQuantMode=");
            stringBuilder.append(this.X);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}

