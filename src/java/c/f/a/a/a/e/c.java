/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  androidx.recyclerview.widget.RecyclerView$i
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.List
 */
package c.f.a.a.a.e;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class c<VH extends RecyclerView.c0>
extends RecyclerView.g<VH> {
    protected static final List<Object> h = Collections.emptyList();
    private RecyclerView.g<VH> i;
    private a j;

    public c(RecyclerView.g<VH> g2) {
        a a2;
        this.i = g2;
        this.j = a2 = new a(this);
        this.i.registerAdapterDataObserver(a2);
        super.setHasStableIds(this.i.hasStableIds());
    }

    final void A(int n2, int n3) {
        this.t(n2, n3);
    }

    final void B(int n2, int n3) {
        this.u(n2, n3);
    }

    final void C(int n2, int n3, int n4) {
        this.v(n2, n3, n4);
    }

    public void D() {
        a a2;
        this.w();
        RecyclerView.g<VH> g2 = this.i;
        if (g2 != null && (a2 = this.j) != null) {
            g2.unregisterAdapterDataObserver((RecyclerView.i)a2);
        }
        this.i = null;
        this.j = null;
    }

    public int getItemCount() {
        if (this.p()) {
            return this.i.getItemCount();
        }
        return 0;
    }

    public long getItemId(int n2) {
        return this.i.getItemId(n2);
    }

    public int getItemViewType(int n2) {
        return this.i.getItemViewType(n2);
    }

    public RecyclerView.g<VH> o() {
        return this.i;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.p()) {
            this.i.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(VH VH, int n2) {
        this.onBindViewHolder(VH, n2, h);
    }

    public void onBindViewHolder(VH VH, int n2, List<Object> list) {
        if (this.p()) {
            this.i.onBindViewHolder(VH, n2, list);
        }
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int n2) {
        return (VH)this.i.onCreateViewHolder(viewGroup, n2);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (this.p()) {
            this.i.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public void onViewAttachedToWindow(VH VH) {
        if (this.p()) {
            this.i.onViewAttachedToWindow(VH);
        }
    }

    public void onViewDetachedFromWindow(VH VH) {
        if (this.p()) {
            this.i.onViewDetachedFromWindow(VH);
        }
    }

    public void onViewRecycled(VH VH) {
        if (this.p()) {
            this.i.onViewRecycled(VH);
        }
    }

    public boolean p() {
        return this.i != null;
    }

    protected void q() {
        this.notifyDataSetChanged();
    }

    protected void r(int n2, int n3) {
        this.notifyItemRangeChanged(n2, n3);
    }

    protected void s(int n2, int n3, Object object) {
        this.notifyItemRangeChanged(n2, n3, object);
    }

    public void setHasStableIds(boolean bl) {
        super.setHasStableIds(bl);
        if (this.p()) {
            this.i.setHasStableIds(bl);
        }
    }

    protected void t(int n2, int n3) {
        this.notifyItemRangeInserted(n2, n3);
    }

    protected void u(int n2, int n3) {
        this.notifyItemRangeRemoved(n2, n3);
    }

    protected void v(int n2, int n3, int n4) {
        if (n4 == 1) {
            this.notifyItemMoved(n2, n3);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("itemCount should be always 1  (actual: ");
        stringBuilder.append(n4);
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected void w() {
    }

    final void x() {
        this.q();
    }

    final void y(int n2, int n3) {
        this.r(n2, n3);
    }

    final void z(int n2, int n3, Object object) {
        this.s(n2, n3, object);
    }

    private static final class a<VH extends RecyclerView.c0>
    extends RecyclerView.i {
        private final WeakReference<c<VH>> a;

        public a(c<VH> c2) {
            this.a = new WeakReference(c2);
        }

        public void onChanged() {
            c c2 = (c)((Object)this.a.get());
            if (c2 != null) {
                c2.x();
            }
        }

        public void onItemRangeChanged(int n2, int n3) {
            c c2 = (c)((Object)this.a.get());
            if (c2 != null) {
                c2.y(n2, n3);
            }
        }

        public void onItemRangeChanged(int n2, int n3, Object object) {
            c c2 = (c)((Object)this.a.get());
            if (c2 != null) {
                c2.z(n2, n3, object);
            }
        }

        public void onItemRangeInserted(int n2, int n3) {
            c c2 = (c)((Object)this.a.get());
            if (c2 != null) {
                c2.A(n2, n3);
            }
        }

        public void onItemRangeMoved(int n2, int n3, int n4) {
            c c2 = (c)((Object)this.a.get());
            if (c2 != null) {
                c2.C(n2, n3, n4);
            }
        }

        public void onItemRangeRemoved(int n2, int n3) {
            c c2 = (c)((Object)this.a.get());
            if (c2 != null) {
                c2.B(n2, n3);
            }
        }
    }

}

