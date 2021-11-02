/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.LinearLayout
 *  android.widget.RadioButton
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  c.a.b.f
 *  com.afollestad.materialdialogs.internal.c
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package c.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.b.e;
import c.a.b.f;
import c.a.b.k;
import java.util.ArrayList;
import java.util.List;

class a
extends RecyclerView.g<b> {
    private final f h;
    private final int i;
    private final e j;
    private c k;

    a(f f2, int n2) {
        this.h = f2;
        this.i = n2;
        this.j = f2.h.f;
    }

    @TargetApi(value=17)
    private boolean q() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        int n2 = this.h.f().e().getResources().getConfiguration().getLayoutDirection();
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    @TargetApi(value=17)
    private void u(ViewGroup viewGroup) {
        ((LinearLayout)viewGroup).setGravity(16 | this.j.a());
        if (viewGroup.getChildCount() == 2) {
            if (this.j == e.h && !this.q() && viewGroup.getChildAt(0) instanceof CompoundButton) {
                CompoundButton compoundButton = (CompoundButton)viewGroup.getChildAt(0);
                viewGroup.removeView((View)compoundButton);
                TextView textView = (TextView)viewGroup.getChildAt(0);
                viewGroup.removeView((View)textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
                viewGroup.addView((View)textView);
                viewGroup.addView((View)compoundButton);
                return;
            }
            if (this.j == e.f && this.q() && viewGroup.getChildAt(1) instanceof CompoundButton) {
                CompoundButton compoundButton = (CompoundButton)viewGroup.getChildAt(1);
                viewGroup.removeView((View)compoundButton);
                TextView textView = (TextView)viewGroup.getChildAt(0);
                viewGroup.removeView((View)textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingRight(), textView.getPaddingBottom());
                viewGroup.addView((View)compoundButton);
                viewGroup.addView((View)textView);
            }
        }
    }

    public int getItemCount() {
        ArrayList<CharSequence> arrayList = this.h.h.l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void r(b b2, int n2) {
        View view = b2.itemView;
        boolean bl = c.a.b.q.a.h(n2, this.h.h.Q);
        int n3 = bl ? c.a.b.q.a.a(this.h.h.h0, 0.4f) : this.h.h.h0;
        b2.itemView.setEnabled(bl ^ true);
        int n4 = a.a[this.h.y.ordinal()];
        if (n4 != 1) {
            if (n4 == 2) {
                CheckBox checkBox = (CheckBox)b2.x;
                boolean bl2 = this.h.z.contains((Object)n2);
                f.d d2 = this.h.h;
                ColorStateList colorStateList = d2.u;
                if (colorStateList != null) {
                    com.afollestad.materialdialogs.internal.c.d((CheckBox)checkBox, (ColorStateList)colorStateList);
                } else {
                    com.afollestad.materialdialogs.internal.c.c((CheckBox)checkBox, (int)d2.t);
                }
                checkBox.setChecked(bl2);
                checkBox.setEnabled(bl ^ true);
            }
        } else {
            RadioButton radioButton = (RadioButton)b2.x;
            f.d d3 = this.h.h;
            boolean bl3 = d3.O == n2;
            ColorStateList colorStateList = d3.u;
            if (colorStateList != null) {
                com.afollestad.materialdialogs.internal.c.i((RadioButton)radioButton, (ColorStateList)colorStateList);
            } else {
                com.afollestad.materialdialogs.internal.c.h((RadioButton)radioButton, (int)d3.t);
            }
            radioButton.setChecked(bl3);
            radioButton.setEnabled(bl ^ true);
        }
        b2.y.setText((CharSequence)this.h.h.l.get(n2));
        b2.y.setTextColor(n3);
        f f2 = this.h;
        f2.p(b2.y, f2.h.S);
        ViewGroup viewGroup = (ViewGroup)view;
        this.u(viewGroup);
        int[] arrn = this.h.h.v0;
        if (arrn != null) {
            if (n2 < arrn.length) {
                view.setId(arrn[n2]);
            } else {
                view.setId(-1);
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && viewGroup.getChildCount() == 2) {
            if (viewGroup.getChildAt(0) instanceof CompoundButton) {
                viewGroup.getChildAt(0).setBackground(null);
                return;
            }
            if (viewGroup.getChildAt(1) instanceof CompoundButton) {
                viewGroup.getChildAt(1).setBackground(null);
            }
        }
    }

    public b s(ViewGroup viewGroup, int n2) {
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(this.i, viewGroup, false);
        c.a.b.q.a.t(view, this.h.i());
        return new b(view, this);
    }

    void t(c c2) {
        this.k = c2;
    }

    static class b
    extends RecyclerView.c0
    implements View.OnClickListener,
    View.OnLongClickListener {
        final CompoundButton x;
        final TextView y;
        final a z;

        b(View view, a a2) {
            super(view);
            this.x = (CompoundButton)view.findViewById(k.f);
            this.y = (TextView)view.findViewById(k.m);
            this.z = a2;
            view.setOnClickListener((View.OnClickListener)this);
            if (a.o((a)a2).h.F != null) {
                view.setOnLongClickListener((View.OnLongClickListener)this);
            }
        }

        public void onClick(View view) {
            if (this.z.k != null && this.getAdapterPosition() != -1) {
                ArrayList<CharSequence> arrayList = a.o((a)this.z).h.l;
                CharSequence charSequence = null;
                if (arrayList != null) {
                    int n2 = this.getAdapterPosition();
                    int n3 = a.o((a)this.z).h.l.size();
                    charSequence = null;
                    if (n2 < n3) {
                        charSequence = (CharSequence)a.o((a)this.z).h.l.get(this.getAdapterPosition());
                    }
                }
                CharSequence charSequence2 = charSequence;
                this.z.k.a(this.z.h, view, this.getAdapterPosition(), charSequence2, false);
            }
        }

        public boolean onLongClick(View view) {
            if (this.z.k != null && this.getAdapterPosition() != -1) {
                ArrayList<CharSequence> arrayList = a.o((a)this.z).h.l;
                CharSequence charSequence = null;
                if (arrayList != null) {
                    int n2 = this.getAdapterPosition();
                    int n3 = a.o((a)this.z).h.l.size();
                    charSequence = null;
                    if (n2 < n3) {
                        charSequence = (CharSequence)a.o((a)this.z).h.l.get(this.getAdapterPosition());
                    }
                }
                CharSequence charSequence2 = charSequence;
                return this.z.k.a(this.z.h, view, this.getAdapterPosition(), charSequence2, true);
            }
            return false;
        }
    }

    static interface c {
        public boolean a(f var1, View var2, int var3, CharSequence var4, boolean var5);
    }

}

