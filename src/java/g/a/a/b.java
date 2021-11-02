/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.TypedValue
 *  java.lang.Object
 *  java.lang.String
 */
package g.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

class b {
    static int a(Context context) {
        int n2 = Build.VERSION.SDK_INT >= 21 ? 16843829 : context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n2, typedValue, true);
        return typedValue.data;
    }
}

