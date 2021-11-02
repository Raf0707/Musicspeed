/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.IdentityHashMap
 *  java.util.Iterator
 *  org.json.JSONObject
 */
package c.g.a.a.a.h;

import android.view.View;
import c.g.a.a.a.e.l;
import c.g.a.a.a.h.a;
import c.g.a.a.a.j.b;
import c.g.a.a.a.j.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c
implements a {
    private final a a;

    public c(a a2) {
        this.a = a2;
    }

    @Override
    public JSONObject a(View view) {
        return b.b(0, 0, 0, 0);
    }

    @Override
    public void b(View view, JSONObject jSONObject, a.a a2, boolean bl) {
        Iterator iterator = this.c().iterator();
        while (iterator.hasNext()) {
            a2.a((View)iterator.next(), this.a, jSONObject);
        }
    }

    ArrayList<View> c() {
        ArrayList arrayList = new ArrayList();
        c.g.a.a.a.f.a a2 = c.g.a.a.a.f.a.a();
        if (a2 != null) {
            Collection<l> collection = a2.e();
            IdentityHashMap identityHashMap = new IdentityHashMap(3 + 2 * collection.size());
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                View view;
                int n2;
                View view2 = ((l)iterator.next()).n();
                if (view2 == null || !f.c(view2) || (view = view2.getRootView()) == null || identityHashMap.containsKey((Object)view)) continue;
                identityHashMap.put((Object)view, (Object)view);
                float f2 = f.a(view);
                for (n2 = arrayList.size(); n2 > 0 && f.a((View)arrayList.get(n2 - 1)) > f2; --n2) {
                }
                arrayList.add(n2, (Object)view);
            }
        }
        return arrayList;
    }
}

