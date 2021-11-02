/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.view.View
 *  java.lang.Object
 */
package j.a.a.a.m;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import j.a.a.a.m.a;

public class b
implements a {
    private final View b;

    public b(View view) {
        this.b = view;
    }

    @Override
    public Rect a() {
        int[] arrn = new int[2];
        this.b.getLocationInWindow(arrn);
        return new Rect(arrn[0], arrn[1], arrn[0] + this.b.getMeasuredWidth(), arrn[1] + this.b.getMeasuredHeight());
    }

    @Override
    public Point b() {
        int[] arrn = new int[2];
        this.b.getLocationInWindow(arrn);
        return new Point(arrn[0] + this.b.getWidth() / 2, arrn[1] + this.b.getHeight() / 2);
    }

    public View c() {
        return this.b;
    }
}

