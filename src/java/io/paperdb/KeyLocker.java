/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.Semaphore
 */
package io.paperdb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;

class KeyLocker {
    private ConcurrentMap<String, Semaphore> semaphoreMap = new ConcurrentHashMap();

    KeyLocker() {
    }

    void acquire(String string2) {
        if (string2 != null) {
            if (!this.semaphoreMap.containsKey((Object)string2)) {
                this.semaphoreMap.put((Object)string2, (Object)new Semaphore(1, true));
            }
            ((Semaphore)this.semaphoreMap.get((Object)string2)).acquireUninterruptibly();
            return;
        }
        throw new IllegalArgumentException("Key couldn't be null");
    }

    void release(String string2) {
        if (string2 != null) {
            Semaphore semaphore = (Semaphore)this.semaphoreMap.get((Object)string2);
            if (semaphore != null) {
                semaphore.release();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't release semaphore. The acquire() with the same key '");
            stringBuilder.append(string2);
            stringBuilder.append("' has to be called prior to calling release()");
            throw new IllegalStateException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("Key couldn't be null");
    }
}

