/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  f.g0.k
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.smp.musicspeed.utils.t;
import f.g0.k;
import g.a.a.a;
import g.a.a.c;

public final class h
extends a {
    private final int h;

    public h(Context context) {
        f.z.d.k.g((Object)context, "context");
        super(context);
        int n2 = t.w(context) ? 2131100185 : 2131100041;
        this.h = n2;
    }

    @Override
    public a b(String string, String string2) {
        f.z.d.k.g(string, "email");
        c c2 = new c();
        c2.n(string2);
        c2.i(2131230812);
        c2.k(this.h);
        c2.j(this.h);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse((String)"mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{string});
        c2.l(intent);
        this.c(c2);
        return this;
    }

    @Override
    public a d(String string, String string2) {
        f.z.d.k.g(string, "url");
        if (!k.o((String)string, (String)"http://", (boolean)false, (int)2, null) && !k.o((String)string, (String)"https://", (boolean)false, (int)2, null)) {
            string = f.z.d.k.m("http://", string);
        }
        c c2 = new c();
        c2.n(string2);
        c2.i(2131230817);
        c2.k(this.h);
        c2.j(this.h);
        c2.o(string);
        c2.l(new Intent("android.intent.action.VIEW", Uri.parse((String)string)));
        this.c(c2);
        return this;
    }

    public a k(String string, String string2) {
        f.z.d.k.g(string, "id");
        f.z.d.k.g(string2, "title");
        c c2 = new c();
        c2.n(string2);
        c2.o(string);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)f.z.d.k.m("https://play.google.com/store/apps/details?id=", string)));
        intent.setPackage("com.android.vending");
        c2.l(intent);
        this.c(c2);
        return this;
    }
}

