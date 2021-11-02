/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 *  androidx.core.graphics.drawable.a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 */
package b.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;

class b
extends Drawable
implements Drawable.Callback {
    private c f;
    private Rect g;
    private Drawable h;
    private Drawable i;
    private int j = 255;
    private boolean k;
    private int l = -1;
    private boolean m;
    private Runnable n;
    private long o;
    private long p;
    private b q;

    b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(Drawable drawable) {
        if (this.q == null) {
            this.q = new b();
        }
        drawable.setCallback((Drawable.Callback)this.q.b(drawable.getCallback()));
        try {
            if (this.f.A <= 0 && this.k) {
                drawable.setAlpha(this.j);
            }
            c c2 = this.f;
            if (c2.E) {
                drawable.setColorFilter(c2.D);
            } else {
                if (c2.H) {
                    androidx.core.graphics.drawable.a.o((Drawable)drawable, (ColorStateList)c2.F);
                }
                c c3 = this.f;
                if (c3.I) {
                    androidx.core.graphics.drawable.a.p((Drawable)drawable, (PorterDuff.Mode)c3.G);
                }
            }
            drawable.setVisible(this.isVisible(), true);
            drawable.setDither(this.f.x);
            drawable.setState(this.getState());
            drawable.setLevel(this.getLevel());
            drawable.setBounds(this.getBounds());
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 23) {
                drawable.setLayoutDirection(this.getLayoutDirection());
            }
            if (n2 >= 19) {
                drawable.setAutoMirrored(this.f.C);
            }
            Rect rect = this.g;
            if (n2 < 21) return;
            if (rect == null) return;
            drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            return;
        }
        finally {
            drawable.setCallback(this.q.a());
        }
    }

    private boolean e() {
        return this.isAutoMirrored() && androidx.core.graphics.drawable.a.f((Drawable)this) == 1;
    }

    static int f(Resources resources, int n2) {
        if (resources != null) {
            n2 = resources.getDisplayMetrics().densityDpi;
        }
        if (n2 == 0) {
            n2 = 160;
        }
        return n2;
    }

    void a(boolean bl) {
        long l2;
        boolean bl2;
        block8 : {
            boolean bl3;
            block6 : {
                block5 : {
                    long l3;
                    Drawable drawable;
                    block7 : {
                        block4 : {
                            block2 : {
                                block1 : {
                                    long l4;
                                    Drawable drawable2;
                                    block3 : {
                                        this.k = bl2 = true;
                                        l2 = SystemClock.uptimeMillis();
                                        drawable2 = this.h;
                                        if (drawable2 == null) break block1;
                                        l4 = this.o;
                                        if (l4 == 0L) break block2;
                                        if (l4 > l2) break block3;
                                        drawable2.setAlpha(this.j);
                                        this.o = 0L;
                                        break block2;
                                    }
                                    drawable2.setAlpha((255 - (int)(255L * (l4 - l2)) / this.f.A) * this.j / 255);
                                    bl3 = true;
                                    break block4;
                                }
                                this.o = 0L;
                            }
                            bl3 = false;
                        }
                        drawable = this.i;
                        if (drawable == null) break block5;
                        l3 = this.p;
                        if (l3 == 0L) break block6;
                        if (l3 > l2) break block7;
                        drawable.setVisible(false, false);
                        this.i = null;
                        this.p = 0L;
                        break block6;
                    }
                    drawable.setAlpha((int)(255L * (l3 - l2)) / this.f.B * this.j / 255);
                    break block8;
                }
                this.p = 0L;
            }
            bl2 = bl3;
        }
        if (bl && bl2) {
            this.scheduleSelf(this.n, l2 + 16L);
        }
    }

    public void applyTheme(Resources.Theme theme) {
        this.f.b(theme);
    }

    c b() {
        throw null;
    }

    int c() {
        return this.l;
    }

    public boolean canApplyTheme() {
        return this.f.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if ((drawable = this.i) != null) {
            drawable.draw(canvas);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean g(int var1_1) {
        if (var1_1 == this.l) {
            return false;
        }
        var2_2 = SystemClock.uptimeMillis();
        if (this.f.B > 0) {
            var10_3 = this.i;
            if (var10_3 != null) {
                var10_3.setVisible(false, false);
            }
            if ((var11_4 = this.h) != null) {
                this.i = var11_4;
                this.p = var2_2 + (long)this.f.B;
            } else {
                this.i = null;
                this.p = 0L;
            }
        } else {
            var4_5 = this.h;
            if (var4_5 != null) {
                var4_5.setVisible(false, false);
            }
        }
        if (var1_1 < 0) ** GOTO lbl-1000
        var6_6 = this.f;
        if (var1_1 < var6_6.h) {
            this.h = var7_7 = var6_6.g(var1_1);
            this.l = var1_1;
            if (var7_7 != null) {
                var8_8 = this.f.A;
                if (var8_8 > 0) {
                    this.o = var2_2 + (long)var8_8;
                }
                this.d(var7_7);
            }
        } else lbl-1000: // 2 sources:
        {
            this.h = null;
            this.l = -1;
        }
        if (this.o != 0L || this.p != 0L) {
            var5_9 = this.n;
            if (var5_9 == null) {
                this.n = new Runnable(){

                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                this.unscheduleSelf(var5_9);
            }
            this.a(true);
        }
        this.invalidateSelf();
        return true;
    }

    public int getAlpha() {
        return this.j;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.f.c()) {
            this.f.d = this.getChangingConfigurations();
            return this.f;
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.h;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.g;
        if (rect2 != null) {
            rect.set(rect2);
            return;
        }
        super.getHotspotBounds(rect);
    }

    public int getIntrinsicHeight() {
        if (this.f.q()) {
            return this.f.i();
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f.q()) {
            return this.f.m();
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f.q()) {
            return this.f.j();
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f.q()) {
            return this.f.k();
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.h;
        if (drawable != null && drawable.isVisible()) {
            return this.f.n();
        }
        return -2;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean bl;
        Rect rect2 = this.f.l();
        if (rect2 != null) {
            rect.set(rect2);
            bl = (rect2.left | rect2.top | rect2.bottom | rect2.right) != 0;
        } else {
            Drawable drawable = this.h;
            bl = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.e()) {
            int n2 = rect.left;
            rect.left = rect.right;
            rect.right = n2;
        }
        return bl;
    }

    void h(c c2) {
        this.f = c2;
        int n2 = this.l;
        if (n2 >= 0) {
            Drawable drawable;
            this.h = drawable = c2.g(n2);
            if (drawable != null) {
                this.d(drawable);
            }
        }
        this.i = null;
    }

    final void i(Resources resources) {
        this.f.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c c2 = this.f;
        if (c2 != null) {
            c2.p();
        }
        if (drawable == this.h && this.getCallback() != null) {
            this.getCallback().invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f.C;
    }

    public void jumpToCurrentState() {
        boolean bl;
        Drawable drawable = this.i;
        boolean bl2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.i = null;
            bl = true;
        } else {
            bl = false;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.k) {
                this.h.setAlpha(this.j);
            }
        }
        if (this.p != 0L) {
            this.p = 0L;
            bl = true;
        }
        if (this.o != 0L) {
            this.o = 0L;
        } else {
            bl2 = bl;
        }
        if (bl2) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.m && super.mutate() == this) {
            c c2 = this.b();
            c2.r();
            this.h(c2);
            this.m = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable;
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
        if ((drawable = this.h) != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n2) {
        return this.f.w(n2, this.c());
    }

    protected boolean onLevelChange(int n2) {
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            return drawable2.setLevel(n2);
        }
        return false;
    }

    protected boolean onStateChange(int[] arrn) {
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            return drawable2.setState(arrn);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        if (drawable == this.h && this.getCallback() != null) {
            this.getCallback().scheduleDrawable((Drawable)this, runnable, l2);
        }
    }

    public void setAlpha(int n2) {
        if (!this.k || this.j != n2) {
            this.k = true;
            this.j = n2;
            Drawable drawable = this.h;
            if (drawable != null) {
                if (this.o == 0L) {
                    drawable.setAlpha(n2);
                    return;
                }
                this.a(false);
            }
        }
    }

    public void setAutoMirrored(boolean bl) {
        c c2 = this.f;
        if (c2.C != bl) {
            c2.C = bl;
            Drawable drawable = this.h;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j((Drawable)drawable, (boolean)bl);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c c2 = this.f;
        c2.E = true;
        if (c2.D != colorFilter) {
            c2.D = colorFilter;
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean bl) {
        c c2 = this.f;
        if (c2.x != bl) {
            c2.x = bl;
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setDither(bl);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k((Drawable)drawable, (float)f2, (float)f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        Rect rect = this.g;
        if (rect == null) {
            this.g = new Rect(n2, n3, n4, n5);
        } else {
            rect.set(n2, n3, n4, n5);
        }
        Drawable drawable = this.h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l((Drawable)drawable, (int)n2, (int)n3, (int)n4, (int)n5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c c2 = this.f;
        c2.H = true;
        if (c2.F != colorStateList) {
            c2.F = colorStateList;
            androidx.core.graphics.drawable.a.o((Drawable)this.h, (ColorStateList)colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c c2 = this.f;
        c2.I = true;
        if (c2.G != mode) {
            c2.G = mode;
            androidx.core.graphics.drawable.a.p((Drawable)this.h, (PorterDuff.Mode)mode);
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Drawable drawable;
        boolean bl3 = super.setVisible(bl, bl2);
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setVisible(bl, bl2);
        }
        if ((drawable = this.h) != null) {
            drawable.setVisible(bl, bl2);
        }
        return bl3;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.h && this.getCallback() != null) {
            this.getCallback().unscheduleDrawable((Drawable)this, runnable);
        }
    }

    static class b
    implements Drawable.Callback {
        private Drawable.Callback f;

        b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f;
            this.f = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
            Drawable.Callback callback = this.f;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, l2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class c
    extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;
        final b a;
        Resources b;
        int c = 160;
        int d;
        int e;
        SparseArray<Drawable.ConstantState> f;
        Drawable[] g;
        int h;
        boolean i;
        boolean j;
        Rect k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        c(c c2, b b2, Resources resources) {
            int n2;
            int n3 = 0;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = b2;
            Object object = resources != null ? resources : (c2 != null ? c2.b : null);
            this.b = object;
            int n4 = c2 != null ? c2.c : 0;
            this.c = n2 = b.f(resources, n4);
            if (c2 != null) {
                this.d = c2.d;
                this.e = c2.e;
                this.v = true;
                this.w = true;
                this.i = c2.i;
                this.l = c2.l;
                this.x = c2.x;
                this.y = c2.y;
                this.z = c2.z;
                this.A = c2.A;
                this.B = c2.B;
                this.C = c2.C;
                this.D = c2.D;
                this.E = c2.E;
                this.F = c2.F;
                this.G = c2.G;
                this.H = c2.H;
                this.I = c2.I;
                if (c2.c == n2) {
                    if (c2.j) {
                        this.k = new Rect(c2.k);
                        this.j = true;
                    }
                    if (c2.m) {
                        this.n = c2.n;
                        this.o = c2.o;
                        this.p = c2.p;
                        this.q = c2.q;
                        this.m = true;
                    }
                }
                if (c2.r) {
                    this.s = c2.s;
                    this.r = true;
                }
                if (c2.t) {
                    this.u = c2.u;
                    this.t = true;
                }
                Drawable[] arrdrawable = c2.g;
                this.g = new Drawable[arrdrawable.length];
                this.h = c2.h;
                SparseArray<Drawable.ConstantState> sparseArray = c2.f;
                this.f = sparseArray != null ? sparseArray.clone() : new SparseArray(this.h);
                int n5 = this.h;
                while (n3 < n5) {
                    if (arrdrawable[n3] != null) {
                        Drawable.ConstantState constantState = arrdrawable[n3].getConstantState();
                        if (constantState != null) {
                            this.f.put(n3, (Object)constantState);
                        } else {
                            this.g[n3] = arrdrawable[n3];
                        }
                    }
                    ++n3;
                }
            } else {
                this.g = new Drawable[10];
                this.h = 0;
            }
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int n2 = sparseArray.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3 = this.f.keyAt(i2);
                    Drawable.ConstantState constantState = (Drawable.ConstantState)this.f.valueAt(i2);
                    this.g[n3] = this.s(constantState.newDrawable(this.b));
                }
                this.f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable drawable2 = drawable.mutate();
            drawable2.setCallback((Drawable.Callback)this.a);
            return drawable2;
        }

        public final int a(Drawable drawable) {
            int n2 = this.h;
            if (n2 >= this.g.length) {
                this.o(n2, n2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback((Drawable.Callback)this.a);
            this.g[n2] = drawable;
            this.h = 1 + this.h;
            this.e |= drawable.getChangingConfigurations();
            this.p();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return n2;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                this.e();
                int n2 = this.h;
                Drawable[] arrdrawable = this.g;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (arrdrawable[i2] == null || !arrdrawable[i2].canApplyTheme()) continue;
                    arrdrawable[i2].applyTheme(theme);
                    this.e |= arrdrawable[i2].getChangingConfigurations();
                }
                this.y(theme.getResources());
            }
        }

        public boolean c() {
            c c2 = this;
            synchronized (c2) {
                block7 : {
                    if (!this.v) break block7;
                    boolean bl = this.w;
                    return bl;
                }
                this.e();
                this.v = true;
                int n2 = this.h;
                Drawable[] arrdrawable = this.g;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (arrdrawable[i2].getConstantState() != null) continue;
                    this.w = false;
                    return false;
                }
                this.w = true;
                return true;
            }
        }

        public boolean canApplyTheme() {
            int n2 = this.h;
            Drawable[] arrdrawable = this.g;
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable.ConstantState constantState;
                Drawable drawable = arrdrawable[i2];
                if (!(drawable != null ? drawable.canApplyTheme() : (constantState = (Drawable.ConstantState)this.f.get(i2)) != null && constantState.canApplyTheme())) continue;
                return true;
            }
            return false;
        }

        protected void d() {
            this.m = true;
            this.e();
            int n2 = this.h;
            Drawable[] arrdrawable = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3;
                int n4;
                int n5;
                Drawable drawable = arrdrawable[i2];
                int n6 = drawable.getIntrinsicWidth();
                if (n6 > this.n) {
                    this.n = n6;
                }
                if ((n3 = drawable.getIntrinsicHeight()) > this.o) {
                    this.o = n3;
                }
                if ((n5 = drawable.getMinimumWidth()) > this.p) {
                    this.p = n5;
                }
                if ((n4 = drawable.getMinimumHeight()) <= this.q) continue;
                this.q = n4;
            }
        }

        final int f() {
            return this.g.length;
        }

        public final Drawable g(int n2) {
            int n3;
            Drawable drawable = this.g[n2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null && (n3 = sparseArray.indexOfKey(n2)) >= 0) {
                Drawable drawable2;
                this.g[n2] = drawable2 = this.s(((Drawable.ConstantState)this.f.valueAt(n3)).newDrawable(this.b));
                this.f.removeAt(n3);
                if (this.f.size() == 0) {
                    this.f = null;
                }
                return drawable2;
            }
            return null;
        }

        public int getChangingConfigurations() {
            return this.d | this.e;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            if (!this.m) {
                this.d();
            }
            return this.o;
        }

        public final int j() {
            if (!this.m) {
                this.d();
            }
            return this.q;
        }

        public final int k() {
            if (!this.m) {
                this.d();
            }
            return this.p;
        }

        public final Rect l() {
            boolean bl = this.i;
            Rect rect = null;
            if (bl) {
                return null;
            }
            Rect rect2 = this.k;
            if (rect2 == null) {
                if (this.j) {
                    return rect2;
                }
                this.e();
                Rect rect3 = new Rect();
                int n2 = this.h;
                Drawable[] arrdrawable = this.g;
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3;
                    int n4;
                    int n5;
                    int n6;
                    if (!arrdrawable[i2].getPadding(rect3)) continue;
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    if ((n5 = rect3.left) > rect.left) {
                        rect.left = n5;
                    }
                    if ((n3 = rect3.top) > rect.top) {
                        rect.top = n3;
                    }
                    if ((n4 = rect3.right) > rect.right) {
                        rect.right = n4;
                    }
                    if ((n6 = rect3.bottom) <= rect.bottom) continue;
                    rect.bottom = n6;
                }
                this.j = true;
                this.k = rect;
                return rect;
            }
            return rect2;
        }

        public final int m() {
            if (!this.m) {
                this.d();
            }
            return this.n;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            this.e();
            int n2 = this.h;
            Drawable[] arrdrawable = this.g;
            int n3 = n2 > 0 ? arrdrawable[0].getOpacity() : -2;
            for (int i2 = 1; i2 < n2; ++i2) {
                n3 = Drawable.resolveOpacity((int)n3, (int)arrdrawable[i2].getOpacity());
            }
            this.s = n3;
            this.r = true;
            return n3;
        }

        public void o(int n2, int n3) {
            Drawable[] arrdrawable = new Drawable[n3];
            System.arraycopy((Object)this.g, (int)0, (Object)arrdrawable, (int)0, (int)n2);
            this.g = arrdrawable;
        }

        void p() {
            this.r = false;
            this.t = false;
        }

        public final boolean q() {
            return this.l;
        }

        abstract void r();

        public final void t(boolean bl) {
            this.l = bl;
        }

        public final void u(int n2) {
            this.A = n2;
        }

        public final void v(int n2) {
            this.B = n2;
        }

        final boolean w(int n2, int n3) {
            int n4 = this.h;
            Drawable[] arrdrawable = this.g;
            boolean bl = false;
            for (int i2 = 0; i2 < n4; ++i2) {
                if (arrdrawable[i2] == null) continue;
                boolean bl2 = Build.VERSION.SDK_INT >= 23 ? arrdrawable[i2].setLayoutDirection(n2) : false;
                if (i2 != n3) continue;
                bl = bl2;
            }
            this.z = n2;
            return bl;
        }

        public final void x(boolean bl) {
            this.i = bl;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.b = resources;
                int n2 = b.f(resources, this.c);
                int n3 = this.c;
                this.c = n2;
                if (n3 != n2) {
                    this.m = false;
                    this.j = false;
                }
            }
        }
    }

}

