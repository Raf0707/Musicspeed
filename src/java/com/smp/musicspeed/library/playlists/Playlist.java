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
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.smp.musicspeed.library.playlists;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.smp.musicspeed.e.g.I;
import com.smp.musicspeed.k0.m0.e;
import com.smp.musicspeed.k0.m0.i;
import com.smp.musicspeed.library.playlists.Playlist;
import f.z.d.g;
import f.z.d.k;
import java.util.ArrayList;
import java.util.List;

public class Playlist
implements e,
Parcelable {
    public static final Parcelable.Creator<Playlist> CREATOR;
    public static final a Companion;
    private final I mediaType;
    private long playlistId;
    private String playlistName;

    static {
        Companion = new Object(null){
            {
                this();
            }

            public final List<Playlist> a(Context context, Cursor cursor, Resources resources) {
                k.g((Object)context, "context");
                k.g((Object)cursor, "cur");
                k.g((Object)resources, "res");
                ArrayList arrayList = new ArrayList(cursor.getCount());
                int n2 = cursor.getColumnIndex("_id");
                int n3 = cursor.getColumnIndex("name");
                String string = resources.getString(2131821377);
                k.f(string, "res.getString(R.string.unknown)");
                int n4 = cursor.getCount();
                if (n4 > 0) {
                    int n5 = 0;
                    do {
                        int n6 = n5 + 1;
                        cursor.moveToPosition(n5);
                        Playlist playlist = new Playlist(i.e(cursor.getString(n3), string), cursor.getLong(n2), null, 4, null);
                        arrayList.add((Object)playlist);
                        if (n6 >= n4) {
                            return arrayList;
                        }
                        n5 = n6;
                    } while (true);
                }
                return arrayList;
            }
        };
        CREATOR = new b();
    }

    public Playlist(String string, long l2, I i2) {
        k.g(string, "playlistName");
        k.g((Object)i2, "mediaType");
        this.playlistName = string;
        this.playlistId = l2;
        this.mediaType = i2;
    }

    public /* synthetic */ Playlist(String string, long l2, I i2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            i2 = I.d;
        }
        this(string, l2, i2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (object == null || !(object instanceof Playlist)) break block3;
                String string = this.playlistName;
                Playlist playlist = (Playlist)object;
                if (k.c(string, playlist.playlistName) && this.playlistId == playlist.playlistId) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public I getMediaType() {
        return this.mediaType;
    }

    public final long getPlaylistId() {
        return this.playlistId;
    }

    public final String getPlaylistName() {
        return this.playlistName;
    }

    public final void setPlaylistId(long l2) {
        this.playlistId = l2;
    }

    public final void setPlaylistName(String string) {
        k.g(string, "<set-?>");
        this.playlistName = string;
    }

    public String toString() {
        return this.playlistName;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        k.g((Object)parcel, "out");
        parcel.writeString(this.playlistName);
        parcel.writeLong(this.playlistId);
        parcel.writeString(this.mediaType.name());
    }

}

