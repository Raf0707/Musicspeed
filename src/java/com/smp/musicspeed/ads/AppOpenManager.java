/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.i
 *  androidx.lifecycle.i$b
 *  androidx.lifecycle.o
 *  androidx.lifecycle.y
 *  androidx.lifecycle.z
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.appopen.AppOpenAd
 *  com.google.android.gms.ads.appopen.AppOpenAd$AppOpenAdLoadCallback
 *  com.google.android.gms.ads.appopen.AppOpenAd$AppOpenAdOrientation
 *  com.smp.musicspeed.ads.AppOpenManager$a
 *  com.smp.musicspeed.ads.AppOpenManager$b
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 *  kotlinx.coroutines.t1
 *  kotlinx.coroutines.t1$a
 */
package com.smp.musicspeed.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.michaelflisar.gdprdialog.d;
import com.michaelflisar.gdprdialog.e;
import com.smp.musicspeed.MusicSpeedChangerApplication;
import com.smp.musicspeed.ads.AppOpenManager;
import com.smp.musicspeed.ads.x;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.f;
import com.smp.musicspeed.utils.l;
import f.m;
import f.n;
import f.t;
import f.z.d.g;
import f.z.d.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.t1;

public final class AppOpenManager
implements Application.ActivityLifecycleCallbacks,
o,
k0 {
    public static final Companion f;
    private static final String g;
    private static boolean h;
    private final MusicSpeedChangerApplication i;
    private final /* synthetic */ k0 j;
    private AppOpenAd k;
    private AppOpenAd l;
    private t1 m;
    private t1 n;
    private Activity o;
    private final AppOpenAd.AppOpenAdLoadCallback p;
    private final AppOpenAd.AppOpenAdLoadCallback q;

    static {
        Object object = new Object(null){
            {
                this();
            }

            public final native String getRealId();
        };
        f = object;
        g = object.getRealId();
    }

    public AppOpenManager(MusicSpeedChangerApplication musicSpeedChangerApplication) {
        k.g((Object)musicSpeedChangerApplication, "application");
        this.i = musicSpeedChangerApplication;
        this.j = l0.b();
        musicSpeedChangerApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        z.i().getLifecycle().a((o)this);
        this.p = new b(this);
        this.q = new a(this);
    }

    public static final /* synthetic */ void h(AppOpenManager appOpenManager, int n2) {
        appOpenManager.o(n2);
    }

    public static final /* synthetic */ void i(AppOpenManager appOpenManager, AppOpenAd appOpenAd) {
        appOpenManager.l = appOpenAd;
    }

    public static final /* synthetic */ void j(AppOpenManager appOpenManager, AppOpenAd appOpenAd) {
        appOpenManager.k = appOpenAd;
    }

    public static final /* synthetic */ void k(AppOpenManager appOpenManager, t1 t12) {
        appOpenManager.n = t12;
    }

    public static final /* synthetic */ void l(AppOpenManager appOpenManager, t1 t12) {
        appOpenManager.m = t12;
    }

    public static final /* synthetic */ void m(boolean bl) {
        h = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void o(@AppOpenAd.AppOpenAdOrientation int n2) {
        if (n2 == 1) {
            t1 t12 = this.m;
            if (t12 != null) {
                t1.a.a((t1)t12, null, (int)1, null);
            }
        } else {
            t1 t13 = this.n;
            if (t13 != null) {
                t1.a.a((t1)t13, null, (int)1, null);
            }
        }
        try {
            MusicSpeedChangerApplication musicSpeedChangerApplication = this.q();
            String string = g;
            AdRequest adRequest = this.p();
            AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = n2 == 1 ? this.p : this.q;
            AppOpenAd.load((Context)musicSpeedChangerApplication, (String)string, (AdRequest)adRequest, (int)n2, (AppOpenAd.AppOpenAdLoadCallback)appOpenAdLoadCallback);
            m.b(t.a);
            return;
        }
        catch (Throwable throwable) {
            m.b(n.a(throwable));
            return;
        }
    }

    private final AdRequest p() {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (com.michaelflisar.gdprdialog.c.e().d().a() == d.h) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, f.b);
        }
        AdRequest adRequest = builder.build();
        k.f((Object)adRequest, "Builder().apply {\n                val state = GDPR.getInstance().consentState\n                if (state.consent == GDPRConsent.NON_PERSONAL_CONSENT_ONLY) {\n                    addNetworkExtrasBundle(AdMobAdapter::class.java, EuHelper.npaBundle)\n                }\n            }.build()");
        return adRequest;
    }

    private final boolean r() {
        return this.l != null;
    }

    private final boolean s() {
        return this.k != null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void t() {
        Object object;
        block8 : {
            block6 : {
                AppOpenAd appOpenAd;
                Activity activity;
                block7 : {
                    activity = this.o;
                    if (activity == null) {
                        return;
                    }
                    final boolean bl = l.d((Context)activity);
                    boolean bl2 = bl ? this.r() : this.s();
                    if (!h && bl2) {
                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback(){

                            public void onAdDismissedFullScreenContent() {
                                if (bl) {
                                    AppOpenManager.i(this, null);
                                } else {
                                    AppOpenManager.j(this, null);
                                }
                                AppOpenManager.m(false);
                                AppOpenManager.u(this);
                            }

                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                k.g((Object)adError, "adError");
                            }

                            public void onAdShowedFullScreenContent() {
                                AppOpenManager.m(true);
                            }
                        };
                        appOpenAd = bl ? this.l : this.k;
                        try {
                            if (AppPrefs.k.D()) break block6;
                            Object object2 = x.f.b().f();
                            k.e(object2);
                            if (((Boolean)object2).booleanValue()) break block6;
                            if (appOpenAd != null) {
                                appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                            }
                            break block7;
                        }
                        catch (Throwable throwable) {
                            object = m.b(n.a(throwable));
                            break block8;
                        }
                    }
                    AppOpenManager.u(this);
                    return;
                }
                if (appOpenAd != null) {
                    appOpenAd.show(activity);
                }
            }
            object = m.b(t.a);
        }
        m.a(object);
    }

    private static final void u(AppOpenManager appOpenManager) {
        if (!appOpenManager.r()) {
            appOpenManager.o(2);
        }
        if (!appOpenManager.s()) {
            appOpenManager.o(1);
        }
    }

    public f.w.g L() {
        return this.j.L();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        k.g((Object)activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        k.g((Object)activity, "activity");
        this.o = null;
    }

    public void onActivityPaused(Activity activity) {
        k.g((Object)activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        k.g((Object)activity, "activity");
        this.o = activity;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        k.g((Object)activity, "activity");
        k.g((Object)bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        k.g((Object)activity, "activity");
        this.o = activity;
    }

    public void onActivityStopped(Activity activity) {
        k.g((Object)activity, "activity");
    }

    @y(value=i.b.ON_START)
    public final void onStart() {
        this.t();
    }

    public final MusicSpeedChangerApplication q() {
        return this.i;
    }

}

