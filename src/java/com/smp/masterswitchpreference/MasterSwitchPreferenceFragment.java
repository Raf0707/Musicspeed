/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.LayoutAnimationController
 *  androidx.annotation.Keep
 *  androidx.preference.Preference
 *  androidx.preference.Preference$c
 *  androidx.preference.PreferenceScreen
 *  androidx.preference.g
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$l
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 */
package com.smp.masterswitchpreference;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import androidx.annotation.Keep;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.masterswitchpreference.MasterSwitchPreferenceAttrs;
import com.smp.masterswitchpreference.MasterSwitchPreferenceFragment;
import com.smp.masterswitchpreference.MasterSwitchSwitchPreference;
import f.f;
import f.t;
import f.z.c.l;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public class MasterSwitchPreferenceFragment
extends androidx.preference.g {
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        public final MasterSwitchPreferenceFragment newInstance(MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs) {
            k.h(masterSwitchPreferenceAttrs, "attrs");
            MasterSwitchPreferenceFragment masterSwitchPreferenceFragment = new MasterSwitchPreferenceFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MasterSwitchAttrs", (Parcelable)masterSwitchPreferenceAttrs);
            masterSwitchPreferenceFragment.setArguments(bundle);
            return masterSwitchPreferenceFragment;
        }
    };
    private HashMap _$_findViewCache;
    private final f attrs$delegate = f.g.a(new f.z.c.a<MasterSwitchPreferenceAttrs>(this){
        public final /* synthetic */ MasterSwitchPreferenceFragment g;
        {
            this.g = masterSwitchPreferenceFragment;
            super(0);
        }

        public Object invoke() {
            Parcelable parcelable = this.g.requireArguments().getParcelable("MasterSwitchAttrs");
            if (parcelable == null) {
                k.o();
            }
            return (MasterSwitchPreferenceAttrs)parcelable;
        }
    });

    private final void setupExplanationText(Preference preference) {
        Integer n2 = this.getAttrs().getExplanationIcon();
        if (n2 != null) {
            preference.setIcon(n2.intValue());
        }
    }

    private final void setupMasterSwitch(MasterSwitchSwitchPreference masterSwitchSwitchPreference, Preference preference, List<? extends Preference> list) {
        l<Boolean, t> l2 = new l<Boolean, t>(this, preference, list){
            public final /* synthetic */ MasterSwitchPreferenceFragment g;
            public final /* synthetic */ Preference h;
            public final /* synthetic */ List i;
            {
                this.g = masterSwitchPreferenceFragment;
                this.h = preference;
                this.i = list;
                super(1);
            }

            public final void a(boolean bl) {
                if (this.g.getAttrs().getHideExplanation()) {
                    this.h.setVisible(bl ^ true);
                }
                Preference preference = this.h;
                MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs = this.g.getAttrs();
                String string = bl ? masterSwitchPreferenceAttrs.getSwitchOnExplanationText() : masterSwitchPreferenceAttrs.getSwitchOffExplanationText();
                preference.setSummary((CharSequence)string);
                java.util.Iterator iterator = this.i.iterator();
                while (iterator.hasNext()) {
                    ((Preference)iterator.next()).setVisible(bl);
                }
            }
        };
        l<Boolean, String> l3 = new l<Boolean, String>(this){
            public final /* synthetic */ MasterSwitchPreferenceFragment g;
            {
                this.g = masterSwitchPreferenceFragment;
                super(1);
            }

            public final String a(boolean bl) {
                if (bl) {
                    return this.g.getAttrs().getSwitchOnText();
                }
                return this.g.getAttrs().getSwitchOffText();
            }
        };
        l<Boolean, t> l4 = new l<Boolean, t>(masterSwitchSwitchPreference){
            public final /* synthetic */ MasterSwitchSwitchPreference g;
            {
                this.g = masterSwitchSwitchPreference;
                super(1);
            }

            public Object g(Object object) {
                if (((Boolean)object).booleanValue()) {
                    this.g.o();
                } else {
                    this.g.n();
                }
                return t.a;
            }
        };
        MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs = this.getAttrs();
        masterSwitchSwitchPreference.getClass();
        k.h(masterSwitchPreferenceAttrs, "<set-?>");
        masterSwitchSwitchPreference.n = masterSwitchPreferenceAttrs;
        masterSwitchSwitchPreference.setKey(masterSwitchSwitchPreference.p().getKey());
        masterSwitchSwitchPreference.setDefaultValue((Object)masterSwitchSwitchPreference.p().getDefaultValue());
        masterSwitchSwitchPreference.setTitle((CharSequence)l3.a(masterSwitchSwitchPreference.c()));
        l2.a(masterSwitchSwitchPreference.c());
        Preference.c c2 = new Preference.c(masterSwitchSwitchPreference, l4, this, l3, l2){
            public final /* synthetic */ MasterSwitchSwitchPreference a;
            public final /* synthetic */ e b;
            public final /* synthetic */ d c;
            public final /* synthetic */ c d;
            {
                this.a = masterSwitchSwitchPreference;
                this.b = e2;
                this.c = d2;
                this.d = c2;
            }

            public final boolean a(Preference preference, Object object) {
                MasterSwitchSwitchPreference masterSwitchSwitchPreference = this.a;
                d d2 = this.c;
                if (object != null) {
                    Boolean bl = (Boolean)object;
                    masterSwitchSwitchPreference.setTitle((CharSequence)d2.a(bl));
                    this.d.a(bl);
                    e e2 = this.b;
                    if (bl.booleanValue()) {
                        e2.g.o();
                    } else {
                        e2.g.n();
                    }
                    return true;
                }
                throw new f.q("null cannot be cast to non-null type kotlin.Boolean");
            }
        };
        masterSwitchSwitchPreference.setOnPreferenceChangeListener(c2);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int n2) {
        View view;
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        if ((view = (View)this._$_findViewCache.get((Object)n2)) == null) {
            View view2 = this.getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(n2);
            this._$_findViewCache.put((Object)n2, (Object)view);
        }
        return view;
    }

    public final MasterSwitchPreferenceAttrs getAttrs() {
        return (MasterSwitchPreferenceAttrs)this.attrs$delegate.getValue();
    }

    public void onCreatePreferences(Bundle bundle, String string) {
        this.addPreferencesFromResource(com.smp.masterswitchpreference.c.a);
        MasterSwitchSwitchPreference masterSwitchSwitchPreference = new MasterSwitchSwitchPreference(this.getContext());
        masterSwitchSwitchPreference.setKey(this.getAttrs().getKey());
        masterSwitchSwitchPreference.setDefaultValue((Object)this.getAttrs().getDefaultValue());
        this.getPreferenceScreen().d((Preference)masterSwitchSwitchPreference);
        this.addPreferencesFromResource(com.smp.masterswitchpreference.c.b);
        Preference preference = this.findPreference((CharSequence)"com_smp_explanation_key");
        if (preference == null) {
            k.o();
        }
        k.d((Object)preference, "findPreference<Preferenc\u2026m_smp_explanation_key\")!!");
        Integer n2 = this.getAttrs().getIncludedPrefScreen();
        if (n2 != null) {
            this.addPreferencesFromResource(n2.intValue());
        }
        ArrayList arrayList = new ArrayList();
        PreferenceScreen preferenceScreen = this.getPreferenceScreen();
        k.d((Object)preferenceScreen, "preferenceScreen");
        int n3 = preferenceScreen.i();
        for (int i2 = 2; i2 < n3; ++i2) {
            Preference preference2 = this.getPreferenceScreen().h(i2);
            k.d((Object)preference2, "pref");
            arrayList.add((Object)preference2);
        }
        Integer n4 = this.getAttrs().getExcludedPrefScreen();
        if (n4 != null) {
            this.addPreferencesFromResource(n4.intValue());
        }
        this.setupMasterSwitch(masterSwitchSwitchPreference, preference, (List<? extends Preference>)arrayList);
        this.setupExplanationText(preference);
    }

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = super.onCreateRecyclerView(layoutInflater, viewGroup, bundle);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutAnimation(null);
        return recyclerView;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

}

