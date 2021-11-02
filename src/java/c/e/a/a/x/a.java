/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  c.e.a.a.x.a$a
 *  c.e.a.a.x.f
 */
package c.e.a.a.x;

import android.graphics.Typeface;
import c.e.a.a.x.a;
import c.e.a.a.x.f;

public final class a
extends f {
    private final Typeface a;
    private final a b;
    private boolean c;

    public a(a a2, Typeface typeface) {
        this.a = typeface;
        this.b = a2;
    }

    private void d(Typeface typeface) {
        if (!this.c) {
            this.b.a(typeface);
        }
    }

    public void a(int n2) {
        this.d(this.a);
    }

    public void b(Typeface typeface, boolean bl) {
        this.d(typeface);
    }

    public void c() {
        this.c = true;
    }
}

