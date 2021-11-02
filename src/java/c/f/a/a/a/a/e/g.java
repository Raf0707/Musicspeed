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
import c.f.a.a.a.a.e.i;

public abstract class g
extends b<i> {
    public g(a a2) {
        super(a2);
    }

    protected boolean A(i i2, RecyclerView.c0 c02) {
        RecyclerView.c0 c03 = i2.a;
        if (c03 != null && (c02 == null || c03 == c02)) {
            this.r(i2, c03);
            this.y(i2, i2.a);
            i2.a(i2.a);
            return true;
        }
        return false;
    }

    public long B() {
        return this.a.n();
    }

    public abstract boolean x(RecyclerView.c0 var1, int var2, int var3, int var4, int var5);

    public void y(i i2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchMoveFinished(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemMoveAnimMgr", (String)stringBuilder.toString());
        }
        this.a.F(c02);
    }

    public void z(i i2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchMoveStarting(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemMoveAnimMgr", (String)stringBuilder.toString());
        }
        this.a.G(c02);
    }
}

