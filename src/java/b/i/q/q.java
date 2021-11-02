/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 */
package b.i.q;

import android.view.View;
import android.view.ViewGroup;

public class q {
    private int a;
    private int b;

    public q(ViewGroup viewGroup) {
    }

    public int a() {
        return this.a | this.b;
    }

    public void b(View view, View view2, int n2) {
        this.c(view, view2, n2, 0);
    }

    public void c(View view, View view2, int n2, int n3) {
        if (n3 == 1) {
            this.b = n2;
            return;
        }
        this.a = n2;
    }

    public void d(View view, int n2) {
        if (n2 == 1) {
            this.b = 0;
            return;
        }
        this.a = 0;
    }
}

