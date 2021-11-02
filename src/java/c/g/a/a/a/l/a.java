/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  c.g.a.a.a.e.l
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package c.g.a.a.a.l;

import android.content.Context;
import android.webkit.WebView;
import c.g.a.a.a.e.c;
import c.g.a.a.a.e.e;
import c.g.a.a.a.e.j;
import c.g.a.a.a.e.k;
import c.g.a.a.a.e.l;
import c.g.a.a.a.e.m.b;
import c.g.a.a.a.f.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class a {
    private c.g.a.a.a.k.b a;
    private c.g.a.a.a.e.a b;
    private b c;
    private a d;
    private long e;

    public a() {
        this.w();
        this.a = new c.g.a.a.a.k.b(null);
    }

    public void a() {
    }

    public void b(float f2) {
        c.g.a.a.a.f.e.a().c(this.u(), f2);
    }

    void c(WebView webView) {
        this.a = new c.g.a.a.a.k.b(webView);
    }

    public void d(c.g.a.a.a.e.a a2) {
        this.b = a2;
    }

    public void e(c c2) {
        c.g.a.a.a.f.e.a().i(this.u(), c2.d());
    }

    public void f(l l2, c.g.a.a.a.e.d d2) {
        this.g(l2, d2, null);
    }

    protected void g(l l2, c.g.a.a.a.e.d d2, JSONObject jSONObject) {
        String string = l2.s();
        JSONObject jSONObject2 = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject2, "environment", "app");
        c.g.a.a.a.j.b.g(jSONObject2, "adSessionType", (Object)d2.c());
        c.g.a.a.a.j.b.g(jSONObject2, "deviceInfo", (Object)c.g.a.a.a.j.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object)"clid");
        jSONArray.put((Object)"vlid");
        c.g.a.a.a.j.b.g(jSONObject2, "supports", (Object)jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject3, "partnerName", d2.h().b());
        c.g.a.a.a.j.b.g(jSONObject3, "partnerVersion", d2.h().c());
        c.g.a.a.a.j.b.g(jSONObject2, "omidNativeInfo", (Object)jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject4, "libraryVersion", "1.3.16-Mopub");
        c.g.a.a.a.j.b.g(jSONObject4, "appId", d.a().c().getApplicationContext().getPackageName());
        c.g.a.a.a.j.b.g(jSONObject2, "app", (Object)jSONObject4);
        if (d2.d() != null) {
            c.g.a.a.a.j.b.g(jSONObject2, "contentUrl", d2.d());
        }
        if (d2.e() != null) {
            c.g.a.a.a.j.b.g(jSONObject2, "customReferenceData", d2.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (k k2 : d2.i()) {
            c.g.a.a.a.j.b.g(jSONObject5, k2.d(), k2.e());
        }
        c.g.a.a.a.f.e.a().f(this.u(), string, jSONObject2, jSONObject5, jSONObject);
    }

    public void h(b b2) {
        this.c = b2;
    }

    public void i(String string) {
        c.g.a.a.a.f.e.a().e(this.u(), string, null);
    }

    public void j(String string, long l2) {
        if (l2 >= this.e) {
            this.d = a.g;
            c.g.a.a.a.f.e.a().m(this.u(), string);
        }
    }

    public void k(String string, JSONObject jSONObject) {
        c.g.a.a.a.f.e.a().e(this.u(), string, jSONObject);
    }

    public void l(JSONObject jSONObject) {
        c.g.a.a.a.f.e.a().n(this.u(), jSONObject);
    }

    public void m(boolean bl) {
        if (this.r()) {
            String string = bl ? "foregrounded" : "backgrounded";
            c.g.a.a.a.f.e.a().p(this.u(), string);
        }
    }

    public void n() {
        this.a.clear();
    }

    public void o(String string, long l2) {
        a a2;
        a a3;
        if (l2 >= this.e && (a2 = this.d) != (a3 = a.h)) {
            this.d = a3;
            c.g.a.a.a.f.e.a().m(this.u(), string);
        }
    }

    public c.g.a.a.a.e.a p() {
        return this.b;
    }

    public b q() {
        return this.c;
    }

    public boolean r() {
        return this.a.get() != null;
    }

    public void s() {
        c.g.a.a.a.f.e.a().b(this.u());
    }

    public void t() {
        c.g.a.a.a.f.e.a().l(this.u());
    }

    public WebView u() {
        return (WebView)this.a.get();
    }

    public void v() {
        c.g.a.a.a.f.e.a().o(this.u());
    }

    public void w() {
        this.e = c.g.a.a.a.j.d.a();
        this.d = a.f;
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        private static final /* synthetic */ a[] i;

        static {
            a a2;
            a a3;
            a a4;
            f = a4 = new a();
            g = a2 = new a();
            h = a3 = new a();
            i = new a[]{a4, a2, a3};
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])i.clone();
        }
    }

}

