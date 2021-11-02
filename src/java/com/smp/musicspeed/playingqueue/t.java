/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.u.l
 *  f.z.d.k
 *  java.io.File
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.playingqueue;

import android.content.Context;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.f;
import f.m;
import f.n;
import f.u.l;
import f.z.d.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class t {
    public static final <T> List<T> a(List<? extends T> list, int n2) {
        k.g(list, (String)"list");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            boolean bl;
            Object object = iterator.next();
            int n4 = n3 + 1;
            if (n3 < 0) {
                l.i();
            }
            if (bl = n3 == n2) {
                arrayList.add(object);
            }
            n3 = n4;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final List<MediaTrack> b(Context context, List<MediaTrack> list) {
        k.g((Object)context, (String)"context");
        k.g(list, (String)"currentList");
        if (list.isEmpty()) {
            return new ArrayList();
        }
        try {
            List list2 = l.G((Collection)f.u(context, null, 2, null), (Iterable)f.s(context, null, 2, null));
            ArrayList arrayList = new ArrayList(l.j(list, (int)10));
            Iterator iterator = list.iterator();
            do {
                Object object2;
                MediaTrack mediaTrack;
                MediaTrack mediaTrack2;
                MediaTrack mediaTrack3;
                block8 : {
                    if (!iterator.hasNext()) {
                        return l.O((Collection)arrayList);
                    }
                    mediaTrack2 = (MediaTrack)iterator.next();
                    for (Object object2 : list2) {
                        if (!k.c((Object)((MediaTrack)object2).getLocation(), (Object)mediaTrack2.getLocation())) continue;
                        break block8;
                    }
                    object2 = null;
                }
                if ((mediaTrack3 = (MediaTrack)object2) != null) {
                    String string2 = mediaTrack3.getTrackName();
                    String string3 = mediaTrack3.getArtistName();
                    long l2 = mediaTrack3.getSongId();
                    String string4 = mediaTrack3.getLocation();
                    long l3 = mediaTrack3.getDuration();
                    I i2 = mediaTrack3.getMediaType();
                    long l4 = mediaTrack3.getAlbumId();
                    String string5 = mediaTrack3.getAlbumName();
                    long l5 = mediaTrack3.getArtistId();
                    int n2 = mediaTrack3.getTrackNumber();
                    int n3 = mediaTrack3.getYear();
                    long l6 = mediaTrack3.getDateModified();
                    long l7 = mediaTrack3.getIdInPlaylist();
                    mediaTrack = new MediaTrack(string2, string3, l2, string4, l3, true, i2, l4, string5, l5, n2, n3, l6, l7);
                } else {
                    MediaTrack mediaTrack4;
                    mediaTrack = mediaTrack4 = new MediaTrack(mediaTrack2.getTrackName(), mediaTrack2.getArtistName(), mediaTrack2.getSongId(), mediaTrack2.getLocation(), mediaTrack2.getDuration(), new File(mediaTrack2.getLocation()).exists(), mediaTrack2.getMediaType(), mediaTrack2.getAlbumId(), mediaTrack2.getAlbumName(), mediaTrack2.getArtistId(), mediaTrack2.getTrackNumber(), mediaTrack2.getYear(), mediaTrack2.getDateModified(), mediaTrack2.getIdInPlaylist());
                }
                arrayList.add((Object)mediaTrack);
            } while (true);
        }
        catch (Throwable throwable) {
            Object object = m.b(n.a(throwable));
            Object object3 = m.f(object) ? null : object;
            Void void_ = (Void)object3;
            if (void_ != null) return (List)void_;
            return l.O(list);
        }
    }
}

