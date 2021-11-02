/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.room.j
 */
package com.smp.musicspeed.dbrecord;

import androidx.room.j;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao;
import com.smp.musicspeed.dbrecord.MarkersDao;
import com.smp.musicspeed.dbrecord.PlayingQueueDao;
import com.smp.musicspeed.dbrecord.PresetsDao;

public abstract class AppDatabase
extends j {
    public abstract InternalPlaylistDao internalPlaylistDao();

    public abstract MarkersDao markersDao();

    public abstract PlayingQueueDao playingQueueDao();

    public abstract PresetsDao presetSDao();
}

