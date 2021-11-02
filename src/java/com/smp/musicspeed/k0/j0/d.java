/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnShowListener
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.Toast
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Objects
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.l0
 */
package com.smp.musicspeed.k0.j0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.j0.d;
import com.smp.musicspeed.k0.j0.e;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.utils.o;
import f.f;
import f.z.d.g;
import f.z.d.k;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class d
extends androidx.fragment.app.c
implements k0 {
    public static final a v = new Object(null){
        {
            this();
        }

        public final d a(List<MediaTrack> list, int n2) {
            k.g(list, "items");
            d d2 = new d();
            Bundle bundle = new Bundle();
            Object[] arrobject = list.toArray((Object[])new MediaTrack[0]);
            Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
            bundle.putParcelableArray("tracks", (Parcelable[])arrobject);
            bundle.putInt("posInQueue", n2);
            d2.setArguments(bundle);
            return d2;
        }
    };
    private final /* synthetic */ k0 w;
    private final f x = f.g.a(new f.z.c.a<MediaTrack[]>(this){
        final /* synthetic */ d g;
        {
            this.g = d2;
            super(0);
        }

        public final MediaTrack[] a() {
            Bundle bundle = this.g.getArguments();
            Parcelable[] arrparcelable = bundle == null ? null : bundle.getParcelableArray("tracks");
            Objects.requireNonNull((Object)arrparcelable, (String)"null cannot be cast to non-null type kotlin.Array<com.smp.musicspeed.dbrecord.MediaTrack>");
            return (MediaTrack[])arrparcelable;
        }
    });
    private final f y = f.g.a(new f.z.c.a<Integer>(this){
        final /* synthetic */ d g;
        {
            this.g = d2;
            super(0);
        }

        public final int a() {
            return this.g.requireArguments().getInt("posInQueue");
        }
    });

    public d() {
        this.w = l0.b();
    }

    private final void N() {
        e e2 = e.f;
        androidx.fragment.app.d d2 = this.requireActivity();
        k.f((Object)d2, "requireActivity()");
        e2.b((Activity)d2, this.O(), this.P());
    }

    private final int P() {
        return ((Number)this.y.getValue()).intValue();
    }

    public static /* synthetic */ void Q(DialogInterface dialogInterface, int n2) {
        d.T(dialogInterface, n2);
    }

    public static /* synthetic */ void R(d d2, View view) {
        d.V(d2, view);
    }

    public static /* synthetic */ void S(d d2, DialogInterface dialogInterface) {
        d.U(d2, dialogInterface);
    }

    private static final void T(DialogInterface dialogInterface, int n2) {
    }

    private static final void U(d d2, DialogInterface dialogInterface) {
        k.g((Object)d2, "this$0");
        Objects.requireNonNull((Object)dialogInterface, (String)"null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        ((androidx.appcompat.app.d)dialogInterface).e(-1).setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.j0.b(d2));
    }

    private static final void V(d d2, View view) {
        boolean bl;
        boolean bl2;
        block7 : {
            k.g((Object)d2, "this$0");
            MediaTrack[] arrmediaTrack = d2.O();
            int n2 = arrmediaTrack.length;
            int n3 = 0;
            do {
                bl = true;
                if (n3 >= n2) break;
                MediaTrack mediaTrack = arrmediaTrack[n3];
                Context context = d2.requireContext();
                k.f((Object)context, "requireContext()");
                if (f0.z(context, mediaTrack)) {
                    bl2 = true;
                    break block7;
                }
                ++n3;
            } while (true);
            bl2 = false;
        }
        if (!bl2) {
            d2.N();
            if (!z.b()) {
                block8 : {
                    MediaTrack[] arrmediaTrack = d2.O();
                    int n4 = arrmediaTrack.length;
                    for (int i2 = 0; i2 < n4; ++i2) {
                        if (!(bl ^ u.c(arrmediaTrack[i2]))) {
                            continue;
                        }
                        break block8;
                    }
                    bl = false;
                }
                if (bl) {
                    Toast.makeText((Context)d2.requireContext(), (int)2131821325, (int)0).show();
                }
            }
            d2.w();
        }
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        androidx.fragment.app.d d3 = this.requireActivity();
        k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3)).t((CharSequence)this.requireActivity().getString(2131820619));
        androidx.fragment.app.d d4 = this.requireActivity();
        Object[] arrobject = new Object[]{this.O().length};
        androidx.appcompat.app.d d5 = a2.h((CharSequence)d4.getString(2131820686, arrobject)).o(2131820733, null).j(17039360, (DialogInterface.OnClickListener)com.smp.musicspeed.k0.j0.a.f).a();
        k.f((Object)d5, "builder\n                .setTitle(requireActivity().getString(R.string.action_delete_track_from_device))\n                .setMessage(requireActivity().getString(R.string.cab_x_selected, data.size))\n                .setPositiveButton(R.string.dialog_button_delete, null)\n                .setNegativeButton(android.R.string.cancel) { _, _ -> }.create()");
        d5.setOnShowListener((DialogInterface.OnShowListener)new com.smp.musicspeed.k0.j0.c(this));
        return d5;
    }

    public f.w.g L() {
        return this.w.L();
    }

    public final MediaTrack[] O() {
        return (MediaTrack[])this.x.getValue();
    }

}

