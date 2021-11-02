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
 *  b.u.a.e
 *  com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl$a
 *  com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl$b
 *  com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl$c
 *  com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl$d
 *  com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl$e
 *  com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl$f
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.smp.musicspeed.dbrecord;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import com.smp.musicspeed.dbrecord.Converters;
import com.smp.musicspeed.dbrecord.PlayingQueueDao;
import com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl;
import com.smp.musicspeed.dbrecord.PlayingQueueInfo;
import com.smp.musicspeed.dbrecord.PlayingQueueInfoItem;
import com.smp.musicspeed.dbrecord.PlayingQueueItem;
import com.smp.musicspeed.dbrecord.PlayingQueueShuffleItem;
import java.util.ArrayList;
import java.util.List;

public final class PlayingQueueDao_Impl
implements PlayingQueueDao {
    private final Converters __converters = new Converters();
    private final j __db;
    private final androidx.room.b<PlayingQueueInfoItem> __deletionAdapterOfPlayingQueueInfoItem;
    private final androidx.room.b<PlayingQueueItem> __deletionAdapterOfPlayingQueueItem;
    private final androidx.room.b<PlayingQueueShuffleItem> __deletionAdapterOfPlayingQueueShuffleItem;
    private final androidx.room.c<PlayingQueueInfoItem> __insertionAdapterOfPlayingQueueInfoItem;
    private final androidx.room.c<PlayingQueueItem> __insertionAdapterOfPlayingQueueItem;
    private final androidx.room.c<PlayingQueueShuffleItem> __insertionAdapterOfPlayingQueueShuffleItem;

    public PlayingQueueDao_Impl(j j2) {
        this.__db = j2;
        this.__insertionAdapterOfPlayingQueueItem = new a(this, j2);
        this.__insertionAdapterOfPlayingQueueShuffleItem = new b(this, j2);
        this.__insertionAdapterOfPlayingQueueInfoItem = new c(this, j2);
        this.__deletionAdapterOfPlayingQueueItem = new d(this, j2);
        this.__deletionAdapterOfPlayingQueueShuffleItem = new e(this, j2);
        this.__deletionAdapterOfPlayingQueueInfoItem = new f(this, j2);
    }

    static /* synthetic */ Converters access$000(PlayingQueueDao_Impl playingQueueDao_Impl) {
        return playingQueueDao_Impl.__converters;
    }

    @Override
    public void deletePlayingQueueInfoItems(List<PlayingQueueInfoItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayingQueueInfoItem.i(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void deletePlayingQueueItems(List<PlayingQueueItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayingQueueItem.i(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void deletePlayingQueueShuffleItems(List<PlayingQueueShuffleItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPlayingQueueShuffleItem.i(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public List<PlayingQueueInfoItem> getAllPlayingQueueInfoItems() {
        m m2 = m.i((String)"SELECT * FROM PlayingQueueInfoItem", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"playingQueueInfoId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"currentlyPlaying");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add((Object)new PlayingQueueInfoItem(cursor.getLong(n2), cursor.getInt(n3)));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public List<PlayingQueueItem> getAllPlayingQueueItems() {
        m m2 = m.i((String)"SELECT * FROM PlayingQueueItem ORDER BY orderInPlayingQueue", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"playingQueueItemId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"orderInPlayingQueue");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"trackName");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"artistName");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"songId");
            int n7 = androidx.room.t.b.b((Cursor)cursor, (String)"location");
            int n8 = androidx.room.t.b.b((Cursor)cursor, (String)"duration");
            int n9 = androidx.room.t.b.b((Cursor)cursor, (String)"isInLibrary");
            int n10 = androidx.room.t.b.b((Cursor)cursor, (String)"mediaType");
            int n11 = androidx.room.t.b.b((Cursor)cursor, (String)"albumId");
            int n12 = androidx.room.t.b.b((Cursor)cursor, (String)"albumName");
            int n13 = androidx.room.t.b.b((Cursor)cursor, (String)"artistId");
            int n14 = androidx.room.t.b.b((Cursor)cursor, (String)"trackNumber");
            return n14;
        }
        finally {
            m m3 = m2;
        }
    }

    @Override
    public List<PlayingQueueShuffleItem> getAllPlayingQueueShuffleItems() {
        m m2 = m.i((String)"SELECT * FROM PlayingQueueShuffleItem ORDER BY orderInShuffleMap", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (b.u.a.e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"playingQueueShuffleItemId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"orderInShuffleMap");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"mapNumber");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                long l2 = cursor.getLong(n2);
                long l3 = cursor.getLong(n3);
                int n5 = cursor.getInt(n4);
                PlayingQueueShuffleItem playingQueueShuffleItem = new PlayingQueueShuffleItem(l2, l3, n5);
                arrayList.add((Object)playingQueueShuffleItem);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public void insertPlayingQueueInfoItems(List<PlayingQueueInfoItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlayingQueueInfoItem.h(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void insertPlayingQueueItems(List<PlayingQueueItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlayingQueueItem.h(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void insertPlayingQueueShuffleItems(List<PlayingQueueShuffleItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlayingQueueShuffleItem.h(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public PlayingQueueInfo loadPlayingQueue() {
        this.__db.beginTransaction();
        try {
            PlayingQueueInfo playingQueueInfo = PlayingQueueDao.DefaultImpls.loadPlayingQueue(this);
            this.__db.setTransactionSuccessful();
            return playingQueueInfo;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void savePlayingQueue(PlayingQueueInfo playingQueueInfo) {
        this.__db.beginTransaction();
        try {
            PlayingQueueDao.DefaultImpls.savePlayingQueue(this, playingQueueInfo);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

