/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.i.a.b
 *  c.i.a.l
 *  c.i.c.r.i.a
 *  java.lang.Object
 */
package c.i.c;

import c.i.a.l;
import c.i.c.a;
import c.i.c.b;

public class e {
    protected c.i.a.b<c.i.c.r.i.a> a;
    private b b;
    private c.i.c.q.a c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;

    public boolean a(c.i.c.r.i.a a2) {
        if (a2.a()) {
            c.i.c.q.a a3 = this.c;
            if (a3 != null && a3.a()) {
                this.c.b();
            }
            this.b(a2.h());
            return false;
        }
        return true;
    }

    public void b(long l2) {
        if (l2 == -1L) {
            this.a.w();
        }
        int n2 = this.a.getItemCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            c.i.c.r.i.a a2 = (c.i.c.r.i.a)this.a.G(i2);
            if (a2.h() != l2 || a2.b()) continue;
            this.a.w();
            this.a.b0(i2);
        }
    }

    public e c(a a2) {
        return this;
    }

    public e d(b b2) {
        this.b = b2;
        return this;
    }
}

