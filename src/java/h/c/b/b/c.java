/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ObjectStreamClass
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Long
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package h.c.b.b;

import h.c.a;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c<T>
implements h.c.b.a<T> {
    private final Class<T> a;
    private final Method b;
    private final Long c;

    public c(Class<T> class_) {
        this.a = class_;
        this.b = c.b();
        this.c = c.a();
    }

    private static Long a() {
        try {
            Method method = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
            method.setAccessible(true);
            Long l2 = (Long)method.invoke(null, new Object[]{Object.class});
            return l2;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new a(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new a(illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new a(noSuchMethodException);
        }
        catch (RuntimeException runtimeException) {
            throw new a(runtimeException);
        }
    }

    private static Method b() {
        try {
            Class[] arrclass = new Class[]{Class.class, Long.TYPE};
            Method method = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrclass);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new a(noSuchMethodException);
        }
        catch (RuntimeException runtimeException) {
            throw new a(runtimeException);
        }
    }

    @Override
    public T newInstance() {
        Object object;
        try {
            Class<T> class_ = this.a;
            Method method = this.b;
            Object[] arrobject = new Object[]{class_, this.c};
            object = class_.cast(method.invoke(null, arrobject));
        }
        catch (Exception exception) {
            throw new a(exception);
        }
        return (T)object;
    }
}

