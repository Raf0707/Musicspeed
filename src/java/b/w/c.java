/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  b.i.q.w
 *  b.w.c$j
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package b.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.i.q.w;
import b.w.c;
import b.w.c0;
import b.w.m;
import b.w.r;
import b.w.s;
import b.w.x;
import java.util.Map;

public class c
extends m {
    private static final String[] P = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> Q = new Property<Drawable, PointF>(PointF.class, "boundsOrigin"){
        private Rect a = new Rect();

        public PointF a(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF((float)rect.left, (float)rect.top);
        }

        public void b(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round((float)pointF.x), Math.round((float)pointF.y));
            drawable.setBounds(this.a);
        }
    };
    private static final Property<k, PointF> R = new Property<k, PointF>(PointF.class, "topLeft"){

        public PointF a(k k2) {
            return null;
        }

        public void b(k k2, PointF pointF) {
            k2.c(pointF);
        }
    };
    private static final Property<k, PointF> S = new Property<k, PointF>(PointF.class, "bottomRight"){

        public PointF a(k k2) {
            return null;
        }

        public void b(k k2, PointF pointF) {
            k2.a(pointF);
        }
    };
    private static final Property<View, PointF> T = new Property<View, PointF>(PointF.class, "bottomRight"){

        public PointF a(View view) {
            return null;
        }

        public void b(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round((float)pointF.x), Math.round((float)pointF.y));
        }
    };
    private static final Property<View, PointF> U = new Property<View, PointF>(PointF.class, "topLeft"){

        public PointF a(View view) {
            return null;
        }

        public void b(View view, PointF pointF) {
            c0.f(view, Math.round((float)pointF.x), Math.round((float)pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> V = new Property<View, PointF>(PointF.class, "position"){

        public PointF a(View view) {
            return null;
        }

        public void b(View view, PointF pointF) {
            int n2 = Math.round((float)pointF.x);
            int n3 = Math.round((float)pointF.y);
            c0.f(view, n2, n3, n2 + view.getWidth(), n3 + view.getHeight());
        }
    };
    private static b.w.k W = new b.w.k();
    private int[] X = new int[2];
    private boolean Y = false;
    private boolean Z = false;

    private void c0(s s2) {
        View view = s2.b;
        if (w.W((View)view) || view.getWidth() != 0 || view.getHeight() != 0) {
            s2.a.put((Object)"android:changeBounds:bounds", (Object)new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            s2.a.put((Object)"android:changeBounds:parent", (Object)s2.b.getParent());
            if (this.Z) {
                s2.b.getLocationInWindow(this.X);
                s2.a.put((Object)"android:changeBounds:windowX", (Object)this.X[0]);
                s2.a.put((Object)"android:changeBounds:windowY", (Object)this.X[1]);
            }
            if (this.Y) {
                s2.a.put((Object)"android:changeBounds:clip", (Object)w.v((View)view));
            }
        }
    }

    private boolean d0(View view, View view2) {
        if (this.Z) {
            s s2 = this.t(view, true);
            return s2 == null ? view == view2 : view2 == s2.b;
        }
        return true;
    }

    @Override
    public String[] D() {
        return P;
    }

    @Override
    public void g(s s2) {
        this.c0(s2);
    }

    @Override
    public void j(s s2) {
        this.c0(s2);
    }

    @Override
    public Animator n(final ViewGroup viewGroup, s s2, s s3) {
        block22 : {
            block23 : {
                int n2;
                int n3;
                View view;
                int n4;
                int n5;
                block26 : {
                    block25 : {
                        block24 : {
                            int n6;
                            if (s2 == null || s3 == null) break block22;
                            Map<String, Object> map = s2.a;
                            Map<String, Object> map2 = s3.a;
                            ViewGroup viewGroup2 = (ViewGroup)map.get((Object)"android:changeBounds:parent");
                            ViewGroup viewGroup3 = (ViewGroup)map2.get((Object)"android:changeBounds:parent");
                            if (viewGroup2 == null || viewGroup3 == null) break block23;
                            view = s3.b;
                            if (!this.d0((View)viewGroup2, (View)viewGroup3)) break block24;
                            Rect rect = (Rect)s2.a.get((Object)"android:changeBounds:bounds");
                            Rect rect2 = (Rect)s3.a.get((Object)"android:changeBounds:bounds");
                            int n7 = rect.left;
                            final int n8 = rect2.left;
                            int n9 = rect.top;
                            final int n10 = rect2.top;
                            int n11 = rect.right;
                            final int n12 = rect2.right;
                            int n13 = rect.bottom;
                            final int n14 = rect2.bottom;
                            int n15 = n11 - n7;
                            int n16 = n13 - n9;
                            int n17 = n12 - n8;
                            int n18 = n14 - n10;
                            Rect rect3 = (Rect)s2.a.get((Object)"android:changeBounds:clip");
                            final Rect rect4 = (Rect)s3.a.get((Object)"android:changeBounds:clip");
                            if (n15 != 0 && n16 != 0 || n17 != 0 && n18 != 0) {
                                n6 = n7 == n8 && n9 == n10 ? 0 : 1;
                                if (n11 != n12 || n13 != n14) {
                                    ++n6;
                                }
                            } else {
                                n6 = 0;
                            }
                            if (rect3 != null && !rect3.equals((Object)rect4) || rect3 == null && rect4 != null) {
                                ++n6;
                            }
                            if (n6 > 0) {
                                View view2;
                                ObjectAnimator objectAnimator;
                                if (!this.Y) {
                                    view2 = view;
                                    c0.f(view2, n7, n9, n11, n13);
                                    if (n6 == 2) {
                                        if (n15 == n17 && n16 == n18) {
                                            Path path = this.v().a(n7, n9, n8, n10);
                                            objectAnimator = b.w.f.a(view2, V, path);
                                        } else {
                                            final k k2 = new k(view2);
                                            Path path = this.v().a(n7, n9, n8, n10);
                                            ObjectAnimator objectAnimator2 = b.w.f.a(k2, R, path);
                                            Path path2 = this.v().a(n11, n13, n12, n14);
                                            ObjectAnimator objectAnimator3 = b.w.f.a(k2, S, path2);
                                            AnimatorSet animatorSet = new AnimatorSet();
                                            animatorSet.playTogether(new Animator[]{objectAnimator2, objectAnimator3});
                                            animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){
                                                private k mViewBounds;
                                                {
                                                    this.mViewBounds = k22;
                                                }
                                            });
                                            objectAnimator = animatorSet;
                                        }
                                    } else if (n7 == n8 && n9 == n10) {
                                        Path path = this.v().a(n11, n13, n12, n14);
                                        objectAnimator = b.w.f.a(view2, T, path);
                                    } else {
                                        Path path = this.v().a(n7, n9, n8, n10);
                                        objectAnimator = b.w.f.a(view2, U, path);
                                    }
                                } else {
                                    ObjectAnimator objectAnimator4;
                                    ObjectAnimator objectAnimator5;
                                    view2 = view;
                                    int n19 = Math.max((int)n15, (int)n17);
                                    int n20 = Math.max((int)n16, (int)n18);
                                    c0.f(view2, n7, n9, n19 + n7, n20 + n9);
                                    if (n7 == n8 && n9 == n10) {
                                        objectAnimator5 = null;
                                    } else {
                                        Path path = this.v().a(n7, n9, n8, n10);
                                        objectAnimator5 = b.w.f.a(view2, V, path);
                                    }
                                    Rect rect5 = rect3 == null ? new Rect(0, 0, n15, n16) : rect3;
                                    Rect rect6 = rect4 == null ? new Rect(0, 0, n17, n18) : rect4;
                                    if (!rect5.equals((Object)rect6)) {
                                        w.y0((View)view2, (Rect)rect5);
                                        ObjectAnimator objectAnimator6 = ObjectAnimator.ofObject((Object)view2, (String)"clipBounds", (TypeEvaluator)W, (Object[])new Object[]{rect5, rect6});
                                        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(){
                                            private boolean a;

                                            public void onAnimationCancel(Animator animator) {
                                                this.a = true;
                                            }

                                            public void onAnimationEnd(Animator animator) {
                                                if (!this.a) {
                                                    w.y0((View)view2, (Rect)rect4);
                                                    c0.f(view2, n8, n10, n12, n14);
                                                }
                                            }
                                        };
                                        objectAnimator6.addListener((Animator.AnimatorListener)animatorListenerAdapter);
                                        objectAnimator4 = objectAnimator6;
                                    } else {
                                        objectAnimator4 = null;
                                    }
                                    objectAnimator = r.c((Animator)objectAnimator5, objectAnimator4);
                                }
                                if (view2.getParent() instanceof ViewGroup) {
                                    ViewGroup viewGroup4 = (ViewGroup)view2.getParent();
                                    x.c(viewGroup4, true);
                                    this.a((m.f)new j(this, viewGroup4));
                                }
                                return objectAnimator;
                            }
                            break block25;
                        }
                        n2 = (Integer)s2.a.get((Object)"android:changeBounds:windowX");
                        n4 = (Integer)s2.a.get((Object)"android:changeBounds:windowY");
                        n5 = (Integer)s3.a.get((Object)"android:changeBounds:windowX");
                        n3 = (Integer)s3.a.get((Object)"android:changeBounds:windowY");
                        if (n2 != n5 || n4 != n3) break block26;
                    }
                    return null;
                }
                viewGroup.getLocationInWindow(this.X);
                Bitmap bitmap = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                final float f2 = c0.c(view);
                c0.g(view, 0.0f);
                c0.b((View)viewGroup).a((Drawable)bitmapDrawable);
                b.w.g g2 = this.v();
                int[] arrn = this.X;
                Path path = g2.a(n2 - arrn[0], n4 - arrn[1], n5 - arrn[0], n3 - arrn[1]);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder((Object)bitmapDrawable, (PropertyValuesHolder[])new PropertyValuesHolder[]{b.w.i.a(Q, path)});
                AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(){

                    public void onAnimationEnd(Animator animator) {
                        c0.b((View)viewGroup).b((Drawable)bitmapDrawable);
                        c0.g(view, f2);
                    }
                };
                objectAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter);
                return objectAnimator;
            }
            return null;
        }
        return null;
    }

    private static class k {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        k(View view) {
            this.e = view;
        }

        private void b() {
            c0.f(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            int n2;
            this.c = Math.round((float)pointF.x);
            this.d = Math.round((float)pointF.y);
            this.g = n2 = 1 + this.g;
            if (this.f == n2) {
                this.b();
            }
        }

        void c(PointF pointF) {
            int n2;
            this.a = Math.round((float)pointF.x);
            this.b = Math.round((float)pointF.y);
            this.f = n2 = 1 + this.f;
            if (n2 == this.g) {
                this.b();
            }
        }
    }

}

