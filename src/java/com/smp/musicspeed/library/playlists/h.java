/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  com.smp.musicspeed.k0.o0.l
 *  com.smp.musicspeed.library.playlists.Playlist
 *  com.smp.musicspeed.library.playlists.h$a
 *  com.smp.musicspeed.utils.AppPrefs
 *  f.g0.k
 *  f.u.l
 *  f.w.d
 *  f.w.g
 *  f.y.g
 *  f.z.c.p
 *  f.z.d.k
 *  java.io.File
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  kotlinx.coroutines.a1
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.k0
 *  kotlinx.coroutines.m1
 *  org.greenrobot.eventbus.c
 */
package com.smp.musicspeed.library.playlists;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.d;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.InternalPlaylistItem;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.folders.u;
import com.smp.musicspeed.k0.o0.l;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.library.playlists.Playlist;
import com.smp.musicspeed.library.playlists.e;
import com.smp.musicspeed.library.playlists.f;
import com.smp.musicspeed.library.playlists.h;
import com.smp.musicspeed.utils.AppPrefs;
import f.g0.k;
import f.w.g;
import f.z.c.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.m1;
import org.greenrobot.eventbus.c;

public final class h {
    public static final /* synthetic */ void a(Context context, Playlist playlist, File file) {
        h.e(context, playlist, file);
    }

    public static final void b(Context context, Playlist playlist) {
        f.z.d.k.g((Object)context, (String)"ctx");
        f.z.d.k.g((Object)playlist, (String)"playlist");
        kotlinx.coroutines.e.d((k0)m1.f, (g)a1.b(), null, (p)new a(context, playlist, null), (int)2, null);
    }

    public static /* synthetic */ void c(List list, File file, String string2, Uri uri) {
        h.f(list, file, string2, uri);
    }

    public static final void d(d d2, f f2) {
        f.z.d.k.g((Object)d2, (String)"activity");
        f.z.d.k.g((Object)f2, (String)"complete");
        l.v.a(f2.a(), f2.b()).M(d2.R(), "playlistExportDialogFragment");
    }

    private static final void e(Context context, Playlist playlist, File file) {
        List<InternalPlaylistItem> list = AppDatabaseKt.getInternalPlaylistDao().loadAllPlaylistItems(playlist.getPlaylistId());
        ArrayList arrayList = new ArrayList(f.u.l.j(list, (int)10));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((InternalPlaylistItem)iterator.next()).getMediaTrack());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#EXTM3U");
        for (MediaTrack mediaTrack : arrayList) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(mediaTrack.getLocation());
        }
        String string2 = stringBuilder.toString();
        f.z.d.k.f((Object)string2, (String)"StringBuilder().run {\n        append(\"#EXTM3U\")\n        tracks.forEach {\n            append(System.lineSeparator())\n            append(it.location)\n        }\n        toString()\n    }");
        f.y.g.d((File)file, (String)string2, null, (int)2, null);
        String[] arrstring = new String[]{file.getAbsolutePath()};
        MediaScannerConnection.scanFile((Context)context, (String[])arrstring, null, (MediaScannerConnection.OnScanCompletedListener)new e((List)arrayList, file));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final void f(List list, File file, String string2, Uri uri) {
        boolean bl;
        f.z.d.k.g((Object)list, (String)"$tracks");
        f.z.d.k.g((Object)file, (String)"$file");
        if (uri == null) return;
        List list2 = uri.getPathSegments();
        f.z.d.k.f((Object)list2, (String)"uri.pathSegments");
        String string3 = (String)f.u.l.E((List)list2);
        if (string3 == null) {
            return;
        }
        Long l2 = k.d((String)string3);
        if (l2 == null) return;
        boolean bl2 = list instanceof Collection;
        boolean bl3 = true;
        if (!bl2 || !list.isEmpty()) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!(bl3 ^ u.c((MediaTrack)iterator.next()))) continue;
                bl = true;
                break;
            }
        } else {
            bl = false;
        }
        if (!bl || !z.c()) {
            bl3 = false;
        }
        AppPrefs.k.X().add((Object)l2.toString());
        c.d().m((Object)new f(file, bl3));
    }
}

