/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.a.g.b.a.b$b
 *  h.a.g.b.a.b$c
 *  h.a.g.b.a.b$d
 *  h.a.g.b.a.b$e
 *  h.a.g.b.a.b$f
 *  h.a.g.b.a.b$g
 *  h.a.g.b.a.b$h
 *  h.a.g.b.a.b$i
 *  h.a.g.b.a.b$k
 *  h.a.g.b.a.b$l
 *  h.a.g.b.a.b$m
 *  h.a.g.b.a.b$n
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.Arrays
 */
package h.a.g.b.a;

import h.a.g.b.a.b;
import java.math.BigInteger;
import java.util.Arrays;

/*
 * Exception performing whole class analysis.
 */
public class b {
    public byte[] a;
    public j[] b;

    public b() {
        this.a = new byte[0];
        this.b = null;
    }

    public j a(int n2, long l2) {
        if (n2 <= 127) {
            if (l2 <= 127L) {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            if (l2 <= 32767L) {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            if (l2 <= Integer.MAX_VALUE) {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (n2 <= 32767) {
            if (l2 <= 127L) {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            if (l2 <= 32767L) {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            if (l2 <= Integer.MAX_VALUE) {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (l2 <= 127L) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (l2 <= 32767L) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (l2 <= Integer.MAX_VALUE) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public int b() {
        int n2 = this.a.length;
        j[] arrj = this.b;
        if (arrj != null && arrj.length > 0) {
            n2 = n2 + 2 + 6 * arrj.length;
        }
        return n2;
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
            if (!new BigInteger(this.a).equals((Object)new BigInteger(b2.a))) {
                return false;
            }
            Object[] arrobject = this.b;
            Object[] arrobject2 = b2.b;
            return !(arrobject != null ? !Arrays.equals((Object[])arrobject, (Object[])arrobject2) : arrobject2 != null);
        }
        return false;
    }

    public int hashCode() {
        byte[] arrby = this.a;
        int n2 = arrby != null ? Arrays.hashCode((byte[])arrby) : 0;
        int n3 = n2 * 31;
        Object[] arrobject = this.b;
        int n4 = 0;
        if (arrobject != null) {
            n4 = Arrays.hashCode((Object[])arrobject);
        }
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Entry{iv=");
        stringBuilder.append(h.a.j.c.a(this.a));
        stringBuilder.append(", pairs=");
        stringBuilder.append(Arrays.toString((Object[])this.b));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static interface j {
        public long a();

        public int clear();
    }

}

