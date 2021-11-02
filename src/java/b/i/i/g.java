/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.fonts.FontVariationAxis
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
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.nio.ByteBuffer
 */
package b.i.i;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.util.Log;
import b.i.h.d.c;
import b.i.i.e;
import b.i.i.j;
import b.i.n.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class g
extends e {
    protected final Class<?> g;
    protected final Constructor<?> h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;

    public g() {
        Method method;
        Method method2;
        Method method3;
        Class<?> class_;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        block3 : {
            void var2_12;
            class_ = null;
            try {
                Method method6;
                Class<?> class_2 = this.y();
                constructor = this.z(class_2);
                method2 = this.v(class_2);
                method5 = this.w(class_2);
                method = this.A(class_2);
                method3 = this.u(class_2);
                method4 = method6 = this.x(class_2);
                class_ = class_2;
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to collect necessary methods for class ");
            stringBuilder.append(var2_12.getClass().getName());
            Log.e((String)"TypefaceCompatApi26Impl", (String)stringBuilder.toString(), (Throwable)var2_12);
            method4 = null;
            constructor = null;
            method2 = null;
            method5 = null;
            method = null;
            method3 = null;
        }
        this.g = class_;
        this.h = constructor;
        this.i = method2;
        this.j = method5;
        this.k = method;
        this.l = method3;
        this.m = method4;
    }

    private Object o() {
        try {
            Object object = this.h.newInstance(new Object[0]);
            return object;
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException throwable) {
            return null;
        }
    }

    private void p(Object object) {
        try {
            this.l.invoke(object, new Object[0]);
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {}
    }

    private boolean q(Context context, Object object, String string, int n2, int n3, int n4, FontVariationAxis[] arrfontVariationAxis) {
        try {
            Method method = this.i;
            Object[] arrobject = new Object[]{context.getAssets(), string, 0, Boolean.FALSE, n2, n3, n4, arrfontVariationAxis};
            boolean bl = (Boolean)method.invoke(object, arrobject);
            return bl;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return false;
        }
    }

    private boolean r(Object object, ByteBuffer byteBuffer, int n2, int n3, int n4) {
        try {
            Method method = this.j;
            Object[] arrobject = new Object[]{byteBuffer, n2, null, n3, n4};
            boolean bl = (Boolean)method.invoke(object, arrobject);
            return bl;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return false;
        }
    }

    private boolean s(Object object) {
        try {
            boolean bl = (Boolean)this.k.invoke(object, new Object[0]);
            return bl;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return false;
        }
    }

    private boolean t() {
        if (this.i == null) {
            Log.w((String)"TypefaceCompatApi26Impl", (String)"Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    protected Method A(Class<?> class_) throws NoSuchMethodException {
        return class_.getMethod("freeze", new Class[0]);
    }

    @Override
    public Typeface b(Context context, c.b b2, Resources resources, int n2) {
        if (!this.t()) {
            return super.b(context, b2, resources, n2);
        }
        Object object = this.o();
        if (object == null) {
            return null;
        }
        for (c.c c2 : b2.a()) {
            if (this.q(context, object, c2.a(), c2.c(), c2.e(), (int)c2.f(), FontVariationAxis.fromFontVariationSettings((String)c2.d()))) continue;
            this.p(object);
            return null;
        }
        if (!this.s(object)) {
            return null;
        }
        return this.l(object);
    }

    /*
     * Exception decompiling
     */
    @Override
    public Typeface c(Context var1_1, CancellationSignal var2_2, f.b[] var3_3, int var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public Typeface e(Context context, Resources resources, int n2, String string, int n3) {
        if (!this.t()) {
            return j.super.e(context, resources, n2, string, n3);
        }
        Object object = this.o();
        if (object == null) {
            return null;
        }
        if (!this.q(context, object, string, 0, -1, -1, null)) {
            this.p(object);
            return null;
        }
        if (!this.s(object)) {
            return null;
        }
        return this.l(object);
    }

    protected Typeface l(Object object) {
        try {
            Object object2 = Array.newInstance(this.g, (int)1);
            Array.set((Object)object2, (int)0, (Object)object);
            Method method = this.m;
            Object[] arrobject = new Object[]{object2, -1, -1};
            Typeface typeface = (Typeface)method.invoke(null, arrobject);
            return typeface;
        }
        catch (IllegalAccessException | InvocationTargetException throwable) {
            return null;
        }
    }

    protected Method u(Class<?> class_) throws NoSuchMethodException {
        return class_.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> class_) throws NoSuchMethodException {
        Class class_2 = Integer.TYPE;
        Class[] arrclass = new Class[]{AssetManager.class, String.class, class_2, Boolean.TYPE, class_2, class_2, class_2, FontVariationAxis[].class};
        return class_.getMethod("addFontFromAssetManager", arrclass);
    }

    protected Method w(Class<?> class_) throws NoSuchMethodException {
        Class class_2 = Integer.TYPE;
        Class[] arrclass = new Class[]{ByteBuffer.class, class_2, FontVariationAxis[].class, class_2, class_2};
        return class_.getMethod("addFontFromBuffer", arrclass);
    }

    protected Method x(Class<?> class_) throws NoSuchMethodException {
        Class class_2;
        Object object = Array.newInstance(class_, (int)1);
        Class[] arrclass = new Class[]{object.getClass(), class_2 = Integer.TYPE, class_2};
        Method method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arrclass);
        method.setAccessible(true);
        return method;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName((String)"android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> class_) throws NoSuchMethodException {
        return class_.getConstructor(new Class[0]);
    }
}

