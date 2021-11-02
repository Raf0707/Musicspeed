/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 *  java.lang.Object
 */
package c.i.d.k;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import c.i.d.j.a;

public class c {
    private Uri a;
    private Drawable b;
    private Bitmap c;
    private int d = -1;

    public c(int n2) {
        this.d = n2;
    }

    public c(Bitmap bitmap) {
        this.c = bitmap;
    }

    public static void a(Drawable drawable, int n2, Drawable drawable2, int n3, boolean bl, ImageView imageView) {
        if (drawable != null) {
            if (drawable2 != null) {
                if (bl) {
                    imageView.setImageDrawable((Drawable)new a(drawable, drawable2, n2, n3));
                } else {
                    imageView.setImageDrawable((Drawable)c.i.d.l.a.c(drawable, drawable2));
                }
            } else if (bl) {
                imageView.setImageDrawable((Drawable)new a(drawable, n2, n3));
            } else {
                imageView.setImageDrawable(drawable);
            }
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    public Bitmap b() {
        return this.c;
    }

    public Drawable c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public Uri e() {
        return this.a;
    }
}

