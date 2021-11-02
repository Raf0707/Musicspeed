/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  java.lang.Object
 */
package j.a.a.a.l;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import j.a.a.a.l.e;
import j.a.a.a.m.a;

public class d
implements e {
    private boolean a = false;
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private Rect e;
    private int f;

    public d(Rect rect, boolean bl) {
        this.a = bl;
        this.c = rect.height();
        this.b = bl ? Integer.MAX_VALUE : rect.width();
        this.e();
    }

    private void e() {
        int n2 = this.b;
        int n3 = -n2 / 2;
        int n4 = this.c;
        this.e = new Rect(n3, -n4 / 2, n2 / 2, n4 / 2);
    }

    @Override
    public void a(Canvas canvas, Paint paint, int n2, int n3) {
        if (!this.e.isEmpty()) {
            Rect rect = this.e;
            int n4 = n2 + rect.left;
            int n5 = this.f;
            canvas.drawRect((float)(n4 - n5), (float)(n3 + rect.top - n5), (float)(n5 + (n2 + rect.right)), (float)(n5 + (n3 + rect.bottom)), paint);
        }
    }

    @Override
    public void b(int n2) {
        this.f = n2;
    }

    @Override
    public int c() {
        return this.c / 2 + this.f;
    }

    @Override
    public void d(a a2) {
        if (this.d) {
            Rect rect = a2.a();
            this.c = rect.height();
            this.b = this.a ? Integer.MAX_VALUE : rect.width();
            this.e();
        }
    }

    @Override
    public int getHeight() {
        return this.c;
    }
}

