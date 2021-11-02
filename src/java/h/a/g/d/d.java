/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package h.a.g.d;

import h.a.f.a.a;
import h.a.g.d.a;
import h.a.g.d.b;
import h.a.g.d.c;
import h.a.g.d.f;
import h.a.g.d.g;
import h.a.g.d.h;
import h.a.i.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class d
extends h.a.i.c {
    private static /* synthetic */ a.a p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    private static /* synthetic */ a.a v;
    private static /* synthetic */ a.a w;
    private static /* synthetic */ a.a x;
    private List<a> A = new LinkedList();
    private String y;
    private int z;

    static {
        d.k();
    }

    public d() {
        super("sgpd");
        this.p(1);
    }

    private static /* synthetic */ void k() {
        h.a.f.b.b.b b2 = new h.a.f.b.b.b("SampleGroupDescriptionBox.java", d.class);
        p = b2.g("method-execution", b2.f("1", "getGroupingType", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 57);
        q = b2.g("method-execution", b2.f("1", "setGroupingType", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 61);
        r = b2.g("method-execution", b2.f("1", "getDefaultLength", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 164);
        s = b2.g("method-execution", b2.f("1", "setDefaultLength", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 168);
        t = b2.g("method-execution", b2.f("1", "getGroupEntries", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 172);
        u = b2.g("method-execution", b2.f("1", "setGroupEntries", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 176);
        v = b2.g("method-execution", b2.f("1", "equals", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 181);
        w = b2.g("method-execution", b2.f("1", "hashCode", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 202);
        x = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 210);
    }

    private a r(ByteBuffer byteBuffer, String string) {
        block11 : {
            a a2;
            block3 : {
                block10 : {
                    block9 : {
                        block8 : {
                            block7 : {
                                block6 : {
                                    block5 : {
                                        block4 : {
                                            block2 : {
                                                if (!"roll".equals((Object)string)) break block2;
                                                a2 = new c();
                                                break block3;
                                            }
                                            if (!"rash".equals((Object)string)) break block4;
                                            a2 = new b();
                                            break block3;
                                        }
                                        if (!"rap ".equals((Object)string)) break block5;
                                        a2 = new h();
                                        break block3;
                                    }
                                    if (!"tele".equals((Object)string)) break block6;
                                    a2 = new f();
                                    break block3;
                                }
                                if (!"sync".equals((Object)string)) break block7;
                                a2 = new h.a.g.a.d.b();
                                break block3;
                            }
                            if (!"tscl".equals((Object)string)) break block8;
                            a2 = new h.a.g.a.d.c();
                            break block3;
                        }
                        if (!"tsas".equals((Object)string)) break block9;
                        a2 = new h.a.g.a.d.d();
                        break block3;
                    }
                    if (!"stsa".equals((Object)string)) break block10;
                    a2 = new h.a.g.a.d.a();
                    break block3;
                }
                if (this.m() == 0) break block11;
                a2 = new g(string);
            }
            ((a)a2).c(byteBuffer);
            return a2;
        }
        throw new RuntimeException("SampleGroupDescriptionBox with UnknownEntry are only supported in version 1");
    }

    @Override
    protected void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.y = h.a.j.d.b(byteBuffer);
        if (this.m() == 1) {
            this.z = h.a.j.a.a(h.a.j.d.j(byteBuffer));
        }
        long l2 = h.a.j.d.j(byteBuffer);
        do {
            long l3 = l2 - 1L;
            if (l2 <= 0L) {
                return;
            }
            int n2 = this.z;
            if (this.m() == 1) {
                if (this.z == 0) {
                    n2 = h.a.j.a.a(h.a.j.d.j(byteBuffer));
                }
            } else {
                n2 = byteBuffer.limit() - byteBuffer.position();
            }
            ByteBuffer byteBuffer2 = byteBuffer.slice();
            byteBuffer2.limit(n2);
            this.A.add((Object)this.r(byteBuffer2, this.y));
            if (this.m() != 1) {
                n2 = byteBuffer2.position();
            }
            byteBuffer.position(n2 + byteBuffer.position());
            l2 = l3;
        } while (true);
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        byteBuffer.put(h.a.d.w(this.y));
        if (this.m() == 1) {
            h.a.j.e.g(byteBuffer, this.z);
        }
        h.a.j.e.g(byteBuffer, this.A.size());
        Iterator iterator = this.A.iterator();
        block0 : while (iterator.hasNext()) {
            ByteBuffer byteBuffer2 = ((a)iterator.next()).a();
            if (this.m() == 1) {
                if (this.z == 0) {
                    h.a.j.e.g(byteBuffer, byteBuffer2.limit());
                } else if (byteBuffer2.limit() > this.z) {
                    Object[] arrobject = new Object[]{byteBuffer2.limit(), this.z};
                    throw new RuntimeException(String.format((String)"SampleGroupDescriptionBox entry size %d more than %d", (Object[])arrobject));
                }
            }
            byteBuffer.put(byteBuffer2);
            int n2 = this.z;
            int n3 = n2 == 0 ? 0 : n2 - byteBuffer2.limit();
            do {
                int n4 = n3 - 1;
                if (n3 <= 0) continue block0;
                byteBuffer.put((byte)0);
                n3 = n4;
            } while (true);
            break;
        }
        return;
    }

    @Override
    protected long e() {
        long l2 = this.m() == 1 ? 12L : 8L;
        long l3 = l2 + 4L;
        Iterator iterator = this.A.iterator();
        while (iterator.hasNext()) {
            int n2;
            a a2 = (a)iterator.next();
            if (this.m() == 1 && this.z == 0) {
                l3 += 4L;
            }
            if ((n2 = this.z) == 0) {
                n2 = a2.d();
            }
            l3 += (long)n2;
        }
        return l3;
    }

    public boolean equals(Object object) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(v, this, this, object);
        e.b().c(a2);
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (d.class != object.getClass()) {
                return false;
            }
            d d2 = (d)object;
            if (this.z != d2.z) {
                return false;
            }
            List<a> list = this.A;
            List<a> list2 = d2.A;
            return !(list != null ? !list.equals(list2) : list2 != null);
        }
        return false;
    }

    public int hashCode() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(w, this, this);
        e.b().c(a2);
        int n2 = 31 * (0 + this.z);
        List<a> list = this.A;
        int n3 = 0;
        if (list != null) {
            n3 = list.hashCode();
        }
        return n2 + n3;
    }

    public void s(List<a> list) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(u, this, this, list);
        e.b().c(a2);
        this.A = list;
    }

    public void t(String string) {
        h.a.f.a.a a2 = h.a.f.b.b.b.d(q, this, this, string);
        e.b().c(a2);
        this.y = string;
    }

    public String toString() {
        h.a.f.a.a a2 = h.a.f.b.b.b.c(x, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        String string = this.A.size() > 0 ? ((a)this.A.get(0)).b() : "????";
        stringBuilder.append(string);
        stringBuilder.append('\'');
        stringBuilder.append(", defaultLength=");
        stringBuilder.append(this.z);
        stringBuilder.append(", groupEntries=");
        stringBuilder.append(this.A);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

