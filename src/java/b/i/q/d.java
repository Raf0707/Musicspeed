/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  b.i.q.d$b
 *  b.i.q.d$c
 *  java.lang.Object
 */
package b.i.q;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import b.i.q.d;

/*
 * Exception performing whole class analysis.
 */
public final class d {
    private final a a;

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        this.a = new /* Unavailable Anonymous Inner Class!! */;
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    static interface a {
        public boolean a(MotionEvent var1);
    }

}

