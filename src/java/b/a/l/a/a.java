/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  androidx.appcompat.widget.f0
 *  androidx.core.graphics.drawable.b
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.a.l.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.f0;
import b.a.l.a.a;
import b.a.l.a.b;
import b.a.l.a.e;
import b.e.h;
import b.x.a.a.i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint(value={"RestrictedAPI"})
public class a
extends b.a.l.a.e
implements androidx.core.graphics.drawable.b {
    private static final String t = a.class.getSimpleName();
    private c u;
    private g v;
    private int w = -1;
    private int x = -1;
    private boolean y;

    public a() {
        this(null, null);
    }

    a(c c2, Resources resources) {
        super(null);
        this.h(new c(c2, this, resources));
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String string = xmlPullParser.getName();
        if (string.equals((Object)"animated-selector")) {
            a a2 = new a();
            a2.n(context, resources, xmlPullParser, attributeSet, theme);
            return a2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid animated-selector tag ");
        stringBuilder.append(string);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n2;
        int n3;
        int n4 = 1 + xmlPullParser.getDepth();
        while ((n3 = xmlPullParser.next()) != 1 && ((n2 = xmlPullParser.getDepth()) >= n4 || n3 != 3)) {
            if (n3 != 2 || n2 > n4) continue;
            if (xmlPullParser.getName().equals((Object)"item")) {
                this.q(context, resources, xmlPullParser, attributeSet, theme);
                continue;
            }
            if (!xmlPullParser.getName().equals((Object)"transition")) continue;
            this.r(context, resources, xmlPullParser, attributeSet, theme);
        }
    }

    private void p() {
        this.onStateChange(this.getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.a.m.b.h);
        int n2 = typedArray.getResourceId(b.a.m.b.i, 0);
        int n3 = typedArray.getResourceId(b.a.m.b.j, -1);
        Drawable drawable = n3 > 0 ? f0.h().j(context, n3) : null;
        typedArray.recycle();
        int[] arrn = this.k(attributeSet);
        if (drawable == null) {
            int n4;
            while ((n4 = xmlPullParser.next()) == 4) {
            }
            if (n4 == 2) {
                drawable = xmlPullParser.getName().equals((Object)"vector") ? i.c(resources, xmlPullParser, attributeSet, theme) : (Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xmlPullParser.getPositionDescription());
                stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(stringBuilder.toString());
            }
        }
        if (drawable != null) {
            return this.u.B(arrn, drawable, n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.a.m.b.k);
        int n2 = typedArray.getResourceId(b.a.m.b.n, -1);
        int n3 = typedArray.getResourceId(b.a.m.b.m, -1);
        int n4 = typedArray.getResourceId(b.a.m.b.l, -1);
        Drawable drawable = n4 > 0 ? f0.h().j(context, n4) : null;
        boolean bl = typedArray.getBoolean(b.a.m.b.o, false);
        typedArray.recycle();
        if (drawable == null) {
            int n5;
            while ((n5 = xmlPullParser.next()) == 4) {
            }
            if (n5 == 2) {
                drawable = xmlPullParser.getName().equals((Object)"animated-vector") ? b.x.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme) : (Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xmlPullParser.getPositionDescription());
                stringBuilder.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(stringBuilder.toString());
            }
        }
        if (drawable != null) {
            if (n2 != -1 && n3 != -1) {
                return this.u.C(n2, n3, drawable, bl);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(xmlPullParser.getPositionDescription());
            stringBuilder.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private boolean s(int n2) {
        block9 : {
            int n3;
            g g2;
            block11 : {
                Drawable drawable;
                block12 : {
                    block10 : {
                        g g3 = this.v;
                        if (g3 != null) {
                            if (n2 == this.w) {
                                return true;
                            }
                            if (n2 == this.x && g3.a()) {
                                g3.b();
                                this.w = this.x;
                                this.x = n2;
                                return true;
                            }
                            n3 = this.w;
                            g3.d();
                        } else {
                            n3 = this.c();
                        }
                        this.v = null;
                        this.x = -1;
                        this.w = -1;
                        c c2 = this.u;
                        int n4 = c2.E(n3);
                        int n5 = c2.E(n2);
                        if (n5 == 0) break block9;
                        if (n4 == 0) {
                            return false;
                        }
                        int n6 = c2.G(n4, n5);
                        if (n6 < 0) {
                            return false;
                        }
                        boolean bl = c2.I(n4, n5);
                        this.g(n6);
                        drawable = this.getCurrent();
                        if (!(drawable instanceof AnimationDrawable)) break block10;
                        boolean bl2 = c2.H(n4, n5);
                        g2 = new g((AnimationDrawable)drawable, bl2, bl){
                            private final ObjectAnimator a;
                            private final boolean b;
                            {
                                int n2 = animationDrawable.getNumberOfFrames();
                                int n3 = bl ? n2 - 1 : 0;
                                int n4 = bl ? 0 : n2 - 1;
                                TimeInterpolator timeInterpolator = new TimeInterpolator(animationDrawable, bl){
                                    private int[] a;
                                    private int b;
                                    private int c;
                                    {
                                        this.b(animationDrawable, bl);
                                    }

                                    int a() {
                                        return this.c;
                                    }

                                    int b(AnimationDrawable animationDrawable, boolean bl) {
                                        int n2;
                                        this.b = n2 = animationDrawable.getNumberOfFrames();
                                        int[] arrn = this.a;
                                        if (arrn == null || arrn.length < n2) {
                                            this.a = new int[n2];
                                        }
                                        int[] arrn2 = this.a;
                                        int n3 = 0;
                                        for (int i2 = 0; i2 < n2; ++i2) {
                                            int n4;
                                            int n5 = bl ? -1 + (n2 - i2) : i2;
                                            arrn2[i2] = n4 = animationDrawable.getDuration(n5);
                                            n3 += n4;
                                        }
                                        this.c = n3;
                                        return n3;
                                    }

                                    public float getInterpolation(float f2) {
                                        int n2;
                                        int n3 = (int)(0.5f + f2 * (float)this.c);
                                        int n4 = this.b;
                                        int[] arrn = this.a;
                                        for (n2 = 0; n2 < n4 && n3 >= arrn[n2]; n3 -= arrn[n2], ++n2) {
                                        }
                                        float f3 = n2 < n4 ? (float)n3 / (float)this.c : 0.0f;
                                        return f3 + (float)n2 / (float)n4;
                                    }
                                };
                                ObjectAnimator objectAnimator = ObjectAnimator.ofInt((Object)animationDrawable, (String)"currentIndex", (int[])new int[]{n3, n4});
                                if (Build.VERSION.SDK_INT >= 18) {
                                    objectAnimator.setAutoCancel(true);
                                }
                                objectAnimator.setDuration((long)timeInterpolator.a());
                                objectAnimator.setInterpolator(timeInterpolator);
                                this.b = bl2;
                                this.a = objectAnimator;
                            }

                            @Override
                            public boolean a() {
                                return this.b;
                            }

                            @Override
                            public void b() {
                                this.a.reverse();
                            }

                            @Override
                            public void c() {
                                this.a.start();
                            }

                            @Override
                            public void d() {
                                this.a.cancel();
                            }
                        };
                        break block11;
                    }
                    if (!(drawable instanceof b.x.a.a.c)) break block12;
                    g2 = new g((b.x.a.a.c)drawable){
                        private final b.x.a.a.c a;
                        {
                            this.a = c2;
                        }

                        @Override
                        public void c() {
                            this.a.start();
                        }

                        @Override
                        public void d() {
                            this.a.stop();
                        }
                    };
                    break block11;
                }
                if (!(drawable instanceof Animatable)) break block9;
                g2 = new g((Animatable)drawable){
                    private final Animatable a;
                    {
                        this.a = animatable;
                    }

                    @Override
                    public void c() {
                        this.a.start();
                    }

                    @Override
                    public void d() {
                        this.a.stop();
                    }
                };
            }
            g2.c();
            this.v = g2;
            this.x = n3;
            this.w = n2;
            return true;
        }
        return false;
    }

    private void t(TypedArray typedArray) {
        c c2 = this.u;
        if (Build.VERSION.SDK_INT >= 21) {
            c2.d |= typedArray.getChangingConfigurations();
        }
        c2.x(typedArray.getBoolean(b.a.m.b.d, c2.i));
        c2.t(typedArray.getBoolean(b.a.m.b.e, c2.l));
        c2.u(typedArray.getInt(b.a.m.b.f, c2.A));
        c2.v(typedArray.getInt(b.a.m.b.g, c2.B));
        this.setDither(typedArray.getBoolean(b.a.m.b.b, c2.x));
    }

    @Override
    void h(b.c c2) {
        super.h(c2);
        if (c2 instanceof c) {
            this.u = (c)c2;
        }
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public void jumpToCurrentState() {
        b.a.l.a.b.super.jumpToCurrentState();
        g g2 = this.v;
        if (g2 != null) {
            g2.d();
            this.v = null;
            this.g(this.w);
            this.w = -1;
            this.x = -1;
        }
    }

    c l() {
        return new c(this.u, this, null);
    }

    @Override
    public Drawable mutate() {
        if (!this.y && super.mutate() == this) {
            this.u.r();
            this.y = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArray = b.i.h.d.g.s(resources, theme, attributeSet, b.a.m.b.a);
        this.setVisible(typedArray.getBoolean(b.a.m.b.c, true), true);
        this.t(typedArray);
        this.i(resources);
        typedArray.recycle();
        this.o(context, resources, xmlPullParser, attributeSet, theme);
        this.p();
    }

    @Override
    protected boolean onStateChange(int[] arrn) {
        int n2 = this.u.F(arrn);
        boolean bl = n2 != this.c() && (this.s(n2) || this.g(n2));
        Drawable drawable = this.getCurrent();
        if (drawable != null) {
            bl |= drawable.setState(arrn);
        }
        return bl;
    }

    @Override
    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = b.a.l.a.b.super.setVisible(bl, bl2);
        g g2 = this.v;
        if (g2 != null && (bl3 || bl2)) {
            if (bl) {
                g2.c();
                return bl3;
            }
            this.jumpToCurrentState();
        }
        return bl3;
    }

    static class c
    extends e.a {
        b.e.d<Long> K;
        h<Integer> L;

        c(c c2, a a2, Resources resources) {
            super(c2, a2, resources);
            if (c2 != null) {
                this.K = c2.K;
                this.L = c2.L;
                return;
            }
            this.K = new b.e.d();
            this.L = new h();
        }

        private static long D(int n2, int n3) {
            return (long)n2 << 32 | (long)n3;
        }

        int B(int[] arrn, Drawable drawable, int n2) {
            int n3 = super.z(arrn, drawable);
            this.L.i(n3, n2);
            return n3;
        }

        int C(int n2, int n3, Drawable drawable, boolean bl) {
            int n4 = b.c.super.a(drawable);
            long l2 = c.D(n2, n3);
            long l3 = bl ? 0x200000000L : 0L;
            b.e.d<Long> d2 = this.K;
            long l4 = n4;
            d2.a(l2, l4 | l3);
            if (bl) {
                long l5 = c.D(n3, n2);
                this.K.a(l5, l3 | (0x100000000L | l4));
            }
            return n4;
        }

        int E(int n2) {
            if (n2 < 0) {
                return 0;
            }
            return this.L.f(n2, 0);
        }

        int F(int[] arrn) {
            int n2 = super.A(arrn);
            if (n2 >= 0) {
                return n2;
            }
            return super.A(StateSet.WILD_CARD);
        }

        int G(int n2, int n3) {
            long l2 = c.D(n2, n3);
            return (int)this.K.f(l2, -1L).longValue();
        }

        boolean H(int n2, int n3) {
            long l2 = c.D(n2, n3);
            return (0x100000000L & this.K.f(l2, -1L)) != 0L;
        }

        boolean I(int n2, int n3) {
            long l2 = c.D(n2, n3);
            return (0x200000000L & this.K.f(l2, -1L)) != 0L;
        }

        @Override
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        @Override
        void r() {
            this.K = this.K.c();
            this.L = this.L.c();
        }
    }

}

