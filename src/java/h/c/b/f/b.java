/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 */
package h.c.b.f;

import h.c.a;
import java.lang.reflect.Constructor;

public class b<T>
implements h.c.b.a<T> {
    private final Constructor<T> a;

    public b(Class<T> class_) {
        Constructor<T> constructor = h.c.b.f.a.d(class_, b.a());
        this.a = constructor;
        constructor.setAccessible(true);
    }

    private static Constructor<Object> a() {
        try {
            Constructor constructor = Object.class.getConstructor(null);
            return constructor;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new a(noSuchMethodException);
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

