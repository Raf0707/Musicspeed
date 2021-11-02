/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package f.d0;

import f.d0.c;
import f.d0.d;
import f.z.d.g;

public final class f
extends d
implements c<Integer> {
    private static final f j;
    public static final a k;

    static {
        k = new Object(null){
            {
                this();
            }

            public final f a() {
                return j;
            }
        };
        j = new f(1, 0);
    }

    public f(int n2, int n3) {
        super(n2, n3, 1);
    }

    @Override
    public boolean equals(Object object) {
        f f2;
        int n2;
        return object instanceof f && (this.isEmpty() && ((f)object).isEmpty() || (n2 = this.d()) == (f2 = (f)object).d() && this.e() == f2.e());
    }

    @Override
    public int hashCode() {
        if (this.isEmpty()) {
            return -1;
        }
        return 31 * this.d() + this.e();
    }

    public Integer i() {
        return this.e();
    }

    @Override
    public boolean isEmpty() {
        return this.d() > this.e();
    }

    public Integer j() {
        return this.d();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d());
        stringBuilder.append("..");
        stringBuilder.append(this.e());
        return stringBuilder.toString();
    }

}

