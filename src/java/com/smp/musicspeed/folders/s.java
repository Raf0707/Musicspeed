/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.SystemClock
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.app.e
 *  androidx.fragment.app.d
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$c0
 *  androidx.recyclerview.widget.RecyclerView$g
 *  c.a.a.b
 *  c.a.a.b$a
 *  c.a.b.q.a
 *  com.bumptech.glide.c
 *  com.bumptech.glide.j
 *  com.bumptech.glide.l
 *  com.bumptech.glide.load.q.f.c
 *  com.bumptech.glide.r.a
 *  com.bumptech.glide.r.j.j
 *  com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.DecimalFormat
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.folders;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.e;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.b;
import com.bumptech.glide.l;
import com.bumptech.glide.r.j.j;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.k0.c0;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.utils.k;
import com.smp.musicspeed.utils.n;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.c;

public class s
extends RecyclerView.g<b>
implements FastScrollRecyclerView.e {
    private final e h;
    private Map<File, MediaTrack> i;
    private final int j;
    private com.smp.musicspeed.k0.u k;
    private final a l;
    private List<File> m;

    public s(e e2, Map<File, MediaTrack> map, int n2, a a2, com.smp.musicspeed.k0.u u3) {
        this.h = e2;
        this.i = map;
        this.m = new ArrayList((Collection)this.i.keySet());
        this.j = n2;
        this.l = a2;
        this.k = u3;
        this.setHasStableIds(false);
    }

    private I B(File file) {
        MediaTrack mediaTrack = (MediaTrack)this.i.get((Object)file);
        if (mediaTrack != null) {
            return mediaTrack.getMediaType();
        }
        return I.g;
    }

    public static String z(long l2) {
        if (l2 <= 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l2);
            stringBuilder.append(" B");
            return stringBuilder.toString();
        }
        String[] arrstring = new String[]{"B", "KB", "MB", "GB", "TB"};
        double d2 = l2;
        int n2 = (int)(Math.log10((double)d2) / Math.log10((double)1024.0));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new DecimalFormat("#,##0.##").format(d2 / Math.pow((double)1024.0, (double)n2)));
        stringBuilder.append(" ");
        stringBuilder.append(arrstring[n2]);
        return stringBuilder.toString();
    }

    public void A(Map<File, MediaTrack> map) {
        this.m = new ArrayList((Collection)map.keySet());
        this.i = map;
    }

    @Override
    public String a(int n2) {
        String string = k.w((Context)this.h, -1);
        if (!string.equals((Object)"title_key") && !string.equals((Object)"title_key")) {
            return i.b(((File)this.m.get(n2)).lastModified() / 1000L);
        }
        return String.valueOf((char)((File)this.m.get(n2)).getName().charAt(0)).toUpperCase();
    }

    public int getItemCount() {
        return this.m.size();
    }

    public long getItemId(int n2) {
        return ((File)this.m.get(n2)).hashCode();
    }

    public int getItemViewType(int n2) {
        return (int)((File)this.m.get(n2)).isDirectory();
    }

    public Map<File, MediaTrack> s() {
        return this.i;
    }

    protected String t(File file) {
        if (file.isDirectory()) {
            return null;
        }
        return s.z(file.length());
    }

    protected String u(File file) {
        return n.a((Context)this.h, file.getName());
    }

    public List<File> v() {
        return this.m;
    }

    protected void w(File file, b b2) {
        Context context = this.h.getApplicationContext();
        int n2 = c.a.b.q.a.l((Context)this.h, (int)2130968779);
        if (file.isDirectory()) {
            b2.x.setColorFilter(n2, PorterDuff.Mode.SRC_IN);
            b2.x.setImageResource(2131230944);
            return;
        }
        MediaTrack mediaTrack = (MediaTrack)this.i.get((Object)file);
        if (mediaTrack != null) {
            ((com.bumptech.glide.j)((com.bumptech.glide.j)com.bumptech.glide.c.w((d)this.h).s((Object)new com.smp.musicspeed.playingqueue.i(context, mediaTrack)).A0((l)com.bumptech.glide.load.q.f.c.h()).R(null)).g(mediaTrack.getMediaType().defaultResource(context))).q0(b2.x);
            return;
        }
        com.bumptech.glide.j j2 = com.bumptech.glide.c.w((d)this.h).t("");
        I i2 = I.a;
        ((com.bumptech.glide.j)((com.bumptech.glide.j)j2.g(i2.defaultResource(context))).Q(i2.defaultResource(context))).q0(b2.x);
    }

    public void x(b b2, int n2) {
        TextView textView;
        File file = (File)this.m.get(n2);
        b2.itemView.setActivated(this.k.q(n2));
        if (b2.getAdapterPosition() == -1 + this.getItemCount()) {
            View view = b2.B;
            if (view != null) {
                view.setVisibility(4);
            }
        } else {
            View view = b2.B;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        if ((textView = b2.y) != null) {
            textView.setText((CharSequence)this.u(file));
        }
        if (b2.z != null) {
            if (b2.getItemViewType() == 0) {
                b2.z.setText((CharSequence)this.t(file));
            } else {
                b2.z.setVisibility(8);
            }
        }
        if (b2.x != null) {
            this.w(file, b2);
        }
    }

    public b y(ViewGroup viewGroup, int n2) {
        return new b(LayoutInflater.from((Context)this.h).inflate(this.j, viewGroup, false));
    }

    public class b
    extends RecyclerView.c0
    implements View.OnClickListener,
    View.OnLongClickListener {
        public ImageButton A;
        public View B;
        private long C;
        public ImageView x;
        public TextView y;
        public TextView z;

        public b(View view) {
            super(view);
            this.C = 0L;
            this.x = (ImageView)view.findViewById(2131296752);
            this.y = (TextView)view.findViewById(2131297235);
            this.z = (TextView)view.findViewById(2131297191);
            this.A = (ImageButton)view.findViewById(2131296936);
            this.B = view.findViewById(2131296647);
            if (this.A != null && s.this.l != null) {
                this.A.setOnClickListener((View.OnClickListener)new com.smp.musicspeed.folders.b(this));
            }
            this.itemView.setOnClickListener((View.OnClickListener)this);
            this.itemView.setOnLongClickListener((View.OnLongClickListener)this);
        }

        private boolean Z(int n2) {
            return n2 >= 0 && n2 < s.this.m.size();
        }

        private /* synthetic */ void a0(View view) {
            if (SystemClock.elapsedRealtime() - 1000L < this.C) {
                return;
            }
            this.C = SystemClock.elapsedRealtime();
            c.d().m((Object)new c0());
            int n2 = s.this.l.a(this.getAdapterPosition());
            if (this.Z(n2)) {
                File file = (File)s.this.m.get(n2);
                s.this.l.d(file, s.this.B(file), u.d(file), view);
            }
        }

        public /* synthetic */ void b0(View view) {
            this.a0(view);
        }

        public void onClick(View view) {
            int n2 = s.this.l.a(this.getAdapterPosition());
            if (this.Z(n2)) {
                if (c.a.a.b.b.d()) {
                    s.this.k.m(this.itemView, n2);
                    return;
                }
                if (s.this.l != null) {
                    s.this.l.b((File)s.this.m.get(n2));
                }
            }
        }

        public boolean onLongClick(View view) {
            int n2 = s.this.l.a(this.getAdapterPosition());
            if (this.Z(n2)) {
                s.this.k.h(this.itemView, n2);
            }
            return true;
        }
    }

}

