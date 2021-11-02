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
 *  com.smp.musicspeed.dbrecord.PresetsDao_Impl$a
 *  com.smp.musicspeed.dbrecord.PresetsDao_Impl$b
 *  java.lang.Iterable
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
import com.smp.musicspeed.dbrecord.PresetItem;
import com.smp.musicspeed.dbrecord.PresetsDao;
import com.smp.musicspeed.dbrecord.PresetsDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class PresetsDao_Impl
implements PresetsDao {
    private final j __db;
    private final androidx.room.b<PresetItem> __deletionAdapterOfPresetItem;
    private final androidx.room.c<PresetItem> __insertionAdapterOfPresetItem;

    public PresetsDao_Impl(j j2) {
        this.__db = j2;
        this.__insertionAdapterOfPresetItem = new a(this, j2);
        this.__deletionAdapterOfPresetItem = new b(this, j2);
    }

    static /* synthetic */ j access$000(PresetsDao_Impl presetsDao_Impl) {
        return presetsDao_Impl.__db;
    }

    @Override
    public void deletePresetItems(List<PresetItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPresetItem.i(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public void deletePresetItemsWithNames(int n2, List<String> list) {
        this.__db.beginTransaction();
        try {
            PresetsDao.DefaultImpls.deletePresetItemsWithNames(this, n2, list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override
    public List<PresetItem> getPresetItems(int n2) {
        m m2 = m.i((String)"SELECT * FROM PresetItem WHERE effectId = ?", (int)1);
        m2.y(1, (long)n2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (e)m2, (boolean)false, null);
        try {
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"presetName");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"effectId");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"controlId");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"value");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add((Object)new PresetItem(cursor.getString(n3), cursor.getInt(n4), cursor.getInt(n5), cursor.getFloat(n6)));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public LiveData<List<PresetItem>> getPresetItemsObservable(int n2) {
        m m2 = m.i((String)"SELECT * FROM PresetItem WHERE effectId = ?", (int)1);
        m2.y(1, (long)n2);
        return this.__db.getInvalidationTracker().d(new String[]{"PresetItem"}, false, (Callable)new Callable<List<PresetItem>>(this, m2){
            final /* synthetic */ m f;
            final /* synthetic */ PresetsDao_Impl g;
            {
                this.g = presetsDao_Impl;
                this.f = m2;
            }

            public List<PresetItem> a() throws java.lang.Exception {
                Cursor cursor = androidx.room.t.c.c((j)PresetsDao_Impl.access$000(this.g), (e)this.f, (boolean)false, null);
                try {
                    int n2 = androidx.room.t.b.b((Cursor)cursor, (String)"presetName");
                    int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"effectId");
                    int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"controlId");
                    int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"value");
                    ArrayList arrayList = new ArrayList(cursor.getCount());
                    while (cursor.moveToNext()) {
                        arrayList.add((Object)new PresetItem(cursor.getString(n2), cursor.getInt(n3), cursor.getInt(n4), cursor.getFloat(n5)));
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

    @Override
    public List<PresetItem> getPresetItemsWithName(int n2, String string) {
        m m2 = m.i((String)"SELECT * FROM PresetItem WHERE presetName = ? AND effectId = ?", (int)2);
        if (string == null) {
            m2.O(1);
        } else {
            m2.k(1, string);
        }
        m2.y(2, (long)n2);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = androidx.room.t.c.c((j)this.__db, (e)m2, (boolean)false, null);
        try {
            int n3 = androidx.room.t.b.b((Cursor)cursor, (String)"presetName");
            int n4 = androidx.room.t.b.b((Cursor)cursor, (String)"effectId");
            int n5 = androidx.room.t.b.b((Cursor)cursor, (String)"controlId");
            int n6 = androidx.room.t.b.b((Cursor)cursor, (String)"value");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add((Object)new PresetItem(cursor.getString(n3), cursor.getInt(n4), cursor.getInt(n5), cursor.getFloat(n6)));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            m2.t();
        }
    }

    @Override
    public void insertPresetItems(List<PresetItem> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPresetItem.h(list);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

