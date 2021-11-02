/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Constructor
 */
package h.c.b.c;

import h.c.b.c.b;
import java.lang.reflect.Constructor;

public class a<T>
extends b<T> {
    public a(Class<T> class_) {
        super(class_);
        Constructor constructor = this.a;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
    }
}

