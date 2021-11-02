/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  androidx.room.a
 *  androidx.room.g
 *  androidx.room.j
 *  androidx.room.l
 *  androidx.room.l$a
 *  b.u.a.b
 *  b.u.a.c
 *  b.u.a.c$a
 *  b.u.a.c$b
 *  b.u.a.c$b$a
 *  b.u.a.c$c
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.smp.musicspeed.dbrecord;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import b.u.a.b;
import b.u.a.c;
import com.smp.musicspeed.dbrecord.AppDatabase;
import com.smp.musicspeed.dbrecord.AppDatabase_Impl;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao_Impl;
import com.smp.musicspeed.dbrecord.MarkersDao;
import com.smp.musicspeed.dbrecord.MarkersDao_Impl;
import com.smp.musicspeed.dbrecord.PlayingQueueDao;
import com.smp.musicspeed.dbrecord.PlayingQueueDao_Impl;
import com.smp.musicspeed.dbrecord.PresetsDao;
import com.smp.musicspeed.dbrecord.PresetsDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppDatabase_Impl
extends AppDatabase {
    private volatile InternalPlaylistDao _internalPlaylistDao;
    private volatile MarkersDao _markersDao;
    private volatile PlayingQueueDao _playingQueueDao;
    private volatile PresetsDao _presetsDao;

    static /* synthetic */ List access$000(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$100(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$1000(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$200(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$300(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$400(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$500(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ b access$602(AppDatabase_Impl appDatabase_Impl, b b2) {
        appDatabase_Impl.mDatabase = b2;
        return b2;
    }

    static /* synthetic */ void access$700(AppDatabase_Impl appDatabase_Impl, b b2) {
        appDatabase_Impl.internalInitInvalidationTracker(b2);
    }

    static /* synthetic */ List access$800(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    static /* synthetic */ List access$900(AppDatabase_Impl appDatabase_Impl) {
        return appDatabase_Impl.mCallbacks;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void clearAllTables() {
        j.super.assertNotMainThread();
        var1_1 = j.super.getOpenHelper().b();
        var2_2 = Build.VERSION.SDK_INT >= 21;
        if (var2_2) ** GOTO lbl7
        try {
            var1_1.j("PRAGMA foreign_keys = FALSE");
lbl7: // 2 sources:
            j.super.beginTransaction();
            if (var2_2) {
                var1_1.j("PRAGMA defer_foreign_keys = TRUE");
            }
            var1_1.j("DELETE FROM `InternalPlaylistItem`");
            var1_1.j("DELETE FROM `InternalPlaylist`");
            var1_1.j("DELETE FROM `PlayingQueueItem`");
            var1_1.j("DELETE FROM `PlayingQueueShuffleItem`");
            var1_1.j("DELETE FROM `PlayingQueueInfoItem`");
            var1_1.j("DELETE FROM `MarkerItem`");
            var1_1.j("DELETE FROM `PresetItem`");
            j.super.setTransactionSuccessful();
            return;
        }
        finally {
            j.super.endTransaction();
            if (!var2_2) {
                var1_1.j("PRAGMA foreign_keys = TRUE");
            }
            var1_1.G("PRAGMA wal_checkpoint(FULL)").close();
            if (!var1_1.S()) {
                var1_1.j("VACUUM");
            }
        }
    }

    protected g createInvalidationTracker() {
        return new g((j)this, (Map)new HashMap(0), (Map)new HashMap(0), new String[]{"InternalPlaylistItem", "InternalPlaylist", "PlayingQueueItem", "PlayingQueueShuffleItem", "PlayingQueueInfoItem", "MarkerItem", "PresetItem"});
    }

    protected c createOpenHelper(androidx.room.a a2) {
        l l2 = new l(a2, new l.a(this, 4){
            final /* synthetic */ AppDatabase_Impl b;
            {
                this.b = appDatabase_Impl;
                super(n2);
            }

            public void a(b b2) {
                b2.j("CREATE TABLE IF NOT EXISTS `InternalPlaylistItem` (`internalPlaylistItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `internalPlaylistId` INTEGER NOT NULL, `orderInPlaylist` INTEGER NOT NULL, `trackName` TEXT NOT NULL, `artistName` TEXT NOT NULL, `songId` INTEGER NOT NULL, `location` TEXT NOT NULL, `duration` INTEGER NOT NULL, `isInLibrary` INTEGER NOT NULL, `mediaType` INTEGER NOT NULL, `albumId` INTEGER NOT NULL, `albumName` TEXT NOT NULL, `artistId` INTEGER NOT NULL, `trackNumber` INTEGER NOT NULL, `year` INTEGER NOT NULL, `dateModified` INTEGER NOT NULL, `idInPlaylist` INTEGER NOT NULL, FOREIGN KEY(`internalPlaylistId`) REFERENCES `InternalPlaylist`(`internalPlaylistId`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
                b2.j("CREATE INDEX IF NOT EXISTS `index_InternalPlaylistItem_internalPlaylistId` ON `InternalPlaylistItem` (`internalPlaylistId`)");
                b2.j("CREATE TABLE IF NOT EXISTS `InternalPlaylist` (`internalPlaylistId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `internalPlaylistName` TEXT NOT NULL, `playlistName` TEXT NOT NULL, `mediaType` INTEGER NOT NULL)");
                b2.j("CREATE TABLE IF NOT EXISTS `PlayingQueueItem` (`playingQueueItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderInPlayingQueue` INTEGER NOT NULL, `trackName` TEXT NOT NULL, `artistName` TEXT NOT NULL, `songId` INTEGER NOT NULL, `location` TEXT NOT NULL, `duration` INTEGER NOT NULL, `isInLibrary` INTEGER NOT NULL, `mediaType` INTEGER NOT NULL, `albumId` INTEGER NOT NULL, `albumName` TEXT NOT NULL, `artistId` INTEGER NOT NULL, `trackNumber` INTEGER NOT NULL, `year` INTEGER NOT NULL, `dateModified` INTEGER NOT NULL, `idInPlaylist` INTEGER NOT NULL)");
                b2.j("CREATE TABLE IF NOT EXISTS `PlayingQueueShuffleItem` (`playingQueueShuffleItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderInShuffleMap` INTEGER NOT NULL, `mapNumber` INTEGER NOT NULL)");
                b2.j("CREATE TABLE IF NOT EXISTS `PlayingQueueInfoItem` (`playingQueueInfoId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `currentlyPlaying` INTEGER NOT NULL)");
                b2.j("CREATE TABLE IF NOT EXISTS `MarkerItem` (`MarkerItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `position` REAL NOT NULL, `isA` INTEGER NOT NULL, `isB` INTEGER NOT NULL, `file` TEXT NOT NULL, `durationUs` INTEGER NOT NULL, `name` TEXT NOT NULL)");
                b2.j("CREATE TABLE IF NOT EXISTS `PresetItem` (`presetName` TEXT NOT NULL, `effectId` INTEGER NOT NULL, `controlId` INTEGER NOT NULL, `value` REAL NOT NULL, PRIMARY KEY(`presetName`, `effectId`, `controlId`))");
                b2.j("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                b2.j("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '28da9b7906846caa946f7a4c39b05952')");
            }

            public void b(b b2) {
                b2.j("DROP TABLE IF EXISTS `InternalPlaylistItem`");
                b2.j("DROP TABLE IF EXISTS `InternalPlaylist`");
                b2.j("DROP TABLE IF EXISTS `PlayingQueueItem`");
                b2.j("DROP TABLE IF EXISTS `PlayingQueueShuffleItem`");
                b2.j("DROP TABLE IF EXISTS `PlayingQueueInfoItem`");
                b2.j("DROP TABLE IF EXISTS `MarkerItem`");
                b2.j("DROP TABLE IF EXISTS `PresetItem`");
                if (AppDatabase_Impl.access$000(this.b) != null) {
                    int n2 = AppDatabase_Impl.access$100(this.b).size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        ((androidx.room.j$b)AppDatabase_Impl.access$200(this.b).get(i2)).b(b2);
                    }
                }
            }

            protected void c(b b2) {
                if (AppDatabase_Impl.access$300(this.b) != null) {
                    int n2 = AppDatabase_Impl.access$400(this.b).size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        ((androidx.room.j$b)AppDatabase_Impl.access$500(this.b).get(i2)).a(b2);
                    }
                }
            }

            public void d(b b2) {
                AppDatabase_Impl.access$602(this.b, b2);
                b2.j("PRAGMA foreign_keys = ON");
                AppDatabase_Impl.access$700(this.b, b2);
                if (AppDatabase_Impl.access$800(this.b) != null) {
                    int n2 = AppDatabase_Impl.access$900(this.b).size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        ((androidx.room.j$b)AppDatabase_Impl.access$1000(this.b).get(i2)).c(b2);
                    }
                }
            }

            public void e(b b2) {
            }

            public void f(b b2) {
                androidx.room.t.c.a((b)b2);
            }

            protected androidx.room.l$b g(b b2) {
                HashMap hashMap = new HashMap(17);
                androidx.room.t.g$a a2 = new androidx.room.t.g$a("internalPlaylistItemId", "INTEGER", true, 1, null, 1);
                hashMap.put((java.lang.Object)"internalPlaylistItemId", (java.lang.Object)a2);
                androidx.room.t.g$a a3 = new androidx.room.t.g$a("internalPlaylistId", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"internalPlaylistId", (java.lang.Object)a3);
                androidx.room.t.g$a a4 = new androidx.room.t.g$a("orderInPlaylist", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"orderInPlaylist", (java.lang.Object)a4);
                androidx.room.t.g$a a5 = new androidx.room.t.g$a("trackName", "TEXT", true, 0, null, 1);
                hashMap.put((java.lang.Object)"trackName", (java.lang.Object)a5);
                androidx.room.t.g$a a6 = new androidx.room.t.g$a("artistName", "TEXT", true, 0, null, 1);
                hashMap.put((java.lang.Object)"artistName", (java.lang.Object)a6);
                androidx.room.t.g$a a7 = new androidx.room.t.g$a("songId", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"songId", (java.lang.Object)a7);
                androidx.room.t.g$a a8 = new androidx.room.t.g$a("location", "TEXT", true, 0, null, 1);
                hashMap.put((java.lang.Object)"location", (java.lang.Object)a8);
                androidx.room.t.g$a a9 = new androidx.room.t.g$a("duration", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"duration", (java.lang.Object)a9);
                androidx.room.t.g$a a10 = new androidx.room.t.g$a("isInLibrary", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"isInLibrary", (java.lang.Object)a10);
                androidx.room.t.g$a a11 = new androidx.room.t.g$a("mediaType", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"mediaType", (java.lang.Object)a11);
                androidx.room.t.g$a a12 = new androidx.room.t.g$a("albumId", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"albumId", (java.lang.Object)a12);
                androidx.room.t.g$a a13 = new androidx.room.t.g$a("albumName", "TEXT", true, 0, null, 1);
                hashMap.put((java.lang.Object)"albumName", (java.lang.Object)a13);
                androidx.room.t.g$a a14 = new androidx.room.t.g$a("artistId", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"artistId", (java.lang.Object)a14);
                androidx.room.t.g$a a15 = new androidx.room.t.g$a("trackNumber", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"trackNumber", (java.lang.Object)a15);
                androidx.room.t.g$a a16 = new androidx.room.t.g$a("year", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"year", (java.lang.Object)a16);
                androidx.room.t.g$a a17 = new androidx.room.t.g$a("dateModified", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"dateModified", (java.lang.Object)a17);
                androidx.room.t.g$a a18 = new androidx.room.t.g$a("idInPlaylist", "INTEGER", true, 0, null, 1);
                hashMap.put((java.lang.Object)"idInPlaylist", (java.lang.Object)a18);
                java.util.HashSet hashSet = new java.util.HashSet(1);
                androidx.room.t.g$b b3 = new androidx.room.t.g$b("InternalPlaylist", "NO ACTION", "NO ACTION", java.util.Arrays.asList((java.lang.Object[])new String[]{"internalPlaylistId"}), java.util.Arrays.asList((java.lang.Object[])new String[]{"internalPlaylistId"}));
                hashSet.add((java.lang.Object)b3);
                java.util.HashSet hashSet2 = new java.util.HashSet(1);
                hashSet2.add((java.lang.Object)new androidx.room.t.g$d("index_InternalPlaylistItem_internalPlaylistId", false, java.util.Arrays.asList((java.lang.Object[])new String[]{"internalPlaylistId"})));
                androidx.room.t.g g2 = new androidx.room.t.g("InternalPlaylistItem", (Map)hashMap, (java.util.Set)hashSet, (java.util.Set)hashSet2);
                androidx.room.t.g g3 = androidx.room.t.g.a((b)b2, (String)"InternalPlaylistItem");
                if (!g2.equals((java.lang.Object)g3)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("InternalPlaylistItem(com.smp.musicspeed.dbrecord.InternalPlaylistItem).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g2);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g3);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                HashMap hashMap2 = new HashMap(4);
                androidx.room.t.g$a a19 = new androidx.room.t.g$a("internalPlaylistId", "INTEGER", true, 1, null, 1);
                hashMap2.put((java.lang.Object)"internalPlaylistId", (java.lang.Object)a19);
                androidx.room.t.g$a a20 = new androidx.room.t.g$a("internalPlaylistName", "TEXT", true, 0, null, 1);
                hashMap2.put((java.lang.Object)"internalPlaylistName", (java.lang.Object)a20);
                androidx.room.t.g$a a21 = new androidx.room.t.g$a("playlistName", "TEXT", true, 0, null, 1);
                hashMap2.put((java.lang.Object)"playlistName", (java.lang.Object)a21);
                androidx.room.t.g$a a22 = new androidx.room.t.g$a("mediaType", "INTEGER", true, 0, null, 1);
                hashMap2.put((java.lang.Object)"mediaType", (java.lang.Object)a22);
                androidx.room.t.g g4 = new androidx.room.t.g("InternalPlaylist", (Map)hashMap2, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.t.g g5 = androidx.room.t.g.a((b)b2, (String)"InternalPlaylist");
                if (!g4.equals((java.lang.Object)g5)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("InternalPlaylist(com.smp.musicspeed.dbrecord.InternalPlaylist).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g4);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g5);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                HashMap hashMap3 = new HashMap(16);
                androidx.room.t.g$a a23 = new androidx.room.t.g$a("playingQueueItemId", "INTEGER", true, 1, null, 1);
                hashMap3.put((java.lang.Object)"playingQueueItemId", (java.lang.Object)a23);
                androidx.room.t.g$a a24 = new androidx.room.t.g$a("orderInPlayingQueue", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"orderInPlayingQueue", (java.lang.Object)a24);
                androidx.room.t.g$a a25 = new androidx.room.t.g$a("trackName", "TEXT", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"trackName", (java.lang.Object)a25);
                androidx.room.t.g$a a26 = new androidx.room.t.g$a("artistName", "TEXT", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"artistName", (java.lang.Object)a26);
                androidx.room.t.g$a a27 = new androidx.room.t.g$a("songId", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"songId", (java.lang.Object)a27);
                androidx.room.t.g$a a28 = new androidx.room.t.g$a("location", "TEXT", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"location", (java.lang.Object)a28);
                androidx.room.t.g$a a29 = new androidx.room.t.g$a("duration", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"duration", (java.lang.Object)a29);
                androidx.room.t.g$a a30 = new androidx.room.t.g$a("isInLibrary", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"isInLibrary", (java.lang.Object)a30);
                androidx.room.t.g$a a31 = new androidx.room.t.g$a("mediaType", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"mediaType", (java.lang.Object)a31);
                androidx.room.t.g$a a32 = new androidx.room.t.g$a("albumId", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"albumId", (java.lang.Object)a32);
                androidx.room.t.g$a a33 = new androidx.room.t.g$a("albumName", "TEXT", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"albumName", (java.lang.Object)a33);
                androidx.room.t.g$a a34 = new androidx.room.t.g$a("artistId", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"artistId", (java.lang.Object)a34);
                androidx.room.t.g$a a35 = new androidx.room.t.g$a("trackNumber", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"trackNumber", (java.lang.Object)a35);
                androidx.room.t.g$a a36 = new androidx.room.t.g$a("year", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"year", (java.lang.Object)a36);
                androidx.room.t.g$a a37 = new androidx.room.t.g$a("dateModified", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"dateModified", (java.lang.Object)a37);
                androidx.room.t.g$a a38 = new androidx.room.t.g$a("idInPlaylist", "INTEGER", true, 0, null, 1);
                hashMap3.put((java.lang.Object)"idInPlaylist", (java.lang.Object)a38);
                androidx.room.t.g g6 = new androidx.room.t.g("PlayingQueueItem", (Map)hashMap3, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.t.g g7 = androidx.room.t.g.a((b)b2, (String)"PlayingQueueItem");
                if (!g6.equals((java.lang.Object)g7)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("PlayingQueueItem(com.smp.musicspeed.dbrecord.PlayingQueueItem).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g6);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g7);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                HashMap hashMap4 = new HashMap(3);
                androidx.room.t.g$a a39 = new androidx.room.t.g$a("playingQueueShuffleItemId", "INTEGER", true, 1, null, 1);
                hashMap4.put((java.lang.Object)"playingQueueShuffleItemId", (java.lang.Object)a39);
                androidx.room.t.g$a a40 = new androidx.room.t.g$a("orderInShuffleMap", "INTEGER", true, 0, null, 1);
                hashMap4.put((java.lang.Object)"orderInShuffleMap", (java.lang.Object)a40);
                androidx.room.t.g$a a41 = new androidx.room.t.g$a("mapNumber", "INTEGER", true, 0, null, 1);
                hashMap4.put((java.lang.Object)"mapNumber", (java.lang.Object)a41);
                androidx.room.t.g g8 = new androidx.room.t.g("PlayingQueueShuffleItem", (Map)hashMap4, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.t.g g9 = androidx.room.t.g.a((b)b2, (String)"PlayingQueueShuffleItem");
                if (!g8.equals((java.lang.Object)g9)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("PlayingQueueShuffleItem(com.smp.musicspeed.dbrecord.PlayingQueueShuffleItem).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g8);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g9);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                HashMap hashMap5 = new HashMap(2);
                androidx.room.t.g$a a42 = new androidx.room.t.g$a("playingQueueInfoId", "INTEGER", true, 1, null, 1);
                hashMap5.put((java.lang.Object)"playingQueueInfoId", (java.lang.Object)a42);
                androidx.room.t.g$a a43 = new androidx.room.t.g$a("currentlyPlaying", "INTEGER", true, 0, null, 1);
                hashMap5.put((java.lang.Object)"currentlyPlaying", (java.lang.Object)a43);
                androidx.room.t.g g10 = new androidx.room.t.g("PlayingQueueInfoItem", (Map)hashMap5, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.t.g g11 = androidx.room.t.g.a((b)b2, (String)"PlayingQueueInfoItem");
                if (!g10.equals((java.lang.Object)g11)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("PlayingQueueInfoItem(com.smp.musicspeed.dbrecord.PlayingQueueInfoItem).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g10);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g11);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                HashMap hashMap6 = new HashMap(7);
                androidx.room.t.g$a a44 = new androidx.room.t.g$a("MarkerItemId", "INTEGER", true, 1, null, 1);
                hashMap6.put((java.lang.Object)"MarkerItemId", (java.lang.Object)a44);
                androidx.room.t.g$a a45 = new androidx.room.t.g$a("position", "REAL", true, 0, null, 1);
                hashMap6.put((java.lang.Object)"position", (java.lang.Object)a45);
                androidx.room.t.g$a a46 = new androidx.room.t.g$a("isA", "INTEGER", true, 0, null, 1);
                hashMap6.put((java.lang.Object)"isA", (java.lang.Object)a46);
                androidx.room.t.g$a a47 = new androidx.room.t.g$a("isB", "INTEGER", true, 0, null, 1);
                hashMap6.put((java.lang.Object)"isB", (java.lang.Object)a47);
                androidx.room.t.g$a a48 = new androidx.room.t.g$a("file", "TEXT", true, 0, null, 1);
                hashMap6.put((java.lang.Object)"file", (java.lang.Object)a48);
                androidx.room.t.g$a a49 = new androidx.room.t.g$a("durationUs", "INTEGER", true, 0, null, 1);
                hashMap6.put((java.lang.Object)"durationUs", (java.lang.Object)a49);
                androidx.room.t.g$a a50 = new androidx.room.t.g$a("name", "TEXT", true, 0, null, 1);
                hashMap6.put((java.lang.Object)"name", (java.lang.Object)a50);
                androidx.room.t.g g12 = new androidx.room.t.g("MarkerItem", (Map)hashMap6, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.t.g g13 = androidx.room.t.g.a((b)b2, (String)"MarkerItem");
                if (!g12.equals((java.lang.Object)g13)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("MarkerItem(com.smp.musicspeed.dbrecord.MarkerItem).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g12);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g13);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                HashMap hashMap7 = new HashMap(4);
                androidx.room.t.g$a a51 = new androidx.room.t.g$a("presetName", "TEXT", true, 1, null, 1);
                hashMap7.put((java.lang.Object)"presetName", (java.lang.Object)a51);
                androidx.room.t.g$a a52 = new androidx.room.t.g$a("effectId", "INTEGER", true, 2, null, 1);
                hashMap7.put((java.lang.Object)"effectId", (java.lang.Object)a52);
                androidx.room.t.g$a a53 = new androidx.room.t.g$a("controlId", "INTEGER", true, 3, null, 1);
                hashMap7.put((java.lang.Object)"controlId", (java.lang.Object)a53);
                androidx.room.t.g$a a54 = new androidx.room.t.g$a("value", "REAL", true, 0, null, 1);
                hashMap7.put((java.lang.Object)"value", (java.lang.Object)a54);
                androidx.room.t.g g14 = new androidx.room.t.g("PresetItem", (Map)hashMap7, (java.util.Set)new java.util.HashSet(0), (java.util.Set)new java.util.HashSet(0));
                androidx.room.t.g g15 = androidx.room.t.g.a((b)b2, (String)"PresetItem");
                if (!g14.equals((java.lang.Object)g15)) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                    stringBuilder.append("PresetItem(com.smp.musicspeed.dbrecord.PresetItem).\n Expected:\n");
                    stringBuilder.append((java.lang.Object)g14);
                    stringBuilder.append("\n Found:\n");
                    stringBuilder.append((java.lang.Object)g15);
                    return new androidx.room.l$b(false, stringBuilder.toString());
                }
                return new androidx.room.l$b(true, null);
            }
        }, "28da9b7906846caa946f7a4c39b05952", "7ce2fd357e4d6ddf41486a91b837dc81");
        c.b b2 = c.b.a((Context)a2.b).c(a2.c).b((c.a)l2).a();
        return a2.a.a(b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public InternalPlaylistDao internalPlaylistDao() {
        if (this._internalPlaylistDao != null) {
            return this._internalPlaylistDao;
        }
        AppDatabase_Impl appDatabase_Impl = this;
        synchronized (appDatabase_Impl) {
            if (this._internalPlaylistDao != null) return this._internalPlaylistDao;
            this._internalPlaylistDao = new InternalPlaylistDao_Impl(this);
            return this._internalPlaylistDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public MarkersDao markersDao() {
        if (this._markersDao != null) {
            return this._markersDao;
        }
        AppDatabase_Impl appDatabase_Impl = this;
        synchronized (appDatabase_Impl) {
            if (this._markersDao != null) return this._markersDao;
            this._markersDao = new MarkersDao_Impl(this);
            return this._markersDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public PlayingQueueDao playingQueueDao() {
        if (this._playingQueueDao != null) {
            return this._playingQueueDao;
        }
        AppDatabase_Impl appDatabase_Impl = this;
        synchronized (appDatabase_Impl) {
            if (this._playingQueueDao != null) return this._playingQueueDao;
            this._playingQueueDao = new PlayingQueueDao_Impl(this);
            return this._playingQueueDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public PresetsDao presetSDao() {
        if (this._presetsDao != null) {
            return this._presetsDao;
        }
        AppDatabase_Impl appDatabase_Impl = this;
        synchronized (appDatabase_Impl) {
            if (this._presetsDao != null) return this._presetsDao;
            this._presetsDao = new PresetsDao_Impl(this);
            return this._presetsDao;
        }
    }
}

