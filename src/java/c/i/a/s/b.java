/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.Filter
 *  android.widget.Filter$FilterResults
 *  c.i.a.b
 *  c.i.a.l
 *  c.i.a.m
 *  c.i.a.s.c
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package c.i.a.s;

import android.widget.Filter;
import c.i.a.d;
import c.i.a.e;
import c.i.a.l;
import c.i.a.m;
import c.i.a.s.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class b<Model, Item extends l>
extends Filter {
    private List<Item> a;
    private CharSequence b;
    private c<?, Item> c;
    protected c.i.a.u.d<Item> d;
    private m.a<Item> e;

    public b(c<?, Item> c2) {
        this.c = c2;
    }

    public CharSequence a() {
        return this.b;
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        List<Item> list;
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (this.a == null && (charSequence == null || charSequence.length() == 0)) {
            return filterResults;
        }
        Iterator iterator = this.c.i().B().iterator();
        while (iterator.hasNext()) {
            ((d)iterator.next()).i(charSequence);
        }
        this.b = charSequence;
        if (this.a == null) {
            this.a = new ArrayList((Collection)this.c.p());
        }
        if (charSequence != null && charSequence.length() != 0) {
            ArrayList arrayList = new ArrayList();
            if (this.e != null) {
                for (l l2 : this.a) {
                    if (!this.e.a(l2, charSequence)) continue;
                    arrayList.add((Object)l2);
                }
            } else {
                arrayList = this.c.p();
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }
        filterResults.values = list = this.a;
        filterResults.count = list.size();
        this.a = null;
        c.i.a.u.d<Item> d2 = this.d;
        if (d2 != null) {
            d2.a();
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        c.i.a.u.d<Item> d2;
        Object object = filterResults.values;
        if (object != null) {
            this.c.v((List)object, false, null);
        }
        if ((d2 = this.d) != null && this.a != null) {
            d2.b(charSequence, (List)filterResults.values);
        }
    }
}

