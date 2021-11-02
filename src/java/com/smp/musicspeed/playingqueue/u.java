/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  b.i.h.a
 *  b.i.q.w
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.l
 *  com.bumptech.glide.load.g
 *  com.bumptech.glide.load.o.j
 *  com.bumptech.glide.load.q.f.c
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.bumptech.glide.s.d
 *  com.smp.musicspeed.playingqueue.u$b
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.i.q.w;
import c.f.a.a.a.b.d;
import com.bumptech.glide.r.j.j;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.player.PlayFileService;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.playingqueue.d0;
import com.smp.musicspeed.playingqueue.g;
import com.smp.musicspeed.playingqueue.h;
import com.smp.musicspeed.playingqueue.i;
import com.smp.musicspeed.playingqueue.l;
import com.smp.musicspeed.playingqueue.q;
import com.smp.musicspeed.playingqueue.u;
import com.smp.musicspeed.playingqueue.v;
import com.smp.musicspeed.playingqueue.x;
import com.smp.musicspeed.utils.t;
import io.gresse.hugo.vumeterlibrary.VuMeterView;
import java.lang.reflect.Field;

/*
 * Exception performing whole class analysis.
 */
public class u
extends RecyclerView.g<b>
implements d<b>,
c.f.a.a.a.c.h<b> {
    private Context h;
    private a i;
    private h j;

    public u(Context context, h h2) {
        this.j = h2;
        this.h = context;
        this.setHasStableIds(true);
    }

    static /* synthetic */ Context p(u u2) {
        return u2.h;
    }

    private boolean t(VuMeterView vuMeterView) {
        try {
            Field field = vuMeterView.getClass().getDeclaredField("mState");
            field.setAccessible(true);
            int n2 = field.getInt((Object)vuMeterView);
            return n2 == 2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return true;
        }
    }

    private /* synthetic */ void u(b b2, View view) {
        int n2 = b2.getAdapterPosition();
        if (n2 >= 0) {
            if (n2 > this.j.a() - 1) {
                return;
            }
            org.greenrobot.eventbus.c.d().m((Object)new v(n2, true));
        }
    }

    public int A(b b2, int n2, int n3, int n4) {
        if (this.x(b2, n2, n3, n4)) {
            return 0;
        }
        return 8194;
    }

    void B(int n2, MediaTrack mediaTrack, boolean bl) {
        org.greenrobot.eventbus.c.d().m((Object)new x(n2, mediaTrack, bl));
        this.j.d(n2);
        this.notifyItemRemoved(n2);
    }

    public void C(b b2, int n2, int n3) {
        int n4 = n3 != 0 ? 0 : 2131230835;
        b2.itemView.setBackgroundResource(n4);
    }

    public c.f.a.a.a.c.m.a D(b b2, int n2, int n3) {
        if (n3 != 2) {
            if (n3 != 4) {
                if (n2 != -1) {
                    // empty if block
                }
                return null;
            }
            return new c(this, n2, this.h);
        }
        return new c(this, n2, this.h);
    }

    public void F() {
        this.j.e();
        this.notifyDataSetChanged();
    }

    @Override
    public void d(int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        this.j.c(n2, n3);
        this.notifyItemMoved(n2, n3);
    }

    public int getItemCount() {
        return this.j.a();
    }

    public long getItemId(int n2) {
        return this.j.b(n2).a();
    }

    public int getItemViewType(int n2) {
        return this.j.b(n2).b();
    }

    @Override
    public boolean l(int n2, int n3) {
        return true;
    }

    public void r() {
        ((q)this.j).f();
        this.notifyItemRangeChanged(0, this.j.a());
    }

    public void s() {
        ((q)this.j).f();
        this.notifyDataSetChanged();
    }

    public /* synthetic */ void v(b b2, View view) {
        this.u(b2, view);
    }

    public void w(b b2, int n2) {
        q.a a2 = (q.a)this.j.b(n2);
        b2.I.setOnClickListener((View.OnClickListener)new g(this, b2));
        String string = a2.c().getArtistName();
        if (string != null) {
            b2.N.setText((CharSequence)string);
        } else {
            b2.N.setText((CharSequence)this.h.getString(2131820965));
        }
        String string2 = a2.c().getTrackName();
        if (string2 != null) {
            b2.M.setText((CharSequence)string2);
        } else {
            b2.M.setText((CharSequence)this.h.getString(2131820965));
        }
        if (b2.R != a2.c()) {
            ((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)com.bumptech.glide.c.u((Context)this.h).s((Object)new i(this.h, a2.c())).A0((com.bumptech.glide.l)com.bumptech.glide.load.q.f.c.h()).e(com.bumptech.glide.load.o.j.a)).X((com.bumptech.glide.load.g)new com.bumptech.glide.s.d((Object)a2.c().getDateModified()))).R(null)).g(a2.c().getMediaType().defaultResource(this.h))).q0(b2.K);
            b2.R = a2.c();
        }
        if (a2.c().isInLibrary()) {
            b2.Q.setVisibility(8);
        } else {
            b2.Q.setVisibility(0);
        }
        if (PlayingQueue.getDefault().getCurrentlyPlaying() == n2) {
            b2.L.setVisibility(0);
            b2.O.setVisibility(0);
            b2.K.setVisibility(8);
            if (PlayFileService.g) {
                b2.L.resume(true);
            } else if (this.t(b2.L)) {
                b2.L.stop(true);
            }
        } else {
            if (this.t(b2.L)) {
                b2.L.stop(true);
            }
            b2.L.setVisibility(8);
            b2.O.setVisibility(8);
            b2.K.setVisibility(0);
        }
        int n3 = b2.f();
        int n4 = t.w(this.h) ? b.i.h.a.c((Context)this.h, (int)2131100304) : b.i.h.a.c((Context)this.h, (int)2131100305);
        if ((Integer.MIN_VALUE & n3) != 0) {
            if ((n3 & 2) != 0) {
                l.a(b2.I.getForeground());
            } else {
                n3 & 1;
            }
            b2.I.setBackgroundColor(n4);
        }
        float f2 = a2.d() ? -65536.0f : 0.0f;
        b2.o(f2);
    }

    public boolean x(b b2, int n2, int n3, int n4) {
        FrameLayout frameLayout = b2.I;
        View view = b2.J;
        int n5 = frameLayout.getLeft() + (int)(0.5f + w.N((View)frameLayout));
        int n6 = frameLayout.getTop() + (int)(0.5f + w.O((View)frameLayout));
        return d0.a(view, n3 - n5, n4 - n6);
    }

    public b y(ViewGroup viewGroup, int n2) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public c.f.a.a.a.b.i z(b b2, int n2) {
        return null;
    }

    private static class c
    extends c.f.a.a.a.c.m.c {
        private u b;
        private final int c;
        private final Context d;

        c(u u2, int n2, Context context) {
            this.b = u2;
            this.c = n2;
            this.d = context.getApplicationContext();
        }

        @Override
        protected void b() {
            c.f.a.a.a.c.m.a.super.b();
            this.b = null;
        }

        @Override
        protected void c() {
            c.f.a.a.a.c.m.a.super.c();
            MediaTrack mediaTrack = ((q.a)this.b.j.b(this.c)).c();
            this.b.B(this.c, mediaTrack, false);
        }

        @Override
        protected void d() {
            c.f.a.a.a.c.m.a.super.d();
            if (this.b.i != null) {
                this.b.i.a(this.c);
            }
        }
    }

}

