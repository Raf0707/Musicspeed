/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.g.a.a.a.e.l
 *  c.g.a.a.a.f.f
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package c.g.a.a.a.e.m;

import c.g.a.a.a.e.l;
import c.g.a.a.a.e.m.a;
import c.g.a.a.a.e.m.c;
import c.g.a.a.a.f.f;
import c.g.a.a.a.j.e;
import org.json.JSONObject;

public final class b {
    private final l a;

    private b(l l2) {
        this.a = l2;
    }

    private void e(float f2) {
        if (!(f2 <= 0.0f)) {
            return;
        }
        throw new IllegalArgumentException("Invalid Media duration");
    }

    private void f(float f2) {
        if (!(f2 < 0.0f) && !(f2 > 1.0f)) {
            return;
        }
        throw new IllegalArgumentException("Invalid Media volume");
    }

    public static b g(c.g.a.a.a.e.b b2) {
        l l2 = (l)b2;
        e.d(b2, "AdSession is null");
        e.l(l2);
        e.c(l2);
        e.g(l2);
        e.j(l2);
        b b3 = new b(l2);
        l2.t().h(b3);
        return b3;
    }

    public void a(a a2) {
        e.d((Object)a2, "InteractionType is null");
        e.h(this.a);
        JSONObject jSONObject = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject, "interactionType", (Object)a2);
        this.a.t().k("adUserInteraction", jSONObject);
    }

    public void b() {
        e.h(this.a);
        this.a.t().i("bufferFinish");
    }

    public void c() {
        e.h(this.a);
        this.a.t().i("bufferStart");
    }

    public void d() {
        e.h(this.a);
        this.a.t().i("complete");
    }

    public void h() {
        e.h(this.a);
        this.a.t().i("firstQuartile");
    }

    public void i() {
        e.h(this.a);
        this.a.t().i("midpoint");
    }

    public void j() {
        e.h(this.a);
        this.a.t().i("pause");
    }

    public void k(c c2) {
        e.d((Object)c2, "PlayerState is null");
        e.h(this.a);
        JSONObject jSONObject = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject, "state", (Object)c2);
        this.a.t().k("playerStateChange", jSONObject);
    }

    public void l() {
        e.h(this.a);
        this.a.t().i("resume");
    }

    public void m() {
        e.h(this.a);
        this.a.t().i("skipped");
    }

    public void n(float f2, float f3) {
        this.e(f2);
        this.f(f3);
        e.h(this.a);
        JSONObject jSONObject = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject, "duration", (Object)Float.valueOf((float)f2));
        c.g.a.a.a.j.b.g(jSONObject, "mediaPlayerVolume", (Object)Float.valueOf((float)f3));
        c.g.a.a.a.j.b.g(jSONObject, "deviceVolume", (Object)Float.valueOf((float)f.c().g()));
        this.a.t().k("start", jSONObject);
    }

    public void o() {
        e.h(this.a);
        this.a.t().i("thirdQuartile");
    }

    public void p(float f2) {
        this.f(f2);
        e.h(this.a);
        JSONObject jSONObject = new JSONObject();
        c.g.a.a.a.j.b.g(jSONObject, "mediaPlayerVolume", (Object)Float.valueOf((float)f2));
        c.g.a.a.a.j.b.g(jSONObject, "deviceVolume", (Object)Float.valueOf((float)f.c().g()));
        this.a.t().k("volumeChange", jSONObject);
    }
}

