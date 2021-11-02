/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package b.i.l;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

public final class a {
    public static boolean a(ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return true;
        }
        int n2 = networkInfo.getType();
        return n2 != 1 && n2 != 7 && n2 != 9;
    }
}

