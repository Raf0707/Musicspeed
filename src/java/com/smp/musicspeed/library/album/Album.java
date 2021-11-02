/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.smp.musicspeed.library.album;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.smp.musicspeed.dbrecord.MediaTrack;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.library.album.Album;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Album
implements e,
Parcelable {
    public static final Parcelable.Creator<Album> CREATOR;
    public static final a f;
    private final long g;
    private final String h;
    private final long i;
    private final String j;
    private final int k;
    private final String l;
    private final long m;
    private final I n;

    static {
        f = new Object(null){
            {
                this();
            }

            public static /* synthetic */ List b(a a2, Cursor cursor, Context context, Map map, long l2, int n2, Object object) {
                if ((n2 & 8) != 0) {
                    l2 = -1L;
                }
                return a2.a(cursor, context, (Map<Long, ? extends List<MediaTrack>>)map, l2);
            }

            /*
             * Enabled aggressive block sorting
             */
            public final List<Album> a(Cursor cursor, Context context, Map<Long, ? extends List<MediaTrack>> map, long l2) {
                k.g((Object)cursor, "cur");
                k.g((Object)context, "context");
                k.g(map, "allSongs");
                Resources resources = context.getResources();
                ArrayList arrayList = new ArrayList(cursor.getCount());
                int n2 = cursor.getColumnIndex("album_id");
                if (n2 == -1) {
                    n2 = cursor.getColumnIndex("_id");
                }
                int n3 = cursor.getColumnIndex("album");
                int n4 = cursor.getColumnIndex("artist");
                int n5 = cursor.getColumnIndex("artist_id");
                int n6 = cursor.getColumnIndex("maxyear");
                int n7 = cursor.getColumnIndex("album_art");
                String string = resources.getString(2131821378);
                k.f(string, "res.getString(R.string.unknown_album)");
                String string2 = resources.getString(2131821379);
                k.f(string2, "res.getString(R.string.unknown_artist)");
                int n8 = cursor.getCount();
                int n9 = 0;
                if (n8 <= 0) return arrayList;
                do {
                    int n10 = n9 + 1;
                    cursor.moveToPosition(n9);
                    List list = (List)map.get((Object)cursor.getLong(n2));
                    long l3 = 0L;
                    if (list != null) {
                        Iterator iterator = list.iterator();
                        while (iterator.hasNext()) {
                            l3 += ((MediaTrack)iterator.next()).getDateModified();
                        }
                    }
                    long l4 = l3;
                    long l5 = cursor.getLong(n2);
                    String string3 = i.e(cursor.getString(n3), string);
                    String string4 = i.e(cursor.getString(n4), string2);
                    long l6 = l2 == -1L ? cursor.getLong(n5) : l2;
                    int n11 = cursor.getInt(n6);
                    String string5 = i.e(cursor.getString(n7), "");
                    Album album = new Album(l5, string3, l6, string4, n11, string5, l4);
                    arrayList.add((Object)album);
                    if (n10 >= n8) {
                        return arrayList;
                    }
                    n9 = n10;
                } while (true);
            }
        };
        CREATOR = new b();
    }

    public Album() {
        this(0L, null, 0L, null, 0, null, 0L, 127, null);
    }

    public Album(long l2, String string, long l3, String string2, int n2, String string3, long l4) {
        k.g(string, "albumName");
        k.g(string2, "artistName");
        k.g(string3, "artUri");
        this.g = l2;
        this.h = string;
        this.i = l3;
        this.j = string2;
        this.k = n2;
        this.l = string3;
        this.m = l4;
        this.n = I.b;
    }

    public /* synthetic */ Album(long l2, String string, long l3, String string2, int n2, String string3, long l4, int n3, g g2) {
        int n4 = n3 & 1;
        long l5 = 0L;
        long l6 = n4 != 0 ? l5 : l2;
        int n5 = n3 & 2;
        String string4 = "";
        String string5 = n5 != 0 ? string4 : string;
        long l7 = (n3 & 4) != 0 ? l5 : l3;
        String string6 = (n3 & 8) != 0 ? string4 : string2;
        int n6 = (n3 & 16) != 0 ? 0 : n2;
        if ((n3 & 32) == 0) {
            string4 = string3;
        }
        if ((n3 & 64) == 0) {
            l5 = l4;
        }
        this(l6, string5, l7, string6, n6, string4, l5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (object == null || !(object instanceof Album)) break block3;
                long l2 = this.g;
                Album album = (Album)object;
                if (l2 == album.g && k.c(this.h, album.h) && this.i == album.i && k.c(this.j, album.j) && this.k == album.k && k.c(this.l, album.l) && this.m == album.m) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public I getMediaType() {
        return this.n;
    }

    public final long l() {
        return this.g;
    }

    public final String m() {
        return this.h;
    }

    public final String n() {
        return this.l;
    }

    public final long o() {
        return this.i;
    }

    public final String p() {
        return this.j;
    }

    public final long q() {
        return this.m;
    }

    public final int r() {
        return this.k;
    }

    public String toString() {
        return this.h;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.g((Object)parcel, "out");
        parcel.writeLong(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeLong(this.m);
    }

}

