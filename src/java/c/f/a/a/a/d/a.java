/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.ViewConfiguration
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  androidx.recyclerview.widget.RecyclerView$s
 *  b.i.q.k
 *  c.f.a.a.a.d.a$a
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package c.f.a.a.a.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.k;
import c.f.a.a.a.d.a;

public class a {
    private RecyclerView.s a = new a(this);
    private RecyclerView b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    private void b(MotionEvent motionEvent) {
        int n2;
        this.e = n2 = (int)(0.5f + motionEvent.getY());
        this.d = n2;
        this.c = false;
    }

    private boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.c) {
            int n2;
            this.e = n2 = (int)(0.5f + motionEvent.getY());
            int n3 = n2 - this.d;
            if (this.h && Math.abs((int)n3) > this.f && a.e(recyclerView)) {
                this.c = true;
            }
        }
        return this.c;
    }

    private void d() {
        this.c = false;
        this.d = 0;
        this.e = 0;
    }

    private static boolean e(RecyclerView recyclerView) {
        RecyclerView.l l2 = recyclerView.getItemAnimator();
        return l2 != null && l2.p();
    }

    public void a(RecyclerView recyclerView) {
        if (!this.f()) {
            if (this.b == null) {
                this.b = recyclerView;
                recyclerView.n(this.a);
                this.f = ViewConfiguration.get((Context)recyclerView.getContext()).getScaledTouchSlop();
                return;
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    public boolean f() {
        return this.a == null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean g(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.g) {
            return false;
        }
        int n2 = k.a((MotionEvent)motionEvent);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return false;
                    }
                } else {
                    if (!this.c(recyclerView, motionEvent)) return false;
                    return true;
                }
            }
            this.d();
            return false;
        }
        this.b(motionEvent);
        return false;
    }

    void h(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.g) {
            return;
        }
        int n2 = k.a((MotionEvent)motionEvent);
        if (n2 != 1 && n2 != 3) {
            return;
        }
        this.d();
    }

    public void i() {
        RecyclerView.s s2;
        RecyclerView recyclerView = this.b;
        if (recyclerView != null && (s2 = this.a) != null) {
            recyclerView.g1(s2);
        }
        this.a = null;
        this.b = null;
    }

    public void j(boolean bl) {
        if (this.g == bl) {
            return;
        }
        this.g = bl;
        if (!bl) {
            this.d();
        }
    }

    public void k(boolean bl) {
        this.h = bl;
    }
}

