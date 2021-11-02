/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.fragment.app.s
 *  androidx.preference.Preference
 *  androidx.preference.l
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  com.jaredrummler.android.colorpicker.c
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.recyclerview.widget.RecyclerView;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.c;
import com.jaredrummler.android.colorpicker.d;
import com.jaredrummler.android.colorpicker.h;
import com.jaredrummler.android.colorpicker.i;
import com.jaredrummler.android.colorpicker.j;
import com.jaredrummler.android.colorpicker.k;

public class ColorPreferenceCompat
extends Preference
implements d {
    private a f;
    private int g = -16777216;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int[] p;
    private int q;

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e(attributeSet);
    }

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.e(attributeSet);
    }

    private void e(AttributeSet attributeSet) {
        this.setPersistent(true);
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, k.B);
        this.h = typedArray.getBoolean(k.L, true);
        this.i = typedArray.getInt(k.H, 1);
        this.j = typedArray.getInt(k.F, 1);
        this.k = typedArray.getBoolean(k.D, true);
        this.l = typedArray.getBoolean(k.C, true);
        this.m = typedArray.getBoolean(k.J, false);
        this.n = typedArray.getBoolean(k.K, true);
        this.o = typedArray.getInt(k.I, 0);
        int n2 = typedArray.getResourceId(k.E, 0);
        this.q = typedArray.getResourceId(k.G, j.b);
        this.p = n2 != 0 ? this.getContext().getResources().getIntArray(n2) : c.v;
        if (this.j == 1) {
            int n3 = this.o == 1 ? i.f : i.e;
            this.setWidgetLayoutResource(n3);
        } else {
            int n4 = this.o == 1 ? i.h : i.g;
            this.setWidgetLayoutResource(n4);
        }
        typedArray.recycle();
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void b(int n2, int n3) {
        this.f(n3);
    }

    public androidx.fragment.app.d c() {
        Context context;
        Context context2 = this.getContext();
        if (context2 instanceof androidx.fragment.app.d) {
            return (androidx.fragment.app.d)context2;
        }
        if (context2 instanceof ContextWrapper && (context = ((ContextWrapper)context2).getBaseContext()) instanceof androidx.fragment.app.d) {
            return (androidx.fragment.app.d)context;
        }
        throw new IllegalStateException("Error getting activity from context");
    }

    public String d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("color_");
        stringBuilder.append(this.getKey());
        return stringBuilder.toString();
    }

    public void f(int n2) {
        this.g = n2;
        this.persistInt(n2);
        this.notifyChanged();
        this.callChangeListener((Object)n2);
    }

    public void onAttached() {
        c c2;
        super.onAttached();
        if (this.h && (c2 = (c)this.c().R().j0(this.d())) != null) {
            c2.b0((d)this);
        }
    }

    public void onBindViewHolder(l l2) {
        super.onBindViewHolder(l2);
        ColorPanelView colorPanelView = (ColorPanelView)l2.itemView.findViewById(h.h);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.g);
        }
    }

    protected void onClick() {
        super.onClick();
        a a2 = this.f;
        if (a2 != null) {
            a2.a((String)this.getTitle(), this.g);
            return;
        }
        if (this.h) {
            c c2 = c.W().g(this.i).f(this.q).e(this.j).h(this.p).c(this.k).b(this.l).i(this.m).j(this.n).d(this.g).a();
            c2.b0((d)this);
            this.c().R().n().e((Fragment)c2, this.d()).j();
        }
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int n2) {
        return typedArray.getInteger(n2, -16777216);
    }

    protected void onSetInitialValue(Object object) {
        super.onSetInitialValue(object);
        if (object instanceof Integer) {
            int n2;
            this.g = n2 = ((Integer)object).intValue();
            this.persistInt(n2);
            return;
        }
        this.g = this.getPersistedInt(-16777216);
    }

}

