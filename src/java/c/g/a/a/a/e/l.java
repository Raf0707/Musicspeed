/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.UUID
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  org.json.JSONObject
 */
package c.g.a.a.a.e;

import android.view.View;
import android.webkit.WebView;
import c.g.a.a.a.e.b;
import c.g.a.a.a.e.c;
import c.g.a.a.a.e.d;
import c.g.a.a.a.e.e;
import c.g.a.a.a.e.g;
import c.g.a.a.a.e.k;
import c.g.a.a.a.f.f;
import c.g.a.a.a.k.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class l
extends b {
    private static final Pattern a = Pattern.compile((String)"^[a-zA-Z0-9 ]+$");
    private final d b;
    private final c c;
    private final List<c.g.a.a.a.f.c> d = new ArrayList();
    private a e;
    private c.g.a.a.a.l.a f;
    private boolean g = false;
    private boolean h = false;
    private final String i;
    private boolean j;
    private boolean k;

    l(c c2, d d2) {
        this.c = c2;
        this.b = d2;
        this.i = UUID.randomUUID().toString();
        this.m(null);
        c.g.a.a.a.l.a a2 = d2.c() != e.f && d2.c() != e.h ? new c.g.a.a.a.l.c(d2.f(), d2.g()) : new c.g.a.a.a.l.b(d2.j());
        this.f = a2;
        this.f.a();
        c.g.a.a.a.f.a.a().b(this);
        this.f.e(c2);
    }

    private c.g.a.a.a.f.c f(View view) {
        for (c.g.a.a.a.f.c c2 : this.d) {
            if (c2.a().get() != view) continue;
            return c2;
        }
        return null;
    }

    private void h(String string) {
        if (string != null) {
            if (string.length() <= 50 && a.matcher((CharSequence)string).matches()) {
                return;
            }
            throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
        }
    }

    private static void k(View view) {
        if (view != null) {
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction is null");
    }

    private void m(View view) {
        this.e = new a(view);
    }

    private void o(View view) {
        Collection<l> collection = c.g.a.a.a.f.a.a().c();
        if (collection != null && !collection.isEmpty()) {
            for (l l2 : collection) {
                if (l2 == this || l2.n() != view) continue;
                l2.e.clear();
            }
        }
    }

    private void w() {
        if (!this.j) {
            return;
        }
        throw new IllegalStateException("Impression event can only be sent once");
    }

    private void x() {
        if (!this.k) {
            return;
        }
        throw new IllegalStateException("Loaded event can only be sent once");
    }

    @Override
    public void a(View view, g g2, String string) {
        if (this.h) {
            return;
        }
        l.k(view);
        this.h(string);
        if (this.f(view) == null) {
            this.d.add((Object)new c.g.a.a.a.f.c(view, g2, string));
        }
    }

    @Override
    public void c() {
        if (this.h) {
            return;
        }
        this.e.clear();
        this.y();
        this.h = true;
        this.t().s();
        c.g.a.a.a.f.a.a().f(this);
        this.t().n();
        this.f = null;
    }

    @Override
    public void d(View view) {
        if (this.h) {
            return;
        }
        c.g.a.a.a.j.e.d((Object)view, "AdView is null");
        if (this.n() == view) {
            return;
        }
        this.m(view);
        this.t().w();
        this.o(view);
    }

    @Override
    public void e() {
        if (this.g) {
            return;
        }
        this.g = true;
        c.g.a.a.a.f.a.a().d(this);
        float f2 = f.c().g();
        this.f.b(f2);
        this.f.f(this, this.b);
    }

    public List<c.g.a.a.a.f.c> g() {
        return this.d;
    }

    void i(JSONObject jSONObject) {
        this.x();
        this.t().l(jSONObject);
        this.k = true;
    }

    void j() {
        this.w();
        this.t().t();
        this.j = true;
    }

    void l() {
        this.x();
        this.t().v();
        this.k = true;
    }

    public View n() {
        return (View)this.e.get();
    }

    public boolean p() {
        return this.g && !this.h;
    }

    public boolean q() {
        return this.g;
    }

    public boolean r() {
        return this.h;
    }

    public String s() {
        return this.i;
    }

    public c.g.a.a.a.l.a t() {
        return this.f;
    }

    public boolean u() {
        return this.c.b();
    }

    public boolean v() {
        return this.c.c();
    }

    public void y() {
        if (this.h) {
            return;
        }
        this.d.clear();
    }
}

