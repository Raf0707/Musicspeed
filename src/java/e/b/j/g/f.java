/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicLong
 */
package e.b.j.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class f
extends AtomicLong
implements ThreadFactory {
    final String f;
    final int g;
    final boolean h;

    public f(String string2) {
        this(string2, 5, false);
    }

    public f(String string2, int n2) {
        this(string2, n2, false);
    }

    public f(String string2, int n2, boolean bl) {
        this.f = string2;
        this.g = n2;
        this.h = bl;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder(this.f);
        stringBuilder.append('-');
        stringBuilder.append(this.incrementAndGet());
        String string2 = stringBuilder.toString();
        a a2 = this.h ? new a(runnable, string2) : new Thread(runnable, string2);
        a2.setPriority(this.g);
        a2.setDaemon(true);
        return a2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxThreadFactory[");
        stringBuilder.append(this.f);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static final class a
    extends Thread {
        a(Runnable runnable, String string2) {
            super(runnable, string2);
        }
    }

}

