/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.a
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.about;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.a;
import androidx.appcompat.app.e;
import androidx.fragment.app.d;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.about.f;
import com.smp.musicspeed.about.g;
import com.smp.musicspeed.about.h;
import com.smp.musicspeed.utils.o;
import com.smp.musicspeed.utils.t;
import f.z.d.k;
import g.a.a.c;

public final class HelpActivity
extends e {
    private boolean x;

    public static /* synthetic */ void l0(HelpActivity helpActivity, View view) {
        HelpActivity.o0(helpActivity, view);
    }

    public static /* synthetic */ void m0(HelpActivity helpActivity, View view) {
        HelpActivity.n0(helpActivity, view);
    }

    private static final void n0(HelpActivity helpActivity, View view) {
        k.g((Object)helpActivity, "this$0");
        helpActivity.q0();
    }

    private static final void o0(HelpActivity helpActivity, View view) {
        k.g((Object)helpActivity, "this$0");
        helpActivity.r0();
    }

    private final void p0() {
        a a2 = this.b0();
        if (a2 == null) {
            return;
        }
        a2.r(true);
    }

    private final void q0() {
        try {
            this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)"https://musicspeedchanger.com/forum/discussion/209/frequently-asked-questions-faq-android-version")));
        }
        catch (Exception exception) {}
    }

    private final void r0() {
        try {
            this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)"https://www.youtube.com/playlist?list=PL3k1Hi8EN8eHZJpqnzd_nP7eAVcUZ4QdO")));
        }
        catch (Exception exception) {}
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setTheme(o.a((Context)this));
        this.p0();
        int n2 = !t.w((Context)this) ? 2131100041 : 2131100185;
        c c2 = new c();
        c2.n(this.getResources().getString(2131820930));
        c2.i(2131230947);
        c2.k(n2);
        c2.j(n2);
        c2.m(new g(this));
        c c3 = new c();
        c3.n(this.getResources().getString(2131820596));
        c3.i(2131230915);
        c3.k(n2);
        c3.j(n2);
        c3.m(new f(this));
        h h2 = new h((Context)this);
        h2.h(false).i(this.getString(2131820886)).c(c2).c(c3).d("https://musicspeedchanger.com/forum", this.getString(2131820597)).b("support@musicspeedchanger.com", this.getString(2131820586));
        this.setContentView(h2.e());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        k.g((Object)menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            this.finish();
            this.startActivity(new Intent((Context)this, MainActivity.class));
            return true;
        }
        return Activity.super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        this.x = false;
        d.super.onPause();
    }

    protected void onResume() {
        this.x = true;
        d.super.onResume();
    }
}

