/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  sun.misc.Unsafe
 */
package h.c.b.f;

import h.c.a;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class c<T>
implements h.c.b.a<T> {
    private static Unsafe a;
    private final Class<T> b;

    public c(Class<T> class_) {
        if (a == null) {
            Field field;
            try {
                field = Unsafe.class.getDeclaredField("theUnsafe");
            }
            catch (NoSuchFieldException noSuchFieldException) {
                throw new a(noSuchFieldException);
            }
            field.setAccessible(true);
            try {
                a = (Unsafe)field.get(null);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new a(illegalAccessException);
            }
        }
        this.b = class_;
    }

    @Override
    public T newInstance() {
        Object object;
        try {
            Class<T> class_ = this.b;
            object = class_.cast(a.allocateInstance(class_));
        }
        catch (InstantiationException instantiationException) {
            throw new a(instantiationException);
        }
        return (T)object;
    }
}

