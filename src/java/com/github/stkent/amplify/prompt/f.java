/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.f
 *  com.github.stkent.amplify.prompt.f$a
 *  com.github.stkent.amplify.prompt.i.a$a
 *  com.github.stkent.amplify.prompt.i.a$b
 *  com.github.stkent.amplify.prompt.i.a$c
 *  com.github.stkent.amplify.prompt.i.b
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.github.stkent.amplify.prompt;

import android.os.Bundle;
import c.d.a.a.m.c;
import c.d.a.a.m.f.d;
import com.github.stkent.amplify.prompt.f;
import com.github.stkent.amplify.prompt.i.a;
import com.github.stkent.amplify.prompt.i.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
implements com.github.stkent.amplify.prompt.i.a {
    private static final a.a a = a.a.f;
    private final c.d.a.a.m.f.f b;
    private final b c;
    private a.a d = a;
    private final List<c.d.a.a.m.f.f> e = new ArrayList();

    public f(c.d.a.a.m.f.f f2, b b2) {
        this.b = f2;
        this.c = b2;
    }

    private void g() {
        this.a(c.l);
        a.a a2 = this.d;
        if (a2 == a.a.h) {
            this.a(c.h);
        } else if (a2 == a.a.i) {
            this.a(c.i);
        }
        if (this.c.b()) {
            this.i(a.a.j);
            return;
        }
        this.i(a.a.k);
    }

    private void h() {
        this.a(c.m);
        a.a a2 = this.d;
        if (a2 == a.a.h) {
            this.a(c.j);
        } else if (a2 == a.a.i) {
            this.a(c.k);
        }
        this.i(a.a.k);
    }

    private void i(a.a a2) {
        this.j(a2, false);
    }

    private void j(a.a a2, boolean bl) {
        this.d = a2;
        int n2 = a.a[a2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            return;
                        }
                        this.c.a(bl);
                        return;
                    }
                    this.c.f(bl);
                    return;
                }
                this.c.e();
                return;
            }
            this.c.c();
            return;
        }
        this.c.d(bl);
    }

    public void a(d d2) {
        this.b.a(d2);
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            ((c.d.a.a.m.f.f)iterator.next()).a(d2);
        }
    }

    @Override
    public void b(a.b b2) {
        a.a a2 = this.d;
        if (a2 != a.a.h && a2 != a.a.i) {
            throw new IllegalStateException("User opinion must be set before this method is called.");
        }
        if (b2 == a.b.f) {
            this.g();
            return;
        }
        if (b2 == a.b.g) {
            this.h();
        }
    }

    @Override
    public void c(a.c c2) {
        if (c2 == a.c.f) {
            this.a(c.f);
            this.i(a.a.h);
            return;
        }
        if (c2 == a.c.g) {
            this.a(c.g);
            this.i(a.a.i);
        }
    }

    @Override
    public Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("PromptFlowStateKey", this.d.ordinal());
        return bundle;
    }

    @Override
    public void e(Bundle bundle) {
        this.j(a.a.values()[bundle.getInt("PromptFlowStateKey", a.ordinal())], true);
    }

    @Override
    public void f(c.d.a.a.m.f.f f2) {
        this.e.add((Object)f2);
    }

    @Override
    public void start() {
        this.i(a.a.g);
    }
}

