/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.Spanned
 *  androidx.appcompat.app.d
 *  androidx.appcompat.app.d$a
 *  androidx.fragment.app.c
 *  androidx.fragment.app.d
 *  b.i.o.b
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.o0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import androidx.appcompat.app.d;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.o0.c;
import com.smp.musicspeed.k0.o0.i;
import com.smp.musicspeed.k0.o0.k;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.utils.o;
import f.z.d.g;

public final class i
extends androidx.fragment.app.c {
    public static final a v = new Object(null){
        {
            this();
        }

        public final i a(Playlist playlist) {
            f.z.d.k.g(playlist, "playlist");
            i i2 = new i();
            Bundle bundle = new Bundle();
            bundle.putParcelable("playlist", (Parcelable)playlist);
            i2.setArguments(bundle);
            return i2;
        }
    };
    private final f.f w = f.g.a(new f.z.c.a<Playlist>(this){
        final /* synthetic */ i g;
        {
            this.g = i2;
            super(0);
        }

        public final Playlist a() {
            Bundle bundle = this.g.getArguments();
            Playlist playlist = bundle == null ? null : (Playlist)bundle.getParcelable("playlist");
            f.z.d.k.e(playlist);
            f.z.d.k.f(playlist, "arguments?.getParcelable(\"playlist\")!!");
            return playlist;
        }
    });

    private final Playlist N() {
        return (Playlist)this.w.getValue();
    }

    public static /* synthetic */ void O(i i2, DialogInterface dialogInterface, int n2) {
        i.P(i2, dialogInterface, n2);
    }

    private static final void P(i i2, DialogInterface dialogInterface, int n2) {
        f.z.d.k.g((Object)i2, "this$0");
        Context context = i2.requireContext();
        f.z.d.k.f((Object)context, "requireContext()");
        f.c(context, i2.N());
        String string = i2.getString(2131821333);
        f.z.d.k.f(string, "getString(R.string.toast_playlist_deleted)");
        Context context2 = i2.requireContext();
        f.z.d.k.f((Object)context2, "requireContext()");
        z.n(string, context2, 0, 2, null);
        org.greenrobot.eventbus.c.d().m((Object)new k());
        i2.w();
    }

    public Dialog B(Bundle bundle) {
        androidx.fragment.app.d d2 = this.requireActivity();
        androidx.fragment.app.d d3 = this.requireActivity();
        f.z.d.k.f((Object)d3, "requireActivity()");
        d.a a2 = new d.a((Context)d2, o.d((Context)d3));
        Object[] arrobject = new Object[]{this.N().getPlaylistName()};
        String string = this.getString(2131820753, arrobject);
        f.z.d.k.f(string, "getString(R.string.dialog_message_delete_playlist, playlist.playlistName)");
        Spanned spanned = b.i.o.b.a((String)string, (int)0);
        f.z.d.k.f((Object)spanned, "fromHtml(text,0)");
        a2.s(2131820778).h((CharSequence)spanned).o(2131820733, (DialogInterface.OnClickListener)new c(this)).j(17039360, null);
        d d4 = a2.a();
        f.z.d.k.f((Object)d4, "builder.create()");
        return d4;
    }

}

