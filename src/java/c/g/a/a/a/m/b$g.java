/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 *  org.json.JSONObject
 */
package c.g.a.a.a.m;

import android.text.TextUtils;
import c.g.a.a.a.e.l;
import c.g.a.a.a.f.a;
import c.g.a.a.a.j.b;
import c.g.a.a.a.m.b$b;
import c.g.a.a.a.m.b$c;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONObject;

public class b$g
extends b$b {
    public b$g(b$c.b b2, HashSet<String> hashSet, JSONObject jSONObject, long l2) {
        super(b2, hashSet, jSONObject, l2);
    }

    private void e(String string) {
        a a2 = a.a();
        if (a2 != null) {
            for (l l2 : a2.c()) {
                if (!this.c.contains((Object)l2.s())) continue;
                l2.t().j(string, this.e);
            }
        }
    }

    @Override
    protected void b(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            this.e(string);
        }
        b$c.super.b(string);
    }

    protected /* varargs */ String d(Object ... arrobject) {
        if (b.l(this.d, this.b.a())) {
            return null;
        }
        this.b.b(this.d);
        return this.d.toString();
    }

    protected /* synthetic */ Object doInBackground(Object[] arrobject) {
        return this.d(arrobject);
    }

    @Override
    protected /* synthetic */ void onPostExecute(Object object) {
        this.b((String)object);
    }
}

