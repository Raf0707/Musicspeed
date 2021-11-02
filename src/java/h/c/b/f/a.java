/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package h.c.b.f;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class a {
    private static Object a(Class<?> class_) {
        try {
            Object object = class_.getDeclaredMethod("getReflectionFactory", new Class[0]).invoke(null, new Object[0]);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new h.c.a(invocationTargetException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new h.c.a(illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new h.c.a(illegalAccessException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new h.c.a(noSuchMethodException);
        }
    }

    private static Method b(Class<?> class_) {
        try {
            Method method = class_.getDeclaredMethod("newConstructorForSerialization", new Class[]{Class.class, Constructor.class});
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new h.c.a(noSuchMethodException);
        }
    }

    private static Class<?> c() {
        try {
            Class class_ = Class.forName((String)"sun.reflect.ReflectionFactory");
            return class_;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new h.c.a(classNotFoundException);
        }
    }

    public static <T> Constructor<T> d(Class<T> class_, Constructor<?> constructor) {
        Class<?> class_2 = a.c();
        Object object = a.a(class_2);
        Method method = a.b(class_2);
        try {
            Constructor constructor2 = (Constructor)method.invoke(object, new Object[]{class_, constructor});
            return constructor2;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new h.c.a(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new h.c.a(illegalAccessException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new h.c.a(illegalArgumentException);
        }
    }
}

