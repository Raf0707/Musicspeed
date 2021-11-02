/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  c.f.a.a.a.a.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.a.e;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.a.a;
import c.f.a.a.a.a.e.b;
import c.f.a.a.a.a.e.c;
import c.f.a.a.a.a.e.e;

public abstract class f
extends b<c> {
    public f(a a2) {
        super(a2);
    }

    protected boolean A(c c2, RecyclerView.c0 c02) {
        RecyclerView.c0 c03;
        RecyclerView.c0 c04 = c2.b;
        if (c04 != null && (c02 == null || c04 == c02)) {
            this.r(c2, c04);
            this.y(c2, c2.b);
            c2.a(c2.b);
        }
        if ((c03 = c2.a) != null && (c02 == null || c03 == c02)) {
            this.r(c2, c03);
            this.y(c2, c2.a);
            c2.a(c2.a);
        }
        return c2.b == null && c2.a == null;
    }

    public long B() {
        return this.a.m();
    }

    protected void C(c c2) {
        RecyclerView.c0 c02;
        RecyclerView.c0 c03 = c2.b;
        if (c03 != null && c03.itemView != null) {
            this.E(c2);
        }
        if ((c02 = c2.a) != null && c02.itemView != null) {
            this.D(c2);
        }
    }

    protected abstract void D(c var1);

    protected abstract void E(c var1);

    public abstract boolean x(RecyclerView.c0 var1, RecyclerView.c0 var2, int var3, int var4, int var5, int var6);

    public void y(c c2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchChangeFinished(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemChangeAnimMgr", (String)stringBuilder.toString());
        }
        a a2 = this.a;
        boolean bl = c02 == c2.b;
        a2.D(c02, bl);
    }

    public void z(c c2, RecyclerView.c0 c02) {
        if (this.d()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dispatchChangeStarting(");
            stringBuilder.append((Object)c02);
            stringBuilder.append(")");
            Log.d((String)"ARVItemChangeAnimMgr", (String)stringBuilder.toString());
        }
        a a2 = this.a;
        boolean bl = c02 == c2.b;
        a2.E(c02, bl);
    }
}

