/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Process
 *  android.util.TypedValue
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.Executor
 *  java.util.concurrent.RejectedExecutionException
 */
package b.i.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.TypedValue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class a {
    private static final Object a = new Object();
    private static TypedValue b;

    public static int a(Context context, String string) {
        if (string != null) {
            return context.checkPermission(string, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static Context b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    public static int c(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(n2);
        }
        return context.getResources().getColor(n2);
    }

    public static ColorStateList d(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(n2);
        }
        return context.getResources().getColorStateList(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Drawable e(Context context, int n2) {
        Object object;
        int n3 = Build.VERSION.SDK_INT;
        if (n3 >= 21) {
            return context.getDrawable(n2);
        }
        if (n3 >= 16) {
            return context.getResources().getDrawable(n2);
        }
        Object object2 = object = a;
        synchronized (object2) {
            if (b == null) {
                b = new TypedValue();
            }
            context.getResources().getValue(n2, b, true);
            int n4 = a.b.resourceId;
            return context.getResources().getDrawable(n4);
        }
    }

    public static Executor f(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return context.getMainExecutor();
        }
        return new a(new Handler(context.getMainLooper()));
    }

    public static boolean g(Context context, Intent[] arrintent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(arrintent, bundle);
        } else {
            context.startActivities(arrintent);
        }
        return true;
    }

    public static void h(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
            return;
        }
        context.startActivity(intent);
    }

    public static void i(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
            return;
        }
        context.startService(intent);
    }

    private static class a
    implements Executor {
        private final Handler f;

        a(Handler handler) {
            this.f = handler;
        }

        public void execute(Runnable runnable) {
            if (this.f.post(runnable)) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this.f);
            stringBuilder.append(" is shutting down");
            throw new RejectedExecutionException(stringBuilder.toString());
        }
    }

}

