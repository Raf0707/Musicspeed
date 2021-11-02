/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.SystemClock
 *  android.view.LayoutInflater
 *  android.view.Menu
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
 *  com.bumptech.glide.l
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.load.q.f.c
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.bumptech.glide.s.d
 *  f.u.l
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.b;
import com.bumptech.glide.l;
import com.bumptech.glide.s.d;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.h;
import com.smp.musicspeed.k0.j;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.k0.z;
import f.z.d.k;
import f.z.d.x;
import java.io.File;
import java.util.List;
import org.greenrobot.eventbus.c;

public abstract class r
extends m<a, MediaTrack> {
    public r(Context context, u u2, g0 g02) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        k.g(g02, "positionInterface");
        super(context, u2, g02);
    }

    @Override
    public String a(int n2) {
        String string = com.smp.musicspeed.utils.k.w(this.p(), this.t().ordinal());
        boolean bl = k.c(string, "title_key") ? true : k.c(string, "title_key DESC");
        if (bl) {
            return i.c(this.p(), ((MediaTrack)this.q().get(n2)).getTrackName());
        }
        return i.b(((MediaTrack)this.q().get(n2)).getDateModified());
    }

    public int getItemCount() {
        return this.q().size();
    }

    public long getItemId(int n2) {
        return ((MediaTrack)this.q().get(n2)).getSongId();
    }

    public abstract g.b t();

    public abstract int u();

    public void v(a a2, int n2) {
        k.g((Object)((Object)a2), "holder");
        a2.itemView.setActivated(this.o().q(n2));
        MediaTrack mediaTrack = (MediaTrack)this.q().get(n2);
        a2.e0().setText((CharSequence)mediaTrack.getTrackName());
        a2.d0().setText((CharSequence)mediaTrack.getArtistName());
        ((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)com.bumptech.glide.c.u((Context)this.p()).s((Object)new com.smp.musicspeed.playingqueue.i(this.p(), mediaTrack)).A0((l)com.bumptech.glide.load.q.f.c.h()).e(com.bumptech.glide.load.o.j.d)).X((com.bumptech.glide.load.g)new d((Object)mediaTrack.getDateModified()))).R(null)).g(mediaTrack.getMediaType().defaultResource(this.p()))).q0(a2.b0());
    }

    public a w(ViewGroup viewGroup, int n2) {
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
                k.g(r.this, "this$0");
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
                view.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.g(r.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new h(r.this, this));
                this.j0();
            }

            private static final void Z(r r2, a a2, View view) {
                k.g(r2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = r2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = r2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                if (b.b.d()) {
                    r2.o().m(a2.itemView, n2);
                    return;
                }
                c c2 = c.d();
                com.smp.musicspeed.k0.l0.h h2 = new com.smp.musicspeed.k0.l0.h(f.u.l.M(r2.q()), n2, false, false, 12, null);
                c2.m((Object)h2);
            }

            private static final boolean a0(r r2, a a2, View view) {
                k.g(r2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = r2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = r2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                r2.o().h(a2.itemView, n2);
                return true;
            }

            public static /* synthetic */ void f0(r r2, a a2, View view) {
                a.Z(r2, a2, view);
            }

            public static /* synthetic */ boolean g0(r r2, a a2, View view) {
                return a.a0(r2, a2, view);
            }

            public static /* synthetic */ boolean h0(r r2, a a2, MenuItem menuItem) {
                return a.l0(r2, a2, menuItem);
            }

            public static /* synthetic */ void i0(x x2, r r2, a a2, View view) {
                a.k0(x2, r2, a2, view);
            }

            private final void j0() {
                x x2 = new x();
                this.A.setOnClickListener((View.OnClickListener)new j(x2, r.this, this));
            }

            private static final void k0(x x2, r r2, a a2, View view) {
                k.g(x2, "$lastClick");
                k.g(r2, "this$0");
                k.g((Object)a2, "this$1");
                if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = SystemClock.elapsedRealtime();
                g0 g02 = r2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = n2 >= 0 && n2 < r2.q().size();
                if (!bl) {
                    return;
                }
                c.d().m((Object)new c0());
                PopupMenu popupMenu = new PopupMenu(r2.p(), (View)a2.c0());
                popupMenu.inflate(r2.u());
                File file = new File(((MediaTrack)r2.q().get(n2)).getLocation());
                if (!com.smp.musicspeed.tag_editor.m.c(file)) {
                    popupMenu.getMenu().findItem(2131296376).setEnabled(false);
                }
                if (!com.smp.musicspeed.folders.u.d(file) && !z.b()) {
                    popupMenu.getMenu().findItem(2131296333).setEnabled(false);
                }
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new com.smp.musicspeed.k0.i(r2, a2));
                popupMenu.show();
            }

            private static final boolean l0(r r2, a a2, MenuItem menuItem) {
                k.g(r2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = r2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = r2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                List list = f.u.l.b((Object)r2.q().get(n2));
                f0.o(r2.p(), menuItem.getItemId(), list, false, 8, null);
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

