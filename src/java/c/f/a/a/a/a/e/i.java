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

public class i
extends e {
    public RecyclerView.c0 a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public i(RecyclerView.c0 c02, int n2, int n3, int n4, int n5) {
        this.a = c02;
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
    }

    @Override
    public void a(RecyclerView.c0 c02) {
        if (this.a == c02) {
            this.a = null;
        }
    }

    @Override
    public RecyclerView.c0 b() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MoveAnimationInfo{holder=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", fromX=");
        stringBuilder.append(this.b);
        stringBuilder.append(", fromY=");
        stringBuilder.append(this.c);
        stringBuilder.append(", toX=");
        stringBuilder.append(this.d);
        stringBuilder.append(", toY=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

