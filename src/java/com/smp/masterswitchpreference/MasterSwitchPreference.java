/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.AbsSavedState
 *  androidx.annotation.Keep
 *  androidx.preference.Preference
 *  androidx.preference.Preference$BaseSavedState
 *  com.smp.masterswitchpreference.MasterSwitchPreference$b
 *  com.smp.masterswitchpreference.MasterSwitchPreferenceFragment
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.masterswitchpreference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import androidx.annotation.Keep;
import androidx.preference.Preference;
import com.smp.masterswitchpreference.MasterSwitchPreference;
import com.smp.masterswitchpreference.MasterSwitchPreferenceAttrs;
import com.smp.masterswitchpreference.MasterSwitchPreferenceFragment;
import f.z.d.g;
import f.z.d.k;
import f.z.d.z;

@Keep
public class MasterSwitchPreference
extends Preference {
    public MasterSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inflateAttrs(attributeSet);
    }

    public MasterSwitchPreference(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.inflateAttrs(attributeSet);
    }

    public MasterSwitchPreference(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.inflateAttrs(attributeSet);
    }

    public MasterSwitchPreference(Context context, MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs) {
        k.h((Object)context, "context");
        k.h(masterSwitchPreferenceAttrs, "attrs");
        super(context);
        this.getExtras().putParcelable("MasterSwitchAttrs", (Parcelable)masterSwitchPreferenceAttrs);
    }

    private final MasterSwitchPreferenceAttrs getAttrs() {
        Parcelable parcelable = this.getExtras().getParcelable("MasterSwitchAttrs");
        if (parcelable == null) {
            k.o();
        }
        return (MasterSwitchPreferenceAttrs)parcelable;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void inflateAttrs(AttributeSet attributeSet) {
        Context context = this.getContext();
        k.d((Object)context, "context");
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, com.smp.masterswitchpreference.b.J, 0, 0);
        if (typedArray != null) {
            Context context2 = this.getContext();
            k.d((Object)context2, "context");
            TypedArray typedArray2 = context2.getTheme().obtainStyledAttributes(attributeSet, com.smp.masterswitchpreference.b.e0, 0, 0);
            String string = typedArray.getString(com.smp.masterswitchpreference.b.N);
            String string2 = typedArray.getString(com.smp.masterswitchpreference.b.K);
            String string3 = typedArray.getString(com.smp.masterswitchpreference.b.L);
            b b2 = new b(this, attributeSet);
            MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs = new MasterSwitchPreferenceAttrs(0, 0, 0, 0, 0, null, null, null, null, null, null, false, null, false, null, false, 65535, null);
            int n2 = typedArray.getColor(com.smp.masterswitchpreference.b.W, masterSwitchPreferenceAttrs.getSwitchThumbColor());
            int n3 = typedArray.getColor(com.smp.masterswitchpreference.b.X, masterSwitchPreferenceAttrs.getSwitchTrackColor());
            int n4 = typedArray.getColor(com.smp.masterswitchpreference.b.S, masterSwitchPreferenceAttrs.getSwitchOnBackgroundColor());
            int n5 = typedArray.getColor(com.smp.masterswitchpreference.b.P, masterSwitchPreferenceAttrs.getSwitchOffBackgroundColor());
            int n6 = typedArray.getColor(com.smp.masterswitchpreference.b.V, masterSwitchPreferenceAttrs.getSwitchTextColor());
            String string4 = typedArray.getString(com.smp.masterswitchpreference.b.Q);
            if (string4 == null) {
                string4 = masterSwitchPreferenceAttrs.getSwitchOffExplanationText();
            }
            String string5 = string4;
            String string6 = typedArray.getString(com.smp.masterswitchpreference.b.T);
            if (string6 == null) {
                string6 = masterSwitchPreferenceAttrs.getSwitchOnExplanationText();
            }
            String string7 = string6;
            Integer n7 = b2.a(string, "xml");
            if (n7 == null) {
                n7 = masterSwitchPreferenceAttrs.getIncludedPrefScreen();
            }
            Integer n8 = n7;
            Integer n9 = b2.a(string2, "xml");
            if (n9 == null) {
                n9 = masterSwitchPreferenceAttrs.getExcludedPrefScreen();
            }
            Integer n10 = n9;
            String string8 = typedArray.getString(com.smp.masterswitchpreference.b.U);
            if (string8 == null) {
                string8 = masterSwitchPreferenceAttrs.getSwitchOnText();
            }
            String string9 = string8;
            String string10 = typedArray.getString(com.smp.masterswitchpreference.b.R);
            if (string10 == null) {
                string10 = masterSwitchPreferenceAttrs.getSwitchOffText();
            }
            String string11 = string10;
            String string12 = this.getKey();
            if (string12 == null) {
                string12 = masterSwitchPreferenceAttrs.getKey();
            }
            String string13 = string12;
            int n11 = com.smp.masterswitchpreference.b.h0;
            boolean bl = typedArray2.hasValue(n11) || typedArray2.hasValue(n11 = com.smp.masterswitchpreference.b.f0) ? typedArray2.getBoolean(n11, false) : masterSwitchPreferenceAttrs.getDefaultValue();
            boolean bl2 = bl;
            boolean bl3 = typedArray.getBoolean(com.smp.masterswitchpreference.b.M, masterSwitchPreferenceAttrs.getHideExplanation());
            Integer n12 = b2.a(string3, "drawable");
            if (n12 == null) {
                n12 = masterSwitchPreferenceAttrs.getExplanationIcon();
            }
            MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs2 = new MasterSwitchPreferenceAttrs(n2, n3, n4, n5, n6, string5, string7, n8, n10, string9, string11, bl3, string13, bl2, n12, typedArray.getBoolean(com.smp.masterswitchpreference.b.O, masterSwitchPreferenceAttrs.getShowStatus()));
            int n13 = com.smp.masterswitchpreference.b.i0;
            String string14 = typedArray2.hasValue(n13) || typedArray2.hasValue(n13 = com.smp.masterswitchpreference.b.g0) ? typedArray2.getString(n13) : z.b(MasterSwitchPreferenceFragment.class).a();
            this.setDefaultValue((Object)masterSwitchPreferenceAttrs2.getDefaultValue());
            this.setKey(masterSwitchPreferenceAttrs2.getKey());
            this.setFragment(string14);
            this.getExtras().putParcelable("MasterSwitchAttrs", (Parcelable)masterSwitchPreferenceAttrs2);
            typedArray.recycle();
            typedArray2.recycle();
        }
    }

    private final void setupStatus() {
        if (this.getAttrs().getShowStatus()) {
            String string = this.getPersistedBoolean(this.getAttrs().getDefaultValue()) ? this.getAttrs().getSwitchOnText() : this.getAttrs().getSwitchOffText();
            this.setSummary((CharSequence)string);
        }
    }

    public void onAttached() {
        super.onAttached();
        this.setupStatus();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && !(true ^ k.c((Object)parcelable.getClass(), a.class))) {
            a a2 = (a)parcelable;
            super.onRestoreInstanceState(a2.getSuperState());
            this.getExtras().putParcelable("MasterSwitchAttrs", (Parcelable)a2.f);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        a a2 = new a(super.onSaveInstanceState());
        a2.f = this.getAttrs();
        return a2;
    }

    public static final class a
    extends Preference.BaseSavedState {
        public MasterSwitchPreferenceAttrs f;

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int n2) {
            k.h((Object)parcel, "dest");
            AbsSavedState.super.writeToParcel(parcel, n2);
            parcel.writeParcelable((Parcelable)this.f, 0);
        }
    }

}

