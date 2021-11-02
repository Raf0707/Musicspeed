/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  androidx.appcompat.app.a
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$k
 *  androidx.fragment.app.FragmentManager$n
 *  androidx.fragment.app.h
 *  androidx.fragment.app.s
 *  androidx.preference.Preference
 *  androidx.preference.g
 *  androidx.preference.g$f
 *  b.i.h.a
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.preference.Preference;
import androidx.preference.g;
import c.h.a.a;
import com.smp.masterswitchpreference.MasterSwitchPreferenceAttrs;
import com.smp.masterswitchpreference.MasterSwitchPreferenceFragment;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.MusicSpeedChangerApplication;
import com.smp.musicspeed.k0.m0.h;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.settings.d;
import com.smp.musicspeed.settings.e;
import com.smp.musicspeed.settings.g;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import f.z.d.k;
import java.io.File;
import java.util.List;

public final class SettingsActivity
extends androidx.appcompat.app.e
implements SharedPreferences.OnSharedPreferenceChangeListener,
a.e,
g.f {
    public static /* synthetic */ void l0(SettingsActivity settingsActivity) {
        SettingsActivity.m0(settingsActivity);
    }

    private static final void m0(SettingsActivity settingsActivity) {
        k.g(settingsActivity, "this$0");
        int n2 = settingsActivity.R().o0();
        if (n2 == 0) {
            settingsActivity.setTitle(2131820653);
            return;
        }
        FragmentManager.k k2 = settingsActivity.R().n0(n2 - 1);
        k.f((Object)k2, "supportFragmentManager.getBackStackEntryAt(ec - 1)");
        settingsActivity.setTitle((CharSequence)k2.getName());
    }

    @Override
    public void A() {
    }

    @Override
    public void F(File file) {
        if (file != null && file.canWrite()) {
            SharedPreferences.Editor editor = t.o((Context)this).edit();
            editor.putString("preferences_store_path", file.getAbsolutePath());
            editor.apply();
            String string = this.getString(2131821313);
            k.f(string, "getString(R.string.toast_creations_directory)");
            z.m(string, (Context)this, 1);
            h.a((Context)this);
            androidx.preference.g g2 = (androidx.preference.g)this.R().i0(2131297116);
            if (g2 != null) {
                Preference preference = g2.findPreference((CharSequence)"preferences_store_path");
                k.e((Object)preference);
                preference.callChangeListener((Object)file);
                return;
            }
        } else {
            String string = this.getString(2131821308);
            k.f(string, "getString(R.string.toast_cant_write)");
            z.n(string, (Context)this, 0, 2, null);
        }
    }

    @Override
    public void a() {
        String string = this.getString(2131821308);
        k.f(string, "getString(R.string.toast_cant_write)");
        z.n(string, (Context)this, 0, 2, null);
    }

    public boolean g0() {
        if (!this.R().a1()) {
            this.finish();
            this.startActivity(new Intent((Context)this, MainActivity.class));
        }
        return true;
    }

    public void onBackPressed() {
        this.g0();
    }

    protected void onCreate(Bundle bundle) {
        a a2;
        super.onCreate(bundle);
        this.setTheme(o.e((Context)this));
        this.setContentView(2131492898);
        if (Build.VERSION.SDK_INT >= 21 && (a2 = this.b0()) != null) {
            a2.s(t.b((Context)this, 4.0f));
        }
        if (bundle == null) {
            androidx.preference.g g2;
            if (this.getIntent().getBooleanExtra("showCustom", false)) {
                this.setTitle((CharSequence)this.getString(2131821201));
                MasterSwitchPreferenceFragment.Companion companion = MasterSwitchPreferenceFragment.Companion;
                String string = this.getString(2131821212);
                String string2 = this.getString(2131821223);
                int n2 = g.a((Activity)this, 2130969202);
                int n3 = b.i.h.a.c((Context)this, (int)2131099933);
                int n4 = b.i.h.a.c((Context)this, (int)2131100320);
                String string3 = this.getString(2131821191);
                String string4 = this.getString(2131821192);
                int n5 = b.i.h.a.c((Context)this, (int)2131100038);
                int n6 = b.i.h.a.c((Context)this, (int)2131100040);
                k.f(string2, "getString(R.string.preference_summary_custom_ui_long)");
                Integer n7 = 2132017157;
                k.f(string4, "getString(R.string.pref_custom_selected)");
                k.f(string3, "getString(R.string.pref_custom_not_selected)");
                k.f(string, "getString(R.string.preference_key_custom_components)");
                MasterSwitchPreferenceAttrs masterSwitchPreferenceAttrs = new MasterSwitchPreferenceAttrs(n5, n6, n3, n2, n4, string2, null, n7, null, string4, string3, false, string, false, null, false, 51520, null);
                g2 = companion.newInstance(masterSwitchPreferenceAttrs);
            } else {
                g2 = new e();
            }
            this.R().n().q(2131297116, (Fragment)g2).i();
        } else {
            this.setTitle(bundle.getCharSequence("settingsActivityTitle"));
        }
        this.R().i((FragmentManager.n)new d(this));
        a a3 = this.b0();
        if (a3 != null) {
            a3.r(true);
        }
        t.O((Context)this, this);
    }

    protected void onDestroy() {
        t.g0((Context)this, this);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        k.g((Object)bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("settingsActivityTitle", this.getTitle());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        k.g((Object)sharedPreferences, "sharedPreferences");
        k.g(string, "key");
        int n2 = string.hashCode();
        if (!(n2 != -491571232 ? (n2 != -218651243 ? n2 != 708156866 || !string.equals((Object)"preferences_theme") : !string.equals((Object)"preferences_accent_color")) : !string.equals((Object)"preferences_accent_color_dark"))) {
            MusicSpeedChangerApplication.f.c((Context)this);
            this.finish();
            this.startActivity(new Intent((Context)this, SettingsActivity.class));
        }
        if (k.c(string, this.getString(2131821212))) {
            AppPrefs appPrefs = AppPrefs.k;
            if (appPrefs.K()) {
                appPrefs.H0(appPrefs.b0());
                appPrefs.K0(5);
                appPrefs.p0(true);
            } else {
                appPrefs.K0(appPrefs.Y());
            }
        }
        if (k.c(string, "preferences_file_type")) {
            List list = this.R().u0();
            k.f((Object)list, "supportFragmentManager.fragments");
            if (true ^ list.isEmpty()) {
                Object object = list.get(0);
                e e2 = object instanceof e ? (e)((Object)object) : null;
                if (e2 == null) {
                    return;
                }
                e2.v();
            }
        }
    }

    public boolean z(androidx.preference.g g2, Preference preference) {
        k.g((Object)g2, "caller");
        k.g((Object)preference, "pref");
        Bundle bundle = preference.getExtras();
        Fragment fragment = this.R().s0().a(this.getClassLoader(), preference.getFragment());
        fragment.setArguments(bundle);
        fragment.setTargetFragment((Fragment)g2, 0);
        k.f((Object)fragment, "supportFragmentManager.fragmentFactory.instantiate(\n                classLoader,\n                pref.fragment\n        ).apply {\n            arguments = args\n            setTargetFragment(caller, 0)\n        }");
        this.R().n().q(2131297116, fragment).g(preference.getTitle().toString()).i();
        this.setTitle(preference.getTitle());
        return true;
    }
}

