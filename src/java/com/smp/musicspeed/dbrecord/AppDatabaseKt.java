/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.room.s.a
 *  com.smp.musicspeed.dbrecord.AppDatabase
 *  com.smp.musicspeed.dbrecord.AppDatabaseKt$MIGRATION_1_2
 *  com.smp.musicspeed.dbrecord.AppDatabaseKt$MIGRATION_1_2$1
 *  com.smp.musicspeed.dbrecord.AppDatabaseKt$MIGRATION_2_3
 *  com.smp.musicspeed.dbrecord.AppDatabaseKt$MIGRATION_2_3$1
 *  com.smp.musicspeed.dbrecord.AppDatabaseKt$MIGRATION_3_4
 *  com.smp.musicspeed.dbrecord.AppDatabaseKt$MIGRATION_3_4$1
 *  java.lang.Class
 *  java.lang.Object
 */
package com.smp.musicspeed.dbrecord;

import androidx.room.s.a;
import com.smp.musicspeed.MusicSpeedChangerApplication;
import com.smp.musicspeed.dbrecord.AppDatabase;
import com.smp.musicspeed.dbrecord.AppDatabaseKt;
import com.smp.musicspeed.dbrecord.InternalPlaylistDao;
import com.smp.musicspeed.dbrecord.MarkersDao;
import com.smp.musicspeed.dbrecord.PlayingQueueDao;
import com.smp.musicspeed.dbrecord.PresetsDao;

public final class AppDatabaseKt {
    private static final a MIGRATION_1_2 = new MIGRATION_1_2.1();
    private static final a MIGRATION_2_3 = new MIGRATION_2_3.1();
    private static final a MIGRATION_3_4 = new MIGRATION_3_4.1();

    private static final AppDatabase getDatabase() {
        Class<AppDatabaseKt> class_ = AppDatabaseKt.class;
        synchronized (AppDatabaseKt.class) {
            AppDatabase appDatabase = MusicSpeedChangerApplication.f.a();
            // ** MonitorExit[var2] (shouldn't be in output)
            return appDatabase;
        }
    }

    public static final InternalPlaylistDao getInternalPlaylistDao() {
        return AppDatabaseKt.getDatabase().internalPlaylistDao();
    }

    public static final a getMIGRATION_1_2() {
        return MIGRATION_1_2;
    }

    public static final a getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final a getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }

    public static final MarkersDao getMarkersDao() {
        return AppDatabaseKt.getDatabase().markersDao();
    }

    public static final PlayingQueueDao getPlayingQueueDao() {
        return AppDatabaseKt.getDatabase().playingQueueDao();
    }

    public static final PresetsDao getPresetsDao() {
        return AppDatabaseKt.getDatabase().presetSDao();
    }
}

