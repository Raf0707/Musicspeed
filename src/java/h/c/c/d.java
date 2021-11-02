/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 */
package h.c.c;

import h.c.b.f.b;
import h.c.c.a;
import h.c.c.c;
import java.io.Serializable;

public class d
extends a {
    @Override
    public <T> h.c.b.a<T> newInstantiatorOf(Class<T> class_) {
        if (!c.h("Java HotSpot") && !c.h("OpenJDK")) {
            if (c.h("Dalvik")) {
                if (c.f()) {
                    return new h.c.b.f.c<T>(class_);
                }
                int n2 = c.g;
                if (n2 <= 10) {
                    return new h.c.b.b.a<T>(class_);
                }
                if (n2 <= 17) {
                    return new h.c.b.b.b<T>(class_);
                }
                return new h.c.b.b.c<T>(class_);
            }
            if (c.h("BEA")) {
                return new b<T>(class_);
            }
            if (c.h("GNU libgcj")) {
                return new h.c.b.d.a<T>(class_);
            }
            if (c.h("PERC")) {
                return new h.c.b.e.a<T>(class_);
            }
            return new h.c.b.f.c<T>(class_);
        }
        if (c.g()) {
            if (Serializable.class.isAssignableFrom(class_)) {
                return new h.c.b.c.c<T>(class_);
            }
            return new h.c.b.c.a<T>(class_);
        }
        return new b<T>(class_);
    }
}

