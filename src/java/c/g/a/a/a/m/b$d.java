/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayDeque
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package c.g.a.a.a.m;

import c.g.a.a.a.m.b$c;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b$d
implements b$c.a {
    private final BlockingQueue<Runnable> a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque<b$c> c = new ArrayDeque();
    private b$c d = null;

    public b$d() {
        ThreadPoolExecutor threadPoolExecutor;
        LinkedBlockingQueue linkedBlockingQueue;
        this.a = linkedBlockingQueue = new LinkedBlockingQueue();
        this.b = threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, (BlockingQueue)linkedBlockingQueue);
    }

    private void b() {
        b$c b$c;
        this.d = b$c = (b$c)((Object)this.c.poll());
        if (b$c != null) {
            b$c.c(this.b);
        }
    }

    @Override
    public void a(b$c b$c) {
        this.d = null;
        this.b();
    }

    public void c(b$c b$c) {
        b$c.a(this);
        this.c.add((Object)b$c);
        if (this.d == null) {
            this.b();
        }
    }
}

