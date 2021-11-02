/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.e.c.l
 *  com.google.gson.internal.a
 *  com.google.gson.internal.f
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.math.BigInteger
 */
package c.e.c;

import c.e.c.l;
import com.google.gson.internal.a;
import com.google.gson.internal.f;
import java.math.BigInteger;

public final class q
extends l {
    private final Object a;

    public q(Boolean bl) {
        this.a = a.b((Object)bl);
    }

    public q(Number number) {
        this.a = a.b((Object)number);
    }

    public q(String string) {
        this.a = a.b((Object)string);
    }

    private static boolean o(q q2) {
        boolean bl;
        block2 : {
            block3 : {
                Object object = q2.a;
                boolean bl2 = object instanceof Number;
                bl = false;
                if (!bl2) break block2;
                Number number = (Number)object;
                if (number instanceof BigInteger || number instanceof Long || number instanceof Integer || number instanceof Short) break block3;
                boolean bl3 = number instanceof Byte;
                bl = false;
                if (!bl3) break block2;
            }
            bl = true;
        }
        return bl;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return bl;
        }
        if (object != null) {
            if (q.class != object.getClass()) {
                return false;
            }
            q q2 = (q)((Object)object);
            if (this.a == null) {
                if (q2.a == null) {
                    return bl;
                }
                return false;
            }
            if (q.o(this) && q.o(q2)) {
                if (this.l().longValue() == q2.l().longValue()) {
                    return bl;
                }
                return false;
            }
            Object object2 = this.a;
            if (object2 instanceof Number && q2.a instanceof Number) {
                double d2;
                double d3 = this.l().doubleValue();
                if (d3 != (d2 = q2.l().doubleValue())) {
                    if (Double.isNaN((double)d3) && Double.isNaN((double)d2)) {
                        return bl;
                    }
                    bl = false;
                }
                return bl;
            }
            return object2.equals(q2.a);
        }
        return false;
    }

    public boolean h() {
        if (this.n()) {
            return (Boolean)this.a;
        }
        return Boolean.parseBoolean((String)this.m());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        long l2;
        if (this.a == null) {
            return 31;
        }
        if (q.o(this)) {
            l2 = this.l().longValue();
            do {
                return (int)(l2 ^ l2 >>> 32);
                break;
            } while (true);
        }
        Object object = this.a;
        if (!(object instanceof Number)) return object.hashCode();
        l2 = Double.doubleToLongBits((double)this.l().doubleValue());
        return (int)(l2 ^ l2 >>> 32);
    }

    public double i() {
        if (this.p()) {
            return this.l().doubleValue();
        }
        return Double.parseDouble((String)this.m());
    }

    public int j() {
        if (this.p()) {
            return this.l().intValue();
        }
        return Integer.parseInt((String)this.m());
    }

    public long k() {
        if (this.p()) {
            return this.l().longValue();
        }
        return Long.parseLong((String)this.m());
    }

    public Number l() {
        Object object = this.a;
        if (object instanceof String) {
            return new f((String)this.a);
        }
        return (Number)object;
    }

    public String m() {
        if (this.p()) {
            return this.l().toString();
        }
        if (this.n()) {
            return ((Boolean)this.a).toString();
        }
        return (String)this.a;
    }

    public boolean n() {
        return this.a instanceof Boolean;
    }

    public boolean p() {
        return this.a instanceof Number;
    }

    public boolean q() {
        return this.a instanceof String;
    }
}

