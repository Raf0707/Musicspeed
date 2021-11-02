/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionMode
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.View
 *  androidx.appcompat.view.menu.o
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package b.a.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import androidx.appcompat.view.menu.o;
import b.a.o.b;
import b.i.j.a.a;

public class f
extends ActionMode {
    final Context a;
    final b b;

    public f(Context context, b b2) {
        this.a = context;
        this.b = b2;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.d();
    }

    public Menu getMenu() {
        return new o(this.a, (a)this.b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.h();
    }

    public CharSequence getTitle() {
        return this.b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    public void invalidate() {
        this.b.k();
    }

    public boolean isTitleOptional() {
        return this.b.l();
    }

    public void setCustomView(View view) {
        this.b.m(view);
    }

    public void setSubtitle(int n2) {
        this.b.n(n2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    public void setTag(Object object) {
        this.b.p(object);
    }

    public void setTitle(int n2) {
        this.b.q(n2);
    }

    public void setTitle(CharSequence charSequence) {
        this.b.r(charSequence);
    }

    public void setTitleOptionalHint(boolean bl) {
        this.b.s(bl);
    }
}

