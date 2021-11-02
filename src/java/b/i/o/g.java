/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package b.i.o;

import android.os.Build;
import android.text.TextUtils;
import b.i.o.c;
import java.util.Locale;

public final class g {
    private static final Locale a = new Locale("", "");

    private static int a(Locale locale) {
        byte by = Character.getDirectionality((char)locale.getDisplayName(locale).charAt(0));
        return by == 1 || by == 2;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale((Locale)locale);
        }
        if (locale != null && !locale.equals((Object)a)) {
            String string = c.c(locale);
            if (string == null) {
                return g.a(locale);
            }
            if (string.equalsIgnoreCase("Arab") || string.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }
}

