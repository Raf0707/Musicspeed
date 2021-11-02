/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ObjectInputStream
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package h.c.b.d;

import h.c.b.d.b;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a<T>
extends b<T> {
    public a(Class<T> class_) {
        super(class_);
    }

    @Override
    public T newInstance() {
        Object object;
        try {
            Class class_ = this.c;
            object = class_.cast(b.a.invoke((Object)b.b, new Object[]{class_, Object.class}));
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new h.c.a(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new h.c.a(illegalAccessException);
        }
        catch (RuntimeException runtimeException) {
            throw new h.c.a(runtimeException);
        }
        return (T)object;
    }
}

