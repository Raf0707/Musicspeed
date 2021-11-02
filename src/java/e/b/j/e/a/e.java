/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package e.b.j.e.a;

import e.b.c;
import e.b.d;
import e.b.e;
import e.b.g.b;
import e.b.j.g.k;

public final class e<T>
extends e.b.j.e.a.a<T, T> {
    final e.b.e g;
    final boolean h;
    final int i;

    public e(c<T> c2, e.b.e e2, boolean bl, int n2) {
        super(c2);
        this.g = e2;
        this.h = bl;
        this.i = n2;
    }

    @Override
    protected void m(d<? super T> d2) {
        e.b.e e2 = this.g;
        if (e2 instanceof k) {
            this.f.a(d2);
            return;
        }
        e.b b2 = e2.a();
        this.f.a(new a<T>(d2, b2, this.h, this.i));
    }

    static final class a<T>
    extends e.b.j.d.b<T>
    implements d<T>,
    Runnable {
        final d<? super T> f;
        final e.b g;
        final boolean h;
        final int i;
        e.b.j.c.c<T> j;
        b k;
        Throwable l;
        volatile boolean m;
        volatile boolean n;
        int o;
        boolean p;

        a(d<? super T> d2, e.b b2, boolean bl, int n2) {
            this.f = d2;
            this.g = b2;
            this.h = bl;
            this.i = n2;
        }

        @Override
        public void a() {
            if (!this.n) {
                this.n = true;
                this.k.a();
                this.g.a();
                if (!this.p && this.getAndIncrement() == 0) {
                    this.j.clear();
                }
            }
        }

        @Override
        public void b() {
            if (this.m) {
                return;
            }
            this.m = true;
            this.j();
        }

        @Override
        public void c(b b2) {
            if (e.b.j.a.b.e(this.k, b2)) {
                this.k = b2;
                if (b2 instanceof e.b.j.c.a) {
                    e.b.j.c.a a2 = (e.b.j.c.a)b2;
                    int n2 = a2.f(7);
                    if (n2 == 1) {
                        this.o = n2;
                        this.j = a2;
                        this.m = true;
                        this.f.c(this);
                        this.j();
                        return;
                    }
                    if (n2 == 2) {
                        this.o = n2;
                        this.j = a2;
                        this.f.c(this);
                        return;
                    }
                }
                this.j = new e.b.j.f.a(this.i);
                this.f.c(this);
            }
        }

        @Override
        public void clear() {
            this.j.clear();
        }

        @Override
        public void d(Throwable throwable) {
            if (this.m) {
                e.b.k.a.k(throwable);
                return;
            }
            this.l = throwable;
            this.m = true;
            this.j();
        }

        @Override
        public void e(T t2) {
            if (this.m) {
                return;
            }
            if (this.o != 2) {
                this.j.offer(t2);
            }
            this.j();
        }

        @Override
        public int f(int n2) {
            if ((n2 & 2) != 0) {
                this.p = true;
                return 2;
            }
            return 0;
        }

        boolean g(boolean bl, boolean bl2, d<? super T> d2) {
            if (this.n) {
                this.j.clear();
                return true;
            }
            if (bl) {
                Throwable throwable = this.l;
                if (this.h) {
                    if (bl2) {
                        this.n = true;
                        if (throwable != null) {
                            d2.d(throwable);
                        } else {
                            d2.b();
                        }
                        this.g.a();
                        return true;
                    }
                } else {
                    if (throwable != null) {
                        this.n = true;
                        this.j.clear();
                        d2.d(throwable);
                        this.g.a();
                        return true;
                    }
                    if (bl2) {
                        this.n = true;
                        d2.b();
                        this.g.a();
                        return true;
                    }
                }
            }
            return false;
        }

        void h() {
            int n2 = 1;
            do {
                if (this.n) {
                    return;
                }
                boolean bl = this.m;
                Throwable throwable = this.l;
                if (!this.h && bl && throwable != null) {
                    this.n = true;
                    this.f.d(this.l);
                    this.g.a();
                    return;
                }
                this.f.e(null);
                if (!bl) continue;
                this.n = true;
                Throwable throwable2 = this.l;
                if (throwable2 != null) {
                    this.f.d(throwable2);
                } else {
                    this.f.b();
                }
                this.g.a();
                return;
            } while ((n2 = this.addAndGet(-n2)) != 0);
        }

        /*
         * Exception decompiling
         */
        void i() {
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
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
        public boolean isEmpty() {
            return this.j.isEmpty();
        }

        void j() {
            if (this.getAndIncrement() == 0) {
                this.g.c(this);
            }
        }

        @Override
        public T poll() throws Exception {
            return this.j.poll();
        }

        public void run() {
            if (this.p) {
                this.h();
                return;
            }
            this.i();
        }
    }

}

