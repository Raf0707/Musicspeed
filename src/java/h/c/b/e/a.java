/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ObjectInputStream
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package h.c.b.e;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class a<T>
implements h.c.b.a<T> {
    private final Method a;
    private final Object[] b;

    public a(Class<T> class_) {
        Object[] arrobject = new Object[]{null, Boolean.FALSE};
        this.b = arrobject;
        arrobject[0] = class_;
        try {
            Method method;
            Class[] arrclass = new Class[]{Class.class, Boolean.TYPE};
            this.a = method = ObjectInputStream.class.getDeclaredMethod("newInstance", arrclass);
            method.setAccessible(true);
            return;
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
            object = this.a.invoke(null, this.b);
        }
        catch (Exception exception) {
            throw new h.c.a(exception);
        }
        return (T)object;
    }
}

