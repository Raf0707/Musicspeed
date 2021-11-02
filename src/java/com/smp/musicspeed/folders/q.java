/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  b.o.b.a
 *  b.o.b.b
 *  java.lang.Object
 */
package com.smp.musicspeed.folders;

import android.content.Context;
import b.o.b.a;
import b.o.b.b;

public abstract class q<D>
extends a<D> {
    private D p;

    public q(Context context) {
        super(context);
    }

    public void f(D d2) {
        if (!this.k()) {
            this.p = d2;
            b.super.f(d2);
        }
    }

    protected void q() {
        b.super.q();
        this.s();
        this.p = null;
    }

    protected void r() {
        b.super.r();
        D d2 = this.p;
        if (d2 != null) {
            this.f(d2);
            return;
        }
        if (this.y() || this.p == null) {
            this.h();
        }
    }

    protected void s() {
        b.super.s();
        this.b();
    }
}

