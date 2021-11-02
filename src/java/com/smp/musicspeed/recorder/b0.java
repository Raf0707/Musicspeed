/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  f.z.d.k
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.recorder;

import android.content.Context;
import android.net.Uri;
import f.z.d.k;

public final class b0 {
    private final Context a;
    private final Uri b;
    private final String c;

    public b0(Context context, Uri uri, String string2) {
        k.g((Object)context, (String)"context");
        k.g((Object)uri, (String)"uri");
        k.g((Object)string2, (String)"name");
        this.a = context;
        this.b = uri;
        this.c = string2;
    }

    public final Context a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final Uri c() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b0)) {
            return false;
        }
        b0 b02 = (b0)object;
        if (!k.c((Object)this.a, (Object)b02.a)) {
            return false;
        }
        if (!k.c((Object)this.b, (Object)b02.b)) {
            return false;
        }
        return k.c((Object)this.c, (Object)b02.c);
    }

    public int hashCode() {
        return 31 * (31 * this.a.hashCode() + this.b.hashCode()) + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UriInfo(context=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", uri=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", name=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

