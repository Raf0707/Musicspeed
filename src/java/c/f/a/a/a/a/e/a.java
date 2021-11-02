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

public class a
extends e {
    public RecyclerView.c0 a;

    public a(RecyclerView.c0 c02) {
        this.a = c02;
    }

    @Override
    public void a(RecyclerView.c0 c02) {
        if (this.a == null) {
            this.a = null;
        }
    }

    @Override
    public RecyclerView.c0 b() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AddAnimationInfo{holder=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

