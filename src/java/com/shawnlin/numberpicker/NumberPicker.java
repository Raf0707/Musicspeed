/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  b.i.h.a
 *  com.shawnlin.numberpicker.NumberPicker$a
 *  com.shawnlin.numberpicker.NumberPicker$g
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.NumberFormat
 */
package com.shawnlin.numberpicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.shawnlin.numberpicker.NumberPicker;
import java.text.NumberFormat;

/*
 * Exception performing whole class analysis.
 */
public class NumberPicker
extends LinearLayout {
    private static final g f;
    private static final char[] g;
    private Typeface A;
    private float A0;
    private int B;
    private int B0;
    private int C;
    private int C0;
    private String[] D;
    private boolean D0;
    private int E;
    private float E0;
    private int F;
    private boolean F0;
    private int G;
    private float G0;
    private View.OnClickListener H;
    private int H0;
    private e I;
    private boolean I0;
    private d J;
    private Context J0;
    private c K;
    private NumberFormat K0;
    private long L;
    private ViewConfiguration L0;
    private final SparseArray<String> M;
    private int N;
    private int O;
    private int P;
    private int[] Q;
    private final Paint R;
    private int S;
    private int T;
    private int U;
    private final com.shawnlin.numberpicker.d V;
    private final com.shawnlin.numberpicker.d W;
    private int a0;
    private int b0;
    private f c0;
    private b d0;
    private float e0;
    private float f0;
    private float g0;
    private final EditText h;
    private float h0;
    private float i;
    private VelocityTracker i0;
    private float j;
    private int j0;
    private int k;
    private int k0;
    private int l;
    private int l0;
    private int m;
    private boolean m0;
    private int n;
    private boolean n0;
    private final boolean o;
    private Drawable o0;
    private int p;
    private int p0;
    private int q;
    private int q0;
    private float r;
    private int r0;
    private boolean s;
    private int s0;
    private boolean t;
    private int t0;
    private Typeface u;
    private int u0;
    private int v;
    private int v0;
    private int w;
    private int w0;
    private float x;
    private int x0;
    private boolean y;
    private boolean y0;
    private boolean z;
    private float z0;

    static {
        f = new /* Unavailable Anonymous Inner Class!! */;
        g = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '\u0660', '\u0661', '\u0662', '\u0663', '\u0664', '\u0665', '\u0666', '\u0667', '\u0668', '\u0669', '\u06f0', '\u06f1', '\u06f2', '\u06f3', '\u06f4', '\u06f5', '\u06f6', '\u06f7', '\u06f8', '\u06f9', '\u0966', '\u0967', '\u0968', '\u0969', '\u096a', '\u096b', '\u096c', '\u096d', '\u096e', '\u096f', '\u09e6', '\u09e7', '\u09e8', '\u09e9', '\u09ea', '\u09eb', '\u09ec', '\u09ed', '\u09ee', '\u09ef', '\u0ce6', '\u0ce7', '\u0ce8', '\u0ce9', '\u0cea', '\u0ceb', '\u0cec', '\u0ced', '\u0cee', '\u0cef', '-'};
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int n2) {
        EditText editText;
        boolean bl;
        ViewConfiguration viewConfiguration;
        super(context, attributeSet);
        this.p = 1;
        this.q = -16777216;
        this.r = 25.0f;
        this.v = 1;
        this.w = -16777216;
        this.x = 25.0f;
        this.E = 1;
        this.F = 100;
        this.L = 300L;
        this.M = new SparseArray();
        this.N = 3;
        this.O = 3;
        this.P = 3 / 2;
        this.Q = new int[3];
        this.T = Integer.MIN_VALUE;
        this.n0 = true;
        this.p0 = -16777216;
        this.w0 = 0;
        this.x0 = -1;
        this.D0 = true;
        this.E0 = 0.9f;
        this.F0 = true;
        this.G0 = 1.0f;
        this.H0 = 8;
        this.I0 = true;
        this.J0 = context;
        this.K0 = NumberFormat.getInstance();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, com.shawnlin.numberpicker.c.D, n2, 0);
        Drawable drawable = typedArray.getDrawable(com.shawnlin.numberpicker.c.F);
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
            if (drawable.isStateful()) {
                drawable.setState(this.getDrawableState());
            }
            this.o0 = drawable;
        } else {
            int n3;
            this.p0 = n3 = typedArray.getColor(com.shawnlin.numberpicker.c.G, this.p0);
            this.setDividerColor(n3);
        }
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int n4 = (int)TypedValue.applyDimension((int)1, (float)48.0f, (DisplayMetrics)displayMetrics);
        int n5 = (int)TypedValue.applyDimension((int)1, (float)2.0f, (DisplayMetrics)displayMetrics);
        this.q0 = typedArray.getDimensionPixelSize(com.shawnlin.numberpicker.c.H, n4);
        this.r0 = typedArray.getDimensionPixelSize(com.shawnlin.numberpicker.c.I, n5);
        this.C0 = typedArray.getInt(com.shawnlin.numberpicker.c.S, 0);
        this.B0 = typedArray.getInt(com.shawnlin.numberpicker.c.T, 1);
        this.z0 = typedArray.getDimensionPixelSize(com.shawnlin.numberpicker.c.j0, -1);
        this.A0 = typedArray.getDimensionPixelSize(com.shawnlin.numberpicker.c.M, -1);
        this.Q();
        this.o = true;
        this.G = typedArray.getInt(com.shawnlin.numberpicker.c.h0, this.G);
        this.F = typedArray.getInt(com.shawnlin.numberpicker.c.P, this.F);
        this.E = typedArray.getInt(com.shawnlin.numberpicker.c.R, this.E);
        this.p = typedArray.getInt(com.shawnlin.numberpicker.c.V, this.p);
        this.q = typedArray.getColor(com.shawnlin.numberpicker.c.W, this.q);
        this.r = typedArray.getDimension(com.shawnlin.numberpicker.c.X, this.S(this.r));
        this.s = typedArray.getBoolean(com.shawnlin.numberpicker.c.Y, this.s);
        this.t = typedArray.getBoolean(com.shawnlin.numberpicker.c.Z, this.t);
        this.u = Typeface.create((String)typedArray.getString(com.shawnlin.numberpicker.c.a0), (int)0);
        this.v = typedArray.getInt(com.shawnlin.numberpicker.c.b0, this.v);
        this.w = typedArray.getColor(com.shawnlin.numberpicker.c.c0, this.w);
        this.x = typedArray.getDimension(com.shawnlin.numberpicker.c.d0, this.S(this.x));
        this.y = typedArray.getBoolean(com.shawnlin.numberpicker.c.e0, this.y);
        this.z = typedArray.getBoolean(com.shawnlin.numberpicker.c.f0, this.z);
        this.A = Typeface.create((String)typedArray.getString(com.shawnlin.numberpicker.c.g0), (int)0);
        this.K = this.T(typedArray.getString(com.shawnlin.numberpicker.c.L));
        this.D0 = typedArray.getBoolean(com.shawnlin.numberpicker.c.J, this.D0);
        this.E0 = typedArray.getFloat(com.shawnlin.numberpicker.c.K, this.E0);
        this.F0 = typedArray.getBoolean(com.shawnlin.numberpicker.c.U, this.F0);
        this.N = typedArray.getInt(com.shawnlin.numberpicker.c.i0, this.N);
        this.G0 = typedArray.getFloat(com.shawnlin.numberpicker.c.O, this.G0);
        this.H0 = typedArray.getInt(com.shawnlin.numberpicker.c.Q, this.H0);
        this.y0 = typedArray.getBoolean(com.shawnlin.numberpicker.c.N, false);
        this.I0 = typedArray.getBoolean(com.shawnlin.numberpicker.c.E, true);
        this.setWillNotDraw(false);
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(com.shawnlin.numberpicker.b.a, (ViewGroup)this, true);
        this.h = editText = (EditText)this.findViewById(com.shawnlin.numberpicker.a.a);
        editText.setEnabled(false);
        editText.setFocusable(false);
        editText.setImeOptions(1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        this.R = paint;
        this.setSelectedTextColor(this.q);
        this.setTextColor(this.w);
        this.setTextSize(this.x);
        this.setSelectedTextSize(this.r);
        this.setTypeface(this.A);
        this.setSelectedTypeface(this.u);
        this.setFormatter(this.K);
        this.W();
        this.setValue(this.G);
        this.setMaxValue(this.F);
        this.setMinValue(this.E);
        this.setWheelItemCount(this.N);
        this.m0 = bl = typedArray.getBoolean(com.shawnlin.numberpicker.c.k0, this.m0);
        this.setWrapSelectorWheel(bl);
        float f2 = this.z0;
        if (f2 != -1.0f && this.A0 != -1.0f) {
            this.setScaleX(f2 / (float)this.m);
            this.setScaleY(this.A0 / (float)this.l);
        } else if (f2 != -1.0f) {
            this.setScaleX(f2 / (float)this.m);
            this.setScaleY(this.z0 / (float)this.m);
        } else {
            float f3 = this.A0;
            if (f3 != -1.0f) {
                this.setScaleX(f3 / (float)this.l);
                this.setScaleY(this.A0 / (float)this.l);
            }
        }
        this.L0 = viewConfiguration = ViewConfiguration.get((Context)context);
        this.j0 = viewConfiguration.getScaledTouchSlop();
        this.k0 = this.L0.getScaledMinimumFlingVelocity();
        this.l0 = this.L0.getScaledMaximumFlingVelocity() / this.H0;
        this.V = new com.shawnlin.numberpicker.d(context, null, true);
        this.W = new com.shawnlin.numberpicker.d(context, (Interpolator)new DecelerateInterpolator(2.5f));
        int n6 = Build.VERSION.SDK_INT;
        if (n6 >= 16 && this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
        if (n6 >= 26 && this.getFocusable() == 16) {
            this.setFocusable(1);
            this.setFocusableInTouchMode(true);
        }
        typedArray.recycle();
    }

    private boolean A(com.shawnlin.numberpicker.d d2) {
        d2.d(true);
        if (this.w()) {
            int n2 = d2.h() - d2.f();
            int n3 = (n2 + this.U) % this.S;
            int n4 = this.T - n3;
            if (n4 != 0) {
                int n5;
                int n6 = Math.abs((int)n4);
                if (n6 > (n5 = this.S) / 2) {
                    n4 = n4 > 0 ? (n4 -= n5) : (n4 += n5);
                }
                this.scrollBy(n2 + n4, 0);
                return true;
            }
        } else {
            int n7 = d2.i() - d2.g();
            int n8 = (n7 + this.U) % this.S;
            int n9 = this.T - n8;
            if (n9 != 0) {
                int n10;
                int n11 = Math.abs((int)n9);
                if (n11 > (n10 = this.S) / 2) {
                    n9 = n9 > 0 ? (n9 -= n10) : (n9 += n10);
                }
                this.scrollBy(0, n7 + n9);
                return true;
            }
        }
        return false;
    }

    private void B(int n2, int n3) {
        e e2 = this.I;
        if (e2 != null) {
            e2.a(this, n2, this.G);
        }
    }

    private void C(int n2) {
        if (this.w0 == n2) {
            return;
        }
        this.w0 = n2;
        d d2 = this.J;
        if (d2 != null) {
            d2.a(this, n2);
        }
    }

    private void D(com.shawnlin.numberpicker.d d2) {
        if (d2 == this.V) {
            this.k();
            this.W();
            this.C(0);
            return;
        }
        if (this.w0 != 1) {
            this.W();
        }
    }

    private void E(boolean bl) {
        this.F(bl, ViewConfiguration.getLongPressTimeout());
    }

    private void F(boolean bl, long l2) {
        b b2 = this.d0;
        if (b2 == null) {
            this.d0 = new b();
        } else {
            this.removeCallbacks((Runnable)b2);
        }
        this.d0.b(bl);
        this.postDelayed((Runnable)this.d0, l2);
    }

    private float G(float f2) {
        return f2 / this.getResources().getDisplayMetrics().density;
    }

    private float H(float f2) {
        return f2 / this.getResources().getDisplayMetrics().scaledDensity;
    }

    private void I() {
        b b2 = this.d0;
        if (b2 != null) {
            this.removeCallbacks((Runnable)b2);
        }
        if (this.c0 == null) {
            return;
        }
        throw null;
    }

    private void J() {
        b b2 = this.d0;
        if (b2 != null) {
            this.removeCallbacks((Runnable)b2);
        }
    }

    private int K(int n2, int n3, int n4) {
        if (n2 != -1) {
            return NumberPicker.resolveSizeAndState(Math.max((int)n2, (int)n3), n4, 0);
        }
        return n3;
    }

    private void P(int n2, boolean bl) {
        if (this.G == n2) {
            return;
        }
        int n3 = this.m0 ? this.q(n2) : Math.min((int)Math.max((int)n2, (int)this.E), (int)this.F);
        int n4 = this.G;
        this.G = n3;
        if (this.w0 != 2) {
            this.W();
        }
        if (bl) {
            this.B(n4, n3);
        }
        this.u();
        this.V();
        this.invalidate();
    }

    private void Q() {
        if (this.w()) {
            this.k = -1;
            this.l = (int)this.h(64.0f);
            this.m = (int)this.h(180.0f);
            this.n = -1;
            return;
        }
        this.k = -1;
        this.l = (int)this.h(180.0f);
        this.m = (int)this.h(64.0f);
        this.n = -1;
    }

    private float S(float f2) {
        return TypedValue.applyDimension((int)2, (float)f2, (DisplayMetrics)this.getResources().getDisplayMetrics());
    }

    private c T(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        return new a(this, string);
    }

    private void U() {
        int n2;
        int n3;
        if (!this.o) {
            return;
        }
        this.R.setTextSize(this.getMaxTextSize());
        String[] arrstring = this.D;
        if (arrstring == null) {
            float f2 = 0.0f;
            for (int i2 = 0; i2 <= 9; ++i2) {
                float f3 = this.R.measureText(this.m(i2));
                if (!(f3 > f2)) continue;
                f2 = f3;
            }
            for (int i3 = this.F; i3 > 0; i3 /= 10) {
                ++n2;
            }
            n3 = (int)(f2 * (float)n2);
        } else {
            int n4 = arrstring.length;
            int n5 = 0;
            for (n2 = 0; n2 < n4; ++n2) {
                float f4 = this.R.measureText(this.D[n2]);
                if (!(f4 > (float)n5)) continue;
                n5 = (int)f4;
            }
            n3 = n5;
        }
        int n6 = n3 + (this.h.getPaddingLeft() + this.h.getPaddingRight());
        if (this.n != n6) {
            int n7 = this.m;
            this.n = n6 > n7 ? n6 : n7;
            this.invalidate();
        }
    }

    private void V() {
        if (!this.I0) {
            return;
        }
        this.setContentDescription((CharSequence)String.valueOf((int)this.getValue()));
    }

    private boolean W() {
        String[] arrstring = this.D;
        String string = arrstring == null ? this.m(this.G) : arrstring[this.G - this.E];
        if (!TextUtils.isEmpty((CharSequence)string) && !string.equals((Object)this.h.getText().toString())) {
            this.h.setText((CharSequence)string);
            return true;
        }
        return false;
    }

    private void X() {
        boolean bl = this.y() && this.n0;
        this.m0 = bl;
    }

    private void c(boolean bl) {
        if (!this.A(this.V)) {
            this.A(this.W);
        }
        this.R(bl, 1);
    }

    private int d(boolean bl) {
        if (bl) {
            return this.getWidth();
        }
        return this.getHeight();
    }

    private int e(boolean bl) {
        if (bl) {
            return this.U;
        }
        return 0;
    }

    private int f(boolean bl) {
        if (bl) {
            return (1 + (this.F - this.E)) * this.S;
        }
        return 0;
    }

    private void g(int[] arrn) {
        for (int i2 = arrn.length - 1; i2 > 0; --i2) {
            arrn[i2] = arrn[i2 - 1];
        }
        int n2 = arrn[1] - 1;
        if (this.m0 && n2 < this.E) {
            n2 = this.F;
        }
        arrn[0] = n2;
        this.j(n2);
    }

    private float getMaxTextSize() {
        return Math.max((float)this.x, (float)this.r);
    }

    private int[] getSelectorIndices() {
        return this.Q;
    }

    public static final c getTwoDigitFormatter() {
        return f;
    }

    private float h(float f2) {
        return f2 * this.getResources().getDisplayMetrics().density;
    }

    private void i(String string, float f2, float f3, Paint paint, Canvas canvas) {
        if (string.contains((CharSequence)"\n")) {
            String[] arrstring = string.split("\n");
            float f4 = Math.abs((float)(paint.descent() + paint.ascent())) * this.G0;
            float f5 = f3 - f4 * (float)(-1 + arrstring.length) / 2.0f;
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                canvas.drawText(arrstring[i2], f2, f5, paint);
                f5 += f4;
            }
        } else {
            canvas.drawText(string, f2, f3, paint);
        }
    }

    private void j(int n2) {
        String string;
        SparseArray<String> sparseArray = this.M;
        if ((String)sparseArray.get(n2) != null) {
            return;
        }
        int n3 = this.E;
        if (n2 >= n3 && n2 <= this.F) {
            String[] arrstring = this.D;
            if (arrstring != null) {
                int n4 = n2 - n3;
                if (n4 >= arrstring.length) {
                    sparseArray.remove(n2);
                    return;
                }
                string = arrstring[n4];
            } else {
                string = this.m(n2);
            }
        } else {
            string = "";
        }
        sparseArray.put(n2, (Object)string);
    }

    private boolean k() {
        int n2 = this.T - this.U;
        if (n2 != 0) {
            int n3;
            int n4 = Math.abs((int)n2);
            if (n4 > (n3 = this.S) / 2) {
                if (n2 > 0) {
                    n3 = -n3;
                }
                n2 += n3;
            }
            int n5 = n2;
            if (this.w()) {
                this.a0 = 0;
                this.W.p(0, 0, n5, 0, 800);
            } else {
                this.b0 = 0;
                this.W.p(0, 0, 0, n5, 800);
            }
            this.invalidate();
            return true;
        }
        return false;
    }

    private void l(int n2) {
        if (this.w()) {
            this.a0 = 0;
            if (n2 > 0) {
                this.V.c(0, 0, n2, 0, 0, Integer.MAX_VALUE, 0, 0);
            } else {
                this.V.c(Integer.MAX_VALUE, 0, n2, 0, 0, Integer.MAX_VALUE, 0, 0);
            }
        } else {
            this.b0 = 0;
            if (n2 > 0) {
                this.V.c(0, 0, 0, n2, 0, 0, 0, Integer.MAX_VALUE);
            } else {
                this.V.c(0, Integer.MAX_VALUE, 0, n2, 0, 0, 0, Integer.MAX_VALUE);
            }
        }
        this.invalidate();
    }

    private String m(int n2) {
        c c2 = this.K;
        if (c2 != null) {
            return c2.format(n2);
        }
        return this.n(n2);
    }

    private String n(int n2) {
        return this.K0.format((long)n2);
    }

    private float o(boolean bl) {
        if (bl && this.D0) {
            return this.E0;
        }
        return 0.0f;
    }

    private float p(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs((float)(fontMetrics.top + fontMetrics.bottom)) / 2.0f;
    }

    private int q(int n2) {
        int n3 = this.F;
        if (n2 > n3) {
            int n4 = this.E;
            return -1 + (n4 + (n2 - n3) % (n3 - n4));
        }
        int n5 = this.E;
        if (n2 < n5) {
            return 1 + (n3 - (n5 - n2) % (n3 - n5));
        }
        return n2;
    }

    private void r(int[] arrn) {
        int n2 = 0;
        while (n2 < -1 + arrn.length) {
            int n3 = n2 + 1;
            arrn[n2] = arrn[n3];
            n2 = n3;
        }
        int n4 = 1 + arrn[-2 + arrn.length];
        if (this.m0 && n4 > this.F) {
            n4 = this.E;
        }
        arrn[-1 + arrn.length] = n4;
        this.j(n4);
    }

    public static int resolveSizeAndState(int n2, int n3, int n4) {
        int n5 = View.MeasureSpec.getMode((int)n3);
        int n6 = View.MeasureSpec.getSize((int)n3);
        if (n5 != Integer.MIN_VALUE) {
            if (n5 == 1073741824) {
                n2 = n6;
            }
        } else if (n6 < n2) {
            n2 = 16777216 | n6;
        }
        return n2 | -16777216 & n4;
    }

    private void s() {
        if (this.w()) {
            this.setHorizontalFadingEdgeEnabled(true);
            this.setFadingEdgeLength((this.getRight() - this.getLeft() - (int)this.x) / 2);
            return;
        }
        this.setVerticalFadingEdgeEnabled(true);
        this.setFadingEdgeLength((this.getBottom() - this.getTop() - (int)this.x) / 2);
    }

    private void t() {
        this.u();
        int[] arrn = this.getSelectorIndices();
        int n2 = (-1 + arrn.length) * (int)this.x + (int)this.r;
        float f2 = arrn.length;
        if (this.w()) {
            int n3;
            this.B = (int)((float)(this.getRight() - this.getLeft() - n2) / f2);
            this.S = n3 = (int)this.getMaxTextSize() + this.B;
            this.T = (int)this.i - n3 * this.P;
        } else {
            int n4;
            this.C = (int)((float)(this.getBottom() - this.getTop() - n2) / f2);
            this.S = n4 = (int)this.getMaxTextSize() + this.C;
            this.T = (int)this.j - n4 * this.P;
        }
        this.U = this.T;
        this.W();
    }

    private void u() {
        this.M.clear();
        int[] arrn = this.getSelectorIndices();
        int n2 = this.getValue();
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            int n3 = n2 + (i2 - this.P);
            if (this.m0) {
                n3 = this.q(n3);
            }
            arrn[i2] = n3;
            this.j(arrn[i2]);
        }
    }

    private boolean y() {
        return this.F - this.E >= this.Q.length - 1;
    }

    private int z(int n2, int n3) {
        if (n3 == -1) {
            return n2;
        }
        int n4 = View.MeasureSpec.getSize((int)n2);
        int n5 = View.MeasureSpec.getMode((int)n2);
        if (n5 != Integer.MIN_VALUE) {
            if (n5 != 0) {
                if (n5 == 1073741824) {
                    return n2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown measure mode: ");
                stringBuilder.append(n5);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            return View.MeasureSpec.makeMeasureSpec((int)n3, (int)1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec((int)Math.min((int)n4, (int)n3), (int)1073741824);
    }

    public void L(int n2, int n3) {
        this.M(this.getResources().getString(n2), n3);
    }

    public void M(String string, int n2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        this.setSelectedTypeface(Typeface.create((String)string, (int)n2));
    }

    public void N(int n2, int n3) {
        this.O(this.getResources().getString(n2), n3);
    }

    public void O(String string, int n2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        this.setTypeface(Typeface.create((String)string, (int)n2));
    }

    public void R(boolean bl, int n2) {
        if (this.w()) {
            this.a0 = 0;
            if (bl) {
                this.V.p(0, 0, n2 * -this.S, 0, 300);
            } else {
                this.V.p(0, 0, n2 * this.S, 0, 300);
            }
        } else {
            this.b0 = 0;
            if (bl) {
                this.V.p(0, 0, 0, n2 * -this.S, 300);
            } else {
                this.V.p(0, 0, 0, n2 * this.S, 300);
            }
        }
        this.invalidate();
    }

    protected int computeHorizontalScrollExtent() {
        return this.d(this.w());
    }

    protected int computeHorizontalScrollOffset() {
        return this.e(this.w());
    }

    protected int computeHorizontalScrollRange() {
        return this.f(this.w());
    }

    public void computeScroll() {
        if (!this.x()) {
            return;
        }
        com.shawnlin.numberpicker.d d2 = this.V;
        if (d2.o() && (d2 = this.W).o()) {
            return;
        }
        d2.b();
        if (this.w()) {
            int n2 = d2.f();
            if (this.a0 == 0) {
                this.a0 = d2.m();
            }
            this.scrollBy(n2 - this.a0, 0);
            this.a0 = n2;
        } else {
            int n3 = d2.g();
            if (this.b0 == 0) {
                this.b0 = d2.n();
            }
            this.scrollBy(0, n3 - this.b0);
            this.b0 = n3;
        }
        if (d2.o()) {
            this.D(d2);
            return;
        }
        this.postInvalidate();
    }

    protected int computeVerticalScrollExtent() {
        return this.d(this.w());
    }

    protected int computeVerticalScrollOffset() {
        return this.e(true ^ this.w());
    }

    protected int computeVerticalScrollRange() {
        return this.f(true ^ this.w());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n2;
        block10 : {
            block8 : {
                block9 : {
                    block7 : {
                        n2 = keyEvent.getKeyCode();
                        if (n2 == 19 || n2 == 20) break block7;
                        if (n2 == 23 || n2 == 66) {
                            this.I();
                        }
                        break block8;
                    }
                    int n3 = keyEvent.getAction();
                    if (n3 == 0) break block9;
                    if (n3 == 1 && this.x0 == n2) {
                        this.x0 = -1;
                        return true;
                    }
                    break block8;
                }
                if (this.m0 || (n2 == 20 ? this.getValue() < this.getMaxValue() : this.getValue() > this.getMinValue())) break block10;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        this.requestFocus();
        this.x0 = n2;
        this.I();
        if (this.V.o()) {
            boolean bl = n2 == 20;
            this.c(bl);
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n2 = 255 & motionEvent.getAction();
        if (n2 == 1 || n2 == 3) {
            this.I();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int n2 = 255 & motionEvent.getAction();
        if (n2 == 1 || n2 == 3) {
            this.I();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o0;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.getDrawableState())) {
            this.invalidateDrawable(drawable);
        }
    }

    protected float getBottomFadingEdgeStrength() {
        return this.o(true ^ this.w());
    }

    public String[] getDisplayedValues() {
        return this.D;
    }

    public int getDividerColor() {
        return this.p0;
    }

    public float getDividerDistance() {
        return this.G(this.q0);
    }

    public float getDividerThickness() {
        return this.G(this.r0);
    }

    public float getFadingEdgeStrength() {
        return this.E0;
    }

    public c getFormatter() {
        return this.K;
    }

    protected float getLeftFadingEdgeStrength() {
        return this.o(this.w());
    }

    public float getLineSpacingMultiplier() {
        return this.G0;
    }

    public int getMaxFlingVelocityCoefficient() {
        return this.H0;
    }

    public int getMaxValue() {
        return this.F;
    }

    public int getMinValue() {
        return this.E;
    }

    public int getOrder() {
        return this.C0;
    }

    public int getOrientation() {
        return this.B0;
    }

    protected float getRightFadingEdgeStrength() {
        return this.o(this.w());
    }

    public int getSelectedTextAlign() {
        return this.p;
    }

    public int getSelectedTextColor() {
        return this.q;
    }

    public float getSelectedTextSize() {
        return this.r;
    }

    public boolean getSelectedTextStrikeThru() {
        return this.s;
    }

    public boolean getSelectedTextUnderline() {
        return this.t;
    }

    public int getTextAlign() {
        return this.v;
    }

    public int getTextColor() {
        return this.w;
    }

    public float getTextSize() {
        return this.S(this.x);
    }

    public boolean getTextStrikeThru() {
        return this.y;
    }

    public boolean getTextUnderline() {
        return this.z;
    }

    protected float getTopFadingEdgeStrength() {
        return this.o(true ^ this.w());
    }

    public Typeface getTypeface() {
        return this.A;
    }

    public int getValue() {
        return this.G;
    }

    public int getWheelItemCount() {
        return this.N;
    }

    public boolean getWrapSelectorWheel() {
        return this.m0;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.o0;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.K0 = NumberFormat.getInstance();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I();
    }

    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        canvas.save();
        boolean bl = this.y0 ? this.hasFocus() : true;
        if (this.w()) {
            f2 = this.U;
            f3 = this.h.getBaseline() + this.h.getTop();
            if (this.O < 3) {
                canvas.clipRect(this.u0, 0, this.v0, this.getBottom());
            }
        } else {
            f2 = (this.getRight() - this.getLeft()) / 2;
            f3 = this.U;
            if (this.O < 3) {
                canvas.clipRect(0, this.s0, this.getRight(), this.t0);
            }
        }
        int[] arrn = this.getSelectorIndices();
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            if (i2 == this.P) {
                this.R.setTextAlign(Paint.Align.values()[this.p]);
                this.R.setTextSize(this.r);
                this.R.setColor(this.q);
                this.R.setStrikeThruText(this.s);
                this.R.setUnderlineText(this.t);
            } else {
                this.R.setTextAlign(Paint.Align.values()[this.v]);
                this.R.setTextSize(this.x);
                this.R.setColor(this.w);
                this.R.setStrikeThruText(this.y);
                this.R.setUnderlineText(this.z);
            }
            int n2 = this.v() ? i2 : arrn.length - i2 - 1;
            int n3 = arrn[n2];
            String string = (String)this.M.get(n3);
            if (string == null) continue;
            if (bl && i2 != this.P || i2 == this.P && this.h.getVisibility() != 0) {
                float f4 = !this.w() ? f3 + this.p(this.R.getFontMetrics()) : f3;
                Paint paint = this.R;
                this.i(string, f2, f4, paint, canvas);
            }
            if (this.w()) {
                f2 += (float)this.S;
                continue;
            }
            f3 += (float)this.S;
        }
        canvas.restore();
        if (bl && this.o0 != null) {
            if (this.w()) {
                int n4 = this.getBottom();
                int n5 = this.u0;
                int n6 = n5 + this.r0;
                this.o0.setBounds(n5, 0, n6, n4);
                this.o0.draw(canvas);
                int n7 = this.v0;
                int n8 = n7 - this.r0;
                this.o0.setBounds(n8, 0, n7, n4);
                this.o0.draw(canvas);
                return;
            }
            int n9 = this.getRight();
            int n10 = this.s0;
            int n11 = n10 + this.r0;
            this.o0.setBounds(0, n10, n9, n11);
            this.o0.draw(canvas);
            int n12 = this.t0;
            int n13 = n12 - this.r0;
            this.o0.setBounds(0, n13, n9, n12);
            this.o0.draw(canvas);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)NumberPicker.class.getName());
        accessibilityEvent.setScrollable(this.x());
        int n2 = this.E;
        int n3 = n2 + this.G;
        int n4 = this.S;
        int n5 = n3 * n4;
        int n6 = n4 * (this.F - n2);
        if (this.w()) {
            accessibilityEvent.setScrollX(n5);
            accessibilityEvent.setMaxScrollX(n6);
            return;
        }
        accessibilityEvent.setScrollY(n5);
        accessibilityEvent.setMaxScrollY(n6);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnabled()) {
            return false;
        }
        if ((255 & motionEvent.getAction()) != 0) {
            return false;
        }
        this.I();
        this.getParent().requestDisallowInterceptTouchEvent(true);
        if (this.w()) {
            float f2;
            this.e0 = f2 = motionEvent.getX();
            this.g0 = f2;
            if (!this.V.o()) {
                this.V.d(true);
                this.W.d(true);
                this.C(0);
                return true;
            }
            if (!this.W.o()) {
                this.V.d(true);
                this.W.d(true);
                return true;
            }
            float f3 = this.e0;
            int n2 = this.u0;
            if (f3 >= (float)n2 && f3 <= (float)this.v0) {
                View.OnClickListener onClickListener = this.H;
                if (onClickListener != null) {
                    onClickListener.onClick((View)this);
                    return true;
                }
            } else {
                if (f3 < (float)n2) {
                    this.E(false);
                    return true;
                }
                if (f3 > (float)this.v0) {
                    this.E(true);
                    return true;
                }
            }
        } else {
            float f4;
            this.f0 = f4 = motionEvent.getY();
            this.h0 = f4;
            if (!this.V.o()) {
                this.V.d(true);
                this.W.d(true);
                this.C(0);
                return true;
            }
            if (!this.W.o()) {
                this.V.d(true);
                this.W.d(true);
                return true;
            }
            float f5 = this.f0;
            int n3 = this.s0;
            if (f5 >= (float)n3 && f5 <= (float)this.t0) {
                View.OnClickListener onClickListener = this.H;
                if (onClickListener != null) {
                    onClickListener.onClick((View)this);
                    return true;
                }
            } else {
                if (f5 < (float)n3) {
                    this.E(false);
                    return true;
                }
                if (f5 > (float)this.t0) {
                    this.E(true);
                }
            }
        }
        return true;
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        int n6 = this.getMeasuredWidth();
        int n7 = this.getMeasuredHeight();
        int n8 = this.h.getMeasuredWidth();
        int n9 = this.h.getMeasuredHeight();
        int n10 = (n6 - n8) / 2;
        int n11 = (n7 - n9) / 2;
        int n12 = n8 + n10;
        int n13 = n9 + n11;
        this.h.layout(n10, n11, n12, n13);
        this.i = this.h.getX() + (float)(this.h.getMeasuredWidth() / 2);
        this.j = this.h.getY() + (float)(this.h.getMeasuredHeight() / 2);
        if (bl) {
            int n14;
            this.t();
            this.s();
            int n15 = 2 * this.r0 + this.q0;
            if (this.w()) {
                int n16;
                this.u0 = n16 = (this.getWidth() - this.q0) / 2 - this.r0;
                this.v0 = n16 + n15;
                return;
            }
            this.s0 = n14 = (this.getHeight() - this.q0) / 2 - this.r0;
            this.t0 = n14 + n15;
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(this.z(n2, this.n), this.z(n3, this.l));
        this.setMeasuredDimension(this.K(this.m, this.getMeasuredWidth(), n2), this.K(this.k, this.getMeasuredHeight(), n3));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnabled()) {
            return false;
        }
        if (!this.x()) {
            return false;
        }
        if (this.i0 == null) {
            this.i0 = VelocityTracker.obtain();
        }
        this.i0.addMovement(motionEvent);
        int n2 = 255 & motionEvent.getAction();
        if (n2 != 1) {
            if (n2 != 2) {
                return true;
            }
            if (this.w()) {
                float f2 = motionEvent.getX();
                if (this.w0 != 1) {
                    if ((int)Math.abs((float)(f2 - this.e0)) > this.j0) {
                        this.I();
                        this.C(1);
                    }
                } else {
                    this.scrollBy((int)(f2 - this.g0), 0);
                    this.invalidate();
                }
                this.g0 = f2;
                return true;
            }
            float f3 = motionEvent.getY();
            if (this.w0 != 1) {
                if ((int)Math.abs((float)(f3 - this.f0)) > this.j0) {
                    this.I();
                    this.C(1);
                }
            } else {
                this.scrollBy(0, (int)(f3 - this.h0));
                this.invalidate();
            }
            this.h0 = f3;
            return true;
        }
        this.J();
        VelocityTracker velocityTracker = this.i0;
        velocityTracker.computeCurrentVelocity(1000, (float)this.l0);
        if (this.w()) {
            int n3 = (int)velocityTracker.getXVelocity();
            if (Math.abs((int)n3) > this.k0) {
                this.l(n3);
                this.C(2);
            } else {
                int n4 = (int)motionEvent.getX();
                if ((int)Math.abs((float)((float)n4 - this.e0)) <= this.j0) {
                    int n5 = n4 / this.S - this.P;
                    if (n5 > 0) {
                        this.c(true);
                    } else if (n5 < 0) {
                        this.c(false);
                    } else {
                        this.k();
                    }
                } else {
                    this.k();
                }
                this.C(0);
            }
        } else {
            int n6 = (int)velocityTracker.getYVelocity();
            if (Math.abs((int)n6) > this.k0) {
                this.l(n6);
                this.C(2);
            } else {
                int n7 = (int)motionEvent.getY();
                if ((int)Math.abs((float)((float)n7 - this.f0)) <= this.j0) {
                    int n8 = n7 / this.S - this.P;
                    if (n8 > 0) {
                        this.c(true);
                    } else if (n8 < 0) {
                        this.c(false);
                    } else {
                        this.k();
                    }
                } else {
                    this.k();
                }
                this.C(0);
            }
        }
        this.i0.recycle();
        this.i0 = null;
        return true;
    }

    public void scrollBy(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        if (!this.x()) {
            return;
        }
        int[] arrn = this.getSelectorIndices();
        int n7 = this.U;
        if (this.w()) {
            if (this.v()) {
                boolean bl = this.m0;
                if (!bl && n2 > 0 && arrn[this.P] <= this.E) {
                    this.U = this.T;
                    return;
                }
                if (!bl && n2 < 0 && arrn[this.P] >= this.F) {
                    this.U = this.T;
                    return;
                }
            } else {
                boolean bl = this.m0;
                if (!bl && n2 > 0 && arrn[this.P] >= this.F) {
                    this.U = this.T;
                    return;
                }
                if (!bl && n2 < 0 && arrn[this.P] <= this.E) {
                    this.U = this.T;
                    return;
                }
            }
            this.U = n2 + this.U;
            n4 = this.B;
        } else {
            if (this.v()) {
                boolean bl = this.m0;
                if (!bl && n3 > 0 && arrn[this.P] <= this.E) {
                    this.U = this.T;
                    return;
                }
                if (!bl && n3 < 0 && arrn[this.P] >= this.F) {
                    this.U = this.T;
                    return;
                }
            } else {
                boolean bl = this.m0;
                if (!bl && n3 > 0 && arrn[this.P] >= this.F) {
                    this.U = this.T;
                    return;
                }
                if (!bl && n3 < 0 && arrn[this.P] <= this.E) {
                    this.U = this.T;
                    return;
                }
            }
            this.U = n3 + this.U;
            n4 = this.C;
        }
        while ((n6 = this.U) - this.T > n4) {
            this.U = n6 - this.S;
            if (this.v()) {
                this.g(arrn);
            } else {
                this.r(arrn);
            }
            this.P(arrn[this.P], true);
            if (this.m0 || arrn[this.P] >= this.E) continue;
            this.U = this.T;
        }
        while ((n5 = this.U) - this.T < -n4) {
            this.U = n5 + this.S;
            if (this.v()) {
                this.r(arrn);
            } else {
                this.g(arrn);
            }
            this.P(arrn[this.P], true);
            if (this.m0 || arrn[this.P] <= this.F) continue;
            this.U = this.T;
        }
        if (n7 != n5) {
            if (this.w()) {
                this.onScrollChanged(this.U, 0, n7, 0);
                return;
            }
            this.onScrollChanged(0, this.U, 0, n7);
        }
    }

    public void setAccessibilityDescriptionEnabled(boolean bl) {
        this.I0 = bl;
    }

    public void setDisplayedValues(String[] arrstring) {
        if (this.D == arrstring) {
            return;
        }
        this.D = arrstring;
        if (arrstring != null) {
            this.h.setRawInputType(655360);
        } else {
            this.h.setRawInputType(2);
        }
        this.W();
        this.u();
        this.U();
    }

    public void setDividerColor(int n2) {
        this.p0 = n2;
        this.o0 = new ColorDrawable(n2);
    }

    public void setDividerColorResource(int n2) {
        this.setDividerColor(b.i.h.a.c((Context)this.J0, (int)n2));
    }

    public void setDividerDistance(int n2) {
        this.q0 = n2;
    }

    public void setDividerDistanceResource(int n2) {
        this.setDividerDistance(this.getResources().getDimensionPixelSize(n2));
    }

    public void setDividerThickness(int n2) {
        this.r0 = n2;
    }

    public void setDividerThicknessResource(int n2) {
        this.setDividerThickness(this.getResources().getDimensionPixelSize(n2));
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        this.h.setEnabled(bl);
    }

    public void setFadingEdgeEnabled(boolean bl) {
        this.D0 = bl;
    }

    public void setFadingEdgeStrength(float f2) {
        this.E0 = f2;
    }

    public void setFormatter(int n2) {
        this.setFormatter(this.getResources().getString(n2));
    }

    public void setFormatter(c c2) {
        if (c2 == this.K) {
            return;
        }
        this.K = c2;
        this.u();
        this.W();
    }

    public void setFormatter(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        this.setFormatter(this.T(string));
    }

    public void setLineSpacingMultiplier(float f2) {
        this.G0 = f2;
    }

    public void setMaxFlingVelocityCoefficient(int n2) {
        this.H0 = n2;
        this.l0 = this.L0.getScaledMaximumFlingVelocity() / this.H0;
    }

    public void setMaxValue(int n2) {
        if (n2 >= 0) {
            this.F = n2;
            if (n2 < this.G) {
                this.G = n2;
            }
            this.X();
            this.u();
            this.W();
            this.U();
            this.invalidate();
            return;
        }
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMinValue(int n2) {
        this.E = n2;
        if (n2 > this.G) {
            this.G = n2;
        }
        this.setWrapSelectorWheel(this.y());
        this.u();
        this.W();
        this.U();
        this.invalidate();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    public void setOnLongPressUpdateInterval(long l2) {
        this.L = l2;
    }

    public void setOnScrollListener(d d2) {
        this.J = d2;
    }

    public void setOnValueChangedListener(e e2) {
        this.I = e2;
    }

    public void setOrder(int n2) {
        this.C0 = n2;
    }

    public void setOrientation(int n2) {
        this.B0 = n2;
        this.Q();
    }

    public void setScrollerEnabled(boolean bl) {
        this.F0 = bl;
    }

    public void setSelectedTextAlign(int n2) {
        this.p = n2;
    }

    public void setSelectedTextColor(int n2) {
        this.q = n2;
        this.h.setTextColor(n2);
    }

    public void setSelectedTextColorResource(int n2) {
        this.setSelectedTextColor(b.i.h.a.c((Context)this.J0, (int)n2));
    }

    public void setSelectedTextSize(float f2) {
        this.r = f2;
        this.h.setTextSize(this.H(f2));
    }

    public void setSelectedTextSize(int n2) {
        this.setSelectedTextSize(this.getResources().getDimension(n2));
    }

    public void setSelectedTextStrikeThru(boolean bl) {
        this.s = bl;
    }

    public void setSelectedTextUnderline(boolean bl) {
        this.t = bl;
    }

    public void setSelectedTypeface(int n2) {
        this.L(n2, 0);
    }

    public void setSelectedTypeface(Typeface typeface) {
        this.u = typeface;
        if (typeface != null) {
            this.R.setTypeface(typeface);
            return;
        }
        Typeface typeface2 = this.A;
        if (typeface2 != null) {
            this.R.setTypeface(typeface2);
            return;
        }
        this.R.setTypeface(Typeface.MONOSPACE);
    }

    public void setSelectedTypeface(String string) {
        this.M(string, 0);
    }

    public void setTextAlign(int n2) {
        this.v = n2;
    }

    public void setTextColor(int n2) {
        this.w = n2;
        this.R.setColor(n2);
    }

    public void setTextColorResource(int n2) {
        this.setTextColor(b.i.h.a.c((Context)this.J0, (int)n2));
    }

    public void setTextSize(float f2) {
        this.x = f2;
        this.R.setTextSize(f2);
    }

    public void setTextSize(int n2) {
        this.setTextSize(this.getResources().getDimension(n2));
    }

    public void setTextStrikeThru(boolean bl) {
        this.y = bl;
    }

    public void setTextUnderline(boolean bl) {
        this.z = bl;
    }

    public void setTypeface(int n2) {
        this.N(n2, 0);
    }

    public void setTypeface(Typeface typeface) {
        this.A = typeface;
        if (typeface != null) {
            this.h.setTypeface(typeface);
            this.setSelectedTypeface(this.u);
            return;
        }
        this.h.setTypeface(Typeface.MONOSPACE);
    }

    public void setTypeface(String string) {
        this.O(string, 0);
    }

    public void setValue(int n2) {
        this.P(n2, false);
    }

    public void setWheelItemCount(int n2) {
        if (n2 >= 1) {
            this.O = n2;
            if (n2 < 3) {
                n2 = 3;
            }
            this.N = n2;
            this.P = n2 / 2;
            this.Q = new int[n2];
            return;
        }
        throw new IllegalArgumentException("Wheel item count must be >= 1");
    }

    public void setWrapSelectorWheel(boolean bl) {
        this.n0 = bl;
        this.X();
    }

    public boolean v() {
        return this.getOrder() == 0;
    }

    public boolean w() {
        return this.getOrientation() == 0;
    }

    public boolean x() {
        return this.F0;
    }

    class b
    implements Runnable {
        private boolean f;

        b() {
        }

        private void b(boolean bl) {
            this.f = bl;
        }

        public void run() {
            NumberPicker.this.c(this.f);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed((Runnable)this, numberPicker.L);
        }
    }

    public static interface c {
        public String format(int var1);
    }

    public static interface d {
        public void a(NumberPicker var1, int var2);
    }

    public static interface e {
        public void a(NumberPicker var1, int var2, int var3);
    }

    private static class f
    implements Runnable {
    }

}

