/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package c.g.a.a.a.m;

import c.g.a.a.a.m.b$c;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class b$b
extends b$c {
    protected final HashSet<String> c;
    protected final JSONObject d;
    protected final long e;

    public b$b(b$c.b b2, HashSet<String> hashSet, JSONObject jSONObject, long l2) {
        super(b2);
        this.c = new HashSet(hashSet);
        this.d = jSONObject;
        this.e = l2;
    }
}

