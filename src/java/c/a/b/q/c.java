/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package c.a.b.q;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import b.e.g;

public class c {
    private static final g<String, Typeface> a = new g();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Typeface a(Context context, String string) {
        g<String, Typeface> g2;
        g<String, Typeface> g3 = g2 = a;
        synchronized (g3) {
            boolean bl = g2.containsKey(string);
            if (bl) {
                return g2.get(string);
            }
            try {
                Typeface typeface = Typeface.createFromAsset((AssetManager)context.getAssets(), (String)String.format((String)"fonts/%s", (Object[])new Object[]{string}));
                g2.put(string, typeface);
                return typeface;
            }
            catch (RuntimeException runtimeException) {
                return null;
            }
        }
    }
}

