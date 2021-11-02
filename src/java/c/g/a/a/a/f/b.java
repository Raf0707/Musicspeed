/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  c.g.a.a.a.e.l
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.Iterator
 */
package c.g.a.a.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import c.g.a.a.a.e.l;
import java.util.Collection;
import java.util.Iterator;

public class b
implements Application.ActivityLifecycleCallbacks {
    @SuppressLint(value={"StaticFieldLeak"})
    private static b f = new b();
    private boolean g;
    private boolean h;
    private a i;

    private b() {
    }

    public static b a() {
        return f;
    }

    private void d(boolean bl) {
        if (this.h != bl) {
            this.h = bl;
            if (this.g) {
                this.h();
                a a2 = this.i;
                if (a2 != null) {
                    a2.b(bl ^ true);
                }
            }
        }
    }

    private void h() {
        boolean bl = true ^ this.h;
        Iterator iterator = c.g.a.a.a.f.a.a().c().iterator();
        while (iterator.hasNext()) {
            ((l)iterator.next()).t().m(bl);
        }
    }

    public void b(Context context) {
        if (context instanceof Application) {
            ((Application)context).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        }
    }

    public void c(a a2) {
        this.i = a2;
    }

    public void e() {
        this.g = true;
        this.h = false;
        this.h();
    }

    public void f() {
        this.g = false;
        this.h = false;
        this.i = null;
    }

    ActivityManager.RunningAppProcessInfo g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            int n2 = this.g().importance;
            boolean bl = true;
            boolean bl2 = n2 != 100;
            Iterator iterator = c.g.a.a.a.f.a.a().e().iterator();
            boolean bl3 = true;
            while (iterator.hasNext()) {
                View view;
                l l2 = (l)iterator.next();
                if (!l2.p() || (view = l2.n()) == null || !view.hasWindowFocus()) continue;
                bl3 = false;
            }
            if (!bl2 || !bl3) {
                bl = false;
            }
            this.d(bl);
        }
    }

    public void onActivityResumed(Activity activity) {
        this.d(false);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public static interface a {
        public void b(boolean var1);
    }

}

