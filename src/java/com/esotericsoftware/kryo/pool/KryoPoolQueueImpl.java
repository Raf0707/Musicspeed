/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.pool.KryoCallback
 *  com.esotericsoftware.kryo.pool.KryoFactory
 *  com.esotericsoftware.kryo.pool.KryoPool
 *  java.lang.Object
 *  java.util.Queue
 */
package com.esotericsoftware.kryo.pool;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.pool.KryoCallback;
import com.esotericsoftware.kryo.pool.KryoFactory;
import com.esotericsoftware.kryo.pool.KryoPool;
import java.util.Queue;

class KryoPoolQueueImpl
implements KryoPool {
    private final KryoFactory factory;
    private final Queue<Kryo> queue;

    KryoPoolQueueImpl(KryoFactory kryoFactory, Queue<Kryo> queue) {
        this.factory = kryoFactory;
        this.queue = queue;
    }

    public Kryo borrow() {
        Kryo kryo = (Kryo)this.queue.poll();
        if (kryo != null) {
            return kryo;
        }
        return this.factory.create();
    }

    public void clear() {
        this.queue.clear();
    }

    public void release(Kryo kryo) {
        this.queue.offer((Object)kryo);
    }

    public <T> T run(KryoCallback<T> kryoCallback) {
        Kryo kryo = this.borrow();
        try {
            Object object = kryoCallback.execute(kryo);
            return (T)object;
        }
        finally {
            this.release(kryo);
        }
    }

    public int size() {
        return this.queue.size();
    }
}

