/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$g
 *  c.f.a.a.a.e.c
 *  java.lang.Class
 *  java.lang.Object
 */
package c.f.a.a.a.e;

import androidx.recyclerview.widget.RecyclerView;
import c.f.a.a.a.e.c;

public class e {
    public static <T> T a(RecyclerView.g g2, Class<T> class_) {
        if (class_.isInstance((Object)g2)) {
            return (T)class_.cast((Object)g2);
        }
        if (g2 instanceof c) {
            return e.a(((c)g2).o(), class_);
        }
        return null;
    }

    public static RecyclerView.g b(RecyclerView.g g2) {
        return e.c(g2);
    }

    private static RecyclerView.g c(RecyclerView.g g2) {
        if (!(g2 instanceof c)) {
            return g2;
        }
        c c2 = (c)g2;
        RecyclerView.g g3 = c2.o();
        c2.D();
        return e.c(g3);
    }
}

