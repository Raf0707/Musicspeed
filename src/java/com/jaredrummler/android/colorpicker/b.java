/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  b.i.i.a
 *  java.lang.Object
 */
package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.g;
import com.jaredrummler.android.colorpicker.h;
import com.jaredrummler.android.colorpicker.i;

class b
extends BaseAdapter {
    final a f;
    final int[] g;
    int h;
    int i;

    b(a a2, int[] arrn, int n2, int n3) {
        this.f = a2;
        this.g = arrn;
        this.h = n2;
        this.i = n3;
    }

    void a() {
        this.h = -1;
        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.g.length;
    }

    public Object getItem(int n2) {
        return this.g[n2];
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        b b2;
        View view2;
        if (view == null) {
            b2 = new b(viewGroup.getContext());
            view2 = b2.a;
        } else {
            b b3 = (b)view.getTag();
            view2 = view;
            b2 = b3;
        }
        b2.c(n2);
        return view2;
    }

    static interface a {
        public void a(int var1);
    }

    private final class com.jaredrummler.android.colorpicker.b$b {
        View a;
        ColorPanelView b;
        ImageView c;
        int d;

        com.jaredrummler.android.colorpicker.b$b(Context context) {
            View view;
            int n2 = b.this.i == 0 ? i.b : i.a;
            this.a = view = View.inflate((Context)context, (int)n2, null);
            this.b = (ColorPanelView)view.findViewById(h.e);
            this.c = (ImageView)this.a.findViewById(h.b);
            this.d = this.b.getBorderColor();
            this.a.setTag((Object)this);
        }

        private void a(int n2) {
            com.jaredrummler.android.colorpicker.b b2 = b.this;
            if (n2 == b2.h && b.i.i.a.d((int)b2.g[n2]) >= 0.65) {
                this.c.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                return;
            }
            this.c.setColorFilter(null);
        }

        private void b(final int n2) {
            this.b.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    com.jaredrummler.android.colorpicker.b b2 = b.this;
                    int n22 = b2.h;
                    int n3 = n2;
                    if (n22 != n3) {
                        b2.h = n3;
                        b2.notifyDataSetChanged();
                    }
                    com.jaredrummler.android.colorpicker.b b3 = b.this;
                    b3.f.a(b3.g[n2]);
                }
            });
            this.b.setOnLongClickListener(new View.OnLongClickListener(){

                public boolean onLongClick(View view) {
                    b.this.b.d();
                    return true;
                }
            });
        }

        void c(int n2) {
            int n3 = b.this.g[n2];
            int n4 = Color.alpha((int)n3);
            this.b.setColor(n3);
            ImageView imageView = this.c;
            int n5 = b.this.h == n2 ? g.b : 0;
            imageView.setImageResource(n5);
            if (n4 != 255) {
                if (n4 <= 165) {
                    this.b.setBorderColor(n3 | -16777216);
                    this.c.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                } else {
                    this.b.setBorderColor(this.d);
                    this.c.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
            } else {
                this.a(n2);
            }
            this.b(n2);
        }

    }

}

