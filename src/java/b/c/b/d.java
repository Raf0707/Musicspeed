/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.support.customtabs.ICustomTabsService
 *  android.support.customtabs.ICustomTabsService$Stub
 *  b.c.b.d$a
 *  java.lang.Object
 */
package b.c.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;
import b.c.b.b;
import b.c.b.d;

public abstract class d
implements ServiceConnection {
    public abstract void onCustomTabsServiceConnected(ComponentName var1, b var2);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.onCustomTabsServiceConnected(componentName, (b)new a(this, ICustomTabsService.Stub.asInterface((IBinder)iBinder), componentName));
    }
}

