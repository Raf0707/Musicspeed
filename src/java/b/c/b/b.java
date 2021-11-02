/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsService
 *  android.text.TextUtils
 *  b.c.b.b$a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package b.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import b.c.b.b;
import b.c.b.d;
import b.c.b.e;

public class b {
    private final ICustomTabsService a;
    private final ComponentName b;

    b(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.a = iCustomTabsService;
        this.b = componentName;
    }

    public static boolean a(Context context, String string, d d2) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            intent.setPackage(string);
        }
        return context.bindService(intent, (ServiceConnection)d2, 33);
    }

    public e b(b.c.b.a a2) {
        e e2;
        a a3;
        block2 : {
            a3 = new a(this, a2);
            e2 = null;
            try {
                boolean bl = this.a.newSession((ICustomTabsCallback)a3);
                if (bl) break block2;
                return null;
            }
            catch (RemoteException remoteException) {}
        }
        e2 = new e(this.a, (ICustomTabsCallback)a3, this.b);
        return e2;
    }

    public boolean c(long l2) {
        try {
            boolean bl = this.a.warmup(l2);
            return bl;
        }
        catch (RemoteException remoteException) {
            return false;
        }
    }
}

