/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.b
 *  androidx.room.c
 *  androidx.room.j
 *  androidx.room.m
 *  androidx.room.t.b
 *  androidx.room.t.c
 *  androidx.room.t.f
 *  b.u.a.e
 *  com.smp.musicspeed.dbrecord.InternalPlaylist
 *  com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl$a
 *  com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl$b
 *  com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl$c
 *  com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl$d
 *  com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl$e
 *  com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl$f
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import com.smp.musicspeed.dbrecord.Converters;
import com.smp.musicspeed.dbrecord.InternalPlaylist;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl;
import com.smp.musicspeed.dbrecord.InternalPlaylistItem;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class InternalPlaylistDao_Impl
implements InternalPlaylistDao {
    private final Converters __converters = new Converters();
    private final j __db;
    private final androidx.room.b<InternalPlaylist> __deletionAdapterOfInternalPlaylist;
    private final androidx.room.b<InternalPlaylistItem> __deletionAdapterOfInternalPlaylistItem;
    private final androidx.room.c<InternalPlaylist> __insertionAdapterOfInternalPlaylist;
    private final androidx.room.c<InternalPlaylistItem> __insertionAdapterOfInternalPlaylistItem;
    private final androidx.room.b<InternalPlaylist> __updateAdapterOfInternalPlaylist;
    private final androidx.room.b<InternalPlaylistItem> __updateAdapterOfInternalPlaylistItem;

    public InternalPlaylistDao_Impl(j j2) {
        this.__db = j2;
        this.__insertionAdapterOfInternalPlaylistItem = new a(this, j2);
        this.__insertionAdapterOfInternalPlaylist = new b(this, j2);
        this.__deletionAdapterOfInternalPlaylist = new c(this, j2);
        this.__deletionAdapterOfInternalPlaylistItem = new d(this, j2);
        this.__updateAdapterOfInternalPlaylistItem = new e(this, j2);
        this.__updateAdapterOfInternalPlaylist = new f(this, j2);
    }

    static /* synthetic */ Converters access$000(InternalPlaylistDao_Impl internalPlaylistDao_Impl) {
        return internalPlaylistDao_Impl.__converters;
    }

    @Override
    public void deleteInternalPlaylist(InternalPlaylist internalPlaylist) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfInternalPlaylist.h((Object)internalPlaylist);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void deleteInternalPlaylistItems(List<InternalPlaylistItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfInternalPlaylistItem.i(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public List<InternalPlaylist> getAllPlaylists() {
        m m2 = m.i((String)"SELECT * FROM InternalPlaylist", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistName");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"playlistName");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                long l2 = cursor.getLong(n2);
                String string = cursor.getString(n3);
                int n6 = cursor.getInt(n5);
                InternalPlaylist internalPlaylist = new InternalPlaylist(l2, string, this.__converters.mediaTypeFromInt(n6));
                internalPlaylist.setPlaylistName(cursor.getString(n4));
                arrayList.add((Object)internalPlaylist);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public long getHighestOrderNumber(long l2) {
        long l3;
        m m2 = m.i((String)"SELECT MAX(orderInPlaylist) FROM InternalPlaylistItem WHERE ? = internalPlaylistId", (int)1);
        m2.y(1, l2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            l3 = cursor.moveToFirst() ? cursor.getLong(0) : 0L;
        }
        catch (Throwable throwable) {
            cursor.close();
            m2.t();
            throw throwable;
        }
        cursor.close();
        m2.t();
        return l3;
    }

    @Override
    public InternalPlaylistItem getItemFromOrderNumber(long l2, long l3) {
        m m2 = m.i((String)"SELECT * FROM InternalPlaylistItem WHERE internalPlaylistId = ? AND orderInPlaylist = ?", (int)2);
        m2.y(1, l2);
        m2.y(2, l3);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistItemId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistId");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"orderInPlaylist");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"trackName");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"artistName");
            int n7 = androidx.room.t.b.b((Cursor)cursor, (String)"songId");
            int n8 = androidx.room.t.b.b((Cursor)cursor, (String)"location");
            int n9 = androidx.room.t.b.b((Cursor)cursor, (String)"duration");
            int n10 = androidx.room.t.b.b((Cursor)cursor, (String)"isInLibrary");
            int n11 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
            int n12 = androidx.room.t.b.b((Cursor)cursor, (String)"albumId");
            int n13 = androidx.room.t.b.b((Cursor)cursor, (String)"albumName");
            int n14 = androidx.room.t.b.b((Cursor)cursor, (String)"artistId");
            return n14;
        }
        finally {
            m m3 = m2;
        }
    }

    @Override
    public List<InternalPlaylistItem> getItemsFromIds(long l2, List<Long> list) {
        StringBuilder stringBuilder = androidx.room.t.f.b();
        stringBuilder.append("SELECT ");
        stringBuilder.append("*");
        stringBuilder.append(" FROM InternalPlaylistItem WHERE internalPlaylistId = ");
        stringBuilder.append("?");
        stringBuilder.append(" AND internalPlaylistItemId IN (");
        int n2 = list.size();
        androidx.room.t.f.a((StringBuilder)stringBuilder, (int)n2);
        stringBuilder.append(")");
        m m2 = m.i((String)stringBuilder.toString(), (int)(n2 + 1));
        m2.y(1, l2);
        Iterator iterator = list.iterator();
        int n3 = 2;
        while (iterator.hasNext()) {
            Long l3 = (Long)iterator.next();
            if (l3 == null) {
                m2.O(n3);
            } else {
                m2.y(n3, l3.longValue());
            }
            ++n3;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistItemId");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistId");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"orderInPlaylist");
            int n7 = androidx.room.t.b.b((Cursor)cursor, (String)"trackName");
            int n8 = androidx.room.t.b.b((Cursor)cursor, (String)"artistName");
            int n9 = androidx.room.t.b.b((Cursor)cursor, (String)"songId");
            int n10 = androidx.room.t.b.b((Cursor)cursor, (String)"location");
            int n11 = androidx.room.t.b.b((Cursor)cursor, (String)"duration");
            int n12 = androidx.room.t.b.b((Cursor)cursor, (String)"isInLibrary");
            int n13 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
            int n14 = androidx.room.t.b.b((Cursor)cursor, (String)"albumId");
            int n15 = androidx.room.t.b.b((Cursor)cursor, (String)"albumName");
            int n16 = androidx.room.t.b.b((Cursor)cursor, (String)"artistId");
            return n16;
        }
        finally {
            m m3 = m2;
        }
    }

    @Override
    public long insertInternalPlaylist(InternalPlaylist internalPlaylist) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long l2 = this.__insertionAdapterOfInternalPlaylist.k((Object)internalPlaylist);
            this.__db.setTransactionSuccessful();
            return l2;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public /* varargs */ void insertInternalPlaylistItems(InternalPlaylistItem ... arrinternalPlaylistItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfInternalPlaylistItem.j((Object[])arrinternalPlaylistItem);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public InternalPlaylist internalPlaylistFromId(long l2) {
        m m2;
        InternalPlaylist internalPlaylist;
        Cursor cursor;
        block3 : {
            int n2;
            int n3;
            int n4;
            int n5;
            m2 = m.i((String)"SELECT * FROM InternalPlaylist WHERE ? = internalPlaylistId", (int)1);
            m2.y(1, l2);
            this.__db.assertNotSuspendingTransaction();
            cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
            try {
                n3 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistId");
                n2 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistName");
                n5 = androidx.room.t.b.b((Cursor)cursor, (String)"playlistName");
                n4 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
                boolean bl = cursor.moveToFirst();
                internalPlaylist = null;
                if (!bl) break block3;
            }
            catch (Throwable throwable) {
                cursor.close();
                m2.t();
                throw throwable;
            }
            long l3 = cursor.getLong(n3);
            String string = cursor.getString(n2);
            int n6 = cursor.getInt(n4);
            InternalPlaylist internalPlaylist2 = new InternalPlaylist(l3, string, this.__converters.mediaTypeFromInt(n6));
            internalPlaylist2.setPlaylistName(cursor.getString(n5));
            internalPlaylist = internalPlaylist2;
        }
        cursor.close();
        m2.t();
        return internalPlaylist;
    }

    @Override
    public List<InternalPlaylist> internalPlaylistFromName(String string) {
        m m2 = m.i((String)"SELECT * FROM InternalPlaylist WHERE ? = internalPlaylistName", (int)1);
        if (string == null) {
            m2.O(1);
        } else {
            m2.k(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistName");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"playlistName");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                long l2 = cursor.getLong(n2);
                String string2 = cursor.getString(n3);
                int n6 = cursor.getInt(n5);
                InternalPlaylist internalPlaylist = new InternalPlaylist(l2, string2, this.__converters.mediaTypeFromInt(n6));
                internalPlaylist.setPlaylistName(cursor.getString(n4));
                arrayList.add((Object)internalPlaylist);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public List<InternalPlaylistItem> loadAllPlaylistItems(long l2) {
        m m2 = m.i((String)"SELECT * FROM InternalPlaylistItem WHERE ? = internalPlaylistId ORDER BY orderInPlaylist", (int)1);
        m2.y(1, l2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistItemId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"internalPlaylistId");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"orderInPlaylist");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"trackName");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"artistName");
            int n7 = androidx.room.t.b.b((Cursor)cursor, (String)"songId");
            int n8 = androidx.room.t.b.b((Cursor)cursor, (String)"location");
            int n9 = androidx.room.t.b.b((Cursor)cursor, (String)"duration");
            int n10 = androidx.room.t.b.b((Cursor)cursor, (String)"isInLibrary");
            int n11 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
            int n12 = androidx.room.t.b.b((Cursor)cursor, (String)"albumId");
            int n13 = androidx.room.t.b.b((Cursor)cursor, (String)"albumName");
            int n14 = androidx.room.t.b.b((Cursor)cursor, (String)"artistId");
            return n14;
        }
        finally {
            m m3 = m2;
        }
    }

    @Override
    public int moveItem(long l2, int n2, int n3) {
        this.__db.beginTransaction();
        try {
            int n4 = InternalPlaylistDao.DefaultImpls.moveItem(this, l2, n2, n3);
            this.__db.setTransactionSuccessful();
            return n4;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void removeTracksFromPlaylist(long l2, List<MediaTrack> list) {
        this.__db.beginTransaction();
        try {
            InternalPlaylistDao.DefaultImpls.removeTracksFromPlaylist(this, l2, list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void renamePlaylist(long l2, String string) {
        this.__db.beginTransaction();
        try {
            InternalPlaylistDao.DefaultImpls.renamePlaylist(this, l2, string);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public int updatePlaylist(InternalPlaylist internalPlaylist) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int n2 = 0 + this.__updateAdapterOfInternalPlaylist.h((Object)internalPlaylist);
            this.__db.setTransactionSuccessful();
            return n2;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public int updatePlaylistItems(List<InternalPlaylistItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int n2 = 0 + this.__updateAdapterOfInternalPlaylistItem.i(list);
            this.__db.setTransactionSuccessful();
            return n2;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

