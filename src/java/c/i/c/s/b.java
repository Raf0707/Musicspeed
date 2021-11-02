/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 *  c.i.c.s.b$a
 *  java.lang.Object
 *  java.lang.String
 */
package c.i.c.s;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import c.i.c.s.b;

public class b {
    private static b a;
    private b b;
    private boolean c = false;

    private b(b b2) {
        this.b = b2;
    }

    public static b a() {
        if (a == null) {
            a = new b((b)new a());
        }
        return a;
    }

    public boolean b(ImageView imageView, Uri uri, String string) {
        if (!(this.c || "http".equals((Object)uri.getScheme()) || "https".equals((Object)uri.getScheme()))) {
            return false;
        }
        b b2 = this.b;
        if (b2 != null) {
            Drawable drawable = b2.b(imageView.getContext(), string);
            this.b.a(imageView, uri, drawable, string);
        }
        return true;
    }

    public static interface b {
        public void a(ImageView var1, Uri var2, Drawable var3, String var4);

        public Drawable b(Context var1, String var2);
    }

}

