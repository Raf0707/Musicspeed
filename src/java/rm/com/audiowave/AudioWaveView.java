/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.animation.LinearInterpolator
 *  android.view.animation.OvershootInterpolator
 *  f.a0.a
 *  f.g
 *  f.u.l
 *  f.z.c.a
 *  f.z.c.l
 *  f.z.c.p
 *  java.lang.Boolean
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 *  rm.com.audiowave.AudioWaveView$a$a
 *  rm.com.audiowave.AudioWaveView$a$b
 *  rm.com.audiowave.AudioWaveView$a$c
 *  rm.com.audiowave.AudioWaveView$b
 *  rm.com.audiowave.AudioWaveView$c
 *  rm.com.audiowave.g
 *  rm.com.audiowave.h
 *  rm.com.audiowave.i
 */
package rm.com.audiowave;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import f.f;
import f.t;
import f.z.c.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import rm.com.audiowave.AudioWaveView;
import rm.com.audiowave.d;
import rm.com.audiowave.g;
import rm.com.audiowave.h;
import rm.com.audiowave.i;
import rm.com.audiowave.j;
import rm.com.audiowave.k;
import rm.com.audiowave.l;
import rm.com.audiowave.m;
import rm.com.audiowave.n;

public final class AudioWaveView
extends View {
    private final ValueAnimator A;
    private Paint B;
    private Paint C;
    private Paint D;
    private Paint E;
    private Paint F;
    private Paint G;
    private Bitmap H;
    private final ValueAnimator I;
    private final ValueAnimator J;
    private int K;
    private int L;
    private final float M;
    private final float N;
    private final float O;
    private final float P;
    private final float Q;
    private final int R;
    private k f;
    private p<? super Float, ? super Boolean, t> g = g.g;
    private f.z.c.l<? super Float, t> h = h.g;
    private f.z.c.l<? super Float, t> i = i.g;
    private int j;
    private float k = 1.0f;
    private int l = j.a(this, 2);
    private int m = j.a(this, 1);
    private int n;
    private int o = j.a(this, 2);
    private int p = -16777216;
    private int q = -16777216;
    private int r = -16777216;
    private int s = -16777216;
    private float t;
    private final List<a> u = new ArrayList();
    private byte[] v = new byte[0];
    private long w = 400L;
    private boolean x = true;
    private boolean y;
    private final long z = 50L;

    public AudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator.setDuration(this.getExpansionDuration());
        valueAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator());
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new rm.com.audiowave.b(this));
        this.A = valueAnimator;
        this.B = j.i(j.j(this.p, 170));
        this.C = j.c(this.p);
        this.D = j.c(j.j(this.p, 170));
        this.E = j.c(this.p);
        this.F = j.c(j.j(this.p, 170));
        this.G = j.c(this.p);
        ValueAnimator valueAnimator2 = ValueAnimator.ofInt((int[])new int[]{170, 34});
        valueAnimator2.setDuration(200L);
        valueAnimator2.setInterpolator((TimeInterpolator)new LinearInterpolator());
        valueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new rm.com.audiowave.a(this));
        this.I = valueAnimator2;
        ValueAnimator valueAnimator3 = ValueAnimator.ofInt((int[])new int[]{255, 34});
        valueAnimator3.setDuration(200L);
        valueAnimator3.setInterpolator((TimeInterpolator)new LinearInterpolator());
        valueAnimator3.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new d(this));
        this.J = valueAnimator3;
        this.M = j.a(this, 24);
        this.N = j.a(this, 4);
        this.O = j.a(this, 4);
        float f2 = 16;
        this.P = f2 * this.getResources().getDisplayMetrics().density;
        this.Q = f2 * this.getResources().getDisplayMetrics().density;
        this.R = j.a(this, 4);
        this.setWillNotDraw(false);
        this.u(attributeSet);
    }

    public static /* synthetic */ void A(AudioWaveView audioWaveView, ValueAnimator valueAnimator) {
        AudioWaveView.q(audioWaveView, valueAnimator);
    }

    private final int B(a a2) {
        int n2;
        int n3 = f.a0.a.b((float)((float)this.getWidth() * a2.e()));
        if (n3 < (n2 = this.R) / 2) {
            return n2 / 2;
        }
        if (n3 + n2 / 2 > this.getWidth()) {
            n3 = this.getWidth() - this.R / 2;
        }
        return n3;
    }

    private final void C() {
        List list = f.u.l.M(this.u);
        this.u.clear();
        List<a> list2 = this.u;
        ArrayList arrayList = new ArrayList(f.u.l.j((Iterable)list, (int)10));
        for (a a2 : list) {
            a a3 = new a(a2.d(), a2.e(), a2.g(), a2.h());
            arrayList.add((Object)a3);
        }
        list2.addAll((Collection)arrayList);
    }

    private final void D(Canvas canvas, float f2) {
        Bitmap bitmap = this.H;
        if (bitmap != null) {
            if (canvas == null) {
                return;
            }
            j.e(bitmap);
            byte[] arrby = this.v;
            int n2 = arrby.length;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                byte by = arrby[i2];
                int n4 = n3 + 1;
                int n5 = (int)(f2 * (float)(Math.max((int)((int)((float)n.a(by) / (float)127 * (float)this.getChunkHeight())), (int)this.getMinChunkHeight()) - this.getMinChunkHeight()));
                canvas.drawRoundRect(j.g(this.getChunkSpacing() / 2 + n3 * this.getChunkStep(), this.getCenterY() - this.getMinChunkHeight() - n5, this.getChunkSpacing() / 2 + n3 * this.getChunkStep() + this.getChunkWidth(), n5 + (this.getCenterY() + this.getMinChunkHeight())), (float)this.getChunkRadius(), (float)this.getChunkRadius(), this.B);
                n3 = n4;
            }
            for (a a2 : this.u) {
                int n6 = this.B(a2);
                int n7 = this.R / 2;
                Paint paint = !a2.g() && !a2.h() ? this.C : this.G;
                canvas.drawRoundRect(j.g(n6 - n7, this.getCenterY() - this.getMarkerHeight(), n6 + n7, this.getCenterY() + this.getMarkerHeight()), (float)this.getChunkRadius(), (float)this.getChunkRadius(), paint);
                String string2 = a2.g() ? "A" : (a2.h() ? "B" : a2.d());
                Paint paint2 = !a2.g() && !a2.h() ? this.getTextPaintMarker() : this.getTextPaintAB();
                Paint paint3 = !a2.g() && !a2.h() ? this.getMarkerRectPaint() : this.getMarkerAccentRectPaint();
                float f3 = this.s(a2);
                float f4 = this.getCenterY();
                float f5 = paint2.descent() + paint2.ascent();
                float f6 = 2;
                canvas.drawText(string2, f3, f4 - f5 / f6, paint2);
                float f7 = f3 - this.M / f6;
                float f8 = this.getCenterY();
                float f9 = this.M;
                canvas.drawRoundRect(new RectF(f7, f8 - f9 / f6, f3 + f9 / f6, (float)this.getCenterY() + this.M / f6), this.N, this.O, paint3);
            }
            this.postInvalidate();
        }
    }

    static /* synthetic */ void E(AudioWaveView audioWaveView, Canvas object, float f2, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            Bitmap bitmap = audioWaveView.H;
            object = bitmap == null ? null : j.f(bitmap);
        }
        if ((n2 & 2) != 0) {
            f2 = 1.0f;
        }
        audioWaveView.D((Canvas)object, f2);
    }

    public static /* synthetic */ void G(AudioWaveView audioWaveView, byte[] arrby, f.z.c.a a2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            a2 = b.g;
        }
        audioWaveView.F(arrby, (f.z.c.a<t>)a2);
    }

    private static final void H(byte[] arrby, AudioWaveView audioWaveView, f.z.c.a a2) {
        f.z.d.k.g(arrby, "$raw");
        f.z.d.k.g((Object)audioWaveView, "this$0");
        f.z.d.k.g((Object)a2, "$callback");
        m.a.b(arrby, audioWaveView.getChunksCount(), (f.z.c.l<? super byte[], t>)new c(audioWaveView, a2));
    }

    public static final /* synthetic */ void a(AudioWaveView audioWaveView) {
        audioWaveView.r();
    }

    public static final /* synthetic */ int b(AudioWaveView audioWaveView, a a2) {
        return audioWaveView.s(a2);
    }

    public static final /* synthetic */ int c(AudioWaveView audioWaveView) {
        return audioWaveView.getCenterY();
    }

    public static final /* synthetic */ int d(AudioWaveView audioWaveView) {
        return audioWaveView.L;
    }

    public static final /* synthetic */ float e(AudioWaveView audioWaveView) {
        return audioWaveView.N;
    }

    public static final /* synthetic */ float f(AudioWaveView audioWaveView) {
        return audioWaveView.O;
    }

    public static final /* synthetic */ float g(AudioWaveView audioWaveView) {
        return audioWaveView.M;
    }

    private final int getCenterY() {
        return this.L / 2;
    }

    private final int getChunkStep() {
        return this.l + this.m;
    }

    private final Paint getMarkerAccentRectPaint() {
        return j.c(this.q);
    }

    private final int getMarkerHeight() {
        return f.a0.a.a((double)(0.85 * (0.5 * (double)this.getHeight())));
    }

    private final Paint getMarkerRectPaint() {
        return j.c(this.p);
    }

    private final float getProgressFactor() {
        return this.t / 100.0f;
    }

    private final Paint getTextPaintAB() {
        Paint paint = j.c(this.r);
        paint.setTextSize(this.P);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.create((Typeface)Typeface.DEFAULT, (int)1));
        return paint;
    }

    private final Paint getTextPaintMarker() {
        Paint paint = j.c(this.s);
        paint.setTextSize(this.Q);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.create((Typeface)Typeface.DEFAULT, (int)1));
        return paint;
    }

    public static final /* synthetic */ float h(AudioWaveView audioWaveView) {
        return audioWaveView.getProgressFactor();
    }

    public static final /* synthetic */ Paint i(AudioWaveView audioWaveView) {
        return audioWaveView.getTextPaintAB();
    }

    public static final /* synthetic */ Paint j(AudioWaveView audioWaveView) {
        return audioWaveView.getTextPaintMarker();
    }

    public static final /* synthetic */ int k(AudioWaveView audioWaveView) {
        return audioWaveView.K;
    }

    public static final /* synthetic */ Paint l(AudioWaveView audioWaveView) {
        return audioWaveView.C;
    }

    public static final /* synthetic */ Paint m(AudioWaveView audioWaveView) {
        return audioWaveView.E;
    }

    public static final /* synthetic */ Paint n(AudioWaveView audioWaveView) {
        return audioWaveView.D;
    }

    public static final /* synthetic */ Paint o(AudioWaveView audioWaveView) {
        return audioWaveView.B;
    }

    private static final void p(AudioWaveView audioWaveView, ValueAnimator valueAnimator) {
        f.z.d.k.g((Object)audioWaveView, "this$0");
        Paint paint = audioWaveView.D;
        Object object = valueAnimator.getAnimatedValue();
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Int");
        paint.setAlpha(((Integer)object).intValue());
        audioWaveView.invalidate();
    }

    private static final void q(AudioWaveView audioWaveView, ValueAnimator valueAnimator) {
        f.z.d.k.g((Object)audioWaveView, "this$0");
        Paint paint = audioWaveView.E;
        Object object = valueAnimator.getAnimatedValue();
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Int");
        paint.setAlpha(((Integer)object).intValue());
        audioWaveView.invalidate();
    }

    private final void r() {
        this.A.start();
    }

    private final int s(a a2) {
        float f2;
        float f3;
        int n2 = this.B(a2);
        float f4 = n2;
        if (f4 < (f2 = this.M) / (f3 = (float)2)) {
            return n2 + (int)f2 / 2;
        }
        if (f4 + f2 / f3 > (float)this.getWidth()) {
            n2 = this.getWidth() - (int)this.M / 2 - (this.getWidth() - n2);
        }
        return n2;
    }

    private static final void t(AudioWaveView audioWaveView, ValueAnimator valueAnimator) {
        f.z.d.k.g((Object)audioWaveView, "this$0");
        AudioWaveView.E(audioWaveView, null, valueAnimator.getAnimatedFraction(), 1, null);
    }

    private final void u(AttributeSet attributeSet) {
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(attributeSet, l.a, 0, 0);
        if (typedArray == null) {
            return;
        }
        this.setChunkHeight(typedArray.getDimensionPixelSize(l.e, this.getChunkHeight()));
        this.setChunkHeightPercentage(typedArray.getFloat(l.f, this.getChunkHeightPercentage()));
        this.setChunkWidth(typedArray.getDimensionPixelSize(l.i, this.getChunkWidth()));
        this.setChunkSpacing(typedArray.getDimensionPixelSize(l.h, this.getChunkSpacing()));
        this.setMinChunkHeight(typedArray.getDimensionPixelSize(l.j, this.getMinChunkHeight()));
        this.setChunkRadius(typedArray.getDimensionPixelSize(l.g, this.getChunkRadius()));
        this.setWaveColor(typedArray.getColor(l.m, this.getWaveColor()));
        this.setAccentColor(typedArray.getColor(l.b, this.getAccentColor()));
        this.setAccentTextColor(typedArray.getColor(l.c, this.getAccentTextColor()));
        this.setNormalTextColor(typedArray.getColor(l.k, this.getNormalTextColor()));
        this.setProgress(typedArray.getFloat(l.l, this.getProgress()));
        this.setExpansionAnimated(typedArray.getBoolean(l.d, this.v()));
        typedArray.recycle();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean w() {
        List<a> list = this.u;
        if (list instanceof Collection && list.isEmpty()) {
            return false;
        }
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!((a)iterator.next()).g());
        boolean bl = true;
        if (!bl) return false;
        List<a> list2 = this.u;
        if (list2 instanceof Collection && list2.isEmpty()) {
            return false;
        }
        Iterator iterator2 = list2.iterator();
        do {
            if (!iterator2.hasNext()) return false;
        } while (!((a)iterator2.next()).h());
        return true;
    }

    public static /* synthetic */ void x(AudioWaveView audioWaveView, ValueAnimator valueAnimator) {
        AudioWaveView.p(audioWaveView, valueAnimator);
    }

    public static /* synthetic */ void y(AudioWaveView audioWaveView, ValueAnimator valueAnimator) {
        AudioWaveView.t(audioWaveView, valueAnimator);
    }

    public static /* synthetic */ void z(byte[] arrby, AudioWaveView audioWaveView, f.z.c.a a2) {
        AudioWaveView.H(arrby, audioWaveView, a2);
    }

    public final void F(byte[] arrby, f.z.c.a<t> a2) {
        f.z.d.k.g(arrby, "raw");
        f.z.d.k.g(a2, "callback");
        n.b().postDelayed((Runnable)new rm.com.audiowave.c(arrby, this, a2), this.z);
    }

    public final a getA() {
        Object object2;
        block1 : {
            for (Object object2 : this.u) {
                if (!((a)object2).g()) continue;
                break block1;
            }
            object2 = null;
        }
        return (a)object2;
    }

    public final int getAccentColor() {
        return this.q;
    }

    public final int getAccentTextColor() {
        return this.r;
    }

    public final a getB() {
        Object object2;
        block1 : {
            for (Object object2 : this.u) {
                if (!((a)object2).h()) continue;
                break block1;
            }
            object2 = null;
        }
        return (a)object2;
    }

    public final int getChunkHeight() {
        int n2 = this.j;
        if (n2 == 0) {
            return this.L;
        }
        return Math.abs((int)n2);
    }

    public final float getChunkHeightPercentage() {
        return this.k;
    }

    public final int getChunkRadius() {
        return this.n;
    }

    public final int getChunkSpacing() {
        return this.m;
    }

    public final int getChunkWidth() {
        return this.l;
    }

    public final int getChunksCount() {
        return this.K / this.getChunkStep();
    }

    public final long getExpansionDuration() {
        return this.w;
    }

    public final int getMinChunkHeight() {
        return this.o;
    }

    public final int getNormalTextColor() {
        return this.s;
    }

    public final p<Float, Boolean, t> getOnProgressChanged() {
        return this.g;
    }

    public final k getOnProgressListener() {
        return this.f;
    }

    public final f.z.c.l<Float, t> getOnStartTracking() {
        return this.h;
    }

    public final f.z.c.l<Float, t> getOnStopTracking() {
        return this.i;
    }

    public final float getProgress() {
        return this.t;
    }

    public final byte[] getScaledData() {
        return this.v;
    }

    public final int getWaveColor() {
        return this.p;
    }

    /*
     * Exception decompiling
     */
    protected void onDraw(Canvas var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl313.1 : RETURN : trying to set 1 previously set to 0
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

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6;
        int n7;
        this.K = n6 = n4 - n2;
        this.L = n7 = n5 - n3;
        if (j.d(this.H, n6, n7)) {
            return;
        }
        if (this.K > 0) {
            if (this.L <= 0) {
                return;
            }
            if (bl) {
                j.h(this.H);
                this.H = Bitmap.createBitmap((int)this.K, (int)this.L, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                byte[] arrby = this.v;
                if (arrby.length == 0) {
                    arrby = new byte[]{};
                }
                this.setScaledData(arrby);
                this.setChunkHeight((int)((float)(this.L / 2) * this.k));
            }
        }
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.C();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void setAccentColor(int n2) {
        this.q = n2;
        this.F = j.c(j.j(n2, 170));
        this.G = j.c(n2);
        this.postInvalidate();
    }

    public final void setAccentTextColor(int n2) {
        this.r = n2;
        this.postInvalidate();
    }

    public final void setChunkHeight(int n2) {
        this.j = n2;
        AudioWaveView.E(this, null, 0.0f, 3, null);
    }

    public final void setChunkHeightPercentage(float f2) {
        this.k = f2;
    }

    public final void setChunkRadius(int n2) {
        this.n = Math.abs((int)n2);
        AudioWaveView.E(this, null, 0.0f, 3, null);
    }

    public final void setChunkSpacing(int n2) {
        this.m = Math.abs((int)n2);
        AudioWaveView.E(this, null, 0.0f, 3, null);
    }

    public final void setChunkWidth(int n2) {
        this.l = Math.abs((int)n2);
        AudioWaveView.E(this, null, 0.0f, 3, null);
    }

    public final void setExpansionAnimated(boolean bl) {
        this.x = bl;
    }

    public final void setExpansionDuration(long l2) {
        long l3;
        this.w = l3 = Math.max((long)400L, (long)l2);
        this.A.setDuration(l3);
    }

    public final void setMarkers(List<a> list) {
        f.z.d.k.g(list, "markers");
        boolean bl = this.w();
        List<a> list2 = this.u;
        if (!f.z.d.k.c(list, list2)) {
            list2.clear();
            list2.addAll(list);
            AudioWaveView.E(this, null, 0.0f, 3, null);
            if (!bl && this.w()) {
                this.I.start();
                this.J.start();
            }
        }
    }

    public final void setMinChunkHeight(int n2) {
        this.o = Math.abs((int)n2);
        AudioWaveView.E(this, null, 0.0f, 3, null);
    }

    public final void setNormalTextColor(int n2) {
        this.s = n2;
        this.postInvalidate();
    }

    public final void setOnProgressChanged(p<? super Float, ? super Boolean, t> p2) {
        f.z.d.k.g(p2, "<set-?>");
        this.g = p2;
    }

    public final void setOnProgressListener(k k2) {
        this.f = k2;
    }

    public final void setOnStartTracking(f.z.c.l<? super Float, t> l2) {
        f.z.d.k.g(l2, "<set-?>");
        this.h = l2;
    }

    public final void setOnStopTracking(f.z.c.l<? super Float, t> l2) {
        f.z.d.k.g(l2, "<set-?>");
        this.i = l2;
    }

    public final void setProgress(float f2) {
        float f3 = 0.0f FCMPG f2;
        boolean bl = false;
        if (f3 <= 0) {
            float f4 = f2 FCMPG 100.0f;
            bl = false;
            if (f4 <= 0) {
                bl = true;
            }
        }
        if (bl) {
            float f5;
            this.t = f5 = Math.abs((float)f2);
            k k2 = this.f;
            if (k2 != null) {
                k2.a(f5, this.y);
            }
            this.g.i((Object)Float.valueOf((float)this.t), (Object)this.y);
            this.postInvalidate();
            return;
        }
        throw new IllegalArgumentException("Progress must be in 0..100".toString());
    }

    public final void setRawData(byte[] arrby) {
        f.z.d.k.g(arrby, "raw");
        AudioWaveView.G(this, arrby, null, 2, null);
    }

    public final void setScaledData(byte[] arrby) {
        f.z.d.k.g(arrby, "value");
        if (arrby.length <= this.getChunksCount()) {
            arrby = n.d(new byte[this.getChunksCount()], arrby);
        }
        this.v = arrby;
        AudioWaveView.E(this, null, 0.0f, 3, null);
    }

    public final void setTouched(boolean bl) {
        this.y = bl;
    }

    public final void setWaveColor(int n2) {
        this.p = n2;
        this.B = j.c(j.j(n2, 170));
        this.C = j.c(n2);
        Paint paint = j.c(n2);
        paint.setAlpha(170);
        this.D = paint;
        this.E = j.c(n2);
        this.postInvalidate();
    }

    public final boolean v() {
        return this.x;
    }

    public final class rm.com.audiowave.AudioWaveView$a {
        private final String a;
        private final float b;
        private final boolean c;
        private final boolean d;
        private final f e;
        private final f f;
        private final f g;

        public rm.com.audiowave.AudioWaveView$a(String string2, float f2, boolean bl, boolean bl2) {
            f.z.d.k.g((Object)AudioWaveView.this, "this$0");
            f.z.d.k.g(string2, "number");
            this.a = string2;
            this.b = f2;
            this.c = bl;
            this.d = bl2;
            this.e = f.g.a((f.z.c.a)new b(AudioWaveView.this, this));
            this.f = f.g.a((f.z.c.a)new c(this, AudioWaveView.this));
            this.g = f.g.a((f.z.c.a)new a(this, AudioWaveView.this));
        }

        public static final /* synthetic */ int a(rm.com.audiowave.AudioWaveView$a a2) {
            return a2.c();
        }

        private final int c() {
            return ((Number)this.e.getValue()).intValue();
        }

        public final Path b() {
            return (Path)this.g.getValue();
        }

        public final String d() {
            return this.a;
        }

        public final float e() {
            return this.b;
        }

        public boolean equals(Object object) {
            boolean bl = false;
            if (object != null) {
                boolean bl2 = object instanceof rm.com.audiowave.AudioWaveView$a;
                bl = false;
                if (bl2) {
                    float f2 = this.b;
                    rm.com.audiowave.AudioWaveView$a a2 = (rm.com.audiowave.AudioWaveView$a)object;
                    boolean bl3 = f2 == a2.b;
                    bl = false;
                    if (bl3) {
                        boolean bl4 = this.c;
                        boolean bl5 = a2.c;
                        bl = false;
                        if (bl4 == bl5) {
                            boolean bl6 = this.d;
                            boolean bl7 = a2.d;
                            bl = false;
                            if (bl6 == bl7) {
                                bl = true;
                            }
                        }
                    }
                }
            }
            return bl;
        }

        public final Path f() {
            return (Path)this.f.getValue();
        }

        public final boolean g() {
            return this.c;
        }

        public final boolean h() {
            return this.d;
        }
    }

}

