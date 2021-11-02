/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.os.Environment
 *  android.text.Spanned
 *  android.text.TextUtils
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  b.i.o.b
 *  f.g0.k
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.smp.musicspeed.k0.o0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.appcompat.app.d;
import com.smp.musicspeed.k0.o0.d;
import com.smp.musicspeed.k0.o0.l;
import com.smp.musicspeed.utils.o;
import f.f;
import f.g0.k;
import f.z.d.g;
import java.io.File;
import java.io.Serializable;

public final class l
extends androidx.fragment.app.c {
    public static final a v = new Object(null){
        {
            this();
        }

        public final l a(File file, boolean bl) {
            f.z.d.k.g((Object)file, "file");
            l l2 = new l();
            Bundle bundle = new Bundle();
            bundle.putSerializable("file", (Serializable)file);
            bundle.putBoolean("sdError", bl);
            l2.setArguments(bundle);
            return l2;
        }
    };
    private final f w = f.g.a(new f.z.c.a<File>(this){
        final /* synthetic */ l g;
        {
            this.g = l2;
            super(0);
        }

        public final File a() {
            Bundle bundle = this.g.getArguments();
            Serializable serializable = bundle == null ? null : bundle.getSerializable("file");
            java.util.Objects.requireNonNull((Object)serializable, (String)"null cannot be cast to non-null type java.io.File");
            return (File)serializable;
        }
    });
    private final f x = f.g.a(new f.z.c.a<Boolean>(this){
        final /* synthetic */ l g;
        {
            this.g = l2;
            super(0);
        }

        public final boolean a() {
            Bundle bundle = this.g.getArguments();
            Boolean bl = bundle == null ? null : Boolean.valueOf((boolean)bundle.getBoolean("sdError"));
            f.z.d.k.e(bl);
            return bl;
        }
    });

    private final File N() {
        return (File)this.w.getValue();
    }

    private final boolean O() {
        return (Boolean)this.x.getValue();
    }

    public static /* synthetic */ void P(DialogInterface dialogInterface, int n2) {
        l.Q(dialogInterface, n2);
    }

    private static final void Q(DialogInterface dialogInterface, int n2) {
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        androidx.fragment.app.d d3 = this.requireActivity();
        f.z.d.k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3));
        String string = this.N().getAbsolutePath();
        f.z.d.k.f(string, "file.absolutePath");
        String string2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        f.z.d.k.f(string2, "getExternalStorageDirectory().absolutePath");
        String string3 = this.getString(2131820764, new Object[]{k.K((String)k.K((String)string, (CharSequence)string2), (CharSequence)"/")});
        f.z.d.k.f(string3, "getString(R.string.dialog_message_playlist_written, apath)");
        Spanned spanned = b.i.o.b.a((String)string3, (int)0);
        f.z.d.k.f((Object)spanned, "fromHtml(t1,0)");
        Object[] arrobject = new Object[]{f.y.g.h(this.N())};
        String string4 = this.getString(2131820763, arrobject);
        f.z.d.k.f(string4, "getString(R.string.dialog_message_playlist_shared, file.nameWithoutExtension)");
        Spanned spanned2 = b.i.o.b.a((String)string4, (int)0);
        f.z.d.k.f((Object)spanned2, "fromHtml(t2,0)");
        CharSequence[] arrcharSequence = new CharSequence[]{spanned, System.lineSeparator()};
        CharSequence charSequence = TextUtils.concat((CharSequence[])arrcharSequence);
        String string5 = this.getString(2131820751);
        f.z.d.k.f(string5, "getString(R.string.dialog_message_cant_add_to_playlist)");
        CharSequence[] arrcharSequence2 = new CharSequence[]{charSequence, System.lineSeparator()};
        CharSequence charSequence2 = TextUtils.concat((CharSequence[])new CharSequence[]{TextUtils.concat((CharSequence[])arrcharSequence2), spanned2});
        if (this.O()) {
            CharSequence[] arrcharSequence3 = new CharSequence[]{charSequence2, f.z.d.k.m(" ", string5)};
            charSequence2 = TextUtils.concat((CharSequence[])arrcharSequence3);
        }
        a2.s(2131820779).h(charSequence2).o(17039370, (DialogInterface.OnClickListener)d.f);
        androidx.appcompat.app.d d4 = a2.a();
        f.z.d.k.f((Object)d4, "builder.create()");
        return d4;
    }

}

