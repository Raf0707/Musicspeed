/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  b.e.a
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Stack
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.wnafee.vector.compat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b.e.a;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.DrawableCompat;
import com.wnafee.vector.compat.PathParser;
import com.wnafee.vector.compat.Tintable;
import com.wnafee.vector.compat.VectorDrawable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawable
extends DrawableCompat
implements Tintable {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff.Mode DEFAULT_TINT_MODE;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final String LOGTAG;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching = true;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private VectorDrawableState mVectorState;

    static {
        LOGTAG = VectorDrawable.class.getSimpleName();
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public VectorDrawable() {
        this.mVectorState = new VectorDrawableState();
    }

    private VectorDrawable(VectorDrawableState vectorDrawableState, Resources resources, Resources.Theme theme) {
        if (theme != null && vectorDrawableState.canApplyTheme()) {
            this.mVectorState = new VectorDrawableState(vectorDrawableState);
            this.applyTheme(theme);
        } else {
            this.mVectorState = vectorDrawableState;
        }
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
    }

    private static int applyAlpha(int n2, float f3) {
        int n3 = Color.alpha((int)n2);
        return n2 & 16777215 | (int)(f3 * (float)n3) << 24;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static VectorDrawable create(Resources resources, int n2) {
        block6 : {
            int n3;
            XmlResourceParser xmlResourceParser = resources.getXml(n2);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n3 = xmlResourceParser.next()) != 2 && n3 != 1) {
            }
            if (n3 != 2) throw new XmlPullParserException("No start tag found");
            if (!SHAPE_VECTOR.equals((Object)xmlResourceParser.getName())) break block6;
            VectorDrawable vectorDrawable = new VectorDrawable();
            vectorDrawable.inflate(resources, (XmlPullParser)xmlResourceParser, attributeSet, null);
            return vectorDrawable;
        }
        try {
            throw new IllegalArgumentException("root node must start with: vector");
        }
        catch (IOException iOException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)iOException);
            return null;
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)xmlPullParserException);
            return null;
        }
    }

    public static int getChangingConfigurations(TypedArray typedArray) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getChangingConfigurations();
        }
        return 0;
    }

    public static VectorDrawable getDrawable(Context context, int n2) {
        return VectorDrawable.create(context.getResources(), n2);
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        Stack stack = new Stack();
        stack.push((Object)vPathRenderer.mRootGroup);
        int n2 = xmlPullParser.getEventType();
        boolean bl = true;
        while (n2 != 1) {
            if (n2 == 2) {
                String string2 = xmlPullParser.getName();
                VGroup vGroup = stack.peek();
                if (SHAPE_PATH.equals((Object)string2)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme);
                    vGroup.mChildren.add((Object)vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put((Object)vFullPath.getPathName(), (Object)vFullPath);
                    }
                    vectorDrawableState.mChangingConfigurations |= vFullPath.mChangingConfigurations;
                    bl = false;
                } else if (SHAPE_CLIP_PATH.equals((Object)string2)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme);
                    vGroup.mChildren.add((Object)vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put((Object)vClipPath.getPathName(), (Object)vClipPath);
                    }
                    vectorDrawableState.mChangingConfigurations |= vClipPath.mChangingConfigurations;
                } else if (SHAPE_GROUP.equals((Object)string2)) {
                    Object object = new Object(){
                        private int mChangingConfigurations;
                        final ArrayList<Object> mChildren = new ArrayList();
                        private String mGroupName;
                        private final Matrix mLocalMatrix;
                        private float mPivotX = 0.0f;
                        private float mPivotY = 0.0f;
                        private float mRotate = 0.0f;
                        private float mScaleX = 1.0f;
                        private float mScaleY = 1.0f;
                        private final Matrix mStackedMatrix = new Matrix();
                        private int[] mThemeAttrs;
                        private float mTranslateX = 0.0f;
                        private float mTranslateY = 0.0f;
                        {
                            this.mLocalMatrix = new Matrix();
                            this.mGroupName = null;
                        }
                        {
                            String string2;
                            Matrix matrix;
                            this.mLocalMatrix = matrix = new Matrix();
                            this.mGroupName = null;
                            this.mRotate = vGroup.mRotate;
                            this.mPivotX = vGroup.mPivotX;
                            this.mPivotY = vGroup.mPivotY;
                            this.mScaleX = vGroup.mScaleX;
                            this.mScaleY = vGroup.mScaleY;
                            this.mTranslateX = vGroup.mTranslateX;
                            this.mTranslateY = vGroup.mTranslateY;
                            this.mThemeAttrs = vGroup.mThemeAttrs;
                            this.mGroupName = string2 = vGroup.mGroupName;
                            this.mChangingConfigurations = vGroup.mChangingConfigurations;
                            if (string2 != null) {
                                a2.put((Object)string2, (Object)this);
                            }
                            matrix.set(vGroup.mLocalMatrix);
                            ArrayList<Object> arrayList = vGroup.mChildren;
                            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                                block8 : {
                                    VPath vPath;
                                    block7 : {
                                        Object object;
                                        block6 : {
                                            object = arrayList.get(i2);
                                            if (object instanceof VGroup) {
                                                VGroup vGroup2 = object;
                                                this.mChildren.add(new /* invalid duplicate definition of identical inner class */);
                                                continue;
                                            }
                                            if (!(object instanceof VFullPath)) break block6;
                                            vPath = new VFullPath((VFullPath)object);
                                            break block7;
                                        }
                                        if (!(object instanceof VClipPath)) break block8;
                                        vPath = new VClipPath((VClipPath)object);
                                    }
                                    this.mChildren.add((Object)vPath);
                                    String string3 = vPath.mPathName;
                                    if (string3 == null) continue;
                                    a2.put((Object)string3, (Object)vPath);
                                    continue;
                                }
                                throw new IllegalStateException("Unknown object in the tree!");
                            }
                        }

                        private void updateLocalMatrix() {
                            this.mLocalMatrix.reset();
                            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
                            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
                            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
                            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
                        }

                        private void updateStateFromTypedArray(TypedArray typedArray) {
                            this.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
                            this.mRotate = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_rotation, this.mRotate);
                            this.mPivotX = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_pivotX, this.mPivotX);
                            this.mPivotY = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_pivotY, this.mPivotY);
                            this.mScaleX = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_scaleX, this.mScaleX);
                            this.mScaleY = typedArray.getFloat(R.styleable.VectorDrawableGroup_android_scaleY, this.mScaleY);
                            this.mTranslateX = typedArray.getFloat(R.styleable.VectorDrawableGroup_vc_translateX, this.mTranslateX);
                            this.mTranslateY = typedArray.getFloat(R.styleable.VectorDrawableGroup_vc_translateY, this.mTranslateY);
                            String string2 = typedArray.getString(R.styleable.VectorDrawableGroup_android_name);
                            if (string2 != null) {
                                this.mGroupName = string2;
                            }
                            this.updateLocalMatrix();
                        }

                        public void applyTheme(Resources.Theme theme) {
                            if (this.mThemeAttrs == null) {
                                // empty if block
                            }
                        }

                        public boolean canApplyTheme() {
                            return this.mThemeAttrs != null;
                        }

                        public String getGroupName() {
                            return this.mGroupName;
                        }

                        public Matrix getLocalMatrix() {
                            return this.mLocalMatrix;
                        }

                        public float getPivotX() {
                            return this.mPivotX;
                        }

                        public float getPivotY() {
                            return this.mPivotY;
                        }

                        public float getRotation() {
                            return this.mRotate;
                        }

                        public float getScaleX() {
                            return this.mScaleX;
                        }

                        public float getScaleY() {
                            return this.mScaleY;
                        }

                        public float getTranslateX() {
                            return this.mTranslateX;
                        }

                        public float getTranslateY() {
                            return this.mTranslateY;
                        }

                        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
                            TypedArray typedArray = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawableGroup);
                            this.updateStateFromTypedArray(typedArray);
                            typedArray.recycle();
                        }

                        public void setPivotX(float f3) {
                            if (f3 != this.mPivotX) {
                                this.mPivotX = f3;
                                this.updateLocalMatrix();
                            }
                        }

                        public void setPivotY(float f3) {
                            if (f3 != this.mPivotY) {
                                this.mPivotY = f3;
                                this.updateLocalMatrix();
                            }
                        }

                        public void setRotation(float f3) {
                            if (f3 != this.mRotate) {
                                this.mRotate = f3;
                                this.updateLocalMatrix();
                            }
                        }

                        public void setScaleX(float f3) {
                            if (f3 != this.mScaleX) {
                                this.mScaleX = f3;
                                this.updateLocalMatrix();
                            }
                        }

                        public void setScaleY(float f3) {
                            if (f3 != this.mScaleY) {
                                this.mScaleY = f3;
                                this.updateLocalMatrix();
                            }
                        }

                        public void setTranslateX(float f3) {
                            if (f3 != this.mTranslateX) {
                                this.mTranslateX = f3;
                                this.updateLocalMatrix();
                            }
                        }

                        public void setTranslateY(float f3) {
                            if (f3 != this.mTranslateY) {
                                this.mTranslateY = f3;
                                this.updateLocalMatrix();
                            }
                        }
                    };
                    object.inflate(resources, attributeSet, theme);
                    vGroup.mChildren.add(object);
                    stack.push(object);
                    if (object.getGroupName() != null) {
                        vPathRenderer.mVGTargetsMap.put((Object)object.getGroupName(), object);
                    }
                    vectorDrawableState.mChangingConfigurations |= (object).mChangingConfigurations;
                }
            } else if (n2 == 3 && SHAPE_GROUP.equals((Object)xmlPullParser.getName())) {
                stack.pop();
            }
            n2 = xmlPullParser.next();
        }
        if (bl) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append(SHAPE_PATH);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("no ");
            stringBuilder.append((Object)stringBuffer);
            stringBuilder.append(" defined");
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    private boolean needMirroring() {
        return this.isAutoMirrored() && this.getLayoutDirection() == 1;
    }

    private void printGroupTree(VGroup vGroup, int n2) {
        int n3 = 0;
        String string2 = "";
        for (int i2 = 0; i2 < n2; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("    ");
            string2 = stringBuilder.toString();
        }
        String string3 = LOGTAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("current group is :");
        stringBuilder.append(vGroup.getGroupName());
        stringBuilder.append(" rotation is ");
        stringBuilder.append(vGroup.mRotate);
        Log.v((String)string3, (String)stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append("matrix is :");
        stringBuilder2.append(vGroup.getLocalMatrix().toString());
        Log.v((String)string3, (String)stringBuilder2.toString());
        while (n3 < vGroup.mChildren.size()) {
            Object object = vGroup.mChildren.get(n3);
            if (object instanceof VGroup) {
                this.printGroupTree(object, n2 + 1);
            }
            ++n3;
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws XmlPullParserException {
        float f3;
        ColorStateList colorStateList;
        VectorDrawableState vectorDrawableState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        vectorDrawableState.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
        int n2 = typedArray.getInt(R.styleable.VectorDrawable_vc_tintMode, -1);
        if (n2 != -1) {
            vectorDrawableState.mTintMode = DrawableCompat.parseTintMode(n2, PorterDuff.Mode.SRC_IN);
        }
        if ((colorStateList = typedArray.getColorStateList(R.styleable.VectorDrawable_vc_tint)) != null) {
            vectorDrawableState.mTint = colorStateList;
        }
        vectorDrawableState.mAutoMirrored = typedArray.getBoolean(R.styleable.VectorDrawable_vc_autoMirrored, vectorDrawableState.mAutoMirrored);
        vPathRenderer.mViewportWidth = typedArray.getFloat(R.styleable.VectorDrawable_vc_viewportWidth, vPathRenderer.mViewportWidth);
        vPathRenderer.mViewportHeight = f3 = typedArray.getFloat(R.styleable.VectorDrawable_vc_viewportHeight, vPathRenderer.mViewportHeight);
        if (!(vPathRenderer.mViewportWidth <= 0.0f)) {
            if (!(f3 <= 0.0f)) {
                float f4;
                vPathRenderer.mBaseWidth = typedArray.getDimension(R.styleable.VectorDrawable_android_width, vPathRenderer.mBaseWidth);
                vPathRenderer.mBaseHeight = f4 = typedArray.getDimension(R.styleable.VectorDrawable_android_height, vPathRenderer.mBaseHeight);
                if (!(vPathRenderer.mBaseWidth <= 0.0f)) {
                    if (!(f4 <= 0.0f)) {
                        vPathRenderer.setAlpha(typedArray.getFloat(R.styleable.VectorDrawable_android_alpha, vPathRenderer.getAlpha()));
                        String string2 = typedArray.getString(R.styleable.VectorDrawable_android_name);
                        if (string2 != null) {
                            vPathRenderer.mRootName = string2;
                            vPathRenderer.mVGTargetsMap.put((Object)string2, (Object)vPathRenderer);
                        }
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(typedArray.getPositionDescription());
                    stringBuilder.append("<menu_vector> tag requires height > 0");
                    throw new XmlPullParserException(stringBuilder.toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<menu_vector> tag requires width > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<menu_vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(typedArray.getPositionDescription());
        stringBuilder.append("<menu_vector> tag requires viewportWidth > 0");
        throw new XmlPullParserException(stringBuilder.toString());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable.super.applyTheme(theme);
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState != null && vectorDrawableState.mThemeAttrs != null) {
            try {
                vectorDrawableState.mCacheDirty = true;
                this.updateStateFromTypedArray(null);
            }
            catch (XmlPullParserException xmlPullParserException) {
                throw new RuntimeException((Throwable)xmlPullParserException);
            }
            finally {
                throw null;
            }
        }
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        if (vPathRenderer != null && vPathRenderer.canApplyTheme()) {
            vPathRenderer.applyTheme(theme);
        }
    }

    @Override
    public boolean canApplyTheme() {
        VectorDrawableState vectorDrawableState;
        return super.canApplyTheme() || (vectorDrawableState = this.mVectorState) != null && vectorDrawableState.canApplyTheme();
        {
        }
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        if (rect.width() != 0) {
            ColorFilter colorFilter;
            if (rect.height() == 0) {
                return;
            }
            int n2 = canvas.save();
            boolean bl = this.needMirroring();
            canvas.translate((float)rect.left, (float)rect.top);
            if (bl) {
                canvas.translate((float)rect.width(), 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            if ((colorFilter = this.mColorFilter) == null) {
                colorFilter = this.mTintFilter;
            }
            if (!this.mAllowCaching) {
                if (!this.mVectorState.hasTranslucentRoot()) {
                    this.mVectorState.mVPathRenderer.draw(canvas, rect.width(), rect.height(), colorFilter);
                } else {
                    this.mVectorState.createCachedBitmapIfNeeded(rect);
                    this.mVectorState.updateCachedBitmap(rect);
                    this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter);
                }
            } else {
                this.mVectorState.createCachedBitmapIfNeeded(rect);
                if (!this.mVectorState.canReuseCache()) {
                    this.mVectorState.updateCachedBitmap(rect);
                    this.mVectorState.updateCacheStates();
                }
                this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter);
            }
            canvas.restoreToCount(n2);
        }
    }

    public int getAlpha() {
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return Drawable.super.getChangingConfigurations() | this.mVectorState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        this.mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mVectorState;
    }

    public int getIntrinsicHeight() {
        return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public int getIntrinsicWidth() {
        return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public float getPixelSize() {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState != null || vectorDrawableState.mVPathRenderer != null) {
            float f3;
            float f4;
            float f5;
            VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
            float f6 = vPathRenderer.mBaseWidth;
            if (f6 != 0.0f && (f4 = vPathRenderer.mBaseHeight) != 0.0f && (f5 = vPathRenderer.mViewportHeight) != 0.0f && (f3 = vPathRenderer.mViewportWidth) != 0.0f) {
                return Math.min((float)(f3 / f6), (float)(f5 / f4));
            }
        }
        return 1.0f;
    }

    Object getTargetByName(String string2) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get((Object)string2);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        vectorDrawableState.mVPathRenderer = new Object(){
            private static final Matrix IDENTITY_MATRIX = new Matrix();
            float mBaseHeight = 0.0f;
            float mBaseWidth = 0.0f;
            private int mChangingConfigurations;
            private Paint mFillPaint;
            private final Matrix mFinalPathMatrix = new Matrix();
            private final Path mPath;
            private PathMeasure mPathMeasure;
            private final Path mRenderPath;
            int mRootAlpha = 255;
            private final VGroup mRootGroup;
            String mRootName = null;
            private Paint mStrokePaint;
            final a<String, Object> mVGTargetsMap;
            float mViewportHeight = 0.0f;
            float mViewportWidth = 0.0f;
            {
                this.mVGTargetsMap = new a();
                this.mRootGroup = new /* invalid duplicate definition of identical inner class */;
                this.mPath = new Path();
                this.mRenderPath = new Path();
            }
            {
                a a2;
                this.mVGTargetsMap = a2 = new a();
                this.mRootGroup = new /* invalid duplicate definition of identical inner class */;
                this.mPath = new Path(vPathRenderer.mPath);
                this.mRenderPath = new Path(vPathRenderer.mRenderPath);
                this.mBaseWidth = vPathRenderer.mBaseWidth;
                this.mBaseHeight = vPathRenderer.mBaseHeight;
                this.mViewportWidth = vPathRenderer.mViewportWidth;
                this.mViewportHeight = vPathRenderer.mViewportHeight;
                this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
                this.mRootAlpha = vPathRenderer.mRootAlpha;
                this.mRootName = vPathRenderer.mRootName;
                String string2 = vPathRenderer.mRootName;
                if (string2 != null) {
                    a2.put((Object)string2, (Object)this);
                }
            }

            private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
                vGroup.mStackedMatrix.set(matrix);
                vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
                for (int i2 = 0; i2 < vGroup.mChildren.size(); ++i2) {
                    Object object = vGroup.mChildren.get(i2);
                    if (object instanceof VGroup) {
                        this.drawGroupTree(object, vGroup.mStackedMatrix, canvas, n2, n3, colorFilter);
                        continue;
                    }
                    if (!(object instanceof VPath)) continue;
                    this.drawPath(vGroup, object, canvas, n2, n3, colorFilter);
                }
            }

            private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
                float f3 = (float)n2 / this.mViewportWidth;
                float f4 = (float)n3 / this.mViewportHeight;
                float f5 = Math.min((float)f3, (float)f4);
                this.mFinalPathMatrix.set(vGroup.mStackedMatrix);
                this.mFinalPathMatrix.postScale(f3, f4);
                vPath.toPath(this.mPath);
                Path path = this.mPath;
                this.mRenderPath.reset();
                if (vPath.isClipPath()) {
                    this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                    canvas.clipPath(this.mRenderPath, Region.Op.REPLACE);
                    return;
                }
                VFullPath vFullPath = (VFullPath)vPath;
                float f6 = vFullPath.mTrimPathStart;
                if (f6 != 0.0f || vFullPath.mTrimPathEnd != 1.0f) {
                    float f7 = vFullPath.mTrimPathOffset;
                    float f8 = (f6 + f7) % 1.0f;
                    float f9 = (f7 + vFullPath.mTrimPathEnd) % 1.0f;
                    if (this.mPathMeasure == null) {
                        this.mPathMeasure = new PathMeasure();
                    }
                    this.mPathMeasure.setPath(this.mPath, false);
                    float f10 = this.mPathMeasure.getLength();
                    float f11 = f8 * f10;
                    float f12 = f9 * f10;
                    path.reset();
                    if (f11 > f12) {
                        this.mPathMeasure.getSegment(f11, f10, path, true);
                        this.mPathMeasure.getSegment(0.0f, f12, path, true);
                    } else {
                        this.mPathMeasure.getSegment(f11, f12, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                if (vFullPath.mFillColor != 0) {
                    if (this.mFillPaint == null) {
                        Paint paint;
                        this.mFillPaint = paint = new Paint();
                        paint.setStyle(Paint.Style.FILL);
                        this.mFillPaint.setAntiAlias(true);
                    }
                    Paint paint = this.mFillPaint;
                    paint.setColor(VectorDrawable.applyAlpha(vFullPath.mFillColor, vFullPath.mFillAlpha));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.mRenderPath, paint);
                }
                if (vFullPath.mStrokeColor != 0) {
                    Paint.Cap cap;
                    if (this.mStrokePaint == null) {
                        Paint paint;
                        this.mStrokePaint = paint = new Paint();
                        paint.setStyle(Paint.Style.STROKE);
                        this.mStrokePaint.setAntiAlias(true);
                    }
                    Paint paint = this.mStrokePaint;
                    Paint.Join join = vFullPath.mStrokeLineJoin;
                    if (join != null) {
                        paint.setStrokeJoin(join);
                    }
                    if ((cap = vFullPath.mStrokeLineCap) != null) {
                        paint.setStrokeCap(cap);
                    }
                    paint.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                    paint.setColor(VectorDrawable.applyAlpha(vFullPath.mStrokeColor, vFullPath.mStrokeAlpha));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth(f5 * vFullPath.mStrokeWidth);
                    canvas.drawPath(this.mRenderPath, paint);
                }
            }

            private void recursiveApplyTheme(VGroup vGroup, Resources.Theme theme) {
                ArrayList<Object> arrayList = vGroup.mChildren;
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    VPath vPath;
                    Object object = arrayList.get(i2);
                    if (object instanceof VGroup) {
                        VGroup vGroup2 = object;
                        if (vGroup2.canApplyTheme()) {
                            vGroup2.applyTheme(theme);
                        }
                        this.recursiveApplyTheme(vGroup2, theme);
                        continue;
                    }
                    if (!(object instanceof VPath) || !(vPath = object).canApplyTheme()) continue;
                    vPath.applyTheme(theme);
                }
            }

            private boolean recursiveCanApplyTheme(VGroup vGroup) {
                ArrayList<Object> arrayList = vGroup.mChildren;
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    VGroup vGroup2;
                    Object object = arrayList.get(i2);
                    if (!(object instanceof VGroup ? (vGroup2 = object).canApplyTheme() || this.recursiveCanApplyTheme(vGroup2) : object instanceof VPath && (object).canApplyTheme())) continue;
                    return true;
                }
                return false;
            }

            public void applyTheme(Resources.Theme theme) {
                this.recursiveApplyTheme(this.mRootGroup, theme);
            }

            public boolean canApplyTheme() {
                return this.recursiveCanApplyTheme(this.mRootGroup);
            }

            public void draw(Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
                this.drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, n2, n3, colorFilter);
            }

            public float getAlpha() {
                return (float)this.getRootAlpha() / 255.0f;
            }

            public int getRootAlpha() {
                return this.mRootAlpha;
            }

            public void setAlpha(float f3) {
                this.setRootAlpha((int)(f3 * 255.0f));
            }

            public void setRootAlpha(int n2) {
                this.mRootAlpha = n2;
            }
        };
        TypedArray typedArray = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawable);
        this.updateStateFromTypedArray(typedArray);
        typedArray.recycle();
        vectorDrawableState.mCacheDirty = true;
        this.inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
    }

    public boolean isAutoMirrored() {
        return this.mVectorState.mAutoMirrored;
    }

    public boolean isStateful() {
        VectorDrawableState vectorDrawableState;
        ColorStateList colorStateList;
        return Drawable.super.isStateful() || (vectorDrawableState = this.mVectorState) != null && (colorStateList = vectorDrawableState.mTint) != null && colorStateList.isStateful();
        {
        }
    }

    public Drawable mutate() {
        if (!this.mMutated && Drawable.super.mutate() == this) {
            this.mVectorState = new VectorDrawableState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    protected boolean onStateChange(int[] arrn) {
        PorterDuff.Mode mode;
        VectorDrawableState vectorDrawableState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableState.mTint;
        if (colorStateList != null && (mode = vectorDrawableState.mTintMode) != null) {
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, colorStateList, mode);
            this.invalidateSelf();
            return true;
        }
        return false;
    }

    void setAllowCaching(boolean bl) {
        this.mAllowCaching = bl;
    }

    public void setAlpha(int n2) {
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != n2) {
            this.mVectorState.mVPathRenderer.setRootAlpha(n2);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean bl) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mAutoMirrored != bl) {
            vectorDrawableState.mAutoMirrored = bl;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.invalidateSelf();
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTint != colorStateList) {
            vectorDrawableState.mTint = colorStateList;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableState.mTintMode);
            this.invalidateSelf();
        }
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTintMode != mode) {
            vectorDrawableState.mTintMode = mode;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, mode);
            this.invalidateSelf();
        }
    }

    private static class VClipPath
    extends VPath {
        public VClipPath() {
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            String string2;
            this.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
            String string3 = typedArray.getString(R.styleable.VectorDrawableClipPath_android_name);
            if (string3 != null) {
                this.mPathName = string3;
            }
            if ((string2 = typedArray.getString(R.styleable.VectorDrawableClipPath_vc_pathData)) != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray typedArray = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawableClipPath);
            this.updateStateFromTypedArray(typedArray);
            typedArray.recycle();
        }

        @Override
        public boolean isClipPath() {
            return true;
        }
    }

    protected static class VFullPath
    extends VPath {
        float mFillAlpha = 1.0f;
        int mFillColor = 0;
        int mFillRule;
        float mStrokeAlpha = 1.0f;
        int mStrokeColor = 0;
        Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
        Paint.Join mStrokeLineJoin = Paint.Join.MITER;
        float mStrokeMiterlimit = 4.0f;
        float mStrokeWidth = 0.0f;
        private int[] mThemeAttrs;
        float mTrimPathEnd = 1.0f;
        float mTrimPathOffset = 0.0f;
        float mTrimPathStart = 0.0f;

        public VFullPath() {
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        private Paint.Cap getStrokeLineCap(int n2, Paint.Cap cap) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join getStrokeLineJoin(int n2, Paint.Join join) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            String string2;
            this.mChangingConfigurations |= VectorDrawable.getChangingConfigurations(typedArray);
            String string3 = typedArray.getString(R.styleable.VectorDrawablePath_android_name);
            if (string3 != null) {
                this.mPathName = string3;
            }
            if ((string2 = typedArray.getString(R.styleable.VectorDrawablePath_vc_pathData)) != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
            this.mFillColor = typedArray.getColor(R.styleable.VectorDrawablePath_vc_fillColor, this.mFillColor);
            this.mFillAlpha = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_fillAlpha, this.mFillAlpha);
            this.mStrokeLineCap = this.getStrokeLineCap(typedArray.getInt(R.styleable.VectorDrawablePath_vc_strokeLineCap, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = this.getStrokeLineJoin(typedArray.getInt(R.styleable.VectorDrawablePath_vc_strokeLineJoin, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_strokeMiterLimit, this.mStrokeMiterlimit);
            this.mStrokeColor = typedArray.getColor(R.styleable.VectorDrawablePath_vc_strokeColor, this.mStrokeColor);
            this.mStrokeAlpha = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_strokeAlpha, this.mStrokeAlpha);
            this.mStrokeWidth = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_strokeWidth, this.mStrokeWidth);
            this.mTrimPathEnd = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_trimPathEnd, this.mTrimPathEnd);
            this.mTrimPathOffset = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_trimPathOffset, this.mTrimPathOffset);
            this.mTrimPathStart = typedArray.getFloat(R.styleable.VectorDrawablePath_vc_trimPathStart, this.mTrimPathStart);
        }

        @Override
        public void applyTheme(Resources.Theme theme) {
            if (this.mThemeAttrs == null) {
                // empty if block
            }
        }

        @Override
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        float getFillAlpha() {
            return this.mFillAlpha;
        }

        int getFillColor() {
            return this.mFillColor;
        }

        float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        int getStrokeColor() {
            return this.mStrokeColor;
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray typedArray = DrawableCompat.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawablePath);
            this.updateStateFromTypedArray(typedArray);
            typedArray.recycle();
        }

        void setFillAlpha(float f3) {
            this.mFillAlpha = f3;
        }

        void setFillColor(int n2) {
            this.mFillColor = n2;
        }

        void setStrokeAlpha(float f3) {
            this.mStrokeAlpha = f3;
        }

        void setStrokeColor(int n2) {
            this.mStrokeColor = n2;
        }

        void setStrokeWidth(float f3) {
            this.mStrokeWidth = f3;
        }

        void setTrimPathEnd(float f3) {
            this.mTrimPathEnd = f3;
        }

        void setTrimPathOffset(float f3) {
            this.mTrimPathOffset = f3;
        }

        void setTrimPathStart(float f3) {
            this.mTrimPathStart = f3;
        }
    }

    private static class VectorDrawableState
    extends DrawableCompat.ConstantStateCompat {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        int[] mThemeAttrs;
        ColorStateList mTint = null;
        PorterDuff.Mode mTintMode = VectorDrawable.DEFAULT_TINT_MODE;
        VPathRenderer mVPathRenderer;

        public VectorDrawableState() {
            this.mVPathRenderer = new /* invalid duplicate definition of identical inner class */;
        }

        public VectorDrawableState(VectorDrawableState vectorDrawableState) {
            if (vectorDrawableState != null) {
                this.mThemeAttrs = vectorDrawableState.mThemeAttrs;
                this.mChangingConfigurations = vectorDrawableState.mChangingConfigurations;
                this.mVPathRenderer = new /* invalid duplicate definition of identical inner class */;
                if (vectorDrawableState.mVPathRenderer.mFillPaint != null) {
                    this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableState.mTint;
                this.mTintMode = vectorDrawableState.mTintMode;
                this.mAutoMirrored = vectorDrawableState.mAutoMirrored;
            }
        }

        @Override
        public boolean canApplyTheme() {
            VPathRenderer vPathRenderer;
            return super.canApplyTheme() || this.mThemeAttrs != null || (vPathRenderer = this.mVPathRenderer) != null && vPathRenderer.canApplyTheme();
            {
            }
        }

        public boolean canReuseBitmap(int n2, int n3) {
            return n2 == this.mCachedBitmap.getWidth() && n3 == this.mCachedBitmap.getHeight();
        }

        public boolean canReuseCache() {
            return !this.mCacheDirty && this.mCachedThemeAttrs == this.mThemeAttrs && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(Rect rect) {
            if (this.mCachedBitmap == null || !this.canReuseBitmap(rect.width(), rect.height())) {
                this.mCachedBitmap = Bitmap.createBitmap((int)rect.width(), (int)rect.height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter) {
            Paint paint = this.getPaint(colorFilter);
            canvas.drawBitmap(this.mCachedBitmap, 0.0f, 0.0f, paint);
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!this.hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.mTempPaint == null) {
                Paint paint;
                this.mTempPaint = paint = new Paint();
                paint.setFilterBitmap(true);
            }
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(colorFilter);
            return this.mTempPaint;
        }

        public boolean hasTranslucentRoot() {
            return this.mVPathRenderer.getRootAlpha() < 255;
        }

        public Drawable newDrawable() {
            return new VectorDrawable(this, null, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawable(this, resources, null);
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return new VectorDrawable(this, resources, theme);
        }

        public void updateCacheStates() {
            this.mCachedThemeAttrs = this.mThemeAttrs;
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(Rect rect) {
            this.mCachedBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mCachedBitmap);
            this.mVPathRenderer.draw(canvas, rect.width(), rect.height(), null);
        }
    }

}

