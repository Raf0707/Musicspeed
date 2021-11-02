/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.lifecycle.LiveData
 *  androidx.room.b
 *  androidx.room.c
 *  androidx.room.g
 *  androidx.room.j
 *  androidx.room.m
 *  androidx.room.t.b
 *  androidx.room.t.c
 *  b.u.a.e
 *  com.smp.musicspeed.dbrecord.MarkersDao_Impl$a
 *  com.smp.musicspeed.dbrecord.MarkersDao_Impl$b
 *  com.smp.musicspeed.dbrecord.MarkersDao_Impl$c
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.Callable
 */
package com.smp.musicspeed.dbrecord;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.g;
import androidx.room.j;
import androidx.room.m;
import b.u.a.e;
import com.smp.musicspeed.dbrecord.MarkerItem;
import com.smp.musicspeed.dbrecord.MarkersDao;
import com.smp.musicspeed.dbrecord.MarkersDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class MarkersDao_Impl
implements MarkersDao {
    private final j __db;
    private final androidx.room.b<MarkerItem> __deletionAdapterOfMarkerItem;
    private final androidx.room.c<MarkerItem> __insertionAdapterOfMarkerItem;
    private final androidx.room.b<MarkerItem> __updateAdapterOfMarkerItem;

    public MarkersDao_Impl(j j2) {
        this.__db = j2;
        this.__insertionAdapterOfMarkerItem = new a(this, j2);
        this.__deletionAdapterOfMarkerItem = new b(this, j2);
        this.__updateAdapterOfMarkerItem = new c(this, j2);
    }

    static /* synthetic */ j access$000(MarkersDao_Impl markersDao_Impl) {
        return markersDao_Impl.__db;
    }

    @Override
    public void addMarkerItemDeleteClose(MarkerItem markerItem) {
        this.__db.beginTransaction();
        try {
            MarkersDao.DefaultImpls.addMarkerItemDeleteClose(this, markerItem);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public /* varargs */ void deleteMarkerItems(MarkerItem ... arrmarkerItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfMarkerItem.j((Object[])arrmarkerItem);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void deleteMarkerItemsForTrack(String string, long l2) {
        this.__db.beginTransaction();
        try {
            MarkersDao.DefaultImpls.deleteMarkerItemsForTrack(this, string, l2);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public /* varargs */ void insertMarkerItems(MarkerItem ... arrmarkerItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMarkerItem.j((Object[])arrmarkerItem);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public LiveData<List<MarkerItem>> loadAllMarkerItems(String string, long l2) {
        m m2 = m.i((String)"SELECT * FROM MarkerItem WHERE file = ? AND durationUs = ? ORDER BY position", (int)2);
        if (string == null) {
            m2.O(1);
        } else {
            m2.k(1, string);
        }
        m2.y(2, l2);
        return this.__db.getInvalidationTracker().d(new String[]{"MarkerItem"}, false, (Callable)new Callable<List<MarkerItem>>(this, m2){
            final /* synthetic */ m f;
            final /* synthetic */ MarkersDao_Impl g;
            {
                this.g = markersDao_Impl;
                this.f = m2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public List<MarkerItem> a() throws java.lang.Exception {
                Cursor cursor = androidx.room.t.c.c((j)MarkersDao_Impl.access$000(this.g), (e)this.f, (boolean)false, null);
                try {
                    int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"MarkerItemId");
                    int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"position");
                    int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"isA");
                    int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"isB");
                    int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"file");
                    int n7 = androidx.room.t.b.b((Cursor)cursor, (String)"durationUs");
                    int n8 = androidx.room.t.b.b((Cursor)cursor, (String)"name");
                    ArrayList arrayList = new ArrayList(cursor.getCount());
                    while (cursor.moveToNext()) {
                        long l2 = cursor.getLong(n2);
                        float f3 = cursor.getFloat(n3);
                        boolean bl = cursor.getInt(n4) != 0;
                        boolean bl2 = cursor.getInt(n5) != 0;
                        String string = cursor.getString(n6);
                        long l3 = cursor.getLong(n7);
                        String string2 = cursor.getString(n8);
                        MarkerItem markerItem = new MarkerItem(l2, f3, bl, bl2, string, l3, string2);
                        arrayList.add((Object)markerItem);
                    }
                    return arrayList;
                }
                finally {
                    cursor.close();
                }
            }

            protected void finalize() {
                this.f.t();
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<MarkerItem> loadAllMarkerItemsList(String string, long l2) {
        m m2 = m.i((String)"SELECT * FROM MarkerItem WHERE file = ? AND durationUs = ? ORDER BY position", (int)2);
        if (string == null) {
            m2.O(1);
        } else {
            m2.k(1, string);
        }
        m2.y(2, l2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (e)m2, (boolean)false, null);
        try {
            int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"MarkerItemId");
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"position");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"isA");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"isB");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"file");
            int n7 = androidx.room.t.b.b((Cursor)cursor, (String)"durationUs");
            int n8 = androidx.room.t.b.b((Cursor)cursor, (String)"name");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                long l3 = cursor.getLong(n2);
                float f3 = cursor.getFloat(n3);
                boolean bl = cursor.getInt(n4) != 0;
                boolean bl2 = cursor.getInt(n5) != 0;
                String string2 = cursor.getString(n6);
                long l4 = cursor.getLong(n7);
                String string3 = cursor.getString(n8);
                MarkerItem markerItem = new MarkerItem(l3, f3, bl, bl2, string2, l4, string3);
                arrayList.add((Object)markerItem);
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public /* varargs */ void updateMarkerItems(MarkerItem ... arrmarkerItem) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfMarkerItem.j((Object[])arrmarkerItem);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

