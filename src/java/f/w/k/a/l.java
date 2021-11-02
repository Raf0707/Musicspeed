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
import f.z.d.h;
import f.z.d.k;
import f.z.d.z;

public abstract class l
extends f.w.k.a.d
implements h<Object> {
    private final int i;

    public l(int n2, d<Object> d2) {
        super(d2);
        this.i = n2;
    }

    @Override
    public int getArity() {
        return this.i;
    }

    @Override
    public String toString() {
        if (this.o() == null) {
            String string = z.g(this);
            k.f(string, "Reflection.renderLambdaToString(this)");
            return string;
        }
        return a.super.toString();
    }
}

