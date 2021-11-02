/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.database.Cursor
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.smp.musicspeed.k0.i0;

import android.content.res.Resources;
import android.database.Cursor;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.i;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.List;

public final class e
implements com.smp.musicspeed.k0.m0.e {
    public static final a f = new Object(null){
        {
            this();
        }

        public final List<e> a(Cursor cursor, Resources resources) {
            k.g((Object)cursor, "cur");
            k.g((Object)resources, "res");
            ArrayList arrayList = new ArrayList(cursor.getCount());
            int n2 = cursor.getColumnIndex("_id");
            int n3 = cursor.getColumnIndex("artist");
            int n4 = cursor.getColumnIndex("number_of_albums");
            int n5 = cursor.getColumnIndex("number_of_tracks");
            String string = resources.getString(2131821379);
            k.f(string, "res.getString(R.string.unknown_artist)");
            int n6 = cursor.getCount();
            if (n6 > 0) {
                int n7 = 0;
                do {
                    int n8 = n7 + 1;
                    cursor.moveToPosition(n7);
                    e e2 = new e(cursor.getLong(n2), i.e(cursor.getString(n3), string), cursor.getLong(n4), cursor.getLong(n5));
                    arrayList.add((Object)e2);
                    if (n8 >= n6) {
                        return arrayList;
                    }
                    n7 = n8;
                } while (true);
            }
            return arrayList;
        }
    };
    private final long g;
    private final String h;
    private final long i;
    private final long j;
    private final I k;

    public e(long l2, String string, long l3, long l4) {
        k.g(string, "artistName");
        this.g = l2;
        this.h = string;
        this.i = l3;
        this.j = l4;
        this.k = I.c;
    }

    public /* synthetic */ e(long l2, String string, long l3, long l4, int n2, g g2) {
        long l5 = (n2 & 4) != 0 ? 0L : l3;
        long l6 = (n2 & 8) != 0 ? 0L : l4;
        this(l2, string, l5, l6);
    }

    public final long a() {
        return this.g;
    }

    public final String b() {
        return this.h;
    }

    public final long c() {
        return this.i;
    }

    public final long d() {
        return this.j;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (object == null || !(object instanceof e)) break block3;
                long l2 = this.g;
                e e2 = (e)object;
                if (l2 == e2.g && k.c(this.h, e2.h) && this.i == e2.i && this.j == e2.j) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public I getMediaType() {
        return this.k;
    }

}

