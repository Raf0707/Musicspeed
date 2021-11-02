/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 */
package c.f.a.a.a.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.e.d;

public class h {
    public final int a;
    public final int b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final Rect h;
    public final int i;

    public h(RecyclerView recyclerView, RecyclerView.c0 c02, int n2, int n3) {
        Rect rect;
        int n4;
        int n5;
        this.a = c02.itemView.getWidth();
        this.b = c02.itemView.getHeight();
        this.c = c02.getItemId();
        this.d = n5 = c02.itemView.getLeft();
        this.e = n4 = c02.itemView.getTop();
        this.f = n2 - n5;
        this.g = n3 - n4;
        this.h = rect = new Rect();
        d.o(c02.itemView, rect);
        this.i = d.v(c02);
    }

    private h(h h2, RecyclerView.c0 c02) {
        int n2;
        int n3;
        this.c = h2.c;
        this.a = n2 = c02.itemView.getWidth();
        this.b = n3 = c02.itemView.getHeight();
        this.h = new Rect(h2.h);
        this.i = d.v(c02);
        this.d = h2.d;
        this.e = h2.e;
        float f2 = 0.5f * (float)h2.a;
        float f3 = 0.5f * (float)h2.b;
        float f4 = 0.5f * (float)n2;
        float f5 = 0.5f * (float)n3;
        float f6 = (float)h2.f - f2;
        float f7 = (float)h2.g - f3;
        float f8 = f6 + f4;
        float f9 = f7 + f5;
        if (f8 >= 0.0f && f8 < (float)n2) {
            f4 = f8;
        }
        this.f = (int)f4;
        if (f9 >= 0.0f && f9 < (float)n3) {
            f5 = f9;
        }
        this.g = (int)f5;
    }

    public static h a(h h2, RecyclerView.c0 c02) {
        return new h(h2, c02);
    }
}

