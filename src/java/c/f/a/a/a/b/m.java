/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  java.lang.IllegalArgumentException
 */
package c.f.a.a.a.b;

import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.b.b;

class m
extends b {
    public m(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    protected int q(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                return 3;
            }
            throw new IllegalArgumentException();
        }
        return 1;
    }
}

