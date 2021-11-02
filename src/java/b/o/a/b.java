/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 *  androidx.lifecycle.e0
 *  androidx.lifecycle.h0
 *  androidx.lifecycle.h0$b
 *  androidx.lifecycle.i0
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  b.o.a.a
 *  b.o.a.a$a
 *  b.o.a.b$a
 *  b.o.b.b
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Modifier
 */
package b.o.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.e0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import b.e.h;
import b.o.a.a;
import b.o.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/*
 * Exception performing whole class analysis.
 */
class b
extends b.o.a.a {
    static boolean a;
    private final p b;
    private final c c;

    b(p p2, i0 i02) {
        this.b = p2;
        this.c = c.h(i02);
    }

    private <D> b.o.b.b<D> h(int n2, Bundle bundle, a.a<D> a2, b.o.b.b<D> b2) {
        try {
            this.c.n();
            b.o.b.b b3 = a2.s(n2, bundle);
            if (b3 != null) {
                if (b3.getClass().isMemberClass() && !Modifier.isStatic((int)b3.getClass().getModifiers())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                    stringBuilder.append((Object)b3);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                a a3 = new /* Unavailable Anonymous Inner Class!! */;
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Created new loader ");
                    stringBuilder.append((Object)a3);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                this.c.l(n2, a3);
                return a3.u(this.b, a2);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        }
        finally {
            this.c.g();
        }
    }

    public void a(int n2) {
        if (!this.c.j()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                a a2;
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("destroyLoader in ");
                    stringBuilder.append((Object)this);
                    stringBuilder.append(" of ");
                    stringBuilder.append(n2);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                if ((a2 = this.c.i(n2)) != null) {
                    a2.q(true);
                    this.c.m(n2);
                }
                return;
            }
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Deprecated
    public void b(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        this.c.f(string, fileDescriptor, printWriter, arrstring);
    }

    public <D> b.o.b.b<D> d(int n2) {
        if (!this.c.j()) {
            a a2 = this.c.i(n2);
            if (a2 != null) {
                return a2.s();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public <D> b.o.b.b<D> e(int n2, Bundle bundle, a.a<D> a2) {
        if (!this.c.j()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                a a3 = this.c.i(n2);
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("initLoader in ");
                    stringBuilder.append((Object)this);
                    stringBuilder.append(": args=");
                    stringBuilder.append((Object)bundle);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                if (a3 == null) {
                    return this.h(n2, bundle, a2, null);
                }
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Re-using existing loader ");
                    stringBuilder.append(a3);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                return a3.u(this.b, a2);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public void f() {
        this.c.k();
    }

    public <D> b.o.b.b<D> g(int n2, Bundle bundle, a.a<D> a2) {
        if (!this.c.j()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("restartLoader in ");
                    stringBuilder.append((Object)this);
                    stringBuilder.append(": args=");
                    stringBuilder.append((Object)bundle);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                a a3 = this.c.i(n2);
                b.o.b.b b2 = null;
                if (a3 != null) {
                    b2 = a3.q(false);
                }
                return this.h(n2, bundle, a2, b2);
            }
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)((Object)this))));
        stringBuilder.append(" in ");
        b.i.p.b.a((Object)this.b, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    static class b<D>
    implements x<D> {
        private final b.o.b.b<D> a;
        private final a.a<D> b;
        private boolean c = false;

        b(b.o.b.b<D> b2, a.a<D> a2) {
            this.a = b2;
            this.b = a2;
        }

        public void a(D d2) {
            if (b.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  onLoadFinished in ");
                stringBuilder.append(this.a);
                stringBuilder.append(": ");
                stringBuilder.append(this.a.d(d2));
                Log.v((String)"LoaderManager", (String)stringBuilder.toString());
            }
            this.b.p(this.a, d2);
            this.c = true;
        }

        public void b(String string, PrintWriter printWriter) {
            printWriter.print(string);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean c() {
            return this.c;
        }

        void d() {
            if (this.c) {
                if (b.a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Resetting: ");
                    stringBuilder.append(this.a);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                this.b.I(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    static class c
    extends e0 {
        private static final h0.b c = new h0.b(){

            public <T extends e0> T a(Class<T> class_) {
                return (T)((Object)new c());
            }
        };
        private h<b.o.a.b$a> d = new h();
        private boolean e = false;

        c() {
        }

        static c h(i0 i02) {
            return (c)new h0(i02, c).a(c.class);
        }

        protected void d() {
            super.d();
            int n2 = this.d.k();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.d.l(i2).q(true);
            }
            this.d.b();
        }

        public void f(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
            if (this.d.k() > 0) {
                printWriter.print(string);
                printWriter.println("Loaders:");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("    ");
                String string2 = stringBuilder.toString();
                for (int i2 = 0; i2 < this.d.k(); ++i2) {
                    b.o.a.b$a a2 = this.d.l(i2);
                    printWriter.print(string);
                    printWriter.print("  #");
                    printWriter.print(this.d.h(i2));
                    printWriter.print(": ");
                    printWriter.println(a2.toString());
                    a2.r(string2, fileDescriptor, printWriter, arrstring);
                }
            }
        }

        void g() {
            this.e = false;
        }

        <D> b.o.a.b$a<D> i(int n2) {
            return this.d.e(n2);
        }

        boolean j() {
            return this.e;
        }

        void k() {
            int n2 = this.d.k();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.d.l(i2).t();
            }
        }

        void l(int n2, b.o.a.b$a a2) {
            this.d.i(n2, a2);
        }

        void m(int n2) {
            this.d.j(n2);
        }

        void n() {
            this.e = true;
        }

    }

}

