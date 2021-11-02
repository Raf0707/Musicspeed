/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Paint
 *  android.graphics.Point
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  c.a.b.f
 *  com.afollestad.materialdialogs.internal.MDButton
 *  com.afollestad.materialdialogs.internal.MDRootLayout
 *  com.afollestad.materialdialogs.internal.b
 *  com.afollestad.materialdialogs.internal.c
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.text.NumberFormat
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package c.a.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.b.a;
import c.a.b.b;
import c.a.b.c;
import c.a.b.e;
import c.a.b.f;
import c.a.b.g;
import c.a.b.i;
import c.a.b.k;
import c.a.b.l;
import c.a.b.m;
import c.a.b.o;
import c.a.b.p;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;

class d {
    private static void a(ProgressBar progressBar) {
        if (Build.VERSION.SDK_INT < 18 && progressBar.isHardwareAccelerated() && progressBar.getLayerType() != 1) {
            progressBar.setLayerType(1, null);
        }
    }

    static int b(f.d d2) {
        if (d2.s != null) {
            return l.c;
        }
        if (d2.l == null && d2.X == null) {
            if (d2.k0 > -2) {
                return l.h;
            }
            if (d2.i0) {
                if (d2.B0) {
                    return l.j;
                }
                return l.i;
            }
            if (d2.o0 != null) {
                if (d2.w0 != null) {
                    return l.e;
                }
                return l.d;
            }
            if (d2.w0 != null) {
                return l.b;
            }
            return l.a;
        }
        if (d2.w0 != null) {
            return l.g;
        }
        return l.f;
    }

    static int c(f.d d2) {
        Context context = d2.a;
        int n2 = g.o;
        p p2 = d2.K;
        p p3 = p.g;
        boolean bl = p2 == p3;
        boolean bl2 = c.a.b.q.a.k(context, n2, bl);
        if (!bl2) {
            p3 = p.f;
        }
        d2.K = p3;
        if (bl2) {
            return m.a;
        }
        return m.b;
    }

    static void d(f f2) {
        boolean bl;
        DialogInterface.OnDismissListener onDismissListener;
        DialogInterface.OnCancelListener onCancelListener;
        TextView textView;
        DialogInterface.OnKeyListener onKeyListener;
        CheckBox checkBox;
        DialogInterface.OnShowListener onShowListener;
        f.d d2 = f2.h;
        f2.setCancelable(d2.L);
        f2.setCanceledOnTouchOutside(d2.M);
        if (d2.g0 == 0) {
            d2.g0 = c.a.b.q.a.m(d2.a, g.e, c.a.b.q.a.l(f2.getContext(), g.b));
        }
        if (d2.g0 != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(d2.a.getResources().getDimension(i.a));
            gradientDrawable.setColor(d2.g0);
            f2.getWindow().setBackgroundDrawable((Drawable)gradientDrawable);
        }
        if (!d2.F0) {
            d2.v = c.a.b.q.a.i(d2.a, g.B, d2.v);
        }
        if (!d2.G0) {
            d2.x = c.a.b.q.a.i(d2.a, g.A, d2.x);
        }
        if (!d2.H0) {
            d2.w = c.a.b.q.a.i(d2.a, g.z, d2.w);
        }
        if (!d2.I0) {
            d2.t = c.a.b.q.a.m(d2.a, g.F, d2.t);
        }
        if (!d2.C0) {
            int n2 = c.a.b.q.a.l(f2.getContext(), 16842806);
            d2.i = c.a.b.q.a.m(d2.a, g.D, n2);
        }
        if (!d2.D0) {
            int n3 = c.a.b.q.a.l(f2.getContext(), 16842808);
            d2.j = c.a.b.q.a.m(d2.a, g.m, n3);
        }
        if (!d2.E0) {
            d2.h0 = c.a.b.q.a.m(d2.a, g.u, d2.j);
        }
        f2.k = (TextView)f2.f.findViewById(k.m);
        f2.j = (ImageView)f2.f.findViewById(k.h);
        f2.o = f2.f.findViewById(k.n);
        f2.l = (TextView)f2.f.findViewById(k.d);
        f2.n = (RecyclerView)f2.f.findViewById(k.e);
        f2.u = (CheckBox)f2.f.findViewById(k.k);
        f2.v = (MDButton)f2.f.findViewById(k.c);
        f2.w = (MDButton)f2.f.findViewById(k.b);
        f2.x = (MDButton)f2.f.findViewById(k.a);
        if (d2.o0 != null && d2.m == null) {
            d2.m = d2.a.getText(17039370);
        }
        MDButton mDButton = f2.v;
        int n4 = d2.m != null ? 0 : 8;
        mDButton.setVisibility(n4);
        MDButton mDButton2 = f2.w;
        int n5 = d2.n != null ? 0 : 8;
        mDButton2.setVisibility(n5);
        MDButton mDButton3 = f2.x;
        int n6 = d2.o != null ? 0 : 8;
        mDButton3.setVisibility(n6);
        f2.v.setFocusable(true);
        f2.w.setFocusable(true);
        f2.x.setFocusable(true);
        if (d2.p) {
            f2.v.requestFocus();
        }
        if (d2.q) {
            f2.w.requestFocus();
        }
        if (d2.r) {
            f2.x.requestFocus();
        }
        if (d2.U != null) {
            f2.j.setVisibility(0);
            f2.j.setImageDrawable(d2.U);
        } else {
            Drawable drawable = c.a.b.q.a.p(d2.a, g.r);
            if (drawable != null) {
                f2.j.setVisibility(0);
                f2.j.setImageDrawable(drawable);
            } else {
                f2.j.setVisibility(8);
            }
        }
        int n7 = d2.W;
        if (n7 == -1) {
            n7 = c.a.b.q.a.n(d2.a, g.t);
        }
        if (d2.V || c.a.b.q.a.j(d2.a, g.s)) {
            n7 = d2.a.getResources().getDimensionPixelSize(i.l);
        }
        if (n7 > -1) {
            f2.j.setAdjustViewBounds(true);
            f2.j.setMaxHeight(n7);
            f2.j.setMaxWidth(n7);
            f2.j.requestLayout();
        }
        if (!d2.J0) {
            int n8 = c.a.b.q.a.l(f2.getContext(), g.p);
            d2.f0 = c.a.b.q.a.m(d2.a, g.q, n8);
        }
        f2.f.setDividerColor(d2.f0);
        TextView textView2 = f2.k;
        if (textView2 != null) {
            CharSequence charSequence;
            f2.p(textView2, d2.T);
            f2.k.setTextColor(d2.i);
            f2.k.setGravity(d2.c.a());
            if (Build.VERSION.SDK_INT >= 17) {
                f2.k.setTextAlignment(d2.c.b());
            }
            if ((charSequence = d2.b) == null) {
                f2.o.setVisibility(8);
            } else {
                f2.k.setText(charSequence);
                f2.o.setVisibility(0);
            }
        }
        if ((textView = f2.l) != null) {
            CharSequence charSequence;
            textView.setMovementMethod((MovementMethod)new LinkMovementMethod());
            f2.p(f2.l, d2.S);
            f2.l.setLineSpacing(0.0f, d2.N);
            ColorStateList colorStateList = d2.y;
            if (colorStateList == null) {
                f2.l.setLinkTextColor(c.a.b.q.a.l(f2.getContext(), 16842806));
            } else {
                f2.l.setLinkTextColor(colorStateList);
            }
            f2.l.setTextColor(d2.j);
            f2.l.setGravity(d2.d.a());
            if (Build.VERSION.SDK_INT >= 17) {
                f2.l.setTextAlignment(d2.d.b());
            }
            if ((charSequence = d2.k) != null) {
                f2.l.setText(charSequence);
                f2.l.setVisibility(0);
            } else {
                f2.l.setVisibility(8);
            }
        }
        if ((checkBox = f2.u) != null) {
            checkBox.setText(d2.w0);
            f2.u.setChecked(d2.x0);
            f2.u.setOnCheckedChangeListener(d2.y0);
            f2.p((TextView)f2.u, d2.S);
            f2.u.setTextColor(d2.j);
            com.afollestad.materialdialogs.internal.c.c((CheckBox)f2.u, (int)d2.t);
        }
        f2.f.setButtonGravity(d2.g);
        f2.f.setButtonStackedGravity(d2.e);
        f2.f.setStackingBehavior(d2.d0);
        if (Build.VERSION.SDK_INT >= 14) {
            bl = c.a.b.q.a.k(d2.a, 16843660, true);
            if (bl) {
                bl = c.a.b.q.a.k(d2.a, g.G, true);
            }
        } else {
            bl = c.a.b.q.a.k(d2.a, g.G, true);
        }
        MDButton mDButton4 = f2.v;
        f2.p((TextView)mDButton4, d2.T);
        mDButton4.setAllCapsCompat(bl);
        mDButton4.setText(d2.m);
        mDButton4.setTextColor(d2.v);
        MDButton mDButton5 = f2.v;
        b b2 = b.f;
        mDButton5.setStackedSelector(f2.g(b2, true));
        f2.v.setDefaultSelector(f2.g(b2, false));
        f2.v.setTag((Object)b2);
        f2.v.setOnClickListener((View.OnClickListener)f2);
        MDButton mDButton6 = f2.x;
        f2.p((TextView)mDButton6, d2.T);
        mDButton6.setAllCapsCompat(bl);
        mDButton6.setText(d2.o);
        mDButton6.setTextColor(d2.w);
        MDButton mDButton7 = f2.x;
        b b3 = b.h;
        mDButton7.setStackedSelector(f2.g(b3, true));
        f2.x.setDefaultSelector(f2.g(b3, false));
        f2.x.setTag((Object)b3);
        f2.x.setOnClickListener((View.OnClickListener)f2);
        MDButton mDButton8 = f2.w;
        f2.p((TextView)mDButton8, d2.T);
        mDButton8.setAllCapsCompat(bl);
        mDButton8.setText(d2.n);
        mDButton8.setTextColor(d2.x);
        MDButton mDButton9 = f2.w;
        b b4 = b.g;
        mDButton9.setStackedSelector(f2.g(b4, true));
        f2.w.setDefaultSelector(f2.g(b4, false));
        f2.w.setTag((Object)b4);
        f2.w.setOnClickListener((View.OnClickListener)f2);
        if (d2.H != null) {
            f2.z = new ArrayList();
        }
        if (f2.n != null) {
            RecyclerView.g<?> g2 = d2.X;
            if (g2 == null) {
                if (d2.G != null) {
                    f2.y = f.l.g;
                } else if (d2.H != null) {
                    f2.y = f.l.h;
                    if (d2.P != null) {
                        f2.z = new ArrayList((Collection)Arrays.asList((Object[])d2.P));
                        d2.P = null;
                    }
                } else {
                    f2.y = f.l.f;
                }
                d2.X = new a(f2, f.l.a(f2.y));
            } else if (g2 instanceof com.afollestad.materialdialogs.internal.b) {
                ((com.afollestad.materialdialogs.internal.b)g2).a(f2);
            }
        }
        d.f(f2);
        d.e(f2);
        if (d2.s != null) {
            FrameLayout frameLayout;
            ((MDRootLayout)f2.f.findViewById(k.l)).t();
            f2.p = frameLayout = (FrameLayout)f2.f.findViewById(k.g);
            View view = d2.s;
            if (view.getParent() != null) {
                ((ViewGroup)view.getParent()).removeView(view);
            }
            if (d2.e0) {
                Resources resources = f2.getContext().getResources();
                int n9 = resources.getDimensionPixelSize(i.g);
                ScrollView scrollView = new ScrollView(f2.getContext());
                int n10 = resources.getDimensionPixelSize(i.f);
                int n11 = resources.getDimensionPixelSize(i.e);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(n9, n10, n9, n11);
                } else {
                    scrollView.setPadding(0, n10, 0, n11);
                    view.setPadding(n9, 0, n9, 0);
                }
                scrollView.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
                view = scrollView;
            }
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        if ((onShowListener = d2.c0) != null) {
            f2.setOnShowListener(onShowListener);
        }
        if ((onCancelListener = d2.a0) != null) {
            f2.setOnCancelListener(onCancelListener);
        }
        if ((onDismissListener = d2.Z) != null) {
            f2.setOnDismissListener(onDismissListener);
        }
        if ((onKeyListener = d2.b0) != null) {
            f2.setOnKeyListener(onKeyListener);
        }
        f2.b();
        f2.l();
        f2.c((View)f2.f);
        f2.d();
        Display display = f2.getWindow().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int n12 = point.x;
        int n13 = point.y;
        int n14 = d2.a.getResources().getDimensionPixelSize(i.j);
        int n15 = d2.a.getResources().getDimensionPixelSize(i.h);
        int n16 = d2.a.getResources().getDimensionPixelSize(i.i);
        int n17 = n12 - n15 * 2;
        f2.f.setMaxHeight(n13 - n14 * 2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(f2.getWindow().getAttributes());
        layoutParams.width = Math.min((int)n16, (int)n17);
        f2.getWindow().setAttributes(layoutParams);
    }

    private static void e(f f2) {
        TextView textView;
        EditText editText;
        f.d d2 = f2.h;
        f2.m = editText = (EditText)f2.f.findViewById(16908297);
        if (editText == null) {
            return;
        }
        f2.p((TextView)editText, d2.S);
        CharSequence charSequence = d2.m0;
        if (charSequence != null) {
            f2.m.setText(charSequence);
        }
        f2.o();
        f2.m.setHint(d2.n0);
        f2.m.setSingleLine();
        f2.m.setTextColor(d2.j);
        f2.m.setHintTextColor(c.a.b.q.a.a(d2.j, 0.3f));
        com.afollestad.materialdialogs.internal.c.e((EditText)f2.m, (int)f2.h.t);
        int n2 = d2.q0;
        if (n2 != -1) {
            f2.m.setInputType(n2);
            int n3 = d2.q0;
            if (n3 != 144 && (n3 & 128) == 128) {
                f2.m.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
            }
        }
        f2.t = textView = (TextView)f2.f.findViewById(k.j);
        if (d2.s0 <= 0 && d2.t0 <= -1) {
            textView.setVisibility(8);
            f2.t = null;
            return;
        }
        f2.k(f2.m.getText().toString().length(), true ^ d2.p0);
    }

    private static void f(f f2) {
        ProgressBar progressBar;
        f.d d2 = f2.h;
        if (d2.i0 || d2.k0 > -2) {
            ProgressBar progressBar2;
            f2.q = progressBar2 = (ProgressBar)f2.f.findViewById(16908301);
            if (progressBar2 == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 14) {
                if (d2.i0) {
                    if (d2.B0) {
                        IndeterminateHorizontalProgressDrawable indeterminateHorizontalProgressDrawable = new IndeterminateHorizontalProgressDrawable(d2.e());
                        indeterminateHorizontalProgressDrawable.setTint(d2.t);
                        f2.q.setProgressDrawable((Drawable)indeterminateHorizontalProgressDrawable);
                        f2.q.setIndeterminateDrawable((Drawable)indeterminateHorizontalProgressDrawable);
                    } else {
                        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = new IndeterminateCircularProgressDrawable(d2.e());
                        indeterminateCircularProgressDrawable.setTint(d2.t);
                        f2.q.setProgressDrawable((Drawable)indeterminateCircularProgressDrawable);
                        f2.q.setIndeterminateDrawable((Drawable)indeterminateCircularProgressDrawable);
                    }
                } else {
                    HorizontalProgressDrawable horizontalProgressDrawable = new HorizontalProgressDrawable(d2.e());
                    horizontalProgressDrawable.setTint(d2.t);
                    f2.q.setProgressDrawable((Drawable)horizontalProgressDrawable);
                    f2.q.setIndeterminateDrawable((Drawable)horizontalProgressDrawable);
                }
            } else {
                com.afollestad.materialdialogs.internal.c.f((ProgressBar)progressBar2, (int)d2.t);
            }
            boolean bl = d2.i0;
            if (!bl || d2.B0) {
                TextView textView;
                TextView textView2;
                ProgressBar progressBar3 = f2.q;
                boolean bl2 = bl && d2.B0;
                progressBar3.setIndeterminate(bl2);
                f2.q.setProgress(0);
                f2.q.setMax(d2.l0);
                f2.r = textView = (TextView)f2.f.findViewById(k.i);
                if (textView != null) {
                    textView.setTextColor(d2.j);
                    f2.p(f2.r, d2.T);
                    f2.r.setText((CharSequence)d2.A0.format(0L));
                }
                f2.s = textView2 = (TextView)f2.f.findViewById(k.j);
                if (textView2 != null) {
                    textView2.setTextColor(d2.j);
                    f2.p(f2.s, d2.S);
                    if (d2.j0) {
                        f2.s.setVisibility(0);
                        TextView textView3 = f2.s;
                        String string = d2.z0;
                        Object[] arrobject = new Object[]{0, d2.l0};
                        textView3.setText((CharSequence)String.format((String)string, (Object[])arrobject));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)f2.q.getLayoutParams();
                        marginLayoutParams.leftMargin = 0;
                        marginLayoutParams.rightMargin = 0;
                    } else {
                        f2.s.setVisibility(8);
                    }
                } else {
                    d2.j0 = false;
                }
            }
        }
        if ((progressBar = f2.q) != null) {
            d.a(progressBar);
        }
    }
}

