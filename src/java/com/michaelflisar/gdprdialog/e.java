/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.michaelflisar.gdprdialog;

import android.content.Context;
import com.michaelflisar.gdprdialog.d;
import com.michaelflisar.gdprdialog.h;
import com.michaelflisar.gdprdialog.m.i;
import java.util.Date;

public class e {
    private d a;
    private h b;
    private long c;
    private int d;

    public e() {
        this.a = d.f;
        this.b = h.f;
        this.c = -1L;
        this.d = -1;
    }

    public e(Context context, d d2, h h2) {
        this.a = d2;
        this.b = h2;
        this.c = new Date().getTime();
        this.d = i.a(context);
    }

    public e(d d2, h h2, long l2, int n2) {
        this.a = d2;
        this.b = h2;
        this.c = l2;
        this.d = n2;
    }

    public final d a() {
        return this.a;
    }

    public final long b() {
        return this.c;
    }

    public final h c() {
        return this.b;
    }

    public final int d() {
        return this.d;
    }

    public String e() {
        Object[] arrobject = new Object[]{this.a.name(), this.b.name(), new Date(this.c).toLocaleString(), this.d};
        return String.format((String)"{ Consent: %s | Location: %s | Date: %s | Version: %d}", (Object[])arrobject);
    }
}

