/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package b.i.q;

import android.view.MotionEvent;

public final class k {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean b(MotionEvent motionEvent, int n2) {
        return (n2 & motionEvent.getSource()) == n2;
    }
}

