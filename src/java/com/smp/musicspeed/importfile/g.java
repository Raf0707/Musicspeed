/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.smp.musicspeed.importfile;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.d;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.importfile.c;
import com.smp.musicspeed.importfile.g;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.utils.o;
import f.f;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
extends androidx.fragment.app.c {
    public static final a v = new Object(null){
        {
            this();
        }

        public final g a(List<MediaTrack> list) {
            k.g(list, "items");
            g g2 = new g();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("trackItems", new ArrayList(list));
            g2.setArguments(bundle);
            return g2;
        }
    };
    private final f w = f.g.a(new f.z.c.a<List<? extends MediaTrack>>(this){
        final /* synthetic */ g g;
        {
            this.g = g2;
            super(0);
        }

        public final List<MediaTrack> a() {
            Bundle bundle = this.g.getArguments();
            ArrayList arrayList = bundle == null ? null : bundle.getParcelableArrayList("trackItems");
            if (arrayList == null) {
                arrayList = f.u.l.d();
            }
            return arrayList;
        }
    });

    public static /* synthetic */ void O(g g2, DialogInterface dialogInterface, int n2) {
        g.T(g2, dialogInterface, n2);
    }

    public static /* synthetic */ void P(g g2, DialogInterface dialogInterface, int n2) {
        g.S(g2, dialogInterface, n2);
    }

    public static /* synthetic */ void Q(g g2, DialogInterface dialogInterface, int n2) {
        g.R(g2, dialogInterface, n2);
    }

    private static final void R(g g2, DialogInterface dialogInterface, int n2) {
        k.g((Object)g2, "this$0");
        Context context = g2.requireContext();
        k.f((Object)context, "requireContext()");
        f0.r(context, g2.N());
    }

    private static final void S(g g2, DialogInterface dialogInterface, int n2) {
        k.g((Object)g2, "this$0");
        Context context = g2.requireContext();
        k.f((Object)context, "requireContext()");
        f0.a(context, g2.N(), true, true);
    }

    private static final void T(g g2, DialogInterface dialogInterface, int n2) {
        k.g((Object)g2, "this$0");
        Context context = g2.requireContext();
        k.f((Object)context, "requireContext()");
        f0.a(context, g2.N(), false, true);
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        androidx.fragment.app.d d3 = this.requireActivity();
        k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3));
        Context context = this.requireContext();
        Object[] arrobject = new Object[]{this.N().size()};
        a2.t((CharSequence)context.getString(2131820777, arrobject));
        Context context2 = this.requireContext();
        Object[] arrobject2 = new Object[]{this.N().size()};
        a2.h((CharSequence)context2.getString(2131820686, arrobject2));
        a2.o(2131821150, (DialogInterface.OnClickListener)new c(this));
        a2.j(2131820638, (DialogInterface.OnClickListener)new com.smp.musicspeed.importfile.b(this));
        a2.l(2131820601, (DialogInterface.OnClickListener)new com.smp.musicspeed.importfile.a(this));
        d d4 = a2.a();
        k.f((Object)d4, "create()");
        return d4;
    }

    public final List<MediaTrack> N() {
        return (List)this.w.getValue();
    }

}

