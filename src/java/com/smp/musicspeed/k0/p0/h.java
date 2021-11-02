/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
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
package com.smp.musicspeed.k0.p0;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.g0;
import com.smp.musicspeed.k0.m;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.k0.p0.b;
import com.smp.musicspeed.k0.p0.c;
import com.smp.musicspeed.k0.p0.d;
import com.smp.musicspeed.k0.p0.e;
import com.smp.musicspeed.k0.u;
import f.z.d.g;
import f.z.d.k;
import f.z.d.x;
import java.io.File;
import java.util.List;

public final class h
extends m<a, MediaTrack>
implements com.smp.musicspeed.m0.a {
    private final com.smp.musicspeed.m0.c l;
    private final long m;
    private final boolean n;

    public h(Context context, u u2, com.smp.musicspeed.m0.c c2, long l2, boolean bl, g0 g02) {
        k.g((Object)context, "context");
        k.g(u2, "cabInterface");
        k.g(c2, "dragStartDragListener");
        k.g(g02, "positionInterface");
        super(context, u2, g02);
        this.l = c2;
        this.m = l2;
        this.n = bl;
    }

    private static final void w(h h2, int n2, int n3) {
        MediaTrack mediaTrack = (MediaTrack)h2.q().remove(n2);
        h2.q().add(n3, (Object)mediaTrack);
        h2.notifyItemMoved(n2, n3);
    }

    @Override
    public String a(int n2) {
        return i.c(this.p(), ((MediaTrack)this.q().get(n2)).getTrackName());
    }

    public int getItemCount() {
        return this.q().size();
    }

    public long getItemId(int n2) {
        return ((MediaTrack)this.q().get(n2)).getSongId();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void m(int var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl15 : ILOAD_3 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:923)
        throw new IllegalStateException("Decompilation failed");
    }

    public final com.smp.musicspeed.m0.c t() {
        return this.l;
    }

    public void u(a a2, int n2) {
        k.g(a2, "holder");
        a2.itemView.setActivated(this.o().q(n2));
        MediaTrack mediaTrack = (MediaTrack)this.q().get(n2);
        a2.f0().setText((CharSequence)mediaTrack.getTrackName());
        a2.e0().setText((CharSequence)mediaTrack.getArtistName());
        ((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)((com.bumptech.glide.j)com.bumptech.glide.c.u((Context)this.p()).s((Object)new com.smp.musicspeed.playingqueue.i(this.p(), mediaTrack)).Q(mediaTrack.getMediaType().defaultResource(this.p()))).A0((l)com.bumptech.glide.load.q.f.c.h()).e(com.bumptech.glide.load.o.j.d)).X((com.bumptech.glide.load.g)new com.bumptech.glide.s.d((Object)mediaTrack.getDateModified()))).g(mediaTrack.getMediaType().defaultResource(this.p()))).q0(a2.c0());
    }

    public a v(ViewGroup viewGroup, int n2) {
        k.g((Object)viewGroup, "parent");
        View view = LayoutInflater.from((Context)this.p()).inflate(2131493002, viewGroup, false);
        view.findViewById(2131297191).setVisibility(0);
        k.f((Object)view, "view");
        return new com.smp.musicspeed.m0.b(view){
            private final ImageButton A;
            private final View B;
            private final ImageView x;
            private final TextView y;
            private final TextView z;
            {
                k.g(h.this, "this$0");
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
                View view6 = view.findViewById(2131296655);
                k.f((Object)view6, "v.findViewById(R.id.drag_handle)");
                this.B = view6;
                view.setHapticFeedbackEnabled(false);
                view6.setOnTouchListener((View.OnTouchListener)new d(h.this, this));
                view.setOnClickListener((View.OnClickListener)new e(h.this, this));
                view.setOnLongClickListener((View.OnLongClickListener)new b(h.this, this));
                this.l0();
            }

            private static final boolean Z(h h2, a a2, View view, MotionEvent motionEvent) {
                k.g(h2, "this$0");
                k.g(a2, "this$1");
                if (motionEvent.getActionMasked() == 0) {
                    h2.t().i(a2);
                }
                return false;
            }

            private static final void a0(h h2, a a2, View view) {
                k.g(h2, "this$0");
                k.g(a2, "this$1");
                int n2 = h2.q().size();
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
                    h2.o().m(a2.itemView, a2.getAdapterPosition());
                    return;
                }
                org.greenrobot.eventbus.c c2 = org.greenrobot.eventbus.c.d();
                com.smp.musicspeed.k0.l0.h h3 = new com.smp.musicspeed.k0.l0.h(f.u.l.M(h2.q()), a2.getAdapterPosition(), false, false, 12, null);
                c2.m((Object)h3);
            }

            private static final boolean b0(h h2, a a2, View view) {
                k.g(h2, "this$0");
                k.g(a2, "this$1");
                int n2 = h2.q().size();
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
                h2.o().h(a2.itemView, a2.getAdapterPosition());
                return true;
            }

            public static /* synthetic */ void g0(x x2, h h2, a a2, View view) {
                a.m0(x2, h2, a2, view);
            }

            public static /* synthetic */ boolean h0(h h2, a a2, View view) {
                return a.b0(h2, a2, view);
            }

            public static /* synthetic */ boolean i0(h h2, a a2, MediaTrack mediaTrack, MenuItem menuItem) {
                return a.n0(h2, a2, mediaTrack, menuItem);
            }

            public static /* synthetic */ boolean j0(h h2, a a2, View view, MotionEvent motionEvent) {
                return a.Z(h2, a2, view, motionEvent);
            }

            public static /* synthetic */ void k0(h h2, a a2, View view) {
                a.a0(h2, a2, view);
            }

            private final void l0() {
                x x2 = new x();
                this.A.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.k0.p0.a(x2, h.this, this));
            }

            private static final void m0(x x2, h h2, a a2, View view) {
                MediaTrack mediaTrack;
                k.g(x2, "$lastClick");
                k.g(h2, "this$0");
                k.g(a2, "this$1");
                if (SystemClock.elapsedRealtime() - 1000L < x2.f) {
                    return;
                }
                x2.f = SystemClock.elapsedRealtime();
                int n2 = h2.q().size();
                int n3 = a2.getAdapterPosition();
                boolean bl = n3 >= 0 && n3 < n2;
                if (!bl) {
                    return;
                }
                org.greenrobot.eventbus.c.d().m((Object)new c0());
                PopupMenu popupMenu = new PopupMenu(h2.p(), (View)a2.d0());
                popupMenu.inflate(2131558417);
                if (!com.smp.musicspeed.tag_editor.m.c(new File(((MediaTrack)h2.q().get(a2.getAdapterPosition())).getLocation()))) {
                    popupMenu.getMenu().findItem(2131296376).setEnabled(false);
                }
                if ((mediaTrack = (MediaTrack)h2.q().get(a2.getAdapterPosition())).getMediaType() != I.a) {
                    popupMenu.getMenu().findItem(2131296339).setEnabled(false);
                    popupMenu.getMenu().findItem(2131296340).setEnabled(false);
                }
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)new c(h2, a2, mediaTrack));
                popupMenu.show();
            }

            private static final boolean n0(h h2, a a2, MediaTrack mediaTrack, MenuItem menuItem) {
                b.a a3;
                k.g(h2, "this$0");
                k.g(a2, "this$1");
                k.g(mediaTrack, "$track");
                int n2 = h2.q().size();
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
                List list = f.u.l.b((Object)mediaTrack);
                f0.o(h2.p(), menuItem.getItemId(), list, false, 8, null);
                if (menuItem.getItemId() == 2131296358 && (a3 = c.a.a.b.b).d()) {
                    a3.a();
                }
                return true;
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

            @Override
            public void l() {
            }

            @Override
            public void r() {
            }
        };
    }

}

