/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package f.w.k.a;

import f.w.d;
import f.w.k.a.a;
import f.w.k.a.j;
import f.z.d.h;
import f.z.d.z;

public abstract class k
extends j
implements h<Object> {
    private final int g;

    public k(int n2, d<Object> d2) {
        super(d2);
        this.g = n2;
    }

    @Override
    public int getArity() {
        return this.g;
    }

    @Override
    public String toString() {
        if (this.o() == null) {
            String string = z.g(this);
            f.z.d.k.f(string, "Reflection.renderLambdaToString(this)");
            return string;
        }
        return a.super.toString();
    }
}

