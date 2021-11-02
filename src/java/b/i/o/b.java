/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.Html
 *  android.text.Spanned
 *  java.lang.Object
 *  java.lang.String
 */
package b.i.o;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

@SuppressLint(value={"InlinedApi"})
public final class b {
    public static Spanned a(String string, int n2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml((String)string, (int)n2);
        }
        return Html.fromHtml((String)string);
    }
}

