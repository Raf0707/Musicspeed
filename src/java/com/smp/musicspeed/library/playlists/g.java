/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
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
 *  java.util.Objects
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.library.playlists;

import android.content.Context;
import android.os.SystemClock;
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
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.library.playlists.b;
import com.smp.musicspeed.library.playlists.c;
import com.smp.musicspeed.library.playlists.d;
import f.u.l;
import f.z.d.k;
import f.z.d.x;
import java.util.List;
import java.util.Objects;

public final class g
extends m<a, Playlist> {
    public g(Context context, u u2, g0 g02) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        k.g(g02, "positionInterface");
        super(context, u2, g02);
    }

    @Override
    public String a(int n2) {
        return i.c(this.p(), ((Playlist)this.q().get(n2)).getPlaylistName());
    }

    public int getItemCount() {
        return this.q().size();
    }

    public long getItemId(int n2) {
        return ((Playlist)this.q().get(n2)).getPlaylistId();
    }

    public void t(a a2, int n2) {
        k.g((Object)a2, "holder");
        a2.itemView.setActivated(this.o().q(n2));
        Playlist playlist = (Playlist)this.q().get(n2);
        TextView textView = a2.d0();
        if (textView != null) {
            textView.setText((CharSequence)playlist.getPlaylistName());
        }
        ((j)((j)com.bumptech.glide.c.u((Context)this.p()).t("").g(playlist.getMediaType().defaultResource(this.p()))).Q(playlist.getMediaType().defaultResource(this.p()))).q0(a2.b0());
    }

    public a u(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.p()).inflate(2131492999, viewGroup, false);
        k.f((Object)view, "view");
        return new RecyclerView.c0(view){
            private final ImageButton A;
            private final ImageView x;
            private final TextView y;
            private final TextView z;
            {
                k.g(g.this, "this$0");
                k.g((Object)view, "v");
                super(view);
                View view2 = view.findViewById(2131296752);
                Objects.requireNonNull((Object)view2, (String)"null cannot be cast to non-null type android.widget.ImageView");
                this.x = (ImageView)view2;
                View view3 = view.findViewById(2131297235);
                Objects.requireNonNull((Object)view3, (String)"null cannot be cast to non-null type android.widget.TextView");
                this.y = (TextView)view3;
                View view4 = view.findViewById(2131297191);
                Objects.requireNonNull((Object)view4, (String)"null cannot be cast to non-null type android.widget.TextView");
                this.z = (TextView)view4;
                View view5 = view.findViewById(2131296936);
                k.f((Object)view5, "v.findViewById(R.id.menu)");
                this.A = (ImageButton)view5;
                view.setOnClickListener((View.OnClickListener)new b(g.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new com.smp.musicspeed.library.playlists.a(g.this, this));
                this.i0();
            }

            private static final void Z(g g2, a a2, View view) {
                k.g(g2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = g2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = g2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                if (c.a.a.b.b.d()) {
                    g2.o().m(a2.itemView, n2);
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.l0.g((Playlist)g2.q().get(n2)));
            }

            private static final boolean a0(g g2, a a2, View view) {
                k.g(g2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = g2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = g2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                g2.o().h(a2.itemView, n2);
                return true;
            }

            public static /* synthetic */ boolean e0(g g2, a a2, View view) {
                return a.a0(g2, a2, view);
            }

            public static /* synthetic */ void f0(g g2, a a2, View view) {
                a.Z(g2, a2, view);
            }

            public static /* synthetic */ void g0(x x2, g g2, a a2, View view) {
                a.j0(x2, g2, a2, view);
            }

            public static /* synthetic */ boolean h0(g g2, a a2, MenuItem menuItem) {
                return a.k0(g2, a2, menuItem);
            }

            private final void i0() {
                x x2 = new x();
                this.A.setOnClickListener((View.OnClickListener)new c(x2, g.this, this));
            }

            private static final void j0(x x2, g g2, a a2, View view) {
                k.g(x2, "$lastClick");
                k.g(g2, "this$0");
                k.g((Object)a2, "this$1");
                if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = SystemClock.elapsedRealtime();
                g0 g02 = g2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = g2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new c0());
                PopupMenu popupMenu = new PopupMenu(g2.p(), (View)a2.c0());
                popupMenu.inflate(2131558416);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new d(g2, a2));
                popupMenu.show();
            }

            private static final boolean k0(g g2, a a2, MenuItem menuItem) {
                b.a a3;
                k.g(g2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = g2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = g2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                List list = l.b((Object)g2.q().get(n2));
                f0.o(g2.p(), menuItem.getItemId(), list, false, 8, null);
                if (menuItem.getItemId() == 2131296334 && (a3 = c.a.a.b.b).d()) {
                    a3.a();
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
                return this.y;
            }
        };
    }

}

