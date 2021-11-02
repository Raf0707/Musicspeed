/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.preference.Preference
 *  androidx.preference.l
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.masterswitchpreference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.masterswitchpreference.a;
import f.q;
import f.z.d.k;

public final class MasterSwitchExplanationText
extends Preference {
    public MasterSwitchExplanationText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onBindViewHolder(l l2) {
        View view;
        super.onBindViewHolder(l2);
        if (l2 != null && (view = l2.itemView) != null) {
            k.d((Object)view, "view");
            view.setClickable(false);
            View view2 = view.findViewById(a.a);
            k.d((Object)view2, "frame");
            Context context = view.getContext();
            k.d((Object)context, "view.context");
            k.h((Object)context, "context");
            Resources resources = context.getResources();
            k.d((Object)resources, "context.resources");
            int n2 = (int)TypedValue.applyDimension((int)1, (float)18.0f, (DisplayMetrics)resources.getDisplayMetrics());
            view2.setPadding(view2.getPaddingLeft(), n2, view2.getPaddingRight(), view2.getPaddingBottom());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)layoutParams;
                layoutParams2.gravity = 48;
                view2.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
                View view3 = view.findViewById(16908304);
                k.d((Object)view3, "view.findViewById<TextView>(android.R.id.summary)");
                ((TextView)view3).setMaxLines(1000);
                return;
            }
            throw new q("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }
}

