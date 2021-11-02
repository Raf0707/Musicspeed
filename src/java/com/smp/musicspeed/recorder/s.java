/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  c.a.a.b
 *  c.a.a.b$a
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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.b;
import com.bumptech.glide.j;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.l0.h;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.recorder.c;
import com.smp.musicspeed.recorder.d;
import com.smp.musicspeed.recorder.e;
import com.smp.musicspeed.recorder.f;
import com.smp.musicspeed.utils.t;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class s
extends m<a, MediaTrack> {
    public s(Context context, u u2) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        super(context, u2, null, 4, null);
    }

    @Override
    public String a(int n2) {
        return i.c(this.p(), ((MediaTrack)this.q().get(n2)).getTrackName());
    }

    public int getItemCount() {
        return this.q().size();
    }

    public long getItemId(int n2) {
        return ((MediaTrack)this.q().get(n2)).getSongId();
    }

    public void t(a a2, int n2) {
        k.g((Object)a2, "holder");
        a2.itemView.setActivated(this.o().q(n2));
        MediaTrack mediaTrack = (MediaTrack)this.q().get(n2);
        a2.e0().setText((CharSequence)mediaTrack.getTrackName());
        a2.d0().setText((CharSequence)t.q(mediaTrack.getDuration()));
        ((j)((j)com.bumptech.glide.c.u((Context)this.p()).s((Object)new com.smp.musicspeed.playingqueue.i(this.p(), mediaTrack)).Q(mediaTrack.getMediaType().defaultResource(this.p()))).g(mediaTrack.getMediaType().defaultResource(this.p()))).q0(a2.b0());
    }

    public a u(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.p()).inflate(2131492999, viewGroup, false);
        view.findViewById(2131297191).setVisibility(0);
        k.f((Object)view, "view");
        return new RecyclerView.c0(view){
            private final ImageButton A;
            private final ImageView x;
            private final TextView y;
            private final TextView z;
            {
                k.g(s.this, "this$0");
                k.g((Object)view, "v");
                super(view);
                View view2 = view.findViewById(2131296752);
                k.f((Object)view2, "v.findViewById(R.id.image)");
                this.x = (ImageView)view2;
                View view3 = view.findViewById(2131297235);
                k.f((Object)view3, "v.findViewById(R.id.title)");
                this.y = (TextView)view3;
                View view4 = view.findViewById(2131297191);
                k.f((Object)view4, "v.findViewById(R.id.text)");
                this.z = (TextView)view4;
                View view5 = view.findViewById(2131296936);
                k.f((Object)view5, "v.findViewById(R.id.menu)");
                this.A = (ImageButton)view5;
                view.setOnClickListener((View.OnClickListener)new f(s.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new d(s.this, this));
                this.j0();
            }

            private static final void Z(s s2, a a2, View view) {
                k.g(s2, "this$0");
                k.g((Object)a2, "this$1");
                int n2 = s2.q().size();
                int n3 = a2.getAdapterPosition();
                boolean bl = false;
                if (n3 >= 0) {
                    bl = false;
                    if (n3 < n2) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                if (b.b.d()) {
                    s2.o().m(a2.itemView, a2.getAdapterPosition());
                    return;
                }
                org.greenrobot.eventbus.c c2 = org.greenrobot.eventbus.c.d();
                h h2 = new h(l.M(s2.q()), a2.getAdapterPosition(), false, false, 12, null);
                c2.m((Object)h2);
            }

            private static final boolean a0(s s2, a a2, View view) {
                k.g(s2, "this$0");
                k.g((Object)a2, "this$1");
                int n2 = s2.q().size();
                int n3 = a2.getAdapterPosition();
                boolean bl = false;
                if (n3 >= 0) {
                    bl = false;
                    if (n3 < n2) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                s2.o().h(a2.itemView, a2.getAdapterPosition());
                return true;
            }

            public static /* synthetic */ void f0(s s2, a a2, View view) {
                a.k0(s2, a2, view);
            }

            public static /* synthetic */ boolean g0(s s2, a a2, View view) {
                return a.a0(s2, a2, view);
            }

            public static /* synthetic */ boolean h0(s s2, a a2, MediaTrack mediaTrack, MenuItem menuItem) {
                return a.l0(s2, a2, mediaTrack, menuItem);
            }

            public static /* synthetic */ void i0(s s2, a a2, View view) {
                a.Z(s2, a2, view);
            }

            private final void j0() {
                this.A.setOnClickListener((View.OnClickListener)new c(s.this, this));
            }

            private static final void k0(s s2, a a2, View view) {
                k.g(s2, "this$0");
                k.g((Object)a2, "this$1");
                int n2 = s2.q().size();
                int n3 = a2.getAdapterPosition();
                boolean bl = false;
                if (n3 >= 0) {
                    bl = false;
                    if (n3 < n2) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new c0());
                PopupMenu popupMenu = new PopupMenu(s2.p(), (View)a2.c0());
                popupMenu.inflate(2131558414);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new e(s2, a2, (MediaTrack)s2.q().get(a2.getAdapterPosition())));
                popupMenu.show();
            }

            private static final boolean l0(s s2, a a2, MediaTrack mediaTrack, MenuItem menuItem) {
                k.g(s2, "this$0");
                k.g((Object)a2, "this$1");
                k.g(mediaTrack, "$track");
                int n2 = s2.q().size();
                int n3 = a2.getAdapterPosition();
                boolean bl = false;
                if (n3 >= 0) {
                    bl = false;
                    if (n3 < n2) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                List list = l.b((Object)mediaTrack);
                f0.o(s2.p(), menuItem.getItemId(), list, false, 8, null);
                if (menuItem.getItemId() == 2131296358) {
                    b.a a3 = b.b;
                    if (a3.d()) {
                        a3.a();
                        return true;
                    }
                    s2.q().remove(a2.getAdapterPosition());
                    s2.notifyItemRemoved(a2.getAdapterPosition());
                    s2.notifyItemRangeChanged(a2.getAdapterPosition(), s2.getItemCount());
                }
                return true;
            }

            public final ImageView b0() {
                return this.x;
            }

            public final ImageButton c0() {
                return this.A;
            }

            public final TextView d0() {
                return this.z;
            }

            public final TextView e0() {
                return this.y;
            }
        };
    }

}

