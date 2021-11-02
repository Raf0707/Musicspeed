/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  f.u.f
 *  java.lang.Object
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 */
package rm.com.audiowave;

import android.os.Handler;
import android.os.Looper;
import f.u.f;
import f.z.d.k;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class n {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final ExecutorService b;

    static {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        k.f((Object)executorService, "newSingleThreadExecutor()");
        b = executorService;
    }

    public static final byte a(byte by) {
        if (by == -128) {
            return 127;
        }
        boolean bl = false;
        if (-127 <= by) {
            bl = false;
            if (by <= 0) {
                bl = true;
            }
        }
        if (bl) {
            by = -by;
        }
        return by;
    }

    public static final Handler b() {
        return a;
    }

    public static final ExecutorService c() {
        return b;
    }

    public static final byte[] d(byte[] arrby, byte[] arrby2) {
        k.g(arrby, "<this>");
        k.g(arrby2, "other");
        int n2 = arrby.length;
        if (n2 == 0) {
            return new byte[0];
        }
        int n3 = arrby.length;
        int n4 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            arrby[i2];
            int n5 = n4 + 1;
            byte by = n4 >= 0 && n4 <= f.k((byte[])arrby2) ? arrby2[n4] : n.a(arrby[n4]);
            arrby[n4] = by;
            n4 = n5;
        }
        return arrby;
    }
}

