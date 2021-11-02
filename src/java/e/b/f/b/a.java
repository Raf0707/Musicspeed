/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  e.b.f.b.b
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.concurrent.Callable
 */
package e.b.f.b;

import android.os.Handler;
import android.os.Looper;
import e.b.e;
import java.util.concurrent.Callable;

public final class a {
    private static final e a = e.b.f.a.a.d(new Callable<e>(){

        public e a() throws Exception {
            return b.a;
        }
    });

    public static e a() {
        return e.b.f.a.a.e(a);
    }

    private static final class b {
        static final e a = new e.b.f.b.b(new Handler(Looper.getMainLooper()), false);
    }

}

