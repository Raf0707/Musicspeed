/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  e.b.j.g.e
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.String
 *  java.util.concurrent.ThreadFactory
 */
package e.b.j.g;

import e.b.e;
import e.b.j.g.e;
import e.b.j.g.f;
import java.util.concurrent.ThreadFactory;

public final class d
extends e.b.e {
    private static final f b = new f("RxNewThreadScheduler", Math.max((int)1, (int)Math.min((int)10, (int)Integer.getInteger((String)"rx2.newthread-priority", (int)5))));
    final ThreadFactory c;

    public d() {
        this(b);
    }

    public d(ThreadFactory threadFactory) {
        this.c = threadFactory;
    }

    @Override
    public e.b a() {
        return new e(this.c);
    }
}

