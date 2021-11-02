/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.Toast
 *  b.i.q.w
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;
import b.i.q.w;
import com.jaredrummler.android.colorpicker.a;
import com.jaredrummler.android.colorpicker.e;
import com.jaredrummler.android.colorpicker.g;
import com.jaredrummler.android.colorpicker.k;
import java.util.Locale;

public class ColorPanelView
extends View {
    private Drawable f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Rect k;
    private Rect l;
    private RectF m = new RectF();
    private boolean n;
    private int o;
    private int p = -9539986;
    private int q = -16777216;
    private int r;

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        boolean bl;
        Paint paint;
        Paint paint2;
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, k.s);
        this.r = typedArray.getInt(k.u, 1);
        this.n = bl = typedArray.getBoolean(k.v, false);
        if (bl && this.r != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.p = typedArray.getColor(k.t, -9539986);
        typedArray.recycle();
        if (this.p == -9539986) {
            TypedArray typedArray2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
            this.p = typedArray2.getColor(0, this.p);
            typedArray2.recycle();
        }
        this.o = e.a(context, 1.0f);
        this.g = paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.h = paint = new Paint();
        paint.setAntiAlias(true);
        if (this.n) {
            this.j = new Paint();
        }
        if (this.r == 1) {
            Paint paint3;
            Bitmap bitmap = ((BitmapDrawable)context.getResources().getDrawable(g.a)).getBitmap();
            this.i = paint3 = new Paint();
            paint3.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.i.setShader((Shader)bitmapShader);
        }
    }

    private void b() {
        Rect rect = this.k;
        int n2 = rect.left;
        int n3 = this.o;
        int n4 = n2 + n3;
        int n5 = n3 + rect.top;
        int n6 = rect.bottom - n3;
        int n7 = rect.right - n3;
        this.m = new RectF((float)n4, (float)n5, (float)n7, (float)n6);
    }

    private void c() {
        Rect rect = this.k;
        int n2 = rect.left;
        int n3 = this.o;
        int n4 = n2 + n3;
        int n5 = n3 + rect.top;
        int n6 = rect.bottom - n3;
        this.l = new Rect(n4, n5, rect.right - n3, n6);
        a a2 = new a(e.a(this.getContext(), 4.0f));
        this.f = a2;
        a2.setBounds(Math.round((float)this.l.left), Math.round((float)this.l.top), Math.round((float)this.l.right), Math.round((float)this.l.bottom));
    }

    public void d() {
        int[] arrn = new int[2];
        Rect rect = new Rect();
        this.getLocationOnScreen(arrn);
        this.getWindowVisibleDisplayFrame(rect);
        Context context = this.getContext();
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = arrn[1] + n3 / 2;
        int n5 = arrn[0] + n2 / 2;
        if (w.C((View)this) == 0) {
            n5 = context.getResources().getDisplayMetrics().widthPixels - n5;
        }
        StringBuilder stringBuilder = new StringBuilder("#");
        if (Color.alpha((int)this.q) != 255) {
            stringBuilder.append(Integer.toHexString((int)this.q).toUpperCase(Locale.ENGLISH));
        } else {
            Object[] arrobject = new Object[]{16777215 & this.q};
            stringBuilder.append(String.format((String)"%06X", (Object[])arrobject).toUpperCase(Locale.ENGLISH));
        }
        Toast toast = Toast.makeText((Context)context, (CharSequence)stringBuilder.toString(), (int)0);
        if (n4 < rect.height()) {
            toast.setGravity(8388661, n5, n3 + arrn[1] - rect.top);
        } else {
            toast.setGravity(81, 0, n3);
        }
        toast.show();
    }

    public int getBorderColor() {
        return this.p;
    }

    public int getColor() {
        return this.q;
    }

    public int getShape() {
        return this.r;
    }

    protected void onDraw(Canvas canvas) {
        this.g.setColor(this.p);
        this.h.setColor(this.q);
        int n2 = this.r;
        if (n2 == 0) {
            Drawable drawable;
            if (this.o > 0) {
                canvas.drawRect(this.k, this.g);
            }
            if ((drawable = this.f) != null) {
                drawable.draw(canvas);
            }
            canvas.drawRect(this.l, this.h);
            return;
        }
        if (n2 == 1) {
            int n3 = this.getMeasuredWidth() / 2;
            if (this.o > 0) {
                canvas.drawCircle((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2), (float)n3, this.g);
            }
            if (Color.alpha((int)this.q) < 255) {
                canvas.drawCircle((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2), (float)(n3 - this.o), this.i);
            }
            if (this.n) {
                canvas.drawArc(this.m, 90.0f, 180.0f, true, this.j);
                canvas.drawArc(this.m, 270.0f, 180.0f, true, this.h);
                return;
            }
            canvas.drawCircle((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2), (float)(n3 - this.o), this.h);
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = this.r;
        if (n4 == 0) {
            this.setMeasuredDimension(View.MeasureSpec.getSize((int)n2), View.MeasureSpec.getSize((int)n3));
            return;
        }
        if (n4 == 1) {
            super.onMeasure(n2, n2);
            this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredWidth());
            return;
        }
        super.onMeasure(n2, n3);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.q = bundle.getInt("color");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("color", this.q);
        return bundle;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        if (this.r == 0 || this.n) {
            Rect rect;
            this.k = rect = new Rect();
            rect.left = this.getPaddingLeft();
            this.k.right = n2 - this.getPaddingRight();
            this.k.top = this.getPaddingTop();
            this.k.bottom = n3 - this.getPaddingBottom();
            if (this.n) {
                this.b();
                return;
            }
            this.c();
        }
    }

    public void setBorderColor(int n2) {
        this.p = n2;
        this.invalidate();
    }

    public void setColor(int n2) {
        this.q = n2;
        this.invalidate();
    }

    public void setOriginalColor(int n2) {
        Paint paint = this.j;
        if (paint != null) {
            paint.setColor(n2);
        }
    }

    public void setShape(int n2) {
        this.r = n2;
        this.invalidate();
    }
}

