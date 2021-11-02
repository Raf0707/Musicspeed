/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.media.MediaFormat
 *  android.os.AsyncTask
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Surface
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.media2.common.MediaItem
 *  androidx.media2.common.MediaMetadata
 *  androidx.media2.common.SessionPlayer
 *  androidx.media2.common.SessionPlayer$TrackInfo
 *  androidx.media2.common.SubtitleData
 *  androidx.media2.common.VideoSize
 *  androidx.media2.common.a
 *  androidx.media2.session.MediaController
 *  b.i.q.w
 *  b.q.a.b0$c
 *  b.q.a.b0$e
 *  b.q.a.c0
 *  b.q.a.c0$a
 *  b.q.a.i
 *  b.q.a.j
 *  b.q.a.k
 *  b.q.a.l
 *  b.q.a.l$b
 *  b.q.a.n
 *  b.q.a.p
 *  b.q.a.s
 *  b.q.a.t$a
 *  b.q.a.v
 *  b.q.a.v$c
 *  b.q.a.v$d
 *  b.q.a.v$f
 *  b.s.a.b
 *  b.s.a.b$d
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 */
package b.q.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import b.q.a.a0;
import b.q.a.b0;
import b.q.a.c0;
import b.q.a.h;
import b.q.a.i;
import b.q.a.j;
import b.q.a.k;
import b.q.a.l;
import b.q.a.n;
import b.q.a.p;
import b.q.a.s;
import b.q.a.t;
import b.q.a.u;
import b.q.a.v;
import b.q.a.w;
import b.q.a.z;
import b.s.a.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * Exception performing whole class analysis.
 */
public class b0
extends t {
    static final boolean g;
    e h;
    c0 i;
    c0 j;
    a0 k;
    z l;
    l m;
    h n;
    k o;
    t.a p;
    int q;
    int r;
    Map<SessionPlayer.TrackInfo, w> s;
    v t;
    SessionPlayer.TrackInfo u;
    u v;
    private final c0.a w;

    static {
        g = Log.isLoggable((String)"VideoView", (int)3);
    }

    public b0(Context context) {
        this(context, null);
    }

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b0(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.w = new c0.a(this){
            final /* synthetic */ b0 a;
            {
                this.a = b02;
            }

            public void a(View view, int n2, int n3) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onSurfaceCreated(), width/height: ");
                    stringBuilder.append(n2);
                    stringBuilder.append("/");
                    stringBuilder.append(n3);
                    stringBuilder.append(", ");
                    stringBuilder.append(view.toString());
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                b0 b02 = this.a;
                if (view == b02.j && b02.a()) {
                    b0 b03 = this.a;
                    b03.j.b(b03.m);
                }
            }

            public void b(View view) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onSurfaceDestroyed(). ");
                    stringBuilder.append(view.toString());
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
            }

            public void c(View view, int n2, int n3) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onSurfaceChanged(). width/height: ");
                    stringBuilder.append(n2);
                    stringBuilder.append("/");
                    stringBuilder.append(n3);
                    stringBuilder.append(", ");
                    stringBuilder.append(view.toString());
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
            }

            public void d(c0 c02) {
                c0 c03;
                if (c02 != this.a.j) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onSurfaceTakeOverDone(). view is not targetView. ignore.: ");
                    stringBuilder.append((Object)c02);
                    Log.w((String)"VideoView", (String)stringBuilder.toString());
                    return;
                }
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onSurfaceTakeOverDone(). Now current view is: ");
                    stringBuilder.append((Object)c02);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (c02 != (c03 = this.a.i)) {
                    ((View)c03).setVisibility(8);
                    b0 b02 = this.a;
                    b02.i = c02;
                    e e2 = b02.h;
                    if (e2 != null) {
                        e2.a((View)b02, c02.a());
                    }
                }
            }
        };
        this.f(context, attributeSet);
    }

    private Drawable c(MediaMetadata mediaMetadata, Drawable drawable) {
        Bitmap bitmap = mediaMetadata != null && mediaMetadata.h("android.media.metadata.ALBUM_ART") ? mediaMetadata.i("android.media.metadata.ALBUM_ART") : null;
        if (bitmap != null) {
            b.s.a.b.b(bitmap).a(new b.d(this){
                final /* synthetic */ b0 a;
                {
                    this.a = b02;
                }

                public void a(b.s.a.b b2) {
                    int n2 = b2.f(0);
                    this.a.o.setBackgroundColor(n2);
                }
            });
            return new BitmapDrawable(this.getResources(), bitmap);
        }
        this.o.setBackgroundColor(b.i.h.a.c(this.getContext(), n.a));
        return drawable;
    }

    private String d(MediaMetadata mediaMetadata, String string, String string2) {
        String string3 = mediaMetadata == null ? string2 : mediaMetadata.k(string);
        if (string3 == null) {
            return string2;
        }
        return string3;
    }

    private void f(Context context, AttributeSet attributeSet) {
        v v2;
        t.a a2;
        u u2;
        k k2;
        int n2;
        this.u = null;
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        this.k = new a0(context);
        this.l = new z(context);
        this.k.d(this.w);
        this.l.d(this.w);
        this.addView((View)this.k);
        this.addView((View)this.l);
        this.p = a2 = new /* Unavailable Anonymous Inner Class!! */;
        a2.a = true;
        this.v = u2 = new u(context);
        u2.setBackgroundColor(0);
        this.addView((View)this.v, (ViewGroup.LayoutParams)this.p);
        this.t = v2 = new v(context, null, new v.d(this){
            final /* synthetic */ b0 a;
            {
                this.a = b02;
            }

            public void a(w w2) {
                SessionPlayer.TrackInfo trackInfo;
                block3 : {
                    java.util.Map$Entry entry;
                    if (w2 == null) {
                        b0 b02 = this.a;
                        b02.u = null;
                        b02.v.setVisibility(8);
                        return;
                    }
                    java.util.Iterator iterator = this.a.s.entrySet().iterator();
                    do {
                        boolean bl = iterator.hasNext();
                        trackInfo = null;
                        if (!bl) break block3;
                    } while ((entry = (java.util.Map$Entry)iterator.next()).getValue() != w2);
                    trackInfo = (SessionPlayer.TrackInfo)entry.getKey();
                }
                if (trackInfo != null) {
                    b0 b03 = this.a;
                    b03.u = trackInfo;
                    b03.v.setVisibility(0);
                }
            }
        });
        v2.j((v.f)new b.q.a.d(context));
        this.t.j((v.f)new b.q.a.f(context));
        this.t.m((v.c)this.v);
        this.o = k2 = new k(context);
        k2.setVisibility(8);
        this.addView((View)this.o, (ViewGroup.LayoutParams)this.p);
        boolean bl = attributeSet == null || attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "enableControlView", true);
        if (bl) {
            h h2;
            this.n = h2 = new h(context);
            h2.setAttachedToVideoView(true);
            this.addView((View)this.n, (ViewGroup.LayoutParams)this.p);
        }
        if ((n2 = attributeSet == null ? 0 : attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "viewType", 0)) == 0) {
            if (g) {
                Log.d((String)"VideoView", (String)"viewType attribute is surfaceView.");
            }
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.i = this.l;
        } else if (n2 == 1) {
            if (g) {
                Log.d((String)"VideoView", (String)"viewType attribute is textureView.");
            }
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.i = this.k;
        }
        this.j = this.i;
    }

    void b(boolean bl) {
        j.super.b(bl);
        l l2 = this.m;
        if (l2 == null) {
            return;
        }
        if (bl) {
            this.j.b(l2);
            return;
        }
        if (l2 != null && !l2.y()) {
            this.i();
            return;
        }
        Log.w((String)"VideoView", (String)"Surface is being destroyed, but player will not be informed as the associated media controller is disconnected.");
    }

    boolean e() {
        if (this.q > 0) {
            return true;
        }
        VideoSize videoSize = this.m.x();
        if (videoSize.e() > 0 && videoSize.f() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("video track count is zero, but it renders video. size: ");
            stringBuilder.append(videoSize.f());
            stringBuilder.append("/");
            stringBuilder.append(videoSize.e());
            Log.w((String)"VideoView", (String)stringBuilder.toString());
            return true;
        }
        return false;
    }

    boolean g() {
        return !this.e() && this.r > 0;
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.media2.widget.VideoView";
    }

    public h getMediaControlView() {
        return this.n;
    }

    public int getViewType() {
        return this.i.a();
    }

    boolean h() {
        l l2 = this.m;
        return l2 != null && l2.s() != 3 && this.m.s() != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void i() {
        void var1_6;
        int n2 = ((androidx.media2.common.a)this.m.G(null).get(100L, TimeUnit.MILLISECONDS)).e();
        if (n2 == 0) return;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("calling setSurface(null) was not successful. ResultCode: ");
            stringBuilder.append(n2);
            Log.e((String)"VideoView", (String)stringBuilder.toString());
            return;
        }
        catch (TimeoutException timeoutException) {
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            // empty catch block
        }
        Log.e((String)"VideoView", (String)"calling setSurface(null) was not successful.", (Throwable)var1_6);
    }

    void j() {
        c.e.b.a.a.a a2 = this.m.G(null);
        a2.a((Runnable)new c(this, a2), b.i.h.a.f(this.getContext()));
    }

    void k(MediaItem mediaItem) {
        boolean bl = mediaItem != null && this.g();
        if (bl) {
            this.o.setVisibility(0);
            MediaMetadata mediaMetadata = mediaItem.j();
            Resources resources = this.getResources();
            Drawable drawable = this.c(mediaMetadata, b.i.h.a.e(this.getContext(), p.b));
            String string = this.d(mediaMetadata, "android.media.metadata.TITLE", resources.getString(s.q));
            String string2 = this.d(mediaMetadata, "android.media.metadata.ARTIST", resources.getString(s.p));
            this.o.c(drawable);
            this.o.e(string);
            this.o.d(string2);
            return;
        }
        this.o.setVisibility(8);
        this.o.c(null);
        this.o.e(null);
        this.o.d(null);
    }

    void l(l l2, List<SessionPlayer.TrackInfo> list) {
        this.s = new LinkedHashMap();
        this.q = 0;
        this.r = 0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            w w2;
            SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo)list.get(i2);
            int n2 = ((SessionPlayer.TrackInfo)list.get(i2)).k();
            if (n2 == 1) {
                this.q = 1 + this.q;
                continue;
            }
            if (n2 == 2) {
                this.r = 1 + this.r;
                continue;
            }
            if (n2 != 4 || (w2 = this.t.a(trackInfo.h())) == null) continue;
            this.s.put((Object)trackInfo, (Object)w2);
        }
        this.u = l2.u(4);
    }

    protected void onAttachedToWindow() {
        ViewGroup.super.onAttachedToWindow();
        l l2 = this.m;
        if (l2 != null) {
            l2.a();
        }
    }

    protected void onDetachedFromWindow() {
        ViewGroup.super.onDetachedFromWindow();
        l l2 = this.m;
        if (l2 != null) {
            l2.j();
        }
    }

    public void setMediaController(MediaController mediaController) {
        Objects.requireNonNull((Object)mediaController, (String)"controller must not be null");
        l l2 = this.m;
        if (l2 != null) {
            l2.j();
        }
        this.m = new l(mediaController, b.i.h.a.f(this.getContext()), new l.b(){

            /*
             * Exception decompiling
             */
            private boolean m(l var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl39 : ICONST_1 : trying to set 0 previously set to 1
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

            void b(l l2, MediaItem mediaItem) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onCurrentMediaItemChanged(): MediaItem: ");
                    stringBuilder.append((Object)mediaItem);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    return;
                }
                b0.this.k(mediaItem);
            }

            void e(l l2, int n2) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onPlayerStateChanged(): state: ");
                    stringBuilder.append(n2);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    // empty if block
                }
            }

            void h(l l2, MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onSubtitleData(): TrackInfo: ");
                    stringBuilder.append((Object)trackInfo);
                    stringBuilder.append(", getCurrentPosition: ");
                    stringBuilder.append(l2.o());
                    stringBuilder.append(", getStartTimeUs(): ");
                    stringBuilder.append(subtitleData.g());
                    stringBuilder.append(", diff: ");
                    stringBuilder.append(subtitleData.g() / 1000L - l2.o());
                    stringBuilder.append("ms, getDurationUs(): ");
                    stringBuilder.append(subtitleData.f());
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    return;
                }
                if (!trackInfo.equals((Object)b0.this.u)) {
                    return;
                }
                w w2 = (w)b0.this.s.get((Object)trackInfo);
                if (w2 != null) {
                    w2.f(subtitleData);
                }
            }

            void i(l l2, SessionPlayer.TrackInfo trackInfo) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onTrackDeselected(): deselected track: ");
                    stringBuilder.append((Object)trackInfo);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    return;
                }
                if ((w)b0.this.s.get((Object)trackInfo) != null) {
                    b0.this.t.l(null);
                }
            }

            void j(l l2, SessionPlayer.TrackInfo trackInfo) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onTrackSelected(): selected track: ");
                    stringBuilder.append((Object)trackInfo);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    return;
                }
                w w2 = (w)b0.this.s.get((Object)trackInfo);
                if (w2 != null) {
                    b0.this.t.l(w2);
                }
            }

            void k(l l2, List<SessionPlayer.TrackInfo> list) {
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onTrackInfoChanged(): tracks: ");
                    stringBuilder.append(list);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    return;
                }
                b0.this.l(l2, list);
                b0.this.k(l2.n());
            }

            void l(l l2, VideoSize videoSize) {
                List list;
                if (b0.g) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onVideoSizeChanged(): size: ");
                    stringBuilder.append((Object)videoSize);
                    Log.d((String)"VideoView", (String)stringBuilder.toString());
                }
                if (this.m(l2)) {
                    return;
                }
                if (b0.this.q == 0 && videoSize.e() > 0 && videoSize.f() > 0 && b0.this.h() && (list = l2.w()) != null) {
                    b0.this.l(l2, (List<SessionPlayer.TrackInfo>)list);
                }
                b0.this.k.forceLayout();
                b0.this.l.forceLayout();
                b0.this.requestLayout();
            }
        });
        if (b.i.q.w.V((View)this)) {
            this.m.a();
        }
        if (this.a()) {
            this.j.b(this.m);
        } else {
            this.j();
        }
        h h2 = this.n;
        if (h2 != null) {
            h2.setMediaControllerInternal(mediaController);
        }
    }

    public void setOnViewTypeChangedListener(e e2) {
        this.h = e2;
    }

    public void setPlayer(SessionPlayer sessionPlayer) {
        Objects.requireNonNull((Object)sessionPlayer, (String)"player must not be null");
        l l2 = this.m;
        if (l2 != null) {
            l2.j();
        }
        this.m = new l(sessionPlayer, b.i.h.a.f(this.getContext()), new /* invalid duplicate definition of identical inner class */);
        if (b.i.q.w.V((View)this)) {
            this.m.a();
        }
        if (this.a()) {
            this.j.b(this.m);
        } else {
            this.j();
        }
        h h2 = this.n;
        if (h2 != null) {
            h2.setPlayerInternal(sessionPlayer);
        }
    }

    public void setViewType(int n2) {
        block7 : {
            c0 c02;
            block6 : {
                block5 : {
                    if (n2 == this.j.a()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("setViewType with the same type (");
                        stringBuilder.append(n2);
                        stringBuilder.append(") is ignored.");
                        Log.d((String)"VideoView", (String)stringBuilder.toString());
                        return;
                    }
                    if (n2 != 1) break block5;
                    Log.d((String)"VideoView", (String)"switching to TextureView");
                    c02 = this.k;
                    break block6;
                }
                if (n2 != 0) break block7;
                Log.d((String)"VideoView", (String)"switching to SurfaceView");
                c02 = this.l;
            }
            this.j = c02;
            if (this.a()) {
                c02.b(this.m);
            }
            c02.setVisibility(0);
            this.requestLayout();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown view type: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

}

