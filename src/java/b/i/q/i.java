/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.Menu
 *  java.lang.Object
 */
package b.i.q;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.Menu;
import b.i.j.a.a;

public final class i {
    @SuppressLint(value={"NewApi"})
    public static void a(Menu menu, boolean bl) {
        if (menu instanceof a) {
            ((a)menu).setGroupDividerEnabled(bl);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            menu.setGroupDividerEnabled(bl);
        }
    }
}

