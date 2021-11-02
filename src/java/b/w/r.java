/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Picture
 *  android.graphics.RectF
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  android.view.ViewParent
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Math
 *  java.lang.Object
 */
package b.w;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.widget.ImageView;
import b.w.c0;

class r {
    private static final boolean a;
    private static final boolean b;
    private static final boolean c;

    static {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = true;
        boolean bl2 = n2 >= 19;
        a = bl2;
        boolean bl3 = n2 >= 18;
        b = bl3;
        if (n2 < 28) {
            bl = false;
        }
        c = bl;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        c0.i(view, matrix);
        c0.j((View)viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        matrix.mapRect(rectF);
        int n2 = Math.round((float)rectF.left);
        int n3 = Math.round((float)rectF.top);
        int n4 = Math.round((float)rectF.right);
        int n5 = Math.round((float)rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmap = r.b(view, matrix, rectF, viewGroup);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec((int)(n4 - n2), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)(n5 - n3), (int)1073741824));
        imageView.layout(n2, n3, n4, n5);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        boolean bl;
        boolean bl2;
        int n2;
        block10 : {
            block9 : {
                block8 : {
                    if (!a) break block8;
                    bl2 = true ^ view.isAttachedToWindow();
                    if (viewGroup == null) break block9;
                    bl = viewGroup.isAttachedToWindow();
                    break block10;
                }
                bl2 = false;
            }
            bl = false;
        }
        boolean bl3 = b;
        if (bl3 && bl2) {
            if (!bl) {
                return null;
            }
            viewGroup2 = (ViewGroup)view.getParent();
            n2 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        } else {
            viewGroup2 = null;
            n2 = 0;
        }
        int n3 = Math.round((float)rectF.width());
        int n4 = Math.round((float)rectF.height());
        Bitmap bitmap = null;
        if (n3 > 0) {
            bitmap = null;
            if (n4 > 0) {
                float f2 = Math.min((float)1.0f, (float)(1048576.0f / (float)(n3 * n4)));
                int n5 = Math.round((float)(f2 * (float)n3));
                int n6 = Math.round((float)(f2 * (float)n4));
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(f2, f2);
                if (c) {
                    Picture picture = new Picture();
                    Canvas canvas = picture.beginRecording(n5, n6);
                    canvas.concat(matrix);
                    view.draw(canvas);
                    picture.endRecording();
                    bitmap = Bitmap.createBitmap((Picture)picture);
                } else {
                    bitmap = Bitmap.createBitmap((int)n5, (int)n6, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmap);
                    canvas.concat(matrix);
                    view.draw(canvas);
                }
            }
        }
        if (bl3 && bl2) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, n2);
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}

