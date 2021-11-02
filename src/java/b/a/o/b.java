/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package b.a.o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class b {
    private Object f;
    private boolean g;

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.g;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View var1);

    public abstract void n(int var1);

    public abstract void o(CharSequence var1);

    public void p(Object object) {
        this.f = object;
    }

    public abstract void q(int var1);

    public abstract void r(CharSequence var1);

    public void s(boolean bl) {
        this.g = bl;
    }

    public static interface a {
        public void a(b var1);

        public boolean b(b var1, Menu var2);

        public boolean c(b var1, Menu var2);

        public boolean d(b var1, MenuItem var2);
    }

}

