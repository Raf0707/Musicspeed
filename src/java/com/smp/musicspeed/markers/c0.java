/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  f.a0.a
 *  f.g0.k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlinx.coroutines.b3.y
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.markers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.markers.a0;
import com.smp.musicspeed.markers.d0;
import com.smp.musicspeed.markers.k;
import com.smp.musicspeed.markers.l;
import com.smp.musicspeed.markers.m;
import com.smp.musicspeed.markers.n;
import com.smp.musicspeed.markers.t;
import com.smp.musicspeed.markers.z;
import com.wnafee.vector.compat.ResourcesCompat;
import java.util.List;
import kotlinx.coroutines.b3.y;
import org.greenrobot.eventbus.c;

public final class c0
extends RecyclerView.g<a> {
    private List<MarkerItem> h;
    private final y<t> i;

    public c0(List<MarkerItem> list, y<? super t> y2) {
        f.z.d.k.g(list, "dataSet");
        f.z.d.k.g(y2, "actor");
        this.h = list;
        this.i = y2;
    }

    public int getItemCount() {
        return this.h.size();
    }

    public final y<t> o() {
        return this.i;
    }

    public final List<MarkerItem> p() {
        return this.h;
    }

    public void q(a a2, int n2) {
        f.z.d.k.g((Object)a2, "holder");
        MarkerItem markerItem = (MarkerItem)this.h.get(n2);
        a2.b0().setText((CharSequence)String.valueOf((int)(n2 + 1)));
        TextView textView = a2.e0();
        float f3 = markerItem.getPosition();
        textView.setText((CharSequence)d0.a(f.a0.a.c((double)((double)markerItem.getDurationUs() / 1000.0 * (double)f3))));
        String string = markerItem.getName();
        TextView textView2 = a2.d0();
        if (!(true ^ f.g0.k.h((CharSequence)string))) {
            string = a2.d0().getContext().getString(2131820812);
        }
        textView2.setText((CharSequence)string);
    }

    public a r(ViewGroup viewGroup, int n2) {
        f.z.d.k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131493000, viewGroup, false);
        f.z.d.k.f((Object)view, "from(parent.context).inflate(\n                        R.layout.list_item_marker,\n                        parent,\n                        false)");
        return new a(view);
    }

    public final void s(List<MarkerItem> list) {
        f.z.d.k.g(list, "<set-?>");
        this.h = list;
    }

    public final class a
    extends RecyclerView.c0 {
        private final ImageView A;
        private final TextView B;
        private final View x;
        private final TextView y;
        private final TextView z;

        public a(View view) {
            f.z.d.k.g((Object)c0.this, "this$0");
            f.z.d.k.g((Object)view, "view");
            super(view);
            View view2 = view.findViewById(2131296788);
            f.z.d.k.f((Object)view2, "view.findViewById(R.id.layout_position)");
            this.x = view2;
            View view3 = view.findViewById(2131297219);
            f.z.d.k.f((Object)view3, "view.findViewById(R.id.text_position)");
            this.y = (TextView)view3;
            View view4 = view.findViewById(2131297222);
            f.z.d.k.f((Object)view4, "view.findViewById(R.id.text_time)");
            this.z = (TextView)view4;
            View view5 = view.findViewById(2131296937);
            f.z.d.k.f((Object)view5, "view.findViewById(R.id.menu_markers)");
            this.A = (ImageView)view5;
            View view6 = view.findViewById(2131297216);
            f.z.d.k.f((Object)view6, "view.findViewById(R.id.text_name)");
            this.B = (TextView)view6;
            view.setOnClickListener((View.OnClickListener)new l(c0.this, this));
            view.setOnLongClickListener((View.OnLongClickListener)new n(c0.this, this));
            this.k0();
            this.j0();
        }

        private static final void Z(c0 c02, a a2, View view) {
            f.z.d.k.g((Object)c02, "this$0");
            f.z.d.k.g((Object)a2, "this$1");
            int n2 = -1 + c02.p().size();
            int n3 = a2.getAdapterPosition();
            boolean bl = false;
            if (n3 >= 0) {
                bl = false;
                if (n3 <= n2) {
                    bl = true;
                }
            }
            if (!bl) {
                return;
            }
            c02.o().offer((Object)new z((MarkerItem)c02.p().get(a2.getAdapterPosition())));
        }

        private static final boolean a0(c0 c02, a a2, View view) {
            f.z.d.k.g((Object)c02, "this$0");
            f.z.d.k.g((Object)a2, "this$1");
            int n2 = -1 + c02.p().size();
            int n3 = a2.getAdapterPosition();
            boolean bl = false;
            if (n3 >= 0) {
                bl = false;
                if (n3 <= n2) {
                    bl = true;
                }
            }
            if (!bl) {
                return true;
            }
            c02.o().offer((Object)new a0((MarkerItem)c02.p().get(a2.getAdapterPosition()), 2131296337));
            return true;
        }

        public static /* synthetic */ boolean f0(c0 c02, a a2, MenuItem menuItem) {
            return a.m0(c02, a2, menuItem);
        }

        public static /* synthetic */ void g0(c0 c02, a a2, View view) {
            a.Z(c02, a2, view);
        }

        public static /* synthetic */ void h0(c0 c02, a a2, View view) {
            a.l0(c02, a2, view);
        }

        public static /* synthetic */ boolean i0(c0 c02, a a2, View view) {
            return a.a0(c02, a2, view);
        }

        private final void j0() {
            boolean bl = com.smp.musicspeed.utils.t.w(this.itemView.getContext());
            View view = this.x;
            int n2 = bl ? 2131231031 : 2131231032;
            view.setBackground(ResourcesCompat.getDrawable(this.itemView.getContext(), n2));
        }

        private final void k0() {
            this.A.setOnClickListener((View.OnClickListener)new m(c0.this, this));
        }

        private static final void l0(c0 c02, a a2, View view) {
            f.z.d.k.g((Object)c02, "this$0");
            f.z.d.k.g((Object)a2, "this$1");
            int n2 = -1 + c02.p().size();
            int n3 = a2.getAdapterPosition();
            boolean bl = false;
            if (n3 >= 0) {
                bl = false;
                if (n3 <= n2) {
                    bl = true;
                }
            }
            if (!bl) {
                return;
            }
            c.d().m((Object)new com.smp.musicspeed.k0.c0());
            PopupMenu popupMenu = new PopupMenu(a2.itemView.getContext(), (View)a2.c0());
            popupMenu.inflate(2131558413);
            popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new k(c02, a2));
            popupMenu.show();
        }

        private static final boolean m0(c0 c02, a a2, MenuItem menuItem) {
            f.z.d.k.g((Object)c02, "this$0");
            f.z.d.k.g((Object)a2, "this$1");
            f.z.d.k.g((Object)menuItem, "menuItem");
            int n2 = -1 + c02.p().size();
            int n3 = a2.getAdapterPosition();
            boolean bl = false;
            if (n3 >= 0) {
                bl = false;
                if (n3 <= n2) {
                    bl = true;
                }
            }
            if (!bl) {
                return true;
            }
            c02.o().offer((Object)new a0((MarkerItem)c02.p().get(a2.getAdapterPosition()), menuItem.getItemId()));
            return true;
        }

        public final TextView b0() {
            return this.y;
        }

        public final ImageView c0() {
            return this.A;
        }

        public final TextView d0() {
            return this.B;
        }

        public final TextView e0() {
            return this.z;
        }
    }

}

