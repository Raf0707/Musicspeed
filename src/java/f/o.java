/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package f;

import f.f;
import f.r;
import f.z.c.a;
import f.z.d.g;
import f.z.d.k;
import java.io.Serializable;

final class o<T>
implements f<T>,
Serializable {
    private a<? extends T> f;
    private volatile Object g;
    private final Object h;

    public o(a<? extends T> a2, Object object) {
        k.g(a2, "initializer");
        this.f = a2;
        this.g = r.a;
        if (object == null) {
            object = this;
        }
        this.h = object;
    }

    public /* synthetic */ o(a a2, Object object, int n2, g g2) {
        if ((n2 & 2) != 0) {
            object = null;
        }
        this(a2, object);
    }

    public boolean a() {
        return this.g != r.a;
    }

    @Override
    public T getValue() {
        Object object;
        Object object2 = this.g;
        r r2 = r.a;
        if (object2 != r2) {
            return (T)object2;
        }
        Object object3 = object = this.h;
        synchronized (object3) {
            Object object4;
            block5 : {
                object4 = this.g;
                if (object4 != r2) break block5;
                a<T> a2 = this.f;
                k.e(a2);
                this.g = object4 = a2.invoke();
                this.f = null;
            }
            return (T)object4;
        }
    }

    public String toString() {
        if (this.a()) {
            return String.valueOf(this.getValue());
        }
        return "Lazy value not initialized yet.";
    }
}

