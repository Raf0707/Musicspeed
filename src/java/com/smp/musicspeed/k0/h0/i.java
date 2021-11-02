/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  c.a.a.b
 *  c.a.a.b$a
 *  f.u.l
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.h0;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.b;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.h0.b;
import com.smp.musicspeed.k0.h0.c;
import com.smp.musicspeed.k0.h0.d;
import com.smp.musicspeed.k0.l0.h;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.u;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.utils.p;
import f.u.l;
import f.z.d.g;
import f.z.d.k;
import f.z.d.x;
import java.io.File;
import java.util.List;

public final class i
extends m<a, MediaTrack> {
    public i(Context context, u u2, g0 g02) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        k.g(g02, "positionInterface");
        super(context, u2, g02);
    }

    @Override
    public String a(int n2) {
        return com.smp.musicspeed.k0.m0.i.c(this.p(), ((MediaTrack)this.q().get(n2)).getTrackName());
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
        p p2 = new p(1000L * mediaTrack.getDuration());
        a2.d0().setText((CharSequence)mediaTrack.getTrackName());
        a2.c0().setText((CharSequence)p2.toString());
        TextView textView = a2.e0();
        int n3 = mediaTrack.getTrackNumber();
        String string = n3 <= 0 ? "-" : String.valueOf((int)(n3 % 1000));
        textView.setText((CharSequence)string);
    }

    public a u(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.p()).inflate(2131492997, viewGroup, false);
        k.f((Object)view, "view");
        return new RecyclerView.c0(view){
            private final ImageButton A;
            private final TextView x;
            private final TextView y;
            private final TextView z;
            {
                k.g(i.this, "this$0");
                k.g((Object)view, "v");
                super(view);
                View view2 = view.findViewById(2131297257);
                k.f((Object)view2, "v.findViewById(R.id.track_num_text)");
                this.x = (TextView)view2;
                View view3 = view.findViewById(2131297235);
                k.f((Object)view3, "v.findViewById(R.id.title)");
                this.y = (TextView)view3;
                View view4 = view.findViewById(2131297191);
                k.f((Object)view4, "v.findViewById(R.id.text)");
                this.z = (TextView)view4;
                View view5 = view.findViewById(2131296936);
                k.f((Object)view5, "v.findViewById(R.id.menu)");
                this.A = (ImageButton)view5;
                view.setOnClickListener((View.OnClickListener)new c(i.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new b(i.this, this));
                this.j0();
            }

            private static final void Z(i i2, a a2, View view) {
                k.g(i2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = i2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = i2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                if (c.a.a.b.b.d()) {
                    i2.o().m(a2.itemView, n2);
                    return;
                }
                org.greenrobot.eventbus.c c2 = org.greenrobot.eventbus.c.d();
                h h2 = new h(l.M(i2.q()), n2, false, false, 12, null);
                c2.m((Object)h2);
            }

            private static final boolean a0(i i2, a a2, View view) {
                k.g(i2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = i2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = i2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                i2.o().h(a2.itemView, n2);
                return true;
            }

            public static /* synthetic */ boolean f0(i i2, a a2, MenuItem menuItem) {
                return a.l0(i2, a2, menuItem);
            }

            public static /* synthetic */ boolean g0(i i2, a a2, View view) {
                return a.a0(i2, a2, view);
            }

            public static /* synthetic */ void h0(i i2, a a2, View view) {
                a.Z(i2, a2, view);
            }

            public static /* synthetic */ void i0(x x2, i i2, a a2, View view) {
                a.k0(x2, i2, a2, view);
            }

            private final void j0() {
                x x2 = new x();
                this.A.setOnClickListener((View.OnClickListener)new d(x2, i.this, this));
            }

            private static final void k0(x x2, i i2, a a2, View view) {
                k.g(x2, "$lastClick");
                k.g(i2, "this$0");
                k.g((Object)a2, "this$1");
                if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = SystemClock.elapsedRealtime();
                g0 g02 = i2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = n2 >= 0 && n2 < i2.q().size();
                if (!bl) {
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new c0());
                PopupMenu popupMenu = new PopupMenu(i2.p(), (View)a2.b0());
                popupMenu.inflate(2131558408);
                File file = new File(((MediaTrack)i2.q().get(n2)).getLocation());
                if (!com.smp.musicspeed.tag_editor.m.c(file)) {
                    popupMenu.getMenu().findItem(2131296376).setEnabled(false);
                }
                if (!com.smp.musicspeed.folders.u.d(file) && !z.b()) {
                    popupMenu.getMenu().findItem(2131296333).setEnabled(false);
                }
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new com.smp.musicspeed.k0.h0.a(i2, a2));
                popupMenu.show();
            }

            private static final boolean l0(i i2, a a2, MenuItem menuItem) {
                k.g(i2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = i2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = i2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                List list = l.b((Object)i2.q().get(n2));
                f0.o(i2.p(), menuItem.getItemId(), list, false, 8, null);
                return true;
            }

            public final ImageButton b0() {
                return this.A;
            }

            public final TextView c0() {
                return this.z;
            }

            public final TextView d0() {
                return this.y;
            }

            public final TextView e0() {
                return this.x;
            }
        };
    }

}

