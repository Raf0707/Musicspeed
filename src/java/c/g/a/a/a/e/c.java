/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.json.JSONObject
 */
package c.g.a.a.a.e;

import c.g.a.a.a.e.f;
import c.g.a.a.a.e.h;
import c.g.a.a.a.e.i;
import c.g.a.a.a.j.b;
import c.g.a.a.a.j.e;
import org.json.JSONObject;

public class c {
    private final i a;
    private final i b;
    private final boolean c;
    private final f d;
    private final h e;

    private c(f f2, h h2, i i2, i i3, boolean bl) {
        this.d = f2;
        this.e = h2;
        this.a = i2;
        this.b = i3 == null ? i.h : i3;
        this.c = bl;
    }

    public static c a(f f2, h h2, i i2, i i3, boolean bl) {
        e.d((Object)f2, "CreativeType is null");
        e.d((Object)h2, "ImpressionType is null");
        e.d((Object)i2, "Impression owner is null");
        e.b(i2, f2, h2);
        c c2 = new c(f2, h2, i2, i3, bl);
        return c2;
    }

    public boolean b() {
        return i.f == this.a;
    }

    public boolean c() {
        return i.f == this.b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.g(jSONObject, "impressionOwner", (Object)this.a);
        b.g(jSONObject, "mediaEventsOwner", (Object)this.b);
        b.g(jSONObject, "creativeType", (Object)this.d);
        b.g(jSONObject, "impressionType", (Object)this.e);
        b.g(jSONObject, "isolateVerificationScripts", this.c);
        return jSONObject;
    }
}

