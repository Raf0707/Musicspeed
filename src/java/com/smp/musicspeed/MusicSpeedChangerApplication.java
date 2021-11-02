/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.StrictMode
 *  android.os.StrictMode$VmPolicy
 *  android.os.StrictMode$VmPolicy$Builder
 *  android.preference.PreferenceManager
 *  androidx.appcompat.app.g
 *  androidx.room.i
 *  androidx.room.j
 *  androidx.room.j$a
 *  androidx.room.s.a
 *  b.r.a
 *  c.c.a.c
 *  c.d.a.a.k.a
 *  c.d.a.a.k.c
 *  c.d.a.a.k.d
 *  c.d.a.a.k.e
 *  c.d.a.a.l.a
 *  c.d.a.a.l.b
 *  c.d.a.a.m.a
 *  c.d.a.a.m.c
 *  c.d.a.a.m.d
 *  c.d.a.a.m.f.b
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.e
 *  c.d.a.a.m.h.a
 *  c.d.a.a.m.h.c
 *  c.d.a.a.m.h.d
 *  c.d.a.a.m.h.e
 *  com.smp.musicspeed.ads.AppOpenManager
 *  com.smp.musicspeed.dbrecord.AppDatabase
 *  com.smp.musicspeed.h0.a
 *  com.smp.musicspeed.h0.b
 *  com.smp.musicspeed.player.ElastiquePlayer
 *  com.smp.musicspeed.utils.AppPrefs
 *  com.smp.musicspeed.utils.f
 *  com.smp.musicspeed.utils.t
 *  f.z.d.g
 *  f.z.d.k
 *  io.paperdb.Paper
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  org.greenrobot.eventbus.c
 *  org.greenrobot.eventbus.d
 */
package com.smp.musicspeed;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import androidx.room.i;
import androidx.room.j;
import c.d.a.a.m.f.e;
import com.smp.musicspeed.ads.AdsProvider;
import com.smp.musicspeed.ads.AppOpenManager;
import com.smp.musicspeed.dbrecord.AppDatabase;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.h0.b;
import com.smp.musicspeed.player.ElastiquePlayer;
import com.smp.musicspeed.utils.AppPrefs;
import com.smp.musicspeed.utils.f;
import com.smp.musicspeed.utils.t;
import f.z.d.g;
import f.z.d.k;
import io.paperdb.Paper;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.d;

public final class MusicSpeedChangerApplication
extends Application {
    public static final a f = new a(null);
    public static AppOpenManager g;
    public static AppDatabase h;

    protected void attachBaseContext(Context context) {
        k.g((Object)context, (String)"base");
        super.attachBaseContext(context);
        b.r.a.l((Context)this);
    }

    public final native void initSuperpowered();

    public void onConfigurationChanged(Configuration configuration) {
        k.g((Object)configuration, (String)"newConfig");
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        block10 : {
            block14 : {
                c.d.a.a.m.h.c c2;
                c.d.a.a.k.d d2;
                a a2;
                block12 : {
                    block13 : {
                        block11 : {
                            block8 : {
                                block9 : {
                                    block7 : {
                                        super.onCreate();
                                        c.c.a.c c3 = c.c.a.c.a;
                                        Context context = this.getApplicationContext();
                                        k.f((Object)context, (String)"applicationContext");
                                        c3.a(context);
                                        a2 = f;
                                        j.a a3 = i.a((Context)this, AppDatabase.class, (String)"AppDataBase-Room").c();
                                        androidx.room.s.a[] arra = new androidx.room.s.a[]{AppDatabaseKt.getMIGRATION_1_2(), AppDatabaseKt.getMIGRATION_2_3(), AppDatabaseKt.getMIGRATION_3_4()};
                                        j j2 = a3.b(arra).d();
                                        k.f((Object)j2, (String)"databaseBuilder(this, AppDatabase::class.java, \"AppDataBase-Room\")\n                .allowMainThreadQueries()\n                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)\n                .build()");
                                        a2.d((AppDatabase)j2);
                                        c.b().f(true).e();
                                        Paper.init((Context)this.getApplicationContext());
                                        f.a((Context)this);
                                        c.d.a.a.m.a.u((c.d.a.a.l.b)new c.d.a.a.l.a());
                                        if (!k.c((Object)"play", (Object)"play")) break block7;
                                        d2 = new c.d.a.a.k.d();
                                        break block8;
                                    }
                                    if (!k.c((Object)"play", (Object)"amazon")) break block9;
                                    d2 = new c.d.a.a.k.a();
                                    break block8;
                                }
                                if (!k.c((Object)"play", (Object)"huawei")) break block10;
                                d2 = new com.smp.musicspeed.h0.a();
                            }
                            if (!k.c((Object)"play", (Object)"play")) break block11;
                            c2 = new c.d.a.a.m.h.c();
                            break block12;
                        }
                        if (!k.c((Object)"play", (Object)"amazon")) break block13;
                        c2 = new c.d.a.a.m.h.a();
                        break block12;
                    }
                    if (!k.c((Object)"play", (Object)"huawei")) break block14;
                    c2 = new b();
                }
                c.d.a.a.m.a a4 = c.d.a.a.m.a.l((Application)this).v(new c.d.a.a.k.e[]{d2}).g((c.d.a.a.m.f.b)c2);
                c.d.a.a.k.e[] arre = new c.d.a.a.k.e[]{new c.d.a.a.k.c(new String[]{"support@musicspeedchanger.com"})};
                c.d.a.a.m.a a5 = a4.q(arre).t(1).s(15).i((c.d.a.a.m.f.d)c.d.a.a.m.c.h, (e)new c.d.a.a.m.h.d(1));
                c.d.a.a.m.c c4 = c.d.a.a.m.c.j;
                a5.h((c.d.a.a.m.f.d)c4, (e)new c.d.a.a.m.h.e(this.getApplicationContext())).i((c.d.a.a.m.f.d)c.d.a.a.m.d.f, (e)new c.d.a.a.m.h.d(7)).i((c.d.a.a.m.f.d)c.d.a.a.m.c.i, (e)new c.d.a.a.m.h.d(1)).i((c.d.a.a.m.f.d)c4, (e)new c.d.a.a.m.h.d(3)).i((c.d.a.a.m.f.d)c.d.a.a.m.c.k, (e)new c.d.a.a.m.h.d(2)).r(6).p(false);
                ElastiquePlayer.init();
                this.initSuperpowered();
                if (Build.VERSION.SDK_INT >= 24) {
                    StrictMode.setVmPolicy((StrictMode.VmPolicy)new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
                }
                androidx.appcompat.app.g.D((boolean)true);
                Context context = this.getApplicationContext();
                k.f((Object)context, (String)"this.applicationContext");
                a2.c(context);
                com.michaelflisar.gdprdialog.c.e().g((Context)this);
                AppPrefs appPrefs = AppPrefs.k;
                if (!appPrefs.D()) {
                    AdsProvider adsProvider = AdsProvider.a;
                    Context context2 = this.getApplicationContext();
                    k.f((Object)context2, (String)"this.applicationContext");
                    adsProvider.g(context2);
                    if (appPrefs.z() == -1L) {
                        appPrefs.m0(System.currentTimeMillis());
                    }
                    if (System.currentTimeMillis() - appPrefs.z() > 172800000L) {
                        a2.b(new AppOpenManager(this));
                    }
                }
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    public void onTerminate() {
        super.onTerminate();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final AppDatabase a() {
            AppDatabase appDatabase = MusicSpeedChangerApplication.h;
            if (appDatabase != null) {
                return appDatabase;
            }
            k.s((String)"database");
            throw null;
        }

        public final void b(AppOpenManager appOpenManager) {
            k.g((Object)appOpenManager, (String)"<set-?>");
            MusicSpeedChangerApplication.g = appOpenManager;
        }

        public final void c(Context context) {
            k.g((Object)context, (String)"context");
            boolean bl = t.w((Context)context);
            if (k.c((Object)PreferenceManager.getDefaultSharedPreferences((Context)context).getString("preferences_theme", context.getString(2131820723)), (Object)"System default")) {
                androidx.appcompat.app.g.H((int)-1);
                return;
            }
            if (bl) {
                androidx.appcompat.app.g.H((int)2);
                return;
            }
            androidx.appcompat.app.g.H((int)1);
        }

        public final void d(AppDatabase appDatabase) {
            k.g((Object)appDatabase, (String)"<set-?>");
            MusicSpeedChangerApplication.h = appDatabase;
        }
    }

}

