/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.bumptech.glide.s.d
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.library.artistsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.o.j;
import com.bumptech.glide.r.a;
import com.bumptech.glide.s.d;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.album.e;
import com.smp.musicspeed.playingqueue.i;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class e
extends com.smp.musicspeed.library.album.e {
    public e(Context context, u u2) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        super(context, u2, null, 4, null);
    }

    @Override
    public void t(e.a a2, int n2) {
        k.g((Object)a2, "holder");
        a2.itemView.findViewById(2131296726).setActivated(this.o().q(n2));
        Album album = (Album)this.q().get(n2);
        a2.f0().setText((CharSequence)album.m());
        a2.e0().setText((CharSequence)album.p());
        com.bumptech.glide.j j2 = (com.bumptech.glide.j)((com.bumptech.glide.j)c.u((Context)this.p()).s((Object)new i(this.p(), album)).e(j.c)).X((com.bumptech.glide.load.g)new d((Object)album.q()));
        I i2 = I.b;
        ((com.bumptech.glide.j)((com.bumptech.glide.j)j2.Q(i2.defaultResourceLargeAlbum(this.p()))).g(i2.defaultResourceLargeAlbum(this.p()))).q0(a2.c0());
        TextView textView = a2.e0();
        String string = album.r() == 0 ? "-" : String.valueOf((int)album.r());
        textView.setText((CharSequence)string);
        boolean bl = ((com.smp.musicspeed.k0.m0.g)com.smp.musicspeed.k0.m0.g.a.a(this.p())).d() == album.o();
        View view = a2.itemView;
        int n3 = bl ? 0 : 4;
        view.setVisibility(n3);
    }

    @Override
    public e.a u(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.p()).inflate(2131492998, viewGroup, false);
        k.f((Object)view, "view");
        return new RecyclerView.c0(this, view){
            private final android.widget.ImageButton A;
            private final View B;
            final /* synthetic */ com.smp.musicspeed.library.album.e C;
            private final ImageView x;
            private final TextView y;
            private final TextView z;
            {
                k.g(e2, "this$0");
                k.g((Object)view, "v");
                this.C = e2;
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
                this.A = (android.widget.ImageButton)view.findViewById(2131296936);
                View view5 = view.findViewById(2131296726);
                k.f((Object)view5, "v.findViewById(R.id.grid_item_container)");
                this.B = view5;
                view.setOnClickListener((android.view.View$OnClickListener)new com.smp.musicspeed.library.album.d(e2, this));
                view.setOnLongClickListener((android.view.View$OnLongClickListener)new com.smp.musicspeed.library.album.b(e2, this));
                this.k0();
            }

            private static final void Z(com.smp.musicspeed.library.album.e e2, e.a a2, View view) {
                k.g(e2, "this$0");
                k.g((Object)((Object)a2), "this$1");
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

            private static final boolean a0(com.smp.musicspeed.library.album.e e2, e.a a2, View view) {
                k.g(e2, "this$0");
                k.g((Object)((Object)a2), "this$1");
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

            public static /* synthetic */ void g0(f.z.d.x x2, com.smp.musicspeed.library.album.e e2, e.a a2, View view) {
                e.a.l0(x2, e2, a2, view);
            }

            public static /* synthetic */ boolean h0(com.smp.musicspeed.library.album.e e2, e.a a2, View view) {
                return e.a.a0(e2, a2, view);
            }

            public static /* synthetic */ boolean i0(com.smp.musicspeed.library.album.e e2, e.a a2, android.view.MenuItem menuItem) {
                return e.a.m0(e2, a2, menuItem);
            }

            public static /* synthetic */ void j0(com.smp.musicspeed.library.album.e e2, e.a a2, View view) {
                e.a.Z(e2, a2, view);
            }

            private final void k0() {
                f.z.d.x x2 = new f.z.d.x();
                android.widget.ImageButton imageButton = this.A;
                if (imageButton == null) {
                    return;
                }
                imageButton.setOnClickListener((android.view.View$OnClickListener)new com.smp.musicspeed.library.album.a(x2, this.C, this));
            }

            private static final void l0(f.z.d.x x2, com.smp.musicspeed.library.album.e e2, e.a a2, View view) {
                k.g(x2, "$lastClick");
                k.g(e2, "this$0");
                k.g((Object)((Object)a2), "this$1");
                if (android.os.SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = android.os.SystemClock.elapsedRealtime();
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
                org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.c0());
                android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(e2.p(), (View)a2.d0());
                popupMenu.inflate(2131558407);
                popupMenu.setOnMenuItemClickListener((android.widget.PopupMenu$OnMenuItemClickListener)new com.smp.musicspeed.library.album.c(e2, a2));
                popupMenu.show();
            }

            private static final boolean m0(com.smp.musicspeed.library.album.e e2, e.a a2, android.view.MenuItem menuItem) {
                k.g(e2, "this$0");
                k.g((Object)((Object)a2), "this$1");
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
                com.smp.musicspeed.k0.f0.o(e2.p(), menuItem.getItemId(), f.u.l.b((Object)e2.q().get(a2.getAdapterPosition())), false, 8, null);
                return true;
            }

            public final View b0() {
                return this.B;
            }

            public final ImageView c0() {
                return this.x;
            }

            public final android.widget.ImageButton d0() {
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

