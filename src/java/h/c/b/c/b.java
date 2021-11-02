/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 */
package h.c.b.c;

import h.c.a;
import java.lang.reflect.Constructor;

public class b<T>
implements h.c.b.a<T> {
    protected Constructor<T> a;

    public b(Class<T> class_) {
        try {
            this.a = class_.getDeclaredConstructor(null);
            return;
        }
        catch (Exception exception) {
            throw new a(exception);
        }
    }

    @Override
    public T newInstance() {
        Object object;
        try {
            object = this.a.newInstance(null);
        }
        catch (Exception exception) {
            throw new a(exception);
        }
        return (T)object;
    }
}

