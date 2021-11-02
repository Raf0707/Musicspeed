/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  androidx.core.graphics.drawable.a
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package b.x.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import b.i.h.d.g;
import b.x.a.a.c;
import b.x.a.a.e;
import b.x.a.a.h;
import b.x.a.a.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c
extends h
implements Animatable {
    private b g;
    private Context h;
    private ArgbEvaluator i = null;
    private Animator.AnimatorListener j = null;
    ArrayList<b.x.a.a.b> k = null;
    final Drawable.Callback l;

    c() {
        this(null, null, null);
    }

    private c(Context context) {
        this(context, null, null);
    }

    private c(Context context, b b2, Resources resources) {
        Drawable.Callback callback;
        this.l = callback = new Drawable.Callback(this){
            final /* synthetic */ c f;
            {
                this.f = c2;
            }

            public void invalidateDrawable(Drawable drawable) {
                this.f.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, java.lang.Runnable runnable, long l2) {
                this.f.scheduleSelf(runnable, l2);
            }

            public void unscheduleDrawable(Drawable drawable, java.lang.Runnable runnable) {
                this.f.unscheduleSelf(runnable);
            }
        };
        this.h = context;
        if (b2 != null) {
            this.g = b2;
            return;
        }
        this.g = new Drawable.ConstantState(context, b2, callback, resources){
            int a;
            i b;
            AnimatorSet c;
            ArrayList<Animator> d;
            b.e.a<Animator, String> e;
            {
                if (b2 != null) {
                    ArrayList<Animator> arrayList;
                    this.a = b2.a;
                    i i2 = b2.b;
                    int n2 = 0;
                    if (i2 != null) {
                        i i3;
                        Drawable.ConstantState constantState = i2.getConstantState();
                        this.b = resources != null ? (i)constantState.newDrawable(resources) : (i)constantState.newDrawable();
                        this.b = i3 = (i)this.b.mutate();
                        i3.setCallback(callback);
                        this.b.setBounds(b2.b.getBounds());
                        this.b.h(false);
                    }
                    if ((arrayList = b2.d) != null) {
                        int n3 = arrayList.size();
                        this.d = new ArrayList(n3);
                        this.e = new b.e.a(n3);
                        while (n2 < n3) {
                            Animator animator = (Animator)b2.d.get(n2);
                            Animator animator2 = animator.clone();
                            String string = (String)b2.e.get((Object)animator);
                            animator2.setTarget(this.b.d(string));
                            this.d.add((Object)animator2);
                            this.e.put(animator2, string);
                            ++n2;
                        }
                        this.a();
                    }
                }
            }

            public void a() {
                if (this.c == null) {
                    this.c = new AnimatorSet();
                }
                this.c.playTogether(this.d);
            }

            public int getChangingConfigurations() {
                return this.a;
            }

            public Drawable newDrawable() {
                throw new IllegalStateException("No constant state support for SDK < 24.");
            }

            public Drawable newDrawable(Resources resources) {
                throw new IllegalStateException("No constant state support for SDK < 24.");
            }
        };
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c c2 = new c(context);
        c2.inflate(resources, xmlPullParser, attributeSet, theme);
        return c2;
    }

    private void b(String string, Animator animator) {
        animator.setTarget(this.g.b.d(string));
        if (Build.VERSION.SDK_INT < 21) {
            this.c(animator);
        }
        b b2 = this.g;
        if (b2.d == null) {
            b2.d = new ArrayList();
            this.g.e = new b.e.a();
        }
        this.g.d.add((Object)animator);
        this.g.e.put(animator, string);
    }

    private void c(Animator animator) {
        ObjectAnimator objectAnimator;
        String string;
        ArrayList arrayList;
        if (animator instanceof AnimatorSet && (arrayList = ((AnimatorSet)animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                this.c((Animator)arrayList.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator && ("fillColor".equals((Object)(string = (objectAnimator = (ObjectAnimator)animator).getPropertyName())) || "strokeColor".equals((Object)string))) {
            if (this.i == null) {
                this.i = new ArgbEvaluator();
            }
            objectAnimator.setEvaluator((TypeEvaluator)this.i);
        }
    }

    @Override
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a((Drawable)drawable, (Resources.Theme)theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b((Drawable)drawable);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.g.b.draw(canvas);
        if (this.g.c.isStarted()) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d((Drawable)drawable);
        }
        return this.g.b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return Drawable.super.getChangingConfigurations() | this.g.a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e((Drawable)drawable);
        }
        return this.g.b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f != null && Build.VERSION.SDK_INT >= 24) {
            return new Drawable.ConstantState(this.f.getConstantState()){
                private final Drawable.ConstantState a;
                {
                    this.a = constantState;
                }

                public boolean canApplyTheme() {
                    return this.a.canApplyTheme();
                }

                public int getChangingConfigurations() {
                    return this.a.getChangingConfigurations();
                }

                public Drawable newDrawable() {
                    Drawable drawable;
                    c c2 = new c();
                    c2.f = drawable = this.a.newDrawable();
                    drawable.setCallback(c2.l);
                    return c2;
                }

                public Drawable newDrawable(Resources resources) {
                    Drawable drawable;
                    c c2 = new c();
                    c2.f = drawable = this.a.newDrawable(resources);
                    drawable.setCallback(c2.l);
                    return c2;
                }

                public Drawable newDrawable(Resources resources, Resources.Theme theme) {
                    Drawable drawable;
                    c c2 = new c();
                    c2.f = drawable = this.a.newDrawable(resources, theme);
                    drawable.setCallback(c2.l);
                    return c2;
                }
            };
        }
        return null;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.g.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.g.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.g.b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g((Drawable)drawable, (Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
            return;
        }
        int n2 = xmlPullParser.getEventType();
        int n3 = 1 + xmlPullParser.getDepth();
        while (n2 != 1 && (xmlPullParser.getDepth() >= n3 || n2 != 3)) {
            if (n2 == 2) {
                String string = xmlPullParser.getName();
                if ("animated-vector".equals((Object)string)) {
                    TypedArray typedArray = g.s(resources, theme, attributeSet, b.x.a.a.a.e);
                    int n4 = typedArray.getResourceId(0, 0);
                    if (n4 != 0) {
                        i i2 = i.b(resources, n4, theme);
                        i2.h(false);
                        i2.setCallback(this.l);
                        i i3 = this.g.b;
                        if (i3 != null) {
                            i3.setCallback(null);
                        }
                        this.g.b = i2;
                    }
                    typedArray.recycle();
                } else if ("target".equals((Object)string)) {
                    TypedArray typedArray = resources.obtainAttributes(attributeSet, b.x.a.a.a.f);
                    String string2 = typedArray.getString(0);
                    int n5 = typedArray.getResourceId(1, 0);
                    if (n5 != 0) {
                        Context context = this.h;
                        if (context != null) {
                            this.b(string2, e.i(context, n5));
                        } else {
                            typedArray.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    typedArray.recycle();
                }
            }
            n2 = xmlPullParser.next();
        }
        this.g.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h((Drawable)drawable);
        }
        return this.g.b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return ((AnimatedVectorDrawable)drawable).isRunning();
        }
        return this.g.c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.g.b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
            return;
        }
        this.g.b.setBounds(rect);
    }

    @Override
    protected boolean onLevelChange(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        return this.g.b.setLevel(n2);
    }

    protected boolean onStateChange(int[] arrn) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(arrn);
        }
        return this.g.b.setState(arrn);
    }

    public void setAlpha(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAlpha(n2);
            return;
        }
        this.g.b.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j((Drawable)drawable, (boolean)bl);
            return;
        }
        this.g.b.setAutoMirrored(bl);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.g.b.setColorFilter(colorFilter);
    }

    public void setTint(int n2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n((Drawable)drawable, (int)n2);
            return;
        }
        this.g.b.setTint(n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o((Drawable)drawable, (ColorStateList)colorStateList);
            return;
        }
        this.g.b.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p((Drawable)drawable, (PorterDuff.Mode)mode);
            return;
        }
        this.g.b.setTintMode(mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setVisible(bl, bl2);
        }
        this.g.b.setVisible(bl, bl2);
        return Drawable.super.setVisible(bl, bl2);
    }

    public void start() {
        Drawable drawable = this.f;
        if (drawable != null) {
            ((AnimatedVectorDrawable)drawable).start();
            return;
        }
        if (this.g.c.isStarted()) {
            return;
        }
        this.g.c.start();
        this.invalidateSelf();
    }

    public void stop() {
        Drawable drawable = this.f;
        if (drawable != null) {
            ((AnimatedVectorDrawable)drawable).stop();
            return;
        }
        this.g.c.end();
    }

}

