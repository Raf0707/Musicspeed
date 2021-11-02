/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 *  java.lang.Object
 *  java.lang.String
 */
package b.v;

import android.os.Trace;

final class b {
    public static void a(String string) {
        Trace.beginSection((String)string);
    }

    public static void b() {
        Trace.endSection();
    }
}

