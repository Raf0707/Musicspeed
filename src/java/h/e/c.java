/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  h.e.e.d
 *  h.e.f.c
 *  h.e.f.e
 *  h.e.f.f
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.URL
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Enumeration
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.LinkedBlockingQueue
 *  org.slf4j.impl.StaticLoggerBinder
 */
package h.e;

import h.e.a;
import h.e.b;
import h.e.e.d;
import h.e.f.e;
import h.e.f.f;
import h.e.f.g;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.impl.StaticLoggerBinder;

public final class c {
    static volatile int a;
    static final f b;
    static final h.e.f.c c;
    static boolean d;
    private static final String[] e;
    private static String f;

    static {
        b = new f();
        c = new h.e.f.c();
        d = g.f("slf4j.detectLoggerNameMismatch");
        e = new String[]{"1.6", "1.7"};
        f = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    private c() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void a() {
        try {
            boolean bl = c.l();
            Set<URL> set = null;
            if (!bl) {
                set = c.f();
                c.s(set);
            }
            StaticLoggerBinder.getSingleton();
            a = 3;
            c.r(set);
            c.g();
            c.p();
            b.b();
            return;
        }
        catch (Exception exception) {
            c.e(exception);
            throw new IllegalStateException("Unexpected initialization failure", (Throwable)exception);
        }
        catch (NoSuchMethodError noSuchMethodError) {
            String string2 = noSuchMethodError.getMessage();
            if (string2 != null && string2.contains((CharSequence)"org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                a = 2;
                g.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                g.c("Your binding is version 1.5.5 or earlier.");
                g.c("Upgrade your binding to version 1.6.x.");
            }
            throw noSuchMethodError;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            if (c.m(noClassDefFoundError.getMessage())) {
                a = 4;
                g.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                g.c("Defaulting to no-operation (NOP) logger implementation");
                g.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            c.e(noClassDefFoundError);
            throw noClassDefFoundError;
        }
    }

    private static void b(d d2, int n2) {
        if (d2.a().k()) {
            c.c(n2);
            return;
        }
        if (d2.a().l()) {
            return;
        }
        c.d();
    }

    private static void c(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("A number (");
        stringBuilder.append(n2);
        stringBuilder.append(") of logging calls during the initialization phase have been intercepted and are");
        g.c(stringBuilder.toString());
        g.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        g.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        g.c("The following set of substitute loggers may have been accessed");
        g.c("during the initialization phase. Logging calls during this");
        g.c("phase were not honored. However, subsequent logging calls to these");
        g.c("loggers will work as normally expected.");
        g.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable throwable) {
        a = 2;
        g.d("Failed to instantiate SLF4J LoggerFactory", throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            Enumeration enumeration = classLoader == null ? ClassLoader.getSystemResources((String)f) : classLoader.getResources(f);
            while (enumeration.hasMoreElements()) {
                linkedHashSet.add((Object)((URL)enumeration.nextElement()));
            }
            return linkedHashSet;
        }
        catch (IOException iOException) {
            g.d("Error getting resources from path", iOException);
        }
        return linkedHashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void g() {
        f f2;
        f f3 = f2 = b;
        synchronized (f3) {
            f2.e();
            Iterator iterator = f2.d().iterator();
            while (iterator.hasNext()) {
                e e2 = (e)iterator.next();
                e2.o(c.j(e2.getName()));
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static a h() {
        int n2;
        if (a == 0) {
            Class<c> class_ = c.class;
            // MONITORENTER : h.e.c.class
            if (a == 0) {
                a = 1;
                c.o();
            }
            // MONITOREXIT : class_
        }
        if ((n2 = a) == 1) return b;
        if (n2 == 2) throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        if (n2 == 3) return StaticLoggerBinder.getSingleton().getLoggerFactory();
        if (n2 != 4) throw new IllegalStateException("Unreachable code");
        return c;
    }

    public static b i(Class<?> class_) {
        Class<?> class_2;
        b b2 = c.j(class_.getName());
        if (d && (class_2 = g.a()) != null && c.n(class_, class_2)) {
            Object[] arrobject = new Object[]{b2.getName(), class_2.getName()};
            g.c(String.format((String)"Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", (Object[])arrobject));
            g.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return b2;
    }

    public static b j(String string2) {
        return c.h().a(string2);
    }

    private static boolean k(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean l() {
        String string2 = g.g("java.vendor.url");
        if (string2 == null) {
            return false;
        }
        return string2.toLowerCase().contains((CharSequence)"android");
    }

    private static boolean m(String string2) {
        if (string2 == null) {
            return false;
        }
        if (string2.contains((CharSequence)"org/slf4j/impl/StaticLoggerBinder")) {
            return true;
        }
        return string2.contains((CharSequence)"org.slf4j.impl.StaticLoggerBinder");
    }

    private static boolean n(Class<?> class_, Class<?> class_2) {
        return true ^ class_2.isAssignableFrom(class_);
    }

    private static final void o() {
        c.a();
        if (a == 3) {
            c.t();
        }
    }

    private static void p() {
        LinkedBlockingQueue linkedBlockingQueue = b.c();
        int n2 = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(128);
        int n3 = 0;
        while (linkedBlockingQueue.drainTo((Collection)arrayList, 128) != 0) {
            for (d d2 : arrayList) {
                c.q(d2);
                int n4 = n3 + 1;
                if (n3 == 0) {
                    c.b(d2, n2);
                }
                n3 = n4;
            }
            arrayList.clear();
        }
        return;
    }

    private static void q(d d2) {
        if (d2 == null) {
            return;
        }
        e e2 = d2.a();
        String string2 = e2.getName();
        if (!e2.m()) {
            if (e2.l()) {
                return;
            }
            if (e2.k()) {
                e2.n((h.e.e.c)d2);
                return;
            }
            g.c(string2);
            return;
        }
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    private static void r(Set<URL> set) {
        if (set != null && c.k(set)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Actual binding is of type [");
            stringBuilder.append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
            stringBuilder.append("]");
            g.c(stringBuilder.toString());
        }
    }

    private static void s(Set<URL> set) {
        if (c.k(set)) {
            g.c("Class path contains multiple SLF4J bindings.");
            for (URL uRL : set) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found binding in [");
                stringBuilder.append((Object)uRL);
                stringBuilder.append("]");
                g.c(stringBuilder.toString());
            }
            g.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /*
     * Exception decompiling
     */
    private static final void t() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
}

