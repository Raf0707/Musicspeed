/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.d.a.a.l.b
 *  c.d.a.a.m.f.d
 *  c.d.a.a.m.f.e
 *  c.d.a.a.m.f.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package c.d.a.a.m.g;

import c.d.a.a.m.a;
import c.d.a.a.m.f.d;
import c.d.a.a.m.f.e;
import c.d.a.a.m.f.h;
import c.d.a.a.m.f.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b<T>
implements h<T> {
    private final j<T> a;
    private final ConcurrentHashMap<String, List<e<T>>> b;

    protected b(j<T> j2) {
        this.a = j2;
        this.b = new ConcurrentHashMap();
    }

    private T i(String string) {
        return (T)this.a.a(this.k(string));
    }

    private String k(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AMPLIFY_");
        stringBuilder.append(string);
        stringBuilder.append("_");
        stringBuilder.append(this.m().toUpperCase(Locale.US));
        return stringBuilder.toString();
    }

    private String m() {
        return this.l().trim().toUpperCase(Locale.US).replaceAll("\\s+", "_");
    }

    private boolean o(String string) {
        return this.b.containsKey((Object)string);
    }

    private void p(e<T> e2, String string) {
        c.d.a.a.l.b b2 = a.j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Blocking feedback because of ");
        stringBuilder.append(e2.getDescription());
        stringBuilder.append(" associated with ");
        stringBuilder.append(string);
        stringBuilder.append(" event");
        b2.b(stringBuilder.toString());
    }

    public void a(d d2) {
        String string = d2.a();
        if (this.o(string)) {
            T t2 = this.i(string);
            T t3 = this.n(t2);
            if (t2 == null) {
                c.d.a.a.l.b b2 = a.j();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Setting ");
                stringBuilder.append(this.l().toLowerCase(Locale.US));
                stringBuilder.append(" of ");
                stringBuilder.append(string);
                stringBuilder.append(" event to ");
                stringBuilder.append(t3);
                b2.b(stringBuilder.toString());
            } else if (!t3.equals(t2)) {
                c.d.a.a.l.b b3 = a.j();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Updating ");
                stringBuilder.append(this.l().toLowerCase(Locale.US));
                stringBuilder.append(" of ");
                stringBuilder.append(string);
                stringBuilder.append(" event from ");
                stringBuilder.append(t2);
                stringBuilder.append(" to ");
                stringBuilder.append(t3);
                b3.b(stringBuilder.toString());
            }
            this.a.b(this.k(string), t3);
        }
    }

    public void d(d d2, e<T> e2) {
        String string = d2.a();
        if (!this.o(string)) {
            this.b.put((Object)string, (Object)new ArrayList());
        }
        ((List)this.b.get((Object)string)).add(e2);
        c.d.a.a.l.b b2 = a.j();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Registered ");
        stringBuilder.append(e2.getDescription());
        stringBuilder.append(" for event ");
        stringBuilder.append(string);
        b2.b(stringBuilder.toString());
    }

    public boolean h() {
        Iterator iterator = this.b.entrySet().iterator();
        boolean bl = true;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            String string = (String)entry.getKey();
            for (e e2 : (List)entry.getValue()) {
                T t2 = this.i(string);
                if (t2 != null) {
                    c.d.a.a.l.b b2 = a.j();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append(" event ");
                    stringBuilder.append(this.j(t2));
                    b2.b(stringBuilder.toString());
                    if (e2.b(t2)) continue;
                    this.p(e2, string);
                } else {
                    c.d.a.a.l.b b3 = a.j();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No tracked value for ");
                    stringBuilder.append(this.l().toLowerCase(Locale.US));
                    stringBuilder.append(" of ");
                    stringBuilder.append(string);
                    stringBuilder.append(" event");
                    b3.b(stringBuilder.toString());
                    if (e2.a()) continue;
                    this.p(e2, string);
                }
                bl = false;
            }
        }
        return bl;
    }

    protected abstract String j(T var1);

    protected abstract String l();

    protected abstract T n(T var1);
}

