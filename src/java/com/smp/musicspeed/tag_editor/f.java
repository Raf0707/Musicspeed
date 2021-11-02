/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.provider.MediaStore
 *  android.text.TextWatcher
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.EditText
 *  androidx.appcompat.app.e
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.core.widget.ContentLoadingProgressBar
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.fragment.app.s
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.p
 *  androidx.lifecycle.x
 *  b.i.h.a
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  kotlinx.coroutines.b3.u
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.tag_editor;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d;
import androidx.fragment.app.s;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.tag_editor.c;
import com.smp.musicspeed.tag_editor.f;
import com.smp.musicspeed.tag_editor.g;
import com.smp.musicspeed.utils.o;
import f.n;
import f.t;
import f.w.k.a.l;
import f.z.d.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.b3.u;
import kotlinx.coroutines.e;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import org.jaudiotagger.tag.FieldKey;

public abstract class f
extends androidx.appcompat.app.e
implements k0,
c.k.a.c {
    private final /* synthetic */ k0 x;
    private final int y = 4799;

    public f() {
        this.x = l0.b();
    }

    private static final void A0(f f2, Boolean bl) {
        k.g(f2, "this$0");
        k.f((Object)bl, "it");
        if (bl.booleanValue()) {
            ((ContentLoadingProgressBar)f2.findViewById(d0.h0)).setVisibility(0);
            return;
        }
        ((ContentLoadingProgressBar)f2.findViewById(d0.h0)).setVisibility(8);
    }

    private final void B0() {
        Uri uri = this.o0().n();
        c.k.a.b b2 = new c.k.a.b();
        Bundle bundle = new Bundle();
        bundle.putParcelable("initialImage", (Parcelable)uri);
        b2.setArguments(bundle);
        this.R().n().c(2131296588, (Fragment)b2, "ImageChooserFrag").j();
    }

    private final void C0() {
        if (!com.smp.musicspeed.utils.t.w((Context)this)) {
            int n2 = com.smp.musicspeed.utils.t.Q((Context)this, 2130969433, 0);
            this.getWindow().getDecorView().setBackgroundColor(n2);
        }
    }

    public static final /* synthetic */ void l0(f f2) {
        f2.B0();
    }

    private final void p0() {
        if (Build.VERSION.SDK_INT >= 21) {
            int n2 = this.getResources().getConfiguration().orientation != 2 ? com.smp.musicspeed.utils.t.Q((Context)this, 2130968792, 0) : b.i.h.a.c((Context)this, (int)2131099924);
            this.getWindow().setNavigationBarColor(n2);
        }
    }

    public static /* synthetic */ void q0(f f2, View view) {
        f.w0(f2, view);
    }

    public static /* synthetic */ void r0(f f2, View view) {
        f.x0(f2, view);
    }

    public static /* synthetic */ void s0(f f2, Boolean bl) {
        f.A0(f2, bl);
    }

    private final void u0(List<? extends Uri> list) {
        PendingIntent pendingIntent = MediaStore.createWriteRequest((ContentResolver)this.getContentResolver(), list);
        k.f((Object)pendingIntent, "createWriteRequest(contentResolver, uriList)");
        try {
            this.startIntentSenderForResult(pendingIntent.getIntentSender(), this.y, null, 0, 0, 0);
        }
        catch (IntentSender.SendIntentException sendIntentException) {}
    }

    private final void v0() {
        ((FloatingActionButton)this.findViewById(d0.s0)).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.tag_editor.a(this));
        ((AppCompatImageButton)this.findViewById(d0.s)).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.tag_editor.b(this));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static final void w0(f var0, View var1_1) {
        k.g(var0, "this$0");
        if (!z.d()) {
            var0.o0().A();
            return;
        }
        var2_2 = var0.o0().j();
        var3_3 = var2_2 instanceof Collection;
        var4_4 = true;
        if (var3_3 && var2_2.isEmpty()) ** GOTO lbl12
        var5_5 = var2_2.iterator();
        do {
            if (var5_5.hasNext()) continue;
lbl12: // 2 sources:
            var4_4 = false;
            break;
        } while (!(var6_6 = var0.checkUriPermission((Uri)var5_5.next(), Binder.getCallingPid(), Binder.getCallingUid(), 2) != 0));
        if (var4_4) {
            var0.u0(var2_2);
            return;
        }
        var0.o0().A();
    }

    private static final void x0(f f2, View view) {
        k.g(f2, "this$0");
        Fragment fragment = f2.R().j0("ImageChooserFrag");
        if (fragment == null) {
            return;
        }
        if (fragment instanceof c.k.a.b) {
            ((c.k.a.b)fragment).w(null);
        }
    }

    private final void y0() {
        Map<FieldKey, String> map = this.o0().r();
        View view = this.findViewById(2131297308);
        for (Map.Entry entry : this.n0().entrySet()) {
            EditText editText = (EditText)entry.getKey();
            FieldKey fieldKey = (FieldKey)((Object)entry.getValue());
            if (map.get((Object)fieldKey) != null) {
                editText.setText((CharSequence)map.get((Object)fieldKey));
            }
            editText.addTextChangedListener(new TextWatcher(this, editText, view){
                final /* synthetic */ f f;
                final /* synthetic */ EditText g;
                final /* synthetic */ View h;
                {
                    this.f = f2;
                    this.g = editText;
                    this.h = view;
                }

                public void afterTextChanged(android.text.Editable editable) {
                    FieldKey fieldKey = f.u.g0.h(this.f.n0(), this.g);
                    if (!k.c(this.g.getText().toString(), this.f.o0().p().get((Object)((Object)fieldKey)))) {
                        this.h.setVisibility(0);
                    }
                    this.f.o0().y(fieldKey, this.g.getText().toString());
                }

                public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                }

                public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                }
            });
        }
    }

    private final void z0() {
        this.o0().q().i((p)this, (x)new c(this));
        e.d((k0)this, null, null, (f.z.c.p)new f.z.c.p<k0, f.w.d<? super t>, Object>(this, this, null){
            int j;
            final /* synthetic */ f k;
            final /* synthetic */ f l;
            {
                this.k = f2;
                this.l = f3;
                super(2, d2);
            }

            @Override
            public final f.w.d<t> a(Object object, f.w.d<?> d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public final Object q(Object var1_1) {
                block9 : {
                    var2_2 = f.w.j.b.c();
                    var3_3 = this.j;
                    if (var3_3 == 0) break block9;
                    if (var3_3 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    n.b(var1_1);
                    var9_4 = var2_2;
                    var8_5 = this;
                    ** GOTO lbl22
                }
                n.b(var1_1);
                var4_6 = this;
                do {
                    var5_7 = var4_6.k.o0().m();
                    var4_6.j = 1;
                    var6_8 = var5_7.f((f.w.d)var4_6);
                    if (var6_8 == var2_2) {
                        return var2_2;
                    }
                    var7_9 = var2_2;
                    var8_5 = var4_6;
                    var1_1 = var6_8;
                    var9_4 = var7_9;
lbl22: // 2 sources:
                    var10_10 = ((Number)var1_1).intValue();
                    if (var10_10 != 1) {
                        if (var10_10 != 2) {
                            if (var10_10 != 3) {
                                if (var10_10 == 4) {
                                    f.l0(var8_5.k);
                                }
                            } else {
                                var15_13 = var8_5.k.getString(2131821363);
                                k.f(var15_13, "getString(R.string.toast_write_tag_ok)");
                                z.n(var15_13, (Context)var8_5.l, 0, 2, null);
                                var8_5.k.t0();
                            }
                        } else {
                            var13_12 = var8_5.k.getString(2131821362);
                            k.f(var13_12, "getString(R.string.toast_write_tag_fail)");
                            z.n(var13_12, (Context)var8_5.l, 0, 2, null);
                            var8_5.k.t0();
                        }
                    } else {
                        var8_5.k.finish();
                        var11_11 = var8_5.k.getString(2131821317);
                        k.f(var11_11, "getString(R.string.toast_invalid_file)");
                        z.n(var11_11, (Context)var8_5.l, 0, 2, null);
                    }
                    var4_6 = var8_5;
                    var2_2 = var9_4;
                } while (true);
            }

            public final Object t(k0 k02, f.w.d<? super t> d2) {
                return (this.a((Object)k02, d2)).q(t.a);
            }
        }, (int)3, null);
    }

    public f.w.g L() {
        return this.x.L();
    }

    @Override
    public void g(Uri uri) {
        if (this.o0().o()) {
            ((FloatingActionButton)this.findViewById(d0.s0)).setVisibility(0);
        }
        this.o0().x(uri);
    }

    public abstract int m0();

    protected abstract Map<EditText, FieldKey> n0();

    protected abstract g o0();

    protected void onActivityResult(int n2, int n3, Intent intent) {
        d.super.onActivityResult(n2, n3, intent);
        if (n2 == this.y && n3 == -1) {
            this.o0().A();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setTheme(o.e((Context)this));
        this.setContentView(this.m0());
        this.C0();
        this.p0();
        this.z0();
        this.y0();
        this.v0();
    }

    protected void onDestroy() {
        l0.d((k0)this, null, (int)1, null);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        k.g((Object)menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            com.smp.musicspeed.utils.t.u((Activity)this);
            this.finish();
            return true;
        }
        return false;
    }

    protected void t0() {
    }

}

