/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  java.lang.Object
 */
package c.i.a.w;

import android.util.SparseArray;
import c.i.a.l;
import c.i.a.q;

public class f<Item extends l>
implements q<Item> {
    private final SparseArray<Item> a = new SparseArray();

    @Override
    public boolean a(Item Item) {
        if (this.a.indexOfKey(Item.getType()) < 0) {
            this.a.put(Item.getType(), Item);
            return true;
        }
        return false;
    }

    @Override
    public Item get(int n2) {
        return (Item)((l)this.a.get(n2));
    }
}

