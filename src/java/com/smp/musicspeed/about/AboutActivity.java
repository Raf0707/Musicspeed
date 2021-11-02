/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.a
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.smp.musicspeed.about;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.about.a;
import com.smp.musicspeed.about.b;
import com.smp.musicspeed.about.c;
import com.smp.musicspeed.about.d;
import com.smp.musicspeed.about.e;
import com.smp.musicspeed.about.h;
import com.smp.musicspeed.about.i;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;

public class AboutActivity
extends androidx.appcompat.app.e {
    private boolean x;

    private void A0() {
        if (this.x) {
            com.smp.musicspeed.misc.b.N().M(this.R(), "LicensesFragment");
        }
    }

    private /* synthetic */ void l0(View view) {
        this.z0();
    }

    private /* synthetic */ void n0(View view) {
        this.y0();
    }

    private /* synthetic */ void p0(View view) {
        this.x0();
    }

    private /* synthetic */ void r0(View view) {
        this.w0();
    }

    private /* synthetic */ void t0(View view) {
        this.A0();
    }

    private void v0() {
        androidx.appcompat.app.a a2 = this.b0();
        if (a2 != null) {
            a2.r(true);
        }
    }

    private void w0() {
        if (this.x) {
            com.smp.musicspeed.misc.a.N().M(this.R(), "ChangeLogFragment");
        }
    }

    private void x0() {
        try {
            this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)this.getString(2131821278))));
        }
        catch (Exception exception) {}
    }

    private void y0() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.addFlags(524288);
        intent.putExtra("android.intent.extra.SUBJECT", this.getResources().getString(2131820673));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getResources().getString(2131821301));
        stringBuilder.append(" ");
        stringBuilder.append(com.smp.musicspeed.h0.c.a());
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        this.startActivity(Intent.createChooser((Intent)intent, (CharSequence)this.getResources().getString(2131820796)));
    }

    private void z0() {
        if (this.x) {
            i.N().M(this.R(), "TechFragment");
        }
    }

    public /* synthetic */ void m0(View view) {
        this.l0(view);
    }

    public /* synthetic */ void o0(View view) {
        this.n0(view);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setTheme(o.a((Context)this));
        this.v0();
        g.a.a.c c2 = new g.a.a.c();
        c2.n("Version 10.3.4-pl");
        int n2 = !t.w((Context)this) ? 2131100041 : 2131100185;
        g.a.a.c c3 = new g.a.a.c();
        c3.n(this.getResources().getString(2131820962));
        c3.i(2131230907);
        c3.k(n2);
        c3.j(n2);
        c3.m(new e(this));
        g.a.a.c c4 = new g.a.a.c();
        c4.n(this.getResources().getString(2131820961));
        c4.i(2131231008);
        c4.k(n2);
        c4.j(n2);
        c4.m(new b(this));
        g.a.a.c c5 = new g.a.a.c();
        c5.n(this.getResources().getString(2131820641));
        c5.m(new d(this));
        g.a.a.c c6 = new g.a.a.c();
        c6.n(this.getResources().getString(2131820605));
        c6.m(new c(this));
        g.a.a.c c7 = new g.a.a.c();
        c7.n(this.getResources().getString(2131820633));
        c7.m(new a(this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getResources().getString(2131820673));
        stringBuilder.append("\n\u00a9 2021 Single Minded Productions, LLC");
        String string = stringBuilder.toString();
        int n3 = Build.VERSION.SDK_INT >= 26 ? 2131231158 : 2131231156;
        h h2 = new h((Context)this);
        h2.h(false).j(n3).i(string).c(c2).c(c3).c(c4).d("https://musicspeedchanger.com/", "musicspeedchanger.com");
        h2.k("com.smp.musicspeed", this.getString(2131820594));
        h2.c(c6).c(c5).c(c7);
        this.setContentView(h2.e());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.finish();
            this.startActivity(new Intent((Context)this, MainActivity.class));
            return true;
        }
        return Activity.super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        this.x = false;
        androidx.fragment.app.d.super.onPause();
    }

    protected void onResume() {
        this.x = true;
        androidx.fragment.app.d.super.onResume();
    }

    public /* synthetic */ void q0(View view) {
        this.p0(view);
    }

    public /* synthetic */ void s0(View view) {
        this.r0(view);
    }

    public /* synthetic */ void u0(View view) {
        this.t0(view);
    }
}

