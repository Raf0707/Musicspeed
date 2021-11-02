/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 */
package b.w;

import android.view.View;
import b.w.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class s {
    public final Map<String, Object> a = new HashMap();
    public View b;
    final ArrayList<m> c = new ArrayList();

    @Deprecated
    public s() {
    }

    public s(View view) {
        this.b = view;
    }

    public boolean equals(Object object) {
        if (object instanceof s) {
            View view = this.b;
            s s2 = (s)object;
            if (view == s2.b && this.a.equals(s2.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 31 * this.b.hashCode() + this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransitionValues@");
        stringBuilder.append(Integer.toHexString((int)this.hashCode()));
        stringBuilder.append(":\n");
        String string = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append("    view = ");
        stringBuilder2.append((Object)this.b);
        stringBuilder2.append("\n");
        String string2 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string2);
        stringBuilder3.append("    values:");
        String string3 = stringBuilder3.toString();
        for (String string4 : this.a.keySet()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string3);
            stringBuilder4.append("    ");
            stringBuilder4.append(string4);
            stringBuilder4.append(": ");
            stringBuilder4.append(this.a.get((Object)string4));
            stringBuilder4.append("\n");
            string3 = stringBuilder4.toString();
        }
        return string3;
    }
}

