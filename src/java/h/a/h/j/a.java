/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.g.a.b.a0
 *  h.a.g.a.b.c
 *  h.a.g.a.b.t
 *  h.a.g.a.c.b
 *  h.a.g.c.b
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.WritableByteChannel
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
package h.a.h.j;

import h.a.g.a.a.a.e;
import h.a.g.a.a.a.n;
import h.a.g.a.b.a0;
import h.a.g.a.b.c;
import h.a.g.a.b.t;
import h.a.h.f;
import h.a.h.h;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a
extends h.a.h.a {
    public static final Map<Integer, Integer> i;
    static Map<Integer, String> j;
    h k = new h();
    private h.a.g.c.b l;
    private long[] m;
    private b n;
    private int o;
    private long p;
    private long q;
    private h.a.h.b r;
    private List<f> s;

    static {
        HashMap hashMap;
        HashMap hashMap2;
        i = hashMap2 = new HashMap();
        j = hashMap = new HashMap();
        Integer n2 = 1;
        hashMap.put((Object)n2, (Object)"AAC Main");
        Map<Integer, String> map = j;
        Integer n3 = 2;
        map.put((Object)n3, (Object)"AAC LC (Low Complexity)");
        Map<Integer, String> map2 = j;
        Integer n4 = 3;
        map2.put((Object)n4, (Object)"AAC SSR (Scalable Sample Rate)");
        Map<Integer, String> map3 = j;
        Integer n5 = 4;
        map3.put((Object)n5, (Object)"AAC LTP (Long Term Prediction)");
        Map<Integer, String> map4 = j;
        Integer n6 = 5;
        map4.put((Object)n6, (Object)"SBR (Spectral Band Replication)");
        Map<Integer, String> map5 = j;
        Integer n7 = 6;
        map5.put((Object)n7, (Object)"AAC Scalable");
        Map<Integer, String> map6 = j;
        Integer n8 = 7;
        map6.put((Object)n8, (Object)"TwinVQ");
        Map<Integer, String> map7 = j;
        Integer n9 = 8;
        map7.put((Object)n9, (Object)"CELP (Code Excited Linear Prediction)");
        Map<Integer, String> map8 = j;
        Integer n10 = 9;
        map8.put((Object)n10, (Object)"HXVC (Harmonic Vector eXcitation Coding)");
        Map<Integer, String> map9 = j;
        Integer n11 = 10;
        map9.put((Object)n11, (Object)"Reserved");
        Map<Integer, String> map10 = j;
        Integer n12 = 11;
        map10.put((Object)n12, (Object)"Reserved");
        j.put((Object)12, (Object)"TTSI (Text-To-Speech Interface)");
        j.put((Object)13, (Object)"Main Synthesis");
        j.put((Object)14, (Object)"Wavetable Synthesis");
        j.put((Object)15, (Object)"General MIDI");
        j.put((Object)16, (Object)"Algorithmic Synthesis and Audio Effects");
        j.put((Object)17, (Object)"ER (Error Resilient) AAC LC");
        j.put((Object)18, (Object)"Reserved");
        j.put((Object)19, (Object)"ER AAC LTP");
        j.put((Object)20, (Object)"ER AAC Scalable");
        j.put((Object)21, (Object)"ER TwinVQ");
        j.put((Object)22, (Object)"ER BSAC (Bit-Sliced Arithmetic Coding)");
        j.put((Object)23, (Object)"ER AAC LD (Low Delay)");
        j.put((Object)24, (Object)"ER CELP");
        j.put((Object)25, (Object)"ER HVXC");
        j.put((Object)26, (Object)"ER HILN (Harmonic and Individual Lines plus Noise)");
        j.put((Object)27, (Object)"ER Parametric");
        j.put((Object)28, (Object)"SSC (SinuSoidal Coding)");
        j.put((Object)29, (Object)"PS (Parametric Stereo)");
        j.put((Object)30, (Object)"MPEG Surround");
        j.put((Object)31, (Object)"(Escape value)");
        j.put((Object)32, (Object)"Layer-1");
        j.put((Object)33, (Object)"Layer-2");
        j.put((Object)34, (Object)"Layer-3");
        j.put((Object)35, (Object)"DST (Direct Stream Transfer)");
        j.put((Object)36, (Object)"ALS (Audio Lossless)");
        j.put((Object)37, (Object)"SLS (Scalable LosslesS)");
        j.put((Object)38, (Object)"SLS non-core");
        j.put((Object)39, (Object)"ER AAC ELD (Enhanced Low Delay)");
        j.put((Object)40, (Object)"SMR (Symbolic Music Representation) Simple");
        j.put((Object)41, (Object)"SMR Main");
        j.put((Object)42, (Object)"USAC (Unified Speech and Audio Coding) (no SBR)");
        j.put((Object)43, (Object)"SAOC (Spatial Audio Object Coding)");
        j.put((Object)44, (Object)"LD MPEG Surround");
        j.put((Object)45, (Object)"USAC");
        Integer n13 = 96000;
        Integer n14 = 0;
        hashMap2.put((Object)n13, (Object)n14);
        Integer n15 = 88200;
        hashMap2.put((Object)n15, (Object)n2);
        Integer n16 = 64000;
        hashMap2.put((Object)n16, (Object)n3);
        hashMap2.put((Object)48000, (Object)n4);
        hashMap2.put((Object)44100, (Object)n5);
        hashMap2.put((Object)32000, (Object)n6);
        hashMap2.put((Object)24000, (Object)n7);
        hashMap2.put((Object)22050, (Object)n8);
        hashMap2.put((Object)16000, (Object)n9);
        hashMap2.put((Object)12000, (Object)n10);
        hashMap2.put((Object)11025, (Object)n11);
        hashMap2.put((Object)8000, (Object)n12);
        hashMap2.put((Object)n14, (Object)n13);
        hashMap2.put((Object)n2, (Object)n15);
        hashMap2.put((Object)n3, (Object)n16);
        hashMap2.put((Object)n4, (Object)48000);
        hashMap2.put((Object)n5, (Object)44100);
        hashMap2.put((Object)n6, (Object)32000);
        hashMap2.put((Object)n7, (Object)24000);
        hashMap2.put((Object)n8, (Object)22050);
        hashMap2.put((Object)n9, (Object)16000);
        hashMap2.put((Object)n10, (Object)12000);
        hashMap2.put((Object)n11, (Object)11025);
        hashMap2.put((Object)n12, (Object)8000);
    }

    public a(h.a.h.b b2) throws IOException {
        this(b2, "eng");
    }

    public a(h.a.h.b b2, String string) throws IOException {
        h.a.g.c.b b3;
        b b4;
        super(b2.toString());
        this.r = b2;
        this.s = new ArrayList();
        this.n = b4 = this.o(b2);
        double d2 = (double)b4.f / 1024.0;
        double d3 = (double)this.s.size() / d2;
        LinkedList linkedList = new LinkedList();
        Iterator iterator = this.s.iterator();
        long l2 = 0L;
        do {
            boolean bl = iterator.hasNext();
            int n2 = 0;
            if (!bl) break;
            int n3 = (int)((f)iterator.next()).a();
            l2 += (long)n3;
            linkedList.add((Object)n3);
            while ((double)linkedList.size() > d2) {
                linkedList.pop();
            }
            if (linkedList.size() != (int)d2) continue;
            Iterator iterator2 = linkedList.iterator();
            while (iterator2.hasNext()) {
                n2 += ((Integer)iterator2.next()).intValue();
            }
            double d4 = d2 * (8.0 * (double)n2 / (double)linkedList.size());
            if (!(d4 > (double)this.p)) continue;
            this.p = (int)d4;
        } while (true);
        this.q = (int)((double)(l2 * 8L) / d3);
        this.o = 1536;
        this.l = b3 = new h.a.g.c.b("mp4a");
        int n4 = this.n.g;
        if (n4 == 7) {
            b3.E(8);
        } else {
            b3.E(n4);
        }
        this.l.L((long)this.n.f);
        this.l.B(1);
        this.l.P(16);
        h.a.g.a.c.b b5 = new h.a.g.a.c.b();
        h.a.g.a.a.a.h h2 = new h.a.g.a.a.a.h();
        h2.i(0);
        n n5 = new n();
        n5.h(2);
        h2.j(n5);
        e e2 = new e();
        e2.l(64);
        e2.m(5);
        e2.j(this.o);
        e2.k(this.p);
        e2.i(this.q);
        h.a.g.a.a.a.a a2 = new h.a.g.a.a.a.a();
        a2.r(2);
        a2.s(this.n.a);
        a2.q(this.n.g);
        e2.h(a2);
        h2.h(e2);
        b5.u(h2);
        this.l.p((h.a.b)b5);
        this.k.k(new Date());
        this.k.m(new Date());
        this.k.l(string);
        this.k.p(1.0f);
        this.k.n(this.n.f);
        long[] arrl = new long[this.s.size()];
        this.m = arrl;
        Arrays.fill((long[])arrl, (long)1024L);
    }

    private b i(h.a.h.b b2) throws IOException {
        Object object = new Object(){
            int a;
            int b;
            int c;
            int d;
            int e;
            int f;
            int g;
            int h;
            int i;
            int j;
            int k;
            int l;
            int m;
            int n;

            int a() {
                int n2 = this.d == 0 ? 2 : 0;
                return n2 + 7;
            }
        };
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)7);
        while (byteBuffer.position() < 7) {
            if (b2.H(byteBuffer) != -1) continue;
            return null;
        }
        h.a.g.a.a.a.c c2 = new h.a.g.a.a.a.c((ByteBuffer)byteBuffer.rewind());
        if (c2.a(12) == 4095) {
            int n2;
            int n3;
            object.b = c2.a(1);
            object.c = c2.a(2);
            object.d = c2.a(1);
            object.e = 1 + c2.a(2);
            object.a = n3 = c2.a(4);
            object.f = (Integer)i.get((Object)n3);
            c2.a(1);
            object.g = c2.a(3);
            object.h = c2.a(1);
            object.i = c2.a(1);
            object.j = c2.a(1);
            object.k = c2.a(1);
            object.l = c2.a(13);
            object.m = c2.a(11);
            object.n = n2 = 1 + c2.a(2);
            if (n2 == 1) {
                if (object.d == 0) {
                    b2.H(ByteBuffer.allocate((int)2));
                }
                return object;
            }
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        }
        throw new IOException("Expected Start Word 0xfff");
    }

    private b o(h.a.h.b b2) throws IOException {
        b b3;
        b b4 = null;
        while ((b3 = this.i(b2)) != null) {
            if (b4 == null) {
                b4 = b3;
            }
            final long l2 = b2.A();
            final long l3 = b3.l - b3.a();
            List<f> list = this.s;
            f f2 = new f(){

                @Override
                public long a() {
                    return l3;
                }

                @Override
                public h.a.g.c.c b() {
                    return a.this.l;
                }

                @Override
                public void c(WritableByteChannel writableByteChannel) throws IOException {
                    a.this.r.d(l2, l3, writableByteChannel);
                }
            };
            list.add((Object)f2);
            b2.W(b2.A() + (long)b3.l - (long)b3.a());
        }
        return b4;
    }

    @Override
    public long[] F() {
        return this.m;
    }

    @Override
    public List<h.a.g.c.c> J() {
        return Collections.singletonList((Object)this.l);
    }

    @Override
    public List<f> K() {
        return this.s;
    }

    @Override
    public String V() {
        return "soun";
    }

    @Override
    public List<t.a> Z() {
        return null;
    }

    public void close() throws IOException {
        this.r.close();
    }

    @Override
    public List<c.a> f() {
        return null;
    }

    @Override
    public h s() {
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AACTrackImpl{sampleRate=");
        stringBuilder.append(this.n.f);
        stringBuilder.append(", channelconfig=");
        stringBuilder.append(this.n.g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public long[] v() {
        return null;
    }

    @Override
    public a0 x() {
        return null;
    }

}

