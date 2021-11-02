/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Point
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.Xfermode
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.Window
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  j.a.a.a.a
 *  j.a.a.a.b
 *  j.a.a.a.f$b
 *  j.a.a.a.f$c
 *  j.a.a.a.l.a
 *  j.a.a.a.l.b
 *  j.a.a.a.l.c
 *  j.a.a.a.l.d
 *  j.a.a.a.m.b
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package j.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import j.a.a.a.c;
import j.a.a.a.f;
import j.a.a.a.g;
import j.a.a.a.h;
import j.a.a.a.i;
import j.a.a.a.j;
import j.a.a.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
extends FrameLayout
implements View.OnTouchListener,
View.OnClickListener {
    private int A;
    private int B;
    private int C;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private int G;
    private j.a.a.a.c H;
    private boolean I = true;
    private boolean J = false;
    private long K = 300L;
    private Handler L;
    private long M = 0L;
    private int N = 0;
    private boolean O = false;
    private g P;
    List<j.a.a.a.e> Q;
    private e R;
    private j.a.a.a.d S;
    private boolean T = false;
    private boolean U = true;
    private boolean V = false;
    private k W;
    private boolean a0;
    long f = 0L;
    long g = 300L;
    private int h;
    private int i;
    private Bitmap j;
    private Canvas k;
    private Paint l;
    private j.a.a.a.m.a m;
    private j.a.a.a.l.e n;
    private int o;
    private int p;
    private boolean q = false;
    private boolean r = false;
    private int s = 10;
    private int t = 10;
    private View u;
    private TextView v;
    private TextView w;
    private TextView x;
    private boolean y;
    private TextView z;

    public f(Context context) {
        super(context);
        this.q(context);
    }

    private void n() {
        View view = this.u;
        if (view != null && view.getLayoutParams() != null) {
            int n2;
            int n3;
            int n4;
            int n5;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.u.getLayoutParams();
            int n6 = layoutParams.bottomMargin;
            int n7 = this.B;
            boolean bl = true;
            boolean bl2 = false;
            if (n6 != n7) {
                layoutParams.bottomMargin = n7;
                bl2 = true;
            }
            if ((n5 = layoutParams.topMargin) != (n4 = this.C)) {
                layoutParams.topMargin = n4;
                bl2 = true;
            }
            if ((n2 = layoutParams.gravity) != (n3 = this.A)) {
                layoutParams.gravity = n3;
            } else {
                bl = bl2;
            }
            if (bl) {
                this.u.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
            this.A();
        }
    }

    private void q(Context context) {
        TextView textView;
        TextView textView2;
        this.setWillNotDraw(false);
        this.Q = new ArrayList();
        this.R = new e();
        this.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.R);
        this.setOnTouchListener((View.OnTouchListener)this);
        this.G = Color.parseColor((String)"#dd335075");
        this.setVisibility(4);
        View view = LayoutInflater.from((Context)this.getContext()).inflate(i.a, (ViewGroup)this, true);
        this.u = view.findViewById(h.a);
        this.v = (TextView)view.findViewById(h.e);
        this.w = (TextView)view.findViewById(h.b);
        this.x = textView2 = (TextView)view.findViewById(h.c);
        textView2.setOnClickListener((View.OnClickListener)this);
        this.z = textView = (TextView)view.findViewById(h.d);
        textView.setOnClickListener((View.OnClickListener)this);
    }

    private void r() {
        j.a.a.a.d d2;
        List<j.a.a.a.e> list = this.Q;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((j.a.a.a.e)iterator.next()).b(this);
            }
            this.Q.clear();
            this.Q = null;
        }
        if ((d2 = this.S) != null) {
            d2.a(this, this.q, this.r);
        }
    }

    private void s() {
        List<j.a.a.a.e> list = this.Q;
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((j.a.a.a.e)iterator.next()).a(this);
            }
        }
    }

    private void setContentText(CharSequence charSequence) {
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private void setContentTextColor(int n2) {
        TextView textView = this.w;
        if (textView != null) {
            textView.setTextColor(n2);
        }
    }

    private void setDelay(long l2) {
        this.M = l2;
    }

    private void setDismissOnTargetTouch(boolean bl) {
        this.U = bl;
    }

    private void setDismissOnTouch(boolean bl) {
        this.D = bl;
    }

    private void setDismissStyle(Typeface typeface) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setTypeface(typeface);
            this.y();
        }
    }

    private void setDismissText(CharSequence charSequence) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(charSequence);
            this.y();
        }
    }

    private void setDismissTextColor(int n2) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setTextColor(n2);
        }
    }

    private void setFadeDuration(long l2) {
        this.K = l2;
    }

    private void setIsSequence(Boolean bl) {
        this.V = bl;
    }

    private void setMaskColour(int n2) {
        this.G = n2;
    }

    private void setRenderOverNavigationBar(boolean bl) {
        this.F = bl;
    }

    private void setShapePadding(int n2) {
        this.s = n2;
    }

    private void setShouldRender(boolean bl) {
        this.E = bl;
    }

    private void setSkipStyle(Typeface typeface) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setTypeface(typeface);
            this.z();
        }
    }

    private void setSkipText(CharSequence charSequence) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(charSequence);
            this.z();
        }
    }

    private void setTargetTouchable(boolean bl) {
        this.T = bl;
    }

    private void setTitleText(CharSequence charSequence) {
        if (this.v != null && !charSequence.equals((Object)"")) {
            this.w.setAlpha(0.5f);
            this.v.setText(charSequence);
        }
    }

    private void setTitleTextColor(int n2) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setTextColor(n2);
        }
    }

    private void setToolTip(k k2) {
    }

    private void setTooltipMargin(int n2) {
        this.t = n2;
    }

    private void setUseFadeAnimation(boolean bl) {
        this.J = bl;
    }

    private void w(String string2) {
        this.O = true;
        this.P = new g(this.getContext(), string2);
    }

    void A() {
        if (this.W != null) {
            if (this.a0) {
                if (this.A == 80) {
                    throw null;
                }
                throw null;
            }
            this.a0 = true;
            (2 * this.n.c() - this.m.a().height()) / 2;
            throw null;
        }
    }

    public int getSoftButtonsBarSizePort() {
        int n2 = this.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (n2 > 0) {
            return this.getResources().getDimensionPixelSize(n2);
        }
        return 0;
    }

    public void m() {
        this.H.a((View)this, this.m.b(), this.K, (c.a)new c(this));
    }

    public void o() {
        this.setVisibility(4);
        this.H.b((View)this, this.m.b(), this.K, (c.b)new b(this));
    }

    public void onClick(View view) {
        if (view.getId() == h.c) {
            this.p();
            return;
        }
        if (view.getId() == h.d) {
            this.x();
        }
    }

    protected void onDetachedFromWindow() {
        g g2;
        super.onDetachedFromWindow();
        if (!this.q && this.O && (g2 = this.P) != null) {
            g2.d();
        }
        this.r();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.E) {
            return;
        }
        int n2 = this.getMeasuredWidth();
        int n3 = this.getMeasuredHeight();
        if (n2 > 0) {
            if (n3 <= 0) {
                return;
            }
            Bitmap bitmap = this.j;
            if (bitmap == null || this.k == null || this.h != n3 || this.i != n2) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.j = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                this.k = new Canvas(this.j);
            }
            this.i = n2;
            this.h = n3;
            this.k.drawColor(0, PorterDuff.Mode.CLEAR);
            this.k.drawColor(this.G);
            if (this.l == null) {
                Paint paint;
                this.l = paint = new Paint();
                paint.setColor(-1);
                this.l.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                this.l.setFlags(1);
            }
            this.n.a(this.k, this.l, this.o, this.p);
            canvas.drawBitmap(this.j, 0.0f, 0.0f, null);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.D) {
            this.p();
        }
        if (this.T && this.m.a().contains((int)motionEvent.getX(), (int)motionEvent.getY())) {
            if (this.U) {
                this.p();
            }
            return false;
        }
        return true;
    }

    public void p() {
        this.q = true;
        if (this.I) {
            this.m();
            return;
        }
        this.t();
    }

    public void setAnimationFactory(j.a.a.a.c c2) {
        this.H = c2;
    }

    public void setConfig(j j2) {
        throw null;
    }

    void setDetachedListener(j.a.a.a.d d2) {
        this.S = d2;
    }

    public void setGravity(int n2) {
        boolean bl = n2 != 0;
        this.y = bl;
        if (bl) {
            this.A = n2;
            this.B = 0;
            this.C = 0;
        }
        this.n();
    }

    void setPosition(Point point) {
        this.u(point.x, point.y);
    }

    public void setShape(j.a.a.a.l.e e2) {
        this.n = e2;
    }

    public void setTarget(j.a.a.a.m.a a2) {
        this.m = a2;
        this.y();
        if (this.m != null) {
            if (!this.F && Build.VERSION.SDK_INT >= 21) {
                int n2;
                int n3;
                this.N = this.getSoftButtonsBarSizePort();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.getLayoutParams();
                if (layoutParams != null && (n3 = layoutParams.bottomMargin) != (n2 = this.N)) {
                    layoutParams.bottomMargin = n2;
                }
            }
            Point point = this.m.b();
            Rect rect = this.m.a();
            this.setPosition(point);
            int n4 = this.getMeasuredHeight();
            int n5 = n4 / 2;
            int n6 = point.y;
            int n7 = Math.max((int)rect.height(), (int)rect.width()) / 2;
            j.a.a.a.l.e e2 = this.n;
            if (e2 != null) {
                e2.d(this.m);
                n7 = this.n.getHeight() / 2;
            }
            if (!this.y) {
                if (n6 > n5) {
                    this.C = 0;
                    this.B = n7 + (n4 - n6) + this.s;
                    this.A = 80;
                } else {
                    this.C = n6 + n7 + this.s;
                    this.B = 0;
                    this.A = 48;
                }
            }
        }
        this.n();
    }

    public void t() {
        Bitmap bitmap;
        if (this.getParent() != null && this.getParent() instanceof ViewGroup) {
            ((ViewGroup)this.getParent()).removeView((View)this);
        }
        if ((bitmap = this.j) != null) {
            bitmap.recycle();
            this.j = null;
        }
        this.l = null;
        this.H = null;
        this.k = null;
        this.L = null;
        this.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.R);
        this.R = null;
        g g2 = this.P;
        if (g2 != null) {
            g2.a();
        }
        this.P = null;
    }

    void u(int n2, int n3) {
        this.o = n2;
        this.p = n3;
    }

    public boolean v(Activity activity) {
        Handler handler;
        if (this.O) {
            if (this.P.c()) {
                return false;
            }
            this.P.f();
        }
        ((ViewGroup)activity.getWindow().getDecorView()).addView((View)this);
        this.setShouldRender(true);
        if (this.W != null) {
            j.a.a.a.m.a a2 = this.m;
            if (!(a2 instanceof j.a.a.a.m.b)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The target must be of type: ");
                stringBuilder.append(j.a.a.a.m.b.class.getCanonicalName());
                throw new RuntimeException(stringBuilder.toString());
            }
            ((j.a.a.a.m.b)a2).c();
            throw null;
        }
        this.L = handler = new Handler();
        handler.postDelayed(new Runnable(){

            public void run() {
                boolean bl = Build.VERSION.SDK_INT >= 19 ? f.this.isAttachedToWindow() : f.this.getWindowToken() != null;
                if (f.this.I && bl) {
                    f.this.o();
                    return;
                }
                f.this.setVisibility(0);
                f.this.s();
            }
        }, this.M);
        this.y();
        return true;
    }

    public void x() {
        this.r = true;
        if (this.I) {
            this.m();
            return;
        }
        this.t();
    }

    void y() {
        TextView textView = this.x;
        if (textView != null) {
            if (TextUtils.isEmpty((CharSequence)textView.getText())) {
                this.x.setVisibility(8);
                return;
            }
            this.x.setVisibility(0);
        }
    }

    void z() {
        TextView textView = this.z;
        if (textView != null) {
            if (TextUtils.isEmpty((CharSequence)textView.getText())) {
                this.z.setVisibility(8);
                return;
            }
            this.z.setVisibility(0);
        }
    }

    public static class d {
        private boolean a = false;
        private int b = 0;
        final f c;
        private final Activity d;

        public d(Activity activity) {
            this.d = activity;
            this.c = new f((Context)activity);
        }

        public f a() {
            if (this.c.n == null) {
                int n2 = this.b;
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            f f2 = this.c;
                            f2.setShape((j.a.a.a.l.e)new j.a.a.a.l.a(f2.m));
                        } else {
                            f f3 = this.c;
                            f3.setShape((j.a.a.a.l.e)new j.a.a.a.l.c(f3.m));
                        }
                    } else {
                        this.c.setShape((j.a.a.a.l.e)new j.a.a.a.l.b());
                    }
                } else {
                    f f4 = this.c;
                    f4.setShape((j.a.a.a.l.e)new j.a.a.a.l.d(f4.m.a(), this.a));
                }
            }
            if (this.c.H == null) {
                if (Build.VERSION.SDK_INT >= 21 && !this.c.J) {
                    this.c.setAnimationFactory((j.a.a.a.c)new j.a.a.a.a());
                } else {
                    this.c.setAnimationFactory((j.a.a.a.c)new j.a.a.a.b());
                }
            }
            this.c.n.b(this.c.s);
            return this.c;
        }

        public d b() {
            this.c.setRenderOverNavigationBar(true);
            return this;
        }

        public d c(CharSequence charSequence) {
            this.c.setContentText(charSequence);
            return this;
        }

        public d d(int n2) {
            this.c.setDelay(n2);
            return this;
        }

        public d e(CharSequence charSequence) {
            this.c.setDismissText(charSequence);
            return this;
        }

        public d f(View view) {
            this.c.setTarget((j.a.a.a.m.a)new j.a.a.a.m.b(view));
            return this;
        }

        public d g(String string2) {
            this.c.w(string2);
            return this;
        }
    }

    private class e
    implements ViewTreeObserver.OnGlobalLayoutListener {
        private e() {
        }

        public void onGlobalLayout() {
            f f2 = f.this;
            f2.setTarget(f2.m);
        }
    }

}

