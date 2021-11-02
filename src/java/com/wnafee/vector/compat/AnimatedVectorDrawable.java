/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  b.e.a
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.wnafee.vector.compat;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b.e.a;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.AnimatedVectorDrawable;
import com.wnafee.vector.compat.DrawableCompat;
import com.wnafee.vector.compat.Outline;
import com.wnafee.vector.compat.PathAnimatorInflater;
import com.wnafee.vector.compat.Tintable;
import com.wnafee.vector.compat.VectorDrawable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawable
extends DrawableCompat
implements Animatable,
Tintable {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = AnimatedVectorDrawable.class.getSimpleName();
    private static final String TARGET = "target";
    private AnimatedVectorDrawableState mAnimatedVectorState;
    private boolean mMutated;

    public AnimatedVectorDrawable() {
        this.mAnimatedVectorState = new Drawable.ConstantState(null){
            ArrayList<Animator> mAnimators;
            int mChangingConfigurations;
            a<Animator, String> mTargetNameMap;
            VectorDrawable mVectorDrawable;
            {
                if (animatedVectorDrawableState != null) {
                    ArrayList<Animator> arrayList;
                    this.mChangingConfigurations = animatedVectorDrawableState.mChangingConfigurations;
                    VectorDrawable vectorDrawable = animatedVectorDrawableState.mVectorDrawable;
                    int n2 = 0;
                    if (vectorDrawable != null) {
                        VectorDrawable vectorDrawable2;
                        this.mVectorDrawable = vectorDrawable2 = (VectorDrawable)vectorDrawable.getConstantState().newDrawable();
                        vectorDrawable2.mutate();
                        this.mVectorDrawable.setAllowCaching(false);
                        this.mVectorDrawable.setBounds(animatedVectorDrawableState.mVectorDrawable.getBounds());
                    }
                    if ((arrayList = animatedVectorDrawableState.mAnimators) != null) {
                        int n3 = arrayList.size();
                        this.mAnimators = new ArrayList(n3);
                        this.mTargetNameMap = new a(n3);
                        while (n2 < n3) {
                            Animator animator = (Animator)animatedVectorDrawableState.mAnimators.get(n2);
                            Animator animator2 = animator.clone();
                            String string = (String)animatedVectorDrawableState.mTargetNameMap.get((Object)animator);
                            animator2.setTarget(this.mVectorDrawable.getTargetByName(string));
                            this.mAnimators.add((Object)animator2);
                            this.mTargetNameMap.put((Object)animator2, (Object)string);
                            ++n2;
                        }
                    }
                } else {
                    this.mVectorDrawable = new VectorDrawable();
                }
            }

            public int getChangingConfigurations() {
                return this.mChangingConfigurations;
            }

            public Drawable newDrawable() {
                return new AnimatedVectorDrawable(this, null, null);
            }

            public Drawable newDrawable(Resources resources) {
                return new AnimatedVectorDrawable(this, resources, null);
            }

            public Drawable newDrawable(Resources resources, Resources.Theme theme) {
                return new AnimatedVectorDrawable(this, resources, theme);
            }
        };
    }

    private AnimatedVectorDrawable(AnimatedVectorDrawableState animatedVectorDrawableState, Resources resources, Resources.Theme theme) {
        this.mAnimatedVectorState = new /* invalid duplicate definition of identical inner class */;
        if (theme != null && this.canApplyTheme()) {
            this.applyTheme(theme);
        }
    }

    public static boolean canReverse(Animator animator) {
        if (animator instanceof AnimatorSet) {
            Iterator iterator = ((AnimatorSet)animator).getChildAnimations().iterator();
            while (iterator.hasNext()) {
                if (AnimatedVectorDrawable.canReverse((Animator)iterator.next())) continue;
                return false;
            }
        } else if (animator instanceof ValueAnimator) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AnimatedVectorDrawable create(Context context, Resources resources, int n2) {
        block6 : {
            int n3;
            XmlResourceParser xmlResourceParser = resources.getXml(n2);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
            }
            if (n3 != 2) throw new XmlPullParserException("No start tag found");
            if (!ANIMATED_VECTOR.equals((Object)xmlResourceParser.getName())) break block6;
            AnimatedVectorDrawable animatedVectorDrawable = new AnimatedVectorDrawable();
            animatedVectorDrawable.inflate(context, resources, (XmlPullParser)xmlResourceParser, attributeSet, null);
            return animatedVectorDrawable;
        }
        try {
            throw new IllegalArgumentException("root node must start with: animated-vector");
        }
        catch (IOException iOException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)iOException);
            return null;
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static AnimatedVectorDrawable getDrawable(Context context, int n2) {
        return AnimatedVectorDrawable.create(context, context.getResources(), n2);
    }

    private boolean isStarted() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((Animator)arrayList.get(i2)).isStarted()) continue;
            return true;
        }
        return false;
    }

    private void reverse(Animator animator) {
        if (animator instanceof AnimatorSet) {
            Iterator iterator = ((AnimatorSet)animator).getChildAnimations().iterator();
            while (iterator.hasNext()) {
                this.reverse((Animator)iterator.next());
            }
        } else if (animator instanceof ValueAnimator) {
            ((ValueAnimator)animator).reverse();
        }
    }

    private void setupAnimatorsForTarget(String string, Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(string));
        AnimatedVectorDrawableState animatedVectorDrawableState = this.mAnimatedVectorState;
        if (animatedVectorDrawableState.mAnimators == null) {
            animatedVectorDrawableState.mAnimators = new ArrayList();
            this.mAnimatedVectorState.mTargetNameMap = new a();
        }
        this.mAnimatedVectorState.mAnimators.add((Object)animator);
        this.mAnimatedVectorState.mTargetNameMap.put((Object)animator, (Object)string);
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable.super.applyTheme(theme);
        VectorDrawable vectorDrawable = this.mAnimatedVectorState.mVectorDrawable;
        if (vectorDrawable != null && vectorDrawable.canApplyTheme()) {
            vectorDrawable.applyTheme(theme);
        }
    }

    @Override
    public boolean canApplyTheme() {
        VectorDrawable vectorDrawable;
        AnimatedVectorDrawableState animatedVectorDrawableState;
        return super.canApplyTheme() || (animatedVectorDrawableState = this.mAnimatedVectorState) != null && (vectorDrawable = animatedVectorDrawableState.mVectorDrawable) != null && vectorDrawable.canApplyTheme();
        {
        }
    }

    public boolean canReverse() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (AnimatedVectorDrawable.canReverse((Animator)arrayList.get(i2))) continue;
            return false;
        }
        return true;
    }

    public void draw(Canvas canvas) {
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (this.isStarted()) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        return Drawable.super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        this.mAnimatedVectorState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mAnimatedVectorState;
    }

    public int getIntrinsicHeight() {
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override
    public void getOutline(Outline outline) {
        this.mAnimatedVectorState.mVectorDrawable.getOutline(outline);
    }

    Animator getPathAnimator(Context context, Resources resources, Resources.Theme theme, int n2, float f3) {
        return PathAnimatorInflater.loadAnimator(context, resources, theme, n2, f3);
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n2 = xmlPullParser.getEventType();
        float f3 = 1.0f;
        while (n2 != 1) {
            if (n2 == 2) {
                String string = xmlPullParser.getName();
                if (ANIMATED_VECTOR.equals((Object)string)) {
                    TypedArray typedArray = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedVectorDrawable);
                    int n3 = typedArray.getResourceId(R.styleable.AnimatedVectorDrawable_android_drawable, 0);
                    if (n3 != 0) {
                        VectorDrawable vectorDrawable = (VectorDrawable)VectorDrawable.create(resources, n3).mutate();
                        vectorDrawable.setAllowCaching(false);
                        f3 = vectorDrawable.getPixelSize();
                        this.mAnimatedVectorState.mVectorDrawable = vectorDrawable;
                    }
                    typedArray.recycle();
                } else if (TARGET.equals((Object)string)) {
                    TypedArray typedArray = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedVectorDrawableTarget);
                    String string2 = typedArray.getString(R.styleable.AnimatedVectorDrawableTarget_android_name);
                    int n4 = typedArray.getResourceId(R.styleable.AnimatedVectorDrawableTarget_android_animation, 0);
                    if (n4 != 0) {
                        Animator animator = this.isPath(string2) ? this.getPathAnimator(context, resources, theme, n4, f3) : AnimatorInflater.loadAnimator((Context)context, (int)n4);
                        this.setupAnimatorsForTarget(string2, animator);
                    }
                    typedArray.recycle();
                }
            }
            n2 = xmlPullParser.next();
        }
    }

    public boolean isPath(String string) {
        return this.mAnimatedVectorState.mVectorDrawable.getTargetByName(string) instanceof VectorDrawable.VFullPath;
    }

    public boolean isRunning() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((Animator)arrayList.get(i2)).isRunning()) continue;
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public Drawable mutate() {
        if (!this.mMutated && Drawable.super.mutate() == this) {
            this.mAnimatedVectorState.mVectorDrawable.mutate();
            this.mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }

    protected boolean onLevelChange(int n2) {
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(n2);
    }

    protected boolean onStateChange(int[] arrn) {
        return this.mAnimatedVectorState.mVectorDrawable.setState(arrn);
    }

    public void reverse() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Animator animator = (Animator)arrayList.get(i2);
            if (AnimatedVectorDrawable.canReverse(animator)) {
                this.reverse(animator);
                continue;
            }
            Log.w((String)LOGTAG, (String)"AnimatedVectorDrawable can't reverse()");
        }
    }

    public void setAlpha(int n2) {
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }

    @Override
    public void setHotspot(float f3, float f4) {
        this.mAnimatedVectorState.mVectorDrawable.setHotspot(f3, f4);
    }

    @Override
    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        this.mAnimatedVectorState.mVectorDrawable.setHotspotBounds(n2, n3, n4, n5);
    }

    @Override
    public void setLayoutDirection(int n2) {
        this.mAnimatedVectorState.mVectorDrawable.setLayoutDirection(n2);
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        this.mAnimatedVectorState.mVectorDrawable.setVisible(bl, bl2);
        return Drawable.super.setVisible(bl, bl2);
    }

    public void start() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Animator animator = (Animator)arrayList.get(i2);
            if (animator.isStarted()) continue;
            animator.start();
        }
        this.invalidateSelf();
    }

    public void stop() {
        ArrayList<Animator> arrayList = this.mAnimatedVectorState.mAnimators;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((Animator)arrayList.get(i2)).end();
        }
    }

}

