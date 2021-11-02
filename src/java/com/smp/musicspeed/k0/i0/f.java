/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
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
 *  java.lang.StringBuilder
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.i0;

import android.annotation.SuppressLint;
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
import com.smp.musicspeed.k0.i0.b;
import com.smp.musicspeed.k0.i0.c;
import com.smp.musicspeed.k0.i0.d;
import com.smp.musicspeed.k0.i0.e;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.k0.u;
import f.u.l;
import f.z.d.k;
import f.z.d.x;
import java.util.List;

public final class f
extends m<a, e> {
    public f(Context context, u u2, g0 g02) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        k.g(g02, "positionInterface");
        super(context, u2, g02);
    }

    @Override
    public String a(int n2) {
        return i.c(this.p(), ((e)this.q().get(n2)).b());
    }

    public int getItemCount() {
        return this.q().size();
    }

    public long getItemId(int n2) {
        return ((e)this.q().get(n2)).a();
    }

    @SuppressLint(value={"SetTextI18n"})
    public void t(a a2, int n2) {
        k.g((Object)a2, "holder");
        a2.itemView.setActivated(this.o().q(n2));
        e e2 = (e)this.q().get(n2);
        long l2 = e2.c();
        String string = this.p().getString(2131821043);
        k.f(string, "context.getString(R.string.library_tab_albums)");
        String string2 = this.p().getString(2131820806);
        k.f(string2, "context.getString(R.string.dot)");
        long l3 = e2.d();
        String string3 = this.p().getString(2131821047);
        k.f(string3, "context.getString(R.string.library_tab_songs)");
        a2.e0().setText((CharSequence)e2.b());
        TextView textView = a2.d0();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append(' ');
        stringBuilder.append(string);
        stringBuilder.append(' ');
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        stringBuilder.append(l3);
        stringBuilder.append(' ');
        stringBuilder.append(string3);
        textView.setText((CharSequence)stringBuilder.toString());
        ((j)((j)com.bumptech.glide.c.u((Context)this.p()).s((Object)new com.smp.musicspeed.playingqueue.i(this.p(), e2)).Q(e2.getMediaType().defaultResource(this.p()))).g(e2.getMediaType().defaultResource(this.p()))).q0(a2.b0());
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
                k.g(f.this, "this$0");
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
                view.setOnClickListener((View.OnClickListener)new b(f.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new com.smp.musicspeed.k0.i0.a(f.this, this));
                this.j0();
            }

            private static final void Z(f f2, a a2, View view) {
                k.g(f2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = f2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = f2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                if (c.a.a.b.b.d()) {
                    f2.o().m(a2.itemView, n2);
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new com.smp.musicspeed.k0.l0.b((e)f2.q().get(n2)));
            }

            private static final boolean a0(f f2, a a2, View view) {
                k.g(f2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = f2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = f2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                f2.o().h(a2.itemView, n2);
                return true;
            }

            public static /* synthetic */ boolean f0(f f2, a a2, View view) {
                return a.a0(f2, a2, view);
            }

            public static /* synthetic */ void g0(f f2, a a2, View view) {
                a.Z(f2, a2, view);
            }

            public static /* synthetic */ boolean h0(f f2, a a2, MenuItem menuItem) {
                return a.l0(f2, a2, menuItem);
            }

            public static /* synthetic */ void i0(x x2, f f2, a a2, View view) {
                a.k0(x2, f2, a2, view);
            }

            private final void j0() {
                x x2 = new x();
                this.A.setOnClickListener((View.OnClickListener)new d(x2, f.this, this));
            }

            private static final void k0(x x2, f f2, a a2, View view) {
                k.g(x2, "$lastClick");
                k.g(f2, "this$0");
                k.g((Object)a2, "this$1");
                if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = SystemClock.elapsedRealtime();
                g0 g02 = f2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = f2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new c0());
                PopupMenu popupMenu = new PopupMenu(f2.p(), (View)a2.c0());
                popupMenu.inflate(2131558409);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new c(f2, a2));
                popupMenu.show();
            }

            private static final boolean l0(f f2, a a2, MenuItem menuItem) {
                k.g(f2, "this$0");
                k.g((Object)a2, "this$1");
                g0 g02 = f2.r();
                k.e(g02);
                int n2 = g02.a(a2.getAdapterPosition());
                boolean bl = false;
                if (n2 >= 0) {
                    int n3 = f2.q().size();
                    bl = false;
                    if (n2 < n3) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return true;
                }
                List list = l.b((Object)f2.q().get(n2));
                f0.o(f2.p(), menuItem.getItemId(), list, false, 8, null);
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

