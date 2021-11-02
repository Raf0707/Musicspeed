/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.PopupMenu
 *  android.widget.PopupMenu$OnMenuItemClickListener
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlinx.coroutines.b3.y
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.l0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.smp.musicspeed.dbrecord.PresetItem;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.l0.e;
import com.smp.musicspeed.l0.f;
import com.smp.musicspeed.l0.g;
import com.smp.musicspeed.l0.j;
import com.smp.musicspeed.l0.l;
import com.smp.musicspeed.l0.m;
import f.z.d.k;
import java.util.List;
import kotlinx.coroutines.b3.y;
import org.greenrobot.eventbus.c;

public final class p
extends RecyclerView.g<a> {
    private List<PresetItem> h;
    private final y<j> i;

    public p(List<PresetItem> list, y<? super j> y2) {
        k.g(list, "dataSet");
        k.g(y2, "actor");
        this.h = list;
        this.i = y2;
    }

    public int getItemCount() {
        return this.h.size();
    }

    public final y<j> o() {
        return this.i;
    }

    public final List<PresetItem> p() {
        return this.h;
    }

    public void q(a a2, int n2) {
        k.g((Object)a2, "holder");
        PresetItem presetItem = (PresetItem)this.h.get(n2);
        a2.b0().setText((CharSequence)presetItem.getPresetName());
    }

    public a r(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131493004, viewGroup, false);
        k.f((Object)view, "from(parent.context).inflate(\n                        R.layout.list_item_preset,\n                        parent,\n                        false)");
        return new a(view);
    }

    public final void s(List<PresetItem> list) {
        k.g(list, "<set-?>");
        this.h = list;
    }

    public final class a
    extends RecyclerView.c0 {
        private final TextView x;
        private final ImageView y;

        public a(View view) {
            k.g((Object)p.this, "this$0");
            k.g((Object)view, "view");
            super(view);
            View view2 = view.findViewById(2131297220);
            k.f((Object)view2, "view.findViewById(R.id.text_preset_name)");
            this.x = (TextView)view2;
            View view3 = view.findViewById(2131296938);
            k.f((Object)view3, "view.findViewById(R.id.menu_preset)");
            this.y = (ImageView)view3;
            view.setOnClickListener((View.OnClickListener)new e(p.this, this));
            this.f0();
        }

        private static final void Z(p p2, a a2, View view) {
            k.g((Object)p2, "this$0");
            k.g((Object)a2, "this$1");
            int n2 = -1 + p2.p().size();
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
            p2.o().offer((Object)new l((PresetItem)p2.p().get(a2.getAdapterPosition())));
        }

        public static /* synthetic */ void c0(p p2, a a2, View view) {
            a.Z(p2, a2, view);
        }

        public static /* synthetic */ boolean d0(p p2, a a2, MenuItem menuItem) {
            return a.h0(p2, a2, menuItem);
        }

        public static /* synthetic */ void e0(p p2, a a2, View view) {
            a.g0(p2, a2, view);
        }

        private final void f0() {
            this.y.setOnClickListener((View.OnClickListener)new g(p.this, this));
        }

        private static final void g0(p p2, a a2, View view) {
            k.g((Object)p2, "this$0");
            k.g((Object)a2, "this$1");
            int n2 = -1 + p2.p().size();
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
            c.d().m((Object)new c0());
            PopupMenu popupMenu = new PopupMenu(a2.itemView.getContext(), (View)a2.a0());
            popupMenu.inflate(2131558418);
            popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new f(p2, a2));
            popupMenu.show();
        }

        private static final boolean h0(p p2, a a2, MenuItem menuItem) {
            k.g((Object)p2, "this$0");
            k.g((Object)a2, "this$1");
            k.g((Object)menuItem, "menuItem");
            int n2 = -1 + p2.p().size();
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
            p2.o().offer((Object)new m((PresetItem)p2.p().get(a2.getAdapterPosition()), menuItem.getItemId()));
            return true;
        }

        public final ImageView a0() {
            return this.y;
        }

        public final TextView b0() {
            return this.x;
        }
    }

}

