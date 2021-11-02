/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.Runnable
 */
package b.w;

import android.view.ViewGroup;
import b.w.j;

public class l {
    private ViewGroup a;
    private Runnable b;

    public static l b(ViewGroup viewGroup) {
        return (l)viewGroup.getTag(j.c);
    }

    static void c(ViewGroup viewGroup, l l2) {
        viewGroup.setTag(j.c, (Object)l2);
    }

    public void a() {
        Runnable runnable;
        if (l.b(this.a) == this && (runnable = this.b) != null) {
            runnable.run();
        }
    }
}

