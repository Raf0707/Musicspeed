/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  b.i.q.a0
 *  b.i.q.w
 */
package c.f.a.a.a.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.a0;
import b.i.q.w;
import c.f.a.a.a.a.e.e;
import c.f.a.a.a.a.e.f;
import c.f.a.a.a.a.e.g;
import c.f.a.a.a.a.e.h;
import c.f.a.a.a.a.e.i;
import c.f.a.a.a.a.e.j;

public class c
extends c.f.a.a.a.a.b {
    @Override
    protected void e0() {
        this.g0();
    }

    @Override
    protected void f0() {
        this.h0(new c.f.a.a.a.a.e.d(this){

            protected void C(c.f.a.a.a.a.e.a a2, RecyclerView.c0 c02) {
                w.u0((View)c02.itemView, (float)1.0f);
            }

            protected void D(c.f.a.a.a.a.e.a a2, RecyclerView.c0 c02) {
                w.u0((View)c02.itemView, (float)1.0f);
            }

            protected void E(c.f.a.a.a.a.e.a a2, RecyclerView.c0 c02) {
            }

            protected void F(c.f.a.a.a.a.e.a a2) {
                a0 a02 = w.d((View)a2.a.itemView);
                a02.a(1.0f);
                a02.d(this.B());
                this.w(a2, a2.a, a02);
            }

            @Override
            public boolean x(RecyclerView.c0 c02) {
                this.j(c02);
                w.u0((View)c02.itemView, (float)0.0f);
                this.n(new c.f.a.a.a.a.e.a(c02));
                return true;
            }
        });
        this.k0(new h(this){

            protected void C(j j2, RecyclerView.c0 c02) {
            }

            protected void D(j j2, RecyclerView.c0 c02) {
                w.u0((View)c02.itemView, (float)1.0f);
            }

            protected void E(j j2, RecyclerView.c0 c02) {
                w.u0((View)c02.itemView, (float)1.0f);
            }

            protected void F(j j2) {
                a0 a02 = w.d((View)j2.a.itemView);
                a02.d(this.B());
                a02.a(0.0f);
                this.w(j2, j2.a, a02);
            }

            @Override
            public boolean x(RecyclerView.c0 c02) {
                this.j(c02);
                this.n(new j(c02));
                return true;
            }
        });
        this.i0(new f(this){

            @Override
            protected void D(c.f.a.a.a.a.e.c c2) {
                a0 a02 = w.d((View)c2.a.itemView);
                a02.k(0.0f);
                a02.l(0.0f);
                a02.d(this.B());
                a02.a(1.0f);
                this.w(c2, c2.a, a02);
            }

            @Override
            protected void E(c.f.a.a.a.a.e.c c2) {
                a0 a02 = w.d((View)c2.b.itemView);
                a02.d(this.B());
                a02.k((float)(c2.e - c2.c));
                a02.l((float)(c2.f - c2.d));
                a02.a(0.0f);
                this.w(c2, c2.b, a02);
            }

            protected void F(c.f.a.a.a.a.e.c c2, RecyclerView.c0 c02) {
            }

            protected void G(c.f.a.a.a.a.e.c c2, RecyclerView.c0 c02) {
                View view = c02.itemView;
                w.u0((View)view, (float)1.0f);
                w.N0((View)view, (float)0.0f);
                w.O0((View)view, (float)0.0f);
            }

            protected void H(c.f.a.a.a.a.e.c c2, RecyclerView.c0 c02) {
                View view = c02.itemView;
                w.u0((View)view, (float)1.0f);
                w.N0((View)view, (float)0.0f);
                w.O0((View)view, (float)0.0f);
            }

            @Override
            public boolean x(RecyclerView.c0 c02, RecyclerView.c0 c03, int n2, int n3, int n4, int n5) {
                float f2 = w.N((View)c02.itemView);
                float f3 = w.O((View)c02.itemView);
                float f4 = w.r((View)c02.itemView);
                this.j(c02);
                int n6 = (int)((float)(n4 - n2) - f2);
                int n7 = (int)((float)(n5 - n3) - f3);
                w.N0((View)c02.itemView, (float)f2);
                w.O0((View)c02.itemView, (float)f3);
                w.u0((View)c02.itemView, (float)f4);
                if (c03 != null) {
                    this.j(c03);
                    w.N0((View)c03.itemView, (float)(-n6));
                    w.O0((View)c03.itemView, (float)(-n7));
                    w.u0((View)c03.itemView, (float)0.0f);
                }
                c.f.a.a.a.a.e.c c2 = new c.f.a.a.a.a.e.c(c02, c03, n2, n3, n4, n5);
                this.n(c2);
                return true;
            }
        });
        this.j0(new g(this){

            protected void C(i i2, RecyclerView.c0 c02) {
                View view = c02.itemView;
                int n2 = i2.d - i2.b;
                int n3 = i2.e - i2.c;
                if (n2 != 0) {
                    w.d((View)view).k(0.0f);
                }
                if (n3 != 0) {
                    w.d((View)view).l(0.0f);
                }
                if (n2 != 0) {
                    w.N0((View)view, (float)0.0f);
                }
                if (n3 != 0) {
                    w.O0((View)view, (float)0.0f);
                }
            }

            protected void D(i i2, RecyclerView.c0 c02) {
                View view = c02.itemView;
                w.O0((View)view, (float)0.0f);
                w.N0((View)view, (float)0.0f);
            }

            protected void E(i i2, RecyclerView.c0 c02) {
            }

            protected void F(i i2) {
                View view = i2.a.itemView;
                int n2 = i2.d - i2.b;
                int n3 = i2.e - i2.c;
                if (n2 != 0) {
                    w.d((View)view).k(0.0f);
                }
                if (n3 != 0) {
                    w.d((View)view).l(0.0f);
                }
                a0 a02 = w.d((View)view);
                a02.d(this.B());
                this.w(i2, i2.a, a02);
            }

            @Override
            public boolean x(RecyclerView.c0 c02, int n2, int n3, int n4, int n5) {
                View view = c02.itemView;
                int n6 = (int)((float)n2 + w.N((View)view));
                int n7 = (int)((float)n3 + w.O((View)c02.itemView));
                this.j(c02);
                int n8 = n4 - n6;
                int n9 = n5 - n7;
                i i2 = new i(c02, n6, n7, n4, n5);
                if (n8 == 0 && n9 == 0) {
                    this.y(i2, i2.a);
                    i2.a(i2.a);
                    return false;
                }
                if (n8 != 0) {
                    w.N0((View)view, (float)(-n8));
                }
                if (n9 != 0) {
                    w.O0((View)view, (float)(-n9));
                }
                this.n(i2);
                return true;
            }
        });
    }

}

