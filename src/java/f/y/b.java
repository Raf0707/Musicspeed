/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  f.a
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.Throwable
 */
package f.y;

import f.a;
import java.io.Closeable;

public final class b {
    public static final void a(Closeable closeable, Throwable throwable) {
        if (closeable == null) {
            return;
        }
        if (throwable == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
            return;
        }
        catch (Throwable throwable2) {
            a.a((Throwable)throwable, (Throwable)throwable2);
            return;
        }
    }
}

