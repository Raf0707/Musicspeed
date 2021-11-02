/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  android.util.Log
 *  b.i.h.d.c$b
 *  b.i.i.j$a
 *  b.i.i.j$b
 *  java.io.File
 *  java.io.InputStream
 *  java.lang.IllegalAccessException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.concurrent.ConcurrentHashMap
 */
package b.i.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import b.i.h.d.c;
import b.i.i.d;
import b.i.i.j;
import b.i.i.k;
import b.i.n.f;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class j {
    @SuppressLint(value={"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, c.b> a = new ConcurrentHashMap();

    j() {
    }

    private void a(Typeface typeface, c.b b2) {
        long l2 = j.j(typeface);
        if (l2 != 0L) {
            this.a.put((Object)l2, (Object)b2);
        }
    }

    private c.c f(c.b b2, int n2) {
        return j.g(b2.a(), n2, new b(this));
    }

    private static <T> T g(T[] arrT, int n2, c<T> c2) {
        int n3 = (n2 & 1) == 0 ? 400 : 700;
        boolean bl = (n2 & 2) != 0;
        T t2 = null;
        int n4 = Integer.MAX_VALUE;
        for (T t3 : arrT) {
            int n5 = 2 * Math.abs((int)(c2.a(t3) - n3));
            int n6 = c2.b(t3) == bl ? 0 : 1;
            int n7 = n5 + n6;
            if (t2 != null && n4 <= n7) continue;
            t2 = t3;
            n4 = n7;
        }
        return t2;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
            long l2 = ((Number)field.get((Object)typeface)).longValue();
            return l2;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)"TypefaceCompatBaseImpl", (String)"Could not retrieve font from family.", (Throwable)illegalAccessException);
            return 0L;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.e((String)"TypefaceCompatBaseImpl", (String)"Could not retrieve font from family.", (Throwable)noSuchFieldException);
            return 0L;
        }
    }

    public Typeface b(Context context, c.b b2, Resources resources, int n2) {
        c.c c2 = this.f(b2, n2);
        if (c2 == null) {
            return null;
        }
        Typeface typeface = d.d(context, resources, c2.b(), c2.a(), n2);
        this.a(typeface, b2);
        return typeface;
    }

    /*
     * Exception decompiling
     */
    public Typeface c(Context var1, CancellationSignal var2, f.b[] var3, int var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl44 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
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

    protected Typeface d(Context context, InputStream inputStream) {
        File file;
        block6 : {
            file = k.e(context);
            if (file == null) {
                return null;
            }
            boolean bl = k.d(file, inputStream);
            if (bl) break block6;
            file.delete();
            return null;
        }
        try {
            Typeface typeface = Typeface.createFromFile((String)file.getPath());
            return typeface;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            file.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int n2, String string, int n3) {
        File file;
        block6 : {
            file = k.e(context);
            if (file == null) {
                return null;
            }
            boolean bl = k.c(file, resources, n2);
            if (bl) break block6;
            file.delete();
            return null;
        }
        try {
            Typeface typeface = Typeface.createFromFile((String)file.getPath());
            return typeface;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            file.delete();
        }
    }

    protected f.b h(f.b[] arrb, int n2) {
        return j.g(arrb, n2, new a(this));
    }

    c.b i(Typeface typeface) {
        long l2 = j.j(typeface);
        if (l2 == 0L) {
            return null;
        }
        return this.a.get((Object)l2);
    }

    private static interface c<T> {
        public int a(T var1);

        public boolean b(T var1);
    }

}

