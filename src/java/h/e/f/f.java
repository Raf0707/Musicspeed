/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Queue
 *  java.util.concurrent.LinkedBlockingQueue
 */
package h.e.f;

import h.e.a;
import h.e.b;
import h.e.e.d;
import h.e.f.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class f
implements a {
    boolean a = false;
    final Map<String, e> b = new HashMap();
    final LinkedBlockingQueue<d> c = new LinkedBlockingQueue();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public b a(String string) {
        f f2 = this;
        synchronized (f2) {
            e e2 = (e)this.b.get((Object)string);
            if (e2 == null) {
                e2 = new e(string, (Queue<d>)this.c, this.a);
                this.b.put((Object)string, (Object)e2);
            }
            return e2;
        }
    }

    public void b() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue<d> c() {
        return this.c;
    }

    public List<e> d() {
        return new ArrayList(this.b.values());
    }

    public void e() {
        this.a = true;
    }
}

