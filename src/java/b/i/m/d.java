/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 */
package b.i.m;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Deprecated
public final class d {
    private static long a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 18 && n2 < 29) {
            try {
                a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class class_ = Long.TYPE;
                Class[] arrclass = new Class[]{class_};
                b = Trace.class.getMethod("isTagEnabled", arrclass);
                Class class_2 = Integer.TYPE;
                Class[] arrclass2 = new Class[]{class_, String.class, class_2};
                c = Trace.class.getMethod("asyncTraceBegin", arrclass2);
                d = Trace.class.getMethod("asyncTraceEnd", new Class[]{class_, String.class, class_2});
                e = Trace.class.getMethod("traceCounter", new Class[]{class_, String.class, class_2});
            }
            catch (Exception exception) {
                Log.i((String)"TraceCompat", (String)"Unable to initialize via reflection.", (Throwable)exception);
            }
        }
    }

    public static void a(String string) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection((String)string);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}

