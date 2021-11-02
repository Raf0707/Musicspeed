/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.util.Log
 *  androidx.core.graphics.drawable.b
 *  c.e.a.a.a0.c
 *  c.e.a.a.a0.g$c
 *  c.e.a.a.a0.k
 *  c.e.a.a.a0.k$c
 *  c.e.a.a.a0.l
 *  c.e.a.a.a0.l$b
 *  c.e.a.a.a0.m
 *  c.e.a.a.a0.m$g
 *  c.e.a.a.a0.n
 *  c.e.a.a.b
 *  c.e.a.a.q.a
 *  c.e.a.a.t.a
 *  c.e.a.a.z.a
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.BitSet
 */
package c.e.a.a.a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import c.e.a.a.a0.g;
import c.e.a.a.a0.i;
import c.e.a.a.a0.k;
import c.e.a.a.a0.l;
import c.e.a.a.a0.m;
import c.e.a.a.a0.n;
import java.util.BitSet;

/*
 * Exception performing whole class analysis.
 */
public class g
extends Drawable
implements androidx.core.graphics.drawable.b,
n {
    private static final String f;
    private static final Paint g;
    private PorterDuffColorFilter A;
    private final RectF B;
    private boolean C;
    private c h;
    private final m.g[] i;
    private final m.g[] j;
    private final BitSet k;
    private boolean l;
    private final Matrix m;
    private final Path n;
    private final Path o;
    private final RectF p;
    private final RectF q;
    private final Region r;
    private final Region s;
    private k t;
    private final Paint u;
    private final Paint v;
    private final c.e.a.a.z.a w;
    private final l.b x;
    private final l y;
    private PorterDuffColorFilter z;

    static {
        f = g.class.getSimpleName();
        g = new Paint(1);
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int n2, int n3) {
        this(k.e((Context)context, (AttributeSet)attributeSet, (int)n2, (int)n3).m());
    }

    private g(c c2) {
        Paint paint;
        Paint paint2;
        this.i = new m.g[4];
        this.j = new m.g[4];
        this.k = new BitSet(8);
        this.m = new Matrix();
        this.n = new Path();
        this.o = new Path();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new Region();
        this.s = new Region();
        this.u = paint = new Paint(1);
        this.v = paint2 = new Paint(1);
        this.w = new c.e.a.a.z.a();
        l l2 = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.y = l2;
        this.B = new RectF();
        this.C = true;
        this.h = c2;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = g;
        paint3.setColor(-1);
        paint3.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.i0();
        this.h0(this.getState());
        this.x = new l.b(){

            public void a(m m2, Matrix matrix, int n2) {
                g.this.k.set(n2, m2.e());
                g.c((g)g.this)[n2] = m2.f(matrix);
            }

            public void b(m m2, Matrix matrix, int n2) {
                g.this.k.set(n2 + 4, m2.e());
                g.d((g)g.this)[n2] = m2.f(matrix);
            }
        };
    }

    /* synthetic */ g(c c2, a a2) {
        this(c2);
    }

    public g(k k2) {
        this(new /* Unavailable Anonymous Inner Class!! */);
    }

    private float D() {
        if (this.L()) {
            return this.v.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean J() {
        c c2 = this.h;
        int n2 = c2.q;
        int n3 = 1;
        if (n2 == n3) return (boolean)0;
        if (c2.r <= 0) return (boolean)0;
        if (n2 == 2) return (boolean)n3;
        if (!this.T()) return (boolean)0;
        return (boolean)n3;
    }

    private boolean K() {
        Paint.Style style = this.h.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
        {
        }
    }

    private boolean L() {
        Paint.Style style = this.h.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.v.getStrokeWidth() > 0.0f;
    }

    private void N() {
        super.invalidateSelf();
    }

    private void Q(Canvas canvas) {
        if (!this.J()) {
            return;
        }
        canvas.save();
        this.S(canvas);
        if (!this.C) {
            this.n(canvas);
            canvas.restore();
            return;
        }
        int n2 = (int)(this.B.width() - (float)this.getBounds().width());
        int n3 = (int)(this.B.height() - (float)this.getBounds().height());
        if (n2 >= 0 && n3 >= 0) {
            Bitmap bitmap = Bitmap.createBitmap((int)(n2 + ((int)this.B.width() + 2 * this.h.r)), (int)(n3 + ((int)this.B.height() + 2 * this.h.r)), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmap);
            float f2 = this.getBounds().left - this.h.r - n2;
            float f3 = this.getBounds().top - this.h.r - n3;
            canvas2.translate(-f2, -f3);
            this.n(canvas2);
            canvas.drawBitmap(bitmap, f2, f3, null);
            bitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int R(int n2, int n3) {
        return n2 * (n3 + (n3 >>> 7)) >>> 8;
    }

    private void S(Canvas canvas) {
        int n2 = this.z();
        int n3 = this.A();
        if (Build.VERSION.SDK_INT < 21 && this.C) {
            Rect rect = canvas.getClipBounds();
            int n4 = this.h.r;
            rect.inset(-n4, -n4);
            rect.offset(n2, n3);
            canvas.clipRect(rect, Region.Op.REPLACE);
        }
        canvas.translate((float)n2, (float)n3);
    }

    static /* synthetic */ m.g[] c(g g2) {
        return g2.i;
    }

    static /* synthetic */ m.g[] d(g g2) {
        return g2.j;
    }

    static /* synthetic */ boolean e(g g2, boolean bl) {
        g2.l = bl;
        return bl;
    }

    private PorterDuffColorFilter f(Paint paint, boolean bl) {
        int n2;
        int n3;
        if (bl && (n3 = this.l(n2 = paint.getColor())) != n2) {
            return new PorterDuffColorFilter(n3, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        this.h(rectF, path);
        if (this.h.j != 1.0f) {
            this.m.reset();
            Matrix matrix = this.m;
            float f2 = this.h.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.m);
        }
        path.computeBounds(this.B, true);
    }

    private boolean h0(int[] arrn) {
        int n2;
        int n3;
        boolean bl;
        int n4;
        int n5;
        if (this.h.d != null && (n3 = this.u.getColor()) != (n4 = this.h.d.getColorForState(arrn, n3))) {
            this.u.setColor(n4);
            bl = true;
        } else {
            bl = false;
        }
        if (this.h.e != null && (n2 = this.v.getColor()) != (n5 = this.h.e.getColorForState(arrn, n2))) {
            this.v.setColor(n5);
            return true;
        }
        return bl;
    }

    private void i() {
        k k2;
        final float f2 = -this.D();
        this.t = k2 = this.C().y(new k.c(){

            public c.e.a.a.a0.c a(c.e.a.a.a0.c c2) {
                if (c2 instanceof i) {
                    return c2;
                }
                return new c.e.a.a.a0.b(f2, c2);
            }
        });
        this.y.d(k2, this.h.k, this.v(), this.o);
    }

    private boolean i0() {
        PorterDuffColorFilter porterDuffColorFilter = this.z;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        c c2 = this.h;
        ColorStateList colorStateList = c2.g;
        PorterDuff.Mode mode = c2.h;
        Paint paint = this.u;
        boolean bl = true;
        this.z = this.k(colorStateList, mode, paint, bl);
        c c3 = this.h;
        this.A = this.k(c3.f, c3.h, this.v, false);
        c c4 = this.h;
        if (c4.u) {
            this.w.d(c4.g.getColorForState(this.getState(), 0));
        }
        if (b.i.p.c.a((Object)porterDuffColorFilter, (Object)this.z)) {
            if (!b.i.p.c.a((Object)porterDuffColorFilter2, (Object)this.A)) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean bl) {
        int n2 = colorStateList.getColorForState(this.getState(), 0);
        if (bl) {
            n2 = this.l(n2);
        }
        return new PorterDuffColorFilter(n2, mode);
    }

    private void j0() {
        float f2 = this.I();
        this.h.r = (int)Math.ceil((double)(0.75f * f2));
        this.h.s = (int)Math.ceil((double)(f2 * 0.25f));
        this.i0();
        this.N();
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean bl) {
        if (colorStateList != null && mode != null) {
            return this.j(colorStateList, mode, bl);
        }
        return this.f(paint, bl);
    }

    public static g m(Context context, float f2) {
        int n2 = c.e.a.a.q.a.b((Context)context, (int)c.e.a.a.b.colorSurface, (String)g.class.getSimpleName());
        g g2 = new g();
        g2.M(context);
        g2.X(ColorStateList.valueOf((int)n2));
        g2.W(f2);
        return g2;
    }

    private void n(Canvas canvas) {
        if (this.k.cardinality() > 0) {
            Log.w((String)f, (String)"Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.h.s != 0) {
            canvas.drawPath(this.n, this.w.c());
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            this.i[i2].b(this.w, this.h.r, canvas);
            this.j[i2].b(this.w, this.h.r, canvas);
        }
        if (this.C) {
            int n2 = this.z();
            int n3 = this.A();
            canvas.translate((float)(-n2), (float)(-n3));
            canvas.drawPath(this.n, g);
            canvas.translate((float)n2, (float)n3);
        }
    }

    private void o(Canvas canvas) {
        this.q(canvas, this.u, this.n, this.h.a, this.u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k k2, RectF rectF) {
        if (k2.u(rectF)) {
            float f2 = k2.t().a(rectF) * this.h.k;
            canvas.drawRoundRect(rectF, f2, f2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void r(Canvas canvas) {
        this.q(canvas, this.v, this.o, this.t, this.v());
    }

    private RectF v() {
        this.q.set(this.u());
        float f2 = this.D();
        this.q.inset(f2, f2);
        return this.q;
    }

    public int A() {
        c c2 = this.h;
        return (int)((double)c2.s * Math.cos((double)Math.toRadians((double)c2.t)));
    }

    public int B() {
        return this.h.r;
    }

    public k C() {
        return this.h.a;
    }

    public ColorStateList E() {
        return this.h.g;
    }

    public float F() {
        return this.h.a.r().a(this.u());
    }

    public float G() {
        return this.h.a.t().a(this.u());
    }

    public float H() {
        return this.h.p;
    }

    public float I() {
        return this.w() + this.H();
    }

    public void M(Context context) {
        this.h.b = new c.e.a.a.t.a(context);
        this.j0();
    }

    public boolean O() {
        c.e.a.a.t.a a2 = this.h.b;
        return a2 != null && a2.d();
    }

    public boolean P() {
        return this.h.a.u(this.u());
    }

    public boolean T() {
        int n2 = Build.VERSION.SDK_INT;
        return n2 < 21 || !this.P() && !this.n.isConvex() && n2 < 29;
        {
        }
    }

    public void U(float f2) {
        this.setShapeAppearanceModel(this.h.a.w(f2));
    }

    public void V(c.e.a.a.a0.c c2) {
        this.setShapeAppearanceModel(this.h.a.x(c2));
    }

    public void W(float f2) {
        c c2 = this.h;
        if (c2.o != f2) {
            c2.o = f2;
            this.j0();
        }
    }

    public void X(ColorStateList colorStateList) {
        c c2 = this.h;
        if (c2.d != colorStateList) {
            c2.d = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public void Y(float f2) {
        c c2 = this.h;
        if (c2.k != f2) {
            c2.k = f2;
            this.l = true;
            this.invalidateSelf();
        }
    }

    public void Z(int n2, int n3, int n4, int n5) {
        c c2 = this.h;
        if (c2.i == null) {
            c2.i = new Rect();
        }
        this.h.i.set(n2, n3, n4, n5);
        this.invalidateSelf();
    }

    public void a0(float f2) {
        c c2 = this.h;
        if (c2.n != f2) {
            c2.n = f2;
            this.j0();
        }
    }

    public void b0(int n2) {
        this.w.d(n2);
        this.h.u = false;
        this.N();
    }

    public void c0(int n2) {
        c c2 = this.h;
        if (c2.t != n2) {
            c2.t = n2;
            this.N();
        }
    }

    public void d0(float f2, int n2) {
        this.g0(f2);
        this.f0(ColorStateList.valueOf((int)n2));
    }

    public void draw(Canvas canvas) {
        this.u.setColorFilter((ColorFilter)this.z);
        int n2 = this.u.getAlpha();
        this.u.setAlpha(g.R(n2, this.h.m));
        this.v.setColorFilter((ColorFilter)this.A);
        this.v.setStrokeWidth(this.h.l);
        int n3 = this.v.getAlpha();
        this.v.setAlpha(g.R(n3, this.h.m));
        if (this.l) {
            this.i();
            this.g(this.u(), this.n);
            this.l = false;
        }
        this.Q(canvas);
        if (this.K()) {
            this.o(canvas);
        }
        if (this.L()) {
            this.r(canvas);
        }
        this.u.setAlpha(n2);
        this.v.setAlpha(n3);
    }

    public void e0(float f2, ColorStateList colorStateList) {
        this.g0(f2);
        this.f0(colorStateList);
    }

    public void f0(ColorStateList colorStateList) {
        c c2 = this.h;
        if (c2.e != colorStateList) {
            c2.e = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public void g0(float f2) {
        this.h.l = f2;
        this.invalidateSelf();
    }

    public Drawable.ConstantState getConstantState() {
        return this.h;
    }

    public int getOpacity() {
        return -3;
    }

    /*
     * Exception decompiling
     */
    @TargetApi(value=21)
    public void getOutline(Outline var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.h.i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    public Region getTransparentRegion() {
        Rect rect = this.getBounds();
        this.r.set(rect);
        this.g(this.u(), this.n);
        this.s.setPath(this.n, this.r);
        this.r.op(this.s, Region.Op.DIFFERENCE);
        return this.r;
    }

    protected final void h(RectF rectF, Path path) {
        l l2 = this.y;
        c c2 = this.h;
        l2.e(c2.a, c2.k, rectF, this.x, path);
    }

    public void invalidateSelf() {
        this.l = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || (colorStateList4 = this.h.g) != null && colorStateList4.isStateful() || (colorStateList3 = this.h.f) != null && colorStateList3.isStateful() || (colorStateList2 = this.h.e) != null && colorStateList2.isStateful() || (colorStateList = this.h.d) != null && colorStateList.isStateful();
        {
        }
    }

    protected int l(int n2) {
        float f2 = this.I() + this.y();
        c.e.a.a.t.a a2 = this.h.b;
        if (a2 != null) {
            n2 = a2.c(n2, f2);
        }
        return n2;
    }

    public Drawable mutate() {
        this.h = new /* Unavailable Anonymous Inner Class!! */;
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.l = true;
        super.onBoundsChange(rect);
    }

    protected boolean onStateChange(int[] arrn) {
        boolean bl = this.h0(arrn);
        boolean bl2 = this.i0();
        boolean bl3 = bl || bl2;
        if (bl3) {
            this.invalidateSelf();
        }
        return bl3;
    }

    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        this.q(canvas, paint, path, this.h.a, rectF);
    }

    public float s() {
        return this.h.a.j().a(this.u());
    }

    public void setAlpha(int n2) {
        c c2 = this.h;
        if (c2.m != n2) {
            c2.m = n2;
            this.N();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.h.c = colorFilter;
        this.N();
    }

    public void setShapeAppearanceModel(k k2) {
        this.h.a = k2;
        this.invalidateSelf();
    }

    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.h.g = colorStateList;
        this.i0();
        this.N();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c c2 = this.h;
        if (c2.h != mode) {
            c2.h = mode;
            this.i0();
            this.N();
        }
    }

    public float t() {
        return this.h.a.l().a(this.u());
    }

    protected RectF u() {
        this.p.set(this.getBounds());
        return this.p;
    }

    public float w() {
        return this.h.o;
    }

    public ColorStateList x() {
        return this.h.d;
    }

    public float y() {
        return this.h.n;
    }

    public int z() {
        c c2 = this.h;
        return (int)((double)c2.s * Math.sin((double)Math.toRadians((double)c2.t)));
    }

}

