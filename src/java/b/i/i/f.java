/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.nio.ByteBuffer
 *  java.util.List
 */
package b.i.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import b.e.g;
import b.i.h.d.c;
import b.i.i.j;
import b.i.i.k;
import b.i.n.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class f
extends j {
    private static final Class<?> b;
    private static final Constructor<?> c;
    private static final Method d;
    private static final Method e;

    static {
        Method method;
        Constructor constructor;
        Class class_;
        Method method2;
        block3 : {
            void var1_12;
            constructor = null;
            try {
                Method method3;
                class_ = Class.forName((String)"android.graphics.FontFamily");
                Constructor constructor2 = class_.getConstructor(new Class[0]);
                Class class_2 = Integer.TYPE;
                Class[] arrclass = new Class[]{ByteBuffer.class, class_2, List.class, class_2, Boolean.TYPE};
                method2 = class_.getMethod("addFontWeightStyle", arrclass);
                Object object = Array.newInstance((Class)class_, (int)1);
                Class[] arrclass2 = new Class[]{object.getClass()};
                method = method3 = Typeface.class.getMethod("createFromFamiliesWithDefault", arrclass2);
                constructor = constructor2;
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            Log.e((String)"TypefaceCompatApi24Impl", (String)var1_12.getClass().getName(), (Throwable)var1_12);
            class_ = null;
            method = null;
            method2 = null;
        }
        c = constructor;
        b = class_;
        d = method2;
        e = method;
    }

    f() {
    }

    private static boolean k(Object object, ByteBuffer byteBuffer, int n2, int n3, boolean bl) {
        try {
            Method method = d;
            Object[] arrobject = new Object[]{byteBuffer, n2, null, n3, bl};
            boolean bl2 = (Boolean)method.invoke(object, arrobject);
            return bl2;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return false;
        }
    }

    private static Typeface l(Object object) {
        try {
            Object object2 = Array.newInstance(b, (int)1);
            Array.set((Object)object2, (int)0, (Object)object);
            Typeface typeface = (Typeface)e.invoke(null, new Object[]{object2});
            return typeface;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return null;
        }
    }

    public static boolean m() {
        Method method = d;
        if (method == null) {
            Log.w((String)"TypefaceCompatApi24Impl", (String)"Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            Object object = c.newInstance(new Object[0]);
            return object;
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException throwable) {
            return null;
        }
    }

    @Override
    public Typeface b(Context context, c.b b2, Resources resources, int n2) {
        Object object = f.n();
        if (object == null) {
            return null;
        }
        for (c.c c2 : b2.a()) {
            ByteBuffer byteBuffer = k.b(context, resources, c2.b());
            if (byteBuffer == null) {
                return null;
            }
            if (f.k(object, byteBuffer, c2.c(), c2.e(), c2.f())) continue;
            return null;
        }
        return f.l(object);
    }

    @Override
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] arrb, int n2) {
        Object object = f.n();
        if (object == null) {
            return null;
        }
        g<Uri, ByteBuffer> g2 = new g<Uri, ByteBuffer>();
        for (f.b b2 : arrb) {
            Uri uri = b2.d();
            ByteBuffer byteBuffer = (ByteBuffer)g2.get((Object)uri);
            if (byteBuffer == null) {
                byteBuffer = k.f(context, cancellationSignal, uri);
                g2.put(uri, byteBuffer);
            }
            if (byteBuffer == null) {
                return null;
            }
            if (f.k(object, byteBuffer, b2.c(), b2.e(), b2.f())) continue;
            return null;
        }
        Typeface typeface = f.l(object);
        if (typeface == null) {
            return null;
        }
        return Typeface.create((Typeface)typeface, (int)n2);
    }
}

