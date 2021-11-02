/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ComposeShader
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Point
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.jaredrummler.android.colorpicker.e;
import com.jaredrummler.android.colorpicker.f;
import com.jaredrummler.android.colorpicker.k;

public class ColorPickerView
extends View {
    private boolean A = false;
    private String B = null;
    private int C = -4342339;
    private int D = -9539986;
    private int E;
    private Rect F;
    private Rect G;
    private Rect H;
    private Rect I;
    private Point J = null;
    private com.jaredrummler.android.colorpicker.a K;
    private c L;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Paint l;
    private Paint m;
    private Paint n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Shader r;
    private Shader s;
    private Shader t;
    private b u;
    private b v;
    private int w = 255;
    private float x = 360.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.g(context, attributeSet);
    }

    private Point a(int n2) {
        Rect rect = this.I;
        float f2 = rect.width();
        Point point = new Point();
        point.x = (int)(f2 - f2 * (float)n2 / 255.0f + (float)rect.left);
        point.y = rect.top;
        return point;
    }

    private void b(Context context) {
        TypedArray typedArray = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
        if (this.D == -9539986) {
            this.D = typedArray.getColor(0, -9539986);
        }
        if (this.C == -4342339) {
            this.C = typedArray.getColor(0, -4342339);
        }
        typedArray.recycle();
    }

    private void c(Canvas canvas) {
        Rect rect;
        if (this.A && (rect = this.I) != null) {
            if (this.K == null) {
                return;
            }
            this.q.setColor(this.D);
            canvas.drawRect((float)(rect.left - 1), (float)(rect.top - 1), (float)(1 + rect.right), (float)(1 + rect.bottom), this.q);
            this.K.draw(canvas);
            float[] arrf = new float[]{this.x, this.y, this.z};
            int n2 = Color.HSVToColor((float[])arrf);
            int n3 = Color.HSVToColor((int)0, (float[])arrf);
            float f2 = rect.left;
            int n4 = rect.top;
            LinearGradient linearGradient = new LinearGradient(f2, (float)n4, (float)rect.right, (float)n4, n2, n3, Shader.TileMode.CLAMP);
            this.t = linearGradient;
            this.n.setShader((Shader)linearGradient);
            canvas.drawRect(rect, this.n);
            String string = this.B;
            if (string != null && !string.equals((Object)"")) {
                canvas.drawText(this.B, (float)rect.centerX(), (float)(rect.centerY() + e.a(this.getContext(), 4.0f)), this.o);
            }
            Point point = this.a(this.w);
            RectF rectF = new RectF();
            int n5 = point.x;
            int n6 = this.k;
            rectF.left = n5 - n6 / 2;
            rectF.right = n5 + n6 / 2;
            int n7 = rect.top;
            int n8 = this.j;
            rectF.top = n7 - n8;
            rectF.bottom = n8 + rect.bottom;
            canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.p);
        }
    }

    private void d(Canvas canvas) {
        Rect rect = this.H;
        this.q.setColor(this.D);
        canvas.drawRect((float)(rect.left - 1), (float)(rect.top - 1), (float)(1 + rect.right), (float)(1 + rect.bottom), this.q);
        if (this.v == null) {
            b b2;
            this.v = b2 = new b();
            b2.b = Bitmap.createBitmap((int)rect.width(), (int)rect.height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            this.v.a = new Canvas(this.v.b);
            int n2 = (int)(0.5f + (float)rect.height());
            int[] arrn = new int[n2];
            int n3 = 0;
            float f2 = 360.0f;
            for (int i2 = 0; i2 < n2; ++i2) {
                arrn[i2] = Color.HSVToColor((float[])new float[]{f2, 1.0f, 1.0f});
                f2 -= 360.0f / (float)n2;
            }
            Paint paint = new Paint();
            paint.setStrokeWidth(0.0f);
            while (n3 < n2) {
                paint.setColor(arrn[n3]);
                b b3 = this.v;
                Canvas canvas2 = b3.a;
                float f3 = n3;
                canvas2.drawLine(0.0f, f3, (float)b3.b.getWidth(), f3, paint);
                ++n3;
            }
        }
        canvas.drawBitmap(this.v.b, null, rect, null);
        Point point = this.f(this.x);
        RectF rectF = new RectF();
        int n4 = rect.left;
        int n5 = this.j;
        rectF.left = n4 - n5;
        rectF.right = n5 + rect.right;
        int n6 = point.y;
        int n7 = this.k;
        rectF.top = n6 - n7 / 2;
        rectF.bottom = n6 + n7 / 2;
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.p);
    }

    private void e(Canvas canvas) {
        b b2;
        Rect rect = this.G;
        this.q.setColor(this.D);
        Rect rect2 = this.F;
        canvas.drawRect((float)rect2.left, (float)rect2.top, (float)(1 + rect.right), (float)(1 + rect.bottom), this.q);
        if (this.r == null) {
            int n2 = rect.left;
            LinearGradient linearGradient = new LinearGradient((float)n2, (float)rect.top, (float)n2, (float)rect.bottom, -1, -16777216, Shader.TileMode.CLAMP);
            this.r = linearGradient;
        }
        if ((b2 = this.u) == null || b2.c != this.x) {
            if (b2 == null) {
                this.u = new b();
            }
            b b3 = this.u;
            if (b3.b == null) {
                b3.b = Bitmap.createBitmap((int)rect.width(), (int)rect.height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            }
            b b4 = this.u;
            if (b4.a == null) {
                b4.a = new Canvas(this.u.b);
            }
            float[] arrf = new float[]{this.x, 1.0f, 1.0f};
            int n3 = Color.HSVToColor((float[])arrf);
            float f2 = rect.left;
            int n4 = rect.top;
            LinearGradient linearGradient = new LinearGradient(f2, (float)n4, (float)rect.right, (float)n4, -1, n3, Shader.TileMode.CLAMP);
            this.s = linearGradient;
            ComposeShader composeShader = new ComposeShader(this.r, this.s, PorterDuff.Mode.MULTIPLY);
            this.l.setShader((Shader)composeShader);
            b b5 = this.u;
            b5.a.drawRect(0.0f, 0.0f, (float)b5.b.getWidth(), (float)this.u.b.getHeight(), this.l);
            this.u.c = this.x;
        }
        canvas.drawBitmap(this.u.b, null, rect, null);
        Point point = this.m(this.y, this.z);
        this.m.setColor(-16777216);
        canvas.drawCircle((float)point.x, (float)point.y, (float)(this.i - e.a(this.getContext(), 1.0f)), this.m);
        this.m.setColor(-2236963);
        canvas.drawCircle((float)point.x, (float)point.y, (float)this.i, this.m);
    }

    private Point f(float f2) {
        Rect rect = this.H;
        float f3 = rect.height();
        Point point = new Point();
        point.y = (int)(f3 - f2 * f3 / 360.0f + (float)rect.top);
        point.x = rect.left;
        return point;
    }

    private void g(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, k.w);
        this.A = typedArray.getBoolean(k.y, false);
        this.B = typedArray.getString(k.x);
        this.C = typedArray.getColor(k.A, -4342339);
        this.D = typedArray.getColor(k.z, -9539986);
        typedArray.recycle();
        this.b(context);
        this.f = e.a(this.getContext(), 30.0f);
        this.g = e.a(this.getContext(), 20.0f);
        this.h = e.a(this.getContext(), 10.0f);
        this.i = e.a(this.getContext(), 5.0f);
        this.k = e.a(this.getContext(), 4.0f);
        this.j = e.a(this.getContext(), 2.0f);
        this.E = this.getResources().getDimensionPixelSize(f.b);
        this.h();
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

    private int getPreferredHeight() {
        int n2 = e.a(this.getContext(), 200.0f);
        if (this.A) {
            n2 += this.h + this.g;
        }
        return n2;
    }

    private int getPreferredWidth() {
        return e.a(this.getContext(), 200.0f) + this.f + this.h;
    }

    private void h() {
        this.l = new Paint();
        this.m = new Paint();
        this.p = new Paint();
        this.n = new Paint();
        this.o = new Paint();
        this.q = new Paint();
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth((float)e.a(this.getContext(), 2.0f));
        this.m.setAntiAlias(true);
        this.p.setColor(this.C);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth((float)e.a(this.getContext(), 2.0f));
        this.p.setAntiAlias(true);
        this.o.setColor(-14935012);
        this.o.setTextSize((float)e.a(this.getContext(), 14.0f));
        this.o.setAntiAlias(true);
        this.o.setTextAlign(Paint.Align.CENTER);
        this.o.setFakeBoldText(true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean i(MotionEvent motionEvent) {
        Point point = this.J;
        if (point == null) {
            return false;
        }
        int n2 = point.x;
        int n3 = point.y;
        if (this.H.contains(n2, n3)) {
            this.x = this.k(motionEvent.getY());
            do {
                return true;
                break;
            } while (true);
        }
        if (this.G.contains(n2, n3)) {
            float[] arrf = this.l(motionEvent.getX(), motionEvent.getY());
            this.y = arrf[0];
            this.z = arrf[1];
            return true;
        }
        Rect rect = this.I;
        if (rect == null || !rect.contains(n2, n3)) return false;
        this.w = this.j((int)motionEvent.getX());
        return true;
    }

    private int j(int n2) {
        Rect rect = this.I;
        int n3 = rect.width();
        int n4 = rect.left;
        int n5 = n2 < n4 ? 0 : (n2 > rect.right ? n3 : n2 - n4);
        return 255 - n5 * 255 / n3;
    }

    private float k(float f2) {
        Rect rect = this.H;
        float f3 = rect.height();
        int n2 = rect.top;
        float f4 = f2 < (float)n2 ? 0.0f : (f2 > (float)rect.bottom ? f3 : f2 - (float)n2);
        return 360.0f - f4 * 360.0f / f3;
    }

    private float[] l(float f2, float f3) {
        Rect rect = this.G;
        float[] arrf = new float[2];
        float f4 = rect.width();
        float f5 = rect.height();
        int n2 = rect.left;
        float f6 = f2 < (float)n2 ? 0.0f : (f2 > (float)rect.right ? f4 : f2 - (float)n2);
        int n3 = rect.top;
        float f7 = f3 < (float)n3 ? 0.0f : (f3 > (float)rect.bottom ? f5 : f3 - (float)n3);
        arrf[0] = f6 * (1.0f / f4);
        arrf[1] = 1.0f - f7 * (1.0f / f5);
        return arrf;
    }

    private Point m(float f2, float f3) {
        Rect rect = this.G;
        float f4 = rect.height();
        float f5 = rect.width();
        Point point = new Point();
        point.x = (int)(f2 * f5 + (float)rect.left);
        point.y = (int)(f4 * (1.0f - f3) + (float)rect.top);
        return point;
    }

    private void o() {
        com.jaredrummler.android.colorpicker.a a2;
        if (!this.A) {
            return;
        }
        Rect rect = this.F;
        int n2 = 1 + rect.left;
        int n3 = rect.bottom;
        int n4 = 1 + (n3 - this.g);
        int n5 = n3 - 1;
        this.I = new Rect(n2, n4, -1 + rect.right, n5);
        this.K = a2 = new com.jaredrummler.android.colorpicker.a(e.a(this.getContext(), 4.0f));
        a2.setBounds(Math.round((float)this.I.left), Math.round((float)this.I.top), Math.round((float)this.I.right), Math.round((float)this.I.bottom));
    }

    private void p() {
        Rect rect = this.F;
        int n2 = rect.right;
        int n3 = 1 + (n2 - this.f);
        int n4 = 1 + rect.top;
        int n5 = -1 + rect.bottom;
        int n6 = this.A ? this.h + this.g : 0;
        int n7 = n5 - n6;
        this.H = new Rect(n3, n4, n2 - 1, n7);
    }

    private void q() {
        Rect rect = this.F;
        int n2 = 1 + rect.left;
        int n3 = 1 + rect.top;
        int n4 = -1 + rect.bottom;
        int n5 = -1 + rect.right;
        int n6 = this.h;
        int n7 = n5 - n6 - this.f;
        if (this.A) {
            n4 -= n6 + this.g;
        }
        this.G = new Rect(n2, n3, n7, n4);
    }

    public String getAlphaSliderText() {
        return this.B;
    }

    public int getBorderColor() {
        return this.D;
    }

    public int getColor() {
        int n2 = this.w;
        float[] arrf = new float[]{this.x, this.y, this.z};
        return Color.HSVToColor((int)n2, (float[])arrf);
    }

    public int getPaddingBottom() {
        return Math.max((int)super.getPaddingBottom(), (int)this.E);
    }

    public int getPaddingLeft() {
        return Math.max((int)super.getPaddingLeft(), (int)this.E);
    }

    public int getPaddingRight() {
        return Math.max((int)super.getPaddingRight(), (int)this.E);
    }

    public int getPaddingTop() {
        return Math.max((int)super.getPaddingTop(), (int)this.E);
    }

    public int getSliderTrackerColor() {
        return this.C;
    }

    public void n(int n2, boolean bl) {
        float f2;
        float f3;
        float f4;
        c c2;
        int n3 = Color.alpha((int)n2);
        int n4 = Color.red((int)n2);
        int n5 = Color.blue((int)n2);
        int n6 = Color.green((int)n2);
        float[] arrf = new float[3];
        Color.RGBToHSV((int)n4, (int)n6, (int)n5, (float[])arrf);
        this.w = n3;
        this.x = f4 = arrf[0];
        this.y = f2 = arrf[1];
        this.z = f3 = arrf[2];
        if (bl && (c2 = this.L) != null) {
            c2.n(Color.HSVToColor((int)n3, (float[])new float[]{f4, f2, f3}));
        }
        this.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (this.F.width() > 0) {
            if (this.F.height() <= 0) {
                return;
            }
            this.e(canvas);
            this.d(canvas);
            this.c(canvas);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        block15 : {
            int n6;
            block14 : {
                int n7;
                int n8;
                block16 : {
                    block12 : {
                        int n9;
                        block13 : {
                            n8 = View.MeasureSpec.getMode((int)n2);
                            n7 = View.MeasureSpec.getMode((int)n3);
                            n5 = View.MeasureSpec.getSize((int)n2) - this.getPaddingLeft() - this.getPaddingRight();
                            n4 = View.MeasureSpec.getSize((int)n3) - this.getPaddingBottom() - this.getPaddingTop();
                            if (n8 == 1073741824 || n7 == 1073741824) break block12;
                            int n10 = this.h;
                            int n11 = n4 + n10;
                            int n12 = this.f;
                            n6 = n11 + n12;
                            n9 = n5 - n10 - n12;
                            if (this.A) {
                                int n13 = this.g;
                                n6 -= n10 + n13;
                                n9 += n10 + n13;
                            }
                            boolean bl = true;
                            boolean bl2 = n6 <= n5;
                            if (n9 > n4) {
                                bl = false;
                            }
                            if (bl2 && bl) break block13;
                            if (!bl && bl2) break block14;
                            if (bl2 || !bl) break block15;
                        }
                        n4 = n9;
                        break block15;
                    }
                    if (n8 != 1073741824 || n7 == 1073741824) break block16;
                    int n14 = this.h;
                    int n15 = n5 - n14 - this.f;
                    if (this.A) {
                        n15 += n14 + this.g;
                    }
                    if (n15 <= n4) {
                        n4 = n15;
                    }
                    break block15;
                }
                if (n7 != 1073741824 || n8 == 1073741824) break block15;
                int n16 = this.h;
                n6 = n4 + n16 + this.f;
                if (this.A) {
                    n6 -= n16 + this.g;
                }
                if (n6 > n5) break block15;
            }
            n5 = n6;
        }
        this.setMeasuredDimension(n5 + this.getPaddingLeft() + this.getPaddingRight(), n4 + this.getPaddingTop() + this.getPaddingBottom());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.w = bundle.getInt("alpha");
            this.x = bundle.getFloat("hue");
            this.y = bundle.getFloat("sat");
            this.z = bundle.getFloat("val");
            this.A = bundle.getBoolean("show_alpha");
            this.B = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("alpha", this.w);
        bundle.putFloat("hue", this.x);
        bundle.putFloat("sat", this.y);
        bundle.putFloat("val", this.z);
        bundle.putBoolean("show_alpha", this.A);
        bundle.putString("alpha_text", this.B);
        return bundle;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        Rect rect;
        super.onSizeChanged(n2, n3, n4, n5);
        this.F = rect = new Rect();
        rect.left = this.getPaddingLeft();
        this.F.right = n2 - this.getPaddingRight();
        this.F.top = this.getPaddingTop();
        this.F.bottom = n3 - this.getPaddingBottom();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.q();
        this.p();
        this.o();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl;
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 != 1) {
                bl = n2 != 2 ? false : this.i(motionEvent);
            } else {
                this.J = null;
                bl = this.i(motionEvent);
            }
        } else {
            this.J = new Point((int)motionEvent.getX(), (int)motionEvent.getY());
            bl = this.i(motionEvent);
        }
        if (bl) {
            c c2 = this.L;
            if (c2 != null) {
                int n3 = this.w;
                float[] arrf = new float[]{this.x, this.y, this.z};
                c2.n(Color.HSVToColor((int)n3, (float[])arrf));
            }
            this.invalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAlphaSliderText(int n2) {
        this.setAlphaSliderText(this.getContext().getString(n2));
    }

    public void setAlphaSliderText(String string) {
        this.B = string;
        this.invalidate();
    }

    public void setAlphaSliderVisible(boolean bl) {
        if (this.A != bl) {
            this.A = bl;
            this.r = null;
            this.s = null;
            this.t = null;
            this.v = null;
            this.u = null;
            this.requestLayout();
        }
    }

    public void setBorderColor(int n2) {
        this.D = n2;
        this.invalidate();
    }

    public void setColor(int n2) {
        this.n(n2, false);
    }

    public void setOnColorChangedListener(c c2) {
        this.L = c2;
    }

    public void setSliderTrackerColor(int n2) {
        this.C = n2;
        this.p.setColor(n2);
        this.invalidate();
    }

    private class b {
        public Canvas a;
        public Bitmap b;
        public float c;

        private b() {
        }
    }

    public static interface c {
        public void n(int var1);
    }

}

