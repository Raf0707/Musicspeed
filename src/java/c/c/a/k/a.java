/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.SystemClock
 *  c.c.a.e
 *  c.c.a.e$a
 *  c.c.a.k.g
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package c.c.a.k;

import android.content.SharedPreferences;
import android.os.SystemClock;
import c.c.a.d;
import c.c.a.e;
import c.c.a.k.g;
import f.e0.i;
import f.z.d.k;
import java.util.Map;

public abstract class a<T>
implements f.b0.d<d, T>,
g {
    private long a;
    private Object b;
    private i<?> c;

    public String c() {
        String string = this.e();
        if (string != null) {
            return string;
        }
        i<?> i2 = this.c;
        if (i2 == null) {
            k.s("property");
        }
        return i2.getName();
    }

    public abstract T d(i<?> var1, SharedPreferences var2);

    public abstract String e();

    public T f(d d2, i<?> i2) {
        k.g(d2, "thisRef");
        k.g(i2, "property");
        if (!d2.i()) {
            return this.d(i2, (SharedPreferences)d2.l());
        }
        if (this.a < d2.n()) {
            this.b = this.d(i2, (SharedPreferences)d2.l());
            this.a = SystemClock.uptimeMillis();
        }
        return (T)this.b;
    }

    public final f.b0.d<d, T> g(d d2, i<?> i2) {
        k.g(d2, "thisRef");
        k.g(i2, "property");
        this.c = i2;
        d2.m().put((Object)i2.getName(), (Object)this);
        return this;
    }

    public abstract void h(i<?> var1, T var2, SharedPreferences.Editor var3);

    public abstract void i(i<?> var1, T var2, SharedPreferences var3);

    public void j(d d2, i<?> i2, T t2) {
        k.g(d2, "thisRef");
        k.g(i2, "property");
        if (d2.i()) {
            this.b = t2;
            this.a = SystemClock.uptimeMillis();
            e.a a2 = d2.h();
            k.e((Object)a2);
            this.h(i2, t2, (SharedPreferences.Editor)a2);
            return;
        }
        this.i(i2, t2, (SharedPreferences)d2.l());
    }
}

