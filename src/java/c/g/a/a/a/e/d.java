/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.UUID
 */
package c.g.a.a.a.e;

import android.webkit.WebView;
import c.g.a.a.a.e.e;
import c.g.a.a.a.e.j;
import c.g.a.a.a.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class d {
    private final j a;
    private final WebView b;
    private final List<k> c;
    private final Map<String, k> d;
    private final String e;
    private final String f;
    private final String g;
    private final e h;

    private d(j j2, WebView webView, String string, List<k> list, String string2, String string3, e e2) {
        ArrayList arrayList;
        this.c = arrayList = new ArrayList();
        this.d = new HashMap();
        this.a = j2;
        this.b = webView;
        this.e = string;
        this.h = e2;
        if (list != null) {
            arrayList.addAll(list);
            for (k k2 : list) {
                String string4 = UUID.randomUUID().toString();
                this.d.put((Object)string4, (Object)k2);
            }
        }
        this.g = string2;
        this.f = string3;
    }

    public static d a(j j2, WebView webView, String string, String string2) {
        c.g.a.a.a.j.e.d(j2, "Partner is null");
        c.g.a.a.a.j.e.d((Object)webView, "WebView is null");
        if (string2 != null) {
            c.g.a.a.a.j.e.e(string2, 256, "CustomReferenceData is greater than 256 characters");
        }
        d d2 = new d(j2, webView, null, null, string, string2, e.f);
        return d2;
    }

    public static d b(j j2, String string, List<k> list, String string2, String string3) {
        c.g.a.a.a.j.e.d(j2, "Partner is null");
        c.g.a.a.a.j.e.d(string, "OM SDK JS script content is null");
        c.g.a.a.a.j.e.d(list, "VerificationScriptResources is null");
        if (string3 != null) {
            c.g.a.a.a.j.e.e(string3, 256, "CustomReferenceData is greater than 256 characters");
        }
        d d2 = new d(j2, null, string, list, string2, string3, e.g);
        return d2;
    }

    public e c() {
        return this.h;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.f;
    }

    public Map<String, k> f() {
        return Collections.unmodifiableMap(this.d);
    }

    public String g() {
        return this.e;
    }

    public j h() {
        return this.a;
    }

    public List<k> i() {
        return Collections.unmodifiableList(this.c);
    }

    public WebView j() {
        return this.b;
    }
}

