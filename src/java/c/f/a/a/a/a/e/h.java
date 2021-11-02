/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  c.f.a.a.a.a.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.a.e;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.a.a;
import c.f.a.a.a.a.e.b;
import c.f.a.a.a.a.e.e;
import c.f.a.a.a.a.e.j;

public abstract class h
extends b<j> {
    public h(a a2) {
        super(a2);
    }

    protected boolean A(j j2, RecyclerView.c0 c02) {
        RecyclerView.c0 c03 = j2.a;
        if (c03 != null && (c02 == null || c03 == c02)) {
            this.r(j2, c03);
            this.y(j2, j2.a);
            j2.a(j2.a);
            return true;
        }
        return false;
    }

    public long B() {
        return this.a.o();
    }

    public abstract boolean x(RecyclerView.c0 var1);

    public void y(j j2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchRemoveFinished(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemRemoveAnimMgr", (String)stringBuilder.toString());
        }
        this.a.H(c02);
    }

    public void z(j j2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchRemoveStarting(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemRemoveAnimMgr", (String)stringBuilder.toString());
        }
        this.a.I(c02);
    }
}

