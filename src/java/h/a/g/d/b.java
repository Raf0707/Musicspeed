/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.util.LinkedList
 *  java.util.List
 */
package h.a.g.d;

import h.a.j.d;
import h.a.j.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class b
extends h.a.g.d.a {
    private short a;
    private short b;
    private List<a> c = new LinkedList();
    private int d;
    private int e;
    private short f;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ByteBuffer a() {
        short s2 = this.a;
        int n2 = s2 == 1 ? 13 : 11 + s2 * 6;
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)n2);
        byteBuffer.putShort(this.a);
        if (this.a == 1) {
            byteBuffer.putShort(this.b);
        } else {
            for (a a2 : this.c) {
                byteBuffer.putInt(a2.a());
                byteBuffer.putShort(a2.b());
            }
        }
        byteBuffer.putInt(this.d);
        byteBuffer.putInt(this.e);
        e.j(byteBuffer, this.f);
        byteBuffer.rewind();
        return byteBuffer;
    }

    @Override
    public String b() {
        return "rash";
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void c(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.getShort();
        this.a = (short)n2;
        if (n2 == 1) {
            this.b = byteBuffer.getShort();
        } else {
            do {
                int n3 = n2 - 1;
                if (n2 <= 0) break;
                this.c.add(new Object(h.a.j.a.a(d.j(byteBuffer)), byteBuffer.getShort()){
                    int a;
                    short b;
                    {
                        this.a = n2;
                        this.b = s2;
                    }

                    public int a() {
                        return this.a;
                    }

                    public short b() {
                        return this.b;
                    }

                    public boolean equals(Object object) {
                        if (this == object) {
                            return true;
                        }
                        if (object != null) {
                            if (a.class != object.getClass()) {
                                return false;
                            }
                            a a2 = object;
                            if (this.a != a2.a) {
                                return false;
                            }
                            return this.b == a2.b;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return 31 * this.a + this.b;
                    }

                    public String toString() {
                        StringBuilder stringBuilder = new StringBuilder("{availableBitrate=");
                        stringBuilder.append(this.a);
                        stringBuilder.append(", targetRateShare=");
                        stringBuilder.append((int)this.b);
                        stringBuilder.append('}');
                        return stringBuilder.toString();
                    }
                });
                n2 = n3;
            } while (true);
        }
        this.d = h.a.j.a.a(d.j(byteBuffer));
        this.e = h.a.j.a.a(d.j(byteBuffer));
        this.f = (short)d.m(byteBuffer);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (b.class != object.getClass()) {
                return false;
            }
            b b2 = (b)object;
            if (this.f != b2.f) {
                return false;
            }
            if (this.d != b2.d) {
                return false;
            }
            if (this.e != b2.e) {
                return false;
            }
            if (this.a != b2.a) {
                return false;
            }
            if (this.b != b2.b) {
                return false;
            }
            List<a> list = this.c;
            List<a> list2 = b2.c;
            return !(list != null ? !list.equals(list2) : list2 != null);
        }
        return false;
    }

    public int hashCode() {
        int n2 = 31 * (31 * this.a + this.b);
        List<a> list = this.c;
        int n3 = list != null ? list.hashCode() : 0;
        return 31 * (31 * (31 * (n2 + n3) + this.d) + this.e) + this.f;
    }

}

