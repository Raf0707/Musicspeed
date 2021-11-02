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
 *  com.bumptech.glide.l
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.load.q.f.c
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.bumptech.glide.s.d
 *  f.u.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.library.album;

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
import com.bumptech.glide.l;
import com.bumptech.glide.r.j.j;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.album.b;
import com.smp.musicspeed.library.album.c;
import com.smp.musicspeed.library.album.d;
import f.z.d.g;
import f.z.d.k;
import f.z.d.x;
import java.util.List;

public class e
extends m<a, Album> {
    public e(Context context, u u2, g0 g02) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        super(context, u2, g02);
    }

    public /* synthetic */ e(Context context, u u2, g0 g02, int n2, g g2) {
        if ((n2 & 4) != 0) {
            g02 = null;
        }
        this(context, u2, g02);
    }

    @Override
    public String a(int n2) {
        return i.c(this.p(), ((Album)this.q().get(n2)).m());
    }

    public int getItemCount() {
        return this.q().size();
    }

    public long getItemId(int n2) {
        return ((Album)this.q().get(n2)).l();
    }

    public void t(a a2, int n2) {
        k.g((Object)a2, "holder");
        a2.itemView.findViewById(2131296726).setActivated(this.o().q(n2));
        Album album = (Album)this.q().get(n2);
        a2.f0().setText((CharSequence)album.m());
        a2.e0().setText((CharSequence)album.p());
        com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)com.bumptech.glide.c.u((Context)this.p()).s((Object)new com.smp.musicspeed.playingqueue.i(this.p(), album)).A0((l)com.bumptech.glide.load.q.f.c.h()).e(com.bumptech.glide.load.o.j.c)).X((com.bumptech.glide.load.g)new com.bumptech.glide.s.d((Object)album.q()));
        I i2 = I.b;
        ((com.bumptech.glide.j)((com.bumptech.glide.j)j2.Q(i2.defaultResourceLargeAlbum(this.p()))).g(i2.defaultResourceLargeAlbum(this.p()))).q0(a2.c0());
    }

    public a u(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.p()).inflate(2131492982, viewGroup, false);
        k.f((Object)view, "view");
        return new RecyclerView.c0(view){
            private final ImageButton A;
            private final View B;
            private final ImageView x;
            private final TextView y;
            private final TextView z;
            {
                k.g(e.this, "this$0");
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
                this.A = (ImageButton)view.findViewById(2131296936);
                View view5 = view.findViewById(2131296726);
                k.f((Object)view5, "v.findViewById(R.id.grid_item_container)");
                this.B = view5;
                view.setOnClickListener((View.OnClickListener)new d(e.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new b(e.this, this));
                this.k0();
            }

            private static final void Z(e e2, a a2, View view) {
                k.g(e2, "this$0");
                k.g((Object)a2, "this$1");
                int n2 = e2.q().size();
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
                if (c.a.a.b.b.d()) {
                    e2.o().m(a2.b0(), a2.getAdapterPosition());
                    return;
                }
                Album album = (Album)e2.q().get(a2.getAdapterPosition());
                org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.l0.a(album));
            }

            private static final boolean a0(e e2, a a2, View view) {
                k.g(e2, "this$0");
                k.g((Object)a2, "this$1");
                int n2 = e2.q().size();
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
                e2.o().h(a2.b0(), a2.getAdapterPosition());
                return true;
            }

            public static /* synthetic */ void g0(x x2, e e2, a a2, View view) {
                a.l0(x2, e2, a2, view);
            }

            public static /* synthetic */ boolean h0(e e2, a a2, View view) {
                return a.a0(e2, a2, view);
            }

            public static /* synthetic */ boolean i0(e e2, a a2, MenuItem menuItem) {
                return a.m0(e2, a2, menuItem);
            }

            public static /* synthetic */ void j0(e e2, a a2, View view) {
                a.Z(e2, a2, view);
            }

            private final void k0() {
                x x2 = new x();
                ImageButton imageButton = this.A;
                if (imageButton == null) {
                    return;
                }
                imageButton.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.library.album.a(x2, e.this, this));
            }

            private static final void l0(x x2, e e2, a a2, View view) {
                k.g(x2, "$lastClick");
                k.g(e2, "this$0");
                k.g((Object)a2, "this$1");
                if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = SystemClock.elapsedRealtime();
                int n2 = e2.q().size();
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
                PopupMenu popupMenu = new PopupMenu(e2.p(), (View)a2.d0());
                popupMenu.inflate(2131558407);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new c(e2, a2));
                popupMenu.show();
            }

            private static final boolean m0(e e2, a a2, MenuItem menuItem) {
                k.g(e2, "this$0");
                k.g((Object)a2, "this$1");
                int n2 = e2.q().size();
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
                f0.o(e2.p(), menuItem.getItemId(), f.u.l.b((Object)e2.q().get(a2.getAdapterPosition())), false, 8, null);
                return true;
            }

            public final View b0() {
                return this.B;
            }

            public final ImageView c0() {
                return this.x;
            }

            public final ImageButton d0() {
                return this.A;
            }

            public final TextView e0() {
                return this.z;
            }

            public final TextView f0() {
                return this.y;
            }
        };
    }

}

