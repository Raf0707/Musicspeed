/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.d0.f
 *  f.d0.g
 *  f.g0.u
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  java.util.Objects
 */
package f.g0;

import f.d0.f;
import f.d0.g;
import f.f0.b;
import f.g0.u;
import f.l;
import f.z.c.p;
import f.z.d.k;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class d
implements b<f> {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final p<CharSequence, Integer, l<Integer, Integer>> d;

    public d(CharSequence charSequence, int n2, int n3, p<? super CharSequence, ? super Integer, l<Integer, Integer>> p2) {
        k.g((Object)charSequence, "input");
        k.g(p2, "getNextMatch");
        this.a = charSequence;
        this.b = n2;
        this.c = n3;
        this.d = p2;
    }

    public static final /* synthetic */ p a(d d2) {
        return d2.d;
    }

    public static final /* synthetic */ int c(d d2) {
        return d2.c;
    }

    @Override
    public Iterator<f> iterator() {
        return new Iterator<f>(){
            private int f = -1;
            private int g;
            private int h;
            private f i;
            private int j;
            {
                int n2;
                this.g = n2 = g.f((int)d2.b, (int)0, (int)d2.a.length());
                this.h = n2;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            private final void b() {
                block6 : {
                    if (this.h < 0) {
                        this.f = 0;
                        this.i = null;
                        return;
                    }
                    if (d.c(this) <= 0) break block6;
                    this.j = var6_1 = 1 + this.j;
                    if (var6_1 >= d.c(this)) ** GOTO lbl-1000
                }
                if (this.h > d.b(this).length()) lbl-1000: // 2 sources:
                {
                    this.i = new f(this.g, u.u((CharSequence)d.b(this)));
                    this.h = -1;
                } else {
                    var1_2 = (l)d.a(this).i(d.b(this), (int)this.h);
                    if (var1_2 == null) {
                        this.i = new f(this.g, u.u((CharSequence)d.b(this)));
                        this.h = -1;
                    } else {
                        var2_3 = ((Number)var1_2.a()).intValue();
                        var3_4 = ((Number)var1_2.b()).intValue();
                        this.i = g.i((int)this.g, (int)var2_3);
                        this.g = var4_5 = var2_3 + var3_4;
                        var5_6 = 0;
                        if (var3_4 == 0) {
                            var5_6 = 1;
                        }
                        this.h = var4_5 + var5_6;
                    }
                }
                this.f = 1;
            }

            public f c() {
                if (this.f == -1) {
                    this.b();
                }
                if (this.f != 0) {
                    f f3 = this.i;
                    Objects.requireNonNull((Object)f3, (String)"null cannot be cast to non-null type kotlin.ranges.IntRange");
                    this.i = null;
                    this.f = -1;
                    return f3;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.f == -1) {
                    this.b();
                }
                return this.f == 1;
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

}

