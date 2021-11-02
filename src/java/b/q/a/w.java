/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 *  android.os.Handler
 *  android.util.Log
 *  android.util.LongSparseArray
 *  androidx.media2.common.SubtitleData
 *  b.q.a.i
 *  b.q.a.i$a
 *  b.q.a.w$a
 *  b.q.a.w$b
 *  b.q.a.w$c
 *  b.q.a.w$d
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package b.q.a;

import android.media.MediaFormat;
import android.os.Handler;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.media2.common.SubtitleData;
import b.q.a.i;
import b.q.a.w;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis.
 */
abstract class w
implements i.a {
    private long a;
    private long b;
    private final LongSparseArray<d> c;
    private final LongSparseArray<d> d;
    private b e;
    final ArrayList<a> f;
    protected boolean g;
    public boolean h;
    protected Handler i;
    private MediaFormat j;
    private long k;
    protected i l;

    w(MediaFormat mediaFormat) {
        this.c = new LongSparseArray();
        this.d = new LongSparseArray();
        this.f = new ArrayList();
        this.h = false;
        this.i = new Handler();
        this.k = -1L;
        this.j = mediaFormat;
        this.e = new /* Unavailable Anonymous Inner Class!! */;
        this.a();
        this.b = -1L;
    }

    private void h(int n2) {
        d d2 = this.c.valueAt(n2);
        while (d2 != null) {
            a a2 = d2.a;
            if (a2 == null) {
                this.d.remove(d2.e);
                d d3 = d2.b;
                d2.c = null;
                d2.b = null;
                d2 = d3;
                continue;
            }
            this.e.a(a2);
            throw null;
        }
        this.c.removeAt(n2);
    }

    protected void a() {
        w w2 = this;
        synchronized (w2) {
            if (this.h) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Clearing ");
                stringBuilder.append(this.f.size());
                stringBuilder.append(" active cues");
                Log.v((String)"SubtitleTrack", (String)stringBuilder.toString());
            }
            this.f.clear();
            this.a = -1L;
            return;
        }
    }

    public final MediaFormat b() {
        return this.j;
    }

    public abstract c c();

    public int d() {
        if (this.c() == null) {
            return 3;
        }
        return 4;
    }

    public void e() {
        c c2;
        if (!this.g) {
            return;
        }
        i i2 = this.l;
        if (i2 != null) {
            i2.b((i.a)this);
        }
        if ((c2 = this.c()) != null) {
            c2.setVisible(false);
        }
        this.g = false;
    }

    public void f(SubtitleData subtitleData) {
        long l2 = 1L + subtitleData.g();
        this.g(subtitleData.e(), true, l2);
        this.i(l2, (subtitleData.g() + subtitleData.f()) / 1000L);
    }

    protected void finalize() throws Throwable {
        for (int i2 = -1 + this.c.size(); i2 >= 0; --i2) {
            this.h(i2);
        }
        super.finalize();
    }

    protected abstract void g(byte[] var1, boolean var2, long var3);

    public void i(long l2, long l3) {
        d d2;
        if (l2 != 0L && l2 != -1L && (d2 = this.d.get(l2)) != null) {
            d2.d = l3;
            d2.b(this.c);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void j(i i2) {
        w w2 = this;
        synchronized (w2) {
            i i3 = this.l;
            if (i3 == i2) {
                return;
            }
            if (i3 != null) {
                i3.b((i.a)this);
            }
            this.l = i2;
            if (i2 != null) {
                i2.a((i.a)this);
            }
            return;
        }
    }

    public void k() {
        i i2;
        if (this.g) {
            return;
        }
        this.g = true;
        c c2 = this.c();
        if (c2 != null) {
            c2.setVisible(true);
        }
        if ((i2 = this.l) != null) {
            i2.a((i.a)this);
        }
    }
}

