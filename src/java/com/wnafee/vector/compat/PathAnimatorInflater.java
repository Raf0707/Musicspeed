/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Xml
 *  android.view.InflateException
 *  android.view.animation.AnimationUtils
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package com.wnafee.vector.compat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import com.wnafee.vector.R;
import com.wnafee.vector.compat.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class PathAnimatorInflater {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int SEQUENTIALLY = 1;
    private static final String TAG = "PathAnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_PATH = 2;

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) throws XmlPullParserException, IOException {
        return PathAnimatorInflater.createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet((XmlPullParser)xmlPullParser), null, 0, f2);
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int n2, float f2) throws XmlPullParserException, IOException {
        int n3;
        int n4 = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        ObjectAnimator objectAnimator = null;
        while (((n3 = xmlPullParser.next()) != 3 || xmlPullParser.getDepth() > n4) && n3 != 1) {
            block11 : {
                block9 : {
                    String string2;
                    block10 : {
                        block8 : {
                            if (n3 != 2) continue;
                            string2 = xmlPullParser.getName();
                            if (!string2.equals((Object)"objectAnimator")) break block8;
                            objectAnimator = PathAnimatorInflater.loadObjectAnimator(context, resources, theme, attributeSet, f2);
                            break block9;
                        }
                        if (!string2.equals((Object)"animator")) break block10;
                        objectAnimator = PathAnimatorInflater.loadAnimator(context, resources, theme, attributeSet, null, f2);
                        break block9;
                    }
                    if (!string2.equals((Object)"set")) break block11;
                    objectAnimator = new AnimatorSet();
                    PathAnimatorInflater.createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, (AnimatorSet)objectAnimator, 0, f2);
                }
                if (animatorSet == null) continue;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((Object)objectAnimator);
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown animator name: ");
            stringBuilder.append(xmlPullParser.getName());
            throw new RuntimeException(stringBuilder.toString());
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] arranimator = new Animator[arrayList.size()];
            int n5 = 0;
            for (Animator animator : arrayList) {
                int n6 = n5 + 1;
                arranimator[n5] = animator;
                n5 = n6;
            }
            if (n2 == 0) {
                animatorSet.playTogether(arranimator);
                return objectAnimator;
            }
            animatorSet.playSequentially(arranimator);
        }
        return objectAnimator;
    }

    /*
     * Exception decompiling
     */
    public static Animator loadAnimator(Context var0, Resources var1_1, Resources.Theme var2_2, int var3_3, float var4_4) throws Resources.NotFoundException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 1[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2) throws Resources.NotFoundException {
        TypedArray typedArray = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.Animator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.Animator);
        TypedArray typedArray2 = valueAnimator != null ? (theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.PropertyAnimator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.PropertyAnimator)) : null;
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        PathAnimatorInflater.parseAnimatorFromTypeArray(valueAnimator, typedArray, typedArray2);
        int n2 = typedArray.getResourceId(R.styleable.Animator_android_interpolator, 0);
        if (n2 > 0) {
            valueAnimator.setInterpolator((TimeInterpolator)AnimationUtils.loadInterpolator((Context)context, (int)n2));
        }
        typedArray.recycle();
        if (typedArray2 != null) {
            typedArray2.recycle();
        }
        return valueAnimator;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        PathAnimatorInflater.loadAnimator(context, resources, theme, attributeSet, (ValueAnimator)objectAnimator, f2);
        return objectAnimator;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2) {
        long l2 = typedArray.getInt(R.styleable.Animator_android_duration, 300);
        long l3 = typedArray.getInt(R.styleable.Animator_android_startOffset, 0);
        if (typedArray.getInt(R.styleable.Animator_vc_valueType, 0) == 2) {
            int n2;
            TypeEvaluator typeEvaluator = PathAnimatorInflater.setupAnimatorForPath(valueAnimator, typedArray);
            valueAnimator.setDuration(l2);
            valueAnimator.setStartDelay(l3);
            int n3 = R.styleable.Animator_android_repeatCount;
            if (typedArray.hasValue(n3)) {
                valueAnimator.setRepeatCount(typedArray.getInt(n3, 0));
            }
            if (typedArray.hasValue(n2 = R.styleable.Animator_android_repeatMode)) {
                valueAnimator.setRepeatMode(typedArray.getInt(n2, 1));
            }
            if (typeEvaluator != null) {
                valueAnimator.setEvaluator(typeEvaluator);
            }
            if (typedArray2 != null) {
                PathAnimatorInflater.setupObjectAnimator(valueAnimator, typedArray2);
            }
            return;
        }
        throw new IllegalArgumentException("target is not a pathType target");
    }

    private static TypeEvaluator setupAnimatorForPath(ValueAnimator valueAnimator, TypedArray typedArray) {
        String string2 = typedArray.getString(R.styleable.Animator_android_valueFrom);
        String string3 = typedArray.getString(R.styleable.Animator_android_valueTo);
        PathParser.PathDataNode[] arrpathDataNode = PathParser.createNodesFromPathData(string2);
        PathParser.PathDataNode[] arrpathDataNode2 = PathParser.createNodesFromPathData(string3);
        if (arrpathDataNode != null) {
            if (arrpathDataNode2 != null) {
                valueAnimator.setObjectValues(new Object[]{arrpathDataNode, arrpathDataNode2});
                if (!PathParser.canMorph(arrpathDataNode, arrpathDataNode2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(typedArray.getPositionDescription());
                    stringBuilder.append(" Can't morph from ");
                    stringBuilder.append(string2);
                    stringBuilder.append(" to ");
                    stringBuilder.append(string3);
                    throw new InflateException(stringBuilder.toString());
                }
            } else {
                valueAnimator.setObjectValues(new Object[]{arrpathDataNode});
            }
            return new PathDataEvaluator(PathParser.deepCopyNodes(arrpathDataNode));
        }
        if (arrpathDataNode2 != null) {
            valueAnimator.setObjectValues(new Object[]{arrpathDataNode2});
            return new PathDataEvaluator(PathParser.deepCopyNodes(arrpathDataNode2));
        }
        return null;
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray) {
        ((ObjectAnimator)valueAnimator).setPropertyName(typedArray.getString(R.styleable.PropertyAnimator_android_propertyName));
    }

    private static class PathDataEvaluator
    implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        private PathDataEvaluator() {
        }

        public PathDataEvaluator(PathParser.PathDataNode[] arrpathDataNode) {
            this.mNodeArray = arrpathDataNode;
        }

        public PathParser.PathDataNode[] evaluate(float f2, PathParser.PathDataNode[] arrpathDataNode, PathParser.PathDataNode[] arrpathDataNode2) {
            if (PathParser.canMorph(arrpathDataNode, arrpathDataNode2)) {
                PathParser.PathDataNode[] arrpathDataNode3 = this.mNodeArray;
                if (arrpathDataNode3 == null || !PathParser.canMorph(arrpathDataNode3, arrpathDataNode)) {
                    this.mNodeArray = PathParser.deepCopyNodes(arrpathDataNode);
                }
                for (int i2 = 0; i2 < arrpathDataNode.length; ++i2) {
                    this.mNodeArray[i2].interpolatePathDataNode(arrpathDataNode[i2], arrpathDataNode2[i2], f2);
                }
                return this.mNodeArray;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

}

