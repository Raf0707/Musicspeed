/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  java.lang.Math
 *  java.lang.Object
 */
package j.a.a.a.l;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import j.a.a.a.l.e;
import j.a.a.a.m.a;

public class c
implements e {
    private int a = 200;
    private boolean b = true;
    private int c;

    public c(int n2) {
        this.a = n2;
    }

    public c(Rect rect) {
        this(c.e(rect));
    }

    public c(a a2) {
        this(a2.a());
    }

    public static int e(Rect rect) {
        return Math.max((int)rect.width(), (int)rect.height()) / 2;
    }

    @Override
    public void a(Canvas canvas, Paint paint, int n2, int n3) {
        int n4 = this.a;
        if (n4 > 0) {
            float f2 = n4 + this.c;
            float f3 = n2;
            float f4 = f3 - f2;
            float f5 = n3;
            float f6 = f2 / 2.0f;
            canvas.drawOval(new RectF(f4, f5 - f6, f3 + f2, f5 + f6), paint);
        }
    }

    @Override
    public void b(int n2) {
        this.c = n2;
    }

    @Override
    public int c() {
        return this.a + this.c;
    }

    @Override
    public void d(a a2) {
        if (this.b) {
            this.a = c.e(a2.a());
        }
    }

    @Override
    public int getHeight() {
        return this.a;
    }
}

