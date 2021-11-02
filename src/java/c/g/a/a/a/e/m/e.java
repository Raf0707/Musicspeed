/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package c.g.a.a.a.e.m;

import c.g.a.a.a.e.m.d;
import c.g.a.a.a.j.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private final boolean a;
    private final Float b;
    private final boolean c;
    private final d d;

    private e(boolean bl, Float f2, boolean bl2, d d2) {
        this.a = bl;
        this.b = f2;
        this.c = bl2;
        this.d = d2;
    }

    public static e b(boolean bl, d d2) {
        c.g.a.a.a.j.e.d((Object)d2, "Position is null");
        return new e(false, null, bl, d2);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.a);
            if (this.a) {
                jSONObject.put("skipOffset", (Object)this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put("position", (Object)this.d);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            c.b("VastProperties: JSON error", (Exception)((Object)jSONException));
            return jSONObject;
        }
    }
}

