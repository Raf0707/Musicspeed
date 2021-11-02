/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package h.a.g.a.b;

import h.a.d;
import h.a.f.a.a;
import h.a.f.a.c;
import h.a.f.a.d.a;
import h.a.f.b.b.b;
import h.a.i.e;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class i
extends h.a.i.a {
    private static /* synthetic */ a.a l;
    private static /* synthetic */ a.a m;
    private static /* synthetic */ a.a n;
    private static /* synthetic */ a.a o;
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private String r;
    private long s;
    private List<String> t = Collections.emptyList();

    static {
        i.k();
    }

    public i() {
        super("ftyp");
    }

    public i(String string, long l2, List<String> list) {
        super("ftyp");
        this.r = string;
        this.s = l2;
        this.t = list;
    }

    private static /* synthetic */ void k() {
        b b2 = new b("FileTypeBox.java", i.class);
        l = b2.g("method-execution", b2.f("1", "getMajorBrand", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "", "", "", "java.lang.String"), 85);
        m = b2.g("method-execution", b2.f("1", "setMajorBrand", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        n = b2.g("method-execution", b2.f("1", "getMinorVersion", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "", "", "", "long"), 104);
        o = b2.g("method-execution", b2.f("1", "setMinorVersion", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "long", "minorVersion", "", "void"), 113);
        p = b2.g("method-execution", b2.f("1", "getCompatibleBrands", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "", "", "", "java.util.List"), 122);
        q = b2.g("method-execution", b2.f("1", "setCompatibleBrands", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.r = h.a.j.d.b(byteBuffer);
        this.s = h.a.j.d.j(byteBuffer);
        int n2 = byteBuffer.remaining() / 4;
        this.t = new LinkedList();
        int n3 = 0;
        while (n3 < n2) {
            this.t.add((Object)h.a.j.d.b(byteBuffer));
            ++n3;
        }
        return;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        byteBuffer.put(d.w(this.r));
        h.a.j.e.g(byteBuffer, this.s);
        Iterator iterator = this.t.iterator();
        while (iterator.hasNext()) {
            byteBuffer.put(d.w((String)iterator.next()));
        }
        return;
    }

    @Override
    protected long e() {
        return 8 + 4 * this.t.size();
    }

    public String l() {
        h.a.f.a.a a2 = b.c(l, this, this);
        e.b().c(a2);
        return this.r;
    }

    public long m() {
        h.a.f.a.a a2 = b.c(n, this, this);
        e.b().c(a2);
        return this.s;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileTypeBox[");
        stringBuilder.append("majorBrand=");
        stringBuilder.append(this.l());
        stringBuilder.append(";");
        stringBuilder.append("minorVersion=");
        stringBuilder.append(this.m());
        Iterator iterator = this.t.iterator();
        do {
            if (!iterator.hasNext()) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            String string = (String)iterator.next();
            stringBuilder.append(";");
            stringBuilder.append("compatibleBrand=");
            stringBuilder.append(string);
        } while (true);
    }
}

