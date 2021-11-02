/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package e.b.j.g;

import e.b.g.b;
import e.b.k.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class h
extends AtomicReferenceArray<Object>
implements Runnable,
Callable<Object>,
b {
    static final Object f = new Object();
    static final Object g = new Object();
    static final Object h = new Object();
    static final Object i = new Object();
    final Runnable j;

    public h(Runnable runnable, e.b.j.a.a a2) {
        super(3);
        this.j = runnable;
        this.lazySet(0, (Object)a2);
    }

    @Override
    public void a() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        while ((object2 = this.get(1)) != i && object2 != (object4 = g) && object2 != (object = h)) {
            boolean bl = this.get(2) != Thread.currentThread();
            if (bl) {
                object4 = object;
            }
            if (!this.compareAndSet(1, object2, object4)) continue;
            if (object2 == null) break;
            ((Future)object2).cancel(bl);
            break;
        }
        while ((object5 = this.get(0)) != i && object5 != (object3 = f)) {
            if (object5 == null) {
                return;
            }
            if (!this.compareAndSet(0, object5, object3)) continue;
            ((e.b.j.a.a)object5).d(this);
            break;
        }
    }

    public void b(Future<?> future) {
        Object object;
        do {
            if ((object = this.get(1)) == i) {
                return;
            }
            if (object == g) {
                future.cancel(false);
                return;
            }
            if (object != h) continue;
            future.cancel(true);
            return;
        } while (!this.compareAndSet(1, object, future));
    }

    public Object call() {
        this.run();
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void run() {
        this.lazySet(2, (Object)Thread.currentThread());
        try {
            this.j.run();
            ** GOTO lbl8
        }
        catch (Throwable throwable) {
            try {
                a.k(throwable);
            }
            catch (Throwable throwable) {
                this.lazySet(2, null);
                object4 = this.get(0);
                if (object4 != h.f && this.compareAndSet(0, object4, h.i) && object4 != null) {
                    ((e.b.j.a.a)object4).d(this);
                }
                while ((object3 = this.get(1)) != h.g) {
                    if (object3 == h.h) throw throwable;
                    if (this.compareAndSet(1, object3, h.i) != false) throw throwable;
                }
                throw throwable;
            }
lbl8: // 2 sources:
            this.lazySet(2, null);
            object2 = this.get(0);
            if (object2 != h.f && this.compareAndSet(0, object2, h.i) && object2 != null) {
                ((e.b.j.a.a)object2).d(this);
            }
            do {
                if ((object = this.get(1)) == h.g) return;
                if (object == h.h) return;
            } while (!this.compareAndSet(1, object, h.i));
            return;
        }
    }
}

