/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.text.TextPaint
 *  b.i.h.a
 *  java.lang.Character
 *  java.lang.CloneNotSupportedException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package c.i.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import c.i.b.b.b;

public class a
extends Drawable {
    private float A = 0.0f;
    private float B = 0.0f;
    private int C = 0;
    private c.i.b.b.a D;
    private String E;
    private ColorStateList F;
    private PorterDuff.Mode G = PorterDuff.Mode.SRC_IN;
    private ColorFilter H;
    private ColorFilter I;
    private Context a;
    private int b = -1;
    private int c = -1;
    private boolean d = false;
    private ColorStateList e;
    private Paint f;
    private int g;
    private int h;
    private Paint i;
    private int j;
    private Paint k;
    private Paint l;
    private int m = -1;
    private int n = -1;
    private Rect o;
    private RectF p;
    private Path q;
    private int r;
    private int s;
    private int t;
    private int u = 0;
    private int v = 0;
    private int w = 255;
    private boolean x;
    private boolean y;
    private float z = 0.0f;

    public a(Context context) {
        this.a = context.getApplicationContext();
        this.w();
        this.o(Character.valueOf((char)' '));
    }

    public a(Context context, c.i.b.b.a a2) {
        this.a = context.getApplicationContext();
        this.w();
        this.n(a2);
    }

    private void F() {
        boolean bl;
        int n2 = this.e.getColorForState(this.getState(), this.e.getDefaultColor());
        int n3 = Color.rgb((int)Color.red((int)n2), (int)Color.green((int)n2), (int)Color.blue((int)n2));
        if (n3 != this.f.getColor()) {
            this.f.setColor(n3);
            bl = true;
        } else {
            bl = false;
        }
        int n4 = Color.alpha((int)n2);
        if (n4 != 255 && n4 != this.w) {
            this.setAlpha(n4);
            return;
        }
        if (bl) {
            this.invalidateSelf();
        }
    }

    private void G(Rect rect) {
        int n2 = this.r;
        if (n2 >= 0 && n2 * 2 <= rect.width() && 2 * this.r <= rect.height()) {
            Rect rect2 = this.o;
            int n3 = rect.left;
            int n4 = this.r;
            rect2.set(n3 + n4, n4 + rect.top, rect.right - n4, rect.bottom - n4);
        }
    }

    private void H(Rect rect) {
        float f2 = rect.height();
        int n2 = this.d ? 1 : 2;
        float f3 = f2 * (float)n2;
        this.f.setTextSize(f3);
        c.i.b.b.a a2 = this.D;
        String string = a2 != null ? String.valueOf((char)a2.a()) : String.valueOf((Object)this.E);
        Paint paint = this.f;
        int n3 = string.length();
        float f4 = rect.height();
        Path path = this.q;
        paint.getTextPath(string, 0, n3, 0.0f, f4, path);
        this.q.computeBounds(this.p, true);
        if (!this.d) {
            float f5;
            float f6 = (float)this.o.width() / this.p.width();
            if (!(f6 < (f5 = (float)this.o.height() / this.p.height()))) {
                f6 = f5;
            }
            float f7 = f3 * f6;
            this.f.setTextSize(f7);
            Paint paint2 = this.f;
            int n4 = string.length();
            float f8 = rect.height();
            Path path2 = this.q;
            paint2.getTextPath(string, 0, n4, 0.0f, f8, path2);
            this.q.computeBounds(this.p, true);
        }
    }

    private PorterDuffColorFilter I(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    private void t(Rect rect) {
        float f2 = (float)rect.centerX() - this.p.width() / 2.0f - this.p.left;
        float f3 = (float)rect.centerY() - this.p.height() / 2.0f - this.p.top;
        this.q.offset(f2 + (float)this.u, f3 + (float)this.v);
    }

    private void w() {
        Paint paint;
        Paint paint2;
        TextPaint textPaint = new TextPaint(1);
        this.f = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setUnderlineText(false);
        this.f.setAntiAlias(true);
        this.k = new Paint(1);
        this.i = paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.l = paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.q = new Path();
        this.p = new RectF();
        this.o = new Rect();
    }

    public a A(int n2) {
        return this.B(c.i.b.c.a.a(this.a, n2));
    }

    public a B(int n2) {
        this.c = n2;
        this.b = n2;
        this.setBounds(0, 0, n2, n2);
        this.invalidateSelf();
        return this;
    }

    public a C(int n2) {
        this.b = n2;
        this.setBounds(0, 0, n2, this.c);
        this.invalidateSelf();
        return this;
    }

    public a D(int n2) {
        this.c = n2;
        this.setBounds(0, 0, this.b, n2);
        this.invalidateSelf();
        return this;
    }

    public a E(Typeface typeface) {
        this.f.setTypeface(typeface);
        this.invalidateSelf();
        return this;
    }

    public a a(int n2) {
        this.setAlpha(n2);
        return this;
    }

    public a b(int n2) {
        this.k.setColor(n2);
        this.j = n2;
        if (this.m == -1) {
            this.m = 0;
        }
        if (this.n == -1) {
            this.n = 0;
        }
        this.invalidateSelf();
        return this;
    }

    public a c(int n2) {
        return this.b(b.i.h.a.c((Context)this.a, (int)n2));
    }

    public void clearColorFilter() {
        this.I = null;
        this.invalidateSelf();
    }

    public a d(int n2) {
        int n3 = Color.red((int)n2);
        int n4 = Color.green((int)n2);
        int n5 = Color.blue((int)n2);
        this.l.setColor(Color.rgb((int)n3, (int)n4, (int)n5));
        this.l.setAlpha(Color.alpha((int)n2));
        this.g = n2;
        this.invalidateSelf();
        return this;
    }

    /*
     * Exception decompiling
     */
    public void draw(Canvas var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl106.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public a e(int n2) {
        this.t = n2;
        this.l.setStrokeWidth((float)n2);
        this.l(true);
        this.invalidateSelf();
        return this;
    }

    public a f() {
        a a2 = new a(this.a).v(this.r).x(this.m).y(this.n).C(this.b).D(this.c).p(this.u).q(this.v).j(this.h).k(this.s).z(this.z, this.A, this.B, this.C).b(this.j).d(this.g).e(this.t).h(this.e).a(this.w).m(this.x).l(this.y).E(this.f.getTypeface());
        c.i.b.b.a a3 = this.D;
        if (a3 != null) {
            a2.n(a3);
            return a2;
        }
        String string = this.E;
        if (string != null) {
            a2.r(string);
        }
        return a2;
    }

    public a g(int n2) {
        this.e = ColorStateList.valueOf((int)n2);
        this.F();
        return this;
    }

    public int getAlpha() {
        return this.w;
    }

    public int getIntrinsicHeight() {
        return this.c;
    }

    public int getIntrinsicWidth() {
        return this.b;
    }

    public int getOpacity() {
        if (this.H == null) {
            if (this.f.getColorFilter() != null) {
                return -3;
            }
            int n2 = this.getAlpha();
            if (n2 != 0) {
                if (n2 != 255) {
                    return -3;
                }
                return -1;
            }
            return -2;
        }
        return -3;
    }

    public a h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.e = colorStateList;
            this.F();
        }
        return this;
    }

    public a i(int n2) {
        return this.g(b.i.h.a.c((Context)this.a, (int)n2));
    }

    public boolean isStateful() {
        return true;
    }

    public a j(int n2) {
        int n3 = Color.red((int)n2);
        int n4 = Color.green((int)n2);
        int n5 = Color.blue((int)n2);
        this.i.setColor(Color.rgb((int)n3, (int)n4, (int)n5));
        this.i.setAlpha(Color.alpha((int)n2));
        this.h = n2;
        this.invalidateSelf();
        return this;
    }

    public a k(int n2) {
        this.s = n2;
        this.i.setStrokeWidth((float)n2);
        this.m(true);
        this.invalidateSelf();
        return this;
    }

    public a l(boolean bl) {
        if (this.y != bl) {
            this.y = bl;
            int n2 = this.r;
            int n3 = bl ? 1 : -1;
            this.r = n2 + 2 * (n3 * this.t);
            this.invalidateSelf();
        }
        return this;
    }

    public a m(boolean bl) {
        if (this.x != bl) {
            this.x = bl;
            int n2 = this.r;
            int n3 = bl ? 1 : -1;
            this.r = n2 + n3 * this.s;
            this.invalidateSelf();
        }
        return this;
    }

    public a n(c.i.b.b.a a2) {
        this.D = a2;
        this.E = null;
        b b2 = a2.b();
        this.f.setTypeface(b2.getTypeface(this.a));
        this.invalidateSelf();
        return this;
    }

    public a o(Character c2) {
        return this.s(c2.toString(), null);
    }

    protected void onBoundsChange(Rect rect) {
        this.t(rect);
        try {
            this.q.close();
        }
        catch (Exception exception) {}
        super.onBoundsChange(rect);
    }

    protected boolean onStateChange(int[] arrn) {
        PorterDuff.Mode mode;
        boolean bl;
        ColorStateList colorStateList = this.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            this.F();
            bl = true;
        } else {
            bl = false;
        }
        ColorStateList colorStateList2 = this.F;
        if (colorStateList2 != null && (mode = this.G) != null) {
            this.H = this.I(colorStateList2, mode);
            this.invalidateSelf();
            return true;
        }
        return bl;
    }

    public a p(int n2) {
        this.u = n2;
        this.invalidateSelf();
        return this;
    }

    public a q(int n2) {
        this.v = n2;
        this.invalidateSelf();
        return this;
    }

    public a r(String string) {
        return this.s(string, null);
    }

    public a s(String string, Typeface typeface) {
        this.E = string;
        this.D = null;
        Paint paint = this.f;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        paint.setTypeface(typeface);
        this.invalidateSelf();
        return this;
    }

    public void setAlpha(int n2) {
        this.f.setAlpha(n2);
        this.w = n2;
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.I = colorFilter;
        this.invalidateSelf();
    }

    public boolean setState(int[] arrn) {
        ColorStateList colorStateList;
        return super.setState(arrn) || (colorStateList = this.e) != null && colorStateList.isStateful() || this.I != null || this.H != null;
        {
        }
    }

    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.F = colorStateList;
        this.H = this.I(colorStateList, this.G);
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.G = mode;
        this.H = this.I(this.F, mode);
        this.invalidateSelf();
    }

    public a u(int n2) {
        return this.v(c.i.b.c.a.a(this.a, n2));
    }

    public a v(int n2) {
        if (this.r != n2) {
            this.r = n2;
            if (this.x) {
                this.r = n2 + this.s;
            }
            if (this.y) {
                this.r += this.t;
            }
            this.invalidateSelf();
        }
        return this;
    }

    public a x(int n2) {
        this.m = n2;
        this.invalidateSelf();
        return this;
    }

    public a y(int n2) {
        this.n = n2;
        this.invalidateSelf();
        return this;
    }

    public a z(float f2, float f3, float f4, int n2) {
        this.z = f2;
        this.A = f3;
        this.B = f4;
        this.C = n2;
        this.f.setShadowLayer(f2, f3, f4, n2);
        this.invalidateSelf();
        return this;
    }
}

