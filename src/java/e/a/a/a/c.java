/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.Set
 *  java.util.UUID
 */
package e.a.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import e.a.a.a.a;
import e.a.a.a.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class c
extends RecyclerView.g<RecyclerView.c0> {
    private final Map<String, e.a.a.a.a> h = new LinkedHashMap();
    private final Map<String, Integer> i = new LinkedHashMap();
    private int j = 0;

    private RecyclerView.c0 q(ViewGroup viewGroup, e.a.a.a.a a2) {
        View view;
        if (a2.x()) {
            view = a2.c(viewGroup);
            Objects.requireNonNull((Object)view, (String)"Section.getEmptyView() returned null");
        } else {
            Integer n2 = a2.b();
            Objects.requireNonNull((Object)n2, (String)"Missing 'empty' resource id");
            view = this.y(n2, viewGroup);
        }
        return a2.d(view);
    }

    private RecyclerView.c0 r(ViewGroup viewGroup, e.a.a.a.a a2) {
        View view;
        if (a2.y()) {
            view = a2.f(viewGroup);
            Objects.requireNonNull((Object)view, (String)"Section.getFailedView() returned null");
        } else {
            Integer n2 = a2.e();
            Objects.requireNonNull((Object)n2, (String)"Missing 'failed' resource id");
            view = this.y(n2, viewGroup);
        }
        return a2.g(view);
    }

    private RecyclerView.c0 s(ViewGroup viewGroup, e.a.a.a.a a2) {
        View view;
        if (a2.z()) {
            view = a2.i(viewGroup);
            Objects.requireNonNull((Object)view, (String)"Section.getFooterView() returned null");
        } else {
            Integer n2 = a2.h();
            Objects.requireNonNull((Object)n2, (String)"Missing 'footer' resource id");
            view = this.y(n2, viewGroup);
        }
        return a2.j(view);
    }

    private RecyclerView.c0 t(ViewGroup viewGroup, e.a.a.a.a a2) {
        View view;
        if (a2.A()) {
            view = a2.l(viewGroup);
            Objects.requireNonNull((Object)view, (String)"Section.getHeaderView() returned null");
        } else {
            Integer n2 = a2.k();
            Objects.requireNonNull((Object)n2, (String)"Missing 'header' resource id");
            view = this.y(n2, viewGroup);
        }
        return a2.m(view);
    }

    private RecyclerView.c0 u(ViewGroup viewGroup, e.a.a.a.a a2) {
        View view;
        if (a2.B()) {
            view = a2.o(viewGroup);
            Objects.requireNonNull((Object)view, (String)"Section.getItemView() returned null");
        } else {
            Integer n2 = a2.n();
            Objects.requireNonNull((Object)n2, (String)"Missing 'item' resource id");
            view = this.y(n2, viewGroup);
        }
        return a2.p(view);
    }

    private RecyclerView.c0 v(ViewGroup viewGroup, e.a.a.a.a a2) {
        View view;
        if (a2.C()) {
            view = a2.r(viewGroup);
            Objects.requireNonNull((Object)view, (String)"Section.getLoadingView() returned null");
        } else {
            Integer n2 = a2.q();
            Objects.requireNonNull((Object)n2, (String)"Missing 'loading' resource id");
            view = this.y(n2, viewGroup);
        }
        return a2.s(view);
    }

    public int getItemCount() {
        Iterator iterator = this.h.entrySet().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            e.a.a.a.a a2 = (e.a.a.a.a)((Map.Entry)iterator.next()).getValue();
            if (!a2.D()) continue;
            n2 += a2.t();
        }
        return n2;
    }

    public int getItemViewType(int n2) {
        Iterator iterator = this.h.entrySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            int n4;
            Map.Entry entry = (Map.Entry)iterator.next();
            e.a.a.a.a a2 = (e.a.a.a.a)entry.getValue();
            if (!a2.D()) continue;
            int n5 = a2.t();
            if (n2 >= n3 && n2 <= (n4 = n3 + n5 - 1)) {
                int n6 = (Integer)this.i.get(entry.getKey());
                if (a2.w() && n2 == n3) {
                    return n6;
                }
                if (a2.v() && n2 == n4) {
                    return n6 + 1;
                }
                int n7 = a.a[a2.u().ordinal()];
                if (n7 != 1) {
                    if (n7 != 2) {
                        if (n7 != 3) {
                            if (n7 == 4) {
                                return n6 + 5;
                            }
                            throw new IllegalStateException("Invalid state");
                        }
                        return n6 + 4;
                    }
                    return n6 + 3;
                }
                return n6 + 2;
            }
            n3 += n5;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public String o(e.a.a.a.a a2) {
        String string2 = UUID.randomUUID().toString();
        this.p(string2, a2);
        return string2;
    }

    public void onBindViewHolder(RecyclerView.c0 c02, int n2) {
        Iterator iterator = this.h.entrySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            int n4;
            e.a.a.a.a a2 = (e.a.a.a.a)((Map.Entry)iterator.next()).getValue();
            if (!a2.D()) continue;
            int n5 = a2.t();
            if (n2 >= n3 && n2 <= (n4 = -1 + (n3 + n5))) {
                if (a2.w() && n2 == n3) {
                    this.x(n2).I(c02);
                    return;
                }
                if (a2.v() && n2 == n4) {
                    this.x(n2).H(c02);
                    return;
                }
                this.x(n2).E(c02, this.w(n2));
                return;
            }
            n3 += n5;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public RecyclerView.c0 onCreateViewHolder(ViewGroup viewGroup, int n2) {
        Iterator iterator = this.i.entrySet().iterator();
        RecyclerView.c0 c02 = null;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (n2 < (Integer)entry.getValue() || n2 >= 6 + (Integer)entry.getValue()) continue;
            e.a.a.a.a a2 = (e.a.a.a.a)this.h.get(entry.getKey());
            int n3 = n2 - (Integer)entry.getValue();
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 != 2) {
                        if (n3 != 3) {
                            if (n3 != 4) {
                                if (n3 == 5) {
                                    c02 = this.q(viewGroup, a2);
                                    continue;
                                }
                                throw new IllegalArgumentException("Invalid viewType");
                            }
                            c02 = this.r(viewGroup, a2);
                            continue;
                        }
                        c02 = this.v(viewGroup, a2);
                        continue;
                    }
                    c02 = this.u(viewGroup, a2);
                    continue;
                }
                c02 = this.s(viewGroup, a2);
                continue;
            }
            c02 = this.t(viewGroup, a2);
        }
        return c02;
    }

    public void p(String string2, e.a.a.a.a a2) {
        this.h.put((Object)string2, (Object)a2);
        this.i.put((Object)string2, (Object)this.j);
        this.j = 6 + this.j;
    }

    public int w(int n2) {
        Iterator iterator = this.h.entrySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            e.a.a.a.a a2 = (e.a.a.a.a)((Map.Entry)iterator.next()).getValue();
            if (!a2.D()) continue;
            int n4 = a2.t();
            if (n2 >= n3 && n2 <= -1 + (n3 + n4)) {
                return n2 - n3 - a2.w();
            }
            n3 += n4;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public e.a.a.a.a x(int n2) {
        Iterator iterator = this.h.entrySet().iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            e.a.a.a.a a2 = (e.a.a.a.a)((Map.Entry)iterator.next()).getValue();
            if (!a2.D()) continue;
            int n4 = a2.t();
            if (n2 >= n3 && n2 <= -1 + (n3 + n4)) {
                return a2;
            }
            n3 += n4;
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    View y(int n2, ViewGroup viewGroup) {
        return LayoutInflater.from((Context)viewGroup.getContext()).inflate(n2, viewGroup, false);
    }

    public static class b
    extends RecyclerView.c0 {
        public b(View view) {
            super(view);
        }
    }

}

