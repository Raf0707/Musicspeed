/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.lang.Class
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package h.c.b.d;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public abstract class b<T>
implements h.c.b.a<T> {
    static Method a;
    static ObjectInputStream b;
    protected final Class<T> c;

    public b(Class<T> class_) {
        this.c = class_;
        b.a();
    }

    private static void a() {
        if (a == null) {
            try {
                Method method;
                a = method = ObjectInputStream.class.getDeclaredMethod("newObject", new Class[]{Class.class, Class.class});
                method.setAccessible(true);
                b = new ObjectInputStream(){};
                return;
            }
            catch (IOException iOException) {
                throw new h.c.a(iOException);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new h.c.a(noSuchMethodException);
            }
            catch (RuntimeException runtimeException) {
                throw new h.c.a(runtimeException);
            }
        }
    }

}

