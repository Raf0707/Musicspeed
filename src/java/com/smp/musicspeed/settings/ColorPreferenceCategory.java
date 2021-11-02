/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.TextView
 *  androidx.preference.PreferenceCategory
 *  androidx.preference.l
 *  b.i.h.a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package com.smp.musicspeed.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.PreferenceCategory;
import androidx.preference.l;
import b.i.h.a;
import com.smp.musicspeed.utils.o;
import f.z.d.k;
import java.util.Objects;

public final class ColorPreferenceCategory
extends PreferenceCategory {
    public ColorPreferenceCategory(Context context) {
        k.g((Object)context, "context");
        super(context);
    }

    public ColorPreferenceCategory(Context context, AttributeSet attributeSet) {
        k.g((Object)context, "context");
        k.g((Object)attributeSet, "attrs");
        super(context, attributeSet);
    }

    public ColorPreferenceCategory(Context context, AttributeSet attributeSet, int n2) {
        k.g((Object)context, "context");
        k.g((Object)attributeSet, "attrs");
        super(context, attributeSet, n2);
    }

    public void onBindViewHolder(l l2) {
        k.g((Object)l2, "view");
        super.onBindViewHolder(l2);
        if (this.getContext() != null) {
            View view = l2.Z(16908310);
            Objects.requireNonNull((Object)view, (String)"null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView)view;
            Context context = this.getContext();
            Context context2 = this.getContext();
            k.f((Object)context2, "context");
            textView.setTextColor(a.c((Context)context, (int)o.b(context2)));
        }
    }
}

