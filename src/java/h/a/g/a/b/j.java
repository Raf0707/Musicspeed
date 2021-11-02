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
 *  java.util.HashMap
 *  java.util.Map
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
import java.util.HashMap;
import java.util.Map;

public class j
extends h.a.i.c {
    public static final Map<String, String> p;
    private static /* synthetic */ a.a q;
    private static /* synthetic */ a.a r;
    private static /* synthetic */ a.a s;
    private static /* synthetic */ a.a t;
    private static /* synthetic */ a.a u;
    private static /* synthetic */ a.a v;
    private long A;
    private boolean B = true;
    private long C;
    private String w;
    private String x = null;
    private long y;
    private long z;

    static {
        j.k();
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"odsm", (Object)"ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"crsm", (Object)"ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"sdsm", (Object)"SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"m7sm", (Object)"MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"ocsm", (Object)"ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"ipsm", (Object)"IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"mjsm", (Object)"MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put((Object)"mdir", (Object)"Apple Meta Data iTunes Reader");
        hashMap.put((Object)"mp7b", (Object)"MPEG-7 binary XML");
        hashMap.put((Object)"mp7t", (Object)"MPEG-7 XML");
        hashMap.put((Object)"vide", (Object)"Video Track");
        hashMap.put((Object)"soun", (Object)"Sound Track");
        hashMap.put((Object)"hint", (Object)"Hint Track");
        hashMap.put((Object)"appl", (Object)"Apple specific");
        hashMap.put((Object)"meta", (Object)"Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        p = Collections.unmodifiableMap((Map)hashMap);
    }

    public j() {
        super("hdlr");
    }

    private static /* synthetic */ void k() {
        b b2 = new b("HandlerBox.java", j.class);
        q = b2.g("method-execution", b2.f("1", "getHandlerType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 78);
        r = b2.g("method-execution", b2.f("1", "setHandlerType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "java.lang.String", "handlerType", "", "void"), 82);
        s = b2.g("method-execution", b2.f("1", "getName", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 86);
        t = b2.g("method-execution", b2.f("1", "setName", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "java.lang.String", "name", "", "void"), 95);
        u = b2.g("method-execution", b2.f("1", "getHumanReadableTrackType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 99);
        v = b2.g("method-execution", b2.f("1", "toString", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    @Override
    public void c(ByteBuffer byteBuffer) {
        this.n(byteBuffer);
        this.C = h.a.j.d.j(byteBuffer);
        this.w = h.a.j.d.b(byteBuffer);
        this.y = h.a.j.d.j(byteBuffer);
        this.z = h.a.j.d.j(byteBuffer);
        this.A = h.a.j.d.j(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            String string;
            this.x = string = h.a.j.d.g(byteBuffer, byteBuffer.remaining());
            if (string.endsWith("\u0000")) {
                String string2 = this.x;
                this.x = string2.substring(0, string2.length() - 1);
                this.B = true;
                return;
            }
            this.B = false;
            return;
        }
        this.B = false;
    }

    @Override
    protected void d(ByteBuffer byteBuffer) {
        this.q(byteBuffer);
        h.a.j.e.g(byteBuffer, this.C);
        byteBuffer.put(d.w(this.w));
        h.a.j.e.g(byteBuffer, this.y);
        h.a.j.e.g(byteBuffer, this.z);
        h.a.j.e.g(byteBuffer, this.A);
        String string = this.x;
        if (string != null) {
            byteBuffer.put(h.a.j.j.b(string));
        }
        if (this.B) {
            byteBuffer.put((byte)0);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected long e() {
        int n2;
        if (this.B) {
            n2 = 25 + h.a.j.j.c(this.x);
            do {
                return n2;
                break;
            } while (true);
        }
        n2 = 24 + h.a.j.j.c(this.x);
        return n2;
    }

    public String r() {
        h.a.f.a.a a2 = b.c(q, this, this);
        e.b().c(a2);
        return this.w;
    }

    public String s() {
        h.a.f.a.a a2 = b.c(s, this, this);
        e.b().c(a2);
        return this.x;
    }

    public void t(String string) {
        h.a.f.a.a a2 = b.d(r, this, this, string);
        e.b().c(a2);
        this.w = string;
    }

    public String toString() {
        h.a.f.a.a a2 = b.c(v, this, this);
        e.b().c(a2);
        StringBuilder stringBuilder = new StringBuilder("HandlerBox[handlerType=");
        stringBuilder.append(this.r());
        stringBuilder.append(";name=");
        stringBuilder.append(this.s());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

