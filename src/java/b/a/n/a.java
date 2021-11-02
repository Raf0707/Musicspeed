/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.text.method.TransformationMethod
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package b.a.n;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class a
implements TransformationMethod {
    private Locale f;

    public a(Context context) {
        this.f = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean bl, int n2, Rect rect) {
    }
}

