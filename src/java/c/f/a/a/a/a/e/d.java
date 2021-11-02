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
import c.f.a.a.a.a.e.a;
import c.f.a.a.a.a.e.b;
import c.f.a.a.a.a.e.e;

public abstract class d
extends b<a> {
    public d(c.f.a.a.a.a.a a2) {
        super(a2);
    }

    protected boolean A(a a2, RecyclerView.c0 c02) {
        RecyclerView.c0 c03 = a2.a;
        if (c03 != null && (c02 == null || c03 == c02)) {
            this.r(a2, c03);
            this.y(a2, a2.a);
            a2.a(a2.a);
            return true;
        }
        return false;
    }

    public long B() {
        return this.a.l();
    }

    public abstract boolean x(RecyclerView.c0 var1);

    public void y(a a2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchAddFinished(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemAddAnimMgr", (String)stringBuilder.toString());
        }
        this.a.B(c02);
    }

    public void z(a a2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchAddStarting(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemAddAnimMgr", (String)stringBuilder.toString());
        }
        this.a.C(c02);
    }
}

