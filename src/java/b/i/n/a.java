/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 */
package b.i.n;

import android.graphics.Typeface;
import android.os.Handler;
import b.i.n.e;
import b.i.n.f;

class a {
    private final f.c a;
    private final Handler b;

    a(f.c c2, Handler handler) {
        this.a = c2;
        this.b = handler;
    }

    private void a(final int n2) {
        final f.c c2 = this.a;
        this.b.post(new Runnable(){

            public void run() {
                c2.a(n2);
            }
        });
    }

    private void c(final Typeface typeface) {
        final f.c c2 = this.a;
        this.b.post(new Runnable(){

            public void run() {
                c2.b(typeface);
            }
        });
    }

    void b(e.e e2) {
        if (e2.a()) {
            this.c(e2.a);
            return;
        }
        this.a(e2.b);
    }

}

