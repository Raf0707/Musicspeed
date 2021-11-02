/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.o0;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.o0.e;
import com.smp.musicspeed.library.playlists.Playlist;
import f.z.d.k;
import java.util.List;
import org.greenrobot.eventbus.c;

public final class n
extends RecyclerView.g<a> {
    private final Context h;
    private final List<Playlist> i;

    public n(Context context) {
        k.g((Object)context, "context");
        this.h = context;
        this.i = f.o(context, null, 2, null);
    }

    public static /* synthetic */ void o(a a2, n n2, View view) {
        n.q(a2, n2, view);
    }

    private static final void q(a a2, n n2, View view) {
        k.g((Object)a2, "$holder");
        k.g((Object)n2, "this$0");
        int n3 = a2.getAdapterPosition();
        if (n3 == 0) {
            c.d().m((Object)new com.smp.musicspeed.k0.l0.e());
            return;
        }
        Playlist playlist = (Playlist)n2.i.get(n3 - 1);
        c.d().m((Object)new com.smp.musicspeed.k0.l0.f(playlist));
    }

    public int getItemCount() {
        return 1 + this.i.size();
    }

    public void p(a a2, int n2) {
        k.g((Object)a2, "holder");
        String string = n2 == 0 ? this.h.getResources().getString(2131820761) : ((Playlist)this.i.get(n2 - 1)).getPlaylistName();
        k.f(string, "if (position == 0) context.resources.getString(R.string.dialog_message_new_playlist)\n                    else mData[position - 1].playlistName");
        a2.a0().setText((CharSequence)string);
        a2.Z().setOnClickListener((View.OnClickListener)new e(a2, this));
    }

    public a r(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131493003, viewGroup, false);
        k.f((Object)view, "v");
        return new a(view);
    }

    public static final class a
    extends RecyclerView.c0 {
        private final TextView x;
        private final FrameLayout y;

        public a(View view) {
            k.g((Object)view, "v");
            super(view);
            this.x = (TextView)view.findViewById(2131297032);
            this.y = (FrameLayout)view.findViewById(2131296764);
        }

        public final FrameLayout Z() {
            return this.y;
        }

        public final TextView a0() {
            return this.x;
        }
    }

}

