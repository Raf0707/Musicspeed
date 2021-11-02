/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.TextView
 *  androidx.appcompat.widget.SwitchCompat
 *  androidx.core.graphics.drawable.a
 *  androidx.preference.SwitchPreferenceCompat
 *  androidx.preference.l
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 */
package com.smp.masterswitchpreference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.l;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.masterswitchpreference.MasterSwitchPreferenceAttrs;
import f.t;
import f.z.d.k;

public final class MasterSwitchSwitchPreference
extends SwitchPreferenceCompat {
    public MasterSwitchPreferenceAttrs n;
    public View o;
    public SwitchCompat p;
    public TextView q;

    public MasterSwitchSwitchPreference(Context context) {
        super(context);
    }

    public MasterSwitchSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void n() {
        MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs;
        View view = this.o;
        if (view == null) {
            k.s("background");
        }
        if ((masterSwitchPreferenceAttrs = this.n) == null) {
            k.s("attrs");
        }
        view.setBackgroundColor(masterSwitchPreferenceAttrs.getSwitchOffBackgroundColor());
    }

    public final void o() {
        MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs;
        View view = this.o;
        if (view == null) {
            k.s("background");
        }
        if ((masterSwitchPreferenceAttrs = this.n) == null) {
            k.s("attrs");
        }
        view.setBackgroundColor(masterSwitchPreferenceAttrs.getSwitchOnBackgroundColor());
    }

    public void onBindViewHolder(l l2) {
        View view;
        super.onBindViewHolder(l2);
        new f.z.c.l<TextView, t>(){

            @Override
            public Object g(Object object) {
                TextView textView = (TextView)object;
                k.h((Object)textView, "textView");
                textView.setTextColor(this.p().getSwitchTextColor());
                return t.a;
            }
        };
        f.z.c.a<t> a2 = new f.z.c.a<t>(){

            public final void a() {
                Drawable drawable;
                Drawable drawable2;
                SwitchCompat switchCompat;
                SwitchCompat switchCompat2 = this.p;
                if (switchCompat2 == null) {
                    k.s("switch");
                }
                if ((drawable = switchCompat2.getThumbDrawable()) != null) {
                    androidx.core.graphics.drawable.a.n((Drawable)drawable, (int)this.p().getSwitchThumbColor());
                }
                if ((switchCompat = this.p) == null) {
                    k.s("switch");
                }
                if ((drawable2 = switchCompat.getTrackDrawable()) != null) {
                    androidx.core.graphics.drawable.a.n((Drawable)drawable2, (int)this.p().getSwitchTrackColor());
                }
            }
        };
        if (l2 != null && (view = l2.itemView) != null) {
            k.d((Object)view, "view");
            this.o = view;
            View view2 = view.findViewById(com.smp.masterswitchpreference.a.b);
            k.d((Object)view2, "view.findViewById(R.id.switchWidget)");
            this.p = (SwitchCompat)view2;
            View view3 = view.findViewById(16908310);
            k.d((Object)view3, "view.findViewById(android.R.id.title)");
            this.q = (TextView)view3;
            a2.a();
            SwitchCompat switchCompat = this.p;
            if (switchCompat == null) {
                k.s("switch");
            }
            if (switchCompat.isChecked()) {
                this.o();
            } else {
                this.n();
            }
            TextView textView = this.q;
            if (textView == null) {
                k.s("text");
            }
            k.h((Object)textView, "textView");
            textView.setTextColor(this.p().getSwitchTextColor());
        }
    }

    public final MasterSwitchPreferenceAttrs p() {
        MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs = this.n;
        if (masterSwitchPreferenceAttrs == null) {
            k.s("attrs");
        }
        return masterSwitchPreferenceAttrs;
    }

}

