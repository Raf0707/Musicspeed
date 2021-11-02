/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package b.i.i;

import android.graphics.Typeface;
import b.i.i.g;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class h
extends g {
    @Override
    protected Typeface l(Object object) {
        void var2_8;
        try {
            Object object2 = Array.newInstance(this.g, (int)1);
            Array.set((Object)object2, (int)0, (Object)object);
            Method method = this.m;
            Object[] arrobject = new Object[]{object2, "sans-serif", -1, -1};
            Typeface typeface = (Typeface)method.invoke(null, arrobject);
            return typeface;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        throw new RuntimeException((Throwable)var2_8);
    }

    @Override
    protected Method x(Class<?> class_) throws NoSuchMethodException {
        Class class_2;
        Object object = Array.newInstance(class_, (int)1);
        Class[] arrclass = new Class[]{object.getClass(), String.class, class_2 = Integer.TYPE, class_2};
        Method method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arrclass);
        method.setAccessible(true);
        return method;
    }
}

