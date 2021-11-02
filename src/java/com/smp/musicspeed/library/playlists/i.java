/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.widget.Toast
 *  com.smp.musicspeed.dbrecord.InternalPlaylist
 *  com.smp.musicspeed.dbrecord.MediaTrack
 *  f.u.f
 *  f.z.d.g
 *  f.z.d.k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.smp.musicspeed.library.playlists;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.InternalPlaylist;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.f;
import com.smp.musicspeed.k0.m0.h;
import f.z.d.g;
import f.z.d.k;
import java.util.List;

public final class i {
    public static final void a(Context context, String string2, MediaTrack[] arrmediaTrack, boolean bl) {
        k.g((Object)context, (String)"ctx");
        k.g((Object)string2, (String)"name");
        k.g((Object)arrmediaTrack, (String)"toInsert");
        InternalPlaylistDao internalPlaylistDao = AppDatabaseKt.getInternalPlaylistDao();
        InternalPlaylist internalPlaylist = new InternalPlaylist(0L, string2, null, 5, null);
        long l2 = internalPlaylistDao.insertInternalPlaylist(internalPlaylist);
        if (bl) {
            Toast.makeText((Context)context, (CharSequence)context.getResources().getString(2131821312, new Object[]{string2}), (int)0).show();
        }
        int n2 = arrmediaTrack.length;
        boolean bl2 = false;
        if (n2 == 0) {
            bl2 = true;
        }
        if (bl2 ^ true) {
            f.a(context, (List<MediaTrack>)f.u.f.a((Object[])arrmediaTrack), l2, string2, bl);
        }
        h.a(context);
    }

    public static /* synthetic */ void b(Context context, String string2, MediaTrack[] arrmediaTrack, boolean bl, int n2, Object object) {
        if ((n2 & 8) != 0) {
            bl = true;
        }
        i.a(context, string2, arrmediaTrack, bl);
    }
}

