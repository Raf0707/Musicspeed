/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package com.smp.musicspeed.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class e<T> {
    private final ScheduledExecutorService a = Executors.newScheduledThreadPool((int)1);
    private final ConcurrentHashMap<T, e<T>> b = new ConcurrentHashMap();
    private final a<T> c;
    private final int d;

    public e(a<T> a2, int n2) {
        this.c = a2;
        this.d = n2;
    }

    public void e(T t2) {
        b b2;
        b b3 = new b(t2);
        do {
            if ((b2 = (b)this.b.putIfAbsent(t2, (Object)b3)) != null) continue;
            this.a.schedule((Runnable)b3, (long)this.d, TimeUnit.MILLISECONDS);
        } while (b2 != null && !b2.a());
    }

    public static interface a<T> {
        public void a(T var1);
    }

    private class b
    implements Runnable {
        private final T f;
        private long g;
        private final Object h = new Object();

        b(T t2) {
            this.f = t2;
            this.a();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public boolean a() {
            Object object;
            Object object2 = object = this.h;
            synchronized (object2) {
                if (this.g < 0L) {
                    return false;
                }
                this.g = System.currentTimeMillis() + (long)e.this.d;
                return true;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            Object object;
            Object object2 = object = this.h;
            synchronized (object2) {
                long l2 = this.g - System.currentTimeMillis();
                if (l2 > 0L) {
                    e.this.a.schedule((Runnable)this, l2, TimeUnit.MILLISECONDS);
                } else {
                    this.g = -1L;
                    e.this.c.a(this.f);
                }
                return;
                finally {
                    e.this.b.remove(this.f);
                }
            }
        }
    }

}

