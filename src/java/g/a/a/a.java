/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.graphics.drawable.a
 *  androidx.core.widget.i
 *  b.i.h.a
 *  b.x.a.a.i
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import g.a.a.b;
import g.a.a.c;
import g.a.a.d;
import g.a.a.e;
import g.a.a.f;
import g.a.a.g;
import g.a.a.h;
import g.a.a.i;

public class a {
    private final Context a;
    private final LayoutInflater b;
    private final View c;
    private CharSequence d;
    private int e = 0;
    private boolean f = false;
    private Typeface g;

    public a(Context context) {
        LayoutInflater layoutInflater;
        this.a = context;
        this.b = layoutInflater = LayoutInflater.from((Context)context);
        this.c = layoutInflater.inflate(h.a, null);
    }

    private View f(final c c2) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setClickable(true);
        if (c2.g() != null) {
            linearLayout.setOnClickListener(c2.g());
        } else if (c2.f() != null) {
            linearLayout.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    try {
                        a.this.a.startActivity(c2.f());
                    }
                    catch (Exception exception) {}
                }
            });
        }
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(d.a, typedValue, true);
        linearLayout.setBackgroundResource(typedValue.resourceId);
        int n2 = this.a.getResources().getDimensionPixelSize(f.d);
        linearLayout.setPadding(n2, n2, n2, n2);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(this.a);
        androidx.core.widget.i.q((TextView)textView, (int)i.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        Typeface typeface = this.g;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        ImageView imageView = null;
        if (c2.c() != null) {
            imageView = new ImageView(this.a);
            int n3 = this.a.getResources().getDimensionPixelSize(f.b);
            imageView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(n3, n3));
            int n4 = this.a.getResources().getDimensionPixelSize(f.a);
            imageView.setPadding(n4, 0, n4, 0);
            if (Build.VERSION.SDK_INT < 21) {
                imageView.setImageDrawable((Drawable)b.x.a.a.i.b((Resources)imageView.getResources(), (int)c2.c(), (Resources.Theme)imageView.getContext().getTheme()));
            } else {
                imageView.setImageResource(c2.c().intValue());
            }
            Drawable drawable2 = androidx.core.graphics.drawable.a.r((Drawable)imageView.getDrawable()).mutate();
            if (c2.a().booleanValue()) {
                if ((48 & this.a.getResources().getConfiguration().uiMode) != 32) {
                    if (c2.e() != null) {
                        androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)b.i.h.a.c((Context)this.a, (int)c2.e()));
                    } else {
                        androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)b.i.h.a.c((Context)this.a, (int)e.a));
                    }
                } else if (c2.d() != null) {
                    androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)b.i.h.a.c((Context)this.a, (int)c2.d()));
                } else {
                    androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)b.a(this.a));
                }
            }
        } else {
            int n5 = this.a.getResources().getDimensionPixelSize(f.a);
            textView.setPadding(n5, n5, n5, n5);
        }
        textView.setText((CharSequence)c2.h());
        if (this.f) {
            int n6 = c2.b() != null ? c2.b() : 8388613;
            int n7 = n6 | 16;
            linearLayout.setGravity(n7);
            layoutParams.gravity = n7;
            linearLayout.addView((View)textView);
            if (c2.c() != null) {
                linearLayout.addView((View)imageView);
                return linearLayout;
            }
        } else {
            int n8 = c2.b() != null ? c2.b() : 8388611;
            int n9 = n8 | 16;
            linearLayout.setGravity(n9);
            layoutParams.gravity = n9;
            if (c2.c() != null) {
                linearLayout.addView((View)imageView);
            }
            linearLayout.addView((View)textView);
        }
        return linearLayout;
    }

    private View g() {
        return this.b.inflate(h.b, null);
    }

    public a b(String string2, String string3) {
        throw null;
    }

    public a c(c c2) {
        LinearLayout linearLayout = (LinearLayout)this.c.findViewById(g.a);
        linearLayout.addView(this.f(c2));
        linearLayout.addView(this.g(), new ViewGroup.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(f.c)));
        return this;
    }

    public a d(String string2, String string3) {
        throw null;
    }

    public View e() {
        TextView textView = (TextView)this.c.findViewById(g.b);
        ImageView imageView = (ImageView)this.c.findViewById(g.c);
        int n2 = this.e;
        if (n2 > 0) {
            imageView.setImageResource(n2);
        }
        if (!TextUtils.isEmpty((CharSequence)this.d)) {
            textView.setText(this.d);
        }
        textView.setGravity(17);
        Typeface typeface = this.g;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        return this.c;
    }

    public a h(boolean bl) {
        this.f = bl;
        return this;
    }

    public a i(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    public a j(int n2) {
        this.e = n2;
        return this;
    }

}

