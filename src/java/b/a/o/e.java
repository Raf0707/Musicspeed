/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.appcompat.view.menu.g
 *  androidx.appcompat.view.menu.g$a
 *  androidx.appcompat.widget.ActionBarContextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package b.a.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import b.a.o.b;
import b.a.o.g;
import java.lang.ref.WeakReference;

public class e
extends b
implements g.a {
    private Context h;
    private ActionBarContextView i;
    private b.a j;
    private WeakReference<View> k;
    private boolean l;
    private boolean m;
    private androidx.appcompat.view.menu.g n;

    public e(Context context, ActionBarContextView actionBarContextView, b.a a2, boolean bl) {
        androidx.appcompat.view.menu.g g2;
        this.h = context;
        this.i = actionBarContextView;
        this.j = a2;
        this.n = g2 = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).S(1);
        g2.R((g.a)this);
        this.m = bl;
    }

    public boolean a(androidx.appcompat.view.menu.g g2, MenuItem menuItem) {
        return this.j.d(this, menuItem);
    }

    public void b(androidx.appcompat.view.menu.g g2) {
        this.k();
        this.i.l();
    }

    @Override
    public void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.i.sendAccessibilityEvent(32);
        this.j.a(this);
    }

    @Override
    public View d() {
        WeakReference<View> weakReference = this.k;
        if (weakReference != null) {
            return (View)weakReference.get();
        }
        return null;
    }

    @Override
    public Menu e() {
        return this.n;
    }

    @Override
    public MenuInflater f() {
        return new g(this.i.getContext());
    }

    @Override
    public CharSequence g() {
        return this.i.getSubtitle();
    }

    @Override
    public CharSequence i() {
        return this.i.getTitle();
    }

    @Override
    public void k() {
        this.j.c(this, (Menu)this.n);
    }

    @Override
    public boolean l() {
        return this.i.j();
    }

    @Override
    public void m(View view) {
        this.i.setCustomView(view);
        WeakReference weakReference = view != null ? new WeakReference((Object)view) : null;
        this.k = weakReference;
    }

    @Override
    public void n(int n2) {
        this.o(this.h.getString(n2));
    }

    @Override
    public void o(CharSequence charSequence) {
        this.i.setSubtitle(charSequence);
    }

    @Override
    public void q(int n2) {
        this.r(this.h.getString(n2));
    }

    @Override
    public void r(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    @Override
    public void s(boolean bl) {
        super.s(bl);
        this.i.setTitleOptional(bl);
    }
}

