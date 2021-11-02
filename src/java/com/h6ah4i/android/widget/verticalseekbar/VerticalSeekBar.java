/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.SeekBar
 *  androidx.appcompat.widget.AppCompatSeekBar
 *  b.i.q.w
 *  java.lang.IllegalArgumentException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 */
package com.h6ah4i.android.widget.verticalseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import b.i.q.w;
import com.h6ah4i.android.widget.verticalseekbar.VerticalSeekBarWrapper;
import com.h6ah4i.android.widget.verticalseekbar.a;
import java.lang.reflect.Method;

public class VerticalSeekBar
extends AppCompatSeekBar {
    private boolean g;
    private Drawable h;
    private Method i;
    private int j = 90;

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b(context, attributeSet, 0, 0);
    }

    private void a(boolean bl) {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(bl);
        }
    }

    private void b(Context context, AttributeSet attributeSet, int n2, int n3) {
        w.E0((View)this, (int)0);
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, a.A, n2, n3);
            int n4 = typedArray.getInteger(a.B, 0);
            if (VerticalSeekBar.c(n4)) {
                this.j = n4;
            }
            typedArray.recycle();
        }
    }

    private static boolean c(int n2) {
        return n2 == 90 || n2 == 270;
        {
        }
    }

    private void d() {
        this.g = true;
    }

    private void e() {
        this.g = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean f(MotionEvent motionEvent) {
        if (!this.isEnabled()) {
            return false;
        }
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return true;
                    }
                    if (this.g) {
                        this.e();
                        this.setPressed(false);
                    }
                    this.invalidate();
                    return true;
                }
                if (!this.g) return true;
                this.i(motionEvent);
                return true;
            }
            if (this.g) {
                this.i(motionEvent);
                this.e();
                this.setPressed(false);
            } else {
                this.d();
                this.i(motionEvent);
                this.e();
                this.a(false);
            }
            this.invalidate();
            return true;
        }
        this.setPressed(true);
        this.d();
        this.i(motionEvent);
        this.a(true);
        this.invalidate();
        return true;
    }

    private boolean g(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 == 1) {
                this.a(false);
            }
        } else {
            this.a(true);
        }
        return SeekBar.super.onTouchEvent(motionEvent);
    }

    private VerticalSeekBarWrapper getWrapper() {
        ViewParent viewParent = this.getParent();
        if (viewParent instanceof VerticalSeekBarWrapper) {
            return (VerticalSeekBarWrapper)viewParent;
        }
        return null;
    }

    private void h() {
        this.onSizeChanged(SeekBar.super.getWidth(), SeekBar.super.getHeight(), 0, 0);
    }

    private void i(MotionEvent motionEvent) {
        int n2 = SeekBar.super.getPaddingLeft();
        int n3 = SeekBar.super.getPaddingRight();
        int n4 = this.getHeight() - n2;
        int n5 = n4 - n3;
        int n6 = (int)motionEvent.getY();
        int n7 = this.j;
        float f2 = n7 != 90 ? (n7 != 270 ? 0.0f : (float)(n4 - n6)) : (float)(n6 - n2);
        float f3 = f2 FCMPG 0.0f;
        float f4 = 0.0f;
        if (f3 >= 0) {
            float f5;
            f4 = n5 == 0 ? 0.0f : (f2 > (f5 = (float)n5) ? 1.0f : f2 / f5);
        }
        this.setProgress((int)(f4 * (float)this.getMax()), true);
    }

    /*
     * Exception decompiling
     */
    private void setProgress(int var1, boolean var2) {
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

    public int getRotationAngle() {
        return this.j;
    }

    boolean j() {
        boolean bl = Build.VERSION.SDK_INT >= 11;
        boolean bl2 = this.isInEditMode();
        return bl && !bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onDraw(Canvas canvas) {
        VerticalSeekBar verticalSeekBar = this;
        synchronized (verticalSeekBar) {
            if (!this.j()) {
                int n2 = this.j;
                if (n2 != 90) {
                    if (n2 == 270) {
                        canvas.rotate(-90.0f);
                        canvas.translate((float)(-SeekBar.super.getHeight()), 0.0f);
                    }
                } else {
                    canvas.rotate(90.0f);
                    canvas.translate(0.0f, (float)(-SeekBar.super.getWidth()));
                }
            }
            super.onDraw(canvas);
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onKeyDown(int var1_1, KeyEvent var2_2) {
        block6 : {
            if (this.isEnabled() == false) return SeekBar.super.onKeyDown(var1_1, var2_2);
            var3_3 = -1;
            switch (var1_1) {
                default: {
                    var3_3 = 0;
                    var4_4 = false;
                    ** break;
                }
                case 21: 
                case 22: {
                    var3_3 = 0;
                    break block6;
                }
                case 20: {
                    if (this.j == 90) {
                        break;
                    }
                    break block6;
                }
                case 19: {
                    if (this.j != 270) break block6;
                }
            }
            var3_3 = 1;
        }
        var4_4 = true;
        ** break;
lbl21: // 2 sources:
        if (var4_4 == false) return SeekBar.super.onKeyDown(var1_1, var2_2);
        var5_5 = this.getKeyProgressIncrement();
        var6_6 = this.getProgress() + var3_3 * var5_5;
        if (var6_6 < 0) return true;
        if (var6_6 > this.getMax()) return true;
        this.setProgress(var6_6 - var5_5, true);
        return true;
    }

    protected void onMeasure(int n2, int n3) {
        VerticalSeekBar verticalSeekBar = this;
        synchronized (verticalSeekBar) {
            if (this.j()) {
                SeekBar.super.onMeasure(n2, n3);
            } else {
                SeekBar.super.onMeasure(n3, n2);
                ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
                if (this.isInEditMode() && layoutParams != null && layoutParams.height >= 0) {
                    this.setMeasuredDimension(SeekBar.super.getMeasuredHeight(), layoutParams.height);
                } else {
                    this.setMeasuredDimension(SeekBar.super.getMeasuredHeight(), SeekBar.super.getMeasuredWidth());
                }
            }
            return;
        }
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        if (this.j()) {
            SeekBar.super.onSizeChanged(n2, n3, n4, n5);
            return;
        }
        SeekBar.super.onSizeChanged(n3, n2, n5, n4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j()) {
            return this.g(motionEvent);
        }
        return this.f(motionEvent);
    }

    public void setProgress(int n2) {
        VerticalSeekBar verticalSeekBar = this;
        synchronized (verticalSeekBar) {
            SeekBar.super.setProgress(n2);
            if (!this.j()) {
                this.h();
            }
            return;
        }
    }

    public void setRotationAngle(int n2) {
        if (VerticalSeekBar.c(n2)) {
            if (this.j == n2) {
                return;
            }
            this.j = n2;
            if (this.j()) {
                VerticalSeekBarWrapper verticalSeekBarWrapper = this.getWrapper();
                if (verticalSeekBarWrapper != null) {
                    verticalSeekBarWrapper.a();
                    return;
                }
            } else {
                this.requestLayout();
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid angle specified :");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setThumb(Drawable drawable) {
        this.h = drawable;
        SeekBar.super.setThumb(drawable);
    }
}

