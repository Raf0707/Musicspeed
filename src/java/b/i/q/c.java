/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package b.i.q;

public final class c {
    private final Object a;

    private c(Object object) {
        this.a = object;
    }

    static c a(Object object) {
        if (object == null) {
            return null;
        }
        return new c(object);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && c.class == object.getClass()) {
            c c2 = (c)object;
            return b.i.p.c.a(this.a, c2.a);
        }
        return false;
    }

    public int hashCode() {
        Object object = this.a;
        if (object == null) {
            return 0;
        }
        return object.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DisplayCutoutCompat{");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

