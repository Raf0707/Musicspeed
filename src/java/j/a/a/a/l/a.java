/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  java.lang.Math
 *  java.lang.Object
 */
package j.a.a.a.l;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import j.a.a.a.l.e;

public class a
implements e {
    private int a = 200;
    private boolean b = true;
    private int c;

    public a(int n2) {
        this.a = n2;
    }

    public a(Rect rect) {
        this(a.e(rect));
    }

    public a(j.a.a.a.m.a a2) {
        this(a2.a());
    }

    public static int e(Rect rect) {
        return Math.max((int)rect.width(), (int)rect.height()) / 2;
    }

    @Override
    public void a(Canvas canvas, Paint paint, int n2, int n3) {
        int n4 = this.a;
        if (n4 > 0) {
            canvas.drawCircle((float)n2, (float)n3, (float)(n4 + this.c), paint);
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
    public void d(j.a.a.a.m.a a2) {
        if (this.b) {
            this.a = a.e(a2.a());
        }
    }

    @Override
    public int getHeight() {
        return 2 * this.a;
    }
}

