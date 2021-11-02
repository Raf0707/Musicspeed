/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ObjectInputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package h.c.b.b;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class a<T>
implements h.c.b.a<T> {
    private final Class<T> a;
    private final Method b;

    public a(Class<T> class_) {
        this.a = class_;
        this.b = a.a();
    }

    private static Method a() {
        try {
            Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new h.c.a(noSuchMethodException);
        }
        catch (RuntimeException runtimeException) {
            throw new h.c.a(runtimeException);
        }
    }

    @Override
    public T newInstance() {
        Object object;
        try {
            Class<T> class_ = this.a;
            object = class_.cast(this.b.invoke(null, new Object[]{class_, Object.class}));
        }
        catch (Exception exception) {
            throw new h.c.a(exception);
        }
        return (T)object;
    }
}

