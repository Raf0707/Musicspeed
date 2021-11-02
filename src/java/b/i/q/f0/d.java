/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  b.i.q.f0.d$b
 *  b.i.q.f0.d$c
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package b.i.q.f0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.i.q.f0.d;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public class d {
    private final Object a;

    public d() {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 26) {
            this.a = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        if (n2 >= 19) {
            this.a = new /* Unavailable Anonymous Inner Class!! */;
            return;
        }
        if (n2 >= 16) {
            this.a = new a(this);
            return;
        }
        this.a = null;
    }

    public d(Object object) {
        this.a = object;
    }

    public void a(int n2, b.i.q.f0.c c2, String string, Bundle bundle) {
    }

    public b.i.q.f0.c b(int n2) {
        return null;
    }

    public List<b.i.q.f0.c> c(String string, int n2) {
        return null;
    }

    public b.i.q.f0.c d(int n2) {
        return null;
    }

    public Object e() {
        return this.a;
    }

    public boolean f(int n2, int n3, Bundle bundle) {
        return false;
    }

    static class a
    extends AccessibilityNodeProvider {
        final d a;

        a(d d2) {
            this.a = d2;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int n2) {
            b.i.q.f0.c c2 = this.a.b(n2);
            if (c2 == null) {
                return null;
            }
            return c2.E0();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String string, int n2) {
            List<b.i.q.f0.c> list = this.a.c(string, n2);
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int n3 = list.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                arrayList.add((Object)((b.i.q.f0.c)list.get(i2)).E0());
            }
            return arrayList;
        }

        public boolean performAction(int n2, int n3, Bundle bundle) {
            return this.a.f(n2, n3, bundle);
        }
    }

}

