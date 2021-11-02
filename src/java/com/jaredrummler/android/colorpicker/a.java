/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package com.jaredrummler.android.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class a
extends Drawable {
    private int a = 10;
    private Paint b = new Paint();
    private Paint c = new Paint();
    private Paint d = new Paint();
    private int e;
    private int f;
    private Bitmap g;

    a(int n2) {
        this.a = n2;
        this.c.setColor(-1);
        this.d.setColor(-3421237);
    }

    private void a() {
        if (this.getBounds().width() > 0) {
            if (this.getBounds().height() <= 0) {
                return;
            }
            this.g = Bitmap.createBitmap((int)this.getBounds().width(), (int)this.getBounds().height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.g);
            Rect rect = new Rect();
            boolean bl = true;
            for (int i2 = 0; i2 <= this.f; ++i2) {
                boolean bl2 = bl;
                for (int i3 = 0; i3 <= this.e; ++i3) {
                    int n2;
                    int n3;
                    int n4 = this.a;
                    rect.top = n3 = i2 * n4;
                    rect.left = n2 = i3 * n4;
                    rect.bottom = n3 + n4;
                    rect.right = n2 + n4;
                    Paint paint = bl2 ? this.c : this.d;
                    canvas.drawRect(rect, paint);
                    bl2 ^= true;
                }
                bl ^= true;
            }
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.g;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.g, null, this.getBounds(), this.b);
        }
    }

    public int getOpacity() {
        return 0;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int n2 = rect.height();
        this.e = (int)Math.ceil((double)(rect.width() / this.a));
        this.f = (int)Math.ceil((double)(n2 / this.a));
        this.a();
    }

    public void setAlpha(int n2) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }
}

