/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.RectF
 *  android.util.DisplayMetrics
 *  android.view.View
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package rm.com.audiowave;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import f.t;
import f.z.d.k;

public final class j {
    public static final int a(View view, int n2) {
        k.g((Object)view, "<this>");
        return (int)((float)n2 * view.getResources().getDisplayMetrics().density);
    }

    public static final PorterDuffColorFilter b(int n2) {
        return new PorterDuffColorFilter(n2, PorterDuff.Mode.SRC_IN);
    }

    public static final Paint c(int n2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter((ColorFilter)j.b(n2));
        return paint;
    }

    public static final boolean d(Bitmap bitmap, int n2, int n3) {
        if (bitmap == null) {
            return false;
        }
        int n4 = bitmap.getHeight();
        boolean bl = false;
        if (n4 == n3) {
            int n5 = bitmap.getWidth();
            bl = false;
            if (n5 == n2) {
                bl = true;
            }
        }
        return bl;
    }

    public static final t e(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        bitmap.eraseColor(0);
        return t.a;
    }

    public static final Canvas f(Bitmap bitmap) {
        k.g((Object)bitmap, "<this>");
        return new Canvas(bitmap);
    }

    public static final RectF g(int n2, int n3, int n4, int n5) {
        return new RectF((float)n2, (float)n3, (float)n4, (float)n5);
    }

    public static final void h(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static final Paint i(int n2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(n2);
        return paint;
    }

    public static final int j(int n2, int n3) {
        boolean bl = false;
        if (n3 >= 0) {
            bl = false;
            if (n3 <= 255) {
                bl = true;
            }
        }
        if (bl) {
            return n2 & 16777215 | n3 << 24;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

