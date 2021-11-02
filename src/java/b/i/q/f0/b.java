/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.Object
 */
package b.i.q.f0;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class b {
    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }

    public static void b(AccessibilityEvent accessibilityEvent, int n2) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(n2);
        }
    }
}

