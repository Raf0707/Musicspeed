/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package f.z.d;

import f.z.d.h;
import f.z.d.k;
import f.z.d.z;
import java.io.Serializable;

public abstract class l<R>
implements h<R>,
Serializable {
    private final int f;

    public l(int n2) {
        this.f = n2;
    }

    @Override
    public int getArity() {
        return this.f;
    }

    public String toString() {
        String string = z.h(this);
        k.f(string, "Reflection.renderLambdaToString(this)");
        return string;
    }
}

