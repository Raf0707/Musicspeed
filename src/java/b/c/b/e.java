/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.IBinder
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsService
 *  java.lang.Object
 */
package b.c.b;

import android.content.ComponentName;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;

public final class e {
    private final Object a = new Object();
    private final ICustomTabsService b;
    private final ICustomTabsCallback c;
    private final ComponentName d;

    e(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.b = iCustomTabsService;
        this.c = iCustomTabsCallback;
        this.d = componentName;
    }

    IBinder a() {
        return this.c.asBinder();
    }

    ComponentName b() {
        return this.d;
    }
}

