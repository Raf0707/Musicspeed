/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.d0;

import f.d0.b;

final class a
implements b<Float> {
    private final float f;
    private final float g;

    public a(float f2, float f3) {
        this.f = f2;
        this.g = f3;
    }

    public Float a() {
        return Float.valueOf((float)this.g);
    }

    public Float d() {
        return Float.valueOf((float)this.f);
    }

    public boolean e() {
        return !(this.f <= this.g);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (!(object instanceof a)) break block2;
                if (this.e() && ((a)object).e()) break block3;
                float f2 = this.f;
                a a2 = (a)object;
                if (f2 != a2.f || this.g != a2.g) break block2;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.e()) {
            return -1;
        }
        return 31 * Float.valueOf((float)this.f).hashCode() + Float.valueOf((float)this.g).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append("..");
        stringBuilder.append(this.g);
        return stringBuilder.toString();
    }
}

