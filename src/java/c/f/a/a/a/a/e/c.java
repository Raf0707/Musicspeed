/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.a.e;

import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.a.e.e;

public class c
extends e {
    public RecyclerView.c0 a;
    public RecyclerView.c0 b;
    public int c;
    public int d;
    public int e;
    public int f;

    public c(RecyclerView.c0 c02, RecyclerView.c0 c03, int n2, int n3, int n4, int n5) {
        this.b = c02;
        this.a = c03;
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = n5;
    }

    @Override
    public void a(RecyclerView.c0 c02) {
        if (this.b == c02) {
            this.b = null;
        }
        if (this.a == c02) {
            this.a = null;
        }
        if (this.b == null && this.a == null) {
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override
    public RecyclerView.c0 b() {
        RecyclerView.c0 c02 = this.b;
        if (c02 != null) {
            return c02;
        }
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChangeInfo{, oldHolder=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", newHolder=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", fromX=");
        stringBuilder.append(this.c);
        stringBuilder.append(", fromY=");
        stringBuilder.append(this.d);
        stringBuilder.append(", toX=");
        stringBuilder.append(this.e);
        stringBuilder.append(", toY=");
        stringBuilder.append(this.f);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

