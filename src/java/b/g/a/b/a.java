/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package b.g.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

public class a {
    public static String a(View view) {
        try {
            String string = view.getContext().getResources().getResourceEntryName(view.getId());
            return string;
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }
}

