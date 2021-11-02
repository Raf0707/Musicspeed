/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.icu.util.ULocale
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.Locale
 */
package b.i.o;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class c {
    private static Method a;
    private static Method b;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 < 21) {
            try {
                Class class_ = Class.forName((String)"libcore.icu.ICU");
                a = class_.getMethod("getScript", new Class[]{String.class});
                b = class_.getMethod("addLikelySubtags", new Class[]{String.class});
            }
            catch (Exception exception) {
                a = null;
                b = null;
                Log.w((String)"ICUCompat", (Throwable)exception);
            }
        } else if (n2 < 24) {
            try {
                b = Class.forName((String)"libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            }
            catch (Exception exception) {
                throw new IllegalStateException((Throwable)exception);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String a(Locale locale) {
        String string = locale.toString();
        Method method = b;
        if (method == null) return string;
        try {
            return (String)method.invoke(null, new Object[]{string});
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)"ICUCompat", (Throwable)invocationTargetException);
            return string;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)"ICUCompat", (Throwable)illegalAccessException);
        }
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String b(String string) {
        Method method = a;
        if (method == null) return null;
        try {
            return (String)method.invoke(null, new Object[]{string});
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)"ICUCompat", (Throwable)invocationTargetException);
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)"ICUCompat", (Throwable)illegalAccessException);
        }
        return null;
    }

    public static String c(Locale locale) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 24) {
            return ULocale.addLikelySubtags((ULocale)ULocale.forLocale((Locale)locale)).getScript();
        }
        if (n2 >= 21) {
            try {
                Object[] arrobject = new Object[]{locale};
                String string = ((Locale)b.invoke(null, arrobject)).getScript();
                return string;
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.w((String)"ICUCompat", (Throwable)illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.w((String)"ICUCompat", (Throwable)invocationTargetException);
            }
            return locale.getScript();
        }
        String string = c.a(locale);
        if (string != null) {
            return c.b(string);
        }
        return null;
    }
}

