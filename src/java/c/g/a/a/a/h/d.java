/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONObject
 */
package c.g.a.a.a.h;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import c.g.a.a.a.h.a;
import c.g.a.a.a.j.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class d
implements a {
    private final int[] a = new int[2];

    private void c(ViewGroup viewGroup, JSONObject jSONObject, a.a a2) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
            a2.a(viewGroup.getChildAt(i2), this, jSONObject);
        }
    }

    @TargetApi(value=21)
    private void d(ViewGroup viewGroup, JSONObject jSONObject, a.a a2) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
            View view = viewGroup.getChildAt(i2);
            ArrayList arrayList = (ArrayList)hashMap.get((Object)Float.valueOf((float)view.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put((Object)Float.valueOf((float)view.getZ()), (Object)arrayList);
            }
            arrayList.add((Object)view);
        }
        ArrayList arrayList = new ArrayList((Collection)hashMap.keySet());
        Collections.sort((List)arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Iterator iterator2 = ((ArrayList)hashMap.get((Object)((Float)iterator.next()))).iterator();
            while (iterator2.hasNext()) {
                a2.a((View)iterator2.next(), this, jSONObject);
            }
        }
    }

    @Override
    public JSONObject a(View view) {
        if (view == null) {
            return b.b(0, 0, 0, 0);
        }
        int n2 = view.getWidth();
        int n3 = view.getHeight();
        view.getLocationOnScreen(this.a);
        int[] arrn = this.a;
        return b.b(arrn[0], arrn[1], n2, n3);
    }

    @Override
    public void b(View view, JSONObject jSONObject, a.a a2, boolean bl) {
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        if (bl && Build.VERSION.SDK_INT >= 21) {
            this.d(viewGroup, jSONObject, a2);
            return;
        }
        this.c(viewGroup, jSONObject, a2);
    }
}

