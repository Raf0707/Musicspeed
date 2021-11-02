/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.SystemClock
 *  b.o.b.b
 *  b.o.b.c
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Void
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.Executor
 */
package b.o.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import b.i.p.i;
import b.o.b.b;
import b.o.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D>
extends b<D> {
    private final Executor j;
    volatile a<D> k;
    volatile a<D> l;
    long m;
    long n = -10000L;
    Handler o;

    public a(Context context) {
        this(context, c.h);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.j = executor;
    }

    public void A() {
    }

    void B(a<D> a2, D d2) {
        this.F(d2);
        if (this.l == a2) {
            this.v();
            this.n = SystemClock.uptimeMillis();
            this.l = null;
            this.e();
            this.D();
        }
    }

    void C(a<D> a2, D d2) {
        if (this.k != a2) {
            this.B(a2, d2);
            return;
        }
        if (this.j()) {
            this.F(d2);
            return;
        }
        this.c();
        this.n = SystemClock.uptimeMillis();
        this.k = null;
        this.f(d2);
    }

    void D() {
        if (this.l == null && this.k != null) {
            if (((a)this.k).q) {
                ((a)this.k).q = false;
                this.o.removeCallbacks(this.k);
            }
            if (this.m > 0L && SystemClock.uptimeMillis() < this.n + this.m) {
                ((a)this.k).q = true;
                this.o.postAtTime(this.k, this.n + this.m);
                return;
            }
            this.k.c(this.j, null);
        }
    }

    public abstract D E();

    public void F(D d2) {
    }

    protected D G() {
        return this.E();
    }

    @Deprecated
    public void g(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        super.g(string, fileDescriptor, printWriter, arrstring);
        if (this.k != null) {
            printWriter.print(string);
            printWriter.print("mTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(((a)this.k).q);
        }
        if (this.l != null) {
            printWriter.print(string);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.l);
            printWriter.print(" waiting=");
            printWriter.println(((a)this.l).q);
        }
        if (this.m != 0L) {
            printWriter.print(string);
            printWriter.print("mUpdateThrottle=");
            i.c(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    protected boolean n() {
        if (this.k != null) {
            if (!this.e) {
                this.h = true;
            }
            if (this.l != null) {
                if (((a)this.k).q) {
                    ((a)this.k).q = false;
                    this.o.removeCallbacks(this.k);
                }
                this.k = null;
                return false;
            }
            if (((a)this.k).q) {
                ((a)this.k).q = false;
                this.o.removeCallbacks(this.k);
                this.k = null;
                return false;
            }
            boolean bl = this.k.a(false);
            if (bl) {
                this.l = this.k;
                this.A();
            }
            this.k = null;
            return bl;
        }
        return false;
    }

    protected void p() {
        super.p();
        this.b();
        this.k = new a();
        this.D();
    }

    final class a
    extends c<Void, Void, D>
    implements Runnable {
        private final CountDownLatch p = new CountDownLatch(1);
        boolean q;

        a() {
        }

        protected void h(D d2) {
            try {
                a.this.B(this, d2);
                return;
            }
            finally {
                this.p.countDown();
            }
        }

        protected void i(D d2) {
            try {
                a.this.C(this, d2);
                return;
            }
            finally {
                this.p.countDown();
            }
        }

        protected /* varargs */ D n(Void ... arrvoid) {
            Object d2;
            try {
                d2 = a.this.G();
            }
            catch (b.i.m.c c2) {
                if (this.f()) {
                    return null;
                }
                throw c2;
            }
            return d2;
        }

        public void run() {
            this.q = false;
            a.this.D();
        }
    }

}

