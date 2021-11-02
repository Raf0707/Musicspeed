/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package c.i.c.p;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import c.i.b.b.b;

public class a
implements b {
    private static Typeface a;

    @Override
    public Typeface getTypeface(Context context) {
        if (a == null) {
            try {
                a = Typeface.createFromAsset((AssetManager)context.getAssets(), (String)"fonts/materialdrawerfont-font-v5.0.0.ttf");
            }
            catch (Exception exception) {
                return null;
            }
        }
        return a;
    }

    public static final class a
    extends Enum<a>
    implements c.i.b.b.a {
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        private static b k;
        private static final /* synthetic */ a[] l;
        char m;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            f = a2 = new a('\ue5c5');
            g = a3 = new a('\ue5c7');
            h = a6 = new a('\ue5ce');
            i = a4 = new a('\ue5cf');
            j = a5 = new a('\ue7fd');
            l = new a[]{a2, a3, a6, a4, a5};
        }

        private a(char c2) {
            this.m = c2;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])l.clone();
        }

        @Override
        public char a() {
            return this.m;
        }

        @Override
        public b b() {
            if (k == null) {
                k = new a();
            }
            return k;
        }
    }

}

