/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Future
 */
package c.e.b.a.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public interface a<V>
extends Future<V> {
    public void a(Runnable var1, Executor var2);
}

