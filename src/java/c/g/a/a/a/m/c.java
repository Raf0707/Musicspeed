/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.g.a.a.a.m.b$f
 *  c.g.a.a.a.m.b$g
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package c.g.a.a.a.m;

import c.g.a.a.a.m.b;
import c.g.a.a.a.m.b$c;
import c.g.a.a.a.m.b$d;
import c.g.a.a.a.m.b$e;
import java.util.HashSet;
import org.json.JSONObject;

public class c
implements b$c.b {
    private JSONObject a;
    private final b$d b;

    public c(b$d b$d) {
        this.b = b$d;
    }

    @Override
    public JSONObject a() {
        return this.a;
    }

    @Override
    public void b(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void c() {
        this.b.c(new b$e(this));
    }

    public void d(JSONObject jSONObject, HashSet<String> hashSet, long l2) {
        b$d b$d = this.b;
        b.g g2 = new b.g((b$c.b)this, hashSet, jSONObject, l2);
        b$d.c((b$c)g2);
    }

    public void e(JSONObject jSONObject, HashSet<String> hashSet, long l2) {
        b$d b$d = this.b;
        b.f f2 = new b.f((b$c.b)this, hashSet, jSONObject, l2);
        b$d.c((b$c)f2);
    }
}

