/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnDismissListener
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.fragment.app.Fragment
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  f.u.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.recorder;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import com.smp.musicspeed.d0;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.recorder.a0;
import com.smp.musicspeed.recorder.h;
import com.smp.musicspeed.recorder.i;
import com.smp.musicspeed.recorder.j;
import com.smp.musicspeed.recorder.k;
import com.smp.musicspeed.recorder.z;
import com.smp.musicspeed.utils.t;
import f.f;
import f.z.d.g;
import f.z.d.l;
import java.util.List;
import org.greenrobot.eventbus.c;

public final class w
extends Fragment {
    public static final a f = new Object(null){
        {
            this();
        }

        public final w a(MediaTrack mediaTrack) {
            f.z.d.k.g(mediaTrack, "track");
            w w2 = new w();
            Bundle bundle = new Bundle();
            bundle.putParcelable("track", (Parcelable)mediaTrack);
            w2.setArguments(bundle);
            return w2;
        }
    };
    private final f g = f.g.a(new f.z.c.a<MediaTrack>(){

        public final MediaTrack a() {
            Bundle bundle = this.getArguments();
            MediaTrack mediaTrack = bundle == null ? null : (MediaTrack)bundle.getParcelable("track");
            if (mediaTrack == null) {
                mediaTrack = new MediaTrack(null, null, 0L, null, 0L, false, null, 0L, null, 0L, 0, 0, 0L, 0L, 16383, null);
            }
            return mediaTrack;
        }
    });

    private final void A() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.Z);
        ((AppCompatImageButton)view2).setOnClickListener((View.OnClickListener)new j(this));
    }

    private static final void B(w w2, View view) {
        f.z.d.k.g((Object)w2, "this$0");
        c.d().m((Object)new c0());
        c.d().m((Object)new z());
        Context context = w2.getContext();
        View view2 = w2.getView();
        View view3 = view2 == null ? null : view2.findViewById(d0.Z);
        PopupMenu popupMenu = new PopupMenu(context, view3);
        popupMenu.inflate(2131558419);
        popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new h(w2));
        popupMenu.setOnDismissListener((PopupMenu.OnDismissListener)k.a);
        popupMenu.show();
    }

    private static final boolean C(w w2, MenuItem menuItem) {
        f.z.d.k.g((Object)w2, "this$0");
        List list = f.u.l.b((Object)w2.t());
        Context context = w2.requireContext();
        f.z.d.k.f((Object)context, "this@RecordedTrackFragment.requireContext()");
        f0.o(context, menuItem.getItemId(), list, false, 8, null);
        return true;
    }

    private static final void D(PopupMenu popupMenu) {
        c.d().m((Object)new a0());
    }

    public static /* synthetic */ boolean u(w w2, MenuItem menuItem) {
        return w.C(w2, menuItem);
    }

    public static /* synthetic */ void v(w w2, View view) {
        w.z(w2, view);
    }

    public static /* synthetic */ void w(w w2, View view) {
        w.B(w2, view);
    }

    public static /* synthetic */ void x(PopupMenu popupMenu) {
        w.D(popupMenu);
    }

    private final void y() {
        View view = this.getView();
        View view2 = view == null ? null : view.findViewById(d0.l0);
        ((TextView)view2).setText((CharSequence)this.t().getTrackName());
        View view3 = this.getView();
        View view4 = view3 == null ? null : view3.findViewById(d0.i0);
        ((TextView)view4).setText((CharSequence)t.q(this.t().getDuration()));
        com.bumptech.glide.j j2 = com.bumptech.glide.c.u((Context)this.requireContext()).t("");
        I i2 = this.t().getMediaType();
        Context context = this.requireContext();
        f.z.d.k.f((Object)context, "requireContext()");
        com.bumptech.glide.j j3 = (com.bumptech.glide.j)j2.g(i2.defaultResource(context));
        I i3 = this.t().getMediaType();
        Context context2 = this.requireContext();
        f.z.d.k.f((Object)context2, "requireContext()");
        com.bumptech.glide.j j4 = (com.bumptech.glide.j)j3.Q(i3.defaultResource(context2));
        View view5 = this.getView();
        View view6 = view5 == null ? null : view5.findViewById(d0.V);
        j4.q0((ImageView)view6);
        View view7 = this.getView();
        View view8 = view7 == null ? null : view7.findViewById(d0.i0);
        ((TextView)view8).setVisibility(0);
        View view9 = this.getView();
        View view10 = view9 == null ? null : view9.findViewById(d0.e0);
        view10.setOnClickListener((View.OnClickListener)new i(this));
    }

    private static final void z(w w2, View view) {
        f.z.d.k.g((Object)w2, "this$0");
        c c2 = c.d();
        com.smp.musicspeed.k0.l0.h h2 = new com.smp.musicspeed.k0.l0.h(f.u.l.b((Object)w2.t()), 0, false, false, 12, null);
        c2.m((Object)h2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.k.g((Object)layoutInflater, "inflater");
        return layoutInflater.inflate(2131492972, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        this.y();
        this.A();
    }

    public final MediaTrack t() {
        return (MediaTrack)this.g.getValue();
    }

}

