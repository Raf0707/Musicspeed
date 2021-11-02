/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.MediaStore
 *  android.provider.MediaStore$Audio
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Video
 *  android.provider.MediaStore$Video$Media
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.k0.m0.a
 *  com.smp.musicspeed.k0.m0.b
 *  com.smp.musicspeed.k0.m0.c
 *  com.smp.musicspeed.k0.m0.d
 *  com.smp.musicspeed.k0.m0.g$a
 *  com.smp.musicspeed.k0.m0.g$f
 *  com.smp.musicspeed.k0.m0.g$g
 *  com.smp.musicspeed.k0.m0.g$h
 *  com.smp.musicspeed.k0.m0.g$i
 *  com.smp.musicspeed.k0.m0.g$j
 *  e.b.b
 *  e.b.m.a
 *  f.b0.d
 *  f.e0.i
 *  f.z.c.l
 *  f.z.d.g
 *  f.z.d.k
 *  f.z.d.o
 *  f.z.d.p
 *  f.z.d.z
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0.m0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import f.z.c.l;
import f.z.d.k;
import f.z.d.o;
import f.z.d.p;
import f.z.d.z;
import java.util.List;

/*
 * Exception performing whole class analysis.
 */
public final class g {
    public static final a a;
    static final /* synthetic */ f.e0.i<Object>[] b;
    private final Context c;
    private final int d;
    private final e.b.m.a<List<com.smp.musicspeed.k0.m0.e>>[] e;
    private final e.b.m.a<Boolean>[] f;
    private Boolean[] g;
    private final f.b0.d h;
    private final f.b0.d i;
    private boolean j;
    private final f.b0.d k;
    private final f.b0.d l;
    private final Handler m;
    private final d n;
    private volatile boolean o;
    private final e p;

    static {
        f.e0.i[] arri = new f.e0.i[]{z.e((o)new p((f.e0.c)z.b(g.class), "currentAlbum", "getCurrentAlbum()J")), z.e((o)new p((f.e0.c)z.b(g.class), "currentPlaylist", "getCurrentPlaylist()J")), z.e((o)new p((f.e0.c)z.b(g.class), "currentArtist", "getCurrentArtist()J")), z.e((o)new p((f.e0.c)z.b(g.class), "currentSearchQuery", "getCurrentSearchQuery()Ljava/lang/String;"))};
        b = arri;
        a = new /* Unavailable Anonymous Inner Class!! */;
    }

    private g(Context context) {
        int n2;
        this.c = context;
        this.d = n2 = b.values().length;
        e.b.m.a[] arra = new e.b.m.a[n2];
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            arra[i2] = e.b.m.a.p();
        }
        this.e = arra;
        int n4 = this.d;
        e.b.m.a[] arra2 = new e.b.m.a[n4];
        for (int i3 = 0; i3 < n4; ++i3) {
            arra2[i3] = e.b.m.a.q((Object)Boolean.TRUE);
        }
        this.f = arra2;
        int n5 = this.d;
        Boolean[] arrboolean = new Boolean[n5];
        while (n3 < n5) {
            arrboolean[n3] = Boolean.FALSE;
            ++n3;
        }
        this.g = arrboolean;
        Long l2 = -1L;
        this.h = new g((Object)l2, (Object)l2, this);
        Long l3 = -1L;
        this.i = new h((Object)l3, (Object)l3, this);
        this.j = true;
        Long l4 = -1L;
        this.k = new i((Object)l4, (Object)l4, this);
        this.l = new j((Object)"", (Object)"", this);
        this.m = new Handler(this.c.getMainLooper());
        this.n = new d();
        this.p = new ContentObserver(){

            public void onChange(boolean bl) {
                if (this.l() - this.m().a() > 2000L) {
                    this.m().run();
                    return;
                }
                this.h().removeCallbacks((Runnable)this.m());
                this.h().postDelayed((Runnable)this.m(), 2000L);
            }
        };
        this.w();
        this.t();
    }

    public /* synthetic */ g(Context context, f.z.d.g g2) {
        this(context);
    }

    private static final boolean F(g g2, int n2, List list) {
        k.g((Object)g2, (String)"this$0");
        k.g((Object)list, (String)"it");
        return g2.j()[n2] == false && k.c((Object)g2.i()[n2].r(), (Object)Boolean.TRUE);
    }

    private static final void G(g g2, int n2, List list) {
        k.g((Object)g2, (String)"this$0");
        if (g2.j()[n2].booleanValue()) {
            g2.i()[n2].e((Object)Boolean.FALSE);
        }
    }

    private final void H() {
        PlayingQueue.getDefault().updateMetadataFromMediaStoreAsync(this.c);
    }

    public static /* synthetic */ boolean n(g g2, int n2, Boolean bl) {
        return g.u(g2, n2, bl);
    }

    public static /* synthetic */ boolean o(g g2, int n2, List list) {
        return g.F(g2, n2, list);
    }

    public static /* synthetic */ List p(l l2, Boolean bl) {
        return g.v(l2, bl);
    }

    public static /* synthetic */ void q(g g2, int n2, List list) {
        g.G(g2, n2, list);
    }

    private final void t() {
        f f2 = new f(this);
        for (b b2 : b.values()) {
            int n2 = b2.ordinal();
            this.f[n2].h((e.b.i.g)new com.smp.musicspeed.k0.m0.a(this, n2)).n(e.b.l.a.a()).j(e.b.l.a.a()).i((e.b.i.e)new com.smp.musicspeed.k0.m0.c((l)f2.g((Object)b2))).a(this.e[n2]);
        }
    }

    private static final boolean u(g g2, int n2, Boolean bl) {
        k.g((Object)g2, (String)"this$0");
        k.g((Object)bl, (String)"changed");
        return bl != false && g2.j()[n2] != false;
    }

    private static final List v(l l2, Boolean bl) {
        k.g((Object)l2, (String)"$tmp0");
        return (List)l2.g((Object)bl);
    }

    private final void w() {
        this.c.getContentResolver().registerContentObserver(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, true, (ContentObserver)this.p);
        this.c.getContentResolver().registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, (ContentObserver)this.p);
    }

    public final void A(long l2) {
        this.i.b((Object)this, b[1], (Object)l2);
    }

    public final void B(boolean bl) {
        this.j = bl;
    }

    public final void C(String string2) {
        k.g((Object)string2, (String)"<set-?>");
        this.l.b((Object)this, b[3], (Object)string2);
    }

    public final void D(boolean bl) {
        this.o = bl;
    }

    public final <MT extends com.smp.musicspeed.k0.m0.e> List<MT> E(b b2, e.b.d<List<MT>> d2) {
        k.g((Object)((Object)b2), (String)"id");
        k.g(d2, (String)"observer");
        int n2 = b2.ordinal();
        e.b.m.a<List<com.smp.musicspeed.k0.m0.e>> a2 = this.e[n2];
        a2.l((e.b.i.g)new com.smp.musicspeed.k0.m0.b(this, n2)).g((e.b.i.d)new com.smp.musicspeed.k0.m0.d(this, n2)).j(e.b.f.b.a.a()).a(d2);
        return (List)a2.r();
    }

    public final Context b() {
        return this.c;
    }

    public final long c() {
        return ((Number)this.h.a((Object)this, b[0])).longValue();
    }

    public final long d() {
        return ((Number)this.k.a((Object)this, b[2])).longValue();
    }

    public final long e() {
        return ((Number)this.i.a((Object)this, b[1])).longValue();
    }

    public final boolean f() {
        return this.j;
    }

    public final String g() {
        return (String)this.l.a((Object)this, b[3]);
    }

    public final Handler h() {
        return this.m;
    }

    public final e.b.m.a<Boolean>[] i() {
        return this.f;
    }

    public final Boolean[] j() {
        return this.g;
    }

    public final boolean k() {
        return this.o;
    }

    public final long l() {
        return System.currentTimeMillis();
    }

    public final d m() {
        return this.n;
    }

    public final void r(b b2) {
        k.g((Object)((Object)b2), (String)"id");
        int n2 = b2.ordinal();
        this.g[n2] = Boolean.FALSE;
    }

    public final List<MediaTrack> s() {
        Object object = this.e[b.f.ordinal()].r();
        if (object instanceof List) {
            return (List)object;
        }
        return null;
    }

    public final void x(b b2) {
        Boolean bl;
        k.g((Object)((Object)b2), (String)"id");
        int n2 = b2.ordinal();
        Boolean[] arrboolean = this.g;
        arrboolean[n2] = bl = Boolean.TRUE;
        if (k.c((Object)this.f[n2].r(), (Object)bl)) {
            this.f[n2].e((Object)bl);
        }
    }

    public final void y(long l2) {
        this.h.b((Object)this, b[0], (Object)l2);
    }

    public final void z(long l2) {
        this.k.b((Object)this, b[2], (Object)l2);
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b f = new b();
        public static final /* enum */ b g = new b();
        public static final /* enum */ b h = new b();
        public static final /* enum */ b i = new b();
        public static final /* enum */ b j = new b();
        public static final /* enum */ b k = new b();
        public static final /* enum */ b l = new b();
        public static final /* enum */ b m = new b();
        public static final /* enum */ b n = new b();
        public static final /* enum */ b o = new b();
        public static final /* enum */ b p = new b();
        public static final /* enum */ b q = new b();
        public static final /* enum */ b r = new b();
        private static final /* synthetic */ b[] s;

        static {
            s = arrb = new b[]{b.f, b.g, b.h, b.i, b.j, b.k, b.l, b.m, b.n, b.o, b.p, b.q, b.r};
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])s.clone();
        }
    }

    public static final class c {
    }

    public final class d
    implements Runnable {
        private long f;

        public d() {
            k.g((Object)g.this, (String)"this$0");
            this.f = g.this.l();
        }

        public final long a() {
            return this.f;
        }

        public void run() {
            g g2 = g.this;
            g2.D(false);
            e.b.m.a<Boolean>[] arra = g.this.i();
            int n2 = arra.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                arra[i2].e((Object)Boolean.TRUE);
            }
            org.greenrobot.eventbus.c.d().m((Object)new c());
            g.this.H();
            this.f = g.this.l();
        }
    }

}

