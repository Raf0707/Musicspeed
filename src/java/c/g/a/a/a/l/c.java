/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Handler
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.net.URL
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONObject
 */
package c.g.a.a.a.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import c.g.a.a.a.e.k;
import c.g.a.a.a.e.l;
import c.g.a.a.a.f.d;
import c.g.a.a.a.f.e;
import c.g.a.a.a.j.b;
import c.g.a.a.a.l.c;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class c
extends c.g.a.a.a.l.a {
    private WebView f;
    private Long g = null;
    private final Map<String, k> h;
    private final String i;

    public c(Map<String, k> map, String string) {
        this.h = map;
        this.i = string;
    }

    static /* synthetic */ WebView x(c c2) {
        return c2.f;
    }

    @Override
    public void a() {
        super.a();
        this.y();
    }

    @Override
    public void f(l l2, c.g.a.a.a.e.d d2) {
        JSONObject jSONObject = new JSONObject();
        Map<String, k> map = d2.f();
        for (String string : map.keySet()) {
            b.g(jSONObject, string, (k)map.get((Object)string));
        }
        this.g(l2, d2, jSONObject);
    }

    @Override
    public void n() {
        super.n();
        long l2 = this.g == null ? 4000L : TimeUnit.MILLISECONDS.convert(c.g.a.a.a.j.d.a() - this.g, TimeUnit.NANOSECONDS);
        long l3 = Math.max((long)(4000L - l2), (long)2000L);
        new Handler().postDelayed(new Runnable(this){
            private final WebView f;
            final /* synthetic */ c g;
            {
                this.g = c2;
                this.f = c.x(c2);
            }

            public void run() {
                this.f.destroy();
            }
        }, l3);
        this.f = null;
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    void y() {
        WebView webView;
        this.f = webView = new WebView(d.a().c());
        webView.getSettings().setJavaScriptEnabled(true);
        this.c(this.f);
        e.a().k(this.f, this.i);
        for (String string : this.h.keySet()) {
            String string2 = ((k)this.h.get((Object)string)).c().toExternalForm();
            e.a().d(this.f, string2, string);
        }
        this.g = c.g.a.a.a.j.d.a();
    }
}

