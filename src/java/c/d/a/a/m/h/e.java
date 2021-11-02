/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  c.d.a.a.m.f.e
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.d.a.a.m.h;

import android.content.Context;
import c.d.a.a.a;

public final class e
implements c.d.a.a.m.f.e<String> {
    private final String a;

    public e(Context context) {
        this(new a(context).b());
    }

    e(String string) {
        this.a = string;
    }

    public boolean a() {
        return true;
    }

    public boolean c(String string) {
        return true ^ string.equals((Object)this.a);
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VersionNameChangedRule with current app version name ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}

