/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  android.os.Parcelable
 *  android.widget.Toast
 *  androidx.appcompat.app.e
 *  androidx.core.app.q
 *  androidx.fragment.app.FragmentManager
 *  com.smp.musicspeed.MainActivity
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.k0.f0$a
 *  com.smp.musicspeed.k0.i0.e
 *  com.smp.musicspeed.k0.j0.d
 *  com.smp.musicspeed.k0.j0.e
 *  com.smp.musicspeed.k0.k0.b
 *  com.smp.musicspeed.k0.m0.g$a
 *  com.smp.musicspeed.k0.o0.i
 *  com.smp.musicspeed.k0.o0.o
 *  com.smp.musicspeed.k0.o0.p
 *  com.smp.musicspeed.library.album.Album
 *  com.smp.musicspeed.library.playlists.Playlist
 *  com.smp.musicspeed.tag_editor.AlbumTagEditorActivity
 *  com.smp.musicspeed.tag_editor.TrackTagEditorActivity
 *  f.c0.c$a
 *  f.d0.f
 *  f.d0.g
 *  f.g0.k
 *  f.u.l
 *  f.z.c.q
 *  f.z.d.g
 *  f.z.d.k
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLConnection
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Objects
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.k0;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import com.smp.musicspeed.MainActivity;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.f0;
import com.smp.musicspeed.k0.j0.d;
import com.smp.musicspeed.k0.j0.e;
import com.smp.musicspeed.k0.k0.b;
import com.smp.musicspeed.k0.l;
import com.smp.musicspeed.k0.l0.h;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.m0.g;
import com.smp.musicspeed.k0.o0.i;
import com.smp.musicspeed.k0.o0.o;
import com.smp.musicspeed.k0.o0.p;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.library.album.Album;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.playingqueue.PlayingQueue;
import com.smp.musicspeed.playingqueue.c0;
import com.smp.musicspeed.tag_editor.AlbumTagEditorActivity;
import com.smp.musicspeed.tag_editor.TrackTagEditorActivity;
import f.c0.c;
import f.t;
import f.z.c.q;
import f.z.d.k;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.greenrobot.eventbus.c;

public final class f0 {
    public static final void a(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list, boolean bl, boolean bl2) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"tracksSelected");
        List<MediaTrack> list2 = f0.i(context, list);
        int n2 = PlayingQueue.getDefault().getLength();
        if (bl) {
            PlayingQueue.getDefault().addItemsNext(context, list2);
        } else {
            PlayingQueue.getDefault().addItems(context, list2);
        }
        if (bl2) {
            Resources resources = context.getResources();
            Object[] arrobject = new Object[]{list2.size()};
            Toast.makeText((Context)context, (CharSequence)resources.getString(2131821307, arrobject), (int)0).show();
        }
        if (true ^ list2.isEmpty() && n2 == 0) {
            c c2 = c.d();
            h h2 = new h(list2, 0, false, false, 4, null);
            c2.m((Object)h2);
        }
    }

    public static final void b() {
        PlayingQueue.getDefault().clear();
        c.d().p((Object)new c0());
    }

    public static final void c(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"tracksSelected");
        androidx.appcompat.app.e e2 = (androidx.appcompat.app.e)context;
        List<MediaTrack> list2 = f0.i(context, list);
        p.v.a(list2).M(e2.R(), "SavePlaylistDialogFragment");
    }

    public static final void d(Context context, com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"track");
        androidx.appcompat.app.e e3 = (androidx.appcompat.app.e)context;
        b.w.a((MediaTrack)e2).M(e3.R(), "DetailsDialogFragment");
    }

    public static final void e(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list, int n2) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"tracksSelected");
        androidx.appcompat.app.e e2 = (androidx.appcompat.app.e)context;
        List<MediaTrack> list2 = f0.i(context, list);
        if (!list2.isEmpty()) {
            if (z.d()) {
                e e3 = e.f;
                Object[] arrobject = list2.toArray((Object[])new MediaTrack[0]);
                Objects.requireNonNull((Object)arrobject, (String)"null cannot be cast to non-null type kotlin.Array<T>");
                e3.b((Activity)e2, (MediaTrack[])arrobject, n2);
                return;
            }
            d.v.a(list2, n2).M(e2.R(), "DeleteFromDeviceDialogFragment");
        }
    }

    public static /* synthetic */ void f(Context context, List list, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = -1;
        }
        f0.e(context, (List<? extends com.smp.musicspeed.k0.m0.e>)list, n2);
    }

    public static final void g(Context context, com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"playlist");
        if (e2 instanceof Playlist) {
            MainActivity mainActivity = (MainActivity)context;
            i.v.a((Playlist)e2).M(mainActivity.R(), "deletePlaylistDialog");
        }
    }

    public static final void h(Context context, com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"mediaStoreItem");
        com.smp.musicspeed.library.playlists.h.b(context, (Playlist)e2);
    }

    private static final List<MediaTrack> i(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list) {
        ArrayList arrayList = new ArrayList();
        for (com.smp.musicspeed.k0.m0.e e2 : list) {
            Object object;
            if (e2 instanceof Album) {
                object = f.g(context, ((Album)e2).l());
            } else if (e2 instanceof com.smp.musicspeed.k0.i0.e) {
                object = f.w(context, ((com.smp.musicspeed.k0.i0.e)e2).a());
            } else if (e2 instanceof Playlist) {
                long l2 = ((Playlist)e2).getPlaylistId();
                boolean bl = e2.getMediaType() == I.d;
                object = f.y(context, l2, bl);
            } else {
                object = e2 instanceof MediaTrack ? f.u.l.b((Object)e2) : f.u.l.d();
            }
            f.u.l.m((Collection)arrayList, object);
        }
        return arrayList;
    }

    public static final void j(Context context, String string2, q<? super Context, ? super Uri, ? super String, t> q2) {
        k.g((Object)context, (String)"context");
        k.g((Object)string2, (String)"path");
        k.g(q2, (String)"command");
        l l2 = new l(q2, context, string2);
        MediaScannerConnection.scanFile((Context)context, (String[])new String[]{string2}, null, (MediaScannerConnection.OnScanCompletedListener)l2);
    }

    private static final void k(q q2, Context context, String string2, String string3, Uri uri) {
        k.g((Object)q2, (String)"$command");
        k.g((Object)context, (String)"$context");
        k.g((Object)string2, (String)"$path");
        if (uri != null) {
            q2.b((Object)context, (Object)uri, (Object)string2);
            return;
        }
        Uri uri2 = Uri.fromFile((File)new File(string2));
        k.f((Object)uri2, (String)"fileUri");
        q2.b((Object)context, (Object)uri2, (Object)string2);
    }

    public static final void l(Context context, com.smp.musicspeed.k0.m0.e e2) {
        List<Album> list;
        MediaTrack mediaTrack;
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"item");
        boolean bl = e2 instanceof MediaTrack;
        if (bl) {
            List<Album> list2 = f.f(context, ((MediaTrack)e2).getAlbumId());
            if (true ^ list2.isEmpty()) {
                c.d().m((Object)new com.smp.musicspeed.k0.l0.a((Album)list2.get(0)));
                return;
            }
        } else if (bl && (mediaTrack = (MediaTrack)e2).getMediaType() == I.a && true ^ (list = f.f(context, mediaTrack.getAlbumId())).isEmpty()) {
            c.d().m((Object)new com.smp.musicspeed.k0.l0.a((Album)list.get(0)));
        }
    }

    public static final void m(com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)e2, (String)"item");
        if (e2 instanceof Album) {
            c c2 = c.d();
            Album album = (Album)e2;
            com.smp.musicspeed.k0.i0.e e3 = new com.smp.musicspeed.k0.i0.e(album.o(), album.p(), 0L, 0L, 12, null);
            c2.m((Object)new com.smp.musicspeed.k0.l0.b(e3));
            return;
        }
        if (e2 instanceof MediaTrack) {
            c c3 = c.d();
            MediaTrack mediaTrack = (MediaTrack)e2;
            com.smp.musicspeed.k0.i0.e e4 = new com.smp.musicspeed.k0.i0.e(mediaTrack.getArtistId(), mediaTrack.getArtistName(), 0L, 0L, 12, null);
            c3.m((Object)new com.smp.musicspeed.k0.l0.b(e4));
        }
    }

    public static final void n(Context context, int n2, List<? extends com.smp.musicspeed.k0.m0.e> list, boolean bl) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"itemSelected");
        switch (n2) {
            default: {
                return;
            }
            case 2131296376: {
                f0.y(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296368: {
                f0.x(context, list);
                return;
            }
            case 2131296367: {
                f0.u(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296362: {
                f0.c(context, list);
                return;
            }
            case 2131296359: {
                f0.t(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296358: {
                f0.s(context, list);
                return;
            }
            case 2131296353: {
                f0.a(context, list, true, bl);
                return;
            }
            case 2131296351: {
                f0.r(context, list);
                return;
            }
            case 2131296340: {
                f0.m((com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296339: {
                f0.l(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296338: {
                f0.h(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296335: {
                f0.d(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296334: {
                f0.g(context, (com.smp.musicspeed.k0.m0.e)list.get(0));
                return;
            }
            case 2131296333: {
                f0.f(context, list, 0, 4, null);
                return;
            }
            case 2131296322: {
                f0.b();
                return;
            }
            case 2131296310: {
                f0.c(context, list);
                return;
            }
            case 2131296309: 
        }
        f0.a(context, list, false, bl);
    }

    public static /* synthetic */ void o(Context context, int n2, List list, boolean bl, int n3, Object object) {
        if ((n3 & 8) != 0) {
            bl = true;
        }
        f0.n(context, n2, (List<? extends com.smp.musicspeed.k0.m0.e>)list, bl);
    }

    public static /* synthetic */ void p(q q2, Context context, String string2, String string3, Uri uri) {
        f0.k(q2, context, string2, string3, uri);
    }

    public static final boolean q(MediaTrack mediaTrack) {
        k.g((Object)mediaTrack, (String)"track");
        return mediaTrack.getMediaType() == I.i;
    }

    public static final void r(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"tracksSelected");
        List<MediaTrack> list2 = f0.i(context, list);
        if (list2.isEmpty()) {
            Toast.makeText((Context)context, (int)2131821327, (int)0).show();
            return;
        }
        c c2 = c.d();
        h h2 = new h(list2, 0, false, false, 12, null);
        c2.m((Object)h2);
    }

    public static final void s(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"items");
        List<MediaTrack> list2 = f0.i(context, list);
        if (true ^ list2.isEmpty()) {
            if (((g)g.a.a(context)).f()) {
                f.G(context, list2);
                return;
            }
            f.H(context, list2);
        }
    }

    public static final void t(Context context, com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"mediaStoreItem");
        Playlist playlist = (Playlist)e2;
        MainActivity mainActivity = (MainActivity)context;
        o.w.a(playlist.getPlaylistId()).M(mainActivity.R(), "renamePlaylistDialog");
    }

    public static final void u(Context context, com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"mediaStoreItem");
        f0.j(context, ((MediaTrack)e2).getLocation(), (q<? super Context, ? super Uri, ? super String, t>)a.n);
    }

    public static final void v(Context context, Uri uri, String string2) {
        k.g((Object)context, (String)"context");
        k.g((Object)uri, (String)"uri");
        k.g((Object)string2, (String)"path");
        context.startActivity(f0.w(context, uri, string2));
    }

    public static final Intent w(Context context, Uri uri, String string2) {
        k.g((Object)context, (String)"context");
        k.g((Object)uri, (String)"uri");
        k.g((Object)string2, (String)"path");
        String string3 = uri.getScheme();
        String string4 = "";
        if (string3 != null) {
            String string5 = string3.toLowerCase();
            k.f((Object)string5, (String)"(this as java.lang.String).toLowerCase()");
            if (string5 != null) {
                string4 = string5;
            }
        }
        String string6 = f.g0.k.r((CharSequence)string4, (CharSequence)"content", (boolean)false, (int)2, null) ? context.getContentResolver().getType(uri) : URLConnection.guessContentTypeFromName((String)new File(string2).getName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getResources().getString(2131821301));
        stringBuilder.append(' ');
        stringBuilder.append(com.smp.musicspeed.h0.c.a());
        String string7 = stringBuilder.toString();
        Intent intent = androidx.core.app.q.d((Activity)((Activity)context)).f(uri).i(string6).g(new File(string2).getName()).h((CharSequence)string7).c();
        k.f((Object)intent, (String)"from(context as Activity)\n            .setStream(uri)\n            .setType(mime)\n            .setSubject(File(path).name)\n            .setText(text)\n            .createChooserIntent()");
        return intent;
    }

    public static final void x(Context context, List<? extends com.smp.musicspeed.k0.m0.e> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"list");
        if (list.isEmpty()) {
            Toast.makeText((Context)context, (int)2131821327, (int)0).show();
            return;
        }
        List<MediaTrack> list2 = f0.i(context, list);
        int n2 = f.d0.g.h((f.d0.f)f.u.l.e(list), (f.c0.c)f.c0.c.g);
        c c2 = c.d();
        h h2 = new h(list2, n2, true, false, 8, null);
        c2.m((Object)h2);
    }

    public static final void y(Context context, com.smp.musicspeed.k0.m0.e e2) {
        k.g((Object)context, (String)"context");
        k.g((Object)e2, (String)"mediaStoreItem");
        if (e2 instanceof MediaTrack) {
            MediaTrack mediaTrack = (MediaTrack)e2;
            boolean bl = new File(mediaTrack.getLocation()).getParent() == null ? false : f0.z(context, mediaTrack);
            if (bl) {
                return;
            }
            Intent intent = new Intent(context, TrackTagEditorActivity.class);
            intent.putExtra("mediaTrack", (Parcelable)e2);
            context.startActivity(intent);
            return;
        }
        if (e2 instanceof Album) {
            boolean bl;
            block7 : {
                List<MediaTrack> list = f.g(context, ((Album)e2).l());
                if (list instanceof Collection && list.isEmpty()) {
                    bl = false;
                } else {
                    Iterator iterator = list.iterator();
                    do {
                        boolean bl2 = iterator.hasNext();
                        bl = false;
                        if (!bl2) break block7;
                    } while (!f0.z(context, (MediaTrack)iterator.next()));
                    bl = true;
                }
            }
            if (bl) {
                return;
            }
            Intent intent = new Intent(context, AlbumTagEditorActivity.class);
            intent.putExtra("album", (Parcelable)e2);
            context.startActivity(intent);
        }
    }

    /*
     * Exception decompiling
     */
    public static final boolean z(Context var0, MediaTrack var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
}

