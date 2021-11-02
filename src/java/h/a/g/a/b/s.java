/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.ByteBuffer
 */
package h.a.g.a.b;

import h.a.d;
import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.f.b.b.b;
import h.a.i.e;
import java.nio.ByteBuffer;

public class s
extends h.a.i.c {
    private static /* synthetic */ a.a A;
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    private static /* synthetic */ a.a v;
    private static /* synthetic */ a.a w;
    private static /* synthetic */ a.a x;
    private static /* synthetic */ a.a y;
    private static /* synthetic */ a.a z;
    private short B;
    private short[] C = new short[0];
    private int D;
    private String E;
    private String F;

    static {
        s.k();
    }

    public s() {
        super("saiz");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("SampleAuxiliaryInformationSizesBox.java", s.class);
        p = b2.g("method-execution", b2.f("1", "getSize", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "index", "", "short"), 55);
        q = b2.g("method-execution", b2.f("1", "getAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 104);
        z = b2.g("method-execution", b2.f("1", "setSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 144);
        A = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 149);
        r = b2.g("method-execution", b2.f("1", "setAuxInfoType", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 108);
        s = b2.g("method-execution", b2.f("1", "getAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 112);
        t = b2.g("method-execution", b2.f("1", "setAuxInfoTypeParameter", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 116);
        u = b2.g("method-execution", b2.f("1", "getDefaultSampleInfoSize", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 120);
        v = b2.g("method-execution", b2.f("1", "setDefaultSampleInfoSize", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 124);
        w = b2.g("method-execution", b2.f("1", "getSampleInfoSizes", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 129);
        x = b2.g("method-execution", b2.f("1", "setSampleInfoSizes", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 135);
        y = b2.g("method-execution", b2.f("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 140);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        int n2;
        this.n(byteBuffer);
        if ((1 & this.l()) == 1) {
            this.E = h.a.j.d.b(byteBuffer);
            this.F = h.a.j.d.b(byteBuffer);
        }
        this.B = (short)h.a.j.d.m(byteBuffer);
        this.D = n2 = h.a.j.a.a(h.a.j.d.j(byteBuffer));
        if (this.B == 0) {
            this.C = new short[n2];
            int n3 = 0;
            do {
                if (n3 >= this.D) {
                    return;
                }
                this.C[n3] = (short)h.a.j.d.m(byteBuffer);
                ++n3;
            } while (true);
        }
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        if ((1 & this.l()) == 1) {
            byteBuffer.put(d.w(this.E));
            byteBuffer.put(d.w(this.F));
        }
        h.a.j.e.j(byteBuffer, this.B);
        if (this.B == 0) {
            h.a.j.e.g(byteBuffer, this.C.length);
            short[] arrs = this.C;
            int n2 = arrs.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    return;
                }
                h.a.j.e.j(byteBuffer, arrs[n3]);
                ++n3;
            } while (true);
        }
        h.a.j.e.g(byteBuffer, this.D);
    }

    @Override
    protected long e() {
        int n2 = (1 & this.l()) == 1 ? 12 : 4;
        int n3 = n2 + 5;
        int n4 = this.B == 0 ? this.C.length : 0;
        return n3 + n4;
    }

    public void r(String string) {
        h.a.f.a.a a2 = b.d(r, this, this, string);
        e.b().c(a2);
        this.E = string;
    }

    public void s(int n2) {
        h.a.f.a.a a2 = b.d(v, this, this, h.a.f.b.a.a.d(n2));
        e.b().c(a2);
        this.B = (short)n2;
    }

    public void t(int n2) {
        h.a.f.a.a a2 = b.d(z, this, this, h.a.f.b.a.a.d(n2));
        e.b().c(a2);
        this.D = n2;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(A, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=");
        stringBuilder.append((int)this.B);
        stringBuilder.append(", sampleCount=");
        stringBuilder.append(this.D);
        stringBuilder.append(", auxInfoType='");
        stringBuilder.append(this.E);
        stringBuilder.append('\'');
        stringBuilder.append(", auxInfoTypeParameter='");
        stringBuilder.append(this.F);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u(short[] arrs) {
        h.a.f.a.a a2 = b.d(x, this, this, arrs);
        e.b().c(a2);
        short[] arrs2 = new short[arrs.length];
        this.C = arrs2;
        System.arraycopy((Object)arrs, (int)0, (Object)arrs2, (int)0, (int)arrs.length);
    }
}

