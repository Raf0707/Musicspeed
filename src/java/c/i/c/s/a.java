/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.Log
 *  android.widget.ImageView
 *  java.lang.Object
 *  java.lang.String
 */
package c.i.c.s;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import c.i.c.s.b;
import c.i.c.s.c;

public abstract class a
implements b.b {
    @Override
    public void a(ImageView imageView, Uri uri, Drawable drawable, String string) {
        this.d(imageView, uri, drawable);
        Log.i((String)"MaterialDrawer", (String)"You have not specified a ImageLoader implementation through the DrawerImageLoader.init() method, or you are still overriding the deprecated method set(ImageView iv, Uri u, Drawable d) instead of set(ImageView iv, Uri u, Drawable d, String tag)");
    }

    @Override
    public Drawable b(Context context, String string) {
        return this.c(context);
    }

    public Drawable c(Context context) {
        return c.c(context);
    }

    public void d(ImageView imageView, Uri uri, Drawable drawable) {
    }
}

